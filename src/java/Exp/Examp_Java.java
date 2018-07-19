/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exp;

/**
 *
 * @author Selvam Stark Gk
 */
public class Examp_Java {
    
    public static void main(String[] arg)
    {
        
        String lst_emp_id1 = "EMP-1001";
        String[] parts = lst_emp_id1.split("-");
        String part1 = parts[1];
        System.out.println("First Part :"+parts[1]);
        Long num= Long.parseLong(part1)+1;
        System.out.println("First Part After Increment:"+num);
        
    }
}
