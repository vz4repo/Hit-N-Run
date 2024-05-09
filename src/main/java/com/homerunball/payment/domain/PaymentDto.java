package com.homerunball.payment.domain;

import java.util.Date;

public class PaymentDto {

  /* field */
  String pay_id;
  int pay_seqnum;
  int c_id;
  int od_id;
  String trace_id;
  int disc_amt;
  int od_pay_amt;
  int pay_final_amt;
  String pay_stat_cd;
  Date pay_dt;
  String pay_meth_cd;
  String pay_aprv_stat;
  String pay_aprv_num;
  Date pay_aprv_dt;
  String pay_resp_cd;
  int pay_canc_amt;
  Date pay_canc_dt;
  String c_name;
  String issuer_cd;
  String acquier_cd;
  String trans_type;
  int mth_instlmt;
  String card_num;
  String bank_name;
  String acct_num;
  Date frst_reg_dt;
  String frst_reg_id;
  Date last_mod_dt;
  String last_mod_id;

  /* constructor */
  public PaymentDto() {
  }

  public PaymentDto(String pay_id, int pay_seqnum, int c_id, int od_id, String trace_id, int od_pay_amt,
      int pay_final_amt, String pay_stat_cd, Date pay_dt, String pay_meth_cd, String pay_aprv_stat, String pay_aprv_num,
      Date pay_aprv_dt, String pay_resp_cd, String c_name, String issuer_cd, String acquier_cd, String trans_type,
      int mth_instlmt, String card_num) {
    this.pay_id = pay_id;
    this.pay_seqnum = pay_seqnum;
    this.c_id = c_id;
    this.od_id = od_id;
    this.trace_id = trace_id;
    this.od_pay_amt = od_pay_amt;
    this.pay_final_amt = pay_final_amt;
    this.pay_stat_cd = pay_stat_cd;
    this.pay_dt = pay_dt;
    this.pay_meth_cd = pay_meth_cd;
    this.pay_aprv_stat = pay_aprv_stat;
    this.pay_aprv_num = pay_aprv_num;
    this.pay_aprv_dt = pay_aprv_dt;
    this.pay_resp_cd = pay_resp_cd;
    this.c_name = c_name;
    this.issuer_cd = issuer_cd;
    this.acquier_cd = acquier_cd;
    this.trans_type = trans_type;
    this.mth_instlmt = mth_instlmt;
    this.card_num = card_num;
  }

  /* getter, setter */
  public String getPay_id() {
    return pay_id;
  }

  public void setPay_id(String pay_id) {
    this.pay_id = pay_id;
  }

  public int getPay_seqnum() {
    return pay_seqnum;
  }

  public void setPay_seqnum(int pay_seqnum) {
    this.pay_seqnum = pay_seqnum;
  }

  public int getC_id() {
    return c_id;
  }

  public void setC_id(int c_id) {
    this.c_id = c_id;
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

  public int getDisc_amt() {
    return disc_amt;
  }

  public void setDisc_amt(int disc_amt) {
    this.disc_amt = disc_amt;
  }

  public int getOd_pay_amt() {
    return od_pay_amt;
  }

  public void setOd_pay_amt(int od_pay_amt) {
    this.od_pay_amt = od_pay_amt;
  }

  public int getPay_final_amt() {
    return pay_final_amt;
  }

  public void setPay_final_amt(int pay_final_amt) {
    this.pay_final_amt = pay_final_amt;
  }

  public String getPay_stat_cd() {
    return pay_stat_cd;
  }

  public void setPay_stat_cd(String pay_stat_cd) {
    this.pay_stat_cd = pay_stat_cd;
  }

  public Date getPay_dt() {
    return pay_dt;
  }

  public void setPay_dt(Date pay_dt) {
    this.pay_dt = pay_dt;
  }

  public String getPay_meth_cd() {
    return pay_meth_cd;
  }

  public void setPay_meth_cd(String pay_meth_cd) {
    this.pay_meth_cd = pay_meth_cd;
  }

  public String getPay_aprv_stat() {
    return pay_aprv_stat;
  }

  public void setPay_aprv_stat(String pay_aprv_stat) {
    this.pay_aprv_stat = pay_aprv_stat;
  }

  public String getPay_aprv_num() {
    return pay_aprv_num;
  }

  public void setPay_aprv_num(String pay_aprv_num) {
    this.pay_aprv_num = pay_aprv_num;
  }

  public Date getPay_aprv_dt() {
    return pay_aprv_dt;
  }

  public void setPay_aprv_dt(Date pay_aprv_dt) {
    this.pay_aprv_dt = pay_aprv_dt;
  }

  public String getPay_resp_cd() {
    return pay_resp_cd;
  }

  public void setPay_resp_cd(String pay_resp_cd) {
    this.pay_resp_cd = pay_resp_cd;
  }

  public int getPay_canc_amt() {
    return pay_canc_amt;
  }

  public void setPay_canc_amt(int pay_canc_amt) {
    this.pay_canc_amt = pay_canc_amt;
  }

  public Date getPay_canc_dt() {
    return pay_canc_dt;
  }

  public void setPay_canc_dt(Date pay_canc_dt) {
    this.pay_canc_dt = pay_canc_dt;
  }

  public String getC_name() {
    return c_name;
  }

  public void setC_name(String c_name) {
    this.c_name = c_name;
  }

  public String getIssuer_cd() {
    return issuer_cd;
  }

  public void setIssuer_cd(String issuer_cd) {
    this.issuer_cd = issuer_cd;
  }

  public String getAcquier_cd() {
    return acquier_cd;
  }

  public void setAcquier_cd(String acquier_cd) {
    this.acquier_cd = acquier_cd;
  }

  public String getTrans_type() {
    return trans_type;
  }

  public void setTrans_type(String trans_type) {
    this.trans_type = trans_type;
  }

  public int getMth_instlmt() {
    return mth_instlmt;
  }

  public void setMth_instlmt(int mth_instlmt) {
    this.mth_instlmt = mth_instlmt;
  }

  public String getCard_num() {
    return card_num;
  }

  public void setCard_num(String card_num) {
    this.card_num = card_num;
  }

  public String getBank_name() {
    return bank_name;
  }

  public void setBank_name(String bank_name) {
    this.bank_name = bank_name;
  }

  public String getAcct_num() {
    return acct_num;
  }

  public void setAcct_num(String acct_num) {
    this.acct_num = acct_num;
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


  /* toString() */
  @Override
  public String toString() {
    return "PaymentDto{" + "pay_id='" + pay_id + '\'' + ", pay_seqnum=" + pay_seqnum + ", c_id=" + c_id + ", od_id="
        + od_id + ", trace_id='" + trace_id + '\'' + ", disc_amt=" + disc_amt + ", od_pay_amt=" + od_pay_amt
        + ", pay_final_amt=" + pay_final_amt + ", pay_stat_cd='" + pay_stat_cd + '\'' + ", pay_dt=" + pay_dt
        + ", pay_meth_cd='" + pay_meth_cd + '\'' + ", pay_aprv_stat='" + pay_aprv_stat + '\'' + ", pay_aprv_num='"
        + pay_aprv_num + '\'' + ", pay_aprv_dt=" + pay_aprv_dt + ", pay_resp_cd='" + pay_resp_cd + '\''
        + ", pay_canc_amt=" + pay_canc_amt + ", pay_canc_dt=" + pay_canc_dt + ", c_name='" + c_name + '\''
        + ", issuer_cd='" + issuer_cd + '\'' + ", acquier_cd='" + acquier_cd + '\'' + ", trans_type='" + trans_type
        + '\'' + ", mth_instlmt=" + mth_instlmt + ", card_num='" + card_num + '\'' + ", bank_name='" + bank_name + '\''
        + ", acct_num='" + acct_num + '\'' + ", frst_reg_dt=" + frst_reg_dt + ", frst_reg_id='" + frst_reg_id + '\''
        + ", last_mod_dt=" + last_mod_dt + ", last_mod_id='" + last_mod_id + '\'' + '}';
  }
}
