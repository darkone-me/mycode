package array.qa1;

public class Solution {
    //从排序数组中删除重复项
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[start] != nums[i]) {
                nums[++start] = nums[i];
            }
        }
        return start + 1;
    }
}
