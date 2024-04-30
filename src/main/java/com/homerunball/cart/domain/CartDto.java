package com.homerunball.cart.domain;

import java.util.Date;
import java.util.Objects;

public class CartDto {
    private String c_id;
    private String pd_id;
    private String pd_clsf_code;
    private int cart_cnt;
    private Date frst_reg_dt;
    private String frst_reg_id;
    private Date last_mod_dt;
    private String last_mod_id;


    /*재고테이블 join*/
    private int sls_prc;
    private String pd_name;


    private int price;

    private int totalPrice;





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartDto cartDto = (CartDto) o;
        return cart_cnt == cartDto.cart_cnt && sls_prc == cartDto.sls_prc && price == cartDto.price && totalPrice == cartDto.totalPrice && Objects.equals(c_id, cartDto.c_id) && Objects.equals(pd_id, cartDto.pd_id) && Objects.equals(pd_clsf_code, cartDto.pd_clsf_code) && Objects.equals(pd_name, cartDto.pd_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(c_id, pd_id, pd_clsf_code, cart_cnt, sls_prc, pd_name, price, totalPrice);
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "c_id='" + c_id + '\'' +
                ", pd_id='" + pd_id + '\'' +
                ", pd_clsf_code='" + pd_clsf_code + '\'' +
                ", cart_cnt=" + cart_cnt +
                ", sls_prc=" + sls_prc +
                ", pd_name='" + pd_name + '\'' +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public CartDto(String c_id, String pd_id, String pd_clsf_code, int cart_cnt, int sls_prc, String pd_name, int price, int totalPrice) {
        this.c_id = c_id;
        this.pd_id = pd_id;
        this.pd_clsf_code = pd_clsf_code;
        this.cart_cnt = cart_cnt;
        this.sls_prc = sls_prc;
        this.pd_name = pd_name;
        this.price = price;
        this.totalPrice = totalPrice;
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

    public int getSls_prc() {
        return sls_prc;
    }

    public void setSls_prc(int sls_prc) {
        this.sls_prc = sls_prc;
    }

    public String getPd_name() {
        return pd_name;
    }

    public void setPd_name(String pd_name) {
        this.pd_name = pd_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
