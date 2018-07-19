/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hos;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.*;
/**
 *
 * @author Selvam Stark Gk
 */
@RequestScoped
@ManagedBean(name="hos")
public class Hos_Page {
    String hos_nam,hos_area,hos_city,hos_state,hos_pin,hos_con,ss;
    long con_per=0;
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

    public void add_Hos(){
        if(hos_nam.isEmpty()){
            ss = "Hospital Name is problem";
        }
        else if(hos_area.isEmpty()){
            ss = "Hospital Area is problem";
        }
        else if(hos_city.isEmpty()){
            ss = "Hospital City is problem";
        }
        else if(hos_state.isEmpty()){
            ss = "Hospital State is problem";
        }
        else if(hos_pin.isEmpty()){
            ss = "Hospital Pincode is problem";
        }
        else if(hos_con.isEmpty()){
            ss = "Hospital Area is problem";
        }
        else if(hos_con.length() < 10 ){
        ss = "MobileNumber Shouldn't be less than 9 Digits";
    }
        else{
        try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "insert into hospital Values('"+hos_nam+"','"+hos_area+"','"+hos_city+"','"+hos_state+"','"+hos_pin+"','"+hos_con+"',"+con_per+")";
        st.executeUpdate(sql);
        ss = "New Hospital Registered";
        }
    catch(SQLException | NumberFormatException e){
        ss= ""+e;
        System.out.println(e);
        }
    catch(Exception e){
        ss= ""+e;
    }}
    }
    public void hos_Report() throws IOException{
    if(hos_nam.isEmpty()){
        ss = "Check The Hospital Name";
    }
    else{  
        try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "select * from hospital where hos_nam='"+hos_nam+"'";
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()){
           hos_nam = rs.getString(1);
           hos_area = rs.getString(2);
           hos_city = rs.getString(3);
           hos_state = rs.getString(4);
           hos_pin = rs.getString(5);
           hos_con = rs.getString(6);
           con_per = rs.getLong(7);
          
        }
       
    } 
    catch(SQLException e){
      ss = "Probelm "+e;  
    }}
    }
     public void rem_Hos(){
    
        if(hos_nam.isEmpty()){
        ss = "Check The Hospital";
    }
    else{
        try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "delete from hospital where hos_nam='"+hos_nam+"'";
        st.executeUpdate(sql);
        ss="Hospital Removed";
    }
    catch(Exception e){
        ss= "Remove Hospital: "+e;
    }}
    }
     
    public String getHos_nam() {
        return hos_nam;
    }

    public void setHos_nam(String hos_nam) {
        this.hos_nam = hos_nam;
    }

    public String getHos_area() {
        return hos_area;
    }

    public void setHos_area(String hos_area) {
        this.hos_area = hos_area;
    }

    public String getHos_city() {
        return hos_city;
    }

    public void setHos_city(String hos_city) {
        this.hos_city = hos_city;
    }

    public String getHos_state() {
        return hos_state;
    }

    public void setHos_state(String hos_state) {
        this.hos_state = hos_state;
    }

    public String getHos_pin() {
        return hos_pin;
    }

    public void setHos_pin(String hos_pin) {
        this.hos_pin = hos_pin;
    }

    public Long getCon_per() {
        return con_per;
    }

    public void setCon_per(Long con_per) {
        this.con_per = con_per;
    }

    public List<String> getHospital_list() {
        return hospital_list;
    }

    public void setHospital_list(List<String> hospital_list) {
        this.hospital_list = hospital_list;
    }

    public String getHos_con() {
        return hos_con;
    }

    public void setHos_con(String hos_con) {
        this.hos_con = hos_con;
    }

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }
  
}
