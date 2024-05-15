// rltd_pd table 현재 사용중 아님
// 아직 생성자 안 만들었다.
// 완료 : 변수입력, getter, setter, toString()
// equals(), hashcode() null값 제외하고 생성함
package com.homerunball.product.customer.domain;

import java.util.Date;
import java.util.Objects;

public class RelatedPrdViewDto {
    private int rltd_pd_seqnum;
    private String pd_id;
    private String rltd_pd_id;
    private Date frst_reg_dt;
    private String frst_reg_id;
    private Date last_mod_dt;
    private String last_mod_id;

    @Override
    public String toString() {
        return "RelatedPrdViewDto{" +
                "rltd_pd_seqnum=" + rltd_pd_seqnum +
                ", pd_id='" + pd_id + '\'' +
                ", rltd_pd_id='" + rltd_pd_id + '\'' +
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
        RelatedPrdViewDto that = (RelatedPrdViewDto) o;
        return rltd_pd_seqnum == that.rltd_pd_seqnum && Objects.equals(pd_id, that.pd_id) && Objects.equals(rltd_pd_id, that.rltd_pd_id) && Objects.equals(frst_reg_id, that.frst_reg_id) && Objects.equals(last_mod_id, that.last_mod_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rltd_pd_seqnum, pd_id, rltd_pd_id, frst_reg_id, last_mod_id);
    }

    public int getRltd_pd_seqnum() {
        return rltd_pd_seqnum;
    }

    public void setRltd_pd_seqnum(int rltd_pd_seqnum) {
        this.rltd_pd_seqnum = rltd_pd_seqnum;
    }

    public String getPd_id() {
        return pd_id;
    }

    public void setPd_id(String pd_id) {
        this.pd_id = pd_id;
    }

    public String getRltd_pd_id() {
        return rltd_pd_id;
    }

    public void setRltd_pd_id(String rltd_pd_id) {
        this.rltd_pd_id = rltd_pd_id;
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
