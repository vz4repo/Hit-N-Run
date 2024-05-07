package com.homerunball.customer.validator;

import com.homerunball.customer.controller.CustValidator;
import com.homerunball.customer.domain.CustDto;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CustValidatorTest {

    private CustValidator custValidator;

    @Before
    public void setUp() {
        custValidator = new CustValidator();
    }


    @Test
    public void testInvalidEmail() {
        CustDto custDto = new CustDto();
        custDto.setC_email("2322");

        Errors errors = new BeanPropertyBindingResult(custDto, "custDto");
        custValidator.validate(custDto, errors);
        boolean rowCnt = errors.hasFieldErrors("c_email");
        assertTrue(rowCnt);

    }


    @Test
    public void testInvalidPassword() {
        CustDto custDto = new CustDto();
        custDto.setC_email("sjsj@naver.com");
        custDto.setC_pwd("11222");

        Errors errors = new BeanPropertyBindingResult(custDto, "custDto");
        custValidator.validate(custDto, errors);
        boolean rowCnt = errors.hasFieldErrors("c_pwd");
        assertTrue(rowCnt);
    }


    @Test
    public void regTest(){
        String regex = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*()_+={};':\"|,.<>?]).{8,15}$";
        String input = "11111qqq@q";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        boolean rowCnt = matcher.matches();
        assertTrue(rowCnt);

    }
}

