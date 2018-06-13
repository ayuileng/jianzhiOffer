package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem15_16 {
    //给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end];
                if (sum < -nums[i]) {
                    start++;
                    while (nums[start] == nums[start - 1] && start < end) {
                        start++;
                    }
                } else if (sum > -nums[i]) {
                    end--;
                    while (nums[end] == nums[end + 1] && start < end) {
                        end--;
                    }
                } else {
                    List<Integer> l = Arrays.asList(nums[i], nums[start], nums[end]);
                    list.add(l);
                    start++;
                    end--;
                    while (nums[start] == nums[start - 1] && nums[end] == nums[end + 1] && start < end) {
                        start++;
                        end--;
                    }
                }
            }
        }
        return list;
    }

    public int threeSumClosest(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return -1;
        Arrays.sort(nums);
        int result=0;
        int minAbs = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                int abs = Math.abs(sum-target);
                if(abs<minAbs){
                    minAbs = abs;
                    result = sum;
                }
                if(sum<target){
                    ++start;
                }else{
                    --end;
                }

            }
        }
        return result;

    }


    public static void main(String[] args) {

        int[] arr1 = {1,1,1,0};
        int i = new Problem15_16().threeSumClosest(arr1, -10);
        System.out.println(i);
    }
}

