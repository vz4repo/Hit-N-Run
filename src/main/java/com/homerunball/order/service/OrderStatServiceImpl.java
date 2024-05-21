package com.homerunball.order.service;

import com.homerunball.order.dao.OrderStatDao;
import com.homerunball.order.domain.OrderStatDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderStatServiceImpl implements com.homerunball.order.service.OrderStatService {
    @Autowired
    OrderStatDao orderstatDao;


    @Override
    public int getcount() throws Exception{
        return  orderstatDao.count();
    }


    @Override
    public int delete(int od_stat_seqnum, int od_id) throws Exception{
        return orderstatDao.delete(od_stat_seqnum,od_id);
    }


    @Override
    public int insert(OrderStatDto ord_stat) throws Exception{
        return orderstatDao.insert(ord_stat);
    }

}
