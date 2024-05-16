package com.homerunball.payment.domain;

import java.time.LocalDateTime;

public class PaymentFailDto {

  /* field */
  String pay_id;
  int od_id;
  String trace_id;
  String pay_meth_cd;
  String inst_cd;
  String pay_err_cd;
  String err_msg_ko;
  LocalDateTime pay_err_dt;
  LocalDateTime frst_reg_dt;
  String frst_reg_id;
  LocalDateTime last_mod_dt;
  String last_mod_id;

  /* constructor */
  public PaymentFailDto() {
  }

  public PaymentFailDto(String pay_id, int od_id, String trace_id, String pay_err_cd, String err_msg_ko,
      LocalDateTime pay_err_dt) {
    this.pay_id = pay_id;
    this.od_id = od_id;
    this.trace_id = trace_id;
    this.pay_err_cd = pay_err_cd;
    this.err_msg_ko = err_msg_ko;
    this.pay_err_dt = pay_err_dt;
  }

  /* getter, setter */
  public String getPay_id() {
    return pay_id;
  }

  public void setPay_id(String pay_id) {
    this.pay_id = pay_id;
  }

  public int getOd_id() {
    return od_id;
  }

  public void setOd_id(int od_id) {
    this.od_id = od_id;
  }

  public String getTrace_id() {
    return trace_id;
  }

  public void setTrace_id(String trace_id) {
    this.trace_id = trace_id;
  }

  public String getPay_meth_cd() {
    return pay_meth_cd;
  }

  public void setPay_meth_cd(String pay_meth_cd) {
    this.pay_meth_cd = pay_meth_cd;
  }

  public String getInst_cd() {
    return inst_cd;
  }

  public void setInst_cd(String inst_cd) {
    this.inst_cd = inst_cd;
  }

  public String getPay_err_cd() {
    return pay_err_cd;
  }

  public void setPay_err_cd(String pay_err_cd) {
    this.pay_err_cd = pay_err_cd;
  }

  public String getErr_msg_ko() {
    return err_msg_ko;
  }

  public void setErr_msg_ko(String err_msg_ko) {
    this.err_msg_ko = err_msg_ko;
  }

  public LocalDateTime getPay_err_dt() {
    return pay_err_dt;
  }

  public void setPay_err_dt(LocalDateTime pay_err_dt) {
    this.pay_err_dt = pay_err_dt;
  }

  public LocalDateTime getFrst_reg_dt() {
    return frst_reg_dt;
  }

  public void setFrst_reg_dt(LocalDateTime frst_reg_dt) {
    this.frst_reg_dt = frst_reg_dt;
  }

  public String getFrst_reg_id() {
    return frst_reg_id;
  }

  public void setFrst_reg_id(String frst_reg_id) {
    this.frst_reg_id = frst_reg_id;
  }

  public LocalDateTime getLast_mod_dt() {
    return last_mod_dt;
  }

  public void setLast_mod_dt(LocalDateTime last_mod_dt) {
    this.last_mod_dt = last_mod_dt;
  }

  public String getLast_mod_id() {
    return last_mod_id;
  }

  public void setLast_mod_id(String last_mod_id) {
    this.last_mod_id = last_mod_id;
  }

  /* toString() */

  @Override
  public String toString() {
    return "PaymentFailDto{" +
        "pay_id='" + pay_id + '\'' +
        ", od_id=" + od_id +
        ", trace_id='" + trace_id + '\'' +
        ", pay_meth_cd='" + pay_meth_cd + '\'' +
        ", inst_cd='" + inst_cd + '\'' +
        ", pay_err_cd='" + pay_err_cd + '\'' +
        ", err_msg_ko='" + err_msg_ko + '\'' +
        ", pay_err_dt=" + pay_err_dt +
        ", frst_reg_dt=" + frst_reg_dt +
        ", frst_reg_id='" + frst_reg_id + '\'' +
        ", last_mod_dt=" + last_mod_dt +
        ", last_mod_id='" + last_mod_id + '\'' +
        '}';
  }
}


