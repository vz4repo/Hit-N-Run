// stk table 현재 사용중 아님
// 아직 생성자 안 만들었다.
// 완료 : 변수입력, getter, setter, toString()
// equals(), hashcode() null값 제외하고 생성함
package com.homerunball.product.customer.domain;

import java.util.Date;
import java.util.Objects;

public class StockViewDto {
    String pd_id;
    String pd_clsf_cd;
    int nml_stk_qty;
    int rt_stk_qry;
    int rgn_stk_qty;
    int urgn_stk_qty;
    int stfy_stk_qty;
    int odpmt_stk;
    String pur_dt;
    String rcpt_dt;
    String rcpt_cp;
    int rcpt_prc;
    int rtl_prc;
    int sls_prc;
    String stk_plc_cd;
    String stk_stat_cd;
    Date frst_reg_dt;
    String frst_reg_id;
    Date last_mod_dt;
    String last_mod_id;

    @Override
    public String toString() {
        return "StockViewDto{" +
                "pd_id='" + pd_id + '\'' +
                ", pd_clsf_cd='" + pd_clsf_cd + '\'' +
                ", nml_stk_qty=" + nml_stk_qty +
                ", rt_stk_qry=" + rt_stk_qry +
                ", rgn_stk_qty=" + rgn_stk_qty +
                ", urgn_stk_qty=" + urgn_stk_qty +
                ", stfy_stk_qty=" + stfy_stk_qty +
                ", odpmt_stk=" + odpmt_stk +
                ", pur_dt='" + pur_dt + '\'' +
                ", rcpt_dt='" + rcpt_dt + '\'' +
                ", rcpt_cp='" + rcpt_cp + '\'' +
                ", rcpt_prc=" + rcpt_prc +
                ", rtl_prc=" + rtl_prc +
                ", sls_prc=" + sls_prc +
                ", stk_plc_cd='" + stk_plc_cd + '\'' +
                ", stk_stat_cd='" + stk_stat_cd + '\'' +
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
        StockViewDto that = (StockViewDto) o;
        return nml_stk_qty == that.nml_stk_qty && rt_stk_qry == that.rt_stk_qry && rgn_stk_qty == that.rgn_stk_qty && urgn_stk_qty == that.urgn_stk_qty && stfy_stk_qty == that.stfy_stk_qty && rcpt_prc == that.rcpt_prc && rtl_prc == that.rtl_prc && sls_prc == that.sls_prc && Objects.equals(pd_id, that.pd_id) && Objects.equals(pd_clsf_cd, that.pd_clsf_cd) && Objects.equals(pur_dt, that.pur_dt) && Objects.equals(rcpt_dt, that.rcpt_dt) && Objects.equals(rcpt_cp, that.rcpt_cp) && Objects.equals(stk_stat_cd, that.stk_stat_cd) && Objects.equals(frst_reg_id, that.frst_reg_id) && Objects.equals(last_mod_id, that.last_mod_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pd_id, pd_clsf_cd, nml_stk_qty, rt_stk_qry, rgn_stk_qty, urgn_stk_qty, stfy_stk_qty, pur_dt, rcpt_dt, rcpt_cp, rcpt_prc, rtl_prc, sls_prc, stk_stat_cd, frst_reg_id, last_mod_id);
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

    public int getNml_stk_qty() {
        return nml_stk_qty;
    }

    public void setNml_stk_qty(int nml_stk_qty) {
        this.nml_stk_qty = nml_stk_qty;
    }

    public int getRt_stk_qry() {
        return rt_stk_qry;
    }

    public void setRt_stk_qry(int rt_stk_qry) {
        this.rt_stk_qry = rt_stk_qry;
    }

    public int getRgn_stk_qty() {
        return rgn_stk_qty;
    }

    public void setRgn_stk_qty(int rgn_stk_qty) {
        this.rgn_stk_qty = rgn_stk_qty;
    }

    public int getUrgn_stk_qty() {
        return urgn_stk_qty;
    }

    public void setUrgn_stk_qty(int urgn_stk_qty) {
        this.urgn_stk_qty = urgn_stk_qty;
    }

    public int getStfy_stk_qty() {
        return stfy_stk_qty;
    }

    public void setStfy_stk_qty(int stfy_stk_qty) {
        this.stfy_stk_qty = stfy_stk_qty;
    }

    public int getOdpmt_stk() {
        return odpmt_stk;
    }

    public void setOdpmt_stk(int odpmt_stk) {
        this.odpmt_stk = odpmt_stk;
    }

    public String getPur_dt() {
        return pur_dt;
    }

    public void setPur_dt(String pur_dt) {
        this.pur_dt = pur_dt;
    }

    public String getRcpt_dt() {
        return rcpt_dt;
    }

    public void setRcpt_dt(String rcpt_dt) {
        this.rcpt_dt = rcpt_dt;
    }

    public String getRcpt_cp() {
        return rcpt_cp;
    }

    public void setRcpt_cp(String rcpt_cp) {
        this.rcpt_cp = rcpt_cp;
    }

    public int getRcpt_prc() {
        return rcpt_prc;
    }

    public void setRcpt_prc(int rcpt_prc) {
        this.rcpt_prc = rcpt_prc;
    }

    public int getRtl_prc() {
        return rtl_prc;
    }

    public void setRtl_prc(int rtl_prc) {
        this.rtl_prc = rtl_prc;
    }

    public int getSls_prc() {
        return sls_prc;
    }

    public void setSls_prc(int sls_prc) {
        this.sls_prc = sls_prc;
    }

    public String getStk_plc_cd() {
        return stk_plc_cd;
    }

    public void setStk_plc_cd(String stk_plc_cd) {
        this.stk_plc_cd = stk_plc_cd;
    }

    public String getStk_stat_cd() {
        return stk_stat_cd;
    }

    public void setStk_stat_cd(String stk_stat_cd) {
        this.stk_stat_cd = stk_stat_cd;
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
