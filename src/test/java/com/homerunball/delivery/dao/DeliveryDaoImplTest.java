package com.homerunball.delivery.dao;

import com.homerunball.admin.product.domain.ProductDto;
import com.homerunball.customer.dao.CustDaoImpl;
import com.homerunball.customer.domain.CustDto;
import com.homerunball.delivery.domain.DeliveryDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})

public class DeliveryDaoImplTest {
    @Autowired /* dao 주입받음 */
    DeliveryDaoImpl deliveryDao;
    @Autowired
    CustDaoImpl custDao;

    /* selectAll() -한 고객의 모든 배송지 목록 조회 */
    @Test
    public void selectAllTest() throws Exception {
        /*0. db 서버가 실행되지 않을 때 테스트하기*/
        try {
        /* DB 초기화 */
        deliveryDao.deleteAll();
        assertTrue(deliveryDao.countAll() == 0);


        /* 1) 1001 고객의 배송지 리스트 1개 추가했을 때 */
        DeliveryDto deliveryDto1 = new DeliveryDto(1001, 1, "집1", "포차코", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
        assertTrue(deliveryDao.insert(deliveryDto1) == 1);
        /* 1-1) 테이블의 모든 행 갯수 확인 +  0번 index가 1인지 확인 */
        assertTrue(deliveryDao.countAll() == 1);
        assertTrue(deliveryDao.selectAll(1001).get(0).getC_adr_list_id() == 1);
        /* 1-2) 1001 고객의 배송지 리스트 1개 더 추가 했을 때, 테이블의 모든 행 갯수가 2인지 확인? +  1번 인덱스의 adr_name이 집2인지 확인*/
        DeliveryDto deliveryDto2 = new DeliveryDto(1001, 2, "집2", "포차코", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
        assertTrue(deliveryDao.insert(deliveryDto2) == 1);
        assertTrue(deliveryDao.countAll() == 2);
        System.out.println(deliveryDao.selectAll(1001).get(1).getAdr_name());
        assertTrue(deliveryDao.selectAll(1001).get(1).getAdr_name().equals("집2"));


        /* DB 초기화 */
        deliveryDao.deleteAll();
        assertTrue(deliveryDao.countAll() == 0);

        /* 2) 배송지 리스트에 100 개의 데이터 추가했을 때, 100개의 데이터가 다 보이는지? */
        DeliveryDto deliveryDto = new DeliveryDto();
        for(int i = 0; i < 100; i++) {
            deliveryDto = new DeliveryDto(2222, i, "회사2", "이클립스", "12312341234", "44444", "부산광역시 남구 수영로 36-9 201호");
            deliveryDao.insert(deliveryDto);
        } assertTrue(deliveryDao.selectAll(2222).size() == 100);
        /* 99번째 인덱스의 c_adr_list_id 가 100인지 확인 */
        System.out.println(deliveryDao.selectAll(2222).get(99).getC_adr_list_id());
        assertTrue(deliveryDao.selectAll(2222).get(99).getC_adr_list_id() == 99);


        /* 3) selectAll() -> 일부러 잘못된 배송지 번호를 조회했을 때? */
        int wrongNum = deliveryDao.selectAll(2222).get(0).getC_adr_list_id();
        System.out.println("wrongNum 배송지 번호 = " + wrongNum);
        assertFalse(wrongNum == 2);    // 1002고객의 0번 idnex의 실제 배송지번호는 1임.
    } catch (MyBatisSystemException e) {
        System.out.println("MySql Server Stopped");
    }
    }


    /* 주문페이지에서 선택한 배송지 띄우기 */
    @Test
    public void selectTest() throws Exception {
        /*0. db 서버가 실행되지 않을 때 테스트하기*/
        try {
        /* DB 초기화 */
        deliveryDao.deleteAll();
        assertTrue(deliveryDao.countAll() == 0);


        /* 1) 1001 고객의 1번 c_adr_list_id의 adr_name은? => 집1 / rcver는? => 포차코 */
        DeliveryDto deliveryDto1 = new DeliveryDto(1001, 1, "집1", "포차코", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
        assertTrue(deliveryDao.insert(deliveryDto1) == 1);
        assertTrue(deliveryDao.select(1001, 1).getAdr_name().equals("집1"));
        assertTrue(deliveryDao.select(1001, 1).getRcver().equals("포차코"));


        /* 2) 1002 고객의 1번 c_adr_list_id의 adr_name은? => 집2 / rcver는? -=> 웅냥냥 */
        DeliveryDto deliveryDto2 = new DeliveryDto(1002, 1, "회사1", "웅냥냥", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
        assertTrue(deliveryDao.insert(deliveryDto2) == 1);
        assertTrue(deliveryDao.select(1002, 1).getAdr_name().equals("회사1"));
        assertTrue(deliveryDao.select(1002, 1).getRcver().equals("웅냥냥"));

        /* 3) 일부러 잘못된 수신자명을 입력? */
        System.out.println("wrongName = " + deliveryDao.select(1002, 1).getRcver().equals("양양이"));
        assertFalse(deliveryDao.select(1002, 1).getRcver().equals("풍풍이"));
        } catch (MyBatisSystemException e) {
            System.out.println("MySql Server Stopped");
        }
    }


    @Test
    public void insertTest() throws Exception {
        /*0. db 서버가 실행되지 않을 때 테스트하기*/
        try {
            /* DB 초기화 */
            deliveryDao.deleteAll();
            assertTrue(deliveryDao.countAll() == 0);

            DeliveryDto deliveryDto4 = new DeliveryDto(1001, 4, "집4", "파파고", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
            DeliveryDto deliveryDto5 = new DeliveryDto(1002, 1, "회사1", "웅냥냥", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
            DeliveryDto deliveryDto6 = new DeliveryDto(1002, 2, "회사2", "양양이", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");


            /* 1) c_id가 1001번인 고객의 배송지 리스트 1개 추가 + 1개 행을 추가했을때, 테이블의 총 row 갯수.*/
            DeliveryDto deliveryDto1 = new DeliveryDto(1001, 1, "집1", "포차코", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
            assertTrue(deliveryDao.insert(deliveryDto1) == 1);
            assertTrue(deliveryDao.countAll() == 1);


            /* 2) c_id가 1001번인 고객의 배송지 리스트 2개 추가. + 2개 행을 추가했을때, 테이블의 총 row 갯수*/
            DeliveryDto deliveryDto2 = new DeliveryDto(1001, 2, "집2", "품품이", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
            DeliveryDto deliveryDto3 = new DeliveryDto(1001, 3, "집3", "퐁퐁이", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
            assertTrue(deliveryDao.insert(deliveryDto2) == 1);
            assertTrue(deliveryDao.insert(deliveryDto3) == 1);
            assertTrue(deliveryDao.countAll() == 3);


            /* DB 초기화 */
            deliveryDao.deleteAll();
            assertTrue(deliveryDao.countAll() == 0);


            DeliveryDto deliveryDto = new DeliveryDto();

            /* 3) 100개 넣어보고 갯수 확인 */
            for (int i = 0; i < 100; i++) {
                deliveryDto = new DeliveryDto(2222, i, "회사2", "이클립스", "12312341234", "44444", "부산광역시 남구 수영로 36-9 201호");
                assertTrue(deliveryDao.insert(deliveryDto) == 1);
            }
            assertTrue(deliveryDao.countAll() == 100);

            /* 3-1) 1000개 넣어보고 갯수 확인 */
            for (int i = 100; i < 1100; i++) {
                deliveryDto = new DeliveryDto(2222, i, "회사2", "이클립스", "12312341234", "44444", "부산광역시 남구 수영로 36-9 201호");
                assertTrue(deliveryDao.insert(deliveryDto) == 1);
            }
            assertTrue(deliveryDao.countAll() == 1100);

            /* DB 초기화 */
            deliveryDao.deleteAll();
            assertTrue(deliveryDao.countAll() == 0);

            /* 4) 중복 데이터 넣어보기 */
            for (int i = 0; i < 5; i++) {
                deliveryDto = new DeliveryDto(2222, i, "회사2", "이클립스", "12312341234", "44444", "부산광역시 남구 수영로 36-9 201호");
                assertTrue(deliveryDao.insert(deliveryDto) == 1);
            }
            assertTrue(deliveryDao.countAll() == 5);
            assertTrue(deliveryDao.select(2222, 4).getC_adr_list_id() == 4);
        } catch (MyBatisSystemException e) {
            System.out.println("MySql Server Stopped");
        }
    }


    @Test
    public void updateTest() throws Exception {
        try {
            /* DB 초기화 */
            deliveryDao.deleteAll();
            assertTrue(deliveryDao.countAll() == 0);

            /* 1. 고객 배송지 리스트 1개 생성 c_id : 1001, c_adr_list_id : 1 */
            DeliveryDto deliveryDto1 = new DeliveryDto(1001, 1, "집1", "포차코", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
            assertTrue(deliveryDao.insert(deliveryDto1) == 1);

            /* 1-1). deliveryDto1 의 adr_name 을 "움막" 으로 바꿔줌 */
            deliveryDto1.setAdr_name("움막");

            /* 1-2). 1001 - 1 을 deliveryDto1 로 업데이트 */
            assertTrue(deliveryDao.update(deliveryDto1) == 1);

            /* 1-3). 1001 - 1 의 adr_name 이 "움막"으로 바뀌었는지 확인 */
            assertTrue(deliveryDao.select(1001, 1).getAdr_name().equals("움막"));


            /* 한번에 여러개 수정하기 */
            /* 2. 고객 배송지 리스트 1개 생성 c_id : 1001, c_adr_list_id : 2 */
            DeliveryDto deliveryDto2 = new DeliveryDto(1001, 2, "집2", "품품이", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
            assertTrue(deliveryDao.insert(deliveryDto2) == 1);

            /* 2-1). deliveryDto2 의 adr_name 을 "초갓집", rcver를 "풍뇽뇽" 으로 바꿔줌 */
            deliveryDto2.setAdr_name("초갓집");
            deliveryDto2.setRcver("풍뇽뇽");

            /* 2-2). 1001 - 2 를 deliveryDto2 로 업데이트 */
            assertTrue(deliveryDao.update(deliveryDto2) == 1);

            /* 2-3). 1001 - 1 의 adr_name 이 "초갓집", rcver가 "풍뇽뇽"으로 바뀌었는지 확인 */
            assertTrue(deliveryDao.select(1001, 2).getAdr_name().equals("초갓집"));
            assertTrue(deliveryDao.select(1001, 2).getRcver().equals("풍뇽뇽"));


            /* 여러 배송지 리스트를 동시에 수정 */
            /* 3. 고객 배송지 리스트 1개 생성 c_id : 1002, c_adr_list_id : 1 / 2 */
            DeliveryDto deliveryDto3 = new DeliveryDto(1002, 1, "회사1", "웅냥냥", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
            assertTrue(deliveryDao.insert(deliveryDto3) == 1);

            /* 3-1). deliveryDto2, deliveryDto3 에 저장 */
            deliveryDto2.setAdr_name("움막");
            deliveryDto3.setAdr_name("동굴");

            /* 3-2). 1001-2/ 1001-1을 deliveryDto2 / deliveryDto3 으로 업데이트 */
            assertTrue(deliveryDao.update(deliveryDto2) == 1);
            assertTrue(deliveryDao.update(deliveryDto3) == 1);

            /* 3-3) 1002 - 1/2 의 adr_name 이 "움막"/"동굴", rcver가 "용용이"/"양음메 로 바뀌었는지 확인 */
            assertTrue(deliveryDao.select(1001, 2).getAdr_name().equals("움막"));
            assertTrue(deliveryDao.select(1002, 1).getAdr_name().equals("동굴"));


            /* 업데이트 불가능한 변수를 업데이트 시도했을 때? */
            /* 3. 고객 배송지 리스트 1개 생성 c_id : 1001, c_adr_list_id : 3 */
            DeliveryDto deliveryDto4 = new DeliveryDto(1001, 3, "집3", "퐁퐁이", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
            assertTrue(deliveryDao.insert(deliveryDto4) == 1);

            /* 3-1). deliveryDto4 의 c_id를 2222로, rcver를 퐁퐁퐁으로 바꿔줌 */
            deliveryDto4.setAdr_name("심해");
//            deliveryDto3.setC_id(2222);
            deliveryDto4.setRcver("퐁퐁퐁");

            /* 3-2). 1001 - 2 를 deliveryDto2 로 업데이트 */
            assertTrue(deliveryDao.update(deliveryDto4) == 1);

            /* 3-3). 1001 - 1 의 adr_name 이 "초갓집", rcver가 "풍뇽뇽"으로 바뀌었는지 확인 */
            assertFalse(deliveryDao.select(1001, 3).getC_id() == 2222);
            assertTrue(deliveryDao.select(1001, 3).getRcver().equals("퐁퐁퐁"));

            /* => 수정 허면 안되는 값이 들어가면, 그 값뿐만 아니라 같이 들어갔던 다른 값들도 다 업데이트 안됨! */
        } catch (NullPointerException e) {
            System.out.println("NullPointerException 발생");
        } catch (MyBatisSystemException e) {
            System.out.println("MySql Server Stopped");
        }
    }
    /* TODO : 업데이트 할 떄 null 이 된부분은 원래 값 그대로 저장되게 하려면 어케하지?? -> Mapper의 update 아랫부분에 있음*/




















//        DeliveryDto deliveryDto1 = new DeliveryDto(1001, 1, "집1", "포차코", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
//        DeliveryDto deliveryDto2 = new DeliveryDto(1001, 2, "집2", "품품이", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
//        DeliveryDto deliveryDto3 = new DeliveryDto(1001, 3, "집3", "퐁퐁이", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
//        DeliveryDto deliveryDto4 = new DeliveryDto(1001, 4, "집4", "파파고", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
//        DeliveryDto deliveryDto5 = new DeliveryDto(1002, 1, "회사1", "웅냥냥", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
//        DeliveryDto deliveryDto6 = new DeliveryDto(1002, 2, "회사2", "양양이", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");





    /* TODO : ⭐⭐⭐⭐⭐⭐ updateDefaultDlvTest1() 는 고객테이블 건드려야해서 나중에 하기 ⭐⭐⭐⭐⭐⭐*/
    @Test
    public void updateDefaultDlvTest() throws Exception {
        try {
            /* DB 초기화 */
         deliveryDao.deleteAll();
         assertTrue(deliveryDao.countAll() == 0);

         /*테스트 중복방지*/
         custDao.deleteAll();

         /*고객 정보 추가*/
            CustDto custDto = new CustDto("pompom@naver.com", "1234", "퐁퐁이", "9203012", "F", "01012345678", "01234", "서울시 강서구 까치산로", "12", "1011", "N", "N");
            /*추가된 고객을 DB에 저장*/
            assertTrue(custDao.insert(custDto) == 1);

            /* 추가된 고객 제대로 있는지 확인 */
            assertTrue(custDao.selectEmail("pompom@naver.com").getC_name().equals("퐁퐁이"));

            /* custDto에 연결된 cust_adr_list 5개 추가*/
            DeliveryDto deliveryDto = new DeliveryDto();

            int cust_num = custDao.selectEmail("pompom@naver.com").getC_id();
            System.out.println("cust_num = " + cust_num);

            for(int i=1; i<6; i++) {
//                deliveryDto = new DeliveryDto(cust_num, "초갓집", "남궁푸린", "01012341234", "성남시 정자동 어쩌구 저쩌구 12");
// 0521 김수연 여기까지 하다 끝.

            }




//            /* love@naver.com 고객의 배송지 3개 추가 */
//            for(int i = 1; i < 4; i++) {
//                deliveryDto = new DeliveryDto(Integer.parseInt(custId), i, "초갓집", "독수리", "01011112222", "12345", "성남시 정자동 어쩌구 저쩌구 14-15");
//                assertTrue(deliveryDao.insert(deliveryDto) == 1);
//            } assertTrue(deliveryDao.countAdrList(Integer.parseInt(custId)) == 3);


//         CustDto toUpdateDfltAddr =



//            int rowCnt = custDao.insertCust(custdto);
//            /*저장 성공*/
//            assertTrue(rowCnt == 1);
//            /* 고객의 DEFAULT c_adr_list_id 를 확인 = null */
//            String custId = custDao.selectEmail("love@naver.com").getC_id();
//            System.out.println("custId = " + custId);
//            System.out.println("custDao.selectID(100006).getC_dlv_adr() = " + custDao.selectID(Integer.parseInt(custId)).getC_dlv_adr());
//
//            /* love@naver.com 고객의 배송지 3개 추가 */
//            for(int i = 1; i < 4; i++) {
//                deliveryDto = new DeliveryDto(Integer.parseInt(custId), i, "초갓집", "독수리", "01011112222", "12345", "성남시 정자동 어쩌구 저쩌구 14-15");
//                assertTrue(deliveryDao.insert(deliveryDto) == 1);
//            } assertTrue(deliveryDao.countAdrList(Integer.parseInt(custId)) == 3);
//
//            /* love@naver.com 고객의 배송지 리스트가 1,2,3이 맞는지 확인 */
//            for(int i = 1; i < 4; i++) {
//                assertTrue(deliveryDao.select(Integer.parseInt(custId), i).getC_adr_list_id() == i);
//            }
//
            /* love@naver.com 고객의 배송지 리스트 2를 cust테이블의 c_adr_list_id 로 업데이트 */
//            String default_c_adr_list_id = String.valueOf(deliveryDao.select(100012, 2).getC_adr_list_id());
//            System.out.println("default_c_adr_list_id = " + default_c_adr_list_id);
//            custdto.setC_dlv_adr(default_c_adr_list_id);
//
//            assertTrue(custDao.update(custdto));
//
        } catch (MyBatisSystemException e) {
            System.out.println("MySql Server Stopped");
        }
    }


















    @Test
    public void deleteTest() throws Exception {
        try {
            /* DB 초기화 */
         deliveryDao.deleteAll();;
         assertTrue(deliveryDao.countAll() == 0);

            /* 1) c_id 가 1001 인 c_adr_list_id가 1인 고객의 배송지 리스트 1개 추가.*/
            DeliveryDto deliveryDto1 = new DeliveryDto(1001, 1, "집1", "포차코", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
            assertTrue(deliveryDao.insert(deliveryDto1) == 1);
            /* 1-1) c_id가 1001인 고객의 총 배송지 수 확인 (count) = 1 + 배송지리스트 테이블 전체 행 갯수 확인(countAll) = 1 */
            assertTrue(deliveryDao.countAll() == 1);
            /* 1-2) c_id가 1001, c_adr_list_id가 1인 행 삭제 (delete) */
            assertTrue(deliveryDao.delete(1001, 1) == 1);
            /* 1-3) c_id가 1001인 고객의 총 배송지 수 확인 (count) = 0 + 배송지리스트 테이블 전체 행 갯수 확인(countAll) = 0 */
            assertTrue(deliveryDao.countAll() == 0);


            /* DB 초기화 */
            deliveryDao.deleteAll();;
            assertTrue(deliveryDao.countAll() == 0);


            /* 3) 한번에 데이터 50개 삭제 후 남은 데이터 갯수 확인 */
            DeliveryDto deliveryDto = new DeliveryDto();

            /* 100개 넣어보고 갯수 확인  */
            for (int i = 0; i < 100; i++) {
                deliveryDto = new DeliveryDto(2222, i, "회사"+i, "이클립스", "12312341234", "44444", "부산광역시 남구 수영로 36-9 201호");
                assertTrue(deliveryDao.insert(deliveryDto) == 1);
            }
            assertTrue(deliveryDao.countAll() == 100);
            assertTrue(deliveryDao.select(2222, 3).getAdr_name().equals("회사3") );

            /* 데이터 50개 한번에 삭제 */
            for (int i = 0; i < 50; i++) {
                assertTrue(deliveryDao.delete(2222, i) == 1);
            }
            assertTrue(deliveryDao.countAll() == 50);

        } catch (MyBatisSystemException e) {
            System.out.println("MySql Server Stopped");
        }
    }



    @Test
    public void deleteAllOfOneCustTest() throws Exception {
        try {
            /* DB 초기화 */
            deliveryDao.deleteAll();;
            assertTrue(deliveryDao.countAll() == 0);


            /* 1) 배송지 1개 추가, 모든 고객의 배숭지갯수 countAll(), 고객의 배송지주소=1 확인 */
            DeliveryDto deliveryDto = new DeliveryDto(1001, 1, "집1", "포차코", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
            assertTrue(deliveryDao.insert(deliveryDto) == 1);
            assertTrue(deliveryDao.countAll() == 1);
            assertTrue(deliveryDao.select(1001, 1).getC_adr_list_id() == 1);

            /* 1001 고객의 배송지 모두 삭제 (deleteAllOfOneCust) */
                /* TODO : delete 여러행을 하면, assertTrue에서 영향 끼친 행만큼의 숫자를 반환한다. */
            assertTrue(deliveryDao.deleteAllOfOneCust(1001) == 1);
            assertTrue(deliveryDao.countAdrList(1001) == 0);


            /* DB 초기화 */
            deliveryDao.deleteAll();;
            assertTrue(deliveryDao.countAll() == 0);

            /* 2) 1001 / 1002 고객의 배송지 100개씩 추가 */
            DeliveryDto deliveryDto1 = new DeliveryDto();
            DeliveryDto deliveryDto2 = new DeliveryDto();
            /* 100개 넣어보고 갯수 확인  */
            for (int i = 0; i < 100; i++) {
                deliveryDto1 = new DeliveryDto(1111, i, "회사"+i, "이클립스", "12312341234", "44444", "부산광역시 남구 수영로 36-9 201호");
                deliveryDto2 = new DeliveryDto(2222, i, "집"+i, "이클립스", "12312341234", "44444", "부산광역시 남구 수영로 36-9 201호");
                assertTrue(deliveryDao.insert(deliveryDto1) == 1);
                assertTrue(deliveryDao.insert(deliveryDto2) == 1);
            }
            assertTrue(deliveryDao.countAll() == 200);
            assertTrue(deliveryDao.deleteAllOfOneCust(1111) == 100);
            assertTrue(deliveryDao.countAll() == 100);
            assertTrue(deliveryDao.countAdrList(2222) == 100);
            assertTrue(deliveryDao.select(2222, 3).getAdr_name().equals("집3") );

        } catch (MyBatisSystemException e) {
            System.out.println("MySql Server Stopped");
        }
    }



    @Test
    public void deleteAll() throws Exception {
        try {
            /* DB 초기화 */
            deliveryDao.deleteAll();
            assertTrue(deliveryDao.countAll() == 0);

            DeliveryDto deliveryDto2 = new DeliveryDto(1001, 2, "집2", "품품이", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
            DeliveryDto deliveryDto3 = new DeliveryDto(1001, 3, "집3", "퐁퐁이", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
            DeliveryDto deliveryDto4 = new DeliveryDto(1001, 4, "집4", "파파고", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
            DeliveryDto deliveryDto5 = new DeliveryDto(1002, 1, "회사1", "웅냥냥", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
            DeliveryDto deliveryDto6 = new DeliveryDto(1002, 2, "회사2", "양양이", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");


            /* 1)  고객 배송지 데이터 1개 삽입 + 고객 배송지 총갯수 카운트 =1 */
            DeliveryDto deliveryDto1 = new DeliveryDto(1001, 1, "집1", "포차코", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
            assertTrue(deliveryDao.insert(deliveryDto1) == 1);
            assertTrue(deliveryDao.countAll() == 1);
            /* 고객 배송지 테이블 전체 삭제 (deleteAll) */
            assertTrue(deliveryDao.deleteAll() == 1);
            /*  고객 배송지 총 갯수 카운트 = 0 */
            assertTrue(deliveryDao.countAll() == 0);


            /* 2) 고객 배송지 데이터 1개 더 삽입 + 고객 배송지 총갯수 카운트=6 */
            assertTrue(deliveryDao.insert(deliveryDto1) == 1);
            assertTrue(deliveryDao.insert(deliveryDto2) == 1);
            assertTrue(deliveryDao.countAll() == 2);
            /* 고객 배송지 테이블 전체 삭제 (deleteAll) */
            assertTrue(deliveryDao.deleteAll() == 2);
            /* 고객 배송지 총 갯수 카운트 = 0 */
            assertTrue(deliveryDao.countAll() == 0);


            /* 3) 고객 배송지 데이터 100개 삽입 + 고객 배송지 총갯수 카운트=100 */
            DeliveryDto deliveryDto = new DeliveryDto();

            for (int i = 0; i < 100; i++) {
                deliveryDto = new DeliveryDto(2222, i, "회사2", "이클립스", "12312341234", "44444", "부산광역시 남구 수영로 36-9 201호");
                assertTrue(deliveryDao.insert(deliveryDto) == 1);
            }  assertTrue(deliveryDao.countAll() == 100);
            /* 고객 배송지 테이블 전체 삭제 (deleteAll) */
            assertTrue(deliveryDao.deleteAll() == 100);
            /* 고객 배송지 총 갯수 카운트 = 0 */
            assertTrue(deliveryDao.countAll() == 0);
        } catch (MyBatisSystemException e) {
            System.out.println("MySql Server Stopped");
        }
    }


    /* 고객의 배송지 리스트(cust_adr_list) 테이블의 모든 row 조회 */
    @Test
    public void selectEveryAdrList() throws Exception {
        try {
            /* DB 초기화 */
            deliveryDao.deleteAll();;
            assertTrue(deliveryDao.countAll() == 0);

            DeliveryDto deliveryDto3 = new DeliveryDto(1001, 3, "집3", "퐁퐁이", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
            DeliveryDto deliveryDto4 = new DeliveryDto(1001, 4, "집4", "파파고", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
            DeliveryDto deliveryDto5 = new DeliveryDto(1002, 1, "회사1", "웅냥냥", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
            DeliveryDto deliveryDto6 = new DeliveryDto(1002, 2, "회사2", "양양이", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");


            /* 1) 고객 배송지 데이터 1개 추가 + 고객 테이블의 모든 row  세기= 1 */
            DeliveryDto deliveryDto1 = new DeliveryDto(1001, 1, "집1", "포차코", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
            assertTrue(deliveryDao.insert(deliveryDto1) == 1);
            assertTrue(deliveryDao.selectEveryAdrList().size() == 1);
            assertTrue(deliveryDao.selectEveryAdrList().get(0).getRcver_adr().equals("부산광역시 남구 수영로 36-9 201호"));

            /* DB 초기화 */
            deliveryDao.deleteAll();;
            assertTrue(deliveryDao.countAll() == 0);

            /* 2) 고객 배송지 데이터 2개 추가 + 고객 테이블의 모든 row 세기 = 6*/
            DeliveryDto deliveryDto2 = new DeliveryDto(1001, 2, "집2", "품품이", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
            assertTrue(deliveryDao.insert(deliveryDto1) == 1);
            assertTrue(deliveryDao.insert(deliveryDto2) == 1);
            assertTrue(deliveryDao.selectEveryAdrList().size() == 2);
            assertTrue(deliveryDao.selectEveryAdrList().get(0).getAdr_name().equals("집1"));
            assertTrue(deliveryDao.selectEveryAdrList().get(1).getRcver().equals("품품이"));

            /* DB 초기화 */
            deliveryDao.deleteAll();;
            assertTrue(deliveryDao.countAll() == 0);


            /* 3) 고객 배송지 데이터 80개 추가 + 고객 테이블의 모든 row 세기 = 80 */
            DeliveryDto deliveryDto = new DeliveryDto();
            for (int i = 0; i < 80; i++) {
                deliveryDto = new DeliveryDto(2222, i, "회사2", "이클립스"+i, "12312341234", "44444", "부산광역시 남구 수영로 36-9 201호");
                assertTrue(deliveryDao.insert(deliveryDto) == 1);
            }  assertTrue(deliveryDao.selectEveryAdrList().size() == 80);
            assertTrue(deliveryDao.selectEveryAdrList().get(77).getRcver().equals("이클립스77"));

//            /* DB 초기화 */
//            deliveryDao.deleteAll();;
//            assertTrue(deliveryDao.countAll() == 0);

            /* 3-1) 2222 고객의 1번 데이터 update + 고객 테이블의 모든 row 세기 = 80 */
            DeliveryDto sample = new DeliveryDto(2222, 1, "회사2", "이클립스1", "12312341234", "44444", "부산광역시 남구 수영로 36-9 201호");
            System.out.println("포문돌린것 : " + deliveryDao.select(2222,1));
            System.out.println("sampleDATA : " + sample);
            assertTrue(deliveryDao.update(sample) == 1);

            sample.setRcver_adr("산리오월드");
            assertTrue(deliveryDao.update(sample) == 1);
            assertTrue(deliveryDao.selectEveryAdrList().size() == 80);
            assertTrue(deliveryDao.selectEveryAdrList().get(1).getRcver_adr().equals("산리오월드"));
                    

        } catch (MyBatisSystemException e) {
            System.out.println("MySql Server Stopped");
        }
    }


    /* 한 고객의 배송지 갯수를 카운트해줌 */
    @Test
    public void countAdrList() throws Exception {
        try {
            /* DB 초기화 */
            deliveryDao.deleteAll();;
            assertTrue(deliveryDao.countAll() == 0);

            /* 1001 고객의 배송지 1개 추가하고, 1001 고객의 총 배송지 갯수 확인 = 1*/
            DeliveryDto deliveryDto1 = new DeliveryDto(1001, 1, "집1", "포차코", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
            assertTrue(deliveryDao.insert(deliveryDto1) == 1);
            assertTrue(deliveryDao.countAdrList(1001) == 1);

            /* 1001 고객의 배송지 1개 더 추가하고, 1001 고객의 총 배송지 갯수 확인 = 2 */
            DeliveryDto deliveryDto2 = new DeliveryDto(1001, 2, "집2", "품품이", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
            assertTrue(deliveryDao.insert(deliveryDto2) == 1);
            assertTrue(deliveryDao.countAdrList(1001) == 2);

            /* 1001 고객의 배송지 1개 삭제하고, 1001 고객의 총 배송지 갯수 확인 = 1 */
            assertTrue(deliveryDao.delete(1001, 1) == 1);
            assertTrue(deliveryDao.countAdrList(1001) == 1);

            /* DB 초기화 */
            deliveryDao.deleteAll();;
            assertTrue(deliveryDao.countAll() == 0);

            /* 2222 고객의 배송지 100개 추가하고, 2222 고객의 총 배송지 갯수 = 100b확인 */
            DeliveryDto deliveryDto = new DeliveryDto();
            for (int i = 0; i < 100; i++) {
                deliveryDto = new DeliveryDto(2222, i, "회사2", "이클립스", "12312341234", "44444", "부산광역시 남구 수영로 36-9 201호");
                assertTrue(deliveryDao.insert(deliveryDto) == 1);
            }  assertTrue(deliveryDao.countAdrList(2222) == 100);

            /* 2222 고객의 배송지 40개 삭제 후, 2222 고객의 총 배송지 갯수 = 60 */
            for (int i = 0; i < 40; i++) {
                assertTrue(deliveryDao.delete(2222, i) == 1);
            }  assertTrue(deliveryDao.countAdrList(2222) == 60);

        } catch (MyBatisSystemException e) {
            System.out.println("MySql Server Stopped");
        }
    }


    @Test
    public void countAll() throws Exception {
        try {
            /* DB 초기화 */
            deliveryDao.deleteAll();;
            assertTrue(deliveryDao.countAll() == 0);

//            DeliveryDto deliveryDto3 = new DeliveryDto(1001, 3, "집3", "퐁퐁이", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
//            DeliveryDto deliveryDto4 = new DeliveryDto(1001, 4, "집4", "파파고", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
//            DeliveryDto deliveryDto5 = new DeliveryDto(1002, 1, "회사1", "웅냥냥", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
//            DeliveryDto deliveryDto6 = new DeliveryDto(1002, 2, "회사2", "양양이", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");

            /* 1001의 배송지 1개 추가 후, 전체 고객 배송지 갯수 확인 */
            DeliveryDto deliveryDto1 = new DeliveryDto(1001, 1, "집1", "포차코", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
            assertTrue(deliveryDao.insert(deliveryDto1) == 1);
            assertTrue(deliveryDao.countAll() == 1);

            /* 1002 배송지 1개 더 추가 후, 전체 고객 배송지 갯수 확인 */
            DeliveryDto deliveryDto2 = new DeliveryDto(1001, 2, "집2", "품품이", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
            assertTrue(deliveryDao.insert(deliveryDto2) == 1);
            assertTrue(deliveryDao.countAll() == 2);

            /* DB 초기화 */
            deliveryDao.deleteAll();;
            assertTrue(deliveryDao.countAll() == 0);

            /* 배송지 100개 추가 후,  */
            /* 2222 고객의 배송지 100개 추가하고, 2222 고객의 총 배송지 갯수 = 100개확인 */
            DeliveryDto deliveryDto = new DeliveryDto();
            for (int i = 0; i < 100; i++) {
                deliveryDto = new DeliveryDto(2222, i, "회사2", "이클립스", "12312341234", "44444", "부산광역시 남구 수영로 36-9 201호");
                assertTrue(deliveryDao.insert(deliveryDto) == 1);
            }   assertTrue(deliveryDao.countAll() == 100);

            /* 2222 고객의 배송지 40개 삭제 후, 2222 고객의 총 배송지 갯수 = 60 */
            for (int i = 0; i < 40; i++) {
                assertTrue(deliveryDao.delete(2222, i) == 1);
            }  assertTrue(deliveryDao.countAll() == 60);

            /* 1111 고객의 배송지 20개 추가 후, 1111 고객의 총 배송지 갯수 = 80 */
            for (int i = 0; i < 20; i++) {
                deliveryDto = new DeliveryDto(1111, i, "회사2", "이클립스", "12312341234", "44444", "부산광역시 남구 수영로 36-9 201호");
                assertTrue(deliveryDao.insert(deliveryDto) == 1);
            }   assertTrue(deliveryDao.countAll() == 80);



        } catch (MyBatisSystemException e) {
            System.out.println("MySql Server Stopped");
        }



    }


@Test
    public void 선택한주소_출력() throws Exception {

    DeliveryDto deliveryDto = deliveryDao.select(100012, 0);
    System.out.println("deliveryDto = " + deliveryDto.toString());
}









}