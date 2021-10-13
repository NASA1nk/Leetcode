class Solution {
    String[] num2strs = {"Zero", "One", "Two", "Three", "Four", "Five","Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    String[] num2strm = {"", "", "Twenty", "Thirty", "Forty", "Fifty","Sixty", "Seventy", "Eighty", "Ninety"};
    String[] num2strl = {"Billion ", "Million ", "Thousand ", ""};
    // 三位一组，加单位num2strl[i]
    // 1,234,567,891：1个亿，234个百万，567个千，891
    public String numberToWords(int num) {
        if(num == 0){
            return num2strs[0];
        }
        int l = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=(int)1e9; i>0; i/=1000){
            int t = num/i;
            if(t != 0){
                sb.append(num2str(t)).append(num2strl[l]);
            }
            num = num%i;
            l++;
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
        
    }
    public String num2str(int num){
        String ans = "";
        if(num >= 100){
            ans += num2strs[num/100] + " Hundred ";
            num = num%100;
        }
        if(num >= 20){
            ans += num2strm[num/10] + " ";
            num = num%10;
        }
        if(num != 0){
            ans += num2strs[num] + " ";
        }
        return ans;
    }
}