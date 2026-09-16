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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null){
            ListNode kthNode = findKth(temp,k);

            if(kthNode == null){
                if(prev != null){
                    prev.next = temp;
                }
                    break;
            }else{
                ListNode nextNode = kthNode.next;
                kthNode.next = null;
                reverseLL(temp);

                if(temp == head){
                    head = kthNode;
                }else{
                    prev.next = kthNode;
                }

                prev = temp;
                temp = nextNode;
            }
        }

        return head;
    }

    public static ListNode findKth(ListNode head,int k){
        ListNode curr = head;
        for(int count =1;count <k;count++){
            if(curr == null){
                return null;
            }
            curr = curr.next;
        }

        return curr;
    }

    public static ListNode reverseLL(ListNode head){
        if(head.next == null){
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
}