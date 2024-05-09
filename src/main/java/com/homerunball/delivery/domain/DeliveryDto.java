package com.homerunball.delivery.domain;

import java.time.LocalDateTime;

public class DeliveryDto {


    int c_id;   /* 고객 번호 */
    int c_adr_list_id;  /* 고객 배송지 번호 */
    String adr_name;    /* 배송지명 */
    String rcver;   /* 수령자명 */
    String rcver_phn;   /* 수령자 연락처 */
    String rcver_zip;   /* 우편번호 */
    String rcver_adr;   /* 배송지 주소 */
    LocalDateTime frst_reg_dt;  /* 최초 등록일시 */
    String frst_reg_id; /* 최초 등록 식별자 번호 */
    LocalDateTime last_mod_dt;  /* 최종 수정일시 */
    String last_mod_id; /* 최종 수정자 식별번호 */





    /* constructor */
    public DeliveryDto() {}

    /* 메서드? 인터페이스?별로 생성자가 있을 필요 x 모든 변수를 한 생성자에 때려넣으면 됨 */
    public DeliveryDto(int c_id, int c_adr_list_id, String adr_name, String rcver, String rcver_phn, String rcver_zip, String rcver_adr) {
        this.c_id = c_id;
        this.c_adr_list_id = c_adr_list_id;
        this.adr_name = adr_name;
        this.rcver = rcver;
        this.rcver_phn = rcver_phn;
        this.rcver_zip = rcver_zip;
        this.rcver_adr = rcver_adr;
    }

    /* getter setter */

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public int getC_adr_list_id() {
        return c_adr_list_id;
    }

    public void setC_adr_list_id(int c_adr_list_id) {
        this.c_adr_list_id = c_adr_list_id;
    }

    public String getAdr_name() {
        return adr_name;
    }

    public void setAdr_name(String adr_name) {
        this.adr_name = adr_name;
    }

    public String getRcver() {
        return rcver;
    }

    public void setRcver(String rcver) {
        this.rcver = rcver;
    }

    public String getRcver_phn() {
        return rcver_phn;
    }

    public void setRcver_phn(String rcver_phn) {
        this.rcver_phn = rcver_phn;
    }

    public String getRcver_zip() {
        return rcver_zip;
    }

    public void setRcver_zip(String rcver_zip) {
        this.rcver_zip = rcver_zip;
    }

    public String getRcver_adr() {
        return rcver_adr;
    }

    public void setRcver_adr(String rcver_adr) {
        this.rcver_adr = rcver_adr;
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

    /* toString */
    /* toString은 그냥 모든걸 출력되게?해줘야하나... */

    @Override
    public String toString() {
        return "DeliveryDto{" +
                "c_id=" + c_id +
                ", c_adr_list_id=" + c_adr_list_id +
                ", adr_name='" + adr_name + '\'' +
                ", rcver='" + rcver + '\'' +
                ", rcver_phn='" + rcver_phn + '\'' +
                ", rcver_zip='" + rcver_zip + '\'' +
                ", rcver_adr='" + rcver_adr + '\'' +
                ", frst_reg_dt=" + frst_reg_dt +
                ", frst_reg_id='" + frst_reg_id + '\'' +
                ", last_mod_dt=" + last_mod_dt +
                ", last_mod_id='" + last_mod_id + '\'' +
                '}';
    }





    /* equlas */
    /* 이것도 어떤 상황에 넣는건지 모르겠어서 일단 시시때때로 수정되는 그런건 빼고 만들기!  */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeliveryDto)) return false;

        DeliveryDto that = (DeliveryDto) o;

        if (getC_id() != that.getC_id()) return false;
        if (getC_adr_list_id() != that.getC_adr_list_id()) return false;
        if (getAdr_name() != null ? !getAdr_name().equals(that.getAdr_name()) : that.getAdr_name() != null)
            return false;
        if (getRcver() != null ? !getRcver().equals(that.getRcver()) : that.getRcver() != null) return false;
        if (getRcver_phn() != null ? !getRcver_phn().equals(that.getRcver_phn()) : that.getRcver_phn() != null)
            return false;
        if (getRcver_zip() != null ? !getRcver_zip().equals(that.getRcver_zip()) : that.getRcver_zip() != null)
            return false;
        return getRcver_adr() != null ? getRcver_adr().equals(that.getRcver_adr()) : that.getRcver_adr() == null;
    }

    @Override
    public int hashCode() {
        int result = getC_id();
        result = 31 * result + getC_adr_list_id();
        result = 31 * result + (getAdr_name() != null ? getAdr_name().hashCode() : 0);
        result = 31 * result + (getRcver() != null ? getRcver().hashCode() : 0);
        result = 31 * result + (getRcver_phn() != null ? getRcver_phn().hashCode() : 0);
        result = 31 * result + (getRcver_zip() != null ? getRcver_zip().hashCode() : 0);
        result = 31 * result + (getRcver_adr() != null ? getRcver_adr().hashCode() : 0);
        return result;
    }
    /* 객체의 주소값(int)를 이용해 객체 고유의 해시코드를 리턴  */
}


