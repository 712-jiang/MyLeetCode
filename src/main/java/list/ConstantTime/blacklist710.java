package list.ConstantTime;
import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * @author qingqing
 * @function:
 * @create 2021-03-26-18:28
 */
public class blacklist710 {
    Random rand = new Random();
    Set<Integer> wlist = new HashSet<>();
    // List<Integer> w = new ArrayList<>();  会超出内存限制，我的妈呀，内存内存
    Map<Integer,Integer> w = new HashMap<>();
    int wlen;

    public blacklist710(int N, int[] blacklist) {
        wlen = N-blacklist.length;
        //后面
        for(int i=wlen; i<N; i++) wlist.add(i);
        for(int b:blacklist) wlist.remove(b);
        //前面
        //使用迭代器,迭代后面可用于交换的白
        Iterator<Integer> wl = wlist.iterator();
        for(int b:blacklist)
            if(b<wlen) w.put(b,wl.next());
    }

    public int pick() {
        int p = rand.nextInt(wlen);
        return w.getOrDefault(p,p);   //节约了内存空间！只有在pick到某个白名单的时候，在赋值，秒
    }

    @Test
    void test(){
        int N = 10;
        int[] blacklist = new int[]{2,3};
        blacklist710 obj = new blacklist710(N, blacklist);
        int param_1 = obj.pick();
        System.out.println(param_1);
    }
}
