package com.homerunball.order.domain;

import java.util.Date;
import java.util.Objects;

public class OrdDto {
    private Integer od_id;
    private String c_id;
    private Date od_dt;
    private String od_stat_cd;
    private Integer od_pd_qty;
    private  Integer od_tot_qty;
    private  Integer od_pay_amt;
    private Date frst_reg_dt;
    private String frst_reg_id;
    private Date last_mod_dt;
    private String last_mod_id;
/*
추가 예정
pd_name, sls_prc
*/
    public  OrdDto(){
    }

    public OrdDto(Integer od_id, String c_id, Date od_dt, String od_stat_cd, Integer od_pd_qty, Integer od_tot_qty, Integer od_pay_amt, String frst_reg_id, String last_mod_id) {
        this.od_id = od_id;
        this.c_id = c_id;
        this.od_dt = od_dt;
        this.od_stat_cd = od_stat_cd;
        this.od_pd_qty = od_pd_qty;
        this.od_tot_qty = od_tot_qty;
        this.od_pay_amt = od_pay_amt;
        this.frst_reg_id = frst_reg_id;
        this.last_mod_id = last_mod_id;
    }

    public OrdDto(Integer od_id, String c_id, Date od_dt, String od_stat_cd, Integer od_pd_qty, Integer od_tot_qty, Integer od_pay_amt, Date frst_reg_dt, String frst_reg_id, Date last_mod_dt, String last_mod_id) {
        this.od_id = od_id;
        this.c_id = c_id;
        this.od_dt = od_dt;
        this.od_stat_cd = od_stat_cd;
        this.od_pd_qty = od_pd_qty;
        this.od_tot_qty = od_tot_qty;
        this.od_pay_amt = od_pay_amt;
        this.frst_reg_dt = frst_reg_dt;
        this.frst_reg_id = frst_reg_id;
        this.last_mod_dt = last_mod_dt;
        this.last_mod_id = last_mod_id;
    }

    public Integer getOd_id() {
        return od_id;
    }

    public void setOd_id(Integer od_id) {
        this.od_id = od_id;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public Date getOd_dt() {
        return od_dt;
    }

    public void setOd_dt(Date od_dt) {
        this.od_dt = od_dt;
    }

    public String getOd_stat_cd() {
        return od_stat_cd;
    }

    public void setOd_stat_cd(String od_stat_cd) {
        this.od_stat_cd = od_stat_cd;
    }

    public Integer getOd_pd_qty() {
        return od_pd_qty;
    }

    public void setOd_pd_qty(Integer od_pd_qty) {
        this.od_pd_qty = od_pd_qty;
    }

    public Integer getOd_tot_qty() {
        return od_tot_qty;
    }

    public void setOd_tot_qty(Integer od_tot_qty) {
        this.od_tot_qty = od_tot_qty;
    }

    public Integer getOd_pay_amt() {
        return od_pay_amt;
    }

    public void setOd_pay_amt(Integer od_pay_amt) {
        this.od_pay_amt = od_pay_amt;
    }

    public Date getFrst_reg_dt() {
        return frst_reg_dt;
    }

    public void setFrst_reg_dt(Date frst_reg_dt) {
        this.frst_reg_dt = frst_reg_dt;
    }

    public String getFrst_reg_id() {
        return frst_reg_id;
    }

    public void setFrst_reg_id(String frst_reg_id) {
        this.frst_reg_id = frst_reg_id;
    }

    public Date getLast_mod_dt() {
        return last_mod_dt;
    }

    public void setLast_mod_dt(Date last_mod_dt) {
        this.last_mod_dt = last_mod_dt;
    }

    public String getLast_mod_id() {
        return last_mod_id;
    }

    public void setLast_mod_id(String last_mod_id) {
        this.last_mod_id = last_mod_id;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        OrdDto ordDto = (OrdDto) o;
//        return Objects.equals(od_id, ordDto.od_id) && Objects.equals(c_id, ordDto.c_id) && Objects.equals(od_dt, ordDto.od_dt) && Objects.equals(od_stat_cd, ordDto.od_stat_cd) && Objects.equals(od_pd_qty, ordDto.od_pd_qty) && Objects.equals(od_tot_qty, ordDto.od_tot_qty) && Objects.equals(od_pay_amt, ordDto.od_pay_amt) && Objects.equals(frst_reg_dt, ordDto.frst_reg_dt) && Objects.equals(frst_reg_id, ordDto.frst_reg_id) && Objects.equals(last_mod_dt, ordDto.last_mod_dt) && Objects.equals(last_mod_id, ordDto.last_mod_id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(od_id, c_id, od_dt, od_stat_cd, od_pd_qty, od_tot_qty, od_pay_amt, frst_reg_dt, frst_reg_id, last_mod_dt, last_mod_id);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdDto ordDto = (OrdDto) o;
        return Objects.equals(od_id, ordDto.od_id) &&
                Objects.equals(c_id, ordDto.c_id) &&
                Objects.equals(od_dt, ordDto.od_dt) &&
                Objects.equals(od_stat_cd, ordDto.od_stat_cd) &&
                Objects.equals(od_pd_qty, ordDto.od_pd_qty) &&
                Objects.equals(od_tot_qty, ordDto.od_tot_qty) &&
                Objects.equals(od_pay_amt, ordDto.od_pay_amt) &&
                Objects.equals(frst_reg_dt, ordDto.frst_reg_dt) &&
                Objects.equals(frst_reg_id, ordDto.frst_reg_id) &&
                Objects.equals(last_mod_dt, ordDto.last_mod_dt) &&
                Objects.equals(last_mod_id, ordDto.last_mod_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(od_id, c_id, od_dt, od_stat_cd, od_pd_qty, od_tot_qty, od_pay_amt, frst_reg_dt, frst_reg_id, last_mod_dt, last_mod_id);
    }

    @Override
    public String toString() {
        return "OrdDto{" +
                "od_id='" + od_id + '\'' +
                ", c_id='" + c_id + '\'' +
                ", od_dt=" + od_dt +
                ", od_stat_cd='" + od_stat_cd + '\'' +
                ", od_pd_qty=" + od_pd_qty +
                ", od_tot_qty=" + od_tot_qty +
                ", od_pay_amt=" + od_pay_amt +
                ", frst_reg_dt=" + frst_reg_dt +
                ", frst_reg_id='" + frst_reg_id + '\'' +
                ", last_mod_dt=" + last_mod_dt +
                ", last_mod_id='" + last_mod_id + '\'' +
                '}';
    }
}


