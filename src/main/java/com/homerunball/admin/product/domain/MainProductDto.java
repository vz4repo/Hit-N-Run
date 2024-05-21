package com.homerunball.admin.product.domain;

import java.util.Objects;

public class MainProductDto {
    private String pd_id;
    private String pd_name;
    private String mdl_name;
    private String mn_img_fn;
    private String pd_ad_cmt;
    private char pd_is_show;
    private String pd_chr_cd;
    private String pd_type_cd;
    private String pd_stat_hist_cd;
    private Integer max_rtl_prc;                //최대 소비자가격
    private Integer max_sls_prc;                //최대 판매가격

    public MainProductDto(String pd_id, String pd_name, String mdl_name, String mn_img_fn, String pd_ad_cmt, char pd_is_show, String pd_chr_cd, String pd_type_cd, String pd_stat_hist_cd, Integer max_rtl_prc, Integer max_sls_prc) {
        this.pd_id = pd_id;
        this.pd_name = pd_name;
        this.mdl_name = mdl_name;
        this.mn_img_fn = mn_img_fn;
        this.pd_ad_cmt = pd_ad_cmt;
        this.pd_is_show = pd_is_show;
        this.pd_chr_cd = pd_chr_cd;
        this.pd_type_cd = pd_type_cd;
        this.pd_stat_hist_cd = pd_stat_hist_cd;
        this.max_rtl_prc = max_rtl_prc;
        this.max_sls_prc = max_sls_prc;
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

    public String getMdl_name() {
        return mdl_name;
    }

    public void setMdl_name(String mdl_name) {
        this.mdl_name = mdl_name;
    }

    public String getMn_img_fn() {
        return mn_img_fn;
    }

    public void setMn_img_fn(String mn_img_fn) {
        this.mn_img_fn = mn_img_fn;
    }

    public String getPd_ad_cmt() {
        return pd_ad_cmt;
    }

    public void setPd_ad_cmt(String pd_ad_cmt) {
        this.pd_ad_cmt = pd_ad_cmt;
    }

    public char getPd_is_show() {
        return pd_is_show;
    }

    public void setPd_is_show(char pd_is_show) {
        this.pd_is_show = pd_is_show;
    }

    public String getPd_chr_cd() {
        return pd_chr_cd;
    }

    public void setPd_chr_cd(String pd_chr_cd) {
        this.pd_chr_cd = pd_chr_cd;
    }

    public String getPd_type_cd() {
        return pd_type_cd;
    }

    public void setPd_type_cd(String pd_type_cd) {
        this.pd_type_cd = pd_type_cd;
    }

    public String getPd_stat_hist_cd() {
        return pd_stat_hist_cd;
    }

    public void setPd_stat_hist_cd(String pd_stat_hist_cd) {
        this.pd_stat_hist_cd = pd_stat_hist_cd;
    }

    public Integer getMax_rtl_prc() {
        return max_rtl_prc;
    }

    public void setMax_rtl_prc(Integer max_rtl_prc) {
        this.max_rtl_prc = max_rtl_prc;
    }

    public Integer getMax_sls_prc() {
        return max_sls_prc;
    }

    public void setMax_sls_prc(Integer max_sls_prc) {
        this.max_sls_prc = max_sls_prc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MainProductDto that = (MainProductDto) o;
        return pd_is_show == that.pd_is_show && Objects.equals(pd_id, that.pd_id) && Objects.equals(pd_name, that.pd_name) && Objects.equals(mdl_name, that.mdl_name) && Objects.equals(mn_img_fn, that.mn_img_fn) && Objects.equals(pd_ad_cmt, that.pd_ad_cmt) && Objects.equals(pd_chr_cd, that.pd_chr_cd) && Objects.equals(pd_type_cd, that.pd_type_cd) && Objects.equals(pd_stat_hist_cd, that.pd_stat_hist_cd) && Objects.equals(max_rtl_prc, that.max_rtl_prc) && Objects.equals(max_sls_prc, that.max_sls_prc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pd_id, pd_name, mdl_name, mn_img_fn, pd_ad_cmt, pd_is_show, pd_chr_cd, pd_type_cd, pd_stat_hist_cd, max_rtl_prc, max_sls_prc);
    }

    @Override
    public String toString() {
        return "MainProductDto{" +
                "pd_id='" + pd_id + '\'' +
                ", pd_name='" + pd_name + '\'' +
                ", mdl_name='" + mdl_name + '\'' +
                ", mn_img_fn='" + mn_img_fn + '\'' +
                ", pd_ad_cmt='" + pd_ad_cmt + '\'' +
                ", pd_is_show=" + pd_is_show +
                ", pd_chr_cd='" + pd_chr_cd + '\'' +
                ", pd_type_cd='" + pd_type_cd + '\'' +
                ", pd_stat_hist_cd='" + pd_stat_hist_cd + '\'' +
                ", max_rtl_prc=" + max_rtl_prc +
                ", max_sls_prc=" + max_sls_prc +
                '}';
    }
}