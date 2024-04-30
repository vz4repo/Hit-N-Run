package com.homerunball.admin.product.domain;

import java.util.Date;
import java.util.Objects;

public class ProductDto {
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

    public String getMdl_name() {
        return mdl_name;
    }

    public void setMdl_name(String mdl_name) {
        this.mdl_name = mdl_name;
    }

    public String getQlt_cd() {
        return qlt_cd;
    }

    public void setQlt_cd(String qlt_cd) {
        this.qlt_cd = qlt_cd;
    }

    public String getCtg() {
        return ctg;
    }

    public void setCtg(String ctg) {
        this.ctg = ctg;
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

    public Integer getMin_od_qty() {
        return min_od_qty;
    }

    public void setMin_od_qty(int min_od_qty) {
        this.min_od_qty = min_od_qty;
    }

    public Integer getMax_od_qty() {
        return max_od_qty;
    }

    public void setMax_od_qty(int max_od_qty) {
        this.max_od_qty = max_od_qty;
    }

    public char getPd_is_show() {
        return pd_is_show;
    }

    public void setPd_is_show(char pd_is_show) {
        this.pd_is_show = pd_is_show;
    }

    public String getSls_strt_dt() {
        return sls_strt_dt;
    }

    public void setSls_strt_dt(String sls_strt_dt) {
        this.sls_strt_dt = sls_strt_dt;
    }

    public String getPd_mnf_date() {
        return pd_mnf_date;
    }

    public void setPd_mnf_date(String pd_mnf_date) {
        this.pd_mnf_date = pd_mnf_date;
    }

    public String getOg_pd_num() {
        return og_pd_num;
    }

    public void setOg_pd_num(String og_pd_num) {
        this.og_pd_num = og_pd_num;
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

    public String getSrs_id() {
        return srs_id;
    }

    public void setSrs_id(String srs_id) {
        this.srs_id = srs_id;
    }

    public String getAge_grp_cd() {
        return age_grp_cd;
    }

    public void setAge_grp_cd(String age_grp_cd) {
        this.age_grp_cd = age_grp_cd;
    }

    public String getPlayer_nm() {
        return player_nm;
    }

    public void setPlayer_nm(String player_nm) {
        this.player_nm = player_nm;
    }

    public String getMtrl() {
        return mtrl;
    }

    public void setMtrl(String mtrl) {
        this.mtrl = mtrl;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Integer getWgh() {
        return wgh;
    }

    public void setWgh(Integer wgh) {
        this.wgh = wgh;
    }

    public String getClr_cd() {
        return clr_cd;
    }

    public void setClr_cd(String clr_cd) {
        this.clr_cd = clr_cd;
    }

    public Integer getHit_cnt() {
        return hit_cnt;
    }

    public void setHit_cnt(int hit_cnt) {
        this.hit_cnt = hit_cnt;
    }

    public Integer getRvw_cnt() {
        return rvw_cnt;
    }

    public void setRvw_cnt(int rvw_cnt) {
        this.rvw_cnt = rvw_cnt;
    }

    public Integer getWish_cnt() {
        return wish_cnt;
    }

    public void setWish_cnt(int wish_cnt) {
        this.wish_cnt = wish_cnt;
    }

    public String getPd_chr_cd() {
        return pd_chr_cd;
    }

    public void setPd_chr_cd(String pd_chr_cd) {
        this.pd_chr_cd = pd_chr_cd;
    }

    public String getSprt_type_cd() {
        return sprt_type_cd;
    }

    public void setSprt_type_cd(String sprt_type_cd) {
        this.sprt_type_cd = sprt_type_cd;
    }

    public String getPd_type_cd() {
        return pd_type_cd;
    }

    public void setPd_type_cd(String pd_type_cd) {
        this.pd_type_cd = pd_type_cd;
    }

    public String getPd_type_det_cd() {
        return pd_type_det_cd;
    }

    public void setPd_type_det_cd(String pd_type_det_cd) {
        this.pd_type_det_cd = pd_type_det_cd;
    }

    public String getBrd_cd() {
        return brd_cd;
    }

    public void setBrd_cd(String brd_cd) {
        this.brd_cd = brd_cd;
    }

    public String getPd_stat_hist_cd() {
        return pd_stat_hist_cd;
    }

    public void setPd_stat_hist_cd(String pd_stat_hist_cd) {
        this.pd_stat_hist_cd = pd_stat_hist_cd;
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

    private String pd_id;
    private String pd_name;
    private String mdl_name;
    private String qlt_cd;
    private String ctg;
    private String mn_img_fn;
    private String det_img_fn;
    private String pd_ad_cmt;
    private String pd_smr_dsc;
    private String pd_det_dsc;
    private Integer min_od_qty;
    private Integer max_od_qty;
    private char pd_is_show;
    private String sls_strt_dt;
    private String pd_mnf_date;
    private String og_pd_num;
    private String origin;
    private String mfr;
    private String srs_id;
    private String age_grp_cd;
    private String player_nm;
    private String mtrl;
    private String season;
    private Integer wgh;
    private String clr_cd;
    private Integer hit_cnt;
    private Integer rvw_cnt;
    private Integer wish_cnt;
    private String pd_chr_cd;
    private String sprt_type_cd;
    private String pd_type_cd;
    private String pd_type_det_cd;
    private String brd_cd;
    private String pd_stat_hist_cd;
    private Date frst_reg_dt;
    private String frst_reg_id;
    private Date last_mod_dt;
    private String last_mod_id;

    public ProductDto() {}

    public ProductDto(String pd_id, String pd_name, String mdl_name, String qlt_cd, String ctg, String mn_img_fn, String det_img_fn, String pd_ad_cmt, String pd_smr_dsc, String pd_det_dsc, Integer min_od_qty, Integer max_od_qty, char pd_is_show, String sls_strt_dt, String pd_mnf_date, String og_pd_num, String origin, String mfr, String srs_id, String age_grp_cd, String player_nm, String mtrl, String season, Integer wgh, String clr_cd, String pd_chr_cd, String sprt_type_cd, String pd_type_cd, String pd_type_det_cd, String brd_cd) {
        this.pd_id = pd_id;
        this.pd_name = pd_name;
        this.mdl_name = mdl_name;
        this.qlt_cd = qlt_cd;
        this.ctg = ctg;
        this.mn_img_fn = mn_img_fn;
        this.det_img_fn = det_img_fn;
        this.pd_ad_cmt = pd_ad_cmt;
        this.pd_smr_dsc = pd_smr_dsc;
        this.pd_det_dsc = pd_det_dsc;
        this.min_od_qty = min_od_qty;
        this.max_od_qty = max_od_qty;
        this.pd_is_show = pd_is_show;
        this.sls_strt_dt = sls_strt_dt;
        this.pd_mnf_date = pd_mnf_date;
        this.og_pd_num = og_pd_num;
        this.origin = origin;
        this.mfr = mfr;
        this.srs_id = srs_id;
        this.age_grp_cd = age_grp_cd;
        this.player_nm = player_nm;
        this.mtrl = mtrl;
        this.season = season;
        this.wgh = wgh;
        this.clr_cd = clr_cd;
        this.pd_chr_cd = pd_chr_cd;
        this.sprt_type_cd = sprt_type_cd;
        this.pd_type_cd = pd_type_cd;
        this.pd_type_det_cd = pd_type_det_cd;
        this.brd_cd = brd_cd;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "pd_stat_hist_cd='" + pd_stat_hist_cd + '\'' +
                ", brd_cd='" + brd_cd + '\'' +
                ", pd_type_det_cd='" + pd_type_det_cd + '\'' +
                ", pd_type_cd='" + pd_type_cd + '\'' +
                ", sprt_type_cd='" + sprt_type_cd + '\'' +
                ", pd_chr_cd='" + pd_chr_cd + '\'' +
                ", wish_cnt=" + wish_cnt +
                ", rvw_cnt=" + rvw_cnt +
                ", hit_cnt=" + hit_cnt +
                ", clr_cd='" + clr_cd + '\'' +
                ", wgh=" + wgh +
                ", season='" + season + '\'' +
                ", mtrl='" + mtrl + '\'' +
                ", player_nm='" + player_nm + '\'' +
                ", age_grp_cd='" + age_grp_cd + '\'' +
                ", srs_id='" + srs_id + '\'' +
                ", mfr='" + mfr + '\'' +
                ", origin='" + origin + '\'' +
                ", og_pd_num='" + og_pd_num + '\'' +
                ", pd_mnf_date='" + pd_mnf_date + '\'' +
                ", sls_strt_dt=" + sls_strt_dt +
                ", pd_is_show=" + pd_is_show +
                ", max_od_qty=" + max_od_qty +
                ", min_od_qty=" + min_od_qty +
                ", pd_det_dsc='" + pd_det_dsc + '\'' +
                ", pd_smr_dsc='" + pd_smr_dsc + '\'' +
                ", pd_ad_cmt='" + pd_ad_cmt + '\'' +
                ", det_img_fn='" + det_img_fn + '\'' +
                ", mn_img_fn='" + mn_img_fn + '\'' +
                ", ctg='" + ctg + '\'' +
                ", qlt_cd='" + qlt_cd + '\'' +
                ", mdl_name='" + mdl_name + '\'' +
                ", pd_name='" + pd_name + '\'' +
                ", pd_id='" + pd_id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return pd_is_show == that.pd_is_show && Objects.equals(pd_id, that.pd_id) && Objects.equals(pd_name, that.pd_name) && Objects.equals(mdl_name, that.mdl_name) && Objects.equals(qlt_cd, that.qlt_cd) && Objects.equals(ctg, that.ctg) && Objects.equals(mn_img_fn, that.mn_img_fn) && Objects.equals(det_img_fn, that.det_img_fn) && Objects.equals(pd_ad_cmt, that.pd_ad_cmt) && Objects.equals(pd_smr_dsc, that.pd_smr_dsc) && Objects.equals(pd_det_dsc, that.pd_det_dsc) && Objects.equals(min_od_qty, that.min_od_qty) && Objects.equals(max_od_qty, that.max_od_qty) && Objects.equals(sls_strt_dt, that.sls_strt_dt) && Objects.equals(pd_mnf_date, that.pd_mnf_date) && Objects.equals(og_pd_num, that.og_pd_num) && Objects.equals(origin, that.origin) && Objects.equals(mfr, that.mfr) && Objects.equals(srs_id, that.srs_id) && Objects.equals(age_grp_cd, that.age_grp_cd) && Objects.equals(player_nm, that.player_nm) && Objects.equals(mtrl, that.mtrl) && Objects.equals(season, that.season) && Objects.equals(wgh, that.wgh) && Objects.equals(clr_cd, that.clr_cd) && Objects.equals(hit_cnt, that.hit_cnt) && Objects.equals(rvw_cnt, that.rvw_cnt) && Objects.equals(wish_cnt, that.wish_cnt) && Objects.equals(pd_chr_cd, that.pd_chr_cd) && Objects.equals(sprt_type_cd, that.sprt_type_cd) && Objects.equals(pd_type_cd, that.pd_type_cd) && Objects.equals(pd_type_det_cd, that.pd_type_det_cd) && Objects.equals(brd_cd, that.brd_cd) && Objects.equals(pd_stat_hist_cd, that.pd_stat_hist_cd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pd_id, pd_name, mdl_name, qlt_cd, ctg, mn_img_fn, det_img_fn, pd_ad_cmt, pd_smr_dsc, pd_det_dsc, min_od_qty, max_od_qty, pd_is_show, sls_strt_dt, pd_mnf_date, og_pd_num, origin, mfr, srs_id, age_grp_cd, player_nm, mtrl, season, wgh, clr_cd, hit_cnt, rvw_cnt, wish_cnt, pd_chr_cd, sprt_type_cd, pd_type_cd, pd_type_det_cd, brd_cd, pd_stat_hist_cd);
    }
}