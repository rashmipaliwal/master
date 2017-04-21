
public class MazeRunner {
	
	public static void main(String[] args) {
		MazeRunner mazeRunner = new MazeRunner();
		int maze[][] = {{1, 0, 0, 0},
				        {1, 1, 0, 0},
				        {0, 1, 0, 0},
				        {1, 1, 1, 1}};
		
		mazeRunner.resolveMaze(maze);
	}
	
	public static void resolveMaze(int[][] maze) {
		int sol[][] = {{0,0,0,0},
				       {0,0,0,0},
				       {0,0,0,0},
				       {0,0,0,0}};
		if(!resolveMazeUtil(maze, 0, 0, sol)) {
			System.out.println("No solution");
			return;
		}
		
		for (int i = 0; i < sol.length; i++) {
			System.out.println();
			for (int j= 0; j < sol[0].length; j++) {
				System.out.print(sol[i][j] + " ");
			}
		}
		
	}
	
	public static boolean resolveMazeUtil(int[][] maze, int row, int col, int[][] sol) {
		int rowCount = maze.length;
		int colCount = maze[0].length;
		
		// if we are already there
		if (row == rowCount - 1 && col == colCount - 1) {
			sol[row][col] = 1;
			return true;
		}
		
	 if (isSafe(maze, row, col)) {
		 sol[row][col] = 1;
		 
		 if (resolveMazeUtil(maze, row +1, col, sol)) {
			 return true;
		 }
		 
		 if (resolveMazeUtil(maze, row,  col+1, sol)) {
			 return true;
		 }
		 
		 sol[row][col] = 0;
		 return false;
	 }
		
		return false;
		
	}
	
	public static boolean isSafe(int maze[][], int row, int col) {
		int rowCount = maze.length;
		int colCount = maze[0].length;
		if (row >= 0 && col >= 0 && row < rowCount && col < colCount && maze[row][col] ==1) {
			return true;
		} else {
			return false;
		}
	}

}
