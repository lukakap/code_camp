//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {

	private boolean[][] grid;
	
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid = grid;
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		//find row
		for(int j = 0 ; j < grid[0].length; j++) {              //col = y
			if(checkRow(j)) {
				clearRow(j);
				oneColDown(j+1);
				j--;
			}
		}
	}

	private void oneColDown(int start) {
		for(int j = start; j < grid[0].length; j++) {
			for(int i = 0; i <grid.length; i++){
				grid[i][j-1] = grid[i][j];
			}
		}

		//clear top row
		for(int i = 0; i < grid.length; i++) {
			grid[i][grid[0].length-1] = false;
		}
	}

	private void clearRow(int j) {
		for(int i = 0; i < grid.length; i++) {
			grid[i][j] = false;
		}
	}

	private boolean checkRow(int j) {
		for(int i = 0 ; i < grid.length; i++) {
			if(!grid[i][j]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return this.grid;
	}
}
