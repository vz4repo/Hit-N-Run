package com.homerunball.order.domain;

import java.util.List;

public class OrdAndStkDto {

    private String pd_name; // 제품명
    private int rtl_prc; // 가격
    private int cart_cnt; // 개수
    private int c_id;

    private int od_pay_amt; // 총금액


    public OrdAndStkDto() {
    }

    public OrdAndStkDto(String pd_name, int rtl_prc, int cart_cnt, int c_id) {
        this.pd_name = pd_name;
        this.rtl_prc = rtl_prc;
        this.cart_cnt = cart_cnt;
        this.c_id = c_id;

        od_pay_amt = rtl_prc * cart_cnt;
    }

    public static int calculateTotalAmount(List<OrdAndStkDto> ordList){
        int totalAmount = 0;
        for(OrdAndStkDto ord : ordList){
            totalAmount += ord.getOd_pay_amt();
        }
        return totalAmount;
    }

    @Override
    public String toString() {
        return "OrdAndStkDto{" +
                "pd_name='" + pd_name + '\'' +
                ", rtl_prc=" + rtl_prc +
                ", cart_cnt=" + cart_cnt +
                ", c_id=" + c_id +
                ", od_pay_amt=" + od_pay_amt +
                '}';
    }

    public int getRtl_prc() {
        return rtl_prc;
    }

    public void setRtl_prc(int rtl_prc) {
        this.rtl_prc = rtl_prc;
    }

    public int getOd_pay_amt() {
        return od_pay_amt;
    }

    public void setOd_pay_amt(int od_pay_amt) {
        this.od_pay_amt = od_pay_amt;
    }

    public String getPd_name() {
        return pd_name;
    }

    public void setPd_name(String pd_name) {
        this.pd_name = pd_name;
    }

    public int getCart_cnt() {
        return cart_cnt;
    }

    public void setCart_cnt(int cart_cnt) {
        this.cart_cnt = cart_cnt;
        od_pay_amt = rtl_prc * cart_cnt;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }
}


