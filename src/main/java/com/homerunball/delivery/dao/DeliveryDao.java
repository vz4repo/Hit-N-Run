package com.homerunball.delivery.dao;

import com.homerunball.delivery.domain.DeliveryDto;
import org.apache.velocity.tools.config.DefaultKey;

import java.util.List;

public interface DeliveryDao {
    /* 한 고객의 모든 배송지 목록 조회 */
    List<DeliveryDto> selectAll(int c_id) throws Exception;

    /* 주문페이지에서 선택한 배송지 띄우기 */
    DeliveryDto select(int c_id, int c_adr_list_id) throws Exception;

    DeliveryDto selecteDefault(int c_id) throws Exception;

        /* 신규 배송지 입력 */
        /* insert는 반환값이 없어서 returnType이 void이지만, 업데이트 된 행의 갯수를 return 받을 용도로 int를 반환값으로 받고,
            테스트시에 쿼리가 성공적으로 돌았는지 판단할 수 있다. */
        /* insert : insert 된 행의 갯수 반환
           updqte : update 된 행의 갯수 반환(없으면 0). 반환값 cnt 로 받고, cnt > 0
           delete : delete 된 행의 갯수 반환(없으면 0). 반환값 cnt 로 받고, cnt > 0     */
    int insert(DeliveryDto deliveryDto) throws Exception;

    /* 배송지 리스트 중 하나 선택해서 수정 */
    int update(DeliveryDto deliveryDto) throws Exception;

    /* 기본 배송지 설정 // 고객 테이블에서 변경 */
    int updateDefaultDlv(DeliveryDto deliveryDto) throws Exception;

    /* 배송지 리스트 중 하나 삭제 */
    int delete(int c_id, int c_adr_list_id) throws Exception;

    /* 한 고객의 배송지 리스트 전체 삭제 */
    int deleteAllOfOneCust(int c_id) throws Exception;

    /* 고객의 배송지 리스트(cust_adr_list) 테이블 모든 row 삭제 */
    int deleteAll() throws Exception;

    /* 고객의 배송지 리스트(cust_adr_list) 테이블의 모든 row 조회 */
    List<DeliveryDto> selectEveryAdrList() throws Exception;

    /* 한 고객의 배송지 갯수를 카운트해줌 */
    int countAdrList(int c_id) throws Exception;

    /* 모든 고객의 배송지 갯수 카운트 (cust_adr_list테이블의 전체 row 카운트) */
    int countAll() throws Exception;
}
