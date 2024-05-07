<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ProductExposure</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            text-align: left;
        }
        strong {
            font-weight: bold;
            color: #1b64da;
        }
    </style>
</head>
<body>
<h1>표시설정 일괄변경</h1>
<div class="product_content">
    <table style="width:100%">
        <tr>
            <th colspan="2">
                총 <strong>${productListSize}</strong>개 상품의 표시설정을 일괄 변경합니다.
            </th>
        </tr>
        <tr>
            <th colspan="2">
                <input type="checkbox" name="selectedContent">전체 선택
            </th>
        </tr>
        <tr>
            <th><input type="checkbox" name="selectedContent">진열 상태</th>
            <td>
                <input type='radio' id="onShow" name='pd_is_show' value='Y' required/>
                <label for="onShow">진열하기</label>
                <input type='radio' id="noShow" name='pd_is_show' value='N' />
                <label for="noShow">진열제외</label>
            </td>
        </tr>
        <tr>
            <th><input type="checkbox" name="selectedContent">판매 상태</th>
            <td>
                <input type='radio' id="planSale" name='pd_stat_hist_cd' value='planSale' required/>
                <label for="planSale">판매 예정</label>
                <input type='radio' id="onSale" name='pd_stat_hist_cd' value='onSale' />
                <label for="onSale">판매 중</label>
                <input type='radio' id="notSale" name='pd_stat_hist_cd' value='notSale' />
                <label for="notSale">판매 안 함</label>
            </td>
        </tr>
        <tr>
            <th>
                <input type="checkbox" name="selectedContent">상품분류 선택
            </th>
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
                <select id="brd_cd" name="brd_cd" >
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
        <tr>
            <th><input type="checkbox" name="selectedContent">제품 특성</th>
            <td>
                <input type="checkbox" id="npd" name="pd_chr_cd" value="N">
                <label for="npd">신상품</label><br>
                <input type="checkbox" id="hpd" name="pd_chr_cd" value="H">
                <label for="hpd">HOT</label><br>
                <input type="checkbox" id="spd" name="pd_chr_cd" value="S">
                <label for="spd">스테디 셀러</label><br>
                <input type="hidden" name="pd_chr_cd" value="">
            </td>
        </tr>
    </table>
</div>
</body>
</html>