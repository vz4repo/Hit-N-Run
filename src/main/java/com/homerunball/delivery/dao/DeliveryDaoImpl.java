package com.homerunball.delivery.dao;

import com.homerunball.cart.domain.CartDto;
import com.homerunball.delivery.domain.DeliveryDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DeliveryDaoImpl implements DeliveryDao {
    @Autowired
    private SqlSession session;

    private String namespace = "com.homerunball.delivery.dao.deliveryMapper.";

    /* 한 회원의 전체 배송지 리스트 띄우기 */
    @Override
    public List<DeliveryDto> selectAll(int c_id) throws Exception {
        return session.selectList(namespace + "selectAll", c_id);
    }


    /* 배송받을 배송지 1개 선택해서 보여줌 */
    /* ⭐⭐⭐⭐ 생각해보기 ⭐⭐⭐⭐*/
        /* @Override 어디는 붙이고 어디는 안붙이는데 그 차이가 뭔지 */
    public DeliveryDto select(int c_id, int c_adr_list_id) throws Exception {
        /* 아런식으로 매개변수가 2개 들어가면, namespace 뒤에 변수 두 개 붙이는게 아니라, map에 담아서 전달해줘야함 */
        // Map생성
        Map map = new HashMap();

        // Map에 담기
        map.put("c_id", c_id);
        map.put("c_adr_list_id", c_adr_list_id);

        return session.selectOne(namespace + "select", map);
    }


    /* 새로운 배송지 입력 */
    @Override
    public int insert(DeliveryDto deliveryDto) throws Exception {
        return session.insert(namespace + "insert", deliveryDto);
    }


    /* 배송지 리스트의 정보 수정 */
    @Override
    public int update(DeliveryDto deliveryDto) throws Exception {
        return session.update(namespace + "update", deliveryDto);
    }

    /* 기본 배송지 설정 */
    @Override
    public int updateDefaultDlv(DeliveryDto deliveryDto) throws Exception {
        return session.update(namespace + "updateDefaultDlv", deliveryDto);
    }



}
