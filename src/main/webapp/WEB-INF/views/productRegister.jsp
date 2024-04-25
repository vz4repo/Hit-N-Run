<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>제품 등록 화면</title>
</head>
<body>
<h1>제품 등록 화면</h1>
<h2>표시 설정</h2>
<table>
    <tr>
        <th>진열 상태</th>
        <th>
            <input type='radio' name='isshow' value='onShow' />진열 중
            <input type='radio' name='isshow' value='noShow' />진열 제외
        </th>
    </tr>
    <tr>
        <th>판매 상태</th>
        <th>
            <input type='radio' name='sale' value='planSale' />판매 예정
            <input type='radio' name='sale' value='onSale' />판매 중
            <input type='radio' name='sale' value='notSale' />판매 안 함
        </th>
    </tr>
    <tr>
        <label for="main">제품 유형</label>
        <select id="main" name="type">
            <option value="australia">글러브</option>
            <option value="canada">보호장비</option>
            <option value="usa">장갑</option>
            <option value="usa">액세서리</option>
            <option value="usa">배트</option>
            <option value="usa">의류</option>
            <option value="usa">야구공</option>
            <option value="usa">야구화</option>
        </select>

        <label for="mid">제품 상세 유형</label>
        <select id="mid" name="type_detail">
            <option value="australia">투수</option>
            <option value="canada">포수</option>
            <option value="usa">내야수</option>
            <option value="usa">외야수</option>
            <option value="usa">타자</option>
            <option value="usa">심판</option>
            <option value="usa">포수</option>
            <option value="usa">수비</option>
        </select>
    </tr>
</table>
</body>
</html>