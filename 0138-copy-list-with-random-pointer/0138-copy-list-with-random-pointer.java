/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null ){
            return null;
        }

        HashMap<Node,Node> newNode = new HashMap<>();
        Node curr = head;
        while(curr != null){
            newNode.put(curr,new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while(curr != null){
            newNode.get(curr).next = newNode.get(curr.next);
            newNode.get(curr).random = newNode.get(curr.random);
            curr = curr.next;
        }

        return newNode.get(head);
    }
}