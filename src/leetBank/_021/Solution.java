package leetBank._021;

import leetBank.common.ListNode;

public class Solution {
    // 解法1： 迭代
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                p.next = l2;
                break;
            } else if (l2 == null) {
                p.next = l1;
                break;
            } else {
                if (l1.val < l2.val) {
                    p.next = l1;
                    l1 = l1.next;
                } else {
                    p.next = l2;
                    l2 = l2.next;
                }
                p = p.next;
            }
        }
        return head.next;
    }

    // 解法2： 递归
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    public static void main(String[] args) {
        Solution so = new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode p = so.mergeTwoLists2(l1, l2);
        while (p.next != null) {
            System.out.print(p.val + "-->");
            p = p.next;
        }
        System.out.print(p.val);
    }
}
