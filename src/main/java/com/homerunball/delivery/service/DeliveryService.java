package com.homerunball.delivery.service;

import com.homerunball.delivery.domain.DeliveryDto;

import java.util.List;

public interface DeliveryService {
    /* 주문페이지에서 선택한 배송지 띄우기 */
    List<DeliveryDto> readAll(int c_id) throws Exception;

    /* 주문페이지에서 선택한 배송지 띄우기 */
    DeliveryDto read(int c_id, int c_adr_list_id) throws Exception;

    /* 새로운 배송지 입력 */
    int create(DeliveryDto deliveryDto) throws Exception;

    /* 배송지 리스트 중 하나 선택해서 수정 */
    int update(DeliveryDto deliveryDto) throws Exception;

    /* 기본 배송지 설정 // 고객 테이블에서 변경 */
    int updateDefaultDlv(DeliveryDto deliveryDto) throws Exception;

    /* 배송지 리스트 중 하나 삭제 */
    int removeAllOfOneCust(int c_id) throws Exception;

    /* 배송지 리스트 중 하나 삭제 */
    int remove(int c_id, int c_adr_list_id) throws Exception;

    /* 한 고객의 배송지 리스트 전체 삭제 */
    int removeAll() throws Exception;

    /* 고객의 배송지 리스트(cust_adr_list) 테이블 모든 row 삭제 */
    List<DeliveryDto> readEveryAdrList() throws Exception;

    /* 고객의 배송지 리스트(cust_adr_list) 테이블의 모든 row 조회 */
    int getCountAdrList(int c_id) throws Exception;

    /* 한 고객의 배송지 갯수를 카운트해줌 */
    int getAllCount() throws Exception;
}
