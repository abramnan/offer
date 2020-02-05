package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * 思路：字典序方法
 * 161ms
 * 11700k
 */
public class Permutation {
    public ArrayList<String> permutation(String str){
        ArrayList<String> result = new ArrayList<>();
        if(str==null||str.length()==0){
            return result;
        }
        char[] array = str.toCharArray();
        Arrays.sort(array);
        String s = new String(array);
        result.add(s);
        while (true){
            s = nestString(s);
            if(s.equals("finish")){
                break;
            }else {
                result.add(s);
            }
        }
        return result;
    }

    public String nestString(String str){
        char []array = str.toCharArray();
        int i = array.length-2;
        while(i>=0&&array[i]>=array[i+1]){
            i--;
        }
        if(i==-1){
            return "finish";
        }
        int j = array.length-1;
        while(j>=0&&array[j]<=array[i]){
            j--;
        }
        //swap i,j
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        //后面的从小到大
        for(int ii = i+1,jj = array.length-1;ii<jj;ii++,jj--){
            temp = array[ii];
            array[ii] = array[jj];
            array[jj]=temp;
        }
        return new String(array);
    }

    /**
     * 回溯
     * 185ms
     * 12328k
     */

    private ArrayList<String> result = new ArrayList<>();
    private TreeSet<String> paths = new TreeSet<>();//treeSet不能重复
    private StringBuilder path = new StringBuilder();
    private boolean[] visited;

    public ArrayList<String> permutation1(String str){
        if(str==null||str.length()==0){
            return result;
        }
        char[] array = str.toCharArray();
        Arrays.sort(array);
        visited = new boolean[str.length()];
        combination(array,0);
        result.addAll(paths);
        return result;
    }

    public void combination(char[] strs,int len){
        if(len == strs.length){
            paths.add(new String(path.toString()));
            return;
        }
        for(int i =0;i<strs.length;i++){
            if(!visited[i]){
                visited[i] = true;
                path.append(strs[i]);
                combination(strs,len+1);
                visited[i] = false;
                path.deleteCharAt(path.length()-1);
            }
        }
    }


}
