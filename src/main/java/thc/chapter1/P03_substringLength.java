package thc.chapter1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author thc
 * @Title:
 * @Package
 * @Description:
 * @date 2020/5/2510:11 下午
 */
public class P03_substringLength {

    /**
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        // 用set来存储不含重复字符的子串
        Set<Character> occ = new HashSet<>();
        // 定义右指针
        int rk = -1, ans = 0;
        for( int i =0; i<s.length(); i++ ){
            if( i != 0 ){
                occ.remove(s.charAt(i-1));
            }
            while( rk+1<s.length() && !occ.contains(s.charAt(rk+1)) ){
                // 右移rk指针
                occ.add(s.charAt(rk+1));
                rk++;
            }
            //
            ans = Math.max(ans, rk-i+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "bbbbb";
        P03_substringLength test = new P03_substringLength();
        System.out.println(test.lengthOfLongestSubstring(str));
    }
}
