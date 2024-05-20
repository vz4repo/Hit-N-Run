package com.homerunball.admin.stock.dao;

import com.homerunball.admin.stock.domain.SizeDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SizeDaoImpl implements SizeDao{

    @Autowired
    private SqlSession session;
    private static String namespace = "com.homerunball.admin.stock.dao.sizeMapper.";

    public List<SizeDto> selectPdTypeSize() throws Exception {
        List<SizeDto> sizeDtoList = session.selectList(namespace+"selectPdTypeSize");
        return sizeDtoList;
    }
}
