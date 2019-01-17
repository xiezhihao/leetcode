package com.helfmxie.leetcode;

import java.util.ArrayList;

/**
 * @description 两数相加
 * @BelongsProject: leetcode
 * @BelongsPackage: com.helfmxie.leetcode
 * @Author: zhihaoxie
 * @CreateTime: 2019-01-17 10:08
 */
class AddTwoNumbers {

    /**
     * 这个算法在时间和空间上都可以优化，l1与l2的迭代可以同时进行
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        ListNode currentNode1 = l1;
        ListNode currentNode2 = l2;
        while (currentNode1 != null) {
            arrayList1.add(currentNode1.val);
            currentNode1 = currentNode1.next;
        }
        while (currentNode2 != null) {
            arrayList2.add(currentNode2.val);
            currentNode2 = currentNode2.next;
        }
        Integer maxSize = arrayList1.size() > arrayList2.size() ? arrayList1.size() : arrayList2.size();
        ListNode firstNode = null;
        ListNode currentNode = null;
        int addNumber = 0;
        for (int i = 0; i <= maxSize; i++) {
            int num1 = 0;
            int num2 = 0;
            try {
                num1 = arrayList1.get(i);
            } catch (IndexOutOfBoundsException e) {

            }
            try {
                num2 = arrayList2.get(i);
            } catch (IndexOutOfBoundsException e) {

            }
            int currentNumber = (num1 + num2 + addNumber) % 10;
            addNumber = (num1 + num2 + addNumber) / 10;
            if (currentNumber == 0 && i == maxSize) {
                continue;
            }
            ListNode nextNode = new ListNode(currentNumber);
            if (firstNode == null) {
                firstNode = nextNode;
            } else {
                currentNode.next = nextNode;
            }
            currentNode = nextNode;
        }
        return firstNode;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}