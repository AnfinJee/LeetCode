package pers.fan.leetcode.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * 2019-07-06
 */
public class TwoSum_J {

    /**
     * 暴力法
     *
     * @param nums   :
     * @param target :
     * @return : int[]
     * @date : 2019/7/6 20:21
     */
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * 两遍哈希表
     *
     * @param nums   :
     * @param target :
     * @return : int[]
     * @date : 2019/7/6 20:04
     */
    public int[] twoSum2(int[] nums, int target) {

        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp) && i != map.get(temp)) {
                result[0] = i;
                result[1] = map.get(temp);
                return result;
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * 一遍哈希表
     *
     * @param nums   :
     * @param target :
     * @return : int[]
     * @date : 2019/7/6 20:04
     */
    public int[] twoSum3(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];

            if (map.containsKey(temp) && i != map.get(temp)) {
                return new int[]{i, map.get(temp)};
            }

            map.put(nums[i], i);

        }

        throw new IllegalArgumentException("No two sum solution");
    }


    public static void main(String[] args) {

        TwoSum_J test = new TwoSum_J();
        System.out.println(test.twoSum2(new int[]{1, 2, 3, 4, 5, 6}, 9));

    }
}
