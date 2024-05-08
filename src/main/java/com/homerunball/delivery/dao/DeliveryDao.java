package com.homerunball.delivery.dao;

import com.homerunball.delivery.domain.DeliveryDto;
import org.apache.velocity.tools.config.DefaultKey;

import java.util.List;

public interface DeliveryDao {
    /* 회원 1명의 전체 배송지 리스트 조회 */
    List<DeliveryDto> selectAll(int c_id) throws Exception;

    /* 배송받을 배송지 1개 선택해서 보여줌 */
    DeliveryDto select(int c_id, int c_adr_list_id) throws Exception;


        /* 새로운 배송지 입력 */
        /* insert는 반환값이 없어서 returnType이 void이지만, 업데이트 된 행의 갯수를 return 받을 용도로 int를 반환값으로 받고,
            테스트시에 쿼리가 성공적으로 돌았는지 판단할 수 있다. */
        /* insert : insert 된 행의 갯수 반환
           updqte : update 된 행의 갯수 반환(없으면 0). 반환값 cnt 로 받고, cnt > 0
           delete : delete 된 행의 갯수 반환(없으면 0). 반환값 cnt 로 받고, cnt > 0     */
    int insert(DeliveryDto deliveryDto) throws Exception;

    /* 배송지 수정 */
    int update(DeliveryDto deliveryDto) throws Exception;

    /* 기본 배송지 설정 */
    int updateDefaultDlv(DeliveryDto deliveryDto) throws Exception;











    /* ⭐⭐⭐⭐ 물어보기 ⭐⭐⭐⭐*/
    /* returnType, parameter에 DTO가 둘 다 필요없으면, DTO에서 생성자를 안만들어줘도되나???*/

}
