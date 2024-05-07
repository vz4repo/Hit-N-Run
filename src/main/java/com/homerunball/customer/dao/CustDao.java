package com.homerunball.customer.dao;

import com.homerunball.customer.domain.CustDto;

/* exception handle */
public interface CustDao {
    int deleteCust(String c_email);

    CustDto selectEmail(String c_email);

    CustDto selectID(int c_id);


    int insertCust(CustDto custdto);

    int updateCust(CustDto custdto);

    int deleteAll() throws Exception;

    int updateLoginDate(String c_email);


}
