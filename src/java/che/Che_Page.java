/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package che;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Selvam Stark Gk
 */
@ManagedBean(name="che")
public class Che_Page {
    String prd_nam,d_o_p,prd_exp,sup_id,prd_true,ss,pur_id,pur_true,sup_nam;
    long prd_price=0,lst_prd_id,lst_pur_id,prd_stk,pur_qty,db_prd_stk;
    String dd,dd1,mm,mm1,yyyy,yyyy1;
    private List<String> category_list1 = new ArrayList<>();
    private List<String> category_list2 = new ArrayList<>();
    private List<String> category_list3 = new ArrayList<>();
    public List<String> get_category_name(){
        try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "select * from supplier";
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            category_list1.add(rs.getString("sup_id"));
        }
        }
        catch(Exception e){
        System.out.println(e);
        }
        return category_list1;
    }
    public List<String> get_category_name1(){
        try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "select * from chemical";
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            category_list2.add(rs.getString("prd_nam"));
        }
        }
        catch(Exception e){
        System.out.println(e);
        }
        return category_list2;
    }
    public List<String> get_category_name2(){
        try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "select * from chemical";
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            category_list3.add(rs.getString("prd_nam"));
        }
        }
        catch(Exception e){
        System.out.println(e);
        }
        return category_list3;
    }
    public void new_Che() throws IOException{
                  
    }
    
    public void new_Pur(){
        String state_id = "pur001";
      try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "select * from process where tag_id='"+state_id+"'";
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()){
          lst_pur_id  = rs.getLong(3);
        }
       pur_id = "PUR-"+Long.toString(lst_pur_id);
       prd_true = "PUR-"+Long.toString(lst_pur_id);
       try{
        Statement st1 = con.createStatement();
        String sql1 = "Update process set tag_nam1='"+pur_true+"' where tag_id='pur001'";
        st1.executeUpdate(sql1);
       
    }
    catch(SQLException e){
        
    }
    } 
    catch(SQLException e){
        ss = ""+e;
    }
    }
    
    public void add_Pur(){
    
    if(pur_id.isEmpty()){
        ss = "Enter Purchase ID";
    }
    else if(prd_nam.isEmpty()){
        ss = "Select Product Name";
    }
    else if(dd.equals("dd") | mm.equals("mm") | yyyy.equals("yyyy")){
        ss = "Select Purchase Date";
    }
    else if(dd1.equals("dd") | mm1.equals("mm") | yyyy1.equals("yyyy")){
        ss = "Select Expiry Date";
    }
    else if(pur_qty == 0 ){
        ss = "Purchase Quantity";
    }
  else{
    try{
        d_o_p = mm+"/"+dd+"/"+yyyy;
        prd_exp = mm1+"/"+dd1+"/"+yyyy1;
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "insert into purchase Values('"+pur_id+"','"+prd_nam+"','"+prd_exp+"','"+d_o_p+"',"+pur_qty+")";
        st.executeUpdate(sql);
        String sql3 = "select * from chemical where prd_nam='"+prd_nam+"'";
        ResultSet rs2 = st.executeQuery(sql3);
        if(rs2.next()){
          db_prd_stk  = rs2.getLong(2);
        }
        String sql4 = "Update chemical set prd_stk="+(db_prd_stk+pur_qty)+" where prd_nam='"+prd_nam+"'";
        st.executeUpdate(sql4);
        String sql5 = "select * from process where tag_id='pur001'";
        ResultSet rs = st.executeQuery(sql5);
        if(rs.next()){
          lst_pur_id  = rs.getLong(3);
        }
        String sql1 = "Update process set tag_nam="+(lst_pur_id+1)+" where tag_id='pur001'";
        st.executeUpdate(sql1);
        ss = "New Purchase Stock Added";
    }
    catch(SQLException | NumberFormatException e){
        ss= ""+e;
        System.out.println(e);
       }}}
    public void pur_Peport(){
        if(pur_id.isEmpty()){
        ss = "Check Purchase ID";
    }
    else{
        try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "select * from purchase where pur_id='"+pur_id+"'";
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()){
           pur_id = rs.getString(1);
           prd_nam = rs.getString(2);
           prd_exp = rs.getString(3);
           d_o_p = rs.getString(4);
           pur_qty = rs.getLong(5);
           
          
        }
       
    } 
    catch(SQLException e){
        ss = ""+e;
    }}
    }
    public void rem_Pur(){
    
        if(pur_id.isEmpty()){
        ss = "Check The Purchase ID";
    }
    else{
        try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "delete from purchase where pur_id='"+pur_id+"'";
        st.executeUpdate(sql);
        ss="Purchase Removed";
    }
    catch(Exception e){
        ss= "Purchase : "+e;
    }}
    }
    public void che_Report() throws IOException{
    if(prd_nam.isEmpty()){
        ss = "Check Product Name";
    }
    else{
        try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "select * from chemical where prd_nam='"+prd_nam+"'";
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()){
           prd_nam = rs.getString(1);
           prd_stk = rs.getLong(2);
           prd_price = rs.getLong(3);
           sup_id = rs.getString(4);
        }
       String sql1 = "select * from supplier where sup_id='"+sup_id+"'";
       ResultSet rs1 = st.executeQuery(sql1);
        if(rs1.next()){
          sup_nam = rs1.getString(2);
        }
    } 
    catch(SQLException e){
        ss = ""+e;
    }}
    }
    public void rem_Che(){
    
        if(prd_nam.isEmpty()){
        ss = "Check The Product ID";
    }
    else{
        try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "delete from chemical where prd_nam='"+prd_nam+"'";
        st.executeUpdate(sql);
        ss="Product Removed";
    }
    catch(Exception e){
        ss= "Product : "+e;
    }}
    }
    public void add_Che(){
    if(prd_nam.isEmpty()){
        ss = "Enter Suplier Name";
    }
    else if(prd_price == 0){
        ss = "Enter Product Price";
    }
    else if(sup_id.isEmpty()){
        ss = "Enter Supplier ID";
    }
  else{
    try{
        
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "insert into chemical Values('"+prd_nam+"',"+prd_stk+","+prd_price+",'"+sup_id+"')";
        st.executeUpdate(sql);
        String sql3 = "select * from process where tag_id='che001'";
        ResultSet rs = st.executeQuery(sql3);
        if(rs.next()){
          lst_prd_id  = rs.getLong(3);
        }
        String sql1 = "Update process set tag_nam="+(lst_prd_id+1)+" where tag_id='che001'";
        st.executeUpdate(sql1);
        ss = "New Product Added";
    }
    catch(SQLException | NumberFormatException e){
        ss= ""+e;
        System.out.println(e);
       }}}

    public String getPrd_nam() {
        return prd_nam;
    }

    public void setPrd_nam(String prd_nam) {
        this.prd_nam = prd_nam;
    }

    public String getD_o_p() {
        return d_o_p;
    }

    public void setD_o_p(String d_o_p) {
        this.d_o_p = d_o_p;
    }

    public String getPrd_exp() {
        return prd_exp;
    }

    public void setPrd_exp(String prd_exp) {
        this.prd_exp = prd_exp;
    }

    public String getSup_id() {
        return sup_id;
    }

    public void setSup_id(String sup_id) {
        this.sup_id = sup_id;
    }

    public String getSup_nam() {
        return sup_nam;
    }

    public void setSup_nam(String sup_nam) {
        this.sup_nam = sup_nam;
    }

    public List<String> getCategory_list3() {
        return category_list3;
    }

    public void setCategory_list3(List<String> category_list3) {
        this.category_list3 = category_list3;
    }

    public String getPrd_true() {
        return prd_true;
    }

    public void setPrd_true(String prd_true) {
        this.prd_true = prd_true;
    }

    public String getDd() {
        return dd;
    }

    public void setDd(String dd) {
        this.dd = dd;
    }

    public String getDd1() {
        return dd1;
    }

    public void setDd1(String dd1) {
        this.dd1 = dd1;
    }

    public String getMm() {
        return mm;
    }

    public void setMm(String mm) {
        this.mm = mm;
    }

    public String getMm1() {
        return mm1;
    }

    public void setMm1(String mm1) {
        this.mm1 = mm1;
    }

    public String getYyyy() {
        return yyyy;
    }

    public void setYyyy(String yyyy) {
        this.yyyy = yyyy;
    }

    public String getYyyy1() {
        return yyyy1;
    }

    public void setYyyy1(String yyyy1) {
        this.yyyy1 = yyyy1;
    }

    public List<String> getCategory_list2() {
        return category_list2;
    }

    public void setCategory_list2(List<String> category_list2) {
        this.category_list2 = category_list2;
    }

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    public String getPur_id() {
        return pur_id;
    }

    public void setPur_id(String pur_id) {
        this.pur_id = pur_id;
    }

    public long getPrd_price() {
        return prd_price;
    }

    public void setPrd_price(long prd_price) {
        this.prd_price = prd_price;
    }

    public long getLst_prd_id() {
        return lst_prd_id;
    }

    public List<String> getCategory_list1() {
        return category_list1;
    }

    public void setCategory_list1(List<String> category_list1) {
        this.category_list1 = category_list1;
    }

    public void setLst_prd_id(long lst_prd_id) {
        this.lst_prd_id = lst_prd_id;
    }

    public long getPrd_stk() {
        return prd_stk;
    }

    public void setPrd_stk(long prd_stk) {
        this.prd_stk = prd_stk;
    }

    public long getPur_qty() {
        return pur_qty;
    }

    public void setPur_qty(long pur_qty) {
        this.pur_qty = pur_qty;
    }

    public String getPur_true() {
        return pur_true;
    }

    public void setPur_true(String pur_true) {
        this.pur_true = pur_true;
    }

    public long getLst_pur_id() {
        return lst_pur_id;
    }

    public void setLst_pur_id(long lst_pur_id) {
        this.lst_pur_id = lst_pur_id;
    }
    
}
