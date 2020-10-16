package thc.chapter1;

/**
 * @author thc
 * @Title:
 * @Package
 * @Description:    https://leetcode-cn.com/problems/qiu-12n-lcof/
 * @date 2020/6/29:59 下午
 */
public class Interview64_sumWithoutFor {
    public int sumNums(int n) {
        if(n==1){
            return 1;
        }else{
            return n+sumNums(n-1);
        }
    }

    public static void main(String[] args) {
        Interview64_sumWithoutFor test = new Interview64_sumWithoutFor();

        System.out.println(test.sumNums(3));
    }


}
