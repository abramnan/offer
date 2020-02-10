package algorithm;

/**
 *给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 */
public class Multiply {
    //B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
    //从左到右算 B[i]=A[0]*A[1]*...*A[i-1]
    //从右到左算B[i]*=A[i+1]*...*A[n-1]
    //19ms
    //9296k
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        int result = 1;
        for(int i =0;i<A.length;i++){
            B[i] = result;
            result = result*A[i];
        }
        result=1;
        for(int i = A.length-1;i>=0;i--){
            B[i]*=result;
            result*=A[i];
        }
        return B;
    }
}
