package main.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        int top=0, bottom=m-1;
        int left=0, right=n-1;
        List<Integer> result = new ArrayList<Integer>(m*n);

        while(top<=bottom && left<=right){
            //step 1 Top row(left to right)
            for(int i=left;i<=right;i++){
                result.add(matrix[top][i]);
            }
            top++;

            //step 2 Right column(top to bottom)
            for(int i=top;i<=bottom;i++){
                result.add(matrix[i][right]);
            }
            right--;

            //step 3 Bottom row ( right to left)
            if (top <= bottom) {
                for(int i=right;i>=left;i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            //step 4 Left Column(bottom to top)
            if (left <= right) {
                for(int i=bottom;i>=top;i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;

    }
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        // Print the results for Test Case 1
        System.out.println("Test Case 1 Input:");
        System.out.println(Arrays.deepToString(matrix));
        System.out.println("Spiral Order Output: " + spiralOrder(matrix));
        System.out.println("------------------------------------");

        int[][] matrix2 = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        System.out.println("Test Case 2 Input:");
        System.out.println(Arrays.deepToString(matrix2));
        System.out.println("Spiral Order Output: " + spiralOrder(matrix2));
        System.out.println("------------------------------------");

    }
}
