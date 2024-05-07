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

@Controller
@RequestMapping("/admin/stock")
public class StockController {

    @Autowired
    private StockService stockService;
    @Autowired
    private ProductService productService;

    /*등록된 재고 전체를 조회하는 메서드*/
    @GetMapping("/list")
    public String list(Model model) {
        try{
            List<StockDto> stockList = stockService.getList();
            /*productList: 등록된 제품을 모두 저장한다.*/
            List<ProductDto> productList = productService.getAllProducts();
            /*productCount: 등록된 제품의 전체 개수를 센다.*/
            model.addAttribute("productList", productList);
            model.addAttribute("stockList", stockList);

        } catch (Exception e){
            e.printStackTrace();
            model.addAttribute("msg", "LIST_ERR");
            return "errorPage";
        }
        return "/admin/stock/stockList";
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
        stockDto.setPur_dt(stockDto.getPur_dt().replace("-",""));
        stockDto.setRcpt_dt(stockDto.getRcpt_dt().replace("-",""));

        /*System.out.println(stockDto);*/
        try{
            /* pd_clsf_cd(제품사이즈)가 ALL 일 때 모든 사이즈를 insert 해야함..  */
            if(stockDto.getPd_clsf_cd().equals("ALL")){
                String[] sizes = {"XS", "S", "M", "L", "XL", "2XL", "3XL"};
                for(String size:sizes){
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

                    if(stockService.create(newStock) != 1){
                        throw new Exception("등록에 실패했습니다.");
                    }
                    System.out.println("register success");
                }
            }
        } catch(Exception e) {
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
