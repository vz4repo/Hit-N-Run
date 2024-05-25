package com.homerunball.customer.controller;

import com.homerunball.customer.domain.CustDto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MyPageInfoValidator implements Validator {

    @Override
    /*supports는 객체(clazz)가 검증이 가능한지 알려주는 Validator의 메서드임*/
    public boolean supports(Class<?> clazz) {
        /*CustDto 타입만 검증한다*/
        return CustDto.class.equals(clazz);
    }

    @Override
    /*target: 검증할 객체, errors: 검증시 발생한 저장소*/
    /*validate 유효성 검사 메서드*/
    public void validate(Object target, Errors errors) {
        System.out.println("서버에서 검사할게요!");
        /*처음 설정이 오브젝트 타겟으로 되있어서 CustDto로 변경해줘야함*/
        CustDto custDto = (CustDto)target;

        String c_phn = custDto.getC_phn();

            if (c_phn == null || !c_phn.matches("^[0-9]{11,12}$")) {
                errors.rejectValue("c_phn", "invalidLength", "핸드폰 뚫을려고?" );
            }}
    }