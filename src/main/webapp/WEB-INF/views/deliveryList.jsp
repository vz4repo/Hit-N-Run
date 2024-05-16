<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://kit.fontawesome.com/f0e73cfa04.js" crossorigin="anonymous"></script>
</head>
<style>
    .dlvAddrList {
        border: 1px solid black;
        padding: 10px;
        margin-bottom: 10px;
        width: 50%; /* 50% width */
    }
    .dlvAddrList table {
        margin: 0 auto; /* 테이블 가운데 정렬 */
    }
    .dlvAddrList button {
        margin-left: 10px;
    }

    #deliveryForm {
        display: flex;
        justify-content: center;
        flex-wrap: wrap; /* 요소가 너무 많을 때 다음 줄로 넘어갈 수 있도록 설정 */
    }

    .modal{
        position:absolute;
        top:50%;
        width:400px;
        height:600px;
        padding:40px;
        text-align: center;
        background-color: rgb(255,255,255);
        border-radius:10px;
        box-shadow:0 2px 3px 0 rgba(34,36,38,0.15);
        transform:translateY(-50%);
    }
</style>
<body>



<%--<p>띄우는거 성공</p>--%>

<%--<select id="customerIdSelecte">--%>
<%--    <option value="1001"> 1번고객 </option>--%>
<%--    <option value="1002"> 2번고객 </option>--%>
<%--    <option value="1003"> 3번고객 </option>--%>
<%--    <option value="1004"> 4번고객 </option>--%>
<%--    <option value="1005"> 5번고객 </option>--%>
<%--</select>--%>

<%-- 로그인이 되면 session을 통해 c_id를 가져옴 --%>
<div style="text-align: center;">
    <div>
        고객 C_ID : ${sessionScope.c_id}
    </div>
    <button id="selectAllBtn">배송지 전체 조회</button>
</div>

<%--
<div id="deliveryForm">
    &lt;%&ndash; items : 여러개의 데이터가 담긴 객체, var : 반복 변수? <-정확히 몬지 모르겠음 &ndash;%&gt;
    <c:forEach var="list" items="${list}">
        <div class="dlvAddrList">회원번호 ${list.c_id} | 배송지주소 고유번호:${list.c_adr_list_id}| 배송지명: ${list.rcver}| 배송지명: ${list.adr_name}| 연락처: ${list.rcver_phn}| 배송지: ${list.rcver_adr}| 우편번호:${list.rcver_zip} <button onclick=setDefault(${list.c_adr_list_id})>변경</button> <br/></div>
    </c:forEach>
</div>--%>

<div class="modal" style="display: none">
    <div>
        <h2>모달창 제목</h2>
        <div id="deliveryForm">
            <c:forEach var="list" items="${list}">
                <div class="dlvAddrList">
                    <table>
                        <tr>
                            <td>회원번호</td>
                            <td>${list.c_id}</td>
                            <td>배송지주소 고유번호</td>
                            <td>${list.c_adr_list_id}</td>
                            <td>배송지명</td>
                            <td>${list.rcver}</td>
                            <td>배송지명</td>
                            <td>${list.adr_name}</td>
                            <td>연락처</td>
                            <td>${list.rcver_phn}</td>
                            <td>배송지</td>
                            <td>${list.rcver_adr}</td>
                            <td>우편번호</td>
                            <td>${list.rcver_zip}</td>

                            <td><button class="selectDLV" data-c_adr_list_id="${list.c_adr_list_id}">변경</button></td>

                                <%--                            <td><button id="selectDLV" onclick="setSelectedDLV(${list.c_adr_list_id})">변경</button></td>--%>
                        </tr>
                    </table>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

</body>
<script>
    $(document).ready(function() {
        // "selectAll" 버튼 클릭 시 데이터 요청
        $('#selectAllBtn').click(function(event) {
            event.preventDefault(); // 버튼의 기본 동작 막기

            // setDefault 함수 호출
            setDefault();
        })

        // "selectDLV" 버튼 클릭시 데이터 전송
        $('.selectDLV').click(function(event) {
            event.preventDefault(); // 버튼의 기본 동작 막기
            // 클릭된 버튼의 data-c_adr_list_id 속성값 가져오기
            var c_adr_list_id = $(this).data('c_adr_list_id');
            setSelectedDLV(c_adr_list_id);
        });

        // setDefault 함수 정의
        function setDefault() {
            // AJAX를 사용하여 서버로 데이터 요청
            $.ajax({
                type: "GET",
                url: '<%= request.getContextPath() %>/delivery/deliveryList',
                data: {
                    c_id: '<%= session.getAttribute("c_id") %>' // 세션에서 c_id 값을 가져옴
                },
                success: function(response) {
                    // 받아온 데이터를 deliveryForm에 채워 넣음
                    $("#deliveryForm").html(response);
                    $(".modal").attr("style", "display:flex");
                },
                error: function(xhr, status, error) {
                    console.error(error);
                }
            });
        }

        // setSelectedDLV 함수 정의
        function setSelectedDLV(c_adr_list_id) {

            $.ajax({
                type: "GET",   // DATA를 서버로 전송
                url: '<%= request.getContextPath() %>/delivery/deliverySelected',
                data: {
                    dlvId: c_adr_list_id // 값을 넣음
                },
                success: function(response) {
                    // 페이지 이동
                    window.location.href = '<%= request.getContextPath() %>/delivery/deliverySelected?dlvId=' + c_adr_list_id;;
                },
                error: function(xhr, status, error) {
                    console.error(error);
                }

            });
        }
    });





    /*
        function setDefault(listId) {
            alert("hi~"+ listId);
        }
        // select 요소의 값이 변경될 때마다 getValue 함수 호출
        document.getElementById('customerIdSelecte').addEventListener('change', function() {
            var selectedCId = this.value;
            getValue(selectedCId);
        });
    */
</script>
</html>