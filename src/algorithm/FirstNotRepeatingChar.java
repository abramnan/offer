package algorithm;

/**
 * 在一个字符串(0<=字符串长度<=10000，
 * 全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class FirstNotRepeatingChar {
    /**
     * 暴力循环
     * 39ms
     * 9304k
     * @param str str
     * @return int
     */
    public static int firstNotRepeatingChar(String str){
        if(str==null||str.length()==0){
            return -1;
        }
        char[] every = str.toCharArray();
        int[] judge = new int[every.length];
        int judgement = 0;
        int tempMin = 0;
        for(int i = 0;i<every.length;i++){
            if(judge[i]==0){
                judgement = 0;
                tempMin=i;
                judge[i]=1;
                for(int j = i+1;j<every.length;j++){
                    if(every[i]==every[j]){
                        judge[j]=1;
                        judgement = 1;
                    }

                }
            }
            if(judgement==0){
                return tempMin;
            }
        }
        return tempMin;
    }
    public static void main(String[] args){
        String a = "google";
        System.out.println(firstNotRepeatingChar(a));
    }

    /**
     * 29ms
     * 9224k
     * @param str
     * @return
     */
    public static int firstNotRepeatingChar1(String str){
        for(int i = 0;i<str.length();i++){
            char t = str.charAt(i);
            if(str.indexOf(t)==i&&str.lastIndexOf(t)==i){//indexof(t):第一次出现t的位置，lastindexOf(t):从后往前，第一次出现的位置
                return i;
            }
        }
        return -1;
    }

    /**
     * 27ms
     * 9560k
     * @param str str
     * @return int
     */
    public static int firstNotRepeatingChar2(String str){
        if(str==null || str.length() == 0)return -1;
        int[] count = new int[256];
        for(int i = 0;i<str.length();i++){
            count[str.charAt(i)]++;
        }
        for(int i =0;i<str.length();i++){
            if(count[str.charAt(i)]==1){
                return i;
            }
        }
        return -1;
    }
}
