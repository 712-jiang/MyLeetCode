package lru;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @author qingqing
 * @function:
 * @create 2021-03-10-22:47
 */
public class LFUCache_460 {

    //key-val
    HashMap<Integer,Integer> kv;
    //key-freq
    HashMap<Integer,Integer> kf;
    //freq-key
    //查，增，删，freq\key可以一对多：Map，key可以有多个list，有时序Linkedhashset
    HashMap<Integer, LinkedHashSet<Integer>> ftok;
    //保存最小freq
    int minFreq;
    int cap;

    //构造函数初始化
    public LFUCache_460() {
        this.cap = 2;
        kv = new HashMap<>();
        kf = new HashMap<>();
        ftok = new HashMap<>();
        this.minFreq = Integer.MAX_VALUE;
    }

    //修改kf和ftok
    public void increaseFreq(int key){
        int freq = kf.get(key);
        //修改kf
        //freq++
        kf.put(key, freq+1);

        //修改ftok
        //删除freq中的key
        ftok.get(freq).remove(key);
        //如果当前freq已经空了，删除
        if(ftok.get(freq).isEmpty()){
            ftok.remove(freq);
            if(this.minFreq == freq) this.minFreq++;
        }
        //将key放到freq+1中
        //不确定有没有freq的存在，直接用.put()可能将LinkedHashSet中的其他key覆盖掉
        ftok.putIfAbsent(freq+1, new LinkedHashSet<>());
        ftok.get(freq+1).add(key);
    }

    //溢出，删除LFU对象
    public void removeMinFreqKey(){
        //查minFreq对应的key
        LinkedHashSet<Integer> leastKey = ftok.get(this.minFreq);
        //最小的freq不只一个key，找双链表头
        if(leastKey.size()>1){
            //找到最早访问的
            Integer oldestKey = leastKey.iterator().next();
            kv.remove(oldestKey);
            kf.remove(oldestKey);
            leastKey.remove(oldestKey);
            minFreq++;
            // if(leastKey.isEmpty()) ftok.remove(this.minFreq);
            return;
        }
        else{
            kv.remove(leastKey.iterator().next());  //这里remove没有作用，因为leastKey是LinkedHashSet<Integer>类型
                                                    //而kv中的值是Integer类型，kv中找不到leastKey就返回null，啥也没干!!
            kf.remove(leastKey.iterator().next());
            ftok.remove(this.minFreq);
        }
    }

    public int get(int key) {
        if(!kv.containsKey(key)) return -1;
        //修改kf,fk
        increaseFreq(key);
        return kv.get(key);
    }

    public Object put(int key, int value) {
        if (this.cap <= 0) return null;
        /* 若 key 已存在，修改对应的 val 即可 */
        if(kv.containsKey(key)){
            kv.put(key,value);
            //修改kf,ftok
            increaseFreq(key);
            return null;
        }
        /* key 不存在，需要插入 */
        /* 容量已满的话需要淘汰一个 freq 最小的 key */
        if(kv.size()>=this.cap){
            removeMinFreqKey();
        }
        //插入k，v，对应freq=1
        //插入kv hashmap
        kv.put(key,value);
        //插入kf hashmap
        kf.put(key,1);
        //插入ftok hashmap
        //不存在freq=1就创建,空的
        LinkedHashSet<Integer> newnode = new LinkedHashSet<>();
        ftok.putIfAbsent(1,newnode);
        ftok.get(1).add(key);
        this.minFreq = 1;
        return null;
    }
/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

@Test
void test(){
    LFUCache_460 obj = new LFUCache_460();
    ArrayList<Object> res = new ArrayList<>();
    res.add(obj.put(1,1));
    res.add(obj.put(2,2));
    res.add(obj.get(1));
    res.add(obj.put(3,3));
    res.add(obj.get(2));
    res.add(obj.get(3));
    res.add(obj.put(4,4));
    res.add(obj.get(1));
    res.add(obj.get(3));
    res.add(obj.get(4));
    System.out.println(res);
    }
}

