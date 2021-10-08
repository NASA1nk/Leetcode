/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int ans = 0;
    public boolean isBalanced(TreeNode root) {
        int t = isBalancediml(root);
        if(t != -1){
            return true;
        }
        return false;
    }
    public int isBalancediml(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = isBalancediml(root.left);
        if(l == -1){
            return -1;
        }
        int r = isBalancediml(root.right);
        if(r == -1){
            return -1;
        }
        if(Math.abs(l-r) > 1){
            return -1;
        }
        return Math.max(l,r)+1;
    }
}

// class Solution {
//     int ans = 0;
//     public boolean isBalanced(TreeNode root) {
//         int t = isBalancediml(root);
//         if(t != -1){
//             return true;
//         }
//         return false;
//     }
//     public int isBalancediml(TreeNode root){
//         if(root == null){
//             return 0;
//         }
//         int l = isBalancediml(root.left);
//         int r = isBalancediml(root.right);
//         if(l == -1 || r == -1){
//             return -1;
//         }
//         if(Math.abs(l-r) > 1){
//             return -1;
//         }
//         return Math.max(l,r)+1;
//     }
// }

// class Solution {
//     int ans = 0;
//     public boolean isBalanced(TreeNode root) {
//         if(root == null){
//             return true;
//         }
//         // 获取左右子树的深度，再处理
//         if(Math.abs(isBalancediml(root.left,1) - isBalancediml(root.right,1)) <= 1){
//             return isBalanced(root.left) && isBalanced(root.right);
//         }
//         return false;
//     }
//     public int isBalancediml(TreeNode root, int depth){
//         if(root == null){
//             return depth;
//         }
//         int left = isBalancediml(root.left,depth+1);
//         int right = isBalancediml(root.right,depth+1);
//         return Math.max(left,right);
//     }
// }