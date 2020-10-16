package thc.chapter1;

/**
 * @author thc
 * @Title:
 * @Package thc.chapter1
 * @Description: 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * <p> https://leetcode-cn.com/problems/longest-palindromic-substring/ </p>
 * @date 2020/10/9 2:37 下午
 */
public class P005_longestPalindrome {

    /**
     * 回文检查
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length()==0) {
            return "";
        }
        String ans = "";
        for (int i=0; i<s.length(); i++) {
            for (int j=i+1; j<s.length(); j++) {
                StringBuffer s1 = new StringBuffer(s.substring(i, j+1));
                StringBuffer s2 = new StringBuffer();
                s2 = s1.reverse();
                System.out.println("i:"+i+" j:"+j);
                System.out.println("s1: "+s1);
                System.out.println("s2: "+s2);
                if (s1.equals(s2) && s1.length()>ans.length()) {
                    ans = s1.toString();
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println("test:");
        StringBuffer sb = new StringBuffer("abcd");
        StringBuffer sb2 = sb.reverse();
        System.out.println(sb);
        System.out.println(sb2);
        System.out.println(sb.reverse());
//        System.out.println(sb2);
        P005_longestPalindrome test = new P005_longestPalindrome();
        System.out.println(test.longestPalindrome("abcba"));
        System.out.println(test.longestPalindrome(""));
        System.out.println("babad");
    }
}
