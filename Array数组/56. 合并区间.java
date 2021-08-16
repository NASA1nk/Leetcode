// 1. 可推导出参数类型时可以省略
// 2. 数组一开始开大了，最后用copyOf取出即可
class Solution {
    public int[][] merge(int[][] intervals) {
        // 按照区间起始位置升序排列
        Arrays.sort(intervals, (t1,t2) -> t1[0] - t2[0]);
        int[][] ans = new int[intervals.length][2];
        int l = 0;
        for(int[] t : intervals){
            if(l == 0){
                ans[l] = t;
                l++;
            }
            else{
                // 重叠修改区间
                if(t[0] <= ans[l-1][1]){
                    ans[l-1][1] = t[1] > ans[l-1][1] ? t[1] : ans[l-1][1];
                }
                // 不重叠直接加入
                else{
                    ans[l] = t;
                    l++;
                }
            }
        }
        return Arrays.copyOf(ans,l);
    }
}

// 1. 区间未排序
// 2. 使用栈时未考虑后一个长度小于前一个长度
// 3. 栈可以丢入自己实现类（k:v）
// 4. 使用map时未考虑key的覆盖
// 5. 增强for循环遍历map
// class Solution {
//     public int[][] merge(int[][] intervals) {
//         Deque<Integer> st = new LinkedList<>();
//         TreeMap<Integer,Integer> m = new TreeMap<>();
//         for(int i=0; i<intervals.length; i++){
//             if(m.get(intervals[i][0]) == null){
//                 m.put(intervals[i][0],intervals[i][1]);
//             }
//             else{
//                 if(m.get(intervals[i][0]) < intervals[i][1]){
//                     m.put(intervals[i][0],intervals[i][1]);
//                 }
//             }
//         }
//         for(int x : m.keySet()){
//             int y = m.get(x);
//             if(st.isEmpty()){
//                 st.push(x);
//                 st.push(y);
//             }
//             else{
//                 int z = st.peek();
//                 if(x <= z){
//                     if(y > z){
//                         st.pop();
//                         st.push(y);
//                     }
//                 }
//                 else{
//                     st.push(x);
//                     st.push(y);
//                 }
//             }
//         }
//         int l = st.size() >> 1;
//         int[][] ans = new int[l][2];
//         int i = l-1;
//         int j = 1;
//         l--;
//         while(!st.isEmpty()){
//             ans[i][j] = st.pop();
//             j--;
//             if(j == -1){
//                 j = 1;
//                 i--;
//             }
//         }
//         return ans;
//     }
// }

// 适用于合并不重叠但连续区间
// TreeSet底层使用红黑树结构存储数据
// TreeMap存储key:value对时，会根据key进行排序
// class Solution {
//     public int[][] merge(int[][] intervals) {
//         int[] tmp = new int[10001];
//         Arrays.fill(tmp,0);
//         int maxx = 0;
//         for(int i=0; i<intervals.length; i++){
//             for(int j=intervals[i][0]; j<=intervals[i][1]; j++){
//                 tmp[j]++;
//                 if(j > maxx){
//                     maxx = j;
//                 }
//             }
//         }
//         Map<Integer,Integer> m = new TreeMap<>();
//         int l = 0;
//         int r = 0;
//         while(r <= maxx){
//             l = r;
//             while(l <= maxx && tmp[l] == 0){
//                 l++;
//             }
//             r = l;
//             while(r <= maxx && tmp[r] != 0){
//                 r++;
//             }
//             m.put(l,r-1);
//         }
//         int [][] ans = new int[m.size()][2];
//         l = 0;
//         for(int x : m.keySet()){
//             ans[l][0] = x;
//             ans[l][1] = m.get(x);
//             l++;
//         }
//         return ans;
//     }
// }
