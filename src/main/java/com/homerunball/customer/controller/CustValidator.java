//package com.homerunball.cust.controller;
//
//import com.homerunball.cust.dto.CustDto;
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//import org.springframework.validation.Validator;
//
//public class CustValidator implements Validator {
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return CustDto.class.isAssignableFrom(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        System.out.println("CustValidator.validate() is called");
//
//        CustDto custdto = (CustDto)target;
//
//        String c_email = custdto.getC_email();
//
//        if(c_email==null || c_email.length() <  1 || c_email.length() > 12) {
//            errors.rejectValue("c_email", "invalidLength", new String[]{"1","12"}, null);
//        }
//    }
//}