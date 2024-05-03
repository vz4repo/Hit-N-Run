package com.homerunball.admin.stock.service;

import com.homerunball.admin.stock.domain.StockDto;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertThrows;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class StockServiceImplTest extends TestCase {

    @Autowired
    private StockService stockService;
    private StockDto stockDto;

    /*재고 목록리스트 보여주는 테스트*/
    @Test
    public void testGetList() throws Exception {
        /*0. 테이블 전체 초기화*/
        stockService.removeAll();
        assertTrue(stockService.getCount() == 0);
//
//            /*1. 재고 1개 추가
//             1개 insert 확인 / count = 1, size = 1 확인  */
//        stockDto = new StockDto("APP000001-10", "M","제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
//        assertTrue(stockService.create(stockDto) == 1);
//        assertTrue(stockService.getCount() == 1);
//        assertTrue(stockService.getList().size() == 1);
//
//        /*2. 재고 1개 추가. 총 2개 / insert = 1 확인 / count = 2, size = 2 확인  */
//        stockDto = new StockDto("APP000001-10", "L","제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
//        assertTrue(stockService.create(stockDto) == 1);
//        assertTrue(stockService.getCount() == 2);
//        assertTrue(stockService.getList().size() == 2);
//
//        /*3. 초기화 후 9개 데이터 삽입, count = 9, size = 9 확인*/
//        stockService.removeAll();
//        assertTrue(stockService.getCount() == 0);
//        for (int i = 1; i <= 3; i++) {
//            for (int j = 1; j <= 3; j++) {
//                StockDto stockDto2 = new StockDto(String.format("%04d", j), "M" + i,"제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
//                stockService.create(stockDto2);
//            }
//        }
//        assertTrue(stockService.getCount() == 9);
//        assertTrue(stockService.getList().size() == 9);
//
//        /*4. 초기화 후 9999개 데이터 삽입, count = 9999, size = 9999 확인*/
//        stockService.removeAll();
//        assertTrue(stockService.getCount() == 0);

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3333; j++) {
                StockDto stockDto3 = new StockDto(String.format("%04d", j), "M" + i,"제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
                stockService.create(stockDto3);
            }
        }

        assertTrue(stockService.getCount() == 9999);
        assertTrue(stockService.getList().size() == 9999);
    }

    /*선택한 재고 상품 상세 보여주기 메서드 테스트*/
    @Test
    public void testGetOneStock() throws Exception {
        /*0. 테이블 전체 초기화*/
        stockService.removeAll();
        assertTrue(stockService.getCount() == 0);

        /*1. 재고 1개 추가 / insert = 1 확인 / size = 1 확인*/
        stockDto = new StockDto("APP000001-10", "M","제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
        assertTrue(stockService.create(stockDto) == 1);
        assertTrue(stockService.getList().size() == 1);

        /*1.1. 삽입한 데이터 일치사는지 확인*/
        assertTrue(stockDto.getPd_id().equals("APP000001-10") && stockDto.getPd_clsf_cd().equals("M"));
        assertFalse(stockDto.getPd_clsf_cd().equals("L"));

        /*3. 데이터 전체 삭제 후 총9개 삽입*/
        stockService.removeAll();
        assertTrue(stockService.getCount() == 0);
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                StockDto stockDto2 = new StockDto(String.format("%04d", j), "M" + i,"제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
                stockService.create(stockDto2);
            }
        }
        assertTrue(stockService.getList().size() == 9);

        /*3.1. (1,M1) 선택 시 값이 잘 불러오는지 확인*/
        String pd_id1 = stockService.getList().get(0).getPd_id();
        String pd_clsf_cd1 = stockService.getList().get(0).getPd_clsf_cd();

        StockDto test1 = stockService.getOneStock(pd_id1, pd_clsf_cd1);
        assertNotNull(test1);
        assertTrue(test1.getPd_id().equals(pd_id1) && test1.getPd_clsf_cd().equals(pd_clsf_cd1));
    }

    @Test
    public void testGetCount() throws Exception {
        /*0. 테이블 전체 초기화*/
        stockService.removeAll();
        assertTrue(stockService.getCount() == 0);

        /*1. 재고 1개 추가*/
        stockDto = new StockDto("APP000001-10", "M","제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
        assertTrue(stockService.create(stockDto) == 1);
        assertTrue(stockService.getCount() == 1);

        /*2. 재고 1개 추가*/
        stockDto = new StockDto("APP000001-10", "L","제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
        assertTrue(stockService.create(stockDto) == 1);
        assertTrue(stockService.getCount() == 2);

        /*3. 재고 9개 삽입*/
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                StockDto stockDto = new StockDto(String.format("%04d", j), "M" + i,"제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
                stockService.create(stockDto);
            }
        }
        assertTrue(stockService.getCount() == 11);
    }

    @Test
    public void testCreate() throws Exception {
        /*0. 테이블 전체 초기화*/
        stockService.removeAll();
        assertTrue(stockService.getCount() == 0);

        /*1. 재고 1개 추가*/
        stockDto = new StockDto("APP000001-10", "M","제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
        assertTrue(stockService.create(stockDto) == 1);
        assertTrue(stockService.getCount() == 1);

        /*2. 필수값 누락하고 재고 추가시 오류 되던지기*/
        stockDto = new StockDto(null, "M","제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
        assertThrows(IllegalArgumentException.class, () -> stockService.create(stockDto));

        /*3. 동일한 재고 추가 시 오류 되던지기*/
        stockDto = new StockDto("APP000001-10", "M","제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
        assertThrows(IllegalArgumentException.class, () -> stockService.create(stockDto));

        /*4. 재고 1개 추가 / getCount = 2 */
        stockDto = new StockDto("APP000001-10", "L","제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
        assertTrue(stockService.create(stockDto) == 1);
        assertTrue(stockService.getCount() == 2);

        /*5. 두번째 삽입한 데이터 잘 꺼내오는지 확인*/
        StockDto checkCreate = stockService.getList().get(1);
        assertNotNull(checkCreate);
        assertEquals(stockDto.getPd_id(), checkCreate.getPd_id());
        assertEquals(stockDto.getPd_clsf_cd(), checkCreate.getPd_clsf_cd());
    }

    /*중복 데이터 확인 테스트*/
    @Test
    public void testValidateDuplicateStock() throws Exception {
        /*0. 테이블 전체 초기화*/
        stockService.removeAll();
        assertTrue(stockService.getCount()==0);

        /*1. 재고 1개 추가 / insert = 1 확인 / size = 1 확인*/
        stockDto = new StockDto("APP000001-10", "M","제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
        assertTrue(stockService.create(stockDto) == 1);
        assertTrue(stockService.getList().size() == 1);

        /*2. 첫 삽입 데이터와 동일데이터 삽입 오류 던지는지 확인*/
        stockDto = new StockDto("APP000001-10", "M","제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
        assertThrows(IllegalArgumentException.class, () -> stockService.create(stockDto));
        assertTrue(stockService.getList().size() == 1);
    }

    /*재고 삽입 시 필수값 누락 확인 테스트*/
    @Test
    public void testValidateNotNullStock() throws Exception {
        /*0. 테이블 전체 초기화*/
        stockService.removeAll();
        assertTrue(stockService.getCount()==0);

        /*1. 재고 1개 추가 / insert = 1 확인 / size = 1 확인*/
        stockDto = new StockDto("APP000001-10", "M","제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
        assertTrue(stockService.create(stockDto) == 1);
        assertTrue(stockService.getList().size() == 1);

        /*2. 필수값 누락 삽입 오류 던지는지 확인*/
        stockDto = new StockDto(null, "M","제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
        assertThrows(IllegalArgumentException.class, () -> stockService.create(stockDto));
        assertTrue(stockService.getList().size() == 1);
    }

    @Test
    public void testRemoveAll() throws Exception {
        /*0. 테이블 전체 초기화*/
        stockService.removeAll();
        assertTrue(stockService.getCount()==0);

        /*1. 재고 1개 추가 / insert = 1 확인 / size = 1 확인*/
        stockDto = new StockDto("APP000001-10", "M","제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
        assertTrue(stockService.create(stockDto) == 1);
        assertTrue(stockService.getList().size() == 1);

        /*2. 재고 9개 삽입*/
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                StockDto stockDto = new StockDto(String.format("%04d", j), "M" + i,"제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
                stockService.create(stockDto);
            }
        }
        assertTrue(stockService.getList().size() == 10);

        /*3. 테이블 전체 지우기*/
        stockService.removeAll();
        assertTrue(stockService.getCount()==0);
    }

    @Test
    public void testRemove() throws Exception {
        /*0. 테이블 전체 초기화*/
        stockService.removeAll();
        assertTrue(stockService.getCount()==0);

        /*1. 재고 1개 추가 / insert = 1 확인 / size = 1 확인*/
        stockDto = new StockDto("APP000001-10", "M","제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
        assertTrue(stockService.create(stockDto) == 1);
        assertTrue(stockService.getList().size() == 1);

        /*1.1. 재고 1개 삭제*/
        assertTrue(stockService.remove(stockDto.getPd_id(), stockDto.getPd_clsf_cd()) == 1);
        assertTrue(stockService.getList().size() == 0);

        /*2. 재고 3333개 삽입*/
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 1111; j++) {
                StockDto stockDto = new StockDto(String.format("%04d", j), "M" + i,"제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
                stockService.create(stockDto);
            }
        }
        assertTrue(stockService.getList().size() == 3333);

        /*데이터 1개 꺼낸 후 잘 지워졌는지 확인*/
        String pd_id1 = stockService.getList().get(0).getPd_id();
        String pd_clsf_cd1 = stockService.getList().get(0).getPd_clsf_cd();

        assertTrue(stockService.remove(pd_id1, pd_clsf_cd1) == 1);
        StockDto checkRemove = stockService.getOneStock(pd_id1, pd_clsf_cd1);
        assertNull(checkRemove);
    }

//    @Test
//    public void testModify() throws Exception {
//        /*0. 테이블 전체 초기화*/
//        stockService.removeAll();
//        assertTrue(stockService.getCount()==0);
//    }

//    @Test
//    public void testUpdateStatus() throws Exception {
//        /*0. 테이블 전체 초기화*/
//        stockService.removeAll();
//        assertTrue(stockService.getCount()==0);
//    }
}
