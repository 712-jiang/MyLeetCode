package backTrack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qingqing
 * @function:N皇后问题
 * 记住公式！
 * 搞清楚row和col的循环，不一定用for进行遍历，可以用一个值代替
 * 会用各种关于String的API
 *
 * @create 2021-03-31-18:49
 */
public class NQueens {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        backtrack(new ArrayList<>(), 0, n);
        return result;
    }

    //list ：路径
    //row和n决定：选择列表---哪一行，一共多少列
    public void backtrack(List<String> list, int row, int n) {
        // 满足条件，加入到结果列表中，然后返回。
        // 条件：遍历完所有行，得到一个满足要求的排列方式
        if(row == n) {
            result.add(new ArrayList<>(list));
            return;
        }
        //公式：for 选择 in 选择列表
        //对每一个row，选择列表就是所有的列
        for(int col = 0; col < n; col++) {
            // 如果放置在该位置合法，则进行递归
            // 如果不传n，放第一个皇后的时候list中空，无法获得n
            if(isValid(col, list, row, n)) {
                // 生成该行的字符串
                list.add(generateString(col, n));
                backtrack(list, row+1, n);
                //撤回选择，就是撤回list最后一个String
                list.remove(list.size()-1);
            }
        }
    }

    public boolean isValid(int col, List<String> list, int row, int n) {
        // 判断此列有没有重合字符
        for(int i = 0; i < row; i++) {
            //读取第i行的String
            if(list.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        // 判断斜向有没有重合的
        for(int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {
            if(list.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        for(int i = row-1, j = col+1; i >= 0 && j < n; i--, j++) {
            if(list.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }

    public String generateString(int col, int n) {
        //需要对String进行操作，非多线程
        StringBuilder SRow = new StringBuilder();
        for(int i = 0; i < col; i++) {
            SRow.append(".");
        }
        SRow.append("Q");
        for(int i = col+1; i < n; i++) {
            SRow.append(".");
        }
        return SRow.toString();
    }

    @Test
    void test(){
        int a = new ArrayList<>(10).size();
        System.out.println(a);
    }
}
