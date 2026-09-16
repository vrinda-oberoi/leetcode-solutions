/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        int len = 1;
        ListNode tail=head;

        while(tail.next !=null){
            len++;
            tail = tail.next;
        }

        if( k % len == 0){
            return head;
        }

        k = k % len;
        int steps = len-k;
        tail.next = head;
        ListNode newNode = findKth(head,steps);
        head = newNode.next;
        newNode.next = null;

        return head;
    }

    public static ListNode findKth(ListNode head,int steps){
        ListNode temp = head;
        for(int i=1;i<steps;i++){
        temp = temp.next;
        }
        return temp;
    }
}