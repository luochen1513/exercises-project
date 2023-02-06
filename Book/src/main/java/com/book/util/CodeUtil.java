package com.book.util;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: bai
 * @date: 2022/4/17 16:28
 * @description: 验证码校验工具
 */
public class CodeUtil {
    /**
     * @param request:获取实际的验证码
     * @param verifyCodeActual:用户输入的验证码
     * @return: boolean
     * @description:
     */
    public static boolean checkVerifyCode(HttpServletRequest request, String verifyCodeActual) {
        //生成的验证码
        String verifyCodeExpected = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        //用户输入验证码
        verifyCodeActual = verifyCodeActual.toUpperCase();
        if (verifyCodeActual == null || !verifyCodeExpected.equalsIgnoreCase(verifyCodeActual)){
            return false;
        }
        return true;
    }
}
