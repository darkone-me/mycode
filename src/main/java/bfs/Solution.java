package bfs;

/**
 * <p>
 * History: 
 *
 * Date                     Author         Version     Description
 * ---------------------------------------------------------------------------------
 * 2019年2月27日 下午4:04:37          Administrator        2.1         To create
 * </p>
 * 2019年2月27日 下午4:04:37          Administrator        2.1         modify parameters
 *
 * @since 
 * @see     
 */
public class Solution {

    public int numIslands(char[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        ;
        int result = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if ('1' == grid[i][j]) {
                    ++result;
                    convert(h, w, i, j, grid);
                }
            }
        }
        return result;
    }

    public void convert(int h, int w, int i, int j, char[][] grid) {
        if (i >= 0 && i < h && j >= 0 && j < w && grid[i][j] == '1') {
            grid[i][j] = '2';
            convert(h, w, i + 1, j, grid);
            convert(h, w, i - 1, j, grid);
            convert(h, w, i, j + 1, grid);
            convert(h, w, i, j - 1, grid);
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } };
        System.out.println(new Solution().numIslands(grid));
    }
}
