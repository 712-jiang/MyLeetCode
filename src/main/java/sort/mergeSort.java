package sort;

import lru.LFUCache_460;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author qingqing
 * @function:
 * @create 2021-03-13-11:04
 */
public class mergeSort {
    private int[] aue;
    private int l = 0;

    private int h;

    public void Sort(int[] a){
        aue = new int[a.length];
        h = a.length-1;
        Sort(a,l,a.length-1);
    }

    public void Sort(int[]a, int l, int h){
        if(l<h) {
            int m = (l + h) / 2;
            Sort(a, l, m);
            Sort(a, m + 1, h);
            merge(a, l, m, h);
        }

    }

    public void merge(int[] a, int l, int m, int h){
        //p1、p2是检测指针，k是存放指针
        int l_head = l;
        int h_head = m+1;
        int k = l;
        aue=new int[a.length];
        //左右都没取完
        while(l_head<=m && h_head<=h){
            if(a[l_head]<=a[h_head]) aue[k++]=a[l_head++];
            else aue[k++]=a[h_head++];
        }
        //右边取完，左边全部赋值
        while(l_head<=m) aue[k++]=a[l_head++];
        //同上
        while(h_head<=h) aue[k++]=a[h_head++];
        //
        for(int i=l;i<=h;i++){
            a[i]=aue[i];
        }
    }


@Test
void test(){
    int[] input = new int[]{2,35,6,9,0,11,4,6,7,300};
    mergeSort test = new mergeSort();
    test.Sort(input);
    for (int i : input) {
        System.out.println(i);
        }
    }
}
