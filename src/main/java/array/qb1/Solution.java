package array.qb1;

public class Solution {
    //有效的数独
    public boolean isValidSudoku(char[][] board) {
        int[][] nums = new int[10][10];
        int[][] nums2 = new int[10][10];
        int[][] nums3 = new int[9][9];
        for (int i = 0, count1 = board.length; i < count1; i++) {
            for (int j = 0, count2 = board[i].length; j < count2; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                int a = board[i][j] - 48;
                //横行判断
                if (nums[i][a] == 0) {
                    nums[i][a] = a;
                } else {
                    if (nums[i][a] == a) {
                        return false;
                    }
                }
                //竖行判断
                if (nums2[a][j] == 0) {
                    nums2[a][j] = a;
                } else {
                    System.out.println(2);
                    if (nums2[a][j] == a) {
                        return false;
                    }
                }
                //3x3判断

                int offsetx = 0;
                if (a % 3 == 0) {
                    offsetx = 3;
                } else {
                    offsetx = a % 3;
                }

                int offsety = 0;
                if (a % 3 == 0) {
                    offsety = a / 3 - 1;
                } else {
                    offsety = a / 3;
                }

                int y = 0, x = 0;
                y = i / 3;
                x = j / 3;
                if (i % 3 == 0) {
                    if (i == 0) {
                        y = 0;
                    } else {
                        y = i / 3;
                    }
                }
                if (j % 3 == 0) {
                    if (j == 0) {
                        x = 0;
                    } else {
                        x = j / 3;
                    }
                }
                y = y * 3 + offsety;
                x = x * 3 + offsetx - 1;
                if (nums3[y][x] == 0) {
                    nums3[y][x] = a;
                } else {
                    if (nums3[y][x] == a) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] nums = new char[9][9];
        nums[0] = new char[] { '8', '3', '.', '.', '7', '.', '.', '.', '.' };
        nums[1] = new char[] { '6', '.', '.', '1', '9', '5', '.', '.', '.' };
        nums[2] = new char[] { '.', '9', '8', '.', '.', '.', '.', '6', '.' };

        nums[3] = new char[] { '8', '.', '.', '.', '6', '.', '.', '.', '3' };
        nums[4] = new char[] { '4', '.', '.', '8', '.', '3', '.', '.', '1' };
        nums[5] = new char[] { '7', '.', '.', '.', '2', '.', '.', '.', '6' };

        nums[6] = new char[] { '.', '6', '.', '.', '.', '.', '2', '8', '.' };
        nums[7] = new char[] { '.', '.', '.', '4', '1', '9', '.', '.', '5' };
        nums[8] = new char[] { '.', '.', '.', '.', '8', '.', '.', '7', '9' };

        System.out.println(new Solution().isValidSudoku(nums));

    }
}
