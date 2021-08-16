import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int tmp = 0;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > tmp) {
                tmp = candies[i];
            }
        }
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= tmp) {
                list.add(true);
            } else {
                list.add(false);
            }
        }
        return list;
    }
}