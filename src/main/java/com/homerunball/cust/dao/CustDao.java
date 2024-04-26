package com.homerunball.cust.dao;

import com.homerunball.cust.dto.CustDto;

public interface CustDao {
    int deleteCust(String c_email);

    CustDto selectCust(String c_email);

    int insertCust(CustDto cust);

    int updateCust(CustDto cust);
}
