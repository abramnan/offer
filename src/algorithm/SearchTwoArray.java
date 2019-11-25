package algorithm;

/**
 *在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 时间复杂度O(n^2)
 * 空间复杂度O(1)
 *  */
public class SearchTwoArray {
    //我写的方法
    public boolean Findme(int target,int [][]array) {
        for(int i=0;i<array[0].length;i++)
            for(int j=0;j<array[0].length;j++) {
                if(array[i][j]==target)
                    return true;
                else if(array[i][j]>target)
                    break;
            }
        return false;
    }

    //另的方法
    /**
     * /* 思路
     * * 矩阵是有序的，从左下角来看，向上数字递减，向右数字递增，
     * * 因此从左下角开始查找，当要查找数字比左下角数字大时。右移
     * * 要查找数字比左下角数字小时，上移
     * 或者从右下角，相反
     * 时间复杂度O(行高+列宽)
     * 空间复杂度O(1)
     */
    public boolean Find(int target,int[][] array){
        int rows = array.length;//二维数组array.length是行数
        if(rows==0)
            return false;
        int clos = array[0].length;
        if(clos==0)
            return false;
        int row =rows-1;
        int column = 0;//array[0].length是列数
        while(row>=0&&column<clos){//要同时满足
            if(array[row][column]<target)
                column++;
            else if(array[row][column]>target)
                row--;
            else
                return true;
        }
        return false;
    }

}
