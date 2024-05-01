package com.homerunball.admin.product.dao;

import com.homerunball.admin.product.domain.ProductDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ProductDaoImplTest {
    @Autowired
    private ProductDao productDao;

    /* productDao가 연결되었는지 테스트하기 */
    @Test
    public void linkTest() {
        System.out.println("ProductDao = " + productDao);
        assertTrue(productDao != null);
    }

    /*
     ProductDaoImpl의 count 테스트하기
     0. db 서버가 실행되지 않을 때 테스트하기
     1. 100개 추가 후 count
     2. 50개 삭제 후 count
     3. 50개 추가 후 count
     4. 없는 것 count
     */
    @Test
    public void countAllTest() throws Exception {
        assertThrows(MyBatisSystemException.class, () -> productDao.countAll());
        productDao.deleteAll();
        assertTrue(productDao.countAll() == 0);

        for (int i = 0; i < 100; i++) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTimeInMillis() - i * 24L * 60 * 60 * 1000);
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg", "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_name", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productDao.insert(productDto);
        }
        assertTrue(productDao.countAll() == 100);

        for (int i = 99; i > 49; i--) {
            productDao.delete(i+"");
        }
        assertTrue(productDao.countAll() == 50);

        for (int i = 50; i < 100; i++) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTimeInMillis() - i * 24L * 60 * 60 * 1000);
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg", "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_name", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productDao.insert(productDto);
        }
        assertTrue(productDao.countAll() == 100);
    }

    /*
     ProductDaoImpl의 deleteAll 테스트하기
     1. 100개 추가
     2. deleteAll  -> count = 0인지
     3. 추가 안 하고 deleteAll -> count 0인지
     */
    @Test
    public void deleteAllTest() throws Exception {
        productDao.deleteAll();
        assertTrue(productDao.countAll() == 0);

        for (int i = 0; i < 100; i++) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTimeInMillis() - i * 24L * 60 * 60 * 1000);
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg", "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_name", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productDao.insert(productDto);
        }

        productDao.deleteAll();
        assertTrue(productDao.countAll() == 0);

        productDao.deleteAll();
        assertTrue(productDao.countAll() == 0);
    }

    /*
     ProductDaoImpl의 delete 테스트하기
     1. 100개 추가
     2. 있는 데이터 50개 삭제 후 개수 확인
     3. 없는 데이터 50개 삭제 후 개수 확인
     */
    @Test
    public void deleteTest() throws Exception {
        productDao.deleteAll();
        assertTrue(productDao.countAll() == 0);

        for (int i = 0; i < 100; i++) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTimeInMillis() - i * 24L * 60 * 60 * 1000);
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg", "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_name", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productDao.insert(productDto);
        }
        assertTrue(productDao.countAll() == 100);

        for(int i = 99; i > 49; i--) {
            productDao.delete(i+"");
        }
        assertTrue(productDao.countAll() == 50);

        for(int i = 99; i > 49; i--) {
            productDao.delete(i+"");
        }
        assertTrue(productDao.countAll() == 50);
    }

    /*
     ProductDaoImpl의 insert 테스트하기
     1. 1,000개 넣고 개수 확인
     2. 50개 넣고 개수 확인
     3. 중복 데이터 넣어보기
     */
    @Test
    public void insertTest() throws Exception {
        productDao.deleteAll();
        assertTrue(productDao.countAll() == 0);

        for (int i = 0; i < 1000; i++) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTimeInMillis() - i * 24L * 60 * 60 * 1000);
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg", "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_name", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productDao.insert(productDto);
        }
        assertTrue(productDao.countAll() == 1000);

        for (int i = 1000; i < 1050; i++) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTimeInMillis() - i * 24L * 60 * 60 * 1000);
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg", "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_name", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productDao.insert(productDto);
        }
        assertTrue(productDao.countAll() == 1050);

        for (int i = 1000; i < 1050; i++) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTimeInMillis() - i * 24L * 60 * 60 * 1000);
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg", "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_name", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            assertThrows(DuplicateKeyException.class, () -> productDao.insert(productDto));
        }
    }

    /*
     ProductDaoImpl의 selectPrd 메서드 테스트하기
     1. 100개 추가
     2. 50번째 데이터 선택
     3. 없는 데이터 선택
     */
    @Test
    public void selectPrdTest() throws Exception {
        productDao.deleteAll();
        assertTrue(productDao.countAll() == 0);

        for (int i = 0; i < 100; i++) {
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg", "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_name", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productDao.insert(productDto);
        }
        assertTrue(productDao.countAll() == 100);

        assertEquals("mdl_name49", productDao.selectPrd("49").getMdl_name());
        assertThrows(NullPointerException.class, () -> productDao.selectPrd("500").getMdl_name());
    }

    /*
     ProductDaoImpl selectPrdAll 테스트하기
     1. 100개 추가 후 selectPrdAll -> 100개 확인
     2. 100개 추가 후 selectPrdAll -> 200개 확인
     3. 모두 삭제 후 getAllProducts -> 0개 확인
     */
    @Test
    public void selectPrdAllTest() throws Exception {
        productDao.deleteAll();
        assertTrue(productDao.countAll() == 0);

        List<ProductDto> productDtoList = productDao.selectPrdAll();
        assertTrue(productDtoList.size() == 0);

        for (int i = 0; i < 100; i++) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTimeInMillis() - i * 24L * 60 * 60 * 1000);
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg", "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_name", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productDao.insert(productDto);
        }
        productDtoList = productDao.selectPrdAll();
        assertTrue(productDtoList.size() == 100);

        for (int i = 100; i < 200; i++) {
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg", "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_name", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productDao.insert(productDto);
        }
        productDtoList = productDao.selectPrdAll();
        assertTrue(productDtoList.size() == 200);

        productDao.deleteAll();
        assertTrue(productDao.countAll() == 0);
    }

    /*
     STK(재고) 테이블과 조인 필요
     */
    @Test
    public void selectPrdPrcAllTest() {
    }

    /*
     STK(재고) 테이블과 조인 필요
     */
    @Test
    public void selectPrdPrcTest() {
    }

    /*
    ProductDaoImpl의 searchBiggestSerialNumber 테스트
    1. productDao로 db에 APP 데이터 100개 추가
    2. APP의 시리얼 넘버가 가장 큰 경우는 99이다.
    3. 추가가 되지 않은 GLV의 가장 큰 숫자는 null
     */
    @Test
    public void searchBiggestSerialNumberTest() throws Exception {
        productDao.deleteAll();
        assertTrue(productDao.countAll() == 0);

        for (int i = 0; i < 100; i++) {
            ProductDto productDto = new ProductDto("APP" + i, "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg", "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_name", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productDao.insert(productDto);
        }
        assertTrue(productDao.countAll() == 100);

        assertTrue(productDao.searchBiggestSerialNumber("APP") == 99);
        assertThrows(NullPointerException.class, () -> productDao.searchBiggestSerialNumber("GLV"));
    }

    /*
    ProductDaoImpl의 countType 테스트
    1. productDao로 db에 APP 데이터 100개 추가
    2. APP의 개수 확인
    3. 추가되지 않은 GLV의 개수 확인
    */
    @Test
    public void countTypeTest() throws Exception {
        productDao.deleteAll();
        assertTrue(productDao.countAll() == 0);

        for (int i = 0; i < 100; i++) {
            ProductDto productDto = new ProductDto("APP" + i, "pd_name" + i, "mdl_name" + i, "qlt_cd" + i, "ctg", "mn_img_fn" + i, "det_img_fn" + i, "pd_ad_cmt" + i, "pd_smr_dsc" + i, "pd_det_dsc" + 1, i, i, 'N', "20240428", "20240414", "og_pd_num" + i, "origin", "mfr", "srs_id" + i, "ADT", "player_name", "mtrl", "season", 100 * i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productDao.insert(productDto);
        }
        assertTrue(productDao.countType("APP") == 100);

        assertTrue(productDao.countType("GLV") == 0);
    }

    /*
     ProductDaoImpl의 updateContent 테스트
     1. 데이터 20개 추가
     2. 20번째 제품명 변경
     3. 19번째 모델명 변경
     */
    @Test
    public void updateContentTest() throws Exception {
        productDao.deleteAll();
        assertTrue(productDao.countAll() == 0);

        List<ProductDto> productDtoList = productDao.selectPrdAll();
        assertTrue(productDtoList.size() == 0);

        for (int i = 0; i < 20; i++) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTimeInMillis() - i * 24L * 60 * 60 * 1000);
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg", "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_name", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productDao.insert(productDto);
        }
        productDtoList = productDao.selectPrdAll();
        assertTrue(productDtoList.size() == 20);

        ProductDto productDto = productDao.selectPrd("19");
        productDto.setPd_name("pd_name190");
        productDao.updateContent(productDto);
        assertEquals("pd_name190", productDao.selectPrd("19").getPd_name());

        productDto = productDao.selectPrd("18");
        productDto.setMdl_name("mdl_name180");
        productDao.updateContent(productDto);
        assertEquals("mdl_name180", productDao.selectPrd("18").getMdl_name());
    }

    /*
     ProductDaoImpl의 updateStatus 테스트
     1. 데이터 20개 추가
     2. 20번째 데이터 상태 1~10으로 변경
     3. 없는 데이터 상태 변경
     */
    @Test
    public void updateStatusTest() throws Exception {
        productDao.deleteAll();
        assertTrue(productDao.countAll() == 0);

        List<ProductDto> productDtoList = productDao.selectPrdAll();
        assertTrue(productDtoList.size() == 0);

        for (int i = 0; i < 20; i++) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTimeInMillis() - i * 24L * 60 * 60 * 1000);
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg", "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_name", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productDao.insert(productDto);
        }
        productDtoList = productDao.selectPrdAll();
        assertTrue(productDtoList.size() == 20);

        ProductDto productDto = productDao.selectPrd("19");
        for(int i=1;i<=10;i++) {
            productDto.setPd_stat_hist_cd(i+"");
            productDao.updateStatus(productDto);
            assertEquals(i+"", productDao.selectPrd("19").getPd_stat_hist_cd());
        }
    }

    /*
     ProductDaoImpl의 increaseHitCnt 테스트
     1. 데이터 100개 삽입
     2. 80번째 데이터 조회수 100개 증가
     3. 없는 데이터 조회수 100개 증가
     */
    @Test
    public void increaseHitCntTest() throws Exception {
        productDao.deleteAll();
        assertTrue(productDao.countAll() == 0);

        List<ProductDto> productDtoList = productDao.selectPrdAll();
        assertTrue(productDtoList.size() == 0);

        for (int i = 0; i < 100; i++) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTimeInMillis() - i * 24L * 60 * 60 * 1000);
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg", "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_name", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productDao.insert(productDto);
        }
        productDtoList = productDao.selectPrdAll();
        assertTrue(productDtoList.size() == 100);
        for(int i=1;i<=100;i++) {
            productDao.increaseHitCnt("80");
        }
        assertTrue(productDao.selectPrd("80").getHit_cnt() == 100);

        for(int i=1;i<=100;i++) {
            productDao.increaseHitCnt("800");
        }
        assertThrows(NullPointerException.class, () -> productDao.selectPrd("800").getHit_cnt());
    }
}