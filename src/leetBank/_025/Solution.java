package leetBank._025;

import leetBank.common.ListNode;

public class Solution {
    // 解法1： 递归
    // 方法与链表节点两两交换类似，只是将需要采用循环将分块的链表反向
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode p = head;  // p节点移动到下一块需要反转部分的起始
        ListNode q = head.next;  // q节点用于辅助一块区域节点的反转
        for (int i = 0; i < k; i++) {
            if (p == null)
                return head;
            p = p.next;
        }
        head.next = reverseKGroup(p, k);  // 每块的头结点指向下一块反转后的头结点
        for (int i = 1; i < k; i++) {
            ListNode temp = q.next;
            q.next = head;
            head = q;
            q = temp;
        }
        return head;
    }

    // 解法2：迭代
    // 每K个为一个块，调用子查询进行反转
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++)
                end = end.next;

            if (end == null)
                break;

            ListNode start = pre.next;
            ListNode next = end.next;

            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int i = 2; i < 16; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
        ListNode.printListNode(head);
        head = so.reverseKGroup2(head, 4);
        ListNode.printListNode(head);
    }
}
