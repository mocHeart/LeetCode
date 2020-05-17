package leetBank._024;

import leetBank.common.ListNode;

public class Solution {
    // 解法1：递归
    // 剩余至少两个节点，第一个节点的下一个为递归返回值（下两个的头结点）
    // 第二个节点的下一个节点为第一个节点
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode firstNode = head;
        ListNode secondNode = head.next;

        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        return secondNode;

    }

    // 解法2： 迭代
    // 添加前置dummy节点帮助处理，同时每次迭代的指针的指向变化
    public ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevNode = dummy;

        while ((head != null) && head.next != null) {
            // 节点暂存
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // 交换
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // 重置
            prevNode = firstNode;
            head = firstNode.next;
        }
        return dummy.next;
    }

        public static void main(String[] args) {
        Solution so = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode.printListNode(head);
        head = so.swapPairs2(head);
        ListNode.printListNode(head);
    }
}
