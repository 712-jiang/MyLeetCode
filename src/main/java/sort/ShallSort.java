package sort;

import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @author qingqing
 * @function:
 * @create 2021-03-15-13:57
 */
//画图理解！
public class ShallSort {
    public void Sort(int[] a){
        int N = a.length;
        int h=1;
        while(h<N/3) h=h*3+1;  //性质，1，4，13，40...比较次数少
        while (h>=1) {
            for (int i = h; i < N; i++)
                for (int j = i; j >= h && a[j] < a[j - h]; j -= h){
                    int temp = a[j];
                    a[j] = a[j-h];
                    a[j-h] = temp;
                }
            h = h/3;
        }
    }
    @Test
    void test(){
        int[] input = new int[]{2,35,6,9,0,11,4,6,7,300};
        ShallSort test = new ShallSort();
        test.Sort(input);
        for (int i : input) {
            System.out.println(i);
        }
    }
}

