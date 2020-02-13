package algorithm;

/**
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），
 * 因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 * 13ms
 * 9288k
 *
 * 这道题跟前一道题一样，也是回溯法，分析题目，
 * 我们需要两个全局变量：标志数组和计数变量；
 * 需要一个函数来计算行坐标和列坐标的数位之和；
 * 终止条件包括三种情况：越界、重复、行坐标和列坐标的数位之和超过k，然后流程和上一道题相同。
 */
public class MovingCount {
    private final int[] dx = {1,-1,0,0};
    private final int[] dy = {0,0,1,-1};

    public int sum(int x){
        int ans = 0;
        while (x>0){
            ans+=x%10;
            x=x/10;
        }
        return ans;
    }

    public int move(int threshold,int rows,int cols,int x,int y,boolean[][] vis){
        vis[x][y] = true;
        int ans = 0;
        for(int i =0;i<4;i++){//四个方向
            int X = x + dx[i];
            int Y = y + dy[i];

            if(X>=0&&Y>=0&&X<rows&&Y<cols&&!vis[X][Y]&&sum(X)+sum(Y)<=threshold){
                ans+=move(threshold,rows,cols,X,Y,vis)+1;//加的是X，Y
            }
        }
        return ans;
    }

    public int movingCount(int threshold, int rows, int cols){
        if(threshold<0||rows<=0||cols<=0){
            return 0;
        }
        boolean[][] vis = new boolean[rows][cols];
        return move(threshold,rows,cols,0,0,vis)+1;//加的是0，0
    }
}
