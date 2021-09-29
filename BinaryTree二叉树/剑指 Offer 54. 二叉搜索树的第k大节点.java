/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 右根左就是从大到小
class Solution {
    int ans = 0;
    int count = 0;
    public int kthLargest(TreeNode root, int k) {
        kthLargestiml(root,k);
        return ans;
    }
    public void kthLargestiml(TreeNode root, int k){
        if(root == null){
            return ;
        }
        kthLargestiml(root.right,k);
        count++;
        if(count == k){
            ans = root.val;
            return ;
        }
        kthLargestiml(root.left,k);
    }
}
// class Solution {
//     public int kthLargest(TreeNode root, int k) {
//         LinkedList<Integer> track = new LinkedList<>();
//         kthLargestiml(root,track);
//         return track.get(track.size()-k);
//     }
//     public void kthLargestiml(TreeNode root,LinkedList<Integer> track){
//         if(root == null){
//             return ;
//         }
//         kthLargestiml(root.left,track);
//         track.add(root.val);
//         kthLargestiml(root.right,track);
//     }
// }