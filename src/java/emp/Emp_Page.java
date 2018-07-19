/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emp;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.*;
/**
 *
 * @author Selvam Stark Gk
 */
@ManagedBean(name="emp")

public class Emp_Page {
    String emp_id,emp_nam,d_o_b,emp_gen="none",emp_qual,emp_dno,emp_city,emp_con,d_o_j,d_nam,emp_zip;
    Double netpay,da,hra,pf,bp;
    Long zip_code,lst_pay_id;
    String user_nam,user_pass;
    String ss,lst_emp_id1,emp_true,pay_true,emp_rep;
    String dd,mm,yyyy,dd1,mm1,yyyy1,dd2,mm2,yyyy2;
    String pid,d_o_p;
    private List<String> category_list = new ArrayList<>();
    private List<String> category_list1 = new ArrayList<>();
    private List<String> category_list2 = new ArrayList<>();
    private List<String> category_list3 = new ArrayList<>();
    private List<String> category_list4 = new ArrayList<>();

    
    public Emp_Page(){
       
}

    public List<String> get_category_name(){
        try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "select * from designation";
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            category_list.add(rs.getString("d_nam"));
        }
        }
        catch(Exception e){
        System.out.println(e);
        }
        return category_list;
    }
    public List<String> get_category_name1(){
        try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "select * from designation";
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            category_list1.add(rs.getString("bp"));
        }
        }
        catch(Exception e){
        System.out.println(e);
        }
        return category_list1;
    }
    public List<String> get_category_name2(){
        try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "select * from designation";
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            category_list2.add(rs.getString("pf"));
        }
        }
        catch(Exception e){
        System.out.println(e);
        }
        return category_list2;
    }
    public List<String> get_category_name3(){
        try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "select * from designation";
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            category_list3.add(rs.getString("da"));
        }
        }
        catch(Exception e){
        System.out.println(e);
        }
        return category_list3;
    }  
    public List<String> get_category_name4(){
        try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "select * from designation";
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            category_list4.add(rs.getString("hra"));
        }
        }
        catch(Exception e){
        System.out.println(e);
        }
        return category_list4;
    } 
    public List<String> getCategory_list() {
        return category_list;
    }

    public List<String> getCategory_list1() {
        return category_list1;
    }

    public void setCategory_list1(List<String> category_list1) {
        this.category_list1 = category_list1;
    }

    public List<String> getCategory_list2() {
        return category_list2;
    }

    public void setCategory_list2(List<String> category_list2) {
        this.category_list2 = category_list2;
    }

    public List<String> getCategory_list3() {
        return category_list3;
    }

    public void setCategory_list3(List<String> category_list3) {
        this.category_list3 = category_list3;
    }

    public List<String> getCategory_list4() {
        return category_list4;
    }

    public String getDd2() {
        return dd2;
    }

    public void setDd2(String dd2) {
        this.dd2 = dd2;
    }

    public String getMm2() {
        return mm2;
    }

    public void setMm2(String mm2) {
        this.mm2 = mm2;
    }

    public String getYyyy2() {
        return yyyy2;
    }

    public void setYyyy2(String yyyy2) {
        this.yyyy2 = yyyy2;
    }

    public void setCategory_list4(List<String> category_list4) {
        this.category_list4 = category_list4;
    }

    public void setCategory_list(List<String> category_list) {
        this.category_list = category_list;
    }

    public String getD_nam() {
        return d_nam;
    }

    public void setD_nam(String d_nam) {
        this.d_nam = d_nam;
    }

    public String getUser_nam() {
        return user_nam;
    }

    public void setUser_nam(String user_nam) {
        this.user_nam = user_nam;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }
    
    public String getEmp_con() {
        return emp_con;
    }

    public void setEmp_con(String emp_con) {
        this.emp_con = emp_con;
    }

    public String getD_o_j() {
        return d_o_j;
    }

    public void setD_o_j(String d_o_j) {
        this.d_o_j = d_o_j;
    }

    public String getD_o_b() {
        return d_o_b;
    }

    public void setD_o_b(String d_o_b) {
        this.d_o_b = d_o_b;
    }

    public String getEmp_zip() {
        return emp_zip;
    }

    public void setEmp_zip(String emp_zip) {
        this.emp_zip = emp_zip;
    }

    public String getEmp_qual() {
        return emp_qual;
    }

    public void setEmp_qual(String emp_qual) {
        this.emp_qual = emp_qual;
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

    public String getDd1() {
        return dd1;
    }

    public void setDd1(String dd1) {
        this.dd1 = dd1;
    }

    public String getMm1() {
        return mm1;
    }

    public void setMm1(String mm1) {
        this.mm1 = mm1;
    }

    public String getYyyy1() {
        return yyyy1;
    }

    public void setYyyy1(String yyyy1) {
        this.yyyy1 = yyyy1;
    }

    public String getEmp_dno() {
        return emp_dno;
    }

    public void setEmp_dno(String emp_dno) {
        this.emp_dno = emp_dno;
    }

    public String getEmp_city() {
        return emp_city;
    }

    public void setEmp_city(String emp_city) {
        this.emp_city = emp_city;
    }

    public Double getBp() {
        return bp;
    }

    public void setBp(Double bp) {
        this.bp = bp;
    }

     public String getEmp_true() {
        return emp_true;
    }

    public void setEmp_true(String emp_true) {
        this.emp_true = emp_true;
    }

    public String getEmp_rep() {
        return emp_rep;
    }

    public void setEmp_rep(String emp_rep) {
        this.emp_rep = emp_rep;
    }
    

    public Long getZip_code() {
        return zip_code;
    }

    public void setZip_code(Long zip_code) {
        this.zip_code = zip_code;
    }

       
    long lst_emp_id;

    public String getLst_emp_id1() {
        return lst_emp_id1;
    }

    public void setLst_emp_id1(String lst_emp_id1) {
        this.lst_emp_id1 = lst_emp_id1;
    }

    public long getLst_emp_id() {
        return lst_emp_id;
    }

    public void setLst_emp_id(long lst_emp_id) {
        this.lst_emp_id = lst_emp_id;
    }
    public String getEmp_gen() {
        return emp_gen;
    }

    public void setEmp_gen(String emp_gen) {
        this.emp_gen = emp_gen;
    }

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }
    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_nam() {
        return emp_nam;
    }

    public void setEmp_nam(String emp_nam) {
        this.emp_nam = emp_nam;
    }

    public Double getNetpay() {
        return netpay;
    }

    public void setNetpay(Double netpay) {
        this.netpay = netpay;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getD_o_p() {
        return d_o_p;
    }

    public void setD_o_p(String d_o_p) {
        this.d_o_p = d_o_p;
    }
    

    public Double getDa() {
        return da;
    }

    public void setDa(Double da) {
        this.da = da;
    }


    public Double getHra() {
        return hra;
    }

    public void setHra(Double hra) {
        this.hra = hra;
    }

    public Double getPf() {
        return pf;
    }

    public void setPf(Double pf) {
        this.pf = pf;
    }
   
    public void exm_prg(){
    ss = "emp_prg";
    }
    public void pay_Report(){
       if(pid.isEmpty()){
       ss="Pay ID is Manditory";
       }
       else{
        try {
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "select * from payslip where pid='"+pid+"'";
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()){
           pid = rs.getString(1);
           emp_id = rs.getString(2);
           netpay = rs.getDouble(3);
           d_o_p = rs.getString(4);
           
        }
        String sql1 = "select * from employee where emp_id='"+emp_id+"'";
        ResultSet rs1 = st.executeQuery(sql1);
        if(rs1.next()){
           emp_nam = rs1.getString(2);
        }
           }
           catch(Exception e){
               ss = "Problem Is"+e;
           }
       }
    }
    public void add_Emp(){
    
    if(emp_nam.isEmpty()){
       ss="Name is problem";
    }
    else if(emp_con.isEmpty()){
        ss="Enter Mobile Number";
    }
    else if(emp_con.length() < 10 ){
        ss = "MobileNumber Shouldn't be less than 9 Digits";
    }
    else if(d_nam.equals("Designation")){
        ss="Designation is problem";
    }
    else if(emp_qual.isEmpty()){
        ss="Enter Qualification";
    }
    
    else if(emp_dno.isEmpty()){
        ss="Address is Problem";
    }
    else if(emp_city.isEmpty()){
        ss="City is Problem";
    }
    else if(emp_zip.isEmpty()){
        ss="ZipCode is Problem";
    }
    else if(dd.equals("dd") | mm.equals("mm") | yyyy.equals("yyyy")){
      ss= "Date of Birth is not selected";
    }
    else if(dd1.equals("dd") | mm1.equals("mm") | yyyy1.equals("yyyy")){
        ss= "Date of Joining is not selected";
    }
    else if(user_nam.isEmpty()){
        ss="Enter UserName";
    }
    else if(user_pass.isEmpty()){
        ss="Enter Password";
    }
    else{
      try{
        d_o_b = mm+"/"+dd+"/"+yyyy;
        d_o_j = mm1+"/"+dd1+"/"+yyyy1;
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "insert into employee Values('"+emp_id+"','"+emp_nam+"','"+d_o_b+"','"+emp_gen+"','"+emp_qual+"','"+emp_dno+"','"+emp_city+"','"+emp_con+"','"+d_o_j+"','"+d_nam+"','"+emp_zip+"')";
        st.executeUpdate(sql);
        String sql3 = "select * from process where tag_id='emp001'";
        ResultSet rs = st.executeQuery(sql3);
        if(rs.next()){
          lst_emp_id  = rs.getLong(3);
           }
        String sql1 = "Update process set tag_nam="+(lst_emp_id+1)+" where tag_id='emp001'";
        st.executeUpdate(sql1);
        String sql2 = "insert into login_panel Values('"+user_nam+"','"+user_pass+"')";
        st.executeUpdate(sql2);
        ss = "Employee Appointed Success";
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

    public void cal_Net(){
        if(emp_id.isEmpty()){
            ss = "Employee ID is Manditory";
        }
        else{
        try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "select * from employee where emp_id='"+emp_id+"'";
        ResultSet rs = st.executeQuery(sql);
        if(rs.next())
        {
          d_nam  = rs.getString(10);
        } 
        String sql1 = "select * from designation where d_nam='"+d_nam+"'";
        ResultSet rs1 = st.executeQuery(sql1);
        if(rs1.next())
        {
          bp  = rs1.getDouble(2);
          pf  = rs1.getDouble(3);
          da  = rs1.getDouble(4);
          hra  = rs1.getDouble(5);
          netpay = bp+hra+da-pf;
        } 
            }
            catch(Exception e){
                ss = "Problem is"+e;
            }
        }
    }
    public boolean new_Emp(){
        
      String state_id = "emp001";
         
    try {
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "select * from process where tag_id='"+state_id+"'";
        ResultSet rs = st.executeQuery(sql);
        if(rs.next())
        {
          lst_emp_id  = rs.getLong(3);
        }
       emp_id = "EMP-"+Long.toString(lst_emp_id);
       emp_true = "EMP-"+Long.toString(lst_emp_id);
       Statement st1 = con.createStatement();
       String sql1 = "Update process set tag_nam1='"+emp_true+"' where tag_id='emp001'";
       st1.executeUpdate(sql1);
        }
    catch(Exception e){
        ss = "Problem d"+e;
    }
         return true;
        } 
     
    public void emp_Report() throws IOException{
    if(emp_id.isEmpty()){
        ss = "Check The Employee ID";
    }
    else{  try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "select * from employee where emp_id='"+emp_id+"'";
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()){
           emp_id = rs.getString(1);
           emp_nam = rs.getString(2);
           d_o_b = rs.getString(3);
           emp_gen = rs.getString(4);
           emp_qual = rs.getString(5);
           emp_dno = rs.getString(6);
           emp_city = rs.getString(7);
           emp_con = rs.getString(8);
           d_o_j = rs.getString(9);
           d_nam = rs.getString(10);
           emp_zip = rs.getString(11);
        }
       
    } 
    catch(SQLException e){
      emp_rep= "Probelm2"+e;  
    }}
    }
    
    public void add_Design(){
    
    if(d_nam.isEmpty()){
        ss = "Check The Employye Designation";
    }
    else if(bp == null){
        ss = "Check The Basicpay";
    }
    else if(pf == null){
        ss = "Check The PF";
    }
    else if(da == null){
        ss = "Check The DA";
    }
    else if(hra == null){
        ss = "Check The HRA";
    }
    else{    
        try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "insert into designation Values('"+d_nam+"',"+bp+","+pf+","+da+","+hra+")";
        st.executeUpdate(sql);
        
        ss = "New Designation Added";
       } 
       catch(Exception e){
           ss= "Add Designation: "+e;

       }}
    }
    public void rem_Design(){
    
        if(d_nam.isEmpty()){
        ss = "Check The Employye Designation";
    }
    else{
        try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "delete from designation where d_nam='"+d_nam+"'";
        st.executeUpdate(sql);
        ss="Designation Removed";
    }
    catch(Exception e){
        ss= "Remove Designation: "+e;
    }}
    }
    public void rem_Emp(){
    
        if(emp_id.isEmpty()){
        ss = "Check The Employye Id";
    }
    else{
        try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "delete from employee where emp_id='"+emp_id+"'";
        st.executeUpdate(sql);
        ss="Employee Removed";
    }
    catch(Exception e){
        ss= "Employee Account: "+e;
    }}
    }
    public void reg_Pay(){
      if(pid.isEmpty()){
          ss = "Check The Payment ID";
      }
      else if(emp_id.isEmpty()){
          ss = "Check The Employee ID";
      } 
       else if(netpay == null){
          ss = "Check The Netpay";
      }
     else if(dd2.equals("dd") | mm2.equals("mm") | yyyy2.equals("yyyy")){
      ss= "Date of Pay is not selected";
    }       
     else{          
       d_o_p = mm2+"/"+dd2+"/"+yyyy2;
        try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "insert into payslip Values('"+pid+"','"+emp_id+"',"+netpay+",'"+d_o_p+"')";
        st.executeUpdate(sql);
        String sql3 = "select * from process where tag_id='pay001'";
        ResultSet rs = st.executeQuery(sql3);
        if(rs.next()){
          lst_pay_id  = rs.getLong(3);
           }
        String sql1 = "Update process set tag_nam="+(lst_pay_id+1)+" where tag_id='pay001'";
        st.executeUpdate(sql1);
        ss = "Payment Registered";
       } 
       catch(Exception e){
           ss= "Payment Problem : "+e;

       }}
    }
     public void rem_Pay(){
      if(pid.isEmpty()){
          ss = "Check The Payment ID";
      } 
      else{ 
      try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
         String sql = "delete from payslip where pid='"+pid+"'";
        st.executeUpdate(sql);
        ss = "Payment Removed";
       } 
       catch(Exception e){
           ss= "Payment Problem : "+e;

       }}
    }
    public void new_Pay(){
    String state_id = "pay001";
         
    try {
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "select * from process where tag_id='"+state_id+"'";
        ResultSet rs = st.executeQuery(sql);
        if(rs.next())
        {
          lst_pay_id  = rs.getLong(3);
        }
       pid = "PAY-"+Long.toString(lst_pay_id);
       pay_true = "PAY-"+Long.toString(lst_pay_id);
       Statement st1 = con.createStatement();
       String sql1 = "Update process set tag_nam1='"+emp_true+"' where tag_id='pay001'";
       st1.executeUpdate(sql1);
        }
    catch(Exception e){
        ss = "Problem d"+e;
    }
        
}
}
