package com.homerunball.admin.stock.dao;

import com.homerunball.admin.stock.domain.StockDto;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertThrows;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class StockDaoImplTest extends TestCase {

    @Autowired
    private StockDao stockDao;
    private StockDto stockDto;

    /*모든 재고 선택 테스트*/
    @Test
    public void testSelectStkAll() throws Exception {
        /*0. 테이블 전체 초기화*/
        stockDao.deleteAll();
        assertTrue(stockDao.count() == 0);

        /*1. 재고 1개 추가
             1개 insert 확인 / count = 1, size = 1 확인  */
        stockDto = new StockDto("APP000001-10", "M", "제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
        assertTrue(stockDao.insertStk(stockDto) == 1);
        assertTrue(stockDao.count() == 1);
        assertTrue(stockDao.selectStkAll().size() == 1);

        /*2. 재고 1개 추가. 총 2개 / 1개 insert 확인 / count = 2, size = 2 확인  */
        /*2.1. 첫 삽입 데이터와 동일데이터 삽입: false 인지 확인*/
        stockDto = new StockDto("APP000001-10", "M","제품명제품명",10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
        assertThrows(DuplicateKeyException.class, () -> stockDao.insertStk(stockDto));
        assertTrue(stockDao.count() == 1);
        assertTrue(stockDao.selectStkAll().size() == 1);

        /*2.2. 첫 삽입 데이터와 다른데이터 삽입: true 인지 확인*/
        stockDto = new StockDto("APP000001-10", "L","제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
        assertTrue(stockDao.insertStk(stockDto) == 1);   /*중복데이터 삽입시 오류남. 중복확인하는 메서트 추가.. isDuplicateStock으로 중복검사 코드 추가*/
        assertTrue(stockDao.count() == 2);
        assertTrue(stockDao.selectStkAll().size() == 2);

        /*3. 초기화 후 9개 데이터 삽입, count = 9, size = 9 확인*/
        stockDao.deleteAll();
        assertTrue(stockDao.count() == 0);
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                StockDto stockDto2 = new StockDto(String.format("%04d", j), "M" + i,"제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
                stockDao.insertStk(stockDto2);
            }
        }
        assertTrue(stockDao.count() == 9);
        assertTrue(stockDao.selectStkAll().size() == 9);

        /*4. 초기화 후 9999개 데이터 삽입, count = 9999, size = 9999 확인*/
        stockDao.deleteAll();
        assertTrue(stockDao.count() == 0);

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3333; j++) {
                StockDto stockDto3 = new StockDto(String.format("%04d", j), "M" + i,"제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
                stockDao.insertStk(stockDto3);
            }
        }

        assertTrue(stockDao.count() == 9999);
        assertTrue(stockDao.selectStkAll().size() == 9999);

        /*(5555,M1), (5555,M2), (5555,M3) 개별 삭제 후 size 9996 확인*/
        String pd_id1 = stockDao.selectStkAll().get(5554).getPd_id();
        String m1 = stockDao.selectStkAll().get(5554).getPd_clsf_cd();

        String pd_id2 = stockDao.selectStkAll().get(5555).getPd_id();
        String m2 = stockDao.selectStkAll().get(5555).getPd_clsf_cd();

        String pd_id3 = stockDao.selectStkAll().get(5556).getPd_id();
        String m3 = stockDao.selectStkAll().get(5556).getPd_clsf_cd();

        assertTrue(stockDao.delete(pd_id1, m1) == 1);
        assertTrue(stockDao.count() == 9998);
        assertTrue(stockDao.selectStkAll().size() == 9998);

        assertTrue(stockDao.delete(pd_id2, m2) == 1);
        assertTrue(stockDao.count() == 9997);
        assertTrue(stockDao.selectStkAll().size() == 9997);

        assertTrue(stockDao.delete(pd_id3, m3) == 1);
        assertTrue(stockDao.count() == 9996);
        assertTrue(stockDao.selectStkAll().size() == 9996);
    }

    /*재고 1개 선택(제품ID + 사이즈코드) 테스트*/
    @Test
    public void testSelectStk() throws Exception {
        /*0. 테이블 전체 초기화*/
        stockDao.deleteAll();
        assertTrue(stockDao.count() == 0);

        /*1. 재고 1개 추가 후 1개 insert 확인*/
        stockDto = new StockDto("APP000001-10", "M", "제품명제품명",10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
        assertTrue(stockDao.insertStk(stockDto) == 1);
        assertTrue(stockDao.count() == 1);

        /*2. 데이터 선택*/
        /*2.1. 추가한 데이터에서 pd_id와 pd_clsf_cd 가져오기*/
        String pd_id = stockDao.selectStkAll().get(0).getPd_id();
        String pd_clsf_cd = stockDao.selectStkAll().get(0).getPd_clsf_cd();

        /*2.2. 구매일자 같은지 확인*/
        StockDto stockDto2 = stockDao.selectStk(pd_id, pd_clsf_cd);
        assertTrue(stockDto2.getPur_dt().equals("20240325"));
        /*2.2. insert한 구매일자와 다른 값 넣었을 때 false인지 확인*/
        assertFalse(stockDto2.getPur_dt().equals("20240425"));

        /*3. 데이터 전체 삭제 후 (같은제어번호 + 다른사이즈코드) 3*3 총9개 삽입*/
        stockDao.deleteAll();
        assertTrue(stockDao.count() == 0);
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                StockDto stockDto3 = new StockDto(String.format("%04d", j), "M" + i, "제품명제품명",10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
                stockDao.insertStk(stockDto3);
            }
        }
        /*3.1. 총 9개 삽입 됐는지 확인*/
        assertTrue(stockDao.count() == 9);

        /*3.2. (1,M1), (1,M2), (1,M3), 선택 후
               정상적으로 값이 불러져 오는지 확인
               - selectStkAll은 오름차순 정렬이다. */
        String pd_id1 = stockDao.selectStkAll().get(0).getPd_id();
        String pd_id2 = stockDao.selectStkAll().get(1).getPd_id();
        String pd_id3 = stockDao.selectStkAll().get(2).getPd_id();
        String m1 = stockDao.selectStkAll().get(0).getPd_clsf_cd();
        String m2 = stockDao.selectStkAll().get(1).getPd_clsf_cd();
        String m3 = stockDao.selectStkAll().get(2).getPd_clsf_cd();

        StockDto test1 = stockDao.selectStk(pd_id1, m1);
        StockDto test2 = stockDao.selectStk(pd_id2, m2);
        StockDto test3 = stockDao.selectStk(pd_id3, m3);
        assertTrue(test1.getPd_id().equals("0001") && test1.getPd_clsf_cd().equals("M1"));
        assertTrue(test2.getPd_id().equals("0001") && test2.getPd_clsf_cd().equals("M2"));
        assertTrue(test3.getPd_id().equals("0001") && test3.getPd_clsf_cd().equals("M3"));
    }

    /*재고 전체 수량 카운트*/
    @Test
    public void testCount() throws Exception {
        /*0. 테이블 전체 초기화*/
        stockDao.deleteAll();
        assertTrue(stockDao.count() == 0);

        /*1. 재고 1개 추가
             1개 insert 확인 / count = 1 확인  */
        stockDto = new StockDto("APP000001-10", "M","제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
        assertTrue(stockDao.insertStk(stockDto) == 1);
        assertTrue(stockDao.count() == 1);

        /*2. 재고 1개 추가. 총 2개 / 1개 insert 확인 / count = 2 확인  */
        stockDto = new StockDto("APP000001-10", "L", "제품명제품명",10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
        assertTrue(stockDao.insertStk(stockDto) == 1);   /*중복데이터 삽입시 오류남. 중복확인하는 메서트 추가.. isDuplicateStock으로 중복검사 코드 추가*/
        assertTrue(stockDao.count() == 2);

        /*3. 9개 데이터 삽입, count = 11 */
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                StockDto stockDto2 = new StockDto(String.format("%04d", j), "M" + i, "제품명제품명",10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
                stockDao.insertStk(stockDto2);
            }
        }
        assertTrue(stockDao.count() == 11);

        /*4. 초기화 후 3333개 데이터 삽입, count = 3333 확인*/
        stockDao.deleteAll();
        assertTrue(stockDao.count() == 0);

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 1111; j++) {
                StockDto stockDto3 = new StockDto(String.format("%04d", j), "M" + i,"제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
                stockDao.insertStk(stockDto3);
            }
        }
        assertTrue(stockDao.count() == 3333);
    }

    /*모든 재고 삭제*/
    @Test
    public void testDeleteAll() throws Exception {
        /*0. 테이블 전체 초기화*/
        stockDao.deleteAll();
        assertTrue(stockDao.count() == 0);

        /*1. 재고 1개 추가
             1개 insert 확인 / count = 1 확인  */
        stockDto = new StockDto("APP000001-10", "M", "제품명제품명",10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
        assertTrue(stockDao.insertStk(stockDto) == 1);
        assertTrue(stockDao.count() == 1);

        /*2. 재고 1개 추가. 총 2개 / 1개 insert 확인 / count = 2 확인  */
        stockDto = new StockDto("APP000001-10", "L","제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
        assertTrue(stockDao.insertStk(stockDto) == 1);
        assertTrue(stockDao.count() == 2);

        /*3. 9개 데이터 삽입, count = 11 */
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                StockDto stockDto2 = new StockDto(String.format("%04d", j), "M" + i,"제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
                stockDao.insertStk(stockDto2);
            }
        }
        assertTrue(stockDao.count() == 11);

        /*4. 초기화 후 count = 0 확인*/
        stockDao.deleteAll();
        assertTrue(stockDao.count() == 0);

        /*5. 데이터 3333개 데이터 삽입, count = 3333 확인*/
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 1111; j++) {
                StockDto stockDto3 = new StockDto(String.format("%04d", j), "M" + i,"제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
                stockDao.insertStk(stockDto3);
            }
        }
        assertTrue(stockDao.count() == 3333);

        /*5.1. 초기화 후 count = 0 확인*/
        stockDao.deleteAll();
        assertTrue(stockDao.count() == 0);
    }

    /*재고 1개 삭제(지정된 제품ID, 사이즈코드 선택)*/
    @Test
    public void testDelete() throws Exception {
        /*0. 테이블 전체 초기화*/
        stockDao.deleteAll();
        assertTrue(stockDao.count() == 0);

        /*1. 재고 1개 추가
             1개 insert 확인 / count = 1 확인  */
        stockDto = new StockDto("APP000001-10", "M","제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
        assertTrue(stockDao.insertStk(stockDto) == 1);
        assertTrue(stockDao.count() == 1);

        /*2. 재고 1개 추가. 총 2개 / 1개 insert 확인 / count = 2 확인  */
        stockDto = new StockDto("APP000001-10", "L","제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
        assertTrue(stockDao.insertStk(stockDto) == 1);
        assertTrue(stockDao.count() == 2);

        /*3. 처음 삽입한 데이터 select 해서 값 일치하는지 확인 */
        String pd_id = stockDao.selectStkAll().get(0).getPd_id();
        String pd_clsf_cd = stockDao.selectStkAll().get(0).getPd_clsf_cd();
        assertTrue(pd_id.equals("APP000001-10"));
        assertTrue(pd_clsf_cd.equals("M"));

        /*3.1. 선택한 데이터 삭제 후 잘 지워졌는지 확인 / count 1 확인*/
        assertTrue(stockDao.delete(pd_id, pd_clsf_cd) == 1);
        StockDto chechDeleted = stockDao.selectStk(pd_id, pd_clsf_cd);
        assertNull(chechDeleted);
        assertTrue(stockDao.count() == 1);

        /*4. 초기화 후 count = 0 확인*/
        stockDao.deleteAll();
        assertTrue(stockDao.count() == 0);

        /*5. 데이터 3333개 데이터 삽입, count = 3333 확인*/
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 1111; j++) {
                StockDto stockDto3 = new StockDto(String.format("%04d", j), "M" + i,"제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
                stockDao.insertStk(stockDto3);
            }
        }

         /*
         5.1. (3330,M1), (3331,M2), (3332,M3) 개별 삭제 후
              - count 순차적으로 1씩 줄어드는지 확인
              - 지워진 데이터 select해서 없는지 확인
        */
        String pd_id1 = stockDao.selectStkAll().get(3330).getPd_id();
        String m1 = stockDao.selectStkAll().get(3330).getPd_clsf_cd();

        String pd_id2 = stockDao.selectStkAll().get(3331).getPd_id();
        String m2 = stockDao.selectStkAll().get(3331).getPd_clsf_cd();

        String pd_id3 = stockDao.selectStkAll().get(3332).getPd_id();
        String m3 = stockDao.selectStkAll().get(3332).getPd_clsf_cd();

        assertTrue(stockDao.delete(pd_id1, m1) == 1);
        StockDto chechDeleted2 = stockDao.selectStk(pd_id1, m1);
        assertNull(chechDeleted2);
        assertTrue(stockDao.count() == 3332);


        assertTrue(stockDao.delete(pd_id2, m2) == 1);
        StockDto chechDeleted3 = stockDao.selectStk(pd_id2, m2);
        assertNull(chechDeleted3);
        assertTrue(stockDao.count() == 3331);


        assertTrue(stockDao.delete(pd_id3, m3) == 1);
        StockDto chechDeleted4 = stockDao.selectStk(pd_id3, m3);
        assertNull(chechDeleted4);
        assertTrue(stockDao.count() == 3330);
    }

    /*재고 1개 추가 테스트*/
    @Test
    public void testInsert() throws Exception {
            /*0. 테이블 전체 초기화*/
            stockDao.deleteAll();
            assertTrue(stockDao.count() == 0);

             /*1. 재고 1개 추가 / insert = 1 확인 / count = 1 확인  */
            stockDto = new StockDto("APP000001-10", "M","제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
            assertTrue(stockDao.insertStk(stockDto) == 1);
            assertTrue(stockDao.count() == 1);

            /*1.1. 삽입한 데이터 선택 후 잘 삽입 됐는지 확인*/
            StockDto checkInsert = stockDao.selectStk(stockDto.getPd_id(), stockDto.getPd_clsf_cd());
            assertNotNull(checkInsert);
            assertEquals(stockDto.getPd_id(), checkInsert.getPd_id());
            assertEquals(stockDto.getPd_clsf_cd(), checkInsert.getPd_clsf_cd());

            /*2. 재고 1개 추가. 총 2개 / 1개 insert 확인 / count = 2 확인  */
            /*2.1. 첫 삽입 데이터와 동일데이터 삽입: false 인지 확인*/
            stockDto = new StockDto("APP000001-10", "M","제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
            assertThrows(DuplicateKeyException.class, () -> stockDao.insertStk(stockDto));
            assertTrue(stockDao.count() == 1);

            /*2.2. 첫 삽입 데이터와 다른데이터 삽입: true 인지 확인*/
            stockDto = new StockDto("APP000001-10", "L","제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
            assertTrue(stockDao.insertStk(stockDto) == 1);
            assertTrue(stockDao.count() == 2);

            /*2.3. 두번째 삽입한 데이터 선택 후 잘 삽입 됐는지 확인*/
            Map checkInsert2 = new HashMap();
            checkInsert2.put("pd_id", stockDao.selectStkAll().get(1).getPd_id());
            checkInsert2.put("pd_clsf_cd", stockDao.selectStkAll().get(1).getPd_clsf_cd());
            assertNotNull(checkInsert2);
            assertEquals(stockDto.getPd_id(), checkInsert2.get("pd_id"));
            assertEquals(stockDto.getPd_clsf_cd(), checkInsert2.get("pd_clsf_cd"));

            /*3. 9개 데이터 삽입, count = 11 */
            for (int i = 1; i <= 3; i++) {
                for (int j = 1; j <= 3; j++) {
                    StockDto stockDto2 = new StockDto(String.format("%04d", j), "M" + i,"제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
                    stockDao.insertStk(stockDto2);
                }
            }
            assertTrue(stockDao.count() == 11);

            /*4. 초기화 후 count = 0 확인*/
            stockDao.deleteAll();
            assertTrue(stockDao.count() == 0);

            /*5. 데이터 3333개 데이터 삽입, count = 3333 확인*/
            for (int i = 1; i <= 3; i++) {
                for (int j = 1; j <= 1111; j++) {
                    StockDto stockDto3 = new StockDto(String.format("%04d", j), "M" + i,"제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
                    stockDao.insertStk(stockDto3);
                }
            }
            assertTrue(stockDao.count() == 3333);

            /*6. 초기화 후 count = 0 확인*/
            stockDao.deleteAll();
            assertTrue(stockDao.count() == 0);

            /*필수값 누락 했을 시 insert 안되는지 확인*/
            StockDto stockDto4 = new StockDto(null, "M","제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
            assertThrows(DataIntegrityViolationException.class, () -> stockDao.insertStk(stockDto4));
    }

    /*재고의 내용을 업데이트 한다.*/
    @Test
    public void testUpdate() throws Exception {
        /*0. 테이블 전체 초기화*/
        stockDao.deleteAll();
        assertTrue(stockDao.count() == 0);

        /*1. 재고 1개 추가 후 insert = 1 확인 / count = 1 확인 / 정상재고 수량 변경  */
        stockDto = new StockDto("APP000001-10", "M","제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
        assertTrue(stockDao.insertStk(stockDto) == 1);
        assertTrue(stockDao.count() == 1);
        stockDto.setNml_stk_qty(20);
        assertTrue(stockDao.update(stockDto) == 1);
        assertTrue(stockDao.selectStk("APP000001-10", "m").getNml_stk_qty().equals(20));
        assertTrue(stockDao.selectStk("APP000001-10", "m").getOdpmt_stk().equals(22));

        /*2. 두번째 다른데이터 삽입 / count = 2 확인 / 입고처 변경 */
        stockDto = new StockDto("APP000001-10", "L","제품명제품명", 10, 0, 2, 2, 1, "20240325", "20240327", "저기야구용품", 40000, 50000, 50000, "4A", "00");
        assertTrue(stockDao.insertStk(stockDto) == 1);
        assertTrue(stockDao.count() == 2);
        stockDto.setRcpt_cp("홈런볼야구점");
        assertTrue(stockDao.update(stockDto) == 1);
        assertTrue(stockDao.selectStk("APP000001-10", "L").getRcpt_cp().equals("홈런볼야구점"));

        /*3. 없는 데이터 정상재고 수량 변경 -> NullPointerException 발생 확인*/
        stockDto = stockDao.selectStk("APP000001-10", "XL");
        assertThrows(NullPointerException.class, () -> stockDto.setNml_stk_qty(20));
    }

    /*재고의 상태를 업데이트 한다.*/
/*
    @Test
    public void testUpdateStatus() throws Exception {

    }
*/

}