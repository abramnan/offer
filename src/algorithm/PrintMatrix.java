package algorithm;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 * 例如，如果输入如下4 X 4矩阵：
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */

import java.util.ArrayList;

public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix){
        /**
         * 32ms
         * 9332k
         * 简单来说，就是不断地收缩矩阵的边界
         * 定义四个变量代表范围，up、down、left、right
         *
         * 向右走存入整行的值，当存入后，该行再也不会被遍历，代表上边界的 up 加一，同时判断是否和代表下边界的 down 交错
         * 向下走存入整列的值，当存入后，该列再也不会被遍历，代表右边界的 right 减一，同时判断是否和代表左边界的 left 交错
         * 向左走存入整行的值，当存入后，该行再也不会被遍历，代表下边界的 down 减一，同时判断是否和代表上边界的 up 交错
         * 向上走存入整列的值，当存入后，该列再也不会被遍历，代表左边界的 left 加一，同时判断是否和代表右边界的 right 交错
         */
        ArrayList<Integer> list = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return list;
        }
        int up = 0;
        int down = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        while(true){
            //最上一行
            for(int col = left;col<=right;col++){
                list.add(matrix[up][col]);
            }
            up++;
            if(up>down){
                break;
            }
            //最右一行
            for(int row = up;row<=down;row++){
                list.add(matrix[row][right]);
            }
            right--;
            if(left>right){
                break;
            }
            //最下一行
            for(int col = right;col>=left;col--){
                list.add(matrix[down][col]);
            }
            down--;
            if(up>down){
                break;
            }
            //最左边一行
            for(int row = down;row>=up;row--){
                list.add(matrix[row][left]);
            }
            left++;
            if(left>right){
                break;
            }
        }
        return list;
    }

    //右，下，左，上
    private final int[] dx = {0,1,0,-1};
    private final int[]dy = {1,0,-1,0};
    public ArrayList<Integer> printMatrix1(int [][] matrix){
        /**
         * 标记数组
         * 29ms
         * 9308k
         */
        int n = matrix.length,m = matrix[0].length;
        boolean[][] virs = new boolean[n][m];
        ArrayList<Integer> list = new ArrayList<>();
        //dir方向
        int x = 0,y = 0,dir = 0;
        while(x>=0&&x<n&&y>=0&&y<m&&!virs[x][y]){
            list.add(matrix[x][y]);
            virs[x][y]=true;
            //继续往dir方向走
            while (x+dx[dir]>=0&&x+dx[dir]<n&&y+dy[dir]>=0&&y+dy[dir]<m&&!virs[x+dx[dir]][y+dy[dir]]){
                x+=dx[dir];
                y+=dy[dir];
                list.add(matrix[x][y]);
                virs[x][y]=true;
            }
            //走不动换方向
            dir = (dir+1)%4;
            x+=dx[dir];
            y+=dy[dir];
        }
        return list;
    }
}
