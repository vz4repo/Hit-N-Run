package com.homerunball.order.dao;

import com.homerunball.order.domain.OrdDto;

import java.util.List;

public interface OrdDao {
    int count() throws Exception; // T selectOne(String statement)

    int delete(String od_id, String c_id) throws Exception; // int delete(String statement, Object parameter)

    int deleteAll() throws Exception;

    int insert(OrdDto dto) throws Exception;

    int update(OrdDto dto) throws Exception;

//    static OrdDto select(String od_id) throws Exception; // T selectOne(String statement, Object parameter)

    List<OrdDto> selectAll() throws Exception; // List<E> selectList(String statement)

    List<OrdDto> selectOdId(String od_id) throws Exception;

    List<OrdDto> selectCid(String c_id) throws Exception;

    OrdDto select(String od_id, String c_id) throws Exception; // T selectOne(String statement, Object parameter)

}