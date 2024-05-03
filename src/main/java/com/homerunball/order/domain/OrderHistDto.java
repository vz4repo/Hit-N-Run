//package com.homerunball.order.domain;
//
//import java.util.Date;
//import java.util.Objects;
//
//public class OrderHistDto {
//    private Integer od_hist_seqnum;
//    private String od_id;
//    private String c_id;
//    private String od_cng_item_cd;
//    private String od_bf;
//    private String od_af;
//    private Date od_cng_dt;
//    private Date frst_reg_dt;
//    private String frst_reg_id;
//    private Date last_mod_dt;
//    private String last_mod_id;
//
//
//
//    public OrderHistDto(Integer od_hist_seqnum, String od_id, String c_id, String od_cng_item_cd, String od_bf, String od_af, Date od_cng_dt, Date frst_reg_dt, String frst_reg_id, Date last_mod_dt, String last_mod_id) {
//        this.od_hist_seqnum = od_hist_seqnum;
//        this.od_id = od_id;
//        this.c_id = c_id;
//        this.od_cng_item_cd = od_cng_item_cd;
//        this.od_bf = od_bf;
//        this.od_af = od_af;
//        this.od_cng_dt = od_cng_dt;
//        this.frst_reg_dt = frst_reg_dt;
//        this.frst_reg_id = frst_reg_id;
//        this.last_mod_dt = last_mod_dt;
//        this.last_mod_id = last_mod_id;
//    }
//
//    public Integer getOd_hist_seqnum() {
//        return od_hist_seqnum;
//    }
//
//    public void setOd_hist_seqnum(Integer od_hist_seqnum) {
//        this.od_hist_seqnum = od_hist_seqnum;
//    }
//
//    public String getOd_id() {
//        return od_id;
//    }
//
//    public void setOd_id(String od_id) {
//        this.od_id = od_id;
//    }
//
//    public String getC_id() {
//        return c_id;
//    }
//
//    public void setC_id(String c_id) {
//        this.c_id = c_id;
//    }
//
//    public String getOd_cng_item_cd() {
//        return od_cng_item_cd;
//    }
//
//    public void setOd_cng_item_cd(String od_cng_item_cd) {
//        this.od_cng_item_cd = od_cng_item_cd;
//    }
//
//    public String getOd_bf() {
//        return od_bf;
//    }
//
//    public void setOd_bf(String od_bf) {
//        this.od_bf = od_bf;
//    }
//
//    public String getOd_af() {
//        return od_af;
//    }
//
//    public void setOd_af(String od_af) {
//        this.od_af = od_af;
//    }
//
//    public Date getOd_cng_dt() {
//        return od_cng_dt;
//    }
//
//    public void setOd_cng_dt(Date od_cng_dt) {
//        this.od_cng_dt = od_cng_dt;
//    }
//
//    public Date getFrst_reg_dt() {
//        return frst_reg_dt;
//    }
//
//    public void setFrst_reg_dt(Date frst_reg_dt) {
//        this.frst_reg_dt = frst_reg_dt;
//    }
//
//    public String getFrst_reg_id() {
//        return frst_reg_id;
//    }
//
//    public void setFrst_reg_id(String frst_reg_id) {
//        this.frst_reg_id = frst_reg_id;
//    }
//
//    public Date getLast_mod_dt() {
//        return last_mod_dt;
//    }
//
//    public void setLast_mod_dt(Date last_mod_dt) {
//        this.last_mod_dt = last_mod_dt;
//    }
//
//    public String getLast_mod_id() {
//        return last_mod_id;
//    }
//
//    public void setLast_mod_id(String last_mod_id) {
//        this.last_mod_id = last_mod_id;
//    }
//
//    @Override
//    public String toString() {
//        return "OrderHistDto{" +
//                "od_hist_seqnum=" + od_hist_seqnum +
//                ", od_id='" + od_id + '\'' +
//                ", c_id='" + c_id + '\'' +
//                ", od_cng_item_cd='" + od_cng_item_cd + '\'' +
//                ", od_bf='" + od_bf + '\'' +
//                ", od_af='" + od_af + '\'' +
//                ", od_cng_dt=" + od_cng_dt +
//                ", frst_reg_dt=" + frst_reg_dt +
//                ", frst_reg_id='" + frst_reg_id + '\'' +
//                ", last_mod_dt=" + last_mod_dt +
//                ", last_mod_id='" + last_mod_id + '\'' +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        OrderHistDto that = (OrderHistDto) o;
//        return Objects.equals(od_hist_seqnum, that.od_hist_seqnum) && Objects.equals(od_id, that.od_id) && Objects.equals(c_id, that.c_id) && Objects.equals(od_cng_item_cd, that.od_cng_item_cd) && Objects.equals(od_bf, that.od_bf) && Objects.equals(od_af, that.od_af) && Objects.equals(od_cng_dt, that.od_cng_dt) && Objects.equals(frst_reg_dt, that.frst_reg_dt) && Objects.equals(frst_reg_id, that.frst_reg_id) && Objects.equals(last_mod_dt, that.last_mod_dt) && Objects.equals(last_mod_id, that.last_mod_id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(od_hist_seqnum, od_id, c_id, od_cng_item_cd, od_bf, od_af, od_cng_dt, frst_reg_dt, frst_reg_id, last_mod_dt, last_mod_id);
//    }
//}
