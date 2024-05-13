package com.homerunball.order.domain;

public class OrdAndStkDto {

    private String pd_name;
    private int sls_prc;
    private int cart_cnt;
    private int c_id;

    int totalPrice=0;
    public OrdAndStkDto() {
    }

    public OrdAndStkDto(String pd_name, int sls_prc, int cart_cnt, int c_id) {
        this.pd_name = pd_name;
        this.sls_prc = sls_prc;
        this.cart_cnt = cart_cnt;
        this.c_id = c_id;
    }


    @Override
    public String toString() {
        return "OrdAndStkDto{" +
                "pd_name='" + pd_name + '\'' +
                ", sls_prc=" + sls_prc +
                ", cart_cnt=" + cart_cnt +
                ", c_id=" + c_id +
                '}';
    }

    public String getPd_name() {
        return pd_name;
    }

    public void setPd_name(String pd_name) {
        this.pd_name = pd_name;
    }

    public int getSls_prc() {
        return sls_prc;
    }

    public void setSls_prc(int sls_prc) {
        this.sls_prc = sls_prc;
    }

    public int getCart_cnt() {
        return cart_cnt;
    }

    public void setCart_cnt(int cart_cnt) {
        this.cart_cnt = cart_cnt;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }
}