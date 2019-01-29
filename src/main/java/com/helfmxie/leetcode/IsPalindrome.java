package com.helfmxie.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: com.helfmxie.leetcode
 * @Author: zhihaoxie
 * @CreateTime: 2019-01-29 12:20
 * @Description: 回文数
 */
public class IsPalindrome {
    

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        int xCpoy = x;
        while (true) {
            if (xCpoy != 0) {
                list.add(xCpoy % 10);
                xCpoy = xCpoy / 10;
            } else {
                break;
            }
        }
        int reverseX = 0;
        for (int i = list.size() - 1, j = 1; i > -1; i--, j *= 10) {
            reverseX = reverseX + list.get(i) * j;
        }
        return x == reverseX;
    }
}
