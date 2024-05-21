<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="<c:url value="/admin/stock/register"/>" class="search-form" method="get">
    <table class="tableLeft">
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
                <select class="search-option" id="pd_type_cd" name="pd_type_cd">
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
                <select class="search-option" id="pd_type_det_cd" name="pd_type_det_cd">
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
                <select class="search-option" id="brd_cd" name="brd_cd">
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
            <%--
                - 미선택 시 후 (1개월, 3개월, 6개월)버튼 클릭 시 오늘날짜 기준으로 조회
                - 검색 시작일자 기준 1개월, 3개월, 6개월
            --%>
            <td>
                기간선택 :
                <label for="sdate">시작일</label>
                <input class="search-inputDate" type="date" id="sdate">
                ~
                <label for="edate">종료일</label>
                <input class="search-inputDate" type="date" id="edate">
            </td>
        </tr>
        <%--진열 상태: 전체, 진열중, 진열 제외--%>
        <tr>
            <th>진열 상태</th>
            <td>
                <input type='radio' id="displayAll" name='pd_is_show'/>
                <label for="displayAll">전체</label>
                <input type='radio' id="displayOn" name='pd_is_show' value='Y'/>
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
                <input type='radio' id="planSale" name='pd_stat_hist_cd' value='planSale'/>
                <label for="planSale">판매 예정</label>
                <input type='radio' id="onSale" name='pd_stat_hist_cd' value='onSale'/>
                <label for="onSale">판매 중</label>
                <input type='radio' id="notSale" name='pd_stat_hist_cd' value='notSale'/>
                <label for="notSale">판매 안 함</label>
            </td>
        </tr>
    </table>
    <div class="buttons">
<%--        <button type="submit" class="sendBtn clickButton" id="searchBtn">검색</button>--%>
        <button type="button" class="sendBtn clickButton" id="searchBtn">검색</button>
        <button type="button" class="cancelBtn clickButton" id="cancelBtn">초기화</button>
    </div>
</form>