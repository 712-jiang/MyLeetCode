package Graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author 712
 * @function:
 * @create 2021/5/22 16:08
 */
public class numSimilarGroups839 {
    public int numSimilarGroups(String[] strs) {

        int count =0;
        int len = strs[0].length();
        int n = strs.length; //共有n个相互异位的词
        int i=0;
        HashMap<String,Integer> table = new HashMap<>();
        int index=0;
        for(int p=0;p<n;p++){
            String point = strs[p];
            if(!table.containsKey(point)) {
                table.put(point, index);
            }
            index++;

        }
        unionFind uf = new unionFind(n);
        while(i<n){
            for(int j=i+1;j<strs.length;j++){
                int x = table.get(strs[i]);
                int y = table.get(strs[j]);
                if(strs[i].equals(strs[j])) continue;
                if(uf.find(x)==uf.find(y))
                    continue;  //如果已经在一个集合中，不用再遍历
                List<Character> def = new ArrayList<>();
                int k=0;
                while(k<len){
                    if(def.size()>2) break;
                    if(strs[i].charAt(k)!=strs[j].charAt(k)){
                        def.add(strs[i].charAt(k));
                    }
                    k++;
                }
                //正好有两个字符不相等-相似，将两个相似的字符串合并
                if(def.size()==2 || def.size()==0) uf.union(x,y);
            }
            i++;
        }
        int[] parents = uf.getParents();
        int group = 0;
        for(int q=0;q<parents.length;q++){
            if(parents[q]==q) group++;  //找到root即可，只对第i个字符串后面union，所以parents不能统一，只用看root有几个即可
        }
        return group-(n-table.size());  //可虑重复的字符串
    }
    class unionFind{
        int n;
        int[] parents;
        int[] rank;
        public unionFind(int n){
            this.n = n;
            this.parents = new int[n];
            this.rank = new int[n];
            for(int i=0;i<n;i++){
                parents[i]=i;
                rank[i]=1;
            }
        }
        public void union(int index1, int index2){
            int x = find(index1);
            int y = find(index2);
            if(x==y) return;
            else if(rank[x]==rank[y]){
                parents[x]=y;
                rank[y]++;
            }
            else if(rank[x]<rank[y]){
                parents[x]=y;
            }
            else parents[y]=x;
        }
        public int find(int aim){
            if(aim!=parents[aim]){
                parents[aim]=find(parents[aim]);
            }
            return parents[aim];
        }
        public int[] getParents(){
            return parents;
        }
    }

    @Test
    public void test(){
        String[] strs = new String[]{"ajdidocuyh","djdyaohuic","ddjyhuicoa","djdhaoyuic","ddjoiuycha","ddhoiuycja","ajdydocuih","ddjiouycha","ajdydohuic","ddjyouicha"};
        numSimilarGroups839 numSimilarGroups399 = new numSimilarGroups839();
        int res = numSimilarGroups399.numSimilarGroups(strs);
        System.out.println(res);
    }

}
