package com.homerunball.customer.domain;

import com.homerunball.customer.service.CustService;

import java.util.Date;
import java.util.Objects;

public class CustDto {
    private int c_id;
    private String c_grd_cd;
    private String c_stat_cd;
    private String c_email;
    private String c_pwd;
    private String c_name;
    private String c_birth;
    private String c_gnd;
    private String c_phn;
    private String c_zip;
    private String c_road_a;
    private String c_jibun_a;
    private String c_det_a;
//    private String c_ext_a;
    private String c_dlv_adr;
    private String sms_agr;
    private String email_agr;
    private String reg_dt;
    private String login_dt;
    private String tot_amt;
    private Date frst_reg_dt;
    private String frst_reg_id;
    private Date last_mod_dt;
    private String last_mod_id;
    private String grd_name;

    public CustDto(){}

    public CustDto(String c_email, String c_pwd, String c_name, String c_birth, String c_gnd, String c_phn, String c_zip, String c_road_a, String c_jibun_a, String c_det_a, String sms_agr, String email_agr) {
        this.c_email = c_email;
        this.c_pwd = c_pwd;
        this.c_name = c_name;
        this.c_birth = c_birth;
        this.c_gnd = c_gnd;
        this.c_phn = c_phn;
        this.c_zip = c_zip;
        this.c_road_a = c_road_a;
        this.c_jibun_a = c_jibun_a;
        this.c_det_a = c_det_a;
        this.sms_agr = sms_agr;
        this.email_agr = email_agr;
    }

    public CustDto(String c_name, String grd_name, String tot_amt, String login_dt, String reg_dt){
        this.c_name = c_name;
        this.grd_name = grd_name;
        this.tot_amt = tot_amt;
        this.login_dt = login_dt;
        this.reg_dt = reg_dt;
    }

//    public CustDto(int c_id, String c_pwd, String c_zip, String c_road_a, String c_jibun_a, String c_det_a, String c_ext_a, String c_phn, String sms_agr, String email_agr){
//        this.c_id = c_id;
//        this.c_pwd = c_pwd;
//        this.c_zip = c_zip;
//        this.c_road_a = c_road_a;
//        this.c_jibun_a = c_jibun_a;
//        this.c_det_a = c_det_a;
//        this.c_ext_a = c_ext_a;
//        this.c_phn = c_phn;
//        this.sms_agr = sms_agr;
//        this.email_agr = email_agr;
//    }

    @Override
    public String toString() {
        return "toString() CustDto{" +
                "c_id='" + c_id + '\'' +
                ", c_grd_cd='" + c_grd_cd + '\'' +
                ", c_stat_cd='" + c_stat_cd + '\'' +
                ", c_email='" + c_email + '\'' +
                ", c_pwd='" + c_pwd + '\'' +
                ", c_name='" + c_name + '\'' +
                ", c_birth='" + c_birth + '\'' +
                ", c_gnd='" + c_gnd + '\'' +
                ", c_phn='" + c_phn + '\'' +
                ", c_zip='" + c_zip + '\'' +
                ", c_road_a='" + c_road_a + '\'' +
                ", c_jibun_a='" + c_jibun_a + '\'' +
                ", c_det_a='" + c_det_a + '\'' +
//                ", c_ext_a='" + c_ext_a + '\'' +
                ", c_dlv_adr='" + c_dlv_adr + '\'' +
                ", sms_agr='" + sms_agr + '\'' +
                ", email_agr='" + email_agr + '\'' +
                ", reg_dt=" + reg_dt +
                ", login_dt=" + login_dt +
                ", tot_amt='" + tot_amt + '\'' +
                ", first_reg_dt=" + frst_reg_dt +
                ", first_reg_id='" + frst_reg_id + '\'' +
                ", last_mod_dt=" + last_mod_dt +
                ", last_mod_id='" + last_mod_id + '\'' +
                '}';
    }

    public String toStringV1() {
        return "고객 아이디 " +c_id+"번님의 수정 후 정보는" +
                "{" +
                "c_pwd='" + c_pwd + '\'' +
                ", c_phn='" + c_phn + '\'' +
                ", c_zip='" + c_zip + '\'' +
                ", c_road_a='" + c_road_a + '\'' +
                ", c_jibun_a='" + c_jibun_a + '\'' +
                ", c_det_a='" + c_det_a + '\'' +
                ", sms_agr='" + sms_agr + '\'' +
                ", email_agr='" + email_agr + '\'' +
                '}';
    }

    public String toStringV2() {
        return "고객 아이디 " +c_id+"번님의 수정 후 정보는" +
                "{" +
                "c_pwd='" + c_pwd + '\'' +
                '}';
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
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

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
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

//    public String getC_ext_a() {
//        return c_ext_a;
//    }
//
//    public void setC_ext_a(String c_ext_a) {
//        this.c_ext_a = c_ext_a;
//    }

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

    public String getReg_dt() {
        return reg_dt;
    }

    public void setReg_dt(String reg_dt) {
        this.reg_dt = reg_dt;
    }

    public String getLogin_dt() {
        return login_dt;
    }

    public void setLogin_dt(String login_dt) {
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

    public String getGrd_name() {
        return grd_name;
    }

    public void setGrd_name(String grd_name) {
        this.grd_name = grd_name;
    }


}