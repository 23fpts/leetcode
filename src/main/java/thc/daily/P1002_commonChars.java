package thc.daily;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author thc
 * @Title:
 * @Package thc.daily
 * @Description: <p>https://leetcode-cn.com/problems/find-common-characters/</p>
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @date 2020/10/14 9:06 下午
 */
public class P1002_commonChars {

    // 26大小的数组hash 代表a-z，出现的次数，初始都为0，遍历字符串数组，
    public List<String> commonChars(String[] A) {

        // 用于存储出现的次数 默认值都是0
        int [] hash = new int[26];

        // 先单独用第一个赋值
        for (int i = 0; i<A[0].length(); i++) {
            char s = A[0].charAt(i);
            hash[s-'a'] ++ ;
        }

        for (int i=1; i<A.length; i++) {
            int [] temp = new int[26];
            for (int j = 0; j<A[i].length(); j++) {
                char s = A[i].charAt(j);
                temp[s-'a'] ++ ;
            }
            for (int k=0; k<26; k++) {
                hash[k] = Math.min(hash[k], temp[k]);
            }
        }
        List<String> answer = new ArrayList<>();
        for (int i =0; i<26; i++) {
            for (int num=0; num<hash[i]; num++) {
                answer.add(String.valueOf((char)(i+'a')));
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        P1002_commonChars test = new P1002_commonChars();
        String [] abc = new String[]{"bella", "label", "roller"};
        List<String> ans = test.commonChars(abc);
        ans.forEach(System.out::println);
    }
}
