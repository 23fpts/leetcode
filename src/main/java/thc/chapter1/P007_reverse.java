package thc.chapter1;

import javax.swing.text.TabableView;

/**
 * @author thc
 * @Title:
 * @Package thc.chapter1
 * @Description:
 * <p>https://leetcode-cn.com/problems/reverse-integer/</p>
 * @date 2020/10/11 10:01 下午
 */
public class P007_reverse {

    public int reverse(int x) {
        long res = 0 ;
        while (x != 0) {
            res = res*10 + x%10;
            x = x/10;
        }
        return (int)res==res? (int)res:0;
    }

    public static void main(String[] args) {
        P007_reverse test = new P007_reverse();
        System.out.println(test.reverse(123));
    }
}
