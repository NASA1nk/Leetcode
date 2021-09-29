/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 前序遍历，交换左右节点即可
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode t = mirrorTree(root.left);
        root.left = mirrorTree(root.right);
        root.right = t;
        return root;
    }
}

// class Solution {
//     public TreeNode mirrorTree(TreeNode root) {
//         if(root != null){
//             helper(root);
//         }
//         return root;
//     }
//     public void helper(TreeNode root){
//         if(root.left == null && root.right == null){
//             return;
//         }
//         TreeNode tmp = root.left;
//         root.left = root.right;
//         root.right = tmp;
//         if(root.left != null){
//             helper(root.left);
//         }
//         if(root.right != null){
//             helper(root.right);
//         }
//     }
// }

// 空子树如何交换？
// 如何交换左右子树？是修改root的指针域
// class Solution {
//     public TreeNode mirrorTree(TreeNode root) {
//         if(root != null){
//             helper(root);
//         }
//         return root;
//     }
//     public void helper(TreeNode root){
//         if(root.left == null && root.right == null){
//             return;
//         }
//         if(root.left == null){
//             root.left = root.right;
//             root.right = null;
//             helper(root.left);
//         }
//         else if(root.right == null){
//             root.right = root.left;
//             root.left = null;
//             helper(root.right);
//         }
//         else{
//             TreeNode tmp = root.left;
//             root.left = root.right;
//             root.right = tmp;
//             helper(root.left);
//             helper(root.right);
//         }
//     }
// }