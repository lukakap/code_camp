
// Test cases for CharGrid -- a few basic tests are provided.

import junit.framework.TestCase;

public class CharGridTest extends TestCase {
	
	public void testCharArea1() {
		char[][] grid = new char[][] {
				{'a', 'y', ' '},
				{'x', 'a', 'z'},
			};
		
		
		CharGrid cg = new CharGrid(grid);
				
		assertEquals(4, cg.charArea('a'));
		assertEquals(1, cg.charArea('z'));
	}
	
	
	public void testCharArea2() {
		char[][] grid = new char[][] {
				{'c', 'a', ' '},
				{'b', ' ', 'b'},
				{' ', ' ', 'a'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(6, cg.charArea('a'));
		assertEquals(3, cg.charArea('b'));
		assertEquals(1, cg.charArea('c'));
	}

	//CASE NO +
	public void testCountPlus1() {
		char[][] grid = new char[][] {
				{' ', 'a', ' '},
				{'a', 'a', 'b'},
				{' ', 'a', 'a'}
		};

		CharGrid cg = new CharGrid(grid);

		assertEquals(0,cg.countPlus());
	}


	//CASE WITH NONEQUAL ARMS
	public void testCountPlus3() {
		char[][] grid = new char[][] {
				{'b', 'c', ' ', 'k'},
				{'c', 'c', 'c', ' '},
				{' ', 'c', 'p', ' '},
				{'k', 'c', 'a', 'h'}
		};

		CharGrid cg = new CharGrid(grid);

		assertEquals(0,cg.countPlus());
	}

	//CASE WITH ONE +
	public void testCountPlus4() {
		char[][] grid = new char[][] {
				{'b', 'c', 'k', 'p'},
				{' ', 'k', 'k', 'k'},
				{' ', 'c', 'k', ' '},
				{'k', 'c', 'a', 'h'}
		};

		CharGrid cg = new CharGrid(grid);

		assertEquals(1,cg.countPlus());
	}

	//CASE WITH SEVERAL +
	public void testCountPlus5() {
		char[][] grid = new char[][] {
				{'b', 'd', 'd', 'a', ' '},
				{'d', 'd', 'd', 'a', 'a'},
				{' ', 'd', 'k', 'a', ' '},
				{'a', 'k', 'k', 'k', 'g'},
				{' ', 'c', 'k', 'h', ' '}
		};

		CharGrid cg = new CharGrid(grid);

		assertEquals(2,cg.countPlus());
	}

	//CASE WITH JOINT +
	public void testCountPlus6() {
		char[][] grid = new char[][] {
				{'b', ' ', 'd', 'a', ' '},
				{'a', 'd', 'd', 'd', 'a'},
				{'d', 'd', 'd', 'a', ' '},
				{'k', 'd', ' ', 'k', ' '},
				{' ', 'c', 'k', 'h', ' '}
		};

		CharGrid cg = new CharGrid(grid);

		assertEquals(2,cg.countPlus());
	}





	
	
	
}
