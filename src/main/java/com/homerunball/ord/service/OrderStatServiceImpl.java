//package com.homerunball.ord.service;
//
//import com.homerunball.ord.dao.OrderStatDao;
//import com.homerunball.ord.domain.OrderStatDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class OrderStatServiceImpl implements OrderStatService {
//    @Autowired
//    OrderStatDao orderstatDao;
//
//
//    @Override
//    public int getcount() throws Exception{
//        return  orderstatDao.count();
//    }
//
//
//    @Override
//    public int delete(String od_statt_seqnum, String od_id, String c_id) throws Exception{
//        return orderstatDao.delete(od_statt_seqnum,od_id,c_id);
//    }
//
//
//    @Override
//    public int insert(OrderStatDto ord_stat) throws Exception{
//        return orderstatDao.insert(ord_stat);
//    }
//
//}
