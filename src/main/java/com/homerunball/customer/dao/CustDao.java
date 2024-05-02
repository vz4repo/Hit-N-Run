package com.homerunball.customer.dao;

import com.homerunball.customer.dto.CustDto;

public interface CustDao {
    int deleteCust(String c_email);

    CustDto selectCust(String c_email);

    int insertCust(CustDto custdto) throws Exception;

    int updateCust(CustDto custdto);

    int deleteAll() throws Exception;
}
