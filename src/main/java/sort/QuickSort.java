package sort;

import org.junit.jupiter.api.Test;

/**
 * @author qingqing
 * @function:
 * @create 2021-03-15-16:39
 */
public class QuickSort {
    private int[] input;
    private int left=0;
    private int right;
    public void sort(int[] a){
        input = new int[a.length];
        right = a.length-1;
        subsort(a, left, right);
    }
    public void subsort(int[] a, int left, int right){
        if(left>=right) return;
        //先分割
        int j = partition(a, left, right);
        //再递归
        subsort(a, left, j-1);
        subsort(a, j+1, right);
    }

    public int partition(int[] a, int left, int right){
        //设定i、j为左右指针，从两边往中间走
        int i=left;
        int j=right;
        //选a[left]为baseline
        //i j相遇了，结束
        while(true) {
            //当左边小于baseline，i++，继续向前
            //这里=是必须的，不然i=left+1
            while (a[i] <= a[left]) {
                if (i == right) break;
                i++;
            }
            //当右边大于baseline，j--，继续向后
            while (a[j] >= a[left]) {
                if (j == left) break;
                j--;
            }
            //只有等i=j了才能跳出去,所以i和j必须相遇!!![秒啊]
            if (i>=j) break;
            //while的循环结束，找到一对放错位置的i和j
            //交换
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        int cur = a[j];
        a[j] = a[left];
        a[left] = cur;
        return j;
    }

    @Test
    void test(){
        int[] input = new int[]{2,35,6,9,0,11,4,6,7,300};
        QuickSort test = new QuickSort();
        test.sort(input);
        for (int i : input) {
            System.out.println(i);
        }
    }
}
