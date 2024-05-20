package com.homerunball.admin.stock.dao;

import com.homerunball.admin.stock.domain.SizeDto;

import java.util.List;

public interface SizeDao {
    /* 제품타입코드에 따른 size 전체 조회 */
    List<SizeDto> selectPdTypeSize() throws Exception;
}
