<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="w3-container search-container">
    <form action="<c:url value="/admin/stock/searchList"/>" class="search-form" method="get">
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
                    <input type="text" name="keyword" class="search-input" value="" placeholder="검색어를 입력해주세요">
                </td>
            </tr>
            <%--상품 분류: 대(제품 유형), 중(제품 상세 유형), 소(브랜드)--%>
            <tr>
                <th>상품 분류</th>
                <td>
                    <select class="search-option" id="pd_type_cd" name="pd_type_cd">
                        <option disabled="" hidden="" selected="">제품 유형</option>
                        <option value="GLV">글러브</option>
                        <option value="PRO">보호장비</option>
                        <option value="OGL">장갑</option>
                        <option value="ACC">액세서리</option>
                        <option value="BAT">배트</option>
                        <option value="APP">의류</option>
                        <option value="BAL">야구공</option>
                        <option value="SHO">야구화</option>
                    </select>

                    <select class="search-option" id="pd_type_det_cd" name="pd_type_det_cd">
                        <option disabled="" hidden="" selected="">제품 상세 유형</option>
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

                    <select class="search-option" id="brd_cd" name="brd_cd">
                        <option disabled="" hidden="" selected="">브랜드</option>
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
            <%--상품 등록일: 검색시작날짜 - 검색마지막날짜--%>
            <tr>
                <th>상품 등록일</th>
                <td>
                    <label for="sdate">시작일</label>
                    <input class="search-inputDate" type="date" id="sdate">
                    <p style="display: inline-block; margin: 0px 20px">~</p>
                    <label for="edate">종료일</label>
                    <input class="search-inputDate" type="date" id="edate">
                </td>
            </tr>
            <%--진열 상태: 전체, 진열중, 진열 제외--%>
            <tr>
                <th>진열 상태</th>
                <td>
                    <label class="radio-container" for="displayAll">전체
                        <input type="radio" id="displayAll" name="pd_is_show">
                        <span class="checkmark"></span>
                    </label>

                    <label class="radio-container" for="displayOn">진열하기
                        <input type="radio" id="displayOn" name="pd_is_show" value="Y">
                        <span class="checkmark"></span>
                    </label>

                    <label class="radio-container" for="displayNo">진열제외
                        <input type="radio" id="displayNo" name="pd_is_show" value="N">
                        <span class="checkmark"></span>
                    </label>
                </td>
            </tr>
            <%--판매 상태: 전체, 판매중, 판매 안함--%>
            <tr>
                <th>판매 상태</th>
                <td>
                    <label class="radio-container" for="allSale">전체
                        <input type="radio" checked="checked" id="allSale" name="pd_stat_hist_cd">
                        <span class="checkmark"></span>
                    </label>

                    <label class="radio-container" for="planSale">판매 예정
                        <input type="radio" id="planSale" name="pd_stat_hist_cd" value="planSale">
                        <span class="checkmark"></span>
                    </label>

                    <label class="radio-container" for="onSale">판매 중
                        <input type="radio" id="onSale" name="pd_stat_hist_cd" value="onSale">
                        <span class="checkmark"></span>
                    </label>

                    <label class="radio-container" for="notSale">판매 안 함
                        <input type="radio" id="notSale" name="pd_stat_hist_cd" value="notSale">
                        <span class="checkmark"></span>
                    </label>
                </td>
            </tr>
        </table>
        <div class="buttons">
            <button type="button" class="sendBtn" id="searchBtn">검색</button>
            <button type="button" class="cancelBtn" id="cancelBtn">초기화</button>
        </div>
    </form>
</div>