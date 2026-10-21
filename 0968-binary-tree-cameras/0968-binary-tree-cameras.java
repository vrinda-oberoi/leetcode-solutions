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
   private int cameras = 0;
    public int minCameraCover(TreeNode root) {
        // 2 - camera nhi hai , camera required hai
        // 1 - camera hai already , required nhi hai
        // 0 - camera nhi hai , required bhi nhi hai 

        if(dfs(root) == 2){
            cameras++;
        }

        return cameras;
    }

    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        if(left == 2 || right == 2){
            cameras++;
            return 1;
        }

        if(left == 1 || right == 1){
            return 0;
        }

        return 2;
    }
}