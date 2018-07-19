/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sup;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Selvam Stark Gk
 */
@ManagedBean(name="sup")
public class Sup_Page {
    String sup_id,sup_nam,sup_company,sup_con,ss,sup_true;
    Long lst_sup_id;
    
    public void new_Sup() throws IOException{
                
      String state_id = "sup001";
      try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "select * from process where tag_id='"+state_id+"'";
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()){
          lst_sup_id  = rs.getLong(3);
        }
       sup_id = "SUP-"+Long.toString(lst_sup_id);
       sup_true = "SUP-"+Long.toString(lst_sup_id);
       try{
        Statement st1 = con.createStatement();
        String sql1 = "Update process set tag_nam1='"+sup_true+"' where tag_id='sup001'";
        st1.executeUpdate(sql1);
       
    }
    catch(SQLException e){
        
    }
    } 
    catch(SQLException e){
        ss = ""+e;
    }
        }
    public void sup_Report() throws IOException{
    if(sup_id.isEmpty()){
        ss = "Check Supplier ID";
    }
    else{
        try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "select * from supplier where sup_id='"+sup_id+"'";
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()){
           sup_id = rs.getString(1);
           sup_nam = rs.getString(2);
           sup_company = rs.getString(3);
           sup_con = rs.getString(4);
        }
       
    } 
    catch(SQLException e){
        ss = ""+e;
    }}
    }
public void add_Sup(){
    if(sup_id.isEmpty()){
        ss = "Enter Suplier ID";
    }
    else if(sup_nam.isEmpty()){
        ss = "Enter Supplier Name";
    }
    else if(sup_company.isEmpty()){
        ss = "Enter Suplier Company";
    }
    else if(sup_con.isEmpty()){
        ss = "Enter Supplier ContactNumber";
    }
    else if(sup_con.length() < 10 ){
        ss = "MobileNumber Shouldn't be less than 9 Digits";
    }
  else{
    try{
        
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "insert into supplier Values('"+sup_id+"','"+sup_nam+"','"+sup_company+"','"+sup_con+"')";
        st.executeUpdate(sql);
        String sql3 = "select * from process where tag_id='sup001'";
        ResultSet rs = st.executeQuery(sql3);
        if(rs.next()){
          lst_sup_id  = rs.getLong(3);
        }
        String sql1 = "Update process set tag_nam="+(lst_sup_id+1)+" where tag_id='sup001'";
        st.executeUpdate(sql1);
        ss = "New Supplier Added";
    }
    catch(SQLException | NumberFormatException e){
        ss= ""+e;
        System.out.println(e);
       }}}
   public void rem_Sup(){
    
        if(sup_id.isEmpty()){
        ss = "Check The Supplier ID";
    }
    else{
        try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "delete from supplier where sup_id='"+sup_id+"'";
        st.executeUpdate(sql);
        ss="Supllier Removed";
    }
    catch(Exception e){
        ss= "Supllier : "+e;
    }}
    }   

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    public String getSup_true() {
        return sup_true;
    }

    public void setSup_true(String sup_true) {
        this.sup_true = sup_true;
    }

    public Long getLst_sup_id() {
        return lst_sup_id;
    }

    public void setLst_sup_id(Long lst_sup_id) {
        this.lst_sup_id = lst_sup_id;
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

    public String getSup_company() {
        return sup_company;
    }

    public void setSup_company(String sup_company) {
        this.sup_company = sup_company;
    }

    public String getSup_con() {
        return sup_con;
    }

    public void setSup_con(String sup_con) {
        this.sup_con = sup_con;
    }
    
}
