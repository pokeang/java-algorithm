import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Scanner;

public class 2D_array {
	public static void main(String args[]) {
		int[][] map = {{1,1,2}, {3,4,3}, {3,1,2}};
		int result = minimumCost(map);
		System.out.println(result);
	}
    // map is a 2D array
    static int minimumCost(int[][] map){
    	int cols = map[0].length;
    	int rows = map.length;
    	int sumCol = 0;
        for(int i=0; i<cols; i++) {
        	sumCol = 0;
        	for (int j=0; j<rows;j++) {
        		sumCol = sumCol+map[j][i];
        	}
        	System.out.println("Sum of" + (i+1) + "column: " + sumCol);
        }
        return sumCol;
    }
    
    // The following may not need to be modified
    public int solution(int rows, int cols, String input) {
        int[][] costs = new int[rows][cols];
        final Scanner in = new Scanner(new BufferedReader(new StringReader(input)));
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                costs[i][j] = in.nextInt();
            }
        }
        return minimumCost(costs);
    }
}
