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
        .main {
            text-align: center;
        }

        .search-container, .product-container, .stock-container {
            width: 100%;
            margin: 20px 0px;
            display: inline-block;
            text-align: center;
        }

        table {
            width: 100%;
            text-align: center;
        }

        table, th, tr, td {
            border: 1px solid black;
            border-collapse: collapse;
            padding: 5px;
        }

        tr { text-align: center; }
        td { text-align: left; }

        .search-option {
            width: 100px;
            height: 100%;
            outline: none;
            margin: 0 5px;
            border: 1px solid #ccc;
            color: gray;
            padding: 5px;
        }

        .search-option > option {
            text-align: center;
        }

        .search-input {
            color: gray;
            background-color: white;
            border: 1px solid #ccc;
            height: 100%;
            width: 300px;
            font-size: 15px;
            padding: 5px;
        }

        .search-input::placeholder {
            color: gray;
        }

        .buttons {
            margin: 20px;
        }

        .searchBtn {
            border-radius: 4px;
            border: 1px solid #000000;
            color: white;
            padding: 10px 20px;
            font-size: 15px;
            cursor: pointer;
            background-color: #585858;
        }

        .searchBtn:hover, .cancelBtn:hover {
            background: #0b7dda;
        }

        .cancelBtn {
            border-radius: 1px;
            border: 1px solid #000000;
            background-color: white;
            padding: 10px 20px;
            font-size: 15px;
            cursor: pointer;
            color: #000000;
        }
    </style>
    <title>재고 목록</title>
</head>
<body>
<jsp:include page="../adminMenu.jsp" flush="false"/>
<div class="main">
    <h1>재고 검색 조회 화면</h1>
    <div class="search-container">
        <form action="<c:url value="/admin/stock/register"/>" class="search-form" method="get">
            <table>
                <tr>
                    <th colspan="2">제품 검색</th>
                </tr>
                <%--검색 분류: 상품ID, 상품명, 모델명, 스포츠 유형, 제조자, 시리즈, 사용 선수명, 시즌--%>
                <tr>
                    <th>검색 분류</th>
                    <td>
                        <select class="search-option" name="keywordSelect">
                            <option value="pd_id">상품ID</option>
                            <option value="pd_name">상품명</option>
                            <option value="mdl_name">모델명</option>
                            <option value="sprt_type_cd">스포츠 유형</option>
                            <option value="mfr">제조사</option>
                            <option value="srs_id">시리즈</option>
                            <option value="player_name">사용 선수명</option>
                            <option value="season">시즌</option>
                        </select>
                        <input type="text" name="keyword" class="search-input" type="text" value="${keyword}"
                               placeholder="검색어를 입력해주세요">
                    </td>
                </tr>
                <%--상품 분류: 대(제품 유형), 중(제품 상세 유형), 소(브랜드)--%>
                <tr>
                    <th>상품 분류</th>
                    <td>
                        <label for="pd_type_cd">제품 유형</label>
                        <select id="pd_type_cd" name="pd_type_cd">
                            <option value="GLV">글러브</option>
                            <option value="PRO">보호장비</option>
                            <option value="OGL">장갑</option>
                            <option value="ACC">액세서리</option>
                            <option value="BAT">배트</option>
                            <option value="APP">의류</option>
                            <option value="BAL">야구공</option>
                            <option value="SHO">야구화</option>
                        </select>

                        <label for="pd_type_det_cd">제품 상세 유형</label>
                        <select id="pd_type_det_cd" name="pd_type_det_cd">
                            <option value="CAT">포수</option>
                            <option value="INF">내야수</option>
                            <option value="FIR">1루수</option>
                            <option value="PIT">투수</option>
                            <option value="OTF">외야수</option>
                            <option value="BTR">타자</option>
                            <option value="UMP">심판</option>
                            <option value="DEF">수비</option>
                            <option value="SLD">슬라이딩</option>
                            <option value="NEC">목걸이</option>
                            <option value="HAT">모자</option>
                            <option value="FST">사계절상의</option>
                            <option value="FSB">사계절하의</option>
                            <option value="WTT">겨울용상의</option>
                            <option value="WTB">겨울용하의</option>
                            <option value="SMT">여름용상의</option>
                            <option value="SMB">여름용하의</option>
                            <option value="UNF">유니폼</option>
                            <option value="OTR">아우터</option>
                            <option value="SPK">스파이크_야구화</option>
                            <option value="TRF">인조잔디_야구화</option>
                        </select>

                        <label for="brd_cd">브랜드</label>
                        <select id="brd_cd" name="brd_cd">
                            <option value="GLD">골드</option>
                            <option value="KBT">구보타슬러거</option>
                            <option value="NB">뉴발란스</option>
                            <option value="DVD">다비드</option>
                            <option value="DST">데상트</option>
                            <option value="RAW">롤링스</option>
                            <option value="MOR">모리모토</option>
                            <option value="MIZ">미즈노</option>
                            <option value="BKP">백퍼센트</option>
                            <option value="VL">볼레</option>
                            <option value="SSK">사사키</option>
                            <option value="SKL">스카이라인</option>
                            <option value="STM">스톰</option>
                            <option value="WLP">월드페가수스</option>
                            <option value="IPS">아이피셀렉트</option>
                            <option value="ACS">아식스</option>
                            <option value="ATM">아톰즈</option>
                            <option value="UA">언더아머</option>
                            <option value="WIL">윌슨</option>
                            <option value="EVO">이보쉴드</option>
                            <option value="IKJ">인코자바</option>
                            <option value="ZET">제트</option>
                            <option value="GF">지폼</option>
                            <option value="PRS">프로스펙스</option>
                            <option value="TTM">투더문</option>
                            <option value="HD">하데나</option>
                            <option value="HTK">하타케야마</option>
                            <option value="44G">44글러브</option>
                            <option value="ETC">기타</option>
                        </select>
                    </td>
                </tr>
                <%--상품 등록일: 날짜 날짜--%>
                <tr>
                    <th>상품 등록일</th>
                </tr>
                <%--진열 상태: 전체, 진열중, 진열 제외--%>
                <tr>
                    <th>진열 상태</th>
                    <td>
                        <input type='radio' id="displayAll" name='pd_is_show'/>
                        <label for="displayAll">전체</label>
                        <input type='radio' id="displayOn" name='pd_is_show' value='Y' required/>
                        <label for="displayOn">진열하기</label>
                        <input type='radio' id="displayNo" name='pd_is_show' value='N'/>
                        <label for="displayNo">진열제외</label>
                    </td>
                </tr>
                <%--판매 상태: 전체, 판매중, 판매 안함--%>
                <tr>
                    <th>판매 상태</th>
                    <td>
                        <input type='radio' id="allSale" name='pd_stat_hist_cd'/>
                        <label for="allSale">전체</label>
                        <input type='radio' id="planSale" name='pd_stat_hist_cd' value='planSale' required/>
                        <label for="planSale">판매 예정</label>
                        <input type='radio' id="onSale" name='pd_stat_hist_cd' value='onSale'/>
                        <label for="onSale">판매 중</label>
                        <input type='radio' id="notSale" name='pd_stat_hist_cd' value='notSale'/>
                        <label for="notSale">판매 안 함</label>
                    </td>
                </tr>
                <tr>

                </tr>
            </table>
            <div class="buttons">
                <button type="submit" class="searchBtn" id="searchBtn">검색</button>
                <button type="button" class="cancelBtn" id="cancelBtn">취소</button>
            </div>
        </form>
    </div>
    <div class="product-container">
        <h5>제품목록</h5>
        <table>
            <tr>
                <th class="pd_id">제품ID</th>
                <th class="pd_name">제품명</th>
                <th class="nml_stk_qty">정상재고 수량</th>
                <th class="rt_stk_qty">반품재고 수량</th>
                <th class="rgn_stk_qty">재생가능재고 수량</th>
                <th class="urgn_stk_qty">재생불가능재고 수량</th>
                <th class="sfty_stk_qty">안전재고 수량</th>
                <th class="odpmt_stk">가용재고</th>
            </tr>
            <c:forEach var="productDto" items="${productList}">
                <tr>
                    <td class="pd_id">${productDto.pd_id}</td>
                    <td class="pd_name">${productDto.pd_name}</td>

                    <c:set var="foundStock" value="false"/>
                    <c:forEach var="stockDto" items="${stockList}">
                        <c:if test="${stockDto.pd_id eq productDto.pd_id}">
                            <c:set var="foundStock" value="true"/>
                            <td class="nml_stk_qty">${stockDto.nml_stk_qty}</td>
                            <td class="rt_stk_qty">${stockDto.nml_stk_qty}</td>
                            <td class="rgn_stk_qty">${stockDto.nml_stk_qty}</td>
                            <td class="urgn_stk_qty">${stockDto.nml_stk_qty}</td>
                            <td class="sfty_stk_qty">${stockDto.nml_stk_qty}</td>
                            <td class="odpmt_stk">${stockDto.nml_stk_qty}</td>
                        </c:if>
                    </c:forEach>
                    <c:if test="${foundStock eq false}">
                        <td class="nml_stk_qty">0</td>
                        <td class="rt_stk_qty">0</td>
                        <td class="rgn_stk_qty">0</td>
                        <td class="urgn_stk_qty">0</td>
                        <td class="sfty_stk_qty">0</td>
                        <td class="odpmt_stk">0</td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="stock-container">
        <h5>재고목록</h5>
        <table>
            <tr>
                <th class="pd_id">제품ID</th>
                <th class="pd_name">제품명</th>
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
            </tr>
            <c:forEach var="stockDto" items="${stockList}">
                <tr>
                    <td class="pd_id">${stockDto.pd_id}</td>
                    <td class="pd_name">${stockDto.pd_name}</td>
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
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="paging-container">
        <p>페이징자리</p>
    </div>
</div>
</body>
</html>
