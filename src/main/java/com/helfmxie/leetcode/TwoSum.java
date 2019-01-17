package com.helfmxie.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description 两数之和解法
 * @BelongsProject: leetcode
 * @BelongsPackage: com.helfmxie.leetcode
 * @Author: zhihaoxie
 * @CreateTime: 2019-01-16 15:25
 */
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            Integer index = map.get(difference);
            if (index != null && index != i) {
                return new int[]{i, index};
            }
        }
        return null;
    }
}