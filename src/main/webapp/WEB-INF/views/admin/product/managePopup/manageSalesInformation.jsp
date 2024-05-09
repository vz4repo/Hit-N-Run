<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        <%@include file="/resources/css/adminMenu.css"%>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            text-align: left;
        }

        strong {
            font-weight: bold;
            color: #1b64da;
        }

        textarea {
            width: 100%;
            height: 200px;
        }
    </style>
    <title>SalesInformation</title>
    <% String msg = (String) request.getAttribute("msg"); %>
    <% if (msg != null && !msg.isEmpty()) { %>
    <script>
        alert("<%= msg %>");
    </script>
    <% } %>
</head>
<body>
<jsp:include page="../../adminMenu.jsp" flush="false" />
<div class="main">
    <h1>판매 정보 일괄변경</h1>
    <form id="registerForm" action="<c:url value='/admin/product/manage'/>" method="post">
        <div class="product_content">
            <table style="width:100%">
                <tr>
                    <th colspan="2">
                        총 <strong>${selectedProductCount}</strong>개 제품의 판매 정보를 일괄 변경합니다.
                    </th>
                </tr>
                <tr>
                    <th colspan="2">
                        <input type="checkbox" id="selectAll"><label for="selectAll">전체 선택</label>
                    </th>
                </tr>
                <tr>
                    <th><input type="checkbox" name="selectedContent" id="minOrderQuantity" value="min_od_qty"><label for="minOrderQuantity">최소 주문 수량</label></th>
                    <td>
                        <input type="text" id="min_od_qty" name="min_od_qty" size="4" value="1" >개 이상
                    </td>
                </tr>
                <tr>
                    <th><input type="checkbox" name="selectedContent" id="maxOrderQuantity" value="max_od_qty"><label for="maxOrderQuantity">최대 주문 수량</label></th>
                    <td>
                        <input type="text" id="max_od_qty" name="max_od_qty" size="4" value="9999">개 이하
                    </td>
                </tr>
                <tr>
                    <th><input type="checkbox" name="selectedContent" id="salesStartDate" value="sls_strt_dt"><label for="salesStartDate">판매 예정일</label></th>
                    <td>
                        <input type='date' id="sls_strt_dt" name='sls_strt_dt' />
                    </td>
                </tr>
                <tr>
                    <th><input type="checkbox" name="selectedContent" id="productManufactureDate" value="pd_mnf_date"><label for="productManufactureDate">제품 제조년월</label></th>
                    <td>
                        <input type='date' id="pd_mnf_date" name='pd_mnf_date' />
                    </td>
                </tr>
            </table>
            <input type="hidden" name="productList" value="${productList}">
            <input type="hidden" name="selectedContent" value="${selectedContent}">
        </div>
        <div class="buttons">
            <button type="submit" class="registerBtn" id="registerBtn">선택항목 일괄변경</button>
            <button type="button" class="cancelBtn" id="cancelBtn">취소</button>
        </div>
    </form>
</div>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script>
    $(document).ready(function() {
        /*전체 선택을 클릭하는 경우 발생하는 함수*/
        $("#selectAll").click(function() {
            /*전체 선택이 체크되어 있다면 나머지 체크박스도 체크되게 한다.*/
            if($("#selectAll").is(":checked")) $("input[name=selectedContent]").prop("checked", true);
            /*그렇지 않다면 나머지 체크박스가 체크되지 않게 한다.*/
            else $("input[name=selectedContent]").prop("checked", false);
        });

        /*체크 박스 하나만을 선택했을 때 발생하는 함수*/
        $("input[name=selectedContent]").click(function() {
            /*total에 체크박스의 전체 개수를 저장한다.*/
            let total = $("input[name=selectedContent][type=checkbox]").length;
            /*checked에 체크가 된 체크박수의 개수를 저장한다.*/
            let checked = $("input[name=selectedContent]:checked").length;

            /*전체 체크박스의 수와 체크된 체크박스의 개수가 다르면 전체 선택이 체크되지 않게 한다.*/
            if(total != checked) $("#selectAll").prop("checked", false);
            /*전체 체크박스의 수와 체크된 체크박스의 개수가 동일하다면 전체 선택이 체크되게 한다.*/
            else $("#selectAll").prop("checked", true);
        });

        $("#registerBtn").on("click",function(event){
            let checked = $("input[name=selectedContent]:checked").length;
            if (checked == 0) {
                alert("하나 이상의 항목을 선택해주세요.");
                event.preventDefault();
            }

            /*아무것도 선택하지 않았으면 값을 입력해달라고 경고창 띄우기*/
        });

        let selectedContent = {};
        $('input:checkbox[name="selectedContent"]').each(function() {
            if (this.checked) {
                selectedContent[$(this).attr('id')] = $('input[name="' + $(this).attr('id') + '"]:checked').val();
            }
        });
    });

    // 취소 버튼 클릭하면 뒤로 가기
    document.getElementById("cancelBtn").addEventListener("click", function() {
        window.history.back();
    });
</script>
</script>
</body>
</html>