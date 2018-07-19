/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emp;

/**
 *
 * @author Selvam Stark Gk
 */
public class Emp_Des {
    private String d_nam;
    private Double bp,pf,da,hra;

    public Emp_Des(String d_nam, Double bp, Double pf, Double da, Double hra) {
        this.d_nam = d_nam;
        this.bp = bp;
        this.pf = pf;
        this.da = da;
        this.hra = hra;
    }

    public String getD_nam() {
        return d_nam;
    }

    public void setD_nam(String d_nam) {
        this.d_nam = d_nam;
    }

    public Double getBp() {
        return bp;
    }

    public void setBp(Double bp) {
        this.bp = bp;
    }

    public Double getPf() {
        return pf;
    }

    public void setPf(Double pf) {
        this.pf = pf;
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
    
    
}
