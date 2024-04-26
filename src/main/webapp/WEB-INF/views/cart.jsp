<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
<%--    <link rel="stylesheet" href="reset.css" />--%>
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet" />
<%--    <link rel="stylesheet" href="cart.css" />--%>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <title>장바구니</title>
</head>
<body>
<div id="header">

</div>

<div class="head_cart">SHOPPING CART</div>
<main>
    <hr class="first__under" />
    <div class="title__cart">장바구니</div>
    <hr class="second__under" />
    <div class="tb__cart">
        <table style="width: 100%">
            <colgroup>
                <c:choose>
                    <c:when test="${cartEmpty == 'CART_EMPTY'}">
                        <col width="100%" />
                    </c:when>
                    <c:otherwise>
                        <col width="50" />
                        <col width="70" />
                        <col width="*" />
                        <col width="100" />
                        <col width="90" />
                        <col width="90" />
                    </c:otherwise>
                </c:choose>
            </colgroup>
            <thead>
            <tr>
                <th><input type="checkbox" id="th_checkbox" name="remember" checked="checked"/></th>
                <th scope="col"><div>이미지</div></th>
                <th scope="col"><div>상품정보</div></th>
                <th scope="col"><div>판매가</div></th>
                <th scope="col"><div>수량</div></th>
                <th scope="col"><div>배송구분</div></th>
                <th scope="col"><div>선택</div></th>
            </tr>
            </thead>
            <tbody>
            <c:choose>
                <c:when test="${cartEmpty == 'CART_EMPTY'}">
                    <td colspan="7"><h1>장바구니에 담긴 상품이 없습니다.</h1></td>
                </c:when>
                <c:otherwise>
                    <form action="/homerunball/cart/list" id="form">
                        <c:forEach var="cartDto" items="${list}">
                            <tr>
                                <td><input type="checkbox" id="tb_checkbox" name="tb_checkbox" /></td>
                                <td>
                                    <a href="#"><img src="#" alt="썸네일" name="thumbnail" /></a>
                                </td>
                                <td>
                                    <a href="#">상품명가져오기</a>
                                    <span name="size">사이즈: ${cartDto.pd_clsf_code} </span>
                                </td>
                                <td><span name="price"></span>판매가 원</td>
                                <td>
                                    <div>
                                        <input type="text" name="count" value="${cartDto.cart_cnt}" />
                                        <span class="btns">
                                          <a href=""></a>
                                          <a href=""></a>
                                        </span>
                                        <a href="#">변경</a>
                                    </div>
                                </td>
                                <td>
                                    <span>무료배송</span>
                                </td>
                                <td>
                                    <button type="button" class="deleteBtn">삭제</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </form>
                </c:otherwise>
            </c:choose>
            </tbody>
            <tfoot>
            <tr>
                <td colspan="2">
                    <div class="tb__left"><span>[기본배송]</span></div>
                </td>
            </tr>
            <tr>
                <td colspan="7">
                    <div class="tb__right">
                        <span>상품구매금액</span>
                        <span>배송비 : 0</span>
                        <span>= 합계:</span>
                        <span>원</span>
                    </div>
                </td>
            </tr>
            </tfoot>
        </table>
    </div>
</main>
<script>
    $(document).ready(function (){
        $('.deleteBtn').on("click", function(){
            if(!confirm("삭제하시겠습니까?")) return;
            let form = $('form');
            form.attr("action", "<c:url value='/cart/remove'/>")
            form.attr("method", "post");
            form.submit();
        })
    })

</script>
</body>
</html>
