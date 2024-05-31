<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- The Modal -->
<div class="modal fade" id="modifyModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h5 class="modal-title" id="stockModalLabel">재고수정</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <form id="stockModifyForm">
                    <table class="table table-striped">
                        <tbody>
                        <tr>
                            <td><label for="modify_pd_id">제품ID</label></td>
                            <td><input type="text" id="modify_pd_id" name="pd_id"></td>
                        </tr>
                        <tr>
                            <td><label for="modify_pd_name">제품명</label></td>
                            <td><input type="text" id="modify_pd_name" name="pd_name"></td>
                        </tr>
                        <tr>
                            <td><label for="modify_pd_clsf_cd">제품구분코드(사이즈)</label></td>
                            <td><input type="text" id="modify_pd_clsf_cd" name="pd_clsf_cd"></td>
                        </tr>
                        <tr>
                            <td><label for="modify_nml_stk_qty">정상재고수량</label></td>
                            <td><input type="text" class="validNumber" id="modify_nml_stk_qty" name="nml_stk_qty" placeholder="정상재고수량을 입력하세요.">
                            </td>
                        </tr>
                        <tr>
                            <td><label for="modify_rt_stk_qty">반품재고수량</label></td>
                            <td><input type="text" class="validNumber" id="modify_rt_stk_qty" name="rt_stk_qty" placeholder="반품재고수량을 입력하세요."></td>
                        </tr>
                        <tr>
                            <td><label for="modify_rgn_stk_qty">재생가능재고수량</label></td>
                            <td><input type="text" class="validNumber" id="modify_rgn_stk_qty" name="rgn_stk_qty" placeholder="재생가능재고수량을 입력하세요.">
                            </td>
                        </tr>
                        <tr>
                            <td><label for="modify_urgn_stk_qty">재생불가능재고수량</label></td>
                            <td><input type="text" class="validNumber" id="modify_urgn_stk_qty" name="urgn_stk_qty"
                                       placeholder="재생불가능재고수량을 입력하세요."></td>
                        </tr>
                        <tr>
                            <td><label for="modify_sfty_stk_qty">안전재고수량</label></td>
                            <td><input type="text" class="validNumber" id="modify_sfty_stk_qty" name="sfty_stk_qty" placeholder="안전재고수량을 입력하세요.">
                            </td>
                        </tr>
                        <tr>
                            <td><label for="modify_pur_dt">매입일</label></td>
                            <td><input type="date" class="search-inputDate dateForm" id="modify_pur_dt" name="pur_dt" placeholder="매입일을 입력하세요."></td>
                        </tr>
                        <tr>
                            <td><label for="modify_rcpt_dt">입고일</label></td>
                            <td><input type="date" class="search-inputDate dateForm" id="modify_rcpt_dt" name="rcpt_dt" placeholder="입고일을 입력하세요."></td>
                        </tr>
                        <tr>
                            <td><label for="modify_rcpt_cp">입고처</label></td>
                            <td><input type="text" class="validText" id="modify_rcpt_cp" name="rcpt_cp" placeholder="입고처를 입력하세요.">
                                <span id="modifyRcptCpCnt">[0 / 20]</span>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="modify_rcpt_prc">입고가격</label></td>
                            <td><input type="text" class="validNumber" id="modify_rcpt_prc" name="rcpt_prc" placeholder="입고가격를 입력하세요.">
                                <span id="modifyRcptPrcCnt">[0 / 10]</span>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="modify_rtl_prc">소비자가격</label></td>
                            <td><input type="text" class="validNumber" id="modify_rtl_prc" name="rtl_prc" placeholder="소비자가격를 입력하세요.">
                                <span id="modifyRtlPrcCnt">[0 / 10]</span>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="modify_sls_prc">판매가격</label></td>
                            <td><input type="text" class="validNumber" id="modify_sls_prc" name="sls_prc" placeholder="판매가격를 입력하세요.">
                                <span id="modifySlsPrcCnt">[0 / 10]</span>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="modify_stk_plc_cd">재고위치코드</label></td>
                            <td><input type="text" class="validText" id="modify_stk_plc_cd" name="stk_plc_cd" placeholder="재고위치코드를 입력하세요."></td>
                        </tr>
                        </tbody>
                    </table>
                </form>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" onclick="modifyStock()" id="confirmStockBtn">수정완료</button>
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal" id="cancelStockBtn">취소</button>
            </div>

        </div>
    </div>
    <script>
        /*입고처 글자 수 세기*/
        $("#modify_rcpt_cp").keyup(function () {
            let content = $(this).val();
            $("#modifyRcptCpCnt").text("[" + content.length + " / 20]"); /* 실시간 글자수 카운팅 */
            if (content.length > 20) {
                alert("최대 20자까지 입력 가능합니다.");
                $(this).val(content.substring(0, 20));
                $('#modifyRcptCpCnt').text("[20 / 20]");
            }
        });

        /*입고가격 글자 수 세기*/
        $("#modify_rcpt_prc").keyup(function () {
            let content = $(this).val();
            $("#modifyRcptPrcCnt").text("[" + content.length + " / 10]"); /* 실시간 글자수 카운팅 */
            if (content.length > 10) {
                alert("최대 10자까지 입력 가능합니다.");
                $(this).val(content.substring(0, 10));
                $('#modifyRcptPrcCnt').text("[10 / 10]");
            }
        });

        /*소비자가격 글자 수 세기*/
        $("#modify_rtl_prc").keyup(function () {
            let content = $(this).val();
            $("#modifyRtlPrcCnt").text("[" + content.length + " / 10]"); /* 실시간 글자수 카운팅 */
            if (content.length > 10) {
                alert("최대 10자까지 입력 가능합니다.");
                $(this).val(content.substring(0, 10));
                $('#modifyRtlPrcCnt').text("[10 / 10]");
            }
        });

        /*판매가격 글자 수 세기*/
        $("#modify_sls_prc").keyup(function () {
            let content = $(this).val();
            $("#modifySlsPrcCnt").text("[" + content.length + " / 10]"); /* 실시간 글자수 카운팅 */
            if (content.length > 10) {
                alert("최대 10자까지 입력 가능합니다.");
                $(this).val(content.substring(0, 10));
                $('#modifySlsPrcCnt').text("[10 / 10]");
            }
        });

        /*만약 입고일이 매입일보다보다 과거면 에러가 발생한다. 등록시에만 할까? 수정시에는?*/
        $('#modify_rcpt_dt, #modify_pur_dt').on('blur', function () {
            let modifyRcptDate = $('#modify_rcpt_dt').val();
            let modifyPurDate = $('#modify_pur_dt').val();

            if (modifyRcptDate && modifyPurDate) {
                let modifyRcptDateObj = new Date(modifyRcptDate);
                let modifyPurDateObj = new Date(modifyPurDate);

                if (modifyRcptDateObj < modifyPurDateObj) {
                    alert("입고일은 매입일보다 이전일 수 없습니다.");
                    $('#modify_rcpt_dt').val('');
                }
            }
        });

        /*만약 입고 가격이 소비자가격보다보다 작으면 에러가 발생한다.*/
  /*      $('#modify_rcpt_prc, #modify_rtl_prc').on('blur', function () {
            let modifyRcptPrc = $('#modify_rcpt_prc').val();
            let modifyRtlPrc = $('#modify_rtl_prc').val();

            if (modifyRcptPrc < modifyRtlPrc) {
                alert("입고 가격은 소비자가격보다 클 수 없습니다.");
                $('#modify_rcpt_prc').val('');
            }
        });*/
        // modify_rcpt_prc 입고가격 modify_rtl_prc 소비자가격
        $('#modify_rcpt_prc, #modify_rtl_prc').on('change', function () {
            let modifyRcptPrc = $('#modify_rcpt_prc').val();
            let modifyRtlPrc = $('#modify_rtl_prc').val();

            // 입력 값이 비어 있지 않은 경우에만 비교
            if (modifyRcptPrc !== '' && modifyRtlPrc !== '') {
                // 숫자로 변환하여 비교
                modifyRcptPrc = parseFloat(modifyRcptPrc);
                modifyRtlPrc = parseFloat(modifyRtlPrc);

                if (modifyRcptPrc > modifyRtlPrc) {
                    alert("입고 가격은 소비자가격보다 클 수 없습니다.");
                    $('#modify_rtl_prc').val('');
                }
            }
        });

        /* 재고수정 버튼을 누르면 모달창이 열린다.
           재고 정보를 한번에 불러온다. */
        function openModifyModal(pdId, pdClsfCd) {
            /* 모달창에 재고테이블의 정보를 가져온다. */
            $('#modify_pd_id').prop('disabled', true);
            $('#modify_pd_name').prop('disabled', true);
            $('#modify_pd_clsf_cd').prop('disabled', true);
            $.ajax({
                type: 'GET',       // 요청 메서드
                url: '/admin/stock/selectOneModify',  // 요청 URI
                headers: {"Content-Type": "application/json"}, // 요청 헤더
                dataType: 'json', // json 객체형으로 응답
                data: {
                    pdId:pdId,
                    pdClsfCd:pdClsfCd
                },  // 서버로 전송할 데이터. stringify()로 직렬화 필요. JSON.stringify()
                success: function (result) {
                    function formatDate(dateStr) {
                        if (dateStr !== null && dateStr !== undefined){
                            return dateStr.slice(0, 4) + '-' + dateStr.slice(4, 6) + '-' + dateStr.slice(6, 8);
                        } else {
                            alert("날짜 데이터가 없어요! 확인 해주세요!");
                            return '';
                        }
                    }

                    console.log("통신성공!" + JSON.stringify(result));
                    if(result) {
                        $('#modify_pd_id').val(result.pd_id);
                        $('#modify_pd_name').val(result.pd_name);
                        $('#modify_pd_clsf_cd').val(result.pd_clsf_cd);
                        $('#modify_nml_stk_qty').val(result.nml_stk_qty);
                        $('#modify_rt_stk_qty').val(result.rt_stk_qty);
                        $('#modify_rgn_stk_qty').val(result.rgn_stk_qty);
                        $('#modify_urgn_stk_qty').val(result.urgn_stk_qty);
                        $('#modify_sfty_stk_qty').val(result.sfty_stk_qty);
                        $('#modify_pur_dt').val(formatDate(result.pur_dt));
                        $('#modify_rcpt_dt').val(formatDate(result.rcpt_dt));
                        $('#modify_rcpt_cp').val(result.rcpt_cp);
                        $('#modify_rcpt_prc').val(result.rcpt_prc);
                        $('#modify_rtl_prc').val(result.rtl_prc);
                        $('#modify_sls_prc').val(result.sls_prc);
                        $('#modify_stk_plc_cd').val(result.stk_plc_cd);
                        $('#modifyModal').modal("show");
                    } else {
                        alert("받은 데이터가 없습니다. 다시 시도해주세요.");
                        return;
                    }
                },
                error: function (request, status, error) {
                    if(request.responseText === "size is All") {
                        alert("사이즈를 선택해 주세요.");
                    } else if(request.responseText === "stock is null") {
                        alert("재고가 없습니다. 다시 확인 해주세요.");
                    } else {
                        alert("error: " + request.responseText);
                    }

                    $('#modifyModal').modal("hide");
                    console.log("code: " + request.status)
                    console.log("message: " + request.responseText)
                    console.log("error: " + error);
                } // 에러가 발생했을 때, 호출될 함수
            });
        }

        /* 확인 버튼을 누르면 재고가 수정된다. */
        function modifyStock() {

            if (!idValidateModifyParams()) {
                return;
            }

            let params = getModifyParams();

            $.ajax({
                type: 'POST',       // 요청 메서드
                url: '/admin/stock/modify',  // 요청 URI
                headers: {"Content-Type": "application/json"}, // 요청 헤더
                /*dataType: 'json', // json 객체형으로 응답*/
                data: JSON.stringify(params),  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
                success: function (result) {
                    console.log(result)
                    if(result == "modify success") {
                        alert("재고 수정 성공");       // response는 서버가 전송한 데이터
                        $('#modifyModal').modal("hide"); // 모달 비활성화
                        window.location.href = "/admin/stock/list";
                    } else if(result == "Same Data"){
                        alert("동일한 데이터 입니다. 내용을 수정해주세요.");
                        return;
                    } else {
                        alert("등록에 실패했습니다.");
                        return;
                    }
                },
                error: function (request, status, error) {
                    alert("올바른 값을 입력 해주세요.");
                    console.log("code: " + request.status)
                    console.log("message: " + request.responseText)
                    console.log("error: " + error);
                } // 에러가 발생했을 때, 호출될 함수
            });
        }

        /* 모달창에서 입력된 재고 정보를 받아온다. */
        function getModifyParams() {
            let pd_id = $('#modify_pd_id').val();
            let pd_name = $('#modify_pd_name').val();
            let pd_clsf_cd = $('#modify_pd_clsf_cd').val();
            let nml_stk_qty = $('#modify_nml_stk_qty').val();
            let rt_stk_qty = $('#modify_rt_stk_qty').val();
            let rgn_stk_qty = $('#modify_rgn_stk_qty').val();
            let urgn_stk_qty = $('#modify_urgn_stk_qty').val();
            let sfty_stk_qty = $('#modify_sfty_stk_qty').val();
            let pur_dt = $('#modify_pur_dt').val();
            let rcpt_dt = $('#modify_rcpt_dt').val();
            let rcpt_cp = $('#modify_rcpt_cp').val();
            let rcpt_prc = $('#modify_rcpt_prc').val();
            let rtl_prc = $('#modify_rtl_prc').val();
            let sls_prc = $('#modify_sls_prc').val();
            let stk_plc_cd = $('#modify_stk_plc_cd').val();

            return {
                pd_id: pd_id,
                pd_name: pd_name,
                pd_clsf_cd: pd_clsf_cd,
                nml_stk_qty: nml_stk_qty,
                rt_stk_qty: rt_stk_qty,
                rgn_stk_qty: rgn_stk_qty,
                urgn_stk_qty: urgn_stk_qty,
                sfty_stk_qty: sfty_stk_qty,
                pur_dt: pur_dt,
                rcpt_dt: rcpt_dt,
                rcpt_cp: rcpt_cp,
                rcpt_prc: rcpt_prc,
                rtl_prc: rtl_prc,
                sls_prc: sls_prc,
                stk_plc_cd: stk_plc_cd
            };
        }

        function idValidateModifyParams() {
            if ($('#modify_pd_id').val() == null || $('#modify_pd_id').val().length < 1) {
                alert('제품ID를 입력해주세요.');
                return false;
            }

            if ($('#modify_pd_name').val() == null || $('#modify_pd_name').val().length < 1) {
                alert('제품명을 입력해주세요.');
                return false;
            }

            if ($('#modify_pd_clsf_cd').val() == null || $('#modify_pd_clsf_cd').val().length < 1) {
                alert('제품사이즈를 선택해주세요.');
                return false;
            }

            if ($('#modify_nml_stk_qty').val() == null || $('#modify_nml_stk_qty').val().length < 1) {
                alert('정상재고수량을 입력해주세요.');
                return false;
            }

            if ($('#modify_rt_stk_qty').val() == null || $('#modify_rt_stk_qty').val().length < 1) {
                alert('반품재고수량을 입력해주세요.');
                return false;
            }

            if ($('#modify_rgn_stk_qty').val() == null || $('#modify_rgn_stk_qty').val().length < 1) {
                alert('재생가능재고수량을 입력해주세요.');
                return false;
            }

            if ($('#modify_urgn_stk_qty').val() == null || $('#modify_urgn_stk_qty').val().length < 1) {
                alert('재생불가능재고수량을 입력해주세요.');
                return false;
            }

            if ($('#modify_sfty_stk_qty').val() == null || $('#modify_sfty_stk_qty').val().length < 1) {
                alert('안전재고재고수량을 입력해주세요.');
                return false;
            }

            if ($('#modify_pur_dt').val() == null || $('#modify_pur_dt').val().length < 1) {
                alert('매입일을 입력해주세요.');
                return false;
            }

            if ($('#modify_rcpt_dt').val() == null || $('#modify_rcpt_dt').val().length < 1) {
                alert('입고일을 입력해주세요.');
                return false;
            }

            if ($('#modify_rcpt_cp').val() == null || $('#modify_rcpt_cp').val().length < 1) {
                alert('입고처를 입력해주세요.');
                return false;
            }

            if ($('#modify_rcpt_prc').val() == null || $('#modify_rcpt_prc').val().length < 1) {
                alert('입고가격을 입력해주세요.');
                return false;
            }

            if ($('#modify_rtl_prc').val() == null || $('#modify_rtl_prc').val().length < 1) {
                alert('소비자가격을 입력해주세요.');
                return false;
            }

            if ($('#modify_sls_prc').val() == null || $('#modify_sls_prc').val().length < 1) {
                alert('판매가격을 입력해주세요.');
                return false;
            }

            if ($('#modify_stk_plc_cd').val() == null || $('#modify_stk_plc_cd').val().length < 1) {
                alert('재고위치를 입력해주세요.');
                return false;
            }

            return true;
        }
    </script>
</div>


