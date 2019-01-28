package com.helfmxie.leetcode;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: com.helfmxie.leetcode
 * @Author: zhihaoxie
 * @CreateTime: 2019-01-28 09:52
 * @Description: 整数反转
 */
public class Reverse {


    public int reverse(int x) {
        long absoluteValue = x < 0 ? (new Long(x) * -1) : x;
        String str = new Long(absoluteValue).toString();
        StringBuilder reverseString = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reverseString.append(str.charAt(i));
        }
        if (new Long(reverseString.toString()) > Integer.MAX_VALUE) {
            return 0;
        } else {
            int reverseValue = x < 0 ? (Integer.parseInt(reverseString.toString()) * -1) : Integer.parseInt(reverseString.toString());
            return reverseValue;
        }
    }
}
