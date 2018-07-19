/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pat;

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
@ManagedBean(name="pat")
public class Pat_Page {
    String pid,hos_nam,p_nam,d_o_b,pat_gen,pat_bg,pat_dno,pat_city,pat_pin,pat_con;
    String dd,mm,yyyy,ss,pat_true;
    Long lst_pat_id,con_per;
    private List<String> hospital_list = new ArrayList<>();
    public List<String> get_hospital_name(){
        try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "select * from hospital";
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            hospital_list.add(rs.getString("hos_nam"));
        }
        }
        catch(Exception e){
        System.out.println(e);
        }
        return hospital_list;
    }

    public String getPat_true() {
        return pat_true;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getHos_nam() {
        return hos_nam;
    }

    public void setHos_nam(String hos_nam) {
        this.hos_nam = hos_nam;
    }

    public String getP_nam() {
        return p_nam;
    }

    public void setP_nam(String p_nam) {
        this.p_nam = p_nam;
    }

    public String getD_o_b() {
        return d_o_b;
    }

    public void setD_o_b(String d_o_b) {
        this.d_o_b = d_o_b;
    }

    public String getPat_bg() {
        return pat_bg;
    }

    public void setPat_bg(String pat_bg) {
        this.pat_bg = pat_bg;
    }

    public String getPat_dno() {
        return pat_dno;
    }

    public void setPat_dno(String pat_dno) {
        this.pat_dno = pat_dno;
    }

    public String getPat_city() {
        return pat_city;
    }

    public void setPat_city(String pat_city) {
        this.pat_city = pat_city;
    }

    public String getPat_pin() {
        return pat_pin;
    }

    public void setPat_pin(String pat_pin) {
        this.pat_pin = pat_pin;
    }

    public Long getCon_per() {
        return con_per;
    }

    public void setCon_per(Long con_per) {
        this.con_per = con_per;
    }

    public void setPat_true(String pat_true) {
        this.pat_true = pat_true;
    }
    public Long getLst_pat_id() {
        return lst_pat_id;
    }

    public void setLst_pat_id(Long lst_pat_id) {
        this.lst_pat_id = lst_pat_id;
    }

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    public String getPat_con() {
        return pat_con;
    }

    public void setPat_con(String pat_con) {
        this.pat_con = pat_con;
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

    public String getPat_gen() {
        return pat_gen;
    }

    public void setPat_gen(String pat_gen) {
        this.pat_gen = pat_gen;
    }

    
    public void add_pat(){
    if(pid.isEmpty()){
        ss = "Enter Patient ID";
    }
    else if(hos_nam.isEmpty()){
        ss = "Enter Hospital Name";
    }
    else if(p_nam.isEmpty()){
        ss = "Enter Patient Name";
    }
    else if(dd.equals("dd") | mm.equals("mm") | yyyy.equals("yyyy")){
        ss = "Enter Date Of Birth";
    }
    else if(pat_gen.isEmpty()){
        ss = "Enter Patient Gender";
    }
    else if(pat_bg.isEmpty()){
        ss = "Enter Patient Blood Group";
    }
    else if(pat_dno.isEmpty()){
        ss = "Enter Patient Door Number";
    }
    else if(pat_city.isEmpty()){
        ss = "Enter Patient Door Number";
    }
    else if(pat_pin.isEmpty()){
        ss = "Enter Patient Pincode";
    }
    else if(pat_con.isEmpty()){
        ss = "Enter Patient contact";
    }
    else if(pat_con.length() < 10 ){
        ss = "MobileNumber Shouldn't be less than 9 Digits";
    }
    else{
    try{
        
        d_o_b = mm+"/"+dd+"/"+yyyy;
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "insert into patient Values('"+pid+"','"+hos_nam+"','"+p_nam+"','"+d_o_b+"','"+pat_gen+"','"+pat_bg+"','"+pat_dno+"','"+pat_city+"','"+pat_pin+"','"+pat_con+"')";
        st.executeUpdate(sql);
        String sql3 = "select * from process where tag_id='pat001'";
        ResultSet rs = st.executeQuery(sql3);
        if(rs.next()){
          lst_pat_id  = rs.getLong(3);
        }
        String sql1 = "Update process set tag_nam="+(lst_pat_id+1)+" where tag_id='pat001'";
        st.executeUpdate(sql1);
        String sql2 = "select * from hospital where hos_nam='"+hos_nam+"' ";
        ResultSet rs1 = st.executeQuery(sql2);
        if(rs1.next()){
          con_per  = rs1.getLong(7);
        }
        String sql5 = "Update hospital set con_per ="+(con_per+1)+" where hos_nam='"+hos_nam+"'";
        st.executeUpdate(sql5);
        ss = "New Patient Appointed";
    }
    catch(SQLException | NumberFormatException e){
        ss= ""+e;
        System.out.println(e);
       }}
        

    }
    
    public void new_Pat() throws IOException{
                
      String state_id = "pat001";
      try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "select * from process where tag_id='"+state_id+"'";
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()){
          lst_pat_id  = rs.getLong(3);
        }
       pid = "PAT-"+Long.toString(lst_pat_id);
       pat_true = "PAT-"+Long.toString(lst_pat_id);
       try{
        Statement st1 = con.createStatement();
        String sql1 = "Update process set tag_nam1='"+pat_true+"' where tag_id='pat001'";
        st1.executeUpdate(sql1);
       
    }
    catch(SQLException e){
        
    }
    } 
    catch(SQLException e){
        ss = ""+e;
    }
        }
    public void pat_Report() throws IOException{
    if(pid.isEmpty()){
        ss = "Check Patient ID";
    }
    else{
        try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "select * from patient where pid='"+pid+"'";
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()){
           pid = rs.getString(1);
           hos_nam = rs.getString(2);
           p_nam = rs.getString(3);
           d_o_b = rs.getString(4);
           pat_gen = rs.getString(5);
           pat_bg = rs.getString(6);
           pat_dno = rs.getString(7);
           pat_city = rs.getString(8);
           pat_pin = rs.getString(9);
           pat_con = rs.getString(10);
          
        }
       
    } 
    catch(SQLException e){
        ss = ""+e;
    }}
    }
    public void rem_Pat(){
    
        if(pid.isEmpty()){
        ss = "Check The Patient ID";
    }
    else{
        try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "delete from patient where pid='"+pid+"'";
        st.executeUpdate(sql);
        ss="Patient Removed";
    }
    catch(Exception e){
        ss= "Patient : "+e;
    }}
    }
    }
