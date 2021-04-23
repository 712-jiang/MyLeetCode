/**
 * @author 712
 * @function:
 * @create 2021/4/22 21:49
 */
public class test {
    public int minDistance(String word1, String word2) {
        int i = word1.length();
        int j = word2.length();
        if(i==-1) return j+1;  //可以理解为word1(0-0)转换成word2(0-j),需要j+1步操作
        if(j==-1) return i+1;
        if(word1.charAt(i) == word2.charAt(j)){  //相等，跳过
            return minDistance(word1.substring(0,i),word2.substring(0,j));
        }
//        if(word1.charAt(i) != word2.charAt(j)){   //不相等，替换，删除，插入
        return Math.max(
                Math.max(
                    minDistance(word1.substring(0,i),word2.substring(0,j))+1,     //替换
                    minDistance(word1.substring(0,i),word2.substring(0,j+1))+1    //删除s1
                ),
        minDistance(word1.substring(0,i+1),word2.substring(0,j))+1     //插入s1
        );
    }
}
