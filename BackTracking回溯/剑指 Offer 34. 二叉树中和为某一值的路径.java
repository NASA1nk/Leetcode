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
  // 路径必须包含根节点到叶子节点
  List<List<Integer>> ans = new LinkedList<>();
  public List<List<Integer>> pathSum(TreeNode root, int target) {
      LinkedList<Integer> track = new LinkedList<>();
      backtrack(root,target,track);
      return ans;
  }
  public void backtrack(TreeNode root,int target,LinkedList<Integer> track){
      if(root == null){
          return ;
      }
      track.add(root.val);
      target -= root.val;
      if(target == 0 && root.left == null && root.right == null){
          ans.add(new LinkedList(track));
          // 要删除
          track.removeLast();
          return ;
      }
      backtrack(root.left,target,track);
      backtrack(root.right,target,track);
      track.removeLast();
  }
}