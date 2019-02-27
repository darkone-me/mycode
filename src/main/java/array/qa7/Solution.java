package array.qa7;

public class Solution {
    //加一
    public int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] >= 9) {
            int[] result;
            boolean flag = false;
            if (digits[0] >= 9) {
                flag = true;
                result = new int[digits.length + 1];
            } else {
                flag = false;
                result = new int[digits.length];
            }
            int i2 = 1;
            for (int i = digits.length; i >= 0; i--) {
                if (i == 0) {
                    if (flag) {
                        result[0] = 1;
                    } else {
                        return result;
                    }
                } else {
                    int integer = digits[i - 1] += i2;
                    if (integer >= 10) {
                        if (flag) {
                            result[i] = integer % 10;
                        } else {
                            result[i - 1] = integer % 10;
                        }
                    } else {
                        if (flag) {
                            result[i] = integer;
                        } else {
                            result[i - 1] = integer;
                        }
                    }
                    i2 = integer / 10;
                }
            }
            return result;
        } else {
            digits[digits.length - 1] += 1;
            return digits;
        }
    }
}
