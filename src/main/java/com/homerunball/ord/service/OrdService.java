package com.homerunball.ord.service;

import com.homerunball.ord.domain.OrdDto;

import java.util.List;

public interface OrdService {
    int getcount() throws Exception;

    int remove(String od_id, String c_id) throws Exception;

    OrdDto read(String od_id) throws Exception;

    int writer(OrdDto ord) throws Exception;

    List<OrdDto> getList() throws Exception;

    int modify(OrdDto ord) throws Exception;
}
