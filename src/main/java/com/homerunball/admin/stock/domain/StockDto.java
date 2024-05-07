package com.homerunball.admin.stock.domain;

import java.util.Date;
import java.util.Objects;

public class StockDto {
    private String pd_id;                   //제품ID
    private String pd_clsf_cd;              //제품 구분 코드
    private String pd_name;                 //제품명
    private Integer nml_stk_qty;            //정상재고 수량
    private Integer rt_stk_qty;             //반품재고 수량
    private Integer rgn_stk_qty;            //재생가능재고 수량
    private Integer urgn_stk_qty;           //재생불가능재고 수량
    private Integer sfty_stk_qty;           //안전재고 수량
    private Integer odpmt_stk;              //가용재고
    private String pur_dt;                  //매입일
    private String rcpt_dt;                 //입고일
    private String rcpt_cp;                 //입고처
    private Integer rcpt_prc;               //입고가격
    private Integer rtl_prc;                //소비자가격
    private Integer sls_prc;                //판매가격
    private String stk_plc_cd;              //재고 위치 코드
    private String stk_stat_cd;             //재고진행상태코드
    private Date frst_reg_dt;               //최초등록일시
    private String frst_reg_id;             //최초등록자
    private Date last_mod_dt;               //최종수정일시
    private String last_mod_id;             //최종수정자

    public StockDto() {
    }

    public StockDto(String pd_id, String pd_clsf_cd, String pd_name, Integer nml_stk_qty, Integer rt_stk_qty, Integer rgn_stk_qty, Integer urgn_stk_qty, Integer sfty_stk_qty, String pur_dt, String rcpt_dt, String rcpt_cp, Integer rcpt_prc, Integer rtl_prc, Integer sls_prc, String stk_plc_cd, String stk_stat_cd) {
        this.pd_id = pd_id;
        this.pd_clsf_cd = pd_clsf_cd;
        this.pd_name = pd_name;
        this.nml_stk_qty = nml_stk_qty;
        this.rt_stk_qty = rt_stk_qty;
        this.rgn_stk_qty = rgn_stk_qty;
        this.urgn_stk_qty = urgn_stk_qty;
        this.sfty_stk_qty = sfty_stk_qty;
        this.odpmt_stk = nml_stk_qty + rt_stk_qty + rgn_stk_qty;
        this.pur_dt = pur_dt;
        this.rcpt_dt = rcpt_dt;
        this.rcpt_cp = rcpt_cp;
        this.rcpt_prc = rcpt_prc;
        this.rtl_prc = rtl_prc;
        this.sls_prc = sls_prc;
        this.stk_plc_cd = stk_plc_cd;
        this.stk_stat_cd = stk_stat_cd;
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

    public String getPd_name() { return pd_name; }

    public void setPd_name(String pd_name) { this.pd_name = pd_name; }

    public Integer getNml_stk_qty() {
        return nml_stk_qty;
    }

    public void setNml_stk_qty(Integer nml_stk_qty) {
        this.nml_stk_qty = nml_stk_qty;
    }

    public Integer getRt_stk_qty() {
        return rt_stk_qty;
    }

    public void setRt_stk_qty(Integer rt_stk_qty) {
        this.rt_stk_qty = rt_stk_qty;
    }

    public Integer getRgn_stk_qty() {
        return rgn_stk_qty;
    }

    public void setRgn_stk_qty(Integer rgn_stk_qty) {
        this.rgn_stk_qty = rgn_stk_qty;
    }

    public Integer getUrgn_stk_qty() {
        return urgn_stk_qty;
    }

    public void setUrgn_stk_qty(Integer urgn_stk_qty) {
        this.urgn_stk_qty = urgn_stk_qty;
    }

    public Integer getSfty_stk_qty() {
        return sfty_stk_qty;
    }

    public void setSfty_stk_qty(Integer sfty_stk_qty) {
        this.sfty_stk_qty = sfty_stk_qty;
    }

    public Integer getOdpmt_stk() {
        return nml_stk_qty + rt_stk_qty + rgn_stk_qty;
    }

    public void setOdpmt_stk(Integer odpmt_stk) { this.odpmt_stk = odpmt_stk; }

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

    public Integer getRcpt_prc() {
        return rcpt_prc;
    }

    public void setRcpt_prc(Integer rcpt_prc) {
        this.rcpt_prc = rcpt_prc;
    }

    public Integer getRtl_prc() {
        return rtl_prc;
    }

    public void setRtl_prc(Integer rtl_prc) {
        this.rtl_prc = rtl_prc;
    }

    public Integer getSls_prc() {
        return sls_prc;
    }

    public void setSls_prc(Integer sls_prc) {
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

    @Override
    public String toString() {
        return "StockDto{" +
                "pd_id='" + pd_id + '\'' +
                ", pd_clsf_cd='" + pd_clsf_cd + '\'' +
                ", pd_name='" + pd_name + '\'' +
                ", nml_stk_qty=" + nml_stk_qty +
                ", rt_stk_qty=" + rt_stk_qty +
                ", rgn_stk_qty=" + rgn_stk_qty +
                ", urgn_stk_qty=" + urgn_stk_qty +
                ", sfty_stk_qty=" + sfty_stk_qty +
                ", odpmt_stk=" + odpmt_stk +
                ", pur_dt='" + pur_dt + '\'' +
                ", rcpt_dt='" + rcpt_dt + '\'' +
                ", rcpt_cp='" + rcpt_cp + '\'' +
                ", rcpt_prc=" + rcpt_prc +
                ", rtl_prc=" + rtl_prc +
                ", sls_prc=" + sls_prc +
                ", stk_plc_cd='" + stk_plc_cd + '\'' +
                ", stk_stat_cd='" + stk_stat_cd + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockDto stockDto = (StockDto) o;
        return Objects.equals(pd_id, stockDto.pd_id) && Objects.equals(pd_clsf_cd, stockDto.pd_clsf_cd) && Objects.equals(pd_name, stockDto.pd_name) && Objects.equals(nml_stk_qty, stockDto.nml_stk_qty) && Objects.equals(rt_stk_qty, stockDto.rt_stk_qty) && Objects.equals(rgn_stk_qty, stockDto.rgn_stk_qty) && Objects.equals(urgn_stk_qty, stockDto.urgn_stk_qty) && Objects.equals(sfty_stk_qty, stockDto.sfty_stk_qty) && Objects.equals(odpmt_stk, stockDto.odpmt_stk) && Objects.equals(pur_dt, stockDto.pur_dt) && Objects.equals(rcpt_dt, stockDto.rcpt_dt) && Objects.equals(rcpt_cp, stockDto.rcpt_cp) && Objects.equals(rcpt_prc, stockDto.rcpt_prc) && Objects.equals(rtl_prc, stockDto.rtl_prc) && Objects.equals(sls_prc, stockDto.sls_prc) && Objects.equals(stk_plc_cd, stockDto.stk_plc_cd) && Objects.equals(stk_stat_cd, stockDto.stk_stat_cd) && Objects.equals(frst_reg_dt, stockDto.frst_reg_dt) && Objects.equals(frst_reg_id, stockDto.frst_reg_id) && Objects.equals(last_mod_dt, stockDto.last_mod_dt) && Objects.equals(last_mod_id, stockDto.last_mod_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pd_id, pd_clsf_cd, pd_name, nml_stk_qty, rt_stk_qty, rgn_stk_qty, urgn_stk_qty, sfty_stk_qty, odpmt_stk, pur_dt, rcpt_dt, rcpt_cp, rcpt_prc, rtl_prc, sls_prc, stk_plc_cd, stk_stat_cd, frst_reg_dt, frst_reg_id, last_mod_dt, last_mod_id);
    }
}
