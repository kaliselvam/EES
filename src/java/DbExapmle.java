
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Selvam Stark Gk
 */
import java.sql.*;
import javax.faces.bean.*;
/**
 *
 * @author Selvam Stark Gk
 */
@ManagedBean(name="DbExam")
public class DbExapmle {
    
    String una,pwd,ss;

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    public String getUna() {
        return una;
    }

    public void setUna(String una) {
        this.una = una;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public void Insert(){
    try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "insert into login_panel Values('"+una+"','"+"pwd"+"')";
        st.executeUpdate(sql);
        ss="Inserted";
    }
    catch(SQLException e){
        
    }
    }
    public void Update(){
    try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "Update login_panel set user_pass='"+pwd+"' where user_nam='"+una+"'";
        st.executeUpdate(sql);
        ss="Updated";
    }
    catch(SQLException e){
        
    }
    }
    public void Delete(){
    try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "delete from login_panel where user_nam='"+una+"'";
        st.executeUpdate(sql);
        ss="Deleted";
    }
    catch(SQLException e){
        
    }
    }
    public void Select(){
    try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "select * from login_panel where user_nam='"+una+"'";
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()){
            pwd = rs.getString(1);
        }
        ss="Deleted";
    }
    catch(SQLException e){
        
    }
    }

}