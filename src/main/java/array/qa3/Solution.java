package array.qa3;

public class Solution {
    //旋转数组
    public void rotate(int[] nums, int k) {
        if (nums.length == 1 || k == 0) {
            return;
        }
        k = k % nums.length;
        System.out.println(k);
        int temp = 0;
        int i = 0;
        int z = 0;
        int startInt = 0;
        boolean start = true;
        boolean jx = true;
        for (; jx;) {
            z = rotate1(nums, k, temp, i, z, start, startInt);
            if (z >= nums.length) {
                jx = false;
            }
            startInt++;
            i = startInt;
        }
    }

    public int rotate1(int[] nums, int k, int temp, int i, int z, boolean start, int startInt) {
        while (start) {
            int j = 0;
            int temp2 = 0;
            int count = nums.length - 1;
            if (i + k > count) {
                j = i + k - count - 1;
            } else {
                j = i + k;
            }
            if (i == startInt) {
                temp = nums[i];
            }
            temp2 = temp;
            temp = nums[j];
            nums[j] = temp2;
            if (j == startInt) {
                start = false;
            }
            i = j;
            z++;
        }
        return z;
    }
}
