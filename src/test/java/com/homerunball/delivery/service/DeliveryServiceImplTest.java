//package com.homerunball.delivery.service;
//
//import com.homerunball.delivery.domain.DeliveryDto;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//
//import static org.junit.Assert.assertTrue;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
//public class DeliveryServiceImplTest {
//    @Autowired
//    private DeliveryService deliveryService;
//
//    /* deliveryService가 연결되었는지 테스트하기 */
//    @Test
//    public void linkTest() {
//        System.out.println("deliveryService = " + deliveryService);
//        Assert.assertTrue(deliveryService != null);
//    }
//
//    @Test
//    public void readAllTest() throws Exception {
//        deliveryService.removeAll();
//        Assert.assertTrue(deliveryService.getAllCount() == 0);
//
//        for (int i = 0; i < 100; i++) {
//            DeliveryDto deliveryDto = new DeliveryDto(1001, i, "집"+i, "포차코"+i, "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
//            assertTrue(deliveryService.create(deliveryDto) == 1);
//        }
//        assertTrue(deliveryService.getAllCount() == 100);
//        System.out.println(deliveryService.readAll(1001).get(0).getAdr_name());
//        assertTrue(deliveryService.readAll(1001).get(0).getAdr_name().equals("집0"));
//        assertTrue(deliveryService.readAll(1001).size() == 100);
//    }
//
//
//    @Test
//    public void readTest() throws Exception {
//        deliveryService.removeAll();
//        Assert.assertTrue(deliveryService.getAllCount() == 0);
//
//        for (int i = 0; i < 100; i++) {
//            DeliveryDto deliveryDto = new DeliveryDto(1001, i, "집"+i, "포차코", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
//            assertTrue(deliveryService.create(deliveryDto) == 1);
//
//        }
//        assertTrue(deliveryService.getAllCount() == 100);
//    }
//
//
//    @Test
//    public void createTest() throws Exception {
//        deliveryService.removeAll();
//        Assert.assertTrue(deliveryService.getAllCount() == 0);
//
//        DeliveryDto deliveryDto = new DeliveryDto(1001, 1, "집", "포차코", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
//        deliveryService.create(deliveryDto);
//        assertTrue(deliveryService.getAllCount() == 1);
//        assertTrue(deliveryService.read(1001, 1).getRcver().equals("포차코"));
//
//        deliveryService.removeAll();
//        Assert.assertTrue(deliveryService.getAllCount() == 0);
//
//        for (int i = 0; i < 100; i++) {
//            deliveryDto = new DeliveryDto(1001, i, "집"+i, "포차코", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
//            assertTrue(deliveryService.create(deliveryDto) == 1);
//
//        }
//        assertTrue(deliveryService.getAllCount() == 100);
//    }
//
//
//    @Test
//    public void updateTest() throws Exception {
//        deliveryService.removeAll();
//        assertTrue(deliveryService.getAllCount() == 0);
//
//        DeliveryDto deliveryDto = new DeliveryDto(1001, 1, "집", "포차코", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
//        assertTrue(deliveryService.create(deliveryDto) == 1);
//        deliveryDto.setRcver("폼폼푸린");
//        deliveryDto.setAdr_name("오두막");
//
//        assertTrue(deliveryService.update(deliveryDto) == 1);
//        assertTrue(deliveryService.read(1001, 1).getRcver().equals("폼폼푸린"));
//
//        deliveryService.removeAll();
//        Assert.assertTrue(deliveryService.getAllCount() == 0);
//
//        for (int i = 0; i < 100; i++) {
//            deliveryDto = new DeliveryDto(1001, i, "집"+i, "포차코", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
//            assertTrue(deliveryService.create(deliveryDto) == 1);
//        }
//
//
//
////        String toUpdate = "훙냥냥";
////        deliveryService.read(c_id, c_adr_list_id).setAdr_name(toUpdate);
////        deliveryService.update()
//
////        deliveryService.update()
//
//
////        DeliveryDto toUpdate = deliveryService.read(1001, 99).getAdr_name()Adr_name("훙냥냥");
//
////        deliveryDto.setRcver("비트");
////        deliveryDto.setAdr_name("오두막집");
////
////
////
////        deliveryService.update(deliveryService.read(1001, 99).setRcver("비트"));
////
////        assertTrue(deliveryService.read(1001, 99).getRcver() == "비트");
//
//
//
//
//
//
//
//    }
//
//
//
//
//        @Test
//    public void removeTest() throws Exception {
//        deliveryService.removeAll();
//        assertTrue(deliveryService.getAllCount() == 0);
//
//        for (int i = 0; i < 100; i++) {
//            DeliveryDto deliveryDto = new DeliveryDto(1111, i, "집"+i, "포차코", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
//            assertTrue(deliveryService.create(deliveryDto) == 1);
//
//        }
//        assertTrue(deliveryService.getAllCount() == 100);
//
//        for(int i = 99; i > 49; i--) {
//            deliveryService.remove(1111, i);
//        }
//        assertTrue(deliveryService.getAllCount() == 50);
//    }
//
//
//    @Test
//    public void removeAllTest() throws Exception {
//        deliveryService.removeAll();
//        assertTrue(deliveryService.getAllCount() == 0);
//
//        for (int i = 50; i < 100; i++) {
//            DeliveryDto deliveryDto = new DeliveryDto(1111, i, "집"+i, "포차코", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
//            assertTrue(deliveryService.create(deliveryDto) == 1);
//
//        }
//
//        deliveryService.removeAll();
//        assertTrue(deliveryService.getAllCount() == 0);
//    }
//
//
//
//
//    /* DeliveryServiceImpl의 getCount 테스트 */
//    @Test
//    public void getAllCountTest() throws Exception {
//        deliveryService.removeAll();
//        Assert.assertTrue(deliveryService.getAllCount() == 0);
//
//        for (int i = 0; i < 100; i++) {
//            DeliveryDto deliveryDto = new DeliveryDto(1001, i, "집"+i, "포차코", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
//            deliveryService.create(deliveryDto);
//        }
//        assertTrue(deliveryService.getAllCount() == 100);
//
//        for (int i = 99; i > 49; i--) {
//            deliveryService.remove(1001,i);
//        }
//        assertTrue(deliveryService.getAllCount() == 50);
//
//        for (int i = 50; i < 100; i++) {
//            DeliveryDto deliveryDto = new DeliveryDto(1111, i, "집"+i, "포차코", "01012312344", "12345", "부산광역시 남구 수영로 36-9 201호");
//            deliveryService.create(deliveryDto);
//        }
//        assertTrue(deliveryService.getAllCount() == 100);
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//}
