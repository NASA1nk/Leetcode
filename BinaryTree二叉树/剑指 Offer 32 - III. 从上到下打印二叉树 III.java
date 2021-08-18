/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 3. 逻辑奇偶，每次遍历2层，不用判断
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null){
            return ans;
        }
        q.offer(root);
        while(!q.isEmpty()){
            LinkedList<Integer> t = new LinkedList<>();
            for(int i=q.size(); i>0; i--){
                TreeNode node = q.poll();
                t.addLast(node.val);
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            ans.add(t);
            // 没有节点了
            if(q.isEmpty()){
                break;
            }
            t = new LinkedList<>();
            for(int i=q.size(); i>0; i--){
                TreeNode node = q.poll();
                t.addFirst(node.val);
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


// 2. 使用ans.size()来判断奇偶
// class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         Queue<TreeNode> q = new LinkedList<>();
//         List<List<Integer>> ans = new LinkedList<>();
//         if(root == null){
//             return ans;
//         }
//         q.offer(root);
//         while(!q.isEmpty()){
//             // 必须使用LinkedList，独有方法
//             LinkedList<Integer> t = new LinkedList<>();
//             for(int i=q.size(); i>0; i--){
//                 TreeNode node = q.poll();
//                 if(ans.size() % 2 == 0){
//                     // 奇数层顺序插入
//                     t.addLast(node.val);
//                 }
//                 else{
//                     // 偶数层倒序插入
//                     t.addFirst(node.val);
//                 }
//                 if(node.left != null){
//                     q.offer(node.left);
//                 }
//                 if(node.right != null){
//                     q.offer(node.right);
//                 }
//             }
//             ans.add(t);
//         }
//         return ans;
//     }
// }


// 1. Collections工具类
// class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         Deque<TreeNode> q = new LinkedList<>();
//         List<List<Integer>> ans = new LinkedList<>();
//         if(root == null){
//             return ans;
//         }
//         q.offer(root);
//         while(!q.isEmpty()){
//             List<Integer> t = new LinkedList<>();
//             for(int i=q.size(); i>0; i--){
//                 TreeNode node = q.poll();
//                 t.add(node.val);
//                 if(node.left != null){
//                     q.offer(node.left);
//                 }
//                 if(node.right != null){
//                     q.offer(node.right);
//                 }
//             }
//             if(ans.size() % 2 == 1){
//                 Collections.reverse(t);
//             }
//             ans.add(t);
//         }
//         return ans;
//     }
// }
