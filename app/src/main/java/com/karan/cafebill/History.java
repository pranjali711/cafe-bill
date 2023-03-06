package com.karan.cafebill;

import java.io.Serializable;

public class History implements Serializable {
    String Totalamount;
    String Ouramount;
    String orderno;

    public History() {
    }

    public History(String totalamount, String ouramount, String orderno) {
        Totalamount = totalamount;
        Ouramount = ouramount;
        this.orderno = orderno;
    }

    public String getTotalamount() {
        return Totalamount;
    }

    public void setTotalamount(String totalamount) {
        Totalamount = totalamount;
    }

    public String getOuramount() {
        return Ouramount;
    }

    public void setOuramount(String ouramount) {
        Ouramount = ouramount;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }
}
