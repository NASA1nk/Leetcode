/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 如何确定每层的list的长度
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){
            return ans;
        }
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> t = new LinkedList<>();
            // 一次性全部出队：ans.size()
            for(int i=q.size(); i>0; i--){
                TreeNode node = q.poll();
                t.add(node.val);
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            ans.add(t);
        }
        return ans;
    }
}
