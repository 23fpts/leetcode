package thc.chapter1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author thc
 * @Title:
 * @Package
 * @Description:
 * @date 2020/5/245:22 下午
 */


public class P01_twoSum {


    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i =0; i< nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement)!=i){
                return new int[]{ i, map.get(complement )};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {

        int [] nums = new int[]{2,7,11,15};
        int target = 9;
        P01_twoSum test1 = new P01_twoSum();
        for (int v : test1.twoSum(nums, target)){
            System.out.println(v);
        }
    }

}
