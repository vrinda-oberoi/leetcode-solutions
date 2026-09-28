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
        int len = 0;
        ListNode curr = head;
        while(curr != null){
            len++;
            curr = curr.next;
        }
       
        if(len == n){
            return head.next;
        }
        int req = len-n+1;

        ListNode temp = head;
        ListNode prev =null;
        int count = 1;

        while(count != req){
             count++;
             prev = temp;
             temp = temp.next;
        } 

        prev.next = temp.next;

        return head;
    }
}