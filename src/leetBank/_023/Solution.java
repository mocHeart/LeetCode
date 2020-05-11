package leetBank._023;

import leetBank.common.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    // 解法1： 顺序合并
    //   合并K个有序链表，可以两个两个顺序合并，采用problem21中的方式合并两个有序数组
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1)
            return null;
        ListNode head = lists[0];
        for (int i = 1; i < lists.length; i++) {
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
    }
    // 合并2个有序列表
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

    // 解法2： 分治合并，
    public ListNode mergeKLists2(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }
    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right)
            return lists[left];
        if (left > right)
            return null;
        int mid = (left + right) >> 1;
        return mergeTwoLists(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    // 解法3：优先队列
    // 先将k个列表的头指针加入最小堆，然后依次从最小堆中取出堆顶元素
    // 每取一个将其加入结果链表上，并将其后一个结点加入堆中
    public ListNode mergeKLists3(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        for (ListNode node: lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = minNode;
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }

        return dummyHead.next;
    }


    public static void main(String[] args) {
        Solution so = new Solution();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = new ListNode[3];
        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;

        ListNode head = so.mergeKLists2(lists);
        while (head.next != null) {
            System.out.print(head.val + "-->");
            head = head.next;
        }
        System.out.print(head.val);

    }

}
