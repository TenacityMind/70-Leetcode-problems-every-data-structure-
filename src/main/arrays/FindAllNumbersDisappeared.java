package main.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllNumbersDisappeared {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        List<Integer> result = new ArrayList<>();
        for (int i=1; i<=nums.length; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = new int[] {4,3,2,7,8,2,3,1};
        List<Integer> result = findDisappearedNumbers(nums);
        System.out.println(result);
        int[] nums2 = new int[] {1,1};
        List<Integer> result2 = findDisappearedNumbers(nums2);
        System.out.println(result2);


    }
}
