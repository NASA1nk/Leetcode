/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 递归
// 必须判断A的每一个节点，是否是B的root，因为可能多个节点都可能是根节点
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null){
            return false;
        }
        return traversal(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }
    // 判断是否包含
    public boolean traversal(TreeNode A,TreeNode B){
        // B为null一定包含
        if(B == null){
            return true;
        }
        if(A == null || A.val != B.val){
            return false;
        }
        return traversal(A.left,B.left) && traversal(A.right,B.right);
    }
}

// class Solution {
//     public boolean isSubStructure(TreeNode A, TreeNode B) {
//         if(A == null || B == null){
//             return false;
//         }
//         Queue<TreeNode> q = new LinkedList<>();
//         q.offer(A);
//         while(!q.isEmpty()){
//             TreeNode t = q.poll();
//             if(isSubStructureiml(t,B)){
//                 return true;
//             }
//             if(t.left != null){
//                 q.offer(t.left);
//             }
//             if(t.right != null){
//                 q.offer(t.right);
//             }
//         }
//         return false;
//     }
//     public boolean isSubStructureiml(TreeNode A,TreeNode B){
//         if(B == null){
//             return true;
//         }
//         if(A == null){
//             return false;
//         }
//         if(A.val != B.val){
//             return false;
//         }
//         return isSubStructureiml(A.left,B.left) && isSubStructureiml(A.right,B.right);
//     }
// }