package sort;

import java.util.Arrays;

/**
 * @author 712
 * @function:  大顶堆-排序结果从小到大
 * 每次adjestHeap后，堆顶为最大值
 * @create 2021/5/10 9:43
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4,6,8,5,9};
        System.out.println("排序前："+Arrays.toString(arr));
        Sort(arr);
        System.out.println("排序后："+Arrays.toString(arr));
    }

    static void Sort(int[] arr){
        //第一遍，初始化大顶堆
        for(int i=arr.length/2-1;i>=0;i--){  //从最后一个非叶子节点开始比较
            adjestHeap(arr,i,arr.length);
        }
        //将顶和尾交换，更新剩下的大顶堆
        for(int j=arr.length-1;j>0;j--){
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjestHeap(arr,0,j); //从顶点开始比较
        }
    }

    static void adjestHeap(int[] arr, int i, int len){
        int temp = arr[i];
        for(int k=2*i+1;k<len;k++){   //遍历arr[i]所有叶子节点
            if(k+1<len && arr[k]<arr[k+1]){   //max{左叶子，右叶子}-arr[k]确保为最大叶子节点
                k++;
            }
            if(temp<arr[k]) {   //和temp比较，不要比arr[i]，因为过程中会改变
                arr[i]=arr[k];
                i=k;            //将i更新到最大值的坐标处
            }
            else break;
        }
        arr[i]=temp;  //大叶和root交换
    }
}
