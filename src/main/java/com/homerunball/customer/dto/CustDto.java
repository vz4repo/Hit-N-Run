package com.homerunball.customer.dto;

import java.util.Date;
import java.util.Objects;

public class CustDto {
    private String c_id;
    private String c_grd_cd;
    private String c_stat_cd;
    private String c_email;
    private String c_pwd;
    private String c_nm;
    private String c_birth;
    private String c_gnd;
    private String c_phn;
    private String c_zip;
    private String c_road_a;
    private String c_jibun_a;
    private String c_det_a;
    private String c_ext_a;
    private String c_dlv_adr;
    private String sms_agr;
    private String email_agr;
    private Date reg_date;
    private Date login_dt;
    private String tot_amt;
    private Date frst_reg_dt;
    private String frst_reg_id;
    private Date last_mod_dt;
    private String last_mod_id;

    public CustDto(){}

    public CustDto(String c_email, String c_pwd, String c_nm, String c_birth, String c_gnd, String c_phn, String c_zip, String c_road_a, String c_jibun_a, String c_det_a, String c_ext_a, String sms_agr, String email_agr) {
        this.c_email = c_email;
        this.c_pwd = c_pwd;
        this.c_nm = c_nm;
        this.c_birth = c_birth;
        this.c_gnd = c_gnd;
        this.c_phn = c_phn;
        this.c_zip = c_zip;
        this.c_road_a = c_road_a;
        this.c_jibun_a = c_jibun_a;
        this.c_det_a = c_det_a;
        this.c_ext_a = c_ext_a;
        this.sms_agr = sms_agr;
        this.email_agr = email_agr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustDto custdto = (CustDto) o;
        return Objects.equals(c_id, custdto.c_id) && Objects.equals(c_grd_cd, custdto.c_grd_cd) && Objects.equals(c_stat_cd, custdto.c_stat_cd) && Objects.equals(c_email, custdto.c_email) && Objects.equals(c_pwd, custdto.c_pwd) && Objects.equals(c_nm, custdto.c_nm) && Objects.equals(c_birth, custdto.c_birth) && Objects.equals(c_gnd, custdto.c_gnd) && Objects.equals(c_phn, custdto.c_phn) && Objects.equals(c_zip, custdto.c_zip) && Objects.equals(c_road_a, custdto.c_road_a) && Objects.equals(c_jibun_a, custdto.c_jibun_a) && Objects.equals(c_det_a, custdto.c_det_a) && Objects.equals(c_ext_a, custdto.c_ext_a) && Objects.equals(c_dlv_adr, custdto.c_dlv_adr) && Objects.equals(sms_agr, custdto.sms_agr) && Objects.equals(email_agr, custdto.email_agr) && Objects.equals(reg_date, custdto.reg_date) && Objects.equals(login_dt, custdto.login_dt) && Objects.equals(tot_amt, custdto.tot_amt) && Objects.equals(frst_reg_dt, custdto.frst_reg_dt) && Objects.equals(frst_reg_id, custdto.frst_reg_id) && Objects.equals(last_mod_dt, custdto.last_mod_dt) && Objects.equals(last_mod_id, custdto.last_mod_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(c_id, c_grd_cd, c_stat_cd, c_email, c_pwd, c_nm, c_birth, c_gnd, c_phn, c_zip, c_road_a, c_jibun_a, c_det_a, c_ext_a, c_dlv_adr, sms_agr, email_agr, reg_date, login_dt, tot_amt, frst_reg_dt, frst_reg_id, last_mod_dt, last_mod_id);
    }

    @Override
    public String toString() {
        return "toString() CustDto{" +
                "c_id='" + c_id + '\'' +
                ", c_grd_cd='" + c_grd_cd + '\'' +
                ", c_stat_cd='" + c_stat_cd + '\'' +
                ", c_email='" + c_email + '\'' +
                ", c_pwd='" + c_pwd + '\'' +
                ", c_nm='" + c_nm + '\'' +
                ", c_birth='" + c_birth + '\'' +
                ", c_gnd='" + c_gnd + '\'' +
                ", c_phn='" + c_phn + '\'' +
                ", c_zip='" + c_zip + '\'' +
                ", c_road_a='" + c_road_a + '\'' +
                ", c_jibun_a='" + c_jibun_a + '\'' +
                ", c_det_a='" + c_det_a + '\'' +
                ", c_ext_a='" + c_ext_a + '\'' +
                ", c_dlv_adr='" + c_dlv_adr + '\'' +
                ", sms_agr='" + sms_agr + '\'' +
                ", email_agr='" + email_agr + '\'' +
                ", reg_date=" + reg_date +
                ", login_dt=" + login_dt +
                ", tot_amt='" + tot_amt + '\'' +
                ", first_reg_dt=" + frst_reg_dt +
                ", first_reg_id='" + frst_reg_id + '\'' +
                ", last_mod_dt=" + last_mod_dt +
                ", last_mod_id='" + last_mod_id + '\'' +
                '}';
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getC_grd_cd() {
        return c_grd_cd;
    }

    public void setC_grd_cd(String c_grd_cd) {
        this.c_grd_cd = c_grd_cd;
    }

    public String getC_stat_cd() {
        return c_stat_cd;
    }

    public void setC_stat_cd(String c_stat_cd) {
        this.c_stat_cd = c_stat_cd;
    }

    public String getC_email() {
        return c_email;
    }

    public void setC_email(String c_email) {
        this.c_email = c_email;
    }

    public String getC_pwd() {
        return c_pwd;
    }

    public void setC_pwd(String c_pwd) {
        this.c_pwd = c_pwd;
    }

    public String getC_nm() {
        return c_nm;
    }

    public void setC_nm(String c_nm) {
        this.c_nm = c_nm;
    }

    public String getC_birth() {
        return c_birth;
    }

    public void setC_birth(String c_birth) {
        this.c_birth = c_birth;
    }

    public String getC_gnd() {
        return c_gnd;
    }

    public void setC_gnd(String c_gnd) {
        this.c_gnd = c_gnd;
    }

    public String getC_phn() {
        return c_phn;
    }

    public void setC_phn(String c_phn) {
        this.c_phn = c_phn;
    }

    public String getC_zip() {
        return c_zip;
    }

    public void setC_zip(String c_zip) {
        this.c_zip = c_zip;
    }

    public String getC_road_a() {
        return c_road_a;
    }

    public void setC_road_a(String c_road_a) {
        this.c_road_a = c_road_a;
    }

    public String getC_jibun_a() {
        return c_jibun_a;
    }

    public void setC_jibun_a(String c_jibun_a) {
        this.c_jibun_a = c_jibun_a;
    }

    public String getC_det_a() {
        return c_det_a;
    }

    public void setC_det_a(String c_det_a) {
        this.c_det_a = c_det_a;
    }

    public String getC_ext_a() {
        return c_ext_a;
    }

    public void setC_ext_a(String c_ext_a) {
        this.c_ext_a = c_ext_a;
    }

    public String getC_dlv_adr() {
        return c_dlv_adr;
    }

    public void setC_dlv_adr(String c_dlv_adr) {
        this.c_dlv_adr = c_dlv_adr;
    }

    public String getSms_agr() {
        return sms_agr;
    }

    public void setSms_agr(String sms_agr) {
        this.sms_agr = sms_agr;
    }

    public String getEmail_agr() {
        return email_agr;
    }

    public void setEmail_agr(String email_agr) {
        this.email_agr = email_agr;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public Date getLogin_dt() {
        return login_dt;
    }

    public void setLogin_dt(Date login_dt) {
        this.login_dt = login_dt;
    }

    public String getTot_amt() {
        return tot_amt;
    }

    public void setTot_amt(String tot_amt) {
        this.tot_amt = tot_amt;
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
}