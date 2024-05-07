package com.homerunball.order.domain;

import java.util.Date;
import java.util.Objects;

public class OrderStatDto {
    private Integer od_stat_seqnum;
    private Integer od_id;
    private  String c_id;
    private  String od_stat_cd;
    private Date od_stat_cng_dt;
    private Date frst_reg_dt;
    private String frst_reg_id;
    private Date last_mod_dt;
    private String last_mod_id;



    public OrderStatDto(){}

    public OrderStatDto(Integer od_stat_seqnum, Integer od_id, String c_id, String od_stat_cd, Date od_stat_cng_dt, Date frst_reg_dt, String frst_reg_id, Date last_mod_dt, String last_mod_id) {
        this.od_stat_seqnum = od_stat_seqnum;
        this.od_id = od_id;
        this.c_id = c_id;
        this.od_stat_cd = od_stat_cd;
        this.od_stat_cng_dt = od_stat_cng_dt;
        this.frst_reg_dt = frst_reg_dt;
        this.frst_reg_id = frst_reg_id;
        this.last_mod_dt = last_mod_dt;
        this.last_mod_id = last_mod_id;
    }


    public Integer getOd_stat_seqnum() {
        return od_stat_seqnum;
    }

    public void setOd_stat_seqnum(Integer od_stat_seqnum) {
        this.od_stat_seqnum = od_stat_seqnum;
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

    public String getOd_stat_cd() {
        return od_stat_cd;
    }

    public void setOd_stat_cd(String od_stat_cd) {
        this.od_stat_cd = od_stat_cd;
    }

    public Date getOd_stat_cng_dt() {
        return od_stat_cng_dt;
    }

    public void setOd_stat_cng_dt(Date od_stat_cng_dt) {
        this.od_stat_cng_dt = od_stat_cng_dt;
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

    @Override
    public String toString() {
        return "OrderStatDto{" +
                "od_stat_seqnum=" + od_stat_seqnum +
                ", od_id='" + od_id + '\'' +
                ", c_id='" + c_id + '\'' +
                ", od_stat_cd='" + od_stat_cd + '\'' +
                ", od_stat_cng_dt=" + od_stat_cng_dt +
                ", frst_reg_dt=" + frst_reg_dt +
                ", frst_reg_id='" + frst_reg_id + '\'' +
                ", last_mod_dt=" + last_mod_dt +
                ", last_mod_id='" + last_mod_id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderStatDto that = (OrderStatDto) o;
        return Objects.equals(od_stat_seqnum, that.od_stat_seqnum) && Objects.equals(od_id, that.od_id) && Objects.equals(c_id, that.c_id) && Objects.equals(od_stat_cd, that.od_stat_cd) && Objects.equals(od_stat_cng_dt, that.od_stat_cng_dt) && Objects.equals(frst_reg_dt, that.frst_reg_dt) && Objects.equals(frst_reg_id, that.frst_reg_id) && Objects.equals(last_mod_dt, that.last_mod_dt) && Objects.equals(last_mod_id, that.last_mod_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(od_stat_seqnum, od_id, c_id, od_stat_cd, od_stat_cng_dt, frst_reg_dt, frst_reg_id, last_mod_dt, last_mod_id);
    }
}
