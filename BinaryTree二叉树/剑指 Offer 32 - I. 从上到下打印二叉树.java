/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// null的处理（序列化时需要保留）
// List容器中的元素有序、可重复，每个元素都对应一个整数型的索引，可以根据索引存取容器中的元素
// list.toArray()方法不能直接从Integer转换到int数组

class Solution {
    public int[] levelOrder(TreeNode root) {
        // 当树的根节点为空时直接返回空数组[]
        if(root == null){
            return new int[0];
        }
        List<Integer> t = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        // 插入队尾
        q.offer(root);
        while(!q.isEmpty()){
            // 删除队首元素并返回
            TreeNode node = q.poll();
            // 层序遍历处理部分
            t.add(node.val);
            if(node.left != null){
                q.offer(node.left);
            }
            if(node.right != null){
                q.offer(node.right);
            }
        }
        int[] ans = new int[t.size()];
        for(int i=0; i<t.size(); i++){
            ans[i] = t.get(i);
        }
        return ans;
    }
}
