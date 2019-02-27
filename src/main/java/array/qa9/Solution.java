package array.qa9;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    //两数之和
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, count = nums.length; i < count; i++) {
            int y = target - nums[i];
            if (map.containsKey(y)) {
                return new int[] { map.get(y), i };
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}
