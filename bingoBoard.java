public class bingoBoard {
	public static void main(String args[]) {
		int[][] map = {{1,2,3}, {4,5,6}, {7,8,9}};
		int[] inputs = {1,3,5,9,12,11,7,4};
		String result = bingo(map, inputs);
		System.out.println(result);
	}

	    public static String bingo(int[][] board, int[] inputs){
	    	int cols = board[0].length;
	    	int rows = board.length;
	    	int sumCol = 0;
	        for(int i=0; i<cols; i++) {
	        	sumCol = 0;
	        	for (int j=0; j<rows;j++) {
	        		sumCol = sumCol+board[j][i];
	        	}
	        	if (i+1 == 2) {
	        		return String.valueOf(sumCol);
		        }
	        }
	        
	        return null;
	    }
	    
	    // The following may not need to be modified
	    public String solution(int n, int[] rawBoard, int[] inputs) {
	        final int[][] board = new int[n][n];
	        for (int i = 0; i < n; ++i) {
	            for (int j = 0; j < n; ++j) {
	                board[i][j]=rawBoard[i * n + j];
	            }
	        }
	        return bingo(board, inputs);
	    }

}
