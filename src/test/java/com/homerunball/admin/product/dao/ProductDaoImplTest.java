package com.homerunball.admin.product.dao;

import com.homerunball.admin.product.domain.ProductDto;
import org.apache.ibatis.jdbc.Null;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLIntegrityConstraintViolationException;
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

    /*ProductDaoImpl의 countAll 테스트하기*/
    @Test
    public void countAllTest() throws Exception {
        /*0. db 서버가 실행되지 않을 때 테스트하기*/
        /*assertThrows(MyBatisSystemException.class, () -> productDao.countAll());*/

        /*1. DB 초기화*/
        productDao.deleteAll();
        assertTrue(productDao.countAll() == 0);

        /*2. 1개 추가한 다음 count*/
        ProductDto productDto = new ProductDto("APP000001-40", "pd_name1", "mdl_name1", "qlt_cd1", "ctg", "mn_img_fn"+1, "det_img_fn1", "pd_ad_cmt1", "pd_smr_dsc1", "pd_det_dsc"+1, 1,1, 'N', "20240428", "20240414", "og_pd_num1", "origin", "mfr", "srs_id", "ADT", "player_nm", "mtrl", "season", 100, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
        productDao.insert(productDto);
        assertTrue(productDao.countAll() == 1);

        /*3. 1개를 더 추가한 다음 count*/
        productDto = new ProductDto("APP000002-40", "pd_name1", "mdl_name1", "qlt_cd1", "ctg", "mn_img_fn"+1, "det_img_fn1", "pd_ad_cmt1", "pd_smr_dsc1", "pd_det_dsc"+1, 1,1, 'N', "20240428", "20240414", "og_pd_num1", "origin", "mfr", "srs_id", "ADT", "player_nm", "mtrl", "season", 100, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
        productDao.insert(productDto);
        assertTrue(productDao.countAll() == 2);

        /*4. 전체를 삭제한 다음*/
        productDao.deleteAll();
        assertTrue(productDao.countAll() == 0);

        /*5. 100개 추가한 다음 count*/
        for (int i = 0; i < 100; i++) {
            productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg", "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productDao.insert(productDto);
        }
        assertTrue(productDao.countAll() == 100);

        /*6. 50개 삭제한 다음 count*/
        for (int i = 99; i > 49; i--) {
            productDao.delete(i+"");
        }
        assertTrue(productDao.countAll() == 50);

        /*7. 50개 추가한 다음 count*/
        for (int i = 50; i < 100; i++) {
            productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg", "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productDao.insert(productDto);
        }
        assertTrue(productDao.countAll() == 100);
    }

    /*ProductDaoImpl의 deleteAll 테스트하기*/
    @Test
    public void deleteAllTest() throws Exception {
        /*1. DB 초기화*/
        productDao.deleteAll();
        assertTrue(productDao.countAll() == 0);

        /*2. 1개 추가한 다음 deleteAll*/
        ProductDto productDto = new ProductDto("APP000001-40", "pd_name1", "mdl_name1", "qlt_cd1", "ctg", "mn_img_fn"+1, "det_img_fn1", "pd_ad_cmt1", "pd_smr_dsc1", "pd_det_dsc"+1, 1,1, 'N', "20240428", "20240414", "og_pd_num1", "origin", "mfr", "srs_id", "ADT", "player_nm", "mtrl", "season", 100, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
        productDao.insert(productDto);
        assertTrue(productDao.deleteAll() == 1);

        /*3. 2개 추가한 다음 deleteAll*/
        productDto = new ProductDto("APP000001-40", "pd_name1", "mdl_name1", "qlt_cd1", "ctg", "mn_img_fn"+1, "det_img_fn1", "pd_ad_cmt1", "pd_smr_dsc1", "pd_det_dsc"+1, 1,1, 'N', "20240428", "20240414", "og_pd_num1", "origin", "mfr", "srs_id", "ADT", "player_nm", "mtrl", "season", 100, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
        productDao.insert(productDto);
        productDto = new ProductDto("APP000002-40", "pd_name1", "mdl_name1", "qlt_cd1", "ctg", "mn_img_fn"+1, "det_img_fn1", "pd_ad_cmt1", "pd_smr_dsc1", "pd_det_dsc"+1, 1,1, 'N', "20240428", "20240414", "og_pd_num1", "origin", "mfr", "srs_id", "ADT", "player_nm", "mtrl", "season", 100, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
        productDao.insert(productDto);
        assertTrue(productDao.deleteAll() == 2);

        /*4. 100개 추가*/
        for (int i = 0; i < 100; i++) {
            productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg", "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productDao.insert(productDto);
        }
        assertTrue(productDao.countAll() == 100);

        /*5. deleteAll 했을 때 100을 반환하는지 확인*/
        assertTrue(productDao.deleteAll() == 100);

        /*6. 추가 안 하고 deleteAll 했을 때 0을 반환하는지 확인*/
        assertTrue(productDao.deleteAll() == 0);
    }

    /*ProductDaoImpl의 delete 테스트하기*/
    @Test
    public void deleteTest() throws Exception {
        /*1. DB 초기화*/
        productDao.deleteAll();
        assertTrue(productDao.countAll() == 0);

        /*2. 1개 추가한 다음 delete*/
        ProductDto productDto = new ProductDto("APP000001-40", "pd_name1", "mdl_name1", "qlt_cd1", "ctg", "mn_img_fn"+1, "det_img_fn1", "pd_ad_cmt1", "pd_smr_dsc1", "pd_det_dsc"+1, 1,1, 'N', "20240428", "20240414", "og_pd_num1", "origin", "mfr", "srs_id", "ADT", "player_nm", "mtrl", "season", 100, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
        productDao.insert(productDto);
        assertTrue(productDao.delete("APP000001-40") == 1);

        /*3. 2개 추가한 다음 delete*/
        productDto = new ProductDto("APP000001-40", "pd_name1", "mdl_name1", "qlt_cd1", "ctg", "mn_img_fn"+1, "det_img_fn1", "pd_ad_cmt1", "pd_smr_dsc1", "pd_det_dsc"+1, 1,1, 'N', "20240428", "20240414", "og_pd_num1", "origin", "mfr", "srs_id", "ADT", "player_nm", "mtrl", "season", 100, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
        productDao.insert(productDto);
        productDto = new ProductDto("APP000002-40", "pd_name1", "mdl_name1", "qlt_cd1", "ctg", "mn_img_fn"+1, "det_img_fn1", "pd_ad_cmt1", "pd_smr_dsc1", "pd_det_dsc"+1, 1,1, 'N', "20240428", "20240414", "og_pd_num1", "origin", "mfr", "srs_id", "ADT", "player_nm", "mtrl", "season", 100, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
        productDao.insert(productDto);
        assertTrue(productDao.countAll()==2);
        assertTrue(productDao.delete("APP000001-40") == 1);
        assertTrue(productDao.delete("APP000002-40") == 1);

        /*4. 100개 추가*/
        for (int i = 0; i < 100; i++) {
            productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg", "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productDao.insert(productDto);
        }
        assertTrue(productDao.countAll() == 100);

        /*5. 존재하는 데이터 50개 삭제 후 개수 확인*/
        for(int i = 99; i > 49; i--) {
            assertTrue(productDao.delete(i+"") == 1);
        }
        assertTrue(productDao.countAll() == 50);

        /*6. 존재하지 않는 데이터 50개 삭제 후 개수 확인*/
        for(int i = 99; i > 49; i--) {
            assertTrue(productDao.delete(i+"") == 0);
        }
        assertTrue(productDao.countAll() == 50);
    }

    /*ProductDaoImpl의 insert 테스트하기*/
    @Test
    public void insertTest() throws Exception {
        /*1. DB 초기화*/
        productDao.deleteAll();
        assertTrue(productDao.countAll() == 0);

        /*2. 1개 추가한 다음 insert*/
        ProductDto productDto = new ProductDto("APP000001-40", "pd_name1", "mdl_name1", "qlt_cd1", "ctg", "mn_img_fn"+1, "det_img_fn1", "pd_ad_cmt1", "pd_smr_dsc1", "pd_det_dsc"+1, 1,1, 'N', "20240428", "20240414", "og_pd_num1", "origin", "mfr", "srs_id", "ADT", "player_nm", "mtrl", "season", 100, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
        assertTrue(productDao.insert(productDto) == 1);

        /*3. 2개 추가한 다음 insert*/
        productDto = new ProductDto("APP000001-30", "pd_name1", "mdl_name1", "qlt_cd1", "ctg", "mn_img_fn"+1, "det_img_fn1", "pd_ad_cmt1", "pd_smr_dsc1", "pd_det_dsc"+1, 1,1, 'N', "20240428", "20240414", "og_pd_num1", "origin", "mfr", "srs_id", "ADT", "player_nm", "mtrl", "season", 100, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
        assertTrue(productDao.insert(productDto) == 1);
        productDto = new ProductDto("APP000002-40", "pd_name1", "mdl_name1", "qlt_cd1", "ctg", "mn_img_fn"+1, "det_img_fn1", "pd_ad_cmt1", "pd_smr_dsc1", "pd_det_dsc"+1, 1,1, 'N', "20240428", "20240414", "og_pd_num1", "origin", "mfr", "srs_id", "ADT", "player_nm", "mtrl", "season", 100, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
        assertTrue(productDao.insert(productDto) == 1);
        assertTrue(productDao.deleteAll() == 3);
        assertTrue(productDao.countAll() == 0);

        /*4. 100개 넣고 개수 확인*/
        for (int i = 0; i < 100; i++) {
            productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg", "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            assertTrue(productDao.insert(productDto) == 1);
        }
        assertTrue(productDao.countAll() == 100);

        /*5. 1000개를 추가로 넣고 개수 확인*/
        for (int i = 100; i < 1100; i++) {
            productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg", "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            assertTrue(productDao.insert(productDto) == 1);
        }
        assertTrue(productDao.countAll() == 1100);

        /*6. 중복 데이터 넣어보기*/
        for (int i = 1; i < 50; i++) {
            ProductDto prdDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg", "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            try {
                assertTrue(productDao.insert(prdDto) == 0);
            } catch (DuplicateKeyException e) {}
        }
        assertTrue(productDao.countAll() == 1100);
    }

    /*ProductDaoImpl의 selectPrd 메서드 테스트하기*/
    @Test
    public void selectPrdTest() throws Exception {
        /*1. DB 초기화*/
        productDao.deleteAll();
        assertTrue(productDao.countAll() == 0);

        /*2. 1개 추가 후 select로 확인 */
        ProductDto productDto = new ProductDto("APP000001-40", "pd_name1", "mdl_name1", "qlt_cd1", "ctg", "mn_img_fn"+1, "det_img_fn1", "pd_ad_cmt1", "pd_smr_dsc1", "pd_det_dsc"+1, 1,1, 'N', "20240428", "20240414", "og_pd_num1", "origin", "mfr", "srs_id", "ADT", "player_nm", "mtrl", "season", 100, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
        assertTrue(productDao.insert(productDto) == 1);

        String pdId = productDto.getPd_id();
        productDto = productDao.selectPrd(pdId);
        ProductDto productDto2 = productDao.selectPrd(pdId);
        assertTrue(productDto.equals(productDto2));

        /*3. DB 초기화*/
        productDao.deleteAll();
        assertTrue(productDao.countAll() == 0);

        /*4. 100개 추가*/
        for (int i = 0; i < 100; i++) {
            productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg", "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            assertTrue(productDao.insert(productDto) == 1);
        }
        assertTrue(productDao.countAll() == 100);

        /*5. 50번째 데이터 선택*/
        assertEquals("mdl_name49", productDao.selectPrd("49").getMdl_name());

        /*6. 없는 데이터 선택*/
        assertThrows(NullPointerException.class, () -> productDao.selectPrd("500").getMdl_name());
    }

    /*ProductDaoImpl selectPrdAll 테스트하기*/
    @Test
    public void selectPrdAllTest() throws Exception {
        /*1. DB 초기화*/
        productDao.deleteAll();
        assertTrue(productDao.countAll() == 0);

        /*2. productDtoList 선언*/
        List<ProductDto> productDtoList = productDao.selectPrdAll();
        assertTrue(productDtoList.size() == 0);

        /*3. 1개 추가한 다음 selectPrdAll로 개수 확인*/
        ProductDto productDto = new ProductDto("APP000001-40", "pd_name1", "mdl_name1", "qlt_cd1", "ctg", "mn_img_fn"+1, "det_img_fn1", "pd_ad_cmt1", "pd_smr_dsc1", "pd_det_dsc"+1, 1,1, 'N', "20240428", "20240414", "og_pd_num1", "origin", "mfr", "srs_id", "ADT", "player_nm", "mtrl", "season", 100, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
        assertTrue(productDao.insert(productDto) == 1);
        productDtoList = productDao.selectPrdAll();
        assertTrue(productDtoList.size() == 1);

        /*4. 1개를 더 추가한 다음 selectPrdAll로 개수 확인*/
        productDto = new ProductDto("APP000002-40", "pd_name1", "mdl_name1", "qlt_cd1", "ctg", "mn_img_fn"+1, "det_img_fn1", "pd_ad_cmt1", "pd_smr_dsc1", "pd_det_dsc"+1, 1,1, 'N', "20240428", "20240414", "og_pd_num1", "origin", "mfr", "srs_id", "ADT", "player_nm", "mtrl", "season", 100, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
        assertTrue(productDao.insert(productDto) == 1);
        productDtoList = productDao.selectPrdAll();
        assertTrue(productDtoList.size() == 2);

        /*5. DB 초기화*/
        productDao.deleteAll();
        assertTrue(productDao.countAll() == 0);

        /*6. 100개 추가 후 selectPrdAll -> 100개 확인*/
        for (int i = 0; i < 100; i++) {
            productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg", "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productDao.insert(productDto);
        }
        productDtoList = productDao.selectPrdAll();
        assertTrue(productDtoList.size() == 100);

        /*7. 100개 추가 후 selectPrdAll -> 200개 확인*/
        for (int i = 100; i < 200; i++) {
            productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg", "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productDao.insert(productDto);
        }
        productDtoList = productDao.selectPrdAll();
        assertTrue(productDtoList.size() == 200);

        /*8. DB 초기화*/
        productDao.deleteAll();
        assertTrue(productDao.countAll() == 0);

        /*9. 모두 삭제 후 -> 0개 확인*/
        productDtoList = productDao.selectPrdAll();
        assertTrue(productDtoList.size() == 0);
    }

    /*STK(재고) 테이블과 조인 필요*/
    @Test
    public void selectPrdPrcAllTest() {
    }

    /*STK(재고) 테이블과 조인 필요*/
    @Test
    public void selectPrdPrcTest() {
    }

    /*ProductDaoImpl의 searchBiggestSerialNumber 테스트*/
    @Test
    public void searchBiggestSerialNumberTest() throws Exception {
        /*1. DB 초기화*/
        productDao.deleteAll();
        assertTrue(productDao.countAll() == 0);

        /*2. APP 데이터 한 개만 넣었을 때 APP의 가장 큰 시리얼 넘버 확인하기*/
        ProductDto productDto = new ProductDto("APP000001-40", "pd_name1", "mdl_name1", "qlt_cd1", "ctg", "mn_img_fn"+1, "det_img_fn1", "pd_ad_cmt1", "pd_smr_dsc1", "pd_det_dsc"+1, 1,1, 'N', "20240428", "20240414", "og_pd_num1", "origin", "mfr", "srs_id", "ADT", "player_nm", "mtrl", "season", 100, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
        assertTrue(productDao.insert(productDto) == 1);
        assertTrue(productDao.searchBiggestSerialNumber("APP") == 1);

        /*3. APP(의류) 데이터 한 개를 추가로 넣었을 때 가장 큰 시리얼 넘버 확인하기*/
        productDto = new ProductDto("APP000002-40", "pd_name1", "mdl_name1", "qlt_cd1", "ctg", "mn_img_fn"+1, "det_img_fn1", "pd_ad_cmt1", "pd_smr_dsc1", "pd_det_dsc"+1, 1,1, 'N', "20240428", "20240414", "og_pd_num1", "origin", "mfr", "srs_id", "ADT", "player_nm", "mtrl", "season", 100, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
        assertTrue(productDao.insert(productDto) == 1);
        assertTrue(productDao.searchBiggestSerialNumber("APP") == 2);

        /*4. 색깔만 다른 APP(의류) 데이터 한 개를 추가로 넣었을 때 가장 큰 시리얼 넘버 확인하기*/
        productDto = new ProductDto("APP000002-30", "pd_name1", "mdl_name1", "qlt_cd1", "ctg", "mn_img_fn"+1, "det_img_fn1", "pd_ad_cmt1", "pd_smr_dsc1", "pd_det_dsc"+1, 1,1, 'N', "20240428", "20240414", "og_pd_num1", "origin", "mfr", "srs_id", "ADT", "player_nm", "mtrl", "season", 100, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
        assertTrue(productDao.insert(productDto) == 1);
        assertTrue(productDao.searchBiggestSerialNumber("APP") == 2);

        /*5. DB 초기화*/
        productDao.deleteAll();
        assertTrue(productDao.countAll() == 0);

        /*6. productDao로 db에 APP 데이터 100개 추가*/
        for (int i = 0; i < 100; i++) {
            productDto = new ProductDto("APP" + i, "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg", "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productDao.insert(productDto);
        }
        assertTrue(productDao.countAll() == 100);

        /*7. APP의 시리얼 넘버가 가장 큰 경우는 99이다.*/
        assertTrue(productDao.searchBiggestSerialNumber("APP") == 99);

        /*8. 추가가 되지 않은 GLV의 가장 큰 숫자는 null*/
        assertThrows(NullPointerException.class, () -> productDao.searchBiggestSerialNumber("GLV"));
    }

    /*ProductDaoImpl의 countType 테스트*/
    @Test
    public void countTypeTest() throws Exception {
        /*1. DB 초기화*/
        productDao.deleteAll();
        assertTrue(productDao.countAll() == 0);

        /*2. APP(의류) 데이터 1개를 추가한 다음 APP의 제품 개수 확인*/
        ProductDto productDto = new ProductDto("APP000001-40", "pd_name1", "mdl_name1", "qlt_cd1", "ctg", "mn_img_fn"+1, "det_img_fn1", "pd_ad_cmt1", "pd_smr_dsc1", "pd_det_dsc"+1, 1,1, 'N', "20240428", "20240414", "og_pd_num1", "origin", "mfr", "srs_id", "ADT", "player_nm", "mtrl", "season", 100, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
        assertTrue(productDao.insert(productDto) == 1);
        assertTrue(productDao.countType("APP") == 1);

        /*3. APP(의류) 데이터 1개 더 추가한 다음 APP의 제품 개수 확인*/
        productDto = new ProductDto("APP000002-40", "pd_name1", "mdl_name1", "qlt_cd1", "ctg", "mn_img_fn"+1, "det_img_fn1", "pd_ad_cmt1", "pd_smr_dsc1", "pd_det_dsc"+1, 1,1, 'N', "20240428", "20240414", "og_pd_num1", "origin", "mfr", "srs_id", "ADT", "player_nm", "mtrl", "season", 100, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
        assertTrue(productDao.insert(productDto) == 1);
        assertTrue(productDao.countType("APP") == 2);

        /*4. DB 초기화*/
        productDao.deleteAll();
        assertTrue(productDao.countAll() == 0);

        /*5. productDao로 db에 APP 데이터 100개 추가*/
        for (int i = 0; i < 100; i++) {
            productDto = new ProductDto("APP" + i, "pd_name" + i, "mdl_name" + i, "qlt_cd" + i, "ctg", "mn_img_fn" + i, "det_img_fn" + i, "pd_ad_cmt" + i, "pd_smr_dsc" + i, "pd_det_dsc" + 1, i, i, 'N', "20240428", "20240414", "og_pd_num" + i, "origin", "mfr", "srs_id" + i, "ADT", "player_nm", "mtrl", "season", 100 * i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productDao.insert(productDto);
        }

        /*6. APP의 개수 확인*/
        assertTrue(productDao.countType("APP") == 100);

        /*7. 추가되지 않은 GLV의 개수 확인*/
        assertTrue(productDao.countType("GLV") == 0);
    }

    /*ProductDaoImpl의 updateContent 테스트*/
    @Test
    public void updateContentTest() throws Exception {
        /*1. DB 초기화*/
        productDao.deleteAll();
        assertTrue(productDao.countAll() == 0);

        /*2. APP(의류) 데이터 1개를 추가한 다음 제품명 변경*/
        ProductDto productDto = new ProductDto("APP000001-40", "pd_name1", "mdl_name1", "qlt_cd1", "ctg", "mn_img_fn"+1, "det_img_fn1", "pd_ad_cmt1", "pd_smr_dsc1", "pd_det_dsc"+1, 1,1, 'N', "20240428", "20240414", "og_pd_num1", "origin", "mfr", "srs_id", "ADT", "player_nm", "mtrl", "season", 100, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
        assertTrue(productDao.insert(productDto) == 1);
        productDto.setPd_name("pd_name190");
        assertTrue(productDao.updateContent(productDto) == 1);
        assertTrue(productDao.selectPrd("APP000001-40").getPd_name().equals("pd_name190"));

        /*3. 새로운 APP(의류) 데이터 1개를 추가한 다음 모델명 변경*/
        productDto = new ProductDto("APP000002-40", "pd_name1", "mdl_name1", "qlt_cd1", "ctg", "mn_img_fn1", "det_img_fn1", "pd_ad_cmt1", "pd_smr_dsc1", "pd_det_dsc"+1, 1,1, 'N', "20240428", "20240414", "og_pd_num1", "origin", "mfr", "srs_id", "ADT", "player_nm", "mtrl", "season", 100, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
        assertTrue(productDao.insert(productDto) == 1);
        productDto.setMdl_name("mdl_name22");
        assertTrue(productDao.updateContent(productDto) == 1);
        assertTrue(productDao.selectPrd("APP000002-40").getMdl_name().equals("mdl_name22"));

        /*4. 새로운 APP(의류) 데이터 1개를 추가한 다음 제품 상태 변경*/
        productDto = new ProductDto("APP000003-40", "pd_name1", "mdl_name1", "qlt_cd1", "ctg", "mn_img_fn1", "det_img_fn1", "pd_ad_cmt1", "pd_smr_dsc1", "pd_det_dsc"+1, 1,1, 'N', "20240428", "20240414", "og_pd_num1", "origin", "mfr", "srs_id", "ADT", "player_nm", "mtrl", "season", 100, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
        assertTrue(productDao.insert(productDto) == 1);
        productDto.setPd_stat_hist_cd("10");
        assertTrue(productDao.updateContent(productDto) == 1);
        assertTrue(productDao.selectPrd("APP000003-40").getPd_stat_hist_cd().equals("10"));

        /*5. 없는 APP(의류) 데이터 최소 주문 수량 변경*/
        try {
            productDto = productDao.selectPrd("APP000004-40");
            productDto.setMin_od_qty(2);
            assertTrue(productDao.updateContent(productDto) == 0);
            assertTrue(productDao.selectPrd("APP000003-40").getMin_od_qty() == 2);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException 발생");
        }

    }

    /*ProductDaoImpl의 increaseHitCnt 테스트*/
    @Test
    public void increaseHitCntTest() throws Exception {
        /*1. DB 초기화*/
        productDao.deleteAll();
        assertTrue(productDao.countAll() == 0);

        /*2. 데이터 1개 추가한 다음 조회수 1 증가*/
        ProductDto productDto = new ProductDto("APP000001-40", "pd_name1", "mdl_name1", "qlt_cd1", "ctg", "mn_img_fn"+1, "det_img_fn1", "pd_ad_cmt1", "pd_smr_dsc1", "pd_det_dsc"+1, 1,1, 'N', "20240428", "20240414", "og_pd_num1", "origin", "mfr", "srs_id", "ADT", "player_nm", "mtrl", "season", 100, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
        assertTrue(productDao.insert(productDto) == 1);
        assertTrue(productDao.increaseHitCnt("APP000001-40") == 1);
        assertTrue(productDao.selectPrd("APP000001-40").getHit_cnt() == 1);

        /*3. 데이터 1개 더 추가한 다음 조회수 2 증가*/
        productDto = new ProductDto("APP000002-40", "pd_name1", "mdl_name1", "qlt_cd1", "ctg", "mn_img_fn"+1, "det_img_fn1", "pd_ad_cmt1", "pd_smr_dsc1", "pd_det_dsc"+1, 1,1, 'N', "20240428", "20240414", "og_pd_num1", "origin", "mfr", "srs_id", "ADT", "player_nm", "mtrl", "season", 100, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
        assertTrue(productDao.insert(productDto) == 1);
        assertTrue(productDao.increaseHitCnt("APP000002-40") == 1);
        assertTrue(productDao.increaseHitCnt("APP000002-40") == 1);
        assertTrue(productDao.selectPrd("APP000002-40").getHit_cnt() == 2);

        /*4. 데이터 1개 더 추가한 다음 조회수 100 증가*/
        productDto = new ProductDto("APP000003-40", "pd_name1", "mdl_name1", "qlt_cd1", "ctg", "mn_img_fn"+1, "det_img_fn1", "pd_ad_cmt1", "pd_smr_dsc1", "pd_det_dsc"+1, 1,1, 'N', "20240428", "20240414", "og_pd_num1", "origin", "mfr", "srs_id", "ADT", "player_nm", "mtrl", "season", 100, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
        assertTrue(productDao.insert(productDto) == 1);
        for(int i=1;i<=100;i++) {
            assertTrue(productDao.increaseHitCnt("APP000003-40") == 1);
        }
        assertTrue(productDao.selectPrd("APP000003-40").getHit_cnt() == 100);

        /*5. 없는 데이터 조회수 1 증가*/
        assertTrue(productDao.increaseHitCnt("GLV000001-90") == 0);
    }
}