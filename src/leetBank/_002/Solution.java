package leetBank._002;

import leetBank.common.ListNode;

/**
 * 思路1：
 * 根据两链表是否为空及是否存在进位区分不同的情况，依次构造链表
 * 链表 dummy头的运用
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int carry = 0;  // 是否有进位
        int sum = 0;

        while (l1 != null || l2 != null || carry == 1) {
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val + carry;
                carry = 0;
                if (sum > 9) {
                    carry = 1;
                    sum -= 10;
                }
                head.next = new ListNode(sum);
                head = head.next;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                sum = l1.val + carry;
                carry = 0;
                if (sum > 9) {
                    carry = 1;
                    sum = 0;
                }
                head.next = new ListNode(sum);
                head = head.next;
                l1 = l1.next;
            } else if (l2 != null) {
                sum = l2.val + carry;
                carry = 0;
                if (sum > 9) {
                    carry = 1;
                    sum = 0;
                }
                head.next = new ListNode(sum);
                head = head.next;
                l2 = l2.next;
            } else {
                head.next = new ListNode(1);
                head = head.next;
                carry = 0;
            }
        }
        return dummy.next;
    }

    // 极简编程 -- 活用三目运算
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    // Best Code [from potpie] -- 巧用进位：sum/10
    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;
    }


    /**
     * 思路2：
     * 先将两链表转化为整型数相加，在将结果的整型数转化为链表。
     * 缺陷：容易整型溢出。
     */

}

