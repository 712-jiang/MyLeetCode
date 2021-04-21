package String;

import org.junit.jupiter.api.Test;

/**
 * @author 712
 * @function:
 * @create 2021/4/21 22:15
 */
public class compareVersion165 {
    public int compareVersion(String version1, String version2) {
        //用.将版本号分开成StringBuilder[]，每个字符串比较大小
        String[] v1 = version1.split("\\.");   //"\\."需要转义符
        String[] v2 = version2.split("\\.");
        int num1 = v1.length;
        int num2 = v2.length;
        int num = 0;
        while(num<Math.min(num1,num2)){
            if(Integer.valueOf(v1[num])>Integer.valueOf(v2[num])) return 1;
            if (Integer.valueOf(v1[num])<Integer.valueOf(v2[num])) return -1;
            num++;
        }
        //尾部多出来的位数
        int tail = Math.abs(num1-num2);
        if(num1>num2){
            for(int i=0;i<tail;i++){
                if(Integer.valueOf(v1[num2+i])>0) return 1;
            }
        }
        if(num1<num2){
            for(int i=0;i<tail;i++){
                if(Integer.valueOf(v2[num1+i])>0) return -1;
            }
        }
        return 0;
    }
    @Test
    public void test(){
        String version1 = "0.1";
        String version2 = "1.1";
        String test = "djsljfls";
        String[] re = version2.split("\\.");
        compareVersion165 compareVersion165 = new compareVersion165();
        int res = compareVersion165.compareVersion(version1,version2);

        System.out.println(res);
    }
}
