package sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author 712
 * @function:  归并 空间复杂度1
 * @create 2021/6/19 10:42
 */
public class mergeSort02 {
    private int l =0;
    private int h;
    private int maxval;

    public void Sort(int[] a){
        maxval = Arrays.stream(a).max().getAsInt()+1;  //求a数组的最大值
        h=a.length-1;
        Sort(a,l,h);
    }

    public void Sort(int[] a, int l, int h){
        if(l<h){
            int m = l+(h-l)/2;
            Sort(a,l,m);
            Sort(a,m+1,h);
            merge(a,l,m,h);
        }
    }

    public void merge(int[] a, int l,int m,int h){
        if(a[m]<=a[m+1]) return;
//        int maxval = Math.max(a[m],a[h])+1;
        int i = l;
        int j = m+1;
        for(int k=0;k<h;k++){
            if(i>m) a[k]= a[k] + a[j++]*maxval;
            else if(j>h) a[k]= a[k] + a[i++]*maxval;
            else if(a[i]%maxval<a[j]%maxval) a[k] = a[k] + a[i++]%maxval*maxval;
            else if(a[i]%maxval>a[j]%maxval) a[k] = a[k] + a[j++]%maxval*maxval;
        }
        for(int k=0;k<h;k++){
            a[k]=a[k]/maxval;
        }
    }

    @Test
    void test(){
        int[] input = new int[]{2,35,6,9,0,11,4,6,7,300};
        mergeSort01 test = new mergeSort01();
        test.Sort(input);
        for (int i : input) {
            System.out.println(i);
        }
    }
}
