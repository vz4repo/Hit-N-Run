package com.homerunball.admin.stock.service;

import com.homerunball.admin.stock.domain.SizeDto;

import java.util.List;

public interface SizeService {
    /*재고 목록리스트 보여주기*/
    List<SizeDto> getSizeList() throws Exception;
}
