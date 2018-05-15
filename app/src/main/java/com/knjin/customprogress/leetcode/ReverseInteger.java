package com.knjin.customprogress.leetcode;

import java.util.InputMismatchException;

/**
 * @author Jing
 * @Description Given a 32-bit signed integer, reverse digits of an integer.
 * @Time 18/5/10
 */
public class ReverseInteger {
    public static int reverse(int x) {
        int temp = Math.abs(x);
        String str = Integer.toString(temp);
        StringBuffer sb = new StringBuffer();
        char[] nums = str.toCharArray();
        for (int i = nums.length;i > 0;i --){
            if (nums[i-1] != '-'){
                sb.append(nums[i-1]);
            }
        }
        String result = sb.toString();
        if (Long.parseLong(result) > Integer.MAX_VALUE){
            result = "0";
        }
        return x > 0 ? Integer.parseInt(result) : - Integer.parseInt(result);
    }
}
