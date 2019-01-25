package com.helfmxie.leetcode;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: com.helfmxie.leetcode
 * @Author: zhihaoxie
 * @CreateTime: 2019-01-19 18:15
 * @Description: 无重复字符的最长子串
 */
public class LengthOfLongestSubstring {


    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        StringBuilder stringBuilder = new StringBuilder(s.substring(0, 1));
        Set<String> stringSet = new LinkedHashSet<>();
        stringSet.add(s.substring(0, 1));
        int maxLength = stringBuilder.toString().length();
        int index = 1;
        while (index < s.length()) {
            if (stringSet.contains(s.substring(index, index + 1))) {
                if (stringBuilder.toString().length() > maxLength) {
                    maxLength = stringBuilder.toString().length();
                }
                index = s.indexOf(stringBuilder.toString(), index - stringBuilder.toString().length())
                        + stringBuilder.toString().indexOf(s.substring(index, index + 1))
                        + 1;
                stringSet.clear();
                stringBuilder = new StringBuilder(s.substring(index, index + 1));
                stringSet.add(s.substring(index, index + 1));
                index++;
                continue;
            } else {
                stringBuilder.append(s.substring(index, index + 1));
                stringSet.add(s.substring(index, index + 1));
                if (index == s.length() - 1 && stringBuilder.toString().length() > maxLength) {
                    maxLength = stringBuilder.toString().length();
                }
                index++;
            }
        }
        return maxLength;
    }
}
