package com.homerunball.admin.stock.service;

import com.homerunball.admin.stock.dao.SizeDao;
import com.homerunball.admin.stock.domain.SizeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeServiceImpl implements SizeService {

    @Autowired
    private SizeDao sizeDao;

    @Override
    public List<SizeDto> getSizeList() throws Exception {
        return sizeDao.selectPdTypeSize();
    }
}
