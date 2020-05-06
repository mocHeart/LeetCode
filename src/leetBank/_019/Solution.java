package leetBank._019;

import leetBank.common.ListNode;

public class Solution {
    // 解法： 双指针
    // 两个指针初始都指向头结点，先让一个指针向后移动n个结点，再两个指针同时向后移动
    // 直到一个指针到达链表末尾，此时删除前一个指针的后一个结点即可
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front = head;
        ListNode end = head;
        while (n != 0) {
            end = end.next;
            n--;
        }
        if (end == null)  // 删除的是头结点
            return head.next;

        while (end.next != null) {
            end = end.next;
            front = front.next;
        }
        end = front.next;
        front.next = front.next.next;
        end = null;
        return head;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int i = 2; i < 2; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
        head = so.removeNthFromEnd(head, 1);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
