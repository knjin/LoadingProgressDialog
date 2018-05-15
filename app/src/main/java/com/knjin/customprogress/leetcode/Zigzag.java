package com.knjin.customprogress.leetcode;

/**
 * @author Jing
 * @Description
 * @Time 18/5/10
 */
public class Zigzag {

    /**
     * zigzag  12345678
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 0) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();//最终生成的结果
        //转换s 中的字符串为一个 String 数组
        char[] chars = s.toCharArray();
        //分拆开始，第一列 肯定是要满列的。发现每次需要跳的坐标是 2N-2
        int size = 2*numRows -2;

        for (int i = 0; i < numRows; i ++){//循环的总数是 需要的行数

            for (int j = i; j < chars.length;j += size){//针对字符串数组进行循环,这个下标直接就是字符串数组的下标
                sb.append(chars[j]);
                //如果不是是第一行或者是最后一行 中间行
                if (i != 0 && i != numRows-1){
                    int temp = j + size - 2*i;//中间行需要跳隔离开的位数
                    if (temp < chars.length){
                        sb.append(chars[temp]);
                    }
                }

            }

        }

        return sb.toString();
    }
}
