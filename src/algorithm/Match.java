package algorithm;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * 穷举
 * 21ms
 * 9140k
 *
 */
public class Match {
    public boolean matchStr(char[] str,int i,char[] pattern,int j){
        if(i == str.length&&j==pattern.length){
            return true;
        }else if(j==pattern.length){
            return false;
        }
        boolean flag = false;
        boolean next = (j+1<pattern.length&&pattern[j+1]=='*');
        if (next){
            if(i<str.length&&(pattern[j]=='.'||pattern[j]==str[i])){
                return matchStr(str,i+1,pattern,j)||matchStr(str,i,pattern,j+2);
            }else {
                return matchStr(str,i,pattern,j+2);
            }
        }else {
            if(i<str.length&&(pattern[j]=='.'||str[i]==pattern[j])){
                return matchStr(str,i+1,pattern,j+1);
            }else {
                return false;
            }
        }
    }
    public boolean match(char[] str, char[] pattern){
        return matchStr(str,0,pattern,0);
    }
}
