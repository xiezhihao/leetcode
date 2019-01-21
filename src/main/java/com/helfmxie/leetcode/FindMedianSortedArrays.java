package com.helfmxie.leetcode;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: com.helfmxie.leetcode
 * @Author: zhihaoxie
 * @CreateTime: 2019-01-21 16:03
 * @Description: 寻找两个有序数组的中位数
 */
public class FindMedianSortedArrays {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] array = mergeArrays(nums1, nums2);
        //中位数的规则
        if (array.length % 2 == 0) {
            return (new Double(array[(array.length) / 2 - 1])
                    +
                    new Double(array[array.length / 2])) / new Double(2);
        } else {
            return (new Double(array[(array.length + 1) / 2 - 1]));
        }
    }

    /**
     * 将两个有序数组合并成一个有序数组
     * 设置两个指针，分别指向两个数组，迭代比较数组元素，将小的元素置入新的数组，并且移动指针，大的元素指针不移动。
     * 直到一个数组被迭代完，将剩余元素统一放到新的数组中
     */
    private int[] mergeArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0, k = 0;
        int[] array = new int[nums1.length + nums2.length];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                array[k] = nums1[i];
                i++;
            } else {
                array[k] = nums2[j];
                j++;
            }
            k++;
        }
        if (i < nums1.length) {
            for (int l = i; l < nums1.length; l++) {
                array[k] = nums1[l];
                k++;
            }
        }
        if (j < nums2.length) {
            for (int l = j; l < nums2.length; l++) {
                array[k] = nums2[l];
                k++;
            }
        }
        return array;
    }
}
