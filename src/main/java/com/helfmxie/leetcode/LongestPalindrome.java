package com.helfmxie.leetcode;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: com.helfmxie.leetcode
 * @Author: zhihaoxie
 * @CreateTime: 2019-01-25 12:39
 * @Description: 最长回文子串
 */
public class LongestPalindrome {
    

    public String longestPalindrome(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return s;
        }
        /*abcdcba型处理*/
        int palindLeftIndex = 0;
        int palindRightIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            int leftIndex = i - 1;
            int rightIndex = i + 1;
            while (leftIndex >= 0 && rightIndex < s.length()) {
                if (s.charAt(leftIndex) == s.charAt(rightIndex)) {
                    if ((rightIndex - leftIndex + 1) > (palindRightIndex - palindLeftIndex + 1)) {
                        palindLeftIndex = leftIndex;
                        palindRightIndex = rightIndex;
                    }
                    leftIndex--;
                    rightIndex++;
                } else {
                    break;
                }
            }
        }
        /*abcddcba型处理*/
        for (int i = 0, j = i + 1; i < s.length() && j < s.length(); i++, j++) {
            if (s.charAt(i) == s.charAt(j)) {
                if ((j - i + 1) > (palindRightIndex - palindLeftIndex + 1)) {
                    palindLeftIndex = i;
                    palindRightIndex = j;
                }
            } else {
                continue;
            }
            int leftIndex = i - 1;
            int rightIndex = j + 1;
            while (leftIndex >= 0 && rightIndex < s.length()) {
                if (s.charAt(leftIndex) == s.charAt(rightIndex)) {
                    if ((rightIndex - leftIndex + 1) > (palindRightIndex - palindLeftIndex + 1)) {
                        palindLeftIndex = leftIndex;
                        palindRightIndex = rightIndex;
                    }
                    leftIndex--;
                    rightIndex++;
                } else {
                    break;
                }
            }
        }
        return s.substring(palindLeftIndex, palindRightIndex + 1);
    }

}
