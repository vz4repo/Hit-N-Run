package com.homerunball.delivery.service;

import com.homerunball.delivery.dao.DeliveryDao;
import com.homerunball.delivery.domain.DeliveryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    DeliveryDao deliveryDao;

    /* 주문페이지에서 선택한 배송지 띄우기 */
        @Override
    public List<DeliveryDto> readAll(int c_id) throws Exception {
        return deliveryDao.selectAll(c_id);
    }

    /* 주문페이지에서 선택한 배송지 띄우기 */
    @Override
    public DeliveryDto read(int c_id, int c_adr_list_id) throws Exception {
        return deliveryDao.select(c_id, c_adr_list_id);
    }

    /* 새로운 배송지 입력 */
    @Override
    public int create(DeliveryDto deliveryDto) throws Exception {
        return deliveryDao.insert(deliveryDto);
    }

    /* 배송지 리스트 중 하나 선택해서 수정 */
    @Override
    public int update(DeliveryDto deliveryDto) throws Exception {
        return deliveryDao.update(deliveryDto);
    }

    /* 기본 배송지 설정 // 고객 테이블에서 변경 */
    @Override
    public int updatToSetDft(DeliveryDto deliveryDto) throws Exception {
        return deliveryDao.update(deliveryDto);
    }

    /* 배송지 리스트 중 하나 삭제 */
    @Override
    public int remove(int c_id, int c_adr_list_id) throws Exception {
        return deliveryDao.delete(c_id, c_adr_list_id);
    }

    /* 한 고객의 배송지 리스트 전체 삭제 */
    @Override
    public int removeAllOfOneCust(int c_id) throws Exception {
        return deliveryDao.deleteAllOfOneCust(c_id);
    }

    /* 고객의 배송지 리스트(cust_adr_list) 테이블 모든 row 삭제 */
    @Override
    public int removeAll() throws Exception {
        return deliveryDao.deleteAll();
    }

    /* 고객의 배송지 리스트(cust_adr_list) 테이블의 모든 row 조회 */
    @Override
    public List<DeliveryDto> readEveryAdrList() throws Exception {
        return deliveryDao.selectEveryAdrList();
    }

    /* 한 고객의 배송지 갯수를 카운트해줌 */
    @Override
    public int getCountAdrList(int c_id) throws Exception{
        return deliveryDao.countAdrList(c_id);
    }

    @Override
    public int getAllCount() throws Exception {
        return deliveryDao.countAll();
    }
}