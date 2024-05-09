package com.homerunball.admin.stock.controller;

import com.homerunball.admin.product.domain.ProductDto;
import com.homerunball.admin.product.service.ProductService;
import com.homerunball.admin.stock.domain.StockDto;
import com.homerunball.admin.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/stock")
public class StockController {

    @Autowired
    private StockService stockService;
    @Autowired
    private ProductService productService;

    /*재고관리 페이지에서 등록된 제품을 조회할 때 사용하는 메서드*/
    @GetMapping("/list")
    public String list(Model model) {
        try {
            /* 등록된 제품의 리스트를 전체 보여준다. */
            List<ProductDto> productList = productService.getAllProducts();
            model.addAttribute("productList", productList);

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "LIST_ERR");
            return "errorPage";
        }
        return "/admin/stock/stockList";
    }

    /* 제품의 재고 사이즈를 조회하여 재고 수량을 조회하는 메서드 */
    @PostMapping("/count")
    @ResponseBody
    public StockDto stockCount(@RequestBody Map getStockSize, Model model) throws Exception {
        /* jsp로부터 전달받은 제품 id와 사이즈를 이용하여 DB조회 후 객체에 정보를 담는다. */
        String pdId = getStockSize.get("pd_id").toString();
        String pdClsfCd = getStockSize.get("pd_clsf_cd").toString();
        StockDto stockDto = new StockDto();
        stockDto.setNml_stk_qty(0);
        stockDto.setRt_stk_qty(0);
        stockDto.setRgn_stk_qty(0);
        stockDto.setUrgn_stk_qty(0);
        stockDto.setSfty_stk_qty(0);

        try {
            /* 사이즈가 ALL이면 모든 사이즈의 재고수량을 더한다. */
            if (pdClsfCd.equals("ALL")) {
                String[] sizes = {"XS", "S", "M", "L", "XL", "2XL", "3XL"};
                for (String size : sizes) {
                    StockDto tempStockDto = stockService.getOneStock(pdId, size);
                    /* 재고가 null이 아닐 때만 재고 수량을 더한다. */
                    if (tempStockDto != null) {
                        stockDto.setNml_stk_qty(stockDto.getNml_stk_qty() + tempStockDto.getNml_stk_qty());
                        stockDto.setRt_stk_qty(stockDto.getRt_stk_qty() + tempStockDto.getRt_stk_qty());
                        stockDto.setRgn_stk_qty(stockDto.getRgn_stk_qty() + tempStockDto.getRgn_stk_qty());
                        stockDto.setUrgn_stk_qty(stockDto.getUrgn_stk_qty() + tempStockDto.getUrgn_stk_qty());
                        stockDto.setSfty_stk_qty(stockDto.getSfty_stk_qty() + tempStockDto.getSfty_stk_qty());
                    }
                }
            } else { /* 개별 사이즈로 값이 넘어올 때 */
                stockDto = stockService.getOneStock(pdId, pdClsfCd);
                /* 등록된 재고를 찾을 수 없으면 재고값을 0으로 반환 */
                if (stockDto == null) {
                    stockDto = new StockDto();
                    stockDto.setNml_stk_qty(0);
                    stockDto.setRt_stk_qty(0);
                    stockDto.setRgn_stk_qty(0);
                    stockDto.setUrgn_stk_qty(0);
                    stockDto.setSfty_stk_qty(0);
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            model.addAttribute("msg", "NullPointException");
        }
        return stockDto;
    }

    /* 재고 일괄설정 버튼클릭 > 재고 수정 ajax 구동 */
    @PostMapping("/modify")
    @ResponseBody                               //비동기 통신
    public String modify(Model model, HttpServletRequest request) {

        return "/admin/stock/stockModify";
    }

    @PostMapping("/register")
    @ResponseBody                               //비동기 통신
    public String register(@RequestBody StockDto stockDto, Model model) {

        /* odpmt_stk(가용재고)는 (nml_stk_qty(정상재고) + rt_stk_qty(반품재고), rgn_stk_qty(재생가능재고)) 수량임 */

        /* 입력한 pur_dt(매입일), rcpt_dt(입고일)의 "-"를 공백으로 교체하고 varChar에 맞춰 String으로 변환 */
        stockDto.setPur_dt(stockDto.getPur_dt().replace("-", ""));
        stockDto.setRcpt_dt(stockDto.getRcpt_dt().replace("-", ""));

        /*System.out.println(stockDto);*/
        try {
            /* pd_clsf_cd(제품사이즈)가 ALL 일 때 모든 사이즈를 insert 해야함..  */
            if (stockDto.getPd_clsf_cd().equals("ALL")) {
                String[] sizes = {"XS", "S", "M", "L", "XL", "2XL", "3XL"};
                for (String size : sizes) {
                    StockDto newStock = new StockDto();
                    newStock.setPd_id(stockDto.getPd_id());
                    newStock.setPd_name(stockDto.getPd_name());
                    newStock.setPd_clsf_cd(size);
                    newStock.setNml_stk_qty(stockDto.getNml_stk_qty());
                    newStock.setRt_stk_qty(stockDto.getRt_stk_qty());
                    newStock.setRgn_stk_qty(stockDto.getRgn_stk_qty());
                    newStock.setUrgn_stk_qty(stockDto.getUrgn_stk_qty());
                    newStock.setSfty_stk_qty(stockDto.getSfty_stk_qty());
                    newStock.setOdpmt_stk(stockDto.getOdpmt_stk());
                    newStock.setPur_dt(stockDto.getPur_dt());
                    newStock.setRcpt_dt(stockDto.getRcpt_dt());
                    newStock.setRcpt_cp(stockDto.getRcpt_cp());
                    newStock.setRcpt_prc(stockDto.getRcpt_prc());
                    newStock.setRtl_prc(stockDto.getRtl_prc());
                    newStock.setSls_prc(stockDto.getSls_prc());
                    newStock.setStk_plc_cd(stockDto.getStk_plc_cd());
                    newStock.setFrst_reg_id("hyunji");
                    newStock.setStk_stat_cd("입고_예정");

                    if (stockService.create(newStock) != 1) {
                        throw new Exception("등록에 실패했습니다.");
                    }

                    System.out.println("register success");
                }
            } else {
                StockDto newStock = new StockDto();
                newStock.setPd_id(stockDto.getPd_id());
                newStock.setPd_name(stockDto.getPd_name());
                newStock.setPd_clsf_cd(stockDto.getPd_clsf_cd());
                newStock.setNml_stk_qty(stockDto.getNml_stk_qty());
                newStock.setRt_stk_qty(stockDto.getRt_stk_qty());
                newStock.setRgn_stk_qty(stockDto.getRgn_stk_qty());
                newStock.setUrgn_stk_qty(stockDto.getUrgn_stk_qty());
                newStock.setSfty_stk_qty(stockDto.getSfty_stk_qty());
                newStock.setOdpmt_stk(stockDto.getOdpmt_stk());
                newStock.setPur_dt(stockDto.getPur_dt());
                newStock.setRcpt_dt(stockDto.getRcpt_dt());
                newStock.setRcpt_cp(stockDto.getRcpt_cp());
                newStock.setRcpt_prc(stockDto.getRcpt_prc());
                newStock.setRtl_prc(stockDto.getRtl_prc());
                newStock.setSls_prc(stockDto.getSls_prc());
                newStock.setStk_plc_cd(stockDto.getStk_plc_cd());
                newStock.setFrst_reg_id("hyunji");
                newStock.setStk_stat_cd("입고_예정");

                if (stockService.create(newStock) != 1) {
                    throw new Exception("등록에 실패했습니다.");
                }

                System.out.println("register success");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/admin/product/list";
        }
        /*  */
        /*  */
        /*  */
        /*  */
        /*  */
        /*  */
        /*  */
        /*  */
        /*  */

        return "redirect:/admin/stock/stockList";
    }



    /*상품목록 검색하는 기능 -> 검색해서 내가 원하는 상품 목록 조회 -> 선택한 상품 재고 등록 or 수정*/
}
