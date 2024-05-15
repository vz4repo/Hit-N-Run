/*
package com.homerunball.product.service;

import com.homerunball.admin.product.ProductDto;
import com.homerunball.admin.product.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class ProductServiceImplTest {
    @Autowired
    private ProductService productService;

    @Test
    public void linkTest() {
        System.out.println("ProductService = " + productService);
        assertTrue(productService != null);
    }

    */
/*
     ProductServiceImpl의 getCount 테스트하기
     1. 100개 추가 후 count
     2. 50개 삭제 후 count
     3. 50개 추가 후 count
     *//*

    @Test
    public void getCountTest() throws Exception {
        productService.removeAll();
        assertTrue(productService.getCount() == 0);

        for (int i = 0; i < 100; i++) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTimeInMillis() - i * 24L * 60 * 60 * 1000);
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', date, "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*1.05*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productService.create(productDto);
        }
        assertTrue(productService.getCount() == 100);

        for (int i = 99; i > 49; i--) {
            productService.remove("APP"+i+"-50");
        }
        assertTrue(productService.getCount() == 50);

        for (int i = 50; i < 100; i++) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTimeInMillis() - i * 24L * 60 * 60 * 1000);
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', date, "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*1.05*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productService.create(productDto);
        }
        assertTrue(productService.getCount() == 100);
    }

    */
/*
     ProductServiceImpl의 removeAll 테스트하기
     1. 100개 추가
     2. removeAll  -> count = 0인지
     3. 추가 안 하고 removeAll -> count 0인지
     *//*

    @Test
    public void removeAllTest() throws Exception {
        productService.removeAll();
        assertTrue(productService.getCount() == 0);

        for (int i = 0; i < 100; i++) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTimeInMillis() - i * 24L * 60 * 60 * 1000);
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', date, "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*1.05*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productService.create(productDto);
        }

        productService.removeAll();
        assertTrue(productService.getCount() == 0);

        productService.removeAll();
        assertTrue(productService.getCount() == 0);
    }

    */
/*
     ProductServiceImpl의 remove 테스트하기
     1. 100개 추가
     2. 있는 데이터 50개 삭제 후 개수 확인
     3. 없는 데이터 50개 삭제 후 개수 확인
     *//*

    @Test
    public void removeTest() throws Exception {
        productService.removeAll();
        assertTrue(productService.getCount() == 0);

        for (int i = 0; i < 100; i++) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTimeInMillis() - i * 24L * 60 * 60 * 1000);
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', date, "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*1.05*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productService.create(productDto);
        }
        assertTrue(productService.getCount() == 100);

        for(int i = 99; i > 49; i--) {
            productService.remove("APP"+i+"-50");
        }
        assertTrue(productService.getCount() == 50);

        for(int i = 99; i > 49; i--) {
            productService.remove("APP"+i+"-50");
        }
        assertTrue(productService.getCount() == 50);
    }

    */
/*
     ProductServiceImpl의 create 테스트하기
     1. 1,000개 넣고 개수 확인
     2. 50개 넣고 개수 확인
     3. 중복 데이터 넣어보기
     *//*

    @Test
    public void createTest() throws Exception {
        productService.removeAll();
        assertTrue(productService.getCount() == 0);

        for (int i = 0; i < 1000; i++) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTimeInMillis() - i * 24L * 60 * 60 * 1000);
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', date, "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*1.05*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productService.create(productDto);
        }
        assertTrue(productService.getCount() == 1000);

        for (int i = 1000; i < 1050; i++) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTimeInMillis() - i * 24L * 60 * 60 * 1000);
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', date, "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*1.05*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productService.create(productDto);
        }
        assertTrue(productService.getCount() == 1050);

        for (int i = 1000; i < 1050; i++) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTimeInMillis() - i * 24L * 60 * 60 * 1000);
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', date, "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*1.05*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            assertThrows(DuplicateKeyException.class, () -> productService.create(productDto));
        }
    }

    */
/*
     ProductServiceImpl getAllProducts 테스트하기
     1. 100개 추가 후 getAllProducts -> 100개 확인
     2. 100개 추가 후 getAllProducts -> 200개 확인
     3. 모두 삭제 후 getAllProducts -> 0개 확인
     *//*

    @Test
    public void getAllProductsTest() throws Exception {
        productService.removeAll();
        assertTrue(productService.getCount() == 0);

        List<ProductDto> productDtoList = productService.getAllProducts();
        assertTrue(productDtoList.size() == 0);

        for (int i = 0; i < 100; i++) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTimeInMillis() - i * 24L * 60 * 60 * 1000);
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', date, "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*1.05*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productService.create(productDto);
        }
        productDtoList = productService.getAllProducts();
        assertTrue(productDtoList.size() == 100);

        for (int i = 100; i < 200; i++) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTimeInMillis() - i * 24L * 60 * 60 * 1000);
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', date, "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*1.05*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productService.create(productDto);
        }
        productDtoList = productService.getAllProducts();
        assertTrue(productDtoList.size() == 200);

        productService.removeAll();
        productDtoList = productService.getAllProducts();
        assertTrue(productDtoList.size() == 0);
    }

    */
/*
     ProductServiceImpl의 getOneProduct 메서드 테스트하기
     1. 100개 추가
     2. 50번째 데이터 선택
     3. 조회수 확인
     4. 50번째 데이터 50번 선택
     5. 조회수 확인
     6. 없는 데이터 선택 50번 선택
     7. 조회수 확인
     *//*

    @Test
    public void getOneProductTest() throws Exception {
        productService.removeAll();
        assertTrue(productService.getCount() == 0);

        for (int i = 0; i < 100; i++) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTimeInMillis() - i * 24L * 60 * 60 * 1000);
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', date, "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*1.05*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productService.create(productDto);
        }
        assertTrue(productService.getCount() == 100);

        assertTrue(productService.getOneProduct("APP49-50").getHit_cnt() == 0);

        for (int i = 0; i < 50; i++) {
            productService.getOneProduct("APP49-50");
        }
        */
/*
        assertTrue 구문 안에서 getOneProduct 메서드를 호출했으므로 1이 추가되어야 한다.
        *//*

        assertTrue(productService.getOneProduct("APP49-50").getHit_cnt() == 51);

        for (int i = 0; i < 50; i++) {
            productService.getOneProduct("APP490-50");
        }

        assertThrows(NullPointerException.class, () -> productService.getOneProduct("pd_id500").getHit_cnt());
    }

    */
/*
     ProductServiceImpl의 modifyContent 테스트
     1. 데이터 20개 추가
     2. 20번째 제품명 변경
     3. 19번째 모델명 변경
     *//*

    @Test
    public void modifyContentTest() throws Exception {
        productService.removeAll();
        assertTrue(productService.getCount() == 0);

        for (int i = 0; i < 20; i++) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTimeInMillis() - i * 24L * 60 * 60 * 1000);
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', date, "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*1.05*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productService.create(productDto);
        }

        ProductDto productDto = productService.getOneProduct("APP19-50");
        productDto.setPd_name("pd_name190");
        productService.modifyContent(productDto);
        assertEquals("pd_name190", productService.getOneProduct("APP19-50").getPd_name());

        productDto = productService.getOneProduct("APP18-50");
        productDto.setMdl_name("mdl_name180");
        productService.modifyContent(productDto);
        assertEquals("mdl_name180", productService.getOneProduct("APP18-50").getMdl_name());
    }

    */
/*
     ProductServiceImpl의 updateStatus 테스트
     1. 데이터 20개 추가
     2. 20번째 데이터 상태 1~10으로 변경
     3. 없는 데이터 상태 변경
     *//*

    @Test
    public void updateStatusTest() throws Exception {
        productService.removeAll();
        assertTrue(productService.getCount() == 0);

        for (int i = 0; i < 20; i++) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTimeInMillis() - i * 24L * 60 * 60 * 1000);
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', date, "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*1.05*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productService.create(productDto);
        }

        ProductDto productDto = productService.getOneProduct("APP19-50");
        for(int i=1;i<=10;i++) {
            productDto.setPd_stat_hist_cd(i+"");
            productService.updateStatus(productDto);
            assertEquals(i+"", productService.getOneProduct("APP19-50").getPd_stat_hist_cd());
        }
    }
}*/
