package com.homerunball.admin.product.service;

import com.homerunball.admin.product.domain.ProductDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ProductServiceImplTest {
    @Autowired
    private ProductService productService;

    /* productService가 연결되었는지 테스트하기 */
    @Test
    public void linkTest() {
        System.out.println("ProductService = " + productService);
        Assert.assertTrue(productService != null);
    }

    /*
     ProductServiceImpl의 getCount 테스트하기
     1. 100개 추가 후 count
     2. 50개 삭제 후 count
     3. 50개 추가 후 count
     */
    @Test
    public void getCountTest() throws Exception {
        productService.removeAll();
        Assert.assertTrue(productService.getAllCount() == 0);

        for (int i = 0; i < 100; i++) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTimeInMillis() - i * 24L * 60 * 60 * 1000);
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg","mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productService.create(productDto);
        }
        Assert.assertTrue(productService.getAllCount() == 100);

        for (int i = 99; i > 49; i--) {
            productService.remove(i+"");
        }
        Assert.assertTrue(productService.getAllCount() == 50);

        for (int i = 50; i < 100; i++) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTimeInMillis() - i * 24L * 60 * 60 * 1000);
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg","mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productService.create(productDto);
        }
        Assert.assertTrue(productService.getAllCount() == 100);
    }

    /*
     ProductServiceImpl의 removeAll 테스트하기
     1. 100개 추가
     2. removeAll  -> count = 0인지
     3. 추가 안 하고 removeAll -> count 0인지
     */
    @Test
    public void removeAllTest() throws Exception {
        productService.removeAll();
        Assert.assertTrue(productService.getAllCount() == 0);

        for (int i = 0; i < 100; i++) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTimeInMillis() - i * 24L * 60 * 60 * 1000);
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg","mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productService.create(productDto);
        }

        productService.removeAll();
        Assert.assertTrue(productService.getAllCount() == 0);

        productService.removeAll();
        Assert.assertTrue(productService.getAllCount() == 0);
    }

    /*
     ProductServiceImpl의 remove 테스트하기
     1. 100개 추가
     2. 있는 데이터 50개 삭제 후 개수 확인
     3. 없는 데이터 50개 삭제 후 개수 확인
     */
    @Test
    public void removeTest() throws Exception {
        productService.removeAll();
        Assert.assertTrue(productService.getAllCount() == 0);

        for (int i = 0; i < 100; i++) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTimeInMillis() - i * 24L * 60 * 60 * 1000);
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg","mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productService.create(productDto);
        }
        Assert.assertTrue(productService.getAllCount() == 100);

        for(int i = 99; i > 49; i--) {
            productService.remove(i+"");
        }
        Assert.assertTrue(productService.getAllCount() == 50);

        for(int i = 99; i > 49; i--) {
            productService.remove(i+"");
        }
        Assert.assertTrue(productService.getAllCount() == 50);
    }

    /*
     ProductServiceImpl의 create 테스트하기
     1. 1,000개 넣고 개수 확인
     2. 50개 넣고 개수 확인
     3. 중복 데이터 넣어보기
     */
    @Test
    public void createTest() throws Exception {
        productService.removeAll();
        Assert.assertTrue(productService.getAllCount() == 0);

        for (int i = 0; i < 1000; i++) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTimeInMillis() - i * 24L * 60 * 60 * 1000);
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg","mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productService.create(productDto);
        }
        Assert.assertTrue(productService.getAllCount() == 1000);

        for (int i = 1000; i < 1050; i++) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTimeInMillis() - i * 24L * 60 * 60 * 1000);
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg","mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productService.create(productDto);
        }
        Assert.assertTrue(productService.getAllCount() == 1050);

        for (int i = 1000; i < 1050; i++) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTimeInMillis() - i * 24L * 60 * 60 * 1000);
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg","mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            Assert.assertThrows(DuplicateKeyException.class, () -> productService.create(productDto));
        }
    }

    /*
     ProductServiceImpl getAllProducts 테스트하기
     1. 100개 추가 후 getAllProducts -> 100개 확인
     2. 100개 추가 후 getAllProducts -> 200개 확인
     3. 모두 삭제 후 getAllProducts -> 0개 확인
     */
    @Test
    public void getAllProductsTest() throws Exception {
        productService.removeAll();
        Assert.assertTrue(productService.getAllCount() == 0);

        List<ProductDto> productDtoList = productService.getAllProducts();
        Assert.assertTrue(productDtoList.size() == 0);

        for (int i = 0; i < 100; i++) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTimeInMillis() - i * 24L * 60 * 60 * 1000);
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg","mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productService.create(productDto);
        }
        productDtoList = productService.getAllProducts();
        Assert.assertTrue(productDtoList.size() == 100);

        for (int i = 100; i < 200; i++) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTimeInMillis() - i * 24L * 60 * 60 * 1000);
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg","mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productService.create(productDto);
        }
        productDtoList = productService.getAllProducts();
        Assert.assertTrue(productDtoList.size() == 200);

        productService.removeAll();
        productDtoList = productService.getAllProducts();
        Assert.assertTrue(productDtoList.size() == 0);
    }

    /*진열되지 않은 모든 제품을 선택하는 getAllOutProducts 테스트하기*/
    @Test
    public void getAllOutProducts() throws Exception {
        /*0. db 서버가 실행되지 않을 때 테스트하기*/
        try {
            /*1. DB 초기화*/
            productService.removeAll();
            Assert.assertTrue(productService.getAllCount() == 0);

            /*2. productDtoList 선언*/
            List<ProductDto> outProductList = productService.getAllOutProducts();
            Assert.assertTrue(outProductList.size() == 0);

            /*3. 진열이 제외된 제품 1개 추가한 다음 getAllOutProducts로 개수 확인*/
            ProductDto productDto = new ProductDto("APP000001-40", "pd_name1", "mdl_name1", "qlt_cd1", "ctg", "mn_img_fn"+1, "det_img_fn1", "pd_ad_cmt1", "pd_smr_dsc1", "pd_det_dsc"+1, 1,1, 'N', "20240428", "20240414", "og_pd_num1", "origin", "mfr", "srs_id", "ADT", "player_nm", "mtrl", "season", 100, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            Assert.assertTrue(productService.create(productDto) == 1);
            outProductList = productService.getAllOutProducts();
            Assert.assertTrue(outProductList.size() == 1);

            /*4. 진열하고 있는 제품 1개를 추가한 다음 getAllOutProducts로 개수 확인*/
            productDto = new ProductDto("APP000002-40", "pd_name1", "mdl_name1", "qlt_cd1", "ctg", "mn_img_fn"+1, "det_img_fn1", "pd_ad_cmt1", "pd_smr_dsc1", "pd_det_dsc"+1, 1,1, 'Y', "20240428", "20240414", "og_pd_num1", "origin", "mfr", "srs_id", "ADT", "player_nm", "mtrl", "season", 100, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            Assert.assertTrue(productService.create(productDto) == 1);
            outProductList = productService.getAllOutProducts();
            Assert.assertTrue(outProductList.size() == 1);

            /*5. DB 초기화*/
            productService.removeAll();
            Assert.assertTrue(productService.getAllCount() == 0);

            /*6. 진열이 제외된 제품 100개 추가 후 selectPrdAll -> 100개 확인*/
            for (int i = 0; i < 100; i++) {
                productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg", "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
                Assert.assertTrue(productService.create(productDto) == 1);
            }
            outProductList = productService.getAllOutProducts();
            Assert.assertTrue(outProductList.size() == 100);

            /*7. 진열이 제외된 제품 100개 추가 후 getAllOutProducts -> 100개 확인*/
            for (int i = 100; i < 200; i++) {
                productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg", "mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'Y', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
                Assert.assertTrue(productService.create(productDto) == 1);
            }
            outProductList = productService.getAllOutProducts();
            Assert.assertTrue(outProductList.size() == 100);

//            /*8. DB 초기화*/
//            productService.removeAll();
//            assertTrue(productService.getAllCount() == 0);
//
//            /*9. 0개 확인*/
//            outProductList = productService.getAllOutProducts();
//            assertTrue(outProductList.size() == 0);
        } catch (MyBatisSystemException e) {
            System.out.println("MySql Server Stopped");
        }
    }

    /*
     ProductServiceImpl의 getOneProduct 메서드 테스트하기
     1. 100개 추가
     2. 50번째 데이터 선택
     3. 조회수 확인
     4. 50번째 데이터 50번 선택
     5. 조회수 확인
     6. 없는 데이터 선택 50번 선택
     7. 조회수 확인
     */
    @Test
    public void getOneProductTest() throws Exception {
        productService.removeAll();
        Assert.assertTrue(productService.getAllCount() == 0);

        for (int i = 0; i < 100; i++) {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date(calendar.getTimeInMillis() - i * 24L * 60 * 60 * 1000);
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg","mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productService.create(productDto);
        }
        Assert.assertTrue(productService.getAllCount() == 100);

        Assert.assertTrue(productService.getOneProduct("49").getHit_cnt() == 0);

        for (int i = 0; i < 50; i++) {
            productService.getOneProduct("49");
        }
        /*
        assertTrue 구문 안에서 getOneProduct 메서드를 호출했으므로 1이 추가되어야 한다.
        */
        Assert.assertTrue(productService.getOneProduct("49").getHit_cnt() == 51);

        for (int i = 0; i < 50; i++) {
            productService.getOneProduct("APP490-50");
        }

        Assert.assertThrows(NullPointerException.class, () -> productService.getOneProduct("pd_id500").getHit_cnt());
    }

    /*
     ProductServiceImpl의 modifyContent 테스트
     1. 데이터 20개 추가
     2. 20번째 제품명 변경
     3. 19번째 모델명 변경
     */
    @Test
    public void modifyContentTest() throws Exception {
        productService.removeAll();
        Assert.assertTrue(productService.getAllCount() == 0);

        for (int i = 0; i < 20; i++) {
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg","mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productService.create(productDto);
        }

        productService.getOneProduct("19").setPd_name("pd_name190");
        productService.modifyContent(productService.getOneProduct("19"));
        Assert.assertTrue(productService.getOneProduct("19").getPd_name().equals("pd_name190"));

        productService.getOneProduct("18").setMdl_name("mdl_name180");
        productService.modifyContent(productService.getOneProduct("18"));
        Assert.assertTrue(productService.getOneProduct("18").getMdl_name().equals("mdl_name180"));
    }

    /*
    ProductServiceImpl의 findBiggestSerialNumber 테스트
    1. productDao로 db에 APP 데이터 100개 추가
    2. APP의 시리얼 넘버가 가장 큰 경우는 99이다.
    3. 데이터가 추가되지 않은 GLV를 선택한 경우
    */
    @Test
    public void findBiggestSerialNumberTest() throws Exception {
        productService.removeAll();
        Assert.assertTrue(productService.getAllCount() == 0);

        for (int i = 0; i < 100; i++) {
            ProductDto productDto = new ProductDto("APP" + i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg","mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productService.create(productDto);
        }
        Assert.assertTrue(productService.getAllCount() == 100);

        System.out.println("productService.findBiggestSerialNumber(\"APP\") = " + productService.findBiggestSerialNumber("APP"));
        Assert.assertTrue(productService.findBiggestSerialNumber("APP") == 99);

        Assert.assertThrows(NullPointerException.class, () -> productService.findBiggestSerialNumber("GLV"));
    }

    /*
    ProductServiceImpl의 countProductType 테스트
    1. productDao로 db에 APP 데이터 100개 추가
    2. APP의 개수 확인
    3. 추가되지 않은 GLV의 개수 확인
    */
    @Test
    public void countProductTypeTest() throws Exception {
        productService.removeAll();
        Assert.assertTrue(productService.getAllCount() == 0);

        for (int i = 0; i < 100; i++) {
            ProductDto productDto = new ProductDto(i+"", "pd_name"+i, "mdl_name"+i, "qlt_cd"+i, "ctg","mn_img_fn"+i, "det_img_fn"+i, "pd_ad_cmt"+i, "pd_smr_dsc"+i, "pd_det_dsc"+1, i, i, 'N', "20240428", "20240414", "og_pd_num"+i, "origin", "mfr", "srs_id"+i, "ADT", "player_nm", "mtrl", "season", 100*i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            productService.create(productDto);
        }
        Assert.assertTrue(productService.countProductType("APP") == 100);

        Assert.assertTrue(productService.countProductType("GLV") == 0);
    }

    /*ProductServiceImpl의 showProduct 테스트*/
    @Test
    public void updateToShowTest() throws Exception {
        /*0. db 서버가 실행되지 않을 때 테스트하기*/
//        try {
        /*1. DB 초기화*/
        productService.removeAll();
        Assert.assertTrue(productService.getAllCount() == 0);

        /*2. 데이터 1개 추가한 다음 진열된 상태로 변경 후 제대로 변경됐는지 확인하기*/
        ProductDto productDto = new ProductDto("APP000001-40", "pd_name1", "mdl_name1", "qlt_cd1", "ctg", "mn_img_fn"+1, "det_img_fn1", "pd_ad_cmt1", "pd_smr_dsc1", "pd_det_dsc"+1, 1,1, 'N', "20240428", "20240414", "og_pd_num1", "origin", "mfr", "srs_id", "ADT", "player_nm", "mtrl", "season", 100, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
        Assert.assertTrue(productService.create(productDto) == 1);
        Assert.assertTrue(productService.showProduct(List.of("APP000001-40")) == 1);
        Assert.assertTrue(productService.getOneProduct("APP000001-40").getPd_is_show() == 'Y');

        /*3. 데이터 1개를 더 추가한 다음 진열된 상태로 변경  -> 진열 제외 -> 진열 상태로 제대로 변경됐는지 확인하기*/
        productDto = new ProductDto("APP000002-40", "pd_name1", "mdl_name1", "qlt_cd1", "ctg", "mn_img_fn"+1, "det_img_fn1", "pd_ad_cmt1", "pd_smr_dsc1", "pd_det_dsc"+1, 1,1, 'N', "20240428", "20240414", "og_pd_num1", "origin", "mfr", "srs_id", "ADT", "player_nm", "mtrl", "season", 100, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
        Assert.assertTrue(productService.create(productDto) == 1);
        /*3-1진열 상태로 변경*/
        Assert.assertTrue(productService.showProduct(List.of("APP000002-40")) == 1);
        Assert.assertTrue(productService.getOneProduct("APP000002-40").getPd_is_show() == 'Y');
        /*3-2 진열 제외 상태로 변경*/
        productDto.setPd_is_show('N');
        Assert.assertTrue(productService.modifyContent(productDto) == 1);
        Assert.assertTrue(productService.getOneProduct("APP000002-40").getPd_is_show() == 'N');
        /*3-3 진열 상태로 변경*/
        Assert.assertTrue(productService.showProduct(List.of("APP000002-40")) == 1);
        Assert.assertTrue(productService.getOneProduct("APP000002-40").getPd_is_show() == 'Y');

        /*4. DB 초기화*/
        productService.removeAll();
        Assert.assertTrue(productService.getAllCount() == 0);

        /*5. 데이터를 100개 추가하기*/
        for (int i = 0; i < 100; i++) {
            productDto = new ProductDto(i+"", "pd_name" + i, "mdl_name" + i, "qlt_cd" + i, "ctg", "mn_img_fn" + i, "det_img_fn" + i, "pd_ad_cmt" + i, "pd_smr_dsc" + i, "pd_det_dsc" + 1, i, i, 'N', "20240428", "20240414", "og_pd_num" + i, "origin", "mfr", "srs_id" + i, "ADT", "player_nm", "mtrl", "season", 100 * i, "50", "pd_chr_cd", "BASE", "APP", "SMT", "MZN");
            Assert.assertTrue(productService.create(productDto) == 1);
        }

        /*6. 99, 100번째의 데이터를 진열상태로 변경하기*/
        Assert.assertTrue(productService.showProduct(List.of("98", "99")) == 2);
        Assert.assertTrue(productService.getOneProduct("98").getPd_is_show() == 'Y');
        Assert.assertTrue(productService.getOneProduct("99").getPd_is_show() == 'Y');

        /*7. 없는 제품을 진열 상태로 변경하기*/
        Assert.assertTrue(productService.showProduct(List.of("1000")) == 0);
//        } catch (MyBatisSystemException e) {
//            System.out.println("MySql Server Stopped");
//        }
    }
}