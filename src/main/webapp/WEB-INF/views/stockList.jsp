<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>재고 목록</title>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            font-family: "Noto Sans KR", sans-serif;
        }

        a {
            text-decoration: none;
            color: black;
        }

        button,
        input {
            border: none;
            outline: none;
        }

        .stock-container {
            width: 90%;
            height: 1200px;
            margin: 0 auto;
            /*border: 1px solid black;*/
        }

        table {
            border-collapse: collapse;
            width: 100%;
            border-top: 2px solid rgb(39, 39, 39);
        }

        tr:nth-child(even) {
            background-color: #f0f0f070;
        }

        th,
        td {
            width: 300px;
            text-align: center;
            padding: 10px 12px;
            border-bottom: 1px solid #ddd;
        }

        td {
            color: rgb(53, 53, 53);
        }

        .pd_id {
            width: 150px;
        }

        .pd_clsf_cd {
            width: 5%;
        }

        td.pd_clsf_cd {
            text-align: center;
        }

        td.nml_stk_qty,
        td.rt_stk_qty,
        td.rgn_stk_qty,
        td.urgn_stk_qty,
        td.sfty_stk_qty,
        td.odpmt_stk,
        td.pur_dt,
        td.rcpt_dt,
        td.rcpt_cp,
        td.rcpt_prc,
        td.rtl_prc,
        td.sls_prc,
        td.stk_plc_cd,
        td.stk_stat_cd {
            text-align: left;
        }

        td.pd_id:hover {
            text-decoration: underline;
        }
/*
        .btn-write {
            background-color: rgb(236, 236, 236); !*Blue background*!
            border: none; !*Remove borders*!
            color: black; !*White text*!
            padding: 6px 12px; !*Some padding*!
            font-size: 16px; !*Set a font size*!
            cursor: pointer; !*Mouse pointer on hover*!
            border-radius: 5px;
            margin-left: 30px;
        }

        .btn-write:hover {
            text-decoration: underline;
        }
        */
    </style>
</head>
<body>
<div class="stock-container">
    <table style="border: 1px">
        <tr>
            <th class="pd_id">제품ID</th>
            <th class="pd_clsf_cd">제품 구분 코드</th>
            <th class="nml_stk_qty">정상재고 수량</th>
            <th class="rt_stk_qty">반품재고 수량</th>
            <th class="rgn_stk_qty">재생가능재고 수량</th>
            <th class="urgn_stk_qty">재생불가능재고 수량</th>
            <th class="sfty_stk_qty">안전재고 수량</th>
            <th class="odpmt_stk">가용재고</th>
            <th class="pur_dt">매입일</th>
            <th class="rcpt_dt">입고일</th>
            <th class="rcpt_cp">입고처</th>
            <th class="rcpt_prc">입고가격</th>
            <th class="rtl_prc">소비자가격</th>
            <th class="sls_prc">판매가격</th>
            <th class="stk_plc_cd">재고 위치 코드</th>
            <th class="stk_stat_cd">재고진행상태코드</th>
        </tr>
        <c:forEach var="stockDto" items="${list}">
            <tr>
                <td class="pd_id">${stockDto.bno}</td>
                <td class="pd_clsf_cd">${stockDto.pd_clsf_cd}</td>
                <td class="nml_stk_qty">${stockDto.nml_stk_qty}</td>
                <td class="rt_stk_qty">${stockDto.rt_stk_qty}</td>
                <td class="rgn_stk_qty">${stockDto.rgn_stk_qty}</td>
                <td class="urgn_stk_qty">${stockDto.urgn_stk_qty}</td>
                <td class="sfty_stk_qty">${stockDto.sfty_stk_qty}</td>
                <td class="odpmt_stk">${stockDto.odpmt_stk}</td>
                <td class="pur_dt">${stockDto.pur_dt}</td>
                <td class="rcpt_dt">${stockDto.rcpt_dt}</td>
                <td class="rcpt_cp">${stockDto.rcpt_cp}</td>
                <td class="rcpt_prc">${stockDto.rcpt_prc}</td>
                <td class="rtl_prc">${stockDto.rtl_prc}</td>
                <td class="sls_prc">${stockDto.sls_prc}</td>
                <td class="stk_plc_cd">${stockDto.stk_plc_cd}</td>
                <td class="stk_stat_cd">${stockDto.stk_stat_cd}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
