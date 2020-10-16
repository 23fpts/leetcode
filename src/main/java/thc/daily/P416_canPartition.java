package thc.daily;

/**
 * @author thc
 * @Title:
 * @Package thc.daily
 * @Description:
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>https://leetcode-cn.com/problems/partition-equal-subset-sum/</p>
 * @date 2020/10/11 8:02 下午
 */
public class P416_canPartition {

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len==0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum%2!=0) {
            return false;
        }
        int target = sum/2;
        boolean [] dp = new boolean[target+1];
        dp[0] = true;
        // 可以少遍历一次
        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }
        for (int i=1; i<len; i++) {
            for (int j = target; j>=nums[i]; j--) {
                if (dp[target]){
                    return true;
                }
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        P416_canPartition test = new P416_canPartition();
        int [] nums = new int[] {1, 5, 11, 5};
        System.out.println(test.canPartition(nums));
        int [] nums2 = new int[] {1, 2, 3, 5};
        System.out.println(test.canPartition(nums2));
    }
}
