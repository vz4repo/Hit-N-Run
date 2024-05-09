<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
<%--    <link rel="stylesheet" href="reset.css" />--%>
<%--    <link rel="stylesheet" href="order.css" />--%>
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap"
          rel="stylesheet" />
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" />

    <title>주문내역조회</title>
</head>
<body>
<main>
    <div class="order__header">
        <a href="#" class="order__path">Homerun() > 주문내역조회</a>
        <hr />
    </div>
    <hr class="second__under" />
    <div class="tb__order">
        <form action="">
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
                    <c:forEach var="orderdetDto" items="${list}">
                        <tr>
                            <td>
                                <a href="#"><img src="#" alt="썸네일" /></a>
                                <a href="#">${orderdetDto.pd_name}</a>
                                <span>사이즈: ${orderdetDto.pd_clsf_cd}</span>
                            </td>
                            <td><span>${orderdetDto.frst_reg_dt}</span></td>
                            <td><a href="#">${orderdetDto.od_id}</a></td>
                            <td>
                                <span>${orderdetDto.slg_prc}</span>
                                <span>${orderdetDto.od_qty}</span>
                            </td>
                            <td>
                                <a href="#">${orderdetDto.dlvry_stat_cd}</a>
                                <button>후기작성</button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </form>
    </div>
</main>
</body>
</html>