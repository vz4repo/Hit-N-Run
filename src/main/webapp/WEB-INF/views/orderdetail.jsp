<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet" />
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <link href="<c:url value='/css/reset.css'/>" type="text/css" rel="stylesheet" />
    <link href="<c:url value='/css/cart.css'/>"   rel="stylesheet" />
    <%--   다니님 header, footer --%>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" rel="stylesheet" />
    <link href="<c:url value='/css/header.css'/>" type="text/css" rel="stylesheet" />
    <link href="<c:url value='/css/footer.css'/>" type="text/css" rel="stylesheet"/>

    <title>주문내역조회</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<main>
    <div class="order__header">
        <a href="#" class="order__path">Homerun() > 주문내역조회</a>
    </div>
<%--    <hr class="second__under" />--%>
    <div class="tb__order">
        <form action="/orderDetail">
            <table style="width: 90%">
                <colgroup>
                    <col width="*" />
                    <col width="100" />
                    <col width="150" />
                    <col width="150" />
                    <col width="150" />
                    <col width="200" />
                </colgroup>
                <thead>
                <tr>
                    <th scope="col">
                        <div>상품정보</div>
                    </th>
                    <th scope="col">
                        <div>주문일자</div>
                    </th>
                    <th scope="col">
                        <div>주문번호</div>
                    </th>
                    <th scope="col">
                        <div>주문금액(수량)</div>
                    </th>
                    <th scope="col">
                        <div>주문상태</div>
                    </th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach var="orderdetDto" items="${list}"  varStatus="status" >
                        <tr>
                            <td>
                                <a href="/product/detail?pd_id=${Imglist[status.index].pd_id}">
                                    <img src="/img/product/${Imglist[status.index].pd_type_cd.toLowerCase()}/main/${Imglist[status.index].mn_img_fn}" alt="썸네일" name="thumbnail" />
                                </a>
                                <a href="#">${orderdetDto.pd_name}</a>
                                <span>사이즈: ${orderdetDto.pd_clsf_cd}</span>
                            </td>
                            <td><span>${orderdetDto.frst_reg_dt}</span></td>
                            <td><a href="#">${orderdetDto.od_id}</a></td>
                            <td>
                                <span>${orderdetDto.sls_prc}</span>
                                <span>${orderdetDto.od_qty}</span>
                            </td>
                            <td>
                                <a href="#">${orderdetDto.od_stat_cd}</a>
                                <button>후기작성</button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </form>
    </div>
</main>
<jsp:include page="footer.jsp"/>
</body>
</html>