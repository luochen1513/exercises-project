package com.book.util;

import java.security.MessageDigest;

/**
 * @author: bai
 * @date: 2022/4/30 12:50
 * @description: md5加密工具
 */
public class Md5Util {

    public static String getMd5(String origin) {
        //自定义数组,相当于盐
        char[] hexArray = {
                '5', 'a', '4', 'b', '9', '6', '8', 'f', 'e', '2', '2', '7', 'e', 'o', 'g', '0'
        };
        try {
            byte[] originBytes = origin.getBytes();
            //md5加密实例
            MessageDigest md5Instance = MessageDigest.getInstance("MD5");
            md5Instance.update(originBytes);
            //加密后数组
            byte[] digest = md5Instance.digest();
            //加盐数组
            char[] str = new char[digest.length * 2];
            int k = 0;
            //对加密数组加盐
            //判断数组长度,遍历数组,对每个数组进行移位运算(二进制)
            for (byte b : digest) {
                //0xf(16进制):1111(2进制)
                str[k++] = hexArray[b >>> 4 & 0xf];
                str[k++] = hexArray[b & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return "123456";
        }
    }

    public static void main(String[] args) {
        System.out.println(Md5Util.getMd5("1513"));
    }
}
