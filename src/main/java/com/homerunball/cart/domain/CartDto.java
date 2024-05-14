package com.homerunball.cart.domain;

import java.util.Date;
import java.util.Objects;

public class CartDto {
    private int c_id;
    private String pd_id;
    private String pd_clsf_code;
    private Date frst_reg_dt;
    private String frst_reg_id;
    private Date last_mod_dt;
    private String last_mod_id;

    private int cart_cnt;
    private int sls_prc;
    private int rtl_prc;



    public CartDto(){}



    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CartDto cartDto = (CartDto) object;
        return c_id == cartDto.c_id && cart_cnt == cartDto.cart_cnt && sls_prc == cartDto.sls_prc && rtl_prc == cartDto.rtl_prc && Objects.equals(pd_id, cartDto.pd_id) && Objects.equals(pd_clsf_code, cartDto.pd_clsf_code) && Objects.equals(frst_reg_dt, cartDto.frst_reg_dt) && Objects.equals(frst_reg_id, cartDto.frst_reg_id) && Objects.equals(last_mod_dt, cartDto.last_mod_dt) && Objects.equals(last_mod_id, cartDto.last_mod_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(c_id, pd_id, pd_clsf_code, frst_reg_dt, frst_reg_id, last_mod_dt, last_mod_id, cart_cnt, sls_prc, rtl_prc);
    }

    public CartDto(int c_id, String pd_id, String pd_clsf_code, int cart_cnt, int sls_prc, int rtl_prc){
        this.c_id = c_id;
        this.pd_id = pd_id;
        this.pd_clsf_code = pd_clsf_code;
        this.cart_cnt = cart_cnt;
        this.sls_prc = sls_prc;
        this.rtl_prc = rtl_prc;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
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

    public int getRtl_prc() {
        return rtl_prc;
    }

    public void setRtl_prc(int rtl_prc) {
        this.rtl_prc = rtl_prc;
    }


    @Override
    public String toString() {
        return "CartDto{" +
                "c_id=" + c_id +
                ", pd_id='" + pd_id + '\'' +
                ", pd_clsf_code='" + pd_clsf_code + '\'' +
                ", frst_reg_dt=" + frst_reg_dt +
                ", frst_reg_id='" + frst_reg_id + '\'' +
                ", last_mod_dt=" + last_mod_dt +
                ", last_mod_id='" + last_mod_id + '\'' +
                ", cart_cnt=" + cart_cnt +
                ", sls_prc=" + sls_prc +
                ", rtl_prc=" + rtl_prc +
                '}';
    }
}