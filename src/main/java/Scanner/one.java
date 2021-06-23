package Scanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 712
 * @function:
 * @create 2021/6/10 16:43
 */
public class one {
    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        int n = sin.nextInt();
        List<List<Integer>> path = new ArrayList<>();
        sin.nextLine();  //nextInt()不能跳到下一行，需要人为nextLine()
        String[] line2 = sin.nextLine().split(" ");
        for(String sub1:line2){
            List<Integer> temp = new ArrayList<>();
            String aa = String.valueOf(sub1.charAt(0));
            String bb = String.valueOf(sub1.charAt(2));
            temp.add(Integer.valueOf(aa));
            temp.add(Integer.valueOf(bb));
            path.add(temp);
        }
        int x=sin.nextInt();
        int y =sin.nextInt();
        int k =sin.nextInt();
    }




}
//5
//1,2 1,3 2,5 3,4 4,1 4,5
//1 4
//3