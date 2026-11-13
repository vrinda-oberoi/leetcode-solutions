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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode temp = head;
        if(head.next == null){
            return null;
        }

        while(temp != null){
            length++;
            temp = temp.next;
        }
        
        if(length == n) return head.next;

        int req = length - n +1;
        ListNode curr = head;
        ListNode prev = null;
        int count = 1;

        while(count != req){
            count++;
            prev = curr;
            curr = curr.next;
        }

        prev.next = curr.next;
        return head;
    }
}