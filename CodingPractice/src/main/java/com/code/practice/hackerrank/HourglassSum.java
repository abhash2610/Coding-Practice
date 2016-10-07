package com.code.practice.hackerrank;
public class HourglassSum {

    public static void main(String[] args) {
    	
    	/**
			1	1	1	0	0	0
			0*	1*	0*	0	0	0
			1	1*	1	0	0	0
			0*	9*	2*	-4	-4	0
			0	0	0	-2	0	0
			0	0	-1	-2	-4	0

			Expected Sum = 13
    	 */
    	
        int arr[][] = new int[][]{{1, 1, 1, 0, 0, 0}, {0, 1, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0}, {0, 9, 2, -4, -4, 0}, {0, 0, 0, -2, 0, 0}, {0, 0, -1, -2, -4, 0}};

        int row_start = 1;
        int row_end = 5;
        int col_end = 5;
        int max_sum = -32767;
        for(; row_start < row_end; row_start++) {
            for(int col_start = 1; col_start < col_end; col_start++) {
                int sum = getHourglassSum(arr, row_start, col_start);
                
                if(max_sum < sum)
                    max_sum = sum;
            }
        }
        
        System.out.print(max_sum);
    }
    
    private static int getHourglassSum(int[][] arr, int row_median, int col_median) {
        
        int sum = 0;
        
        sum += arr[row_median - 1][col_median - 1];
        sum += arr[row_median - 1][col_median];
        sum += arr[row_median - 1][col_median + 1];
        sum += arr[row_median][col_median];
        sum += arr[row_median + 1][col_median - 1];
        sum += arr[row_median + 1][col_median];
        sum += arr[row_median + 1][col_median + 1];
        
        return sum;
    }
}