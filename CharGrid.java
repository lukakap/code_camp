// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		int topLeftX = grid[0].length - 1;
		int topLeftY = grid.length - 1;
		int bottomRightX = 0;
		int bottomRightY = 0;

		for(int i = 0 ; i < grid.length; i++) {          //row = y
			for(int j = 0; j < grid[0].length; j++) {    //col = x
				if(grid[i][j] == ch) {
					if(i < topLeftY || j < topLeftX) {
						topLeftY = i;
						topLeftX = j;
					}
					if(i > bottomRightY || j > bottomRightX) {
						bottomRightY = i;
						bottomRightX = j;
					}
				}
			}
		}

		int area = (bottomRightX - topLeftX + 1) * (bottomRightY - topLeftY + 1);

		return area;
	}
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
		int pluses = 0;
		for(int i = 0 ; i < grid.length; i++) {          //row = y
			for (int j = 0; j < grid[0].length; j++) {   //col = x
					if (dropFromThisMiddlePoint(j, i)) pluses++;
			}
		}
		return pluses;
	}

	private boolean dropFromThisMiddlePoint(int x, int y) {
		int left = countArm(x, y, -1, 0);
		int right = countArm(x, y, 1, 0);
		int top = countArm(x, y, 0, -1);
		int bottom = countArm(x, y, 0, 1);
		if(left < 2 || right < 2 || top < 2 || bottom < 2) return false;
		if(left != right || top != bottom || left != bottom) return false;
		return true;
	}

	private int countArm(int x, int y, int changeInX, int changeInY) {
		int count = 1;
		while(x + changeInX >= 0 && y + changeInY >= 0 && x + changeInX < grid[0].length && y + changeInY < grid.length){
			if(grid[y][x] == grid[y + changeInY][x + changeInX]) {
				count++;
				y = y + changeInY;
				x = x + changeInX;
			} else {
				break;
			}
		}
		return count;
	}

}
