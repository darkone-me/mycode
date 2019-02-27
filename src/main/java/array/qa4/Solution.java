package array.qa4;

public class Solution {
    //存在重复
    public boolean containsDuplicate(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        boolean isAll = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
            if (nums[i] < nums[i - 1] || isAll) {
                isAll = true;
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] == nums[i]) {
                        return true;
                    }
                }
            }
        }
        return false;

    }
}
