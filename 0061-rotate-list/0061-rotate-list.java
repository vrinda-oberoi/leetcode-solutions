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
    public ListNode reverseLL(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
    public ListNode rotateRight(ListNode head, int k) {
        // Edge cases
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int len = 0;
        ListNode curr = head;

        while(curr != null){
            len++;
            curr = curr.next;
        } 

        // Remove unnecessary full rotations
        k = k % len;

        if (k == 0) {
            return head;
        }

        // Reverse entire list
        head = reverseLL(head);

        
        int count = 1;
        ListNode temp = head;
        while(count < k){
            temp = temp.next;
            count++;
        }

        ListNode other = temp.next;
        temp.next = null;

        ListNode firstH = reverseLL(head);
        ListNode secondH = reverseLL(other);

        curr = firstH;
        while(curr.next != null){
            curr = curr.next;
        }

        curr.next = secondH;

        return firstH;
    }
}