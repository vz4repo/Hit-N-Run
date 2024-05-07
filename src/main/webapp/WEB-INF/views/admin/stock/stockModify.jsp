<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <style>
        <%@include file="/resources/css/adminMenu.css" %>
    </style>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            text-align: left;
        }
    </style>
    <title>재고 등록하기 페이지</title>
</head>
<body>
<jsp:include page="../adminMenu.jsp" flush="false"/>
<div class="main">
    <h1>재고 등록 화면</h1>
    <div class="stock-container">
        <form>
            <table>
                <tr>
                    <th colspan="10">재고 정보 등록</th>
                </tr>
                <tr>
                    <th class="pd_id">제품ID</th>
                    <td class="pd_id"></td>
                </tr>
                <tr>
                    <th class="pd_name">제품명</th>
                </tr>
                <tr>
                    <th class="pd_clsf_cd">제품 구분 코드</th>

                </tr>
                <tr>
                    <th class="nml_stk_qty">정상재고 수량</th>

                </tr>
                <tr>
                    <th class="rt_stk_qty">반품재고 수량</th>

                </tr>

                <tr>
                    <th class="rgn_stk_qty">재생가능재고 수량</th>

                </tr>
                <tr>
                    <th class="urgn_stk_qty">재생불가능재고 수량</th>

                </tr>
                <tr>
                    <th class="sfty_stk_qty">안전재고 수량</th>

                </tr>
                <tr>
                    <th class="odpmt_stk">가용재고</th>

                </tr>
                <tr>
                    <th class="pur_dt">매입일</th>

                </tr>
                <tr>
                <th class="rcpt_dt">입고일</th>
                </tr>
                <tr>
                    <th class="rcpt_cp">입고처</th>
                </tr>
                <tr>
                    <th class="rcpt_prc">입고가격</th>
                </tr>
                <tr>
                    <th class="rtl_prc">소비자가격</th>
                </tr>
                <tr>
                    <th class="sls_prc">판매가격</th>
                </tr>
                <tr>
                    <th class="stk_plc_cd">재고 위치 코드</th>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
