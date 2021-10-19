class Solution {
    public int findComplement(int num) {
        int s = 1;
        int ans = 0;
        while(num > 0){
            int t = num & 1;
            t = t==1 ? 0 : 1;
            ans += t*s;
            s <<= 1;
            num >>= 1;
        }
        return ans;
    }
}