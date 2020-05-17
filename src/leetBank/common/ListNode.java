package leetBank.common;

/**
 * Definition for singly-linked list.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static void printListNode(ListNode head) {
        if (head == null)
            return;
        while (head.next != null) {
            System.out.print(head.val + "-->");
            head = head.next;
        }
        System.out.println(head.val);
    }

}
