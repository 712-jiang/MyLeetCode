package backTrack;

import org.junit.jupiter.api.Test;

import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author qingqing
 * @function:全排列
 * @create 2021-03-30-22:02
 */
public class FullArray {
    List<List<Integer>> res = new LinkedList<>();

    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    List<List<Integer>> permute(int[] nums) {



        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素
    // 结束条件：nums 中的元素全都在 track 中出现
    void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        // 每完成一次全排列就放到res中，并进入“取消操作”，向另一个分支进行排列
        if (track.size() == nums.length) {
//            res.add(track);
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择，有重复
            if (track.contains(nums[i]))
                continue;
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }

    @Test
    public void test(){
        List<List<String>> res = new ArrayList<>();
        ArrayList<String> objects = new ArrayList<>();
        ArrayList<String> test = new ArrayList<>();
        objects.add(".");
        objects.add("2");
        objects.add("3");
        test.add("11");
        test.add("22");
        test.add("33");
        res.add(objects);
        res.add(test);
        System.out.println(res.get(1).get(1));
        String s = "dsdd";
    }
}
