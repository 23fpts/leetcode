package thc.common;

/**
 * @author thc
 * @Title:
 * @Package thc.common
 * @Description: 01背包问题
 * <p>https://www.cnblogs.com/kkbill/p/12081172.html</p>
 * @date 2020/10/11 8:36 下午
 */
public class BeiBao01 {

    public int maxValue(int[] weight, int[] value, int W) {
        //这里假定传入的weight和values数组长度总是一致的
        int n = weight.length;
        if (n == 0) return 0;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= W; k++) {
                // 存放 i 号物品（前提是放得下这件物品）
                int valueWith_i = (k-weight[i-1] >= 0) ? (value[i-1]+dp[i-1][k-weight[i-1]]) : 0;
                // 不存放 i 号物品
                int valueWithout_i = dp[i - 1][k];
                dp[i][k] = Math.max(valueWith_i, valueWithout_i);
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        BeiBao01 obj = new BeiBao01();
        int[] w = {1, 4, 3};
        int[] v = {15, 30, 20};
        int W = 4;
        System.out.println(obj.maxValue(w, v, W));
        boolean [] dp = new boolean[5];
        for (boolean b : dp) {
            System.out.println(b);
        }
    }
}
