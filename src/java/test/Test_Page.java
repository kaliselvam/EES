/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.*;
/**
 *
 * @author Selvam Stark Gk
 */
@ManagedBean(name="test")
public class Test_Page {
    String t_id,pid,t_nam,t_date,tv_id,value,range,t_value,normal,t_true,tv_true,ss,dd,mm,yyyy,p_nam,pat_bg;
    Long amtpaid,amt,lst_t_id,lst_tv_id;
    private List<String> test_list = new ArrayList<>();

    public String getT_id() {
        return t_id;
    }

    public String getT_true() {
        return t_true;
    }

    public void setT_true(String t_true) {
        this.t_true = t_true;
    }

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    public Long getLst_t_id() {
        return lst_t_id;
    }

    public String getTv_true() {
        return tv_true;
    }

    public void setTv_true(String tv_true) {
        this.tv_true = tv_true;
    }

    public String getP_nam() {
        return p_nam;
    }

    public void setP_nam(String p_nam) {
        this.p_nam = p_nam;
    }

    public Long getLst_tv_id() {
        return lst_tv_id;
    }

    public void setLst_tv_id(Long lst_tv_id) {
        this.lst_tv_id = lst_tv_id;
    }

    public void setLst_t_id(Long lst_t_id) {
        this.lst_t_id = lst_t_id;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getT_nam() {
        return t_nam;
    }

    public void setT_nam(String t_nam) {
        this.t_nam = t_nam;
    }

    public String getT_date() {
        return t_date;
    }

    public void setT_date(String t_date) {
        this.t_date = t_date;
    }

    public String getTv_id() {
        return tv_id;
    }

    public void setTv_id(String tv_id) {
        this.tv_id = tv_id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getT_value() {
        return t_value;
    }

    public void setT_value(String t_value) {
        this.t_value = t_value;
    }

    public String getNormal() {
        return normal;
    }

    public String getDd() {
        return dd;
    }

    public void setDd(String dd) {
        this.dd = dd;
    }

    public String getMm() {
        return mm;
    }

    public void setMm(String mm) {
        this.mm = mm;
    }

    public String getYyyy() {
        return yyyy;
    }

    public void setYyyy(String yyyy) {
        this.yyyy = yyyy;
    }

    public List<String> getTest_list() {
        return test_list;
    }

    public void setTest_list(List<String> test_list) {
        this.test_list = test_list;
    }

    public void setNormal(String normal) {
        this.normal = normal;
    }

    public Long getAmtpaid() {
        return amtpaid;
    }

    public void setAmtpaid(Long amtpaid) {
        this.amtpaid = amtpaid;
    }

    public Long getAmt() {
        return amt;
    }

    public void setAmt(Long amt) {
        this.amt = amt;
    }
    public void new_Test(){
           
    String state_id = "tes001";
    try {
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "select * from process where tag_id='"+state_id+"'";
        ResultSet rs = st.executeQuery(sql);
        if(rs.next())
        {
          lst_t_id  = rs.getLong(3);
        }
        
        
       t_id = "TES-"+Long.toString(lst_t_id);
       t_true = "TES-"+Long.toString(lst_t_id);
       
       String sql2 = "Update process set tag_nam1='"+t_true+"' where tag_id='tes001'";
       st.executeUpdate(sql2);
        }
    catch(Exception e){
        ss = "Problem d"+e;
    }
    }
    
    public void reg_Test(){
          
    if(t_nam.isEmpty()){
        ss="TestName is Manditory";
    }
    else if(t_value.isEmpty()){
        ss="Test Value is Manditory";
    }
    else if(normal.isEmpty()){
        ss="Normal Value is Manditory";
    }
    else if(amt == null){
        ss="Amount is Manditory";
    }
    else{
      try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "insert into test_value Values('"+t_nam+"','"+t_value+"','"+normal+"')";
        st.executeUpdate(sql);
        String sql2 = "insert into test_amt Values('"+t_nam+"',"+amt+")";
        st.executeUpdate(sql2);
        ss = "New Testing Is Added";
        }
    catch(SQLException | NumberFormatException e){
        ss= ""+e;
        System.out.println(e);
        }
    catch(Exception e){
        ss= ""+e;
          }   
        }
        }
    public void test_Report(){
        if(t_nam.isEmpty()){
        ss = "Check The Test Name";
    }
    else{  
            try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "select * from test_value where t_nam='"+t_nam+"'";
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()){
           t_nam = rs.getString(1);
           t_value = rs.getString(2);
           normal = rs.getString(3);
           }
        String sql1 = "select * from test_amt where t_nam='"+t_nam+"'";
        ResultSet rs1 = st.executeQuery(sql1);
        if(rs1.next()){
           amt = rs1.getLong(2);
           }
        ss = "Data Collected Successfully";
       
    } 
    catch(SQLException e){
      ss = "Report Error : "+e;  
    }}
    }
    public void rem_Test(){
    
        if(t_nam.isEmpty()){
        ss = "Check The Test Name";
    }
    else{
        try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "delete from test_value where t_nam='"+t_nam+"'";
        st.executeUpdate(sql);
        String sql1 = "delete from test_amt where t_nam='"+t_nam+"'";
        st.executeUpdate(sql1);
        ss="Test Removed";
    }
    catch(Exception e){
        ss= "Employee Account: "+e;
    }}
    }
    public List<String> get_test_name(){
        try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "select * from test_value";
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            test_list.add(rs.getString("t_nam"));
        }
        }
        catch(Exception e){
        System.out.println(e);
        }
        return test_list;
    }
    public void reg_PatTest(){
    if(t_id.isEmpty()){
        ss="Check Test ID";
    }          
    else if(t_nam.isEmpty()){
        ss="TestName is Manditory";
    }
    else if(dd.equals("dd") | mm.equals("mm") | yyyy.equals("yyyy")){
        ss="Test Date is Manditory";
    }
    else if(amtpaid == null){
        ss="Paid Amount is Manditory";
    }
    else if(value.isEmpty()){
        ss="Value is Manditory";
    }
    else if(range.isEmpty()){
        ss="Range is Manditory";
    }
    else{
        t_date = mm+"/"+dd+"/"+yyyy;
      try{
        String state_id1 = "val001";
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql11 = "select * from process where tag_id='"+state_id1+"'";
        ResultSet rs11 = st.executeQuery(sql11);
        if(rs11.next())
        {
          lst_tv_id  = rs11.getLong(3);
        }
        tv_id = "VAL-"+Long.toString(lst_tv_id);
        tv_true = "VAL-"+Long.toString(lst_tv_id);
        String sql13 = "Update process set tag_nam1='"+tv_true+"' where tag_id='val001'";
        st.executeUpdate(sql13);
        
        String sql = "insert into pat_test Values('"+t_id+"','"+t_nam+"','"+t_date+"',"+amtpaid+",'"+pid+"')";
        st.executeUpdate(sql);
        String sql3 = "select * from process where tag_id='tes001'";
        ResultSet rs = st.executeQuery(sql3);
        if(rs.next()){
          lst_t_id  = rs.getLong(3);
           }
        String sql1 = "Update process set tag_nam="+(lst_t_id+1)+" where tag_id='tes001'";
        st.executeUpdate(sql1);
        
        String sql2 = "insert into pat_test_value Values('"+tv_id+"','"+value+"','"+range+"')";
        st.executeUpdate(sql2);
        String sql4 = "select * from process where tag_id='val001'";
        ResultSet rs1 = st.executeQuery(sql4);
        if(rs1.next()){
          lst_tv_id  = rs1.getLong(3);
           }
        String sql5 = "Update process set tag_nam="+(lst_tv_id+1)+" where tag_id='val001'";
        st.executeUpdate(sql5);
        
        String sql10 = "insert into ptpv Values('"+t_id+"','"+tv_id+"')";
        st.executeUpdate(sql10);
        ss = "Patient Test Record Added";
        }
    catch(SQLException | NumberFormatException e){
        ss= ""+e;
        System.out.println(e);
        }
    catch(Exception e){
        ss= ""+e;
          }   
        }
     }
    public void testPat_Report() throws IOException{
    if(t_id.isEmpty()){
        ss = "Check The Test ID";
    }
    else{  
        try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "select * from pat_test where t_id='"+t_id+"'";
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()){
           t_id = rs.getString(1);
           t_nam = rs.getString(2);
           t_date = rs.getString(3);
           amtpaid = rs.getLong(4);
           pid = rs.getString(5);
        }
       String sql1 = "select * from ptpv where t_id='"+t_id+"'";
       ResultSet rs1 = st.executeQuery(sql1);
       if(rs1.next()){
           tv_id = rs1.getString(2);
           }
       String sql2 = "select * from test_amt where t_nam='"+t_nam+"'";
       ResultSet rs2 = st.executeQuery(sql2);
       if(rs2.next()){
           amt = rs2.getLong(2);
           }
       String sql3 = "select * from pat_test_value where tv_id='"+tv_id+"'";
       ResultSet rs3 = st.executeQuery(sql3);
       if(rs3.next()){
           value = rs3.getString(2);
           range = rs3.getString(3);
           }
       String sql4 = "select * from test_value where t_nam='"+t_nam+"'";
       ResultSet rs4 = st.executeQuery(sql4);
       if(rs4.next()){
           t_value = rs4.getString(2);
           normal = rs4.getString(3);
           }
       String sql5 = "select * from patient where pid='"+pid+"'";
       ResultSet rs5 = st.executeQuery(sql5);
       if(rs5.next()){
           p_nam = rs5.getString(3);
           pat_bg = rs5.getString(6);
           }
       ss="Data Gathered Successfully";
    }
    catch(SQLException e){
      ss= "Error in Report : "+e;  
    }}
    }
    }

