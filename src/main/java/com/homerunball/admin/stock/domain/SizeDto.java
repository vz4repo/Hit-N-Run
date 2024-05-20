package com.homerunball.admin.stock.domain;

import java.util.Date;
import java.util.Objects;

public class SizeDto {
    private String pd_id;                   //제품ID
    private int size_list_id;
    private String pd_type_cd;
    private String pd_clsf_cd;
    private Date frst_reg_dt;               //최초등록일시
    private String frst_reg_id;             //최초등록자
    private Date last_mod_dt;               //최종수정일시
    private String last_mod_id;             //최종수정자

    public String getPd_id() {
        return pd_id;
    }

    public void setPd_id(String pd_id) {
        this.pd_id = pd_id;
    }

    public int getSize_list_id() {
        return size_list_id;
    }

    public void setSize_list_id(int size_list_id) {
        this.size_list_id = size_list_id;
    }

    public String getPd_type_cd() {
        return pd_type_cd;
    }

    public void setPd_type_cd(String pd_type_cd) {
        this.pd_type_cd = pd_type_cd;
    }

    public String getPd_clsf_cd() {
        return pd_clsf_cd;
    }

    public void setPd_clsf_cd(String pd_clsf_cd) {
        this.pd_clsf_cd = pd_clsf_cd;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SizeDto sizeDto = (SizeDto) o;
        return size_list_id == sizeDto.size_list_id && Objects.equals(pd_id, sizeDto.pd_id) && Objects.equals(pd_type_cd, sizeDto.pd_type_cd) && Objects.equals(pd_clsf_cd, sizeDto.pd_clsf_cd) && Objects.equals(frst_reg_dt, sizeDto.frst_reg_dt) && Objects.equals(frst_reg_id, sizeDto.frst_reg_id) && Objects.equals(last_mod_dt, sizeDto.last_mod_dt) && Objects.equals(last_mod_id, sizeDto.last_mod_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pd_id, size_list_id, pd_type_cd, pd_clsf_cd, frst_reg_dt, frst_reg_id, last_mod_dt, last_mod_id);
    }

    @Override
    public String toString() {
        return "SizeDto{" +
                "pd_id='" + pd_id + '\'' +
                ", size_list_id=" + size_list_id +
                ", pd_type_cd='" + pd_type_cd + '\'' +
                ", pd_clsf_cd='" + pd_clsf_cd + '\'' +
                ", frst_reg_dt=" + frst_reg_dt +
                ", frst_reg_id='" + frst_reg_id + '\'' +
                ", last_mod_dt=" + last_mod_dt +
                ", last_mod_id='" + last_mod_id + '\'' +
                '}';
    }
}


