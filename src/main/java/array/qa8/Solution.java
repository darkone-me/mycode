package array.qa8;

public class Solution {
    //移动零
    public void moveZeroes(int[] nums) {
        int jl = 0;
        int count = nums.length;
        for (int i : nums) {
            if (i != 0) {
                nums[jl] = i;
                jl++;
            }
        }
        for (int i = jl; i < count; i++) {
            nums[i] = 0;
        }
    }
}
