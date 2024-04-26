<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<body>
    <h2>Hello Home run()</h2>
    <h2>SYSDATE : ${empty curDate? "no conn" : curDate }</h2>

    <form id="testPayment" name="testPayment" >
        <%--
        <input type="button" onclick="fnPageChange('/PayAmtForm');" value="결제하기">
        --%>
        <input type="button" onclick="fnPageChange('/PayAmtList');" value="결제조회하기">
    </form>
</body>
<script type="text/javascript">
    function fnPageChange(pageUrl) {
        const frm = document.getElementById("testPayment");
        frm.action = pageUrl;
        frm.submit();
    }
</script>
</html>
