package com.homerunball.delivery.dao;

import com.homerunball.delivery.domain.DeliveryDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.SpringTransactionAnnotationParser;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})

public class DeliveryDaoImplTest {
    @Autowired /* dao 주입받음 */
    DeliveryDaoImpl deliveryDao;

    /* selectAll() -> c_id가 9001인 회원의 c_adr_list_id의 0번 index가 1이 맞는지 테스트  */
    @Test
    public void selectAllTest1() throws Exception {
        /* 나중에 만들기 */
        /* deliveryDao.deleteAll(); */

        int c_adr_list_id1 = deliveryDao.selectAll(9001).get(0).getC_adr_list_id();
        System.out.println("deliveryDao.selectAll(9001) = " + deliveryDao.selectAll(9001));
        System.out.println("c_adr_list_id1 = " + c_adr_list_id1);
    /* 9001번 id 의 0번 인덱스를 가져오면 배송지 번호는 1 */
        assertEquals(c_adr_list_id1, 1);
    }

    /* selectAll() -> 일부러 잘못된 배송지 번호를 조회했을 때? */
    @Test
    public void selectAllTest2() throws Exception {
        /* 나중에 만들기 */
        /* deliveryDao.deleteAll(); */
        int c_adr_list_id2 = deliveryDao.selectAll(9001).get(1).getC_adr_list_id();
        System.out.println("c_adr_list_id2 = " + c_adr_list_id2);

        /* 9001번 id 의 0번 인덱스를 가져오면 배송지 번호는 1 */
        assertFalse(c_adr_list_id2==1);
    }


    /* select() -> c_id가 9002인 회원의 c_adr_list_id의 2번이 "해삼"인지 테스트 */
    @Test
    public void selectTest1() throws Exception {
        /* 나중에 만들기 */
        /* deliveryDao.deleteAll(); */
        String c_adr_list_id = deliveryDao.select(9002, 2).getRcver();
        System.out.println("c_adr_list_id = " + c_adr_list_id);

        /* 9001번 id 의 0번 인덱스를 가져오면 배송지 번호는 1 */
        assertEquals(c_adr_list_id, "해삼");


        String c_adr_list_id2 = deliveryDao.select(9004, 900004).getRcver();
        System.out.println("c_adr_list_id2 = " + c_adr_list_id2);

        /* 9001번 id 의 0번 인덱스를 가져오면 배송지 번호는 1 */
        assertEquals(c_adr_list_id2, "젤다");
    }


    /* insert() -> 1개 행을 추가했을때 */
    @Test
    public void insertTest1() throws Exception {
        /* 나중에 만들기 */
        /* deliveryDao.deleteAll(); */
        DeliveryDto deliveryDto = new DeliveryDto(1005, "학원", "젤다", "01012341234", "00090", "서울시 강남구 강남대로 미왕빌딩 10층 201호");
        assertTrue(deliveryDao.insert(deliveryDto)==1);
    }
    /* 연속 2개 넣어서 테스트 실패해도 테스트 */


    /* insert() -> 3개 행을 추가했을때 */
    /* 이건 일단 미래의 insert 테스트로 남겨둠. */
    /* TODO : 여러개 insert해서 테스트 하는방법을 모르겠네... -> 근데 어차피 한번에 한개만 insert되자나? 그럼 굳이 여러개 insert 해볼필요가있나? */
    @Test
    public void insertTest2() throws Exception {
        /* 나중에 만들기 */
        /* deliveryDao.deleteAll(); */
        DeliveryDto deliveryDto = new DeliveryDto(1004, "회사", "suyeon", "01056789876", "00090", "서울시 강서구 까치산로 18나길 40");

        assertTrue(deliveryDao.insert(deliveryDto)==1);
    }


    /* update() -> select로 cust_adr_list의 프라이머리 키 2개 끌어와서 dto 객체에 담긴 항목들 업데이트 해줌 */
    @Test
    public void updateTest1() throws Exception {
        /* 나중에 만들기 */
        /* deliveryDao.deleteAll(); */

        DeliveryDto deliveryDto = new DeliveryDto("웅냥냥", "앙냥냥", "01011112222", "54321", "부산광역시 남구 대연동 6-5번지 레이덤오피스텔");
                /* TODO : null 이 된부분은 원래 값 그대로 저장되게 하려면 어케하지?? -> Mapper의 update 아랫부분에 있음*/

        /* select 메서드로, cust_adr_list의 프라이머리 키 2개 저장함 */
        DeliveryDto toUpdate = deliveryDao.select(9004, 900001);
        System.out.println("BF * toUpdate = " + toUpdate);

        /* deliveryDto에, toUpdate의 c_id와 c_adr_list_id 를 넣어서(set) */
        deliveryDto.setC_id(toUpdate.getC_id());
        deliveryDto.setC_adr_list_id(toUpdate.getC_adr_list_id());
        System.out.println("toUpdate.getC_id() = " + toUpdate.getC_id());
        System.out.println("toUpdate.getC_adr_list_id() = " + toUpdate.getC_adr_list_id());


        /* select 로 c_id가 1004, c_adr_list_id가 900005인 애를 찾아서, 업데이트 시키고 업데이트 된 행이 1개인지 확인 */
        System.out.println(" ***** 업데이트 전 ******");
        System.out.println(deliveryDao.select(9004, 900001));
        assertTrue(deliveryDao.update(deliveryDto) == 1);

        System.out.println(" ***** 업데이트 후 ******");
        System.out.println(deliveryDao.select(9004, 900001));


/* DTO 불러와서 map을 끌어올수있다. */
    }




    /* TODO : null 이 된부분은 원래 값 그대로 저장되게 하려면 어케하지?? -> Mapper의 update 아랫부분에 있음*/
    @Test
    public void updateDefaultDlvTest1() throws Exception {
        /* 나중에 만들기 */
        /* deliveryDao.deleteAll(); */

        DeliveryDto deliveryDto = new DeliveryDto(33333);
        /* select 메서드로, cust_adr_list의 프라이머리 키 2개 저장함 */
        DeliveryDto toDefaultDLV = deliveryDao.select(1004, 900007);
        System.out.println("toDefaultDLV = " + toDefaultDLV);

        System.out.println("*****BEFORE*****");
        System.out.println(toDefaultDLV.getC_id());
        System.out.println(toDefaultDLV.getC_adr_list_id());



        /* deliveryDto에, toUpdate의 c_id와 c_adr_list_id 를 넣어서(set) */
        toDefaultDLV.setC_id(deliveryDto.getC_id());
        toDefaultDLV.setC_adr_list_id(deliveryDto.getC_adr_list_id());
        System.out.println("*****AFTER*****");
        System.out.println(toDefaultDLV.getC_id());
        System.out.println(toDefaultDLV.getC_adr_list_id());






        /* select 메서드로, cust_adr_list의 프라이머리 키 2개 저장함 */
//        DeliveryDto toUpdate = deliveryDao.select(9004, 900001);
//        System.out.println("BF * toUpdate = " + toUpdate);

        /* deliveryDto에, toUpdate의 c_id와 c_adr_list_id 를 넣어서(set) */
//        deliveryDto.setC_id(toUpdate.getC_id());
//        deliveryDto.setC_adr_list_id(toUpdate.getC_adr_list_id());
//        System.out.println("toUpdate.getC_id() = " + toUpdate.getC_id());
//        System.out.println("toUpdate.getC_adr_list_id() = " + toUpdate.getC_adr_list_id());
        
        
        
        


//        System.out.println(" ***** 업데이트 전 ******");
//        System.out.println(deliveryDao.updateDefaultDlv());



//
//        /* select 로 c_id가 1004, c_adr_list_id가 900005인 애를 찾아서, 업데이트 시키고 업데이트 된 행이 1개인지 확인 */
//        System.out.println(" ***** 업데이트 전 ******");
//        System.out.println(deliveryDao.select(1004, 900007));
//        assertTrue(deliveryDao.update(deliveryDto) == 1);
//
//        System.out.println(" ***** 업데이트 후 ******");
//        System.out.println(deliveryDao.select(1004, 900007));

        }




    /* 배송지 번호를 입력하지 않았을 때? -> 근데 이건 notnull 인데.... */
}