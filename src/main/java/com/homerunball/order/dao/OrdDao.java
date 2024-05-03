package com.homerunball.order.dao;

import com.homerunball.customer.domain.CustDto;
import com.homerunball.order.domain.OrdDto;
import com.homerunball.order.domain.OrderDetDto;

import java.util.List;

public interface OrdDao {




    String getcid() throws Exception;
    int count() throws Exception; // T selectOne(String statement)

    int delete(Integer od_id, String c_id) throws Exception; // int delete(String statement, Object parameter)

    int deleteAll() throws Exception; // int delete(String statement)

    int insert(OrdDto ord) throws Exception;

    int update(OrdDto ord) throws Exception;

//    static OrdDto select(String od_id) throws Exception; // T selectOne(String statement, Object parameter)

    List<OrdDto> selectAll() throws Exception; // List<E> selectList(String statement)

    List<OrdDto> selectOdId(Integer od_id) throws Exception;

    OrdDto select(Integer od_id, String c_id) throws Exception; // T selectOne(String statement, Object parameter)

}
