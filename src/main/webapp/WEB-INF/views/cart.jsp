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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" />
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
                    <c:forEach var="cartDto" items="${list}">
                        <tr>
                            <td><input type="checkbox" id="tb_checkbox" name="tb_checkbox" /></td>
                            <td>
                                <a href="#"><img src="#" alt="썸네일" name="thumbnail" /></a>
                            </td>
                            <td>
                                <a href="#">${cartDto.pd_id}</a>
                                <span name="size">사이즈: ${cartDto.pd_clsf_code} </span>
                            </td>
                            <td><span name="price"></span>판매가 원</td>
                            <td>
                                <div class="quantity_control">
                                    <form action="/cart/update" method="post" id="update_form">
                                        <input type="hidden" name="c_id" id="update_c_id" value="${cartDto.c_id}"/>
                                        <input type="hidden" name="pd_id" id="update_pd_id" value="${cartDto.pd_id}"/>
                                        <input type="hidden" name="pd_clsf_code" id="update_pd_clsf_code" value="${cartDto.pd_clsf_code}"/>
                                        <input type="text" name="cart_cnt" id="update_count" value="${cartDto.cart_cnt}"/>
                                        <button class="quantity_btn plus_btn"><i class="fas fa-sort-up"></i></button>
                                        <button class="quantity_btn minus_btn"><i class="fas fa-sort-down"></i></button>
                                        <button class="quantity_modify_btn" data-cid="${cartDto.c_id}" data-pdid="${cartDto.pd_id}" data-sizecd="${cartDto.pd_clsf_code}">변경</button>
                                    </form>
                                </div>
                            </td>
                            <td>
                                <span>무료배송</span>
                            </td>
                            <td>
                                <%-- c_id 고객번호, pd_id 제품코드, pd_clsf_code 사이즈 가 일치하는것을 선택해서 삭제 --%>
                                <button type="button" class="deleteBtn" data-cid="${cartDto.c_id}" data-pdid="${cartDto.pd_id}" data-sizecd="${cartDto.pd_clsf_code}">삭제</button>
                            </td>
                        </tr>
                    </c:forEach>
            </c:otherwise>
        </c:choose>
        <div>
            <%-- CartController 의 remove 메서드로 데이터를 넘긴다 --%>
            <form action="/cart/remove" method="post" class="delete_form">
                <input type="hidden" name="c_id" class="delete_c_id" value="${c_id}"/>
                <input type="hidden" name="pd_id" class="delete_pd_id" value="${pd_id}"/>
                <input type="hidden" name="pd_clsf_code" class="delete_pd_clsf_code" value="${pd_clsf_code}"/>
            </form>
        </div>
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
        <tr>
            <td colspan="7">
                <form action="" id="removeAllForm">
                    <button type="button" id="delete_All_Btn">전체상품 삭제</button>
                    <button type="button" id="order_Select_Btn"><a href="/order?c_id=${c_id}">선택상품 주문</a></button>
                    <button type="button" id="order_All_Btn"><a href="/order?c_id=${c_id}">전체상품 주문</a></button>
                </form>
            </td>
        </tr>
        </tfoot>
    </table>
</main>
<script>
    $(document).ready(function (){
        /* 고객의 장바구니 한건 삭제 */
        $('.deleteBtn').on("click", function(){
            if(!confirm("삭제하시겠습니까?")) return;
            /* data-cid 를 찾아서 c_id에 저장 */
            let c_id = $(this).data("cid");
            let pd_id = $(this).data("pdid");
            let pd_clsf_code = $(this).data("sizecd");
            /* class delete_c_id 태그를 찾아서 c_id를 controller에 넘겨준다 */
            $(".delete_c_id").val(c_id);
            $(".delete_pd_id").val(pd_id);
            $(".delete_pd_clsf_code").val(pd_clsf_code);
            $(".delete_form").attr("action", "<c:url value='/cart/remove'/>").submit();
        })

        /* 한명의 고객의 장바구니 전체삭제 */
        $('#delete_All_Btn').on("click", function (){
            let removeAllForm = $('#removeAllForm');
            removeAllForm.attr("action", "<c:url value='/cart/removeAll'/>?c_id=${c_id}");
            removeAllForm.attr("method", "post");
            removeAllForm.submit();
        });

        /* plus 수량변경 */
        $('.plus_btn').on('click', function() {
            /* 수량 input 태그를 찾아서 현재 수량을 가져온다. */
            let quantityInput = $(this).siblings('input[name="cart_cnt"]');
            /* 수량의 value를 parseInt해준다 */
            let quantity = parseInt(quantityInput.val());
            quantity++;
            /* 증가된 수량을 input 태그에 설정한다.*/
            quantityInput.val(quantity);
            /* form에 제출되지 않도록 false로 둔다 */
            return false;
        });

        /* minus 수량변경 */
        $('.minus_btn').on('click', function (){
            let quantityInput = $(this).siblings('input[name="cart_cnt"]');
            let quantity = parseInt(quantityInput.val());
            if(quantity > 1) {
                quantity--;
                quantityInput.val(quantity);
            }
            return false;
        })

        /* 장바구니 수량 변경 동작버튼 구현 */
        $(document).on('click', '.quantity_modify_btn', function(){
            let form = $(this).closest('#update_form');
            let c_id = $(this).data("cid");
            let pd_id = $(this).data("pdid");
            let pd_clsf_code = $(this).data("sizecd");
            let cart_cnt = form.find('input[name="cart_cnt"]').val();

            $.ajax({
                url: '/cart/update',
                method: 'POST',
                data: {
                    c_id: c_id,
                    pd_id: pd_id,
                    pd_clsf_code: pd_clsf_code,
                    cart_cnt: cart_cnt
                },
                success: function (response){
                    console.log('장바구니 수량이 변경되었습니다')
                },
                error: function(xhr, status, error){
                    console.error('장바구니 수량변경에 실패하였습니다', error)
                }
            })
        })

    })
</script>
</body>
</html>