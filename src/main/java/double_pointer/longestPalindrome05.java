package double_pointer;

/**
 * @author 712
 * @function: 5. 最长回文子串
 * bab,baab
 * @create 2021/5/30 11:01
 */
public class longestPalindrome05 {
    public String longestPalindrome(String s) {
        String max="";
        for(int i=0; i<s.length(); i++){
            //判断以i为中心的最长回文子串
            String s1 = Palindrome(s,i,i);
            //判断以i和i+1为中心的最长回文子串
            String s2 = Palindrome(s,i,i+1);
            //拿到奇数和偶数中最长的回文子串
            max=s1.length()>max.length()? s1:max;
            max=s2.length()>max.length()? s2:max;
        }
        return max;
    }
    public String Palindrome(String s, int l, int r){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l+1,r);
    }
}
