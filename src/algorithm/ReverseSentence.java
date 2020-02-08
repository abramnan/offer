package algorithm;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class ReverseSentence {
    /**
     * 18ms
     * 9536k
     * 思路：将空格分开，然后倒着放进去
     * @param str
     * @return
     */
    public String reverseSentence(String str) {
        if(str==null||str.length()==0){
            return str;
        }
        String[] strs = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        if(strs.length==0){//用来处理" "这种只有空格的
            return str;
        }
        for(int i =strs.length-1;i>0;i--){
            stringBuilder.append(strs[i]).append(" ");
        }
        stringBuilder.append(strs[0]);
        /**
         * for (i = a.length; i >0;i--){
         *             o.append(a[i-1]);
         *             if(i > 1){
         *                 o.append(" ");
         *             }
         *         }
         *         解决" a"这种问题，没解决" a "这种
         */
        return stringBuilder.toString();
    }

    /**
     * 24ms
     * 9488k
     * 思路：一个空格一个空格找，解决" a "," "这些。
     * @param str
     * @return
     */
    public String reverseSentence1(String str) {
        if(str==null||str.length()==0){
            return str;
        }
        //反转整个句子
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.reverse();
        //存放结果
        StringBuilder result = new StringBuilder();
        int j = 0;
        //标记空格数
        int blackSum = 0;
        for(int i =0;i<stringBuilder.length();i++){
            //1、当有空格，且没有到达最后一个单词时
            if(stringBuilder.charAt(i)==' '&&i!=stringBuilder.length()-1){
                blackSum++;
                StringBuilder str1 = new StringBuilder(stringBuilder.substring(j,i));
                result.append(str1.reverse()).append(" ");
                j=i+1;
            }
            //2、当有空格，且到达最后一个单词时
            if(blackSum!=0&&i==stringBuilder.length()-1){
                StringBuilder str2 = new StringBuilder(stringBuilder.substring(j,i+1));
                result.append(str2.reverse());
            }
        }
        //空格数为0时，直接返回原字符串
        if(blackSum==0){
            return str;
        }
        return result.toString();

    }

}
