package com.karan.cafebill;

import java.io.Serializable;

public class orderlist implements Serializable {
    int price,ourprice;
    String itemname;

    public orderlist(int price, int ourprice, String itemname) {
        this.price = price;
        this.ourprice = ourprice;
        this.itemname = itemname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOurprice() {
        return ourprice;
    }

    public void setOurprice(int ourprice) {
        this.ourprice = ourprice;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }
}
