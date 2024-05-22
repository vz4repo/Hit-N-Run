package com.homerunball.delivery.controller;

import com.homerunball.delivery.dao.DeliveryDao;
import com.homerunball.delivery.domain.DeliveryDto;
import com.homerunball.delivery.service.DeliveryService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/delivery") /* 원하는 url을 사용해서 해당 메서드 실행할수있게 해줌 */
public class DeliveryController {
    @Autowired /* 의존성 주입 */
    DeliveryDao deliveryDao;
    @Autowired
    DeliveryService deliveryService;

    /* 2024.05.21 [혁락] 안쓰는 요청 앞에 '_' 추가 */
    /* 유저 개인의 배송지 전체 목록 띄우는 */
    @GetMapping("/_deliveryList")
    /*public String deliveryList(HttpServletRequest request) {*/
    /* 고객 배송지 목록 출력 <- CartController 의 cartForm 에서 뺏겨옴*/
    /*public String deliveryList(int c_id, Model model, HttpSession session) throws Exception {*/
    /*    public String deliveryList(Model model, @RequestParam("c_id") int c_id) throws Exception {*/
    public String deliveryList(@SessionAttribute(name = "c_id")int sessionId, DeliveryDto dto, Model model) throws Exception {

        /* 로그인 되어있는지 체크하는 메서드로 체크. 안되어있으면 로그인페이지로 */
        /*로그인한 고객이 세션에있는지 확인한다*/
        /*int loginId = (int)session.getAttribute(c_id);*/

        try {   /* [혁락] 예외 추가 */
            /* 기본배송지 무조건 띄워줄 dto */
            DeliveryDto defaultDto = deliveryService.read(sessionId, 1);
            model.addAttribute("defaultDto", defaultDto);

            List<DeliveryDto> list = deliveryService.readAll(dto.getC_id());
            model.addAttribute("dlvList", list);

            System.out.println("dto.getC_id() = " + dto.getC_id());
            System.out.println("list = " + list);
        } catch (Exception e) {
            model.addAttribute("msg", e.toString());
            return "errorPage";
        }   /* end [혁락] 예외 추가 */

        return "deliveryList";
    }

    /* 2024.05.21 [혁락] 안쓰는 요청 앞에 '_' 추가 */
    /* TODO : 원장님이 파라미터에 @RequestParam("dlvId") Integer dlvId 이거 쓰지 마라그랬는데 ㅜㅜ */
    @GetMapping("/_deliverySelected")
    public String selectedList(@SessionAttribute(name = "c_id")int sessionId, Model model, DeliveryDto dto, @RequestParam("dlvId") Integer dlvId) throws Exception {
        try {
            /* 선택된 배송지 dto */
            DeliveryDto selectedDto = deliveryService.read(sessionId, dlvId);
            model.addAttribute("selectedDto", selectedDto);
            model.addAttribute("dlvId", dlvId); // dlvId도 모델에 추가
            System.out.println("***** 배송지 띄우기 = " + deliveryService.read(sessionId, dlvId));
            System.out.println("dto = " + dto); // 얘는 null
            System.out.println("selectedDto = " + selectedDto); // 얘는 값들어가있음.
            System.out.println("dto.getC_adr_list_id() = " + dlvId);
            System.out.println("dlvId = " + dlvId);

        } catch (Exception e) {
            e.printStackTrace();
        }
        /*        System.out.println("deliveryDto = " + deliveryDto.toString());*/
        return "deliveryList";
    }

    /* 2024.05.21 [혁락] 안쓰는 요청 앞에 '_' 추가 */
    @GetMapping("/__")
    public String selectedDefault(@SessionAttribute(name = "c_id")int sessionId, Model model) throws Exception {
        try {
            DeliveryDto deliveryDto = deliveryDao.selecteDefault(sessionId);
            model.addAttribute("selectedDto", deliveryDto);

            System.out.println("[DeliveryController]deliveryDto = " + deliveryDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "deliveryList";
    }

//    @GetMapping("/deliveryShowDeflt")
//    public String showDefaultDlv(@SessionAttribute(name = "c_id")int sessionId, DeliveryDto dto, Model model) throws Exception {
//        try {
//            System.out.println("s고객 아이디? = " + sessionId);
//
//            /* 일단 무조건 1번이 기본배송지로 하기 */
//            DeliveryDto deliveryDto = deliveryDao.select(sessionId, 1);
//            model.addAttribute("deliveryDto", deliveryDto);
//            System.out.println("dto로 배송지 출력해보기 = " + deliveryDto.toString());
//
//            System.out.println("첫번째 배송지 출력 = " + deliveryService.readAll(sessionId).get(0));
//            System.out.println("service 시험해보기 = " + deliveryService.read(sessionId, deliveryDto.getC_adr_list_id()));
//
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "deliveryShowDeflt";
//    }



//    @GetMapping("/deliveryAddrInput")
//    public String newAddrInput() throws Exception {
////        try {
////
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
//        return "deliveryAddrInput";
//    }

    /* 2024.05.21 [혁락] 요청이 겹쳐서 앞에 '_' 추가 */
    @GetMapping("/deliveryList")
    public ResponseEntity<Map<String, Object>> deliveryList(@SessionAttribute(name = "c_id") int sessionId) {
        Map<String, Object> response = new HashMap<>();
        try {
            List<DeliveryDto> list = deliveryService.readAll(sessionId);
            if (list.isEmpty()) {
                response.put("message", "조회된 내용이 없습니다.");
            } else {
                response.put("list", list);
            }
            System.out.println("response = " + response);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("error", "배송지 정보를 불러오는 중 오류가 발생했습니다.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/deliverySelected")
    public ResponseEntity<Map<String, Object>> selectedList(@SessionAttribute(name = "c_id") int sessionId, @RequestParam("dlvId") Integer dlvId) {
        Map<String, Object> response = new HashMap<>();
        try {
            DeliveryDto selectedDto = deliveryService.read(sessionId, dlvId);
            if (selectedDto == null) {
                response.put("message", "선택한 배송지 정보가 없습니다.");
            } else {
                response.put("selectedDto", selectedDto);
            }
            System.out.println("response = " + response);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("error", "선택한 배송지 정보를 불러오는 중 오류가 발생했습니다.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
