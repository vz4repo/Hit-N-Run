package com.homerunball.ord.domain;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Objects;

public class OrderDetDto {
    private Integer od_det_seqnum;
    private Integer od_id;
    private String pd_id;
    private String pd_clsf_cd;
    private Date od_dt;
    private String pd_name;
    private Integer slg_prc;
    private Integer od_qty;
    private String divry_sts_cd;
    private Date frst_reg_dt;
    private String frst_reg_id;
    private Date last_mod_dt;
    private String last_mod_id;


    public OrderDetDto(){}

    public OrderDetDto(Integer od_det_seqnum, Integer od_id, String pd_id, String pd_clsf_cd, Date od_dt, String pd_name, Integer slg_prc, Integer od_qty, String divry_sts_cd, Date frst_reg_dt, String frst_reg_id, Date last_mod_dt, String last_mod_id) {
        this.od_det_seqnum = od_det_seqnum;
        this.od_id = od_id;
        this.pd_id = pd_id;
        this.pd_clsf_cd = pd_clsf_cd;
        this.od_dt = od_dt;
        this.pd_name = pd_name;
        this.slg_prc = slg_prc;
        this.od_qty = od_qty;
        this.divry_sts_cd = divry_sts_cd;
        this.frst_reg_dt = frst_reg_dt;
        this.frst_reg_id = frst_reg_id;
        this.last_mod_dt = last_mod_dt;
        this.last_mod_id = last_mod_id;
    }

    public Integer getOd_det_seqnum() {
        return od_det_seqnum;
    }

    public void setOd_det_seqnum(Integer od_det_seqnum) {
        this.od_det_seqnum = od_det_seqnum;
    }

    public Integer getOd_id() {
        return od_id;
    }

    public void setOd_id(Integer od_id) {
        this.od_id = od_id;
    }

    public String getPd_id() {
        return pd_id;
    }

    public void setPd_id(String pd_id) {
        this.pd_id = pd_id;
    }

    public String getPd_clsf_cd() {
        return pd_clsf_cd;
    }

    public void setPd_clsf_cd(String pd_clsf_cd) {
        this.pd_clsf_cd = pd_clsf_cd;
    }

    public Date getOd_dt() {
        return od_dt;
    }

    public void setOd_dt(Date od_dt) {
        this.od_dt = od_dt;
    }

    public String getPd_name() {
        return pd_name;
    }

    public void setPd_name(String pd_name) {
        this.pd_name = pd_name;
    }

    public Integer getSlg_prc() {
        return slg_prc;
    }

    public void setSls_prc(Integer sls_prc) {
        this.slg_prc = slg_prc;
    }

    public Integer getOd_qty() {
        return od_qty;
    }

    public void setOd_qty(Integer od_qty) {
        this.od_qty = od_qty;
    }

    public String getDivry_sts_cd() {
        return divry_sts_cd;
    }

    public void setDivry_sts_cd(String divry_sts_cd) {
        this.divry_sts_cd = divry_sts_cd;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetDto that = (OrderDetDto) o;
        return Objects.equals(od_det_seqnum, that.od_det_seqnum) && Objects.equals(od_id, that.od_id) && Objects.equals(pd_id, that.pd_id) && Objects.equals(pd_clsf_cd, that.pd_clsf_cd) && Objects.equals(od_dt, that.od_dt) && Objects.equals(pd_name, that.pd_name) && Objects.equals(slg_prc, that.slg_prc) && Objects.equals(od_qty, that.od_qty) && Objects.equals(divry_sts_cd, that.divry_sts_cd) && Objects.equals(frst_reg_dt, that.frst_reg_dt) && Objects.equals(frst_reg_id, that.frst_reg_id) && Objects.equals(last_mod_dt, that.last_mod_dt) && Objects.equals(last_mod_id, that.last_mod_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(od_det_seqnum, od_id, pd_id, pd_clsf_cd, od_dt, pd_name, slg_prc, od_qty, divry_sts_cd, frst_reg_dt, frst_reg_id, last_mod_dt, last_mod_id);
    }

    @Override
    public String toString() {
        return "OrderDetDto{" +
                "od_det_seqnum=" + od_det_seqnum +
                ", od_id='" + od_id + '\'' +
                ", pd_id='" + pd_id + '\'' +
                ", pd_clsf_cd='" + pd_clsf_cd + '\'' +
                ", od_dt=" + od_dt +
                ", pd_name='" + pd_name + '\'' +
                ", slg_prc=" + slg_prc +
                ", od_qty=" + od_qty +
                ", divry_sts_cd='" + divry_sts_cd + '\'' +
                ", frst_reg_dt=" + frst_reg_dt +
                ", frst_reg_id='" + frst_reg_id + '\'' +
                ", last_mod_dt=" + last_mod_dt +
                ", last_mod_id='" + last_mod_id + '\'' +
                '}';
    }
}