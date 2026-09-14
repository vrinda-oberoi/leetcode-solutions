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
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr !=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
       if(head == null || head.next == null){
            if(n == 1){
                return null;
            }else{
                return head;
            }
       }

       head = reverse(head);
    
       ListNode temp = head;
       ListNode prev = null;
       int count = 1;
       while(temp != null && count != n){
        
        prev = temp;
        count++;
        temp = temp.next;
       }
       
       if(prev == null){
        head = temp.next;
       }else{
        prev.next = temp.next;
       }
     
        head = reverse(head);
        return head;
    }
}