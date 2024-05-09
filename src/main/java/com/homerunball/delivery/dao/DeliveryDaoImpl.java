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

    /* 한 고객의 모든 배송지 목록 조회 */
    @Override
    public List<DeliveryDto> selectAll(int c_id) throws Exception {
        return session.selectList(namespace + "selectAll", c_id);
    }


    /* 주문페이지에서 선택한 배송지 띄우기 */
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

    /* 배송지 리스트 중 하나 선택해서 수정 */
    @Override
    public int update(DeliveryDto deliveryDto) throws Exception {
        return session.update(namespace + "update", deliveryDto);
    }

    /* 기본 배송지 설정 // 고객 테이블에서 변경 */
    @Override
    public int updateDefaultDlv(DeliveryDto deliveryDto) throws Exception {
        return session.update(namespace + "updateDefaultDlv", deliveryDto);
    }

    /* 배송지 리스트 중 하나 삭제 */
    @Override
    public int delete(int c_id, int c_adr_list_id) throws Exception {
        // Map생성
        Map map = new HashMap();

        // Map에 담기
        map.put("c_id", c_id);
        map.put("c_adr_list_id", c_adr_list_id);


        return session.delete(namespace + "delete", map);
    }

    /* 한 고객의 배송지 리스트 전체 삭제 */
    @Override
    public int deleteAllOfOneCust(int c_id) throws Exception {
        return session.delete(namespace + "deleteAllOfOneCust", c_id);
    }

    /* 고객의 배송지 리스트(cust_adr_list) 테이블 모든 row 삭제 */
    @Override
    public int deleteAll() throws Exception {
        return session.delete(namespace + "deleteAll");
    }



    /* ⭐⭐ returyType 확신이 없다....ㅜㅜ⭐⭐ */
    /* 고객의 배송지 리스트(cust_adr_list) 테이블의 모든 row 조회 */
    @Override
    public List<DeliveryDto> selectEveryAdrList() throws Exception {
        return session.selectList(namespace + "selectEveryAdrList");
    }

    /* 한 고객의 배송지 갯수를 카운트해줌 */
    /* Mapper에서 총 행의 갯수를 세어주므로, selectOne 해도 됨 */
    @Override
    public int countAdrList(int c_id) throws Exception {
        return session.selectOne(namespace + "countAdrList", c_id);
    }

    /* 모든 고객의 배송지 갯수 카운트 (cust_adr_list테이블의 전체 row 카운트) */
    @Override
    public int countAll() throws Exception {
        return session.selectOne(namespace + "countAll");
    }
}
