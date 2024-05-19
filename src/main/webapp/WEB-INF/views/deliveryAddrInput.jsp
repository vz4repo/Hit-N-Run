<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>새로운 배송지 입력</title>
</head>
<body>
        <p> 새로운 배송지 입력창 </p>

        <div class="container">
            <h1 class="display-1">배송지 입력</h1>
            <form action="#">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="rcver">수령인:</label>
                            <input type="name" id="rcver" name="rcver" class="form-control" placeholder="남궁성">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="rcver_adr">배송지:</label>
                            <input type="text" id="rcver_adr" name="rcver_adr" class="form-control" placeholder="서울특별시 강남구 강남대로 364 10층">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="adr_name">배송지명:</label>
                            <input type="text" id="adr_name" name="adr_name" class="form-control" placeholder="서울특별시 강남구 강남대로 364 10층">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="rcver_phn">연락처:</label>
                            <input type="text" id="rcver_phn" name="rcver_phn" class="form-control" placeholder="010123455678">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <button type="submit" class="form-control btn btn-primary">Submit</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>


</body>
</html>
