package com.homerunball.customer.dao;

import com.homerunball.customer.domain.CustDto;

/* exception handle */
public interface CustDao {
    int deleteCust(String c_email);

    CustDto selectEmail(String c_email);

    /*리절트타입 CustDto 파마리터타입 int*/
    CustDto selectID(int c_id);

    int insert(CustDto custdto);

    int updateAll(CustDto custdto);

    int deleteAll() throws Exception;

    int updateLoginDt(String c_email);

    CustDto grdNameJoin(int c_id);


}
