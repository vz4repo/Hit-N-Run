package com.homerunball.cart.domain;

import java.util.Date;
import java.util.Objects;

public class CartDto {
    private String c_id;
    private String pd_id;
    private String pd_clsf_code;
    private int cart_cnt=0;
    private Date frst_reg_dt;
    private String frst_reg_id;
    private Date last_mod_dt;
    private String last_mod_id;

    private int price;

    private int totalPrice;


    public CartDto(){}

    public CartDto(String c_id, String pd_id, String pd_clsf_code, int cart_cnt){
        this.c_id = c_id;
        this.pd_id = pd_id;
        this.pd_clsf_code = pd_clsf_code;
        this.cart_cnt = cart_cnt;

        totalPrice = cart_cnt*price;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CartDto cartDto = (CartDto) object;
        return Objects.equals(c_id, cartDto.c_id) && Objects.equals(pd_id, cartDto.pd_id) && Objects.equals(pd_clsf_code, cartDto.pd_clsf_code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(c_id, pd_id, pd_clsf_code);
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getPd_id() {
        return pd_id;
    }

    public void setPd_id(String pd_id) {
        this.pd_id = pd_id;
    }

    public String getPd_clsf_code() {
        return pd_clsf_code;
    }

    public void setPd_clsf_code(String pd_clsf_code) {
        this.pd_clsf_code = pd_clsf_code;
    }

    public int getCart_cnt() {
        return cart_cnt;
    }

    public void setCart_cnt(int cart_cnt) {
        this.cart_cnt = cart_cnt;
    }

    public int getprice() {
        return price;
    }

    public void setprice(int price) {
        this.price = price;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "CardDto{" +
                "c_id='" + c_id + '\'' +
                ", pd_id='" + pd_id + '\'' +
                ", pd_clsf_code='" + pd_clsf_code + '\'' +
                ", cart_cnt=" + cart_cnt +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                '}';
    }
}