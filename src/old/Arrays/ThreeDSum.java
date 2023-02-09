package old.Arrays;

import java.util.*;

public class ThreeDSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            Set<Integer> set = new HashSet<>();
            int data = nums[i];
            for (int j = i+1; j <nums.length ; j++) {
                int sum = (data + nums[j])*-1;
                if(set.contains(sum)){
                    List<Integer> values = new ArrayList<>();
                    values.add(data);
                    values.add(sum);
                    values.add(nums[j]);
                    result.add(values);
                }else {
                    set.add(nums[j]);
                }
            }

        }
        return result;
    }
}
