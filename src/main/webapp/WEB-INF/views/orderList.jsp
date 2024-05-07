<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
<%--    <link rel="stylesheet" href="reset.css" />--%>
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap"
          rel="stylesheet" />
<%--    <link rel="stylesheet" href="order.css" />--%>
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
                <tr>
                    <td>
                        <a href="#"><img src="#" alt="썸네일" /></a>
                        <a href="#">상품명가져오기</a>
                        <span>옵션명</span>
                    </td>
                    <td><span>주문일자</span></td>
                    <td><a href="#">주문번호</a></td>
                    <td>
                        <span>주문금액</span>
                        <span>수량</span>
                    </td>
                    <td>
                        <a href="#">주문상태</a>
                        <button>후기작성</button>
                    </td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>
</main>
</body>
</html>
