package main.arrays;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int expectedSum = nums.length * (nums.length + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3,0,1};
        System.out.println(new MissingNumber().missingNumber(arr));
        int[] arr2 = new int[]{0,1};
        System.out.println(new MissingNumber().missingNumber(arr2));
        int[] arr3 = new int[]{9,6,4,2,3,5,7,0,1};
        System.out.println(new MissingNumber().missingNumber(arr3));
    }
}
