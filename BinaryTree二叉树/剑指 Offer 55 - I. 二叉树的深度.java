/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 一开始认为返回0无法作为递归终止条件
// 但其实深度是由下往上累加的，所以递归到叶子节点本身就就是0
// 再一层层返回上去，就是结果
class Solution {
  public int maxDepth(TreeNode root) {
      if(root == null){
          return 0;
      }
      return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
  }
}

// class Solution {
//     public int maxDepth(TreeNode root) {
//         if(root == null){
//             return 0;
//         }
//         int t = 0;
//         return maxDepthiml(root,t);
//     }
//     public int maxDepthiml(TreeNode root,int depth){
//         if(root == null){
//             return depth;
//         }
//         return Math.max(maxDepthiml(root.left,depth),maxDepthiml(root.right,depth))+1;
//     }
// }