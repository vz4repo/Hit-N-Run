package com.homerunball.payment.controller;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.homerunball.cart.domain.CartDto;
import com.homerunball.order.dao.OrdDao;
import com.homerunball.order.dao.OrderDetDao;
import com.homerunball.order.domain.OrdDto;
import com.homerunball.order.domain.OrderDetDto;
import freemarker.ext.beans.StringModel;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/* [GET]  /payment  결제창 이동  */
/* [GET]  /success  인증 성공 처리 */
/* [GET]  /fail     인증 실패 처리 */
/* [POST] /confirm   승인 성공 후 처리 */
@Controller
public class WidgetController {
    @Autowired
    OrderDetDao orderDetDao;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("#{properties['widgetClientKey']}")
    private String widgetClientKey;
    @Value("#{properties['widgetSecretKey']}")
    private String widgetSecretKey;

    @GetMapping(value = "/payment")
    public String index( Model model) throws Exception {
        System.out.println("[paymentController] :: /payment ");
        model.addAttribute("widgetClientKey", widgetClientKey);
        return "/payCheckout";
    }

    /* 인증 성공 처리 */
    @GetMapping(value = "/success")
    public String successPayment(Model model) throws Exception {
        System.out.println("[paymentController] :: /success ");

        /* request session에서 로그인 했으면 c_id 가 저장되어있을것을 가정 */
        Integer c_id = 0001;

        OrderDetDto orderDetDto = new OrderDetDto(c_id);

        System.out.println(c_id);

        orderDetDao.insert(orderDetDto);

        System.out.println("====" + orderDetDto);


        return "/paySuccess";
    }

    /* 인증 실패 처리 */
    @GetMapping(value = "/fail")
    public String failPayment(HttpServletRequest request, Model model) throws Exception {
        System.out.println("[paymentController] :: /fail ");
        String failCode = request.getParameter("code");
        String failMessage = request.getParameter("message");

        model.addAttribute("code", failCode);
        model.addAttribute("message", failMessage);

        return "/payFail";
    }

    /* 인증 성공 후, payCheckout.jsp 에서 호출 */
    @PostMapping(value = "/confirm")
    public ResponseEntity<JSONObject> confirmPayment(@RequestBody String jsonBody) throws Exception {

        JSONParser parser = new JSONParser();
        String orderId;
        String amount;
        String paymentKey;
        try {
            /* 클라이언트에서 받은 JSON 요청 바디 */
            JSONObject requestData = (JSONObject) parser.parse(jsonBody);
            paymentKey = (String) requestData.get("paymentKey");
            orderId = (String) requestData.get("orderId");
            amount = (String) requestData.get("amount");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        };
        JSONObject obj = new JSONObject();
        obj.put("orderId", orderId);
        obj.put("amount", amount);
        obj.put("paymentKey", paymentKey);


        /* 토스페이먼츠 API는 시크릿 키를 사용자 ID로 사용, 비밀번호 미사용 */
        /* 비밀번호가 없다는 것을 알리기 위해 시크릿 키 뒤에 콜론 추가 */
        /* @docs https://docs.tosspayments.com/reference/using-api/api-keys */
        /* @docs https://docs.tosspayments.com/reference/using-api/authorization#%EC%9D%B8%EC%A6%9D */
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encodedBytes = encoder.encode((widgetSecretKey + ":").getBytes(StandardCharsets.UTF_8));
        String authorizations = "Basic " + new String(encodedBytes);

        /* 결제 승인 API를 호출 */
        /* 결제를 승인하면 결제수단에서 금액이 차감 */
        /* @docs https://docs.tosspayments.com/guides/payment-widget/integration#3-결제-승인하기 */
        URL url = new URL("https://api.tosspayments.com/v1/payments/confirm");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("Authorization", authorizations);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);


        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(obj.toString().getBytes("UTF-8"));

        int code = connection.getResponseCode();
        boolean isSuccess = code == 200;

        InputStream responseStream = isSuccess ? connection.getInputStream() : connection.getErrorStream();

        /* TODO: 결제 성공 및 실패 비즈니스 로직을 구현 */
        Reader reader = new InputStreamReader(responseStream, StandardCharsets.UTF_8);
        JSONObject jsonObject = (JSONObject) parser.parse(reader);
        responseStream.close();

        return ResponseEntity.status(code).body(jsonObject);
    }
}
