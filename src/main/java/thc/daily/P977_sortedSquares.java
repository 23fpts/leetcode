package thc.daily;

/**
 * @author thc
 * @Title:
 * @Package thc.daily
 * @Description: <p>https://leetcode-cn.com/problems/squares-of-a-sorted-array/</p>
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 *
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @date 2020/10/16 3:57 下午
 */
public class P977_sortedSquares {

    public int[] sortedSquares(int[] A) {
        int [] ans = new int[A.length];
        // 先找到负数范围
        int negativeRange = 0;
        for (int i=0; i<A.length; i++) {
            if (A[i]>=0) {
                break;
            } else {
                negativeRange++;
            }
        }
        // 从negativeRange向两边遍历,i 右边正数， j左边负数
        int negative = negativeRange-1;
        int positive = negativeRange;
        // 新数组指针
        int p = 0;
        while (negative>=0 || positive<=A.length-1) {
//            System.out.println("negative: "+ negative);
//            System.out.println("positive: "+ positive);
//            System.out.println("p: "+ p);
            // 如果正数或者负数的一边遍历完了就不用判断了
            if (negative==-1) {
                // 只用遍历正数
                ans[p] = A[positive]*A[positive];
                positive++;
                p++;
                continue;
            } else if (positive==A.length){
                // 只用遍历负数
                ans[p] = A[negative]*A[negative];
                negative--;
                p++;
                continue;
            }
            // 如果正数或者负数的平方大于另一个，就只用一边需要遍历
            int negNum = A[negative];
            int posNum = A[positive];
            if (negNum*negNum > posNum*posNum) {
                // 负数大于正数，移动正数，并存放正数
                ans[p] = posNum*posNum;
                positive ++;
            } else {
                // 负数小于正数，移动负数，
                ans[p] = negNum*negNum;
                negative --;
            }
            p++;
        }
        return ans;
    }

    public static void main(String[] args) {

        int [] tmp = new int[] {-4,-1,0,3,10};
        P977_sortedSquares test = new P977_sortedSquares();
        int [] ans = test.sortedSquares(tmp);
        for (int a: ans) {
            System.out.print(" "+a);
        }
    }
}
