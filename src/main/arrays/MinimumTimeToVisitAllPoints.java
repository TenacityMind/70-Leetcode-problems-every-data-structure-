package main.arrays;

public class MinimumTimeToVisitAllPoints {
    public static int minTimeToVisitAllPoints(int[][] points) {
        int minTime =0;

        //choose the starting point
        int x1 = points[0][0], y1 = points[0][1];
        // Iterate from the second point to the last point
        for(int i = 1; i < points.length ; i++){
            int x2 = points[i][0], y2 = points[i][1];
            /* Number of diagonal moves = min(dx, dy). Each takes 1 second.
               The remaining distance will be purely horizontal or vertical.
               Remaining distance = max(dx, dy) - min(dx, dy)
               Time = min(dx, dy) + (max(dx, dy) - min(dx, dy)
               Time = max(dx, dy) */
            minTime += Math.max(Math.abs(x2-x1), Math.abs(y2-y1));
            // Update (x1, y1) to the current point
            x1=x2;
            y1=y2;
        }

        return minTime;
    }
    public static void main(String[] args) {
        int[][] points = new int[][]{{1,1},{3,4},{-1,0}};
        System.out.println(minTimeToVisitAllPoints(points));
        int[][] points2 = new int[][]{{3,2},{-2,2}};
        System.out.println(minTimeToVisitAllPoints(points2));
    }
}
