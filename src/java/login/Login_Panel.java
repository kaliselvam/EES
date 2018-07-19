/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;
import java.io.IOException;
import java.sql.*;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
/**
 *@author Selvam Stark Gk
 * 
 */
@ManagedBean(name="log")
public class Login_Panel {
    
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
    public void Select() throws IOException{
    if(una.isEmpty()){
        ss = "Enter USername";
    }
    else if(pwd.isEmpty()){
        ss = "Enter Password";
    }
    else{    
        try{
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/EES");
        Statement st = con.createStatement();
        String sql = "select * from login_panel where user_nam='"+una+"'";
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()){
           if(pwd.equals(rs.getString(1)))
           {
               FacesContext.getCurrentInstance().getExternalContext().redirect("Home_Page.xhtml");   
           }
           else{
                ss="Password Is Wrong";
           }
        }
       
    } 
    catch(SQLException e){
        
    }
    }}
    
   
    
}
