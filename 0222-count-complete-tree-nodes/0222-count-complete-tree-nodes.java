/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int leftHeight = findLeft(root.left);
        int rightHeight = findRight(root.right);

        if(leftHeight == rightHeight){
            return ((2<<(leftHeight))-1);
        }

        else return countNodes(root.left) + countNodes(root.right) +1;
    }

    private int findLeft(TreeNode node){
        if(node == null) return 0;

        int count =0;
        while(node != null){
            node =node.left;
            count++;
        }

        return count;
    }

    private int findRight(TreeNode node){
        if(node == null) return 0;
        int count = 0;
        while(node != null){
            node = node.right;
            count++;
        }
        return count;
    }
}