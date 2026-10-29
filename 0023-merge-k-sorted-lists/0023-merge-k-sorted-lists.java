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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;

        if(n ==0 ){
            return null;
        }

        return partitionAndMerge(0,n-1,lists);
    }

    private ListNode partitionAndMerge(int start,int end,ListNode[] lists){
        if(start == end){
            return lists[start];
        }

        int mid = start +(end-start)/2;

        ListNode L1 = partitionAndMerge(start,mid,lists);
        ListNode L2 = partitionAndMerge(mid+1,end,lists);

        return mergeTwoLists(L1,L2);
    }

    private ListNode mergeTwoLists(ListNode L1,ListNode L2){
        if(L1 == null) return L2;
        if(L2 == null) return L1;

        if(L1.val <= L2.val){
            L1.next = mergeTwoLists(L1.next,L2);
            return L1;
        }else{
            L2.next = mergeTwoLists(L2.next,L1);
            return L2;
        }
    }
}