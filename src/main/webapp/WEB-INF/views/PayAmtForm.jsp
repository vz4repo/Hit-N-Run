<%--
  Created by IntelliJ IDEA.
  User: hyunjimoon
  Date: 2024-04-23
  Time: PM 2:21
  To change this template use File | Settings | File Templates.
--%>
<%--

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>결제정보데이터 넣기</title>
</head>
<body>
<form id="insertPayAmt" name="insertPayAmt" method="post">
    <table style="border:1px solid blue;">
        <tr>
            <td>주문번호: </td>
            <td><input type="text" placeholder="주문번호를 입력해주세요." name="odId"></td>
        </tr>
        <tr>
            <td>할인금액: </td>
            <td><input type="number" placeholder="할인금액을 입력해주세요." name="discAmt"></td>
            <td>주문결제금액: </td>
            <td><input type="number" placeholder="주문결제금액을 입력해주세요." name="odPayAmt"></td>
            <td>결제최종금액: </td>
            <td><input type="number" placeholder="결제최종금액을 입력해주세요." name="payFinalAmt"></td>
        </tr>
        <tr>
            <td>
                <input type="button" onclick="fnInsertPayAmt('/insertDataPayAmt');" value="저장">
            </td>
        </tr>
    </table>
</form>
</body>

<script type="text/javascript">
    function fnInsertPayAmt(pageUrl) {
        var frm = document.getElementById("insertPayAmt");
        frm.action = pageUrl;
        frm.submit();
    }
</script>
</html>
--%>
