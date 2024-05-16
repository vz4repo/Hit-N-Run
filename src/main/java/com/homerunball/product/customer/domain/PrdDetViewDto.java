// prd + stk + rltd_pd table 사용중 아님
package com.homerunball.product.customer.domain;

import java.util.Objects;

public class PrdDetViewDto {
    private String pd_id;
    private String pd_name;
    private String qlt_cd;
    private String mn_img_fn;
    private String det_img_fn;
    private String pd_ad_cmt;
    private String pd_smr_dsc;
    private String pd_det_dsc;
    private int min_od_qty;
    private int max_od_qty;
    private String pd_mnf_date;
    private String origin;
    private String mfr;
    private String age_grp_cd;
    private String mtrl;
    private String pd_clsf_cd;
    private int nml_stk_qty;
    private int rcpt_prc;
    private int rtl_prc;
    private int sls_prc;
    private String rltd_pd_id;
    private int rltd_pd_seqnum;

    @Override
    public String toString() {
        return "PrdDetViewDto{" +
                "pd_id='" + pd_id + '\'' +
                ", pd_name='" + pd_name + '\'' +
                ", qlt_cd='" + qlt_cd + '\'' +
                ", mn_img_fn='" + mn_img_fn + '\'' +
                ", det_img_fn='" + det_img_fn + '\'' +
                ", pd_ad_cmt='" + pd_ad_cmt + '\'' +
                ", pd_smr_dsc='" + pd_smr_dsc + '\'' +
                ", pd_det_dsc='" + pd_det_dsc + '\'' +
                ", min_od_qty=" + min_od_qty +
                ", max_od_qty=" + max_od_qty +
                ", pd_mnf_date='" + pd_mnf_date + '\'' +
                ", origin='" + origin + '\'' +
                ", mfr='" + mfr + '\'' +
                ", age_grp_cd='" + age_grp_cd + '\'' +
                ", mtrl='" + mtrl + '\'' +
                ", pd_clsf_cd='" + pd_clsf_cd + '\'' +
                ", nml_stk_qty=" + nml_stk_qty +
                ", rcpt_prc=" + rcpt_prc +
                ", rtl_prc=" + rtl_prc +
                ", sls_prc=" + sls_prc +
                ", rltd_pd_id='" + rltd_pd_id + '\'' +
                ", rltd_pd_seqnum=" + rltd_pd_seqnum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrdDetViewDto that = (PrdDetViewDto) o;
        return min_od_qty == that.min_od_qty && max_od_qty == that.max_od_qty && nml_stk_qty == that.nml_stk_qty && rcpt_prc == that.rcpt_prc && rtl_prc == that.rtl_prc && sls_prc == that.sls_prc && rltd_pd_seqnum == that.rltd_pd_seqnum && Objects.equals(pd_id, that.pd_id) && Objects.equals(pd_name, that.pd_name) && Objects.equals(qlt_cd, that.qlt_cd) && Objects.equals(mn_img_fn, that.mn_img_fn) && Objects.equals(det_img_fn, that.det_img_fn) && Objects.equals(pd_ad_cmt, that.pd_ad_cmt) && Objects.equals(pd_smr_dsc, that.pd_smr_dsc) && Objects.equals(pd_det_dsc, that.pd_det_dsc) && Objects.equals(pd_mnf_date, that.pd_mnf_date) && Objects.equals(origin, that.origin) && Objects.equals(mfr, that.mfr) && Objects.equals(age_grp_cd, that.age_grp_cd) && Objects.equals(mtrl, that.mtrl) && Objects.equals(pd_clsf_cd, that.pd_clsf_cd) && Objects.equals(rltd_pd_id, that.rltd_pd_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pd_id, pd_name, qlt_cd, mn_img_fn, det_img_fn, pd_ad_cmt, pd_smr_dsc, pd_det_dsc, min_od_qty, max_od_qty, pd_mnf_date, origin, mfr, age_grp_cd, mtrl, pd_clsf_cd, nml_stk_qty, rcpt_prc, rtl_prc, sls_prc, rltd_pd_id, rltd_pd_seqnum);
    }

    public String getPd_id() {
        return pd_id;
    }

    public void setPd_id(String pd_id) {
        this.pd_id = pd_id;
    }

    public String getPd_name() {
        return pd_name;
    }

    public void setPd_name(String pd_name) {
        this.pd_name = pd_name;
    }

    public String getQlt_cd() {
        return qlt_cd;
    }

    public void setQlt_cd(String qlt_cd) {
        this.qlt_cd = qlt_cd;
    }

    public String getMn_img_fn() {
        return mn_img_fn;
    }

    public void setMn_img_fn(String mn_img_fn) {
        this.mn_img_fn = mn_img_fn;
    }

    public String getDet_img_fn() {
        return det_img_fn;
    }

    public void setDet_img_fn(String det_img_fn) {
        this.det_img_fn = det_img_fn;
    }

    public String getPd_ad_cmt() {
        return pd_ad_cmt;
    }

    public void setPd_ad_cmt(String pd_ad_cmt) {
        this.pd_ad_cmt = pd_ad_cmt;
    }

    public String getPd_smr_dsc() {
        return pd_smr_dsc;
    }

    public void setPd_smr_dsc(String pd_smr_dsc) {
        this.pd_smr_dsc = pd_smr_dsc;
    }

    public String getPd_det_dsc() {
        return pd_det_dsc;
    }

    public void setPd_det_dsc(String pd_det_dsc) {
        this.pd_det_dsc = pd_det_dsc;
    }

    public int getMin_od_qty() {
        return min_od_qty;
    }

    public void setMin_od_qty(int min_od_qty) {
        this.min_od_qty = min_od_qty;
    }

    public int getMax_od_qty() {
        return max_od_qty;
    }

    public void setMax_od_qty(int max_od_qty) {
        this.max_od_qty = max_od_qty;
    }

    public String getPd_mnf_date() {
        return pd_mnf_date;
    }

    public void setPd_mnf_date(String pd_mnf_date) {
        this.pd_mnf_date = pd_mnf_date;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getMfr() {
        return mfr;
    }

    public void setMfr(String mfr) {
        this.mfr = mfr;
    }

    public String getAge_grp_cd() {
        return age_grp_cd;
    }

    public void setAge_grp_cd(String age_grp_cd) {
        this.age_grp_cd = age_grp_cd;
    }

    public String getMtrl() {
        return mtrl;
    }

    public void setMtrl(String mtrl) {
        this.mtrl = mtrl;
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

    public String getRltd_pd_id() {
        return rltd_pd_id;
    }

    public void setRltd_pd_id(String rltd_pd_id) {
        this.rltd_pd_id = rltd_pd_id;
    }

    public int getRltd_pd_seqnum() {
        return rltd_pd_seqnum;
    }

    public void setRltd_pd_seqnum(int rltd_pd_seqnum) {
        this.rltd_pd_seqnum = rltd_pd_seqnum;
    }
}
