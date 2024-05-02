package com.homerunball.order.service;

import com.homerunball.order.domain.OrdDto;

import java.util.List;

public interface OrdService {
    int getcount() throws Exception;

    int remove(Integer od_id, String c_id) throws Exception;

    OrdDto read(Integer od_id, String c_id) throws Exception;

    int writer(OrdDto ord) throws Exception;

    List<OrdDto> getList() throws Exception;

    int modify(OrdDto ord) throws Exception;
}
