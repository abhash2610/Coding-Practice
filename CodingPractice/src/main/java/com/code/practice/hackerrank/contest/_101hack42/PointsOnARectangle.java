/**
 * 
 */
package com.code.practice.hackerrank.contest._101hack42;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/101hack42/challenges/points-on-rectangle
 * 
 * @author Abhash Upadhyaya
 *
 *
You are given q queries where each query consists of a set of n points on a two-dimensional 
plane (i.e., (x, y)). For each set of points, print YES on a new line if all the points fall 
on the edges (i.e., sides and/or corners) of a non-degenerate rectangle which is axis 
parallel; otherwise, print NO instead.

Input Format

The first line contains a single positive integer, q, denoting the number of queries. 
The subsequent lines describe each query in the following format:

   1. The first line contains a single positive integer, n, denoting the number of points in the query.
   2. Each line i of the n subsequent lines contains two space-separated integers describing 
      the respective values of xi and yi for the point at coordinate (xi, yi).

Constraints
1<=q<=10
1<=n<=10
-10e4<=x,y<=10e4

Output Format

For each query, print YES on a new line if all n points lie on the edges of some 
non-degenerate rectangle which is axis parallel; otherwise, print NO instead.

Sample Input

2
3
0 0
0 1
1 0
4
0 0
0 2
2 0
1 1

Sample Output

YES
NO

Explanation

We perform the following q=2 queries:

   1. In the first query, all points lie on the edges of a non-degenerate rectangle with 
      corners at (0,0), (0,1), (1,0), and (1,1). Thus, we print YES on a new line.
   2. In the second query, points (0,0), (0,2), (2,0) and could all lie along the 
      edge of some non-degenerate rectangle, but point (1,1) would have to fall inside
      that rectangle. Thus, we print NO on a new line.

 */

public class PointsOnARectangle {

	public static void main(String[] args) {

		try(Scanner scan = new Scanner(System.in)) {
            int q = scan.nextInt();
            
            while(q-- > 0) {
                
                int n = scan.nextInt();
                
                int minX = Integer.MAX_VALUE;
                int maxX = Integer.MIN_VALUE;
                int minY = Integer.MAX_VALUE;
                int maxY = Integer.MIN_VALUE;
                
                int[][] points = new int[n][2];
                while(n-- > 0) {
                    
                    int x = scan.nextInt();
                    int y = scan.nextInt();
                    
                    points[n][0] = x;
                    points[n][1] = y;
                    
                    if(x < minX)
                        minX = x;
                    if(x > maxX)
                        maxX = x;
                    
                    if(y < minY)
                        minY = y;
                    if(y > maxY)
                        maxY = y;
                }
                
                int len = points.length;
                boolean result = true;
                while(len-- > 0) {
                    
                    if((points[len][0] <= maxX && points[len][0] >= minX && (points[len][1] == minY || points[len][1] == maxY)) || 
                       (points[len][0] == maxX || points[len][0] == minX && (points[len][1] >= minY || points[len][1] <= maxY))) {
                        
                    }
                    else {
                        result = false;
                        break;
                    }
                }   
                
                if(result)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
	}
}
