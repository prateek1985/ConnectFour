
public class Board {

	private char grid[][];
	private final static String SPACE = " ";
	
	public Board(int row, int column) {
		grid = new char[row][column];
		resetBoard();
	}
	
	public void resetBoard() {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j] = '_';
			}
		}
	}
	
	public String print() {
		StringBuilder displayBoard = new StringBuilder();
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				displayBoard.append(this.grid[i][j]).append(SPACE);
			}
			displayBoard.append(System.lineSeparator());
		}
		return displayBoard.toString();
	}
	
	public int getRowCount() {
		return this.grid.length;
	}

	public char getValue(int i, int j) {
		return this.grid[i][j];
	}

	public void setValue(int i, int j, char label) {
		this.grid[i][j] = label;
	}

	public String getHorizontal(int lastFilledRow, int lastFilledColumn) {
		StringBuilder horizontal = new StringBuilder();
		for(int j=0;j<grid[lastFilledRow].length;j++) {
			horizontal.append(grid[lastFilledRow][j]);
		}
		return horizontal.toString();
	}

	public String getVertical(int lastFilledRow, int lastFilledColumn) {
		StringBuilder vertical = new StringBuilder();
		for(int i=0;i<grid.length;i++) {
			vertical.append(grid[i][lastFilledColumn]);
		}
		return vertical.toString();
	}

	public String getDiagonal(int row, int column) {
		// get to the boundary of grid to begin
		while(row > 0 && column > 0) {
			row--;
			column--;
			
		}
		StringBuilder diagonal = new StringBuilder();
		while(row < grid.length && column < grid[row].length) {
			diagonal.append(grid[row][column]);
			row++;
			column++;
		}
		return diagonal.toString();
	}

	public String getAntiDiagonal(int row, int column) {
		// get to the boundary of grid to begin
		while(row > 0 && column < grid[row].length-1) {
			row--;
			column++;
			
		}
		StringBuilder antiDiagonal = new StringBuilder();
		while(row < grid.length && column >= 0) {
			antiDiagonal.append(grid[row][column]);
			row++;
			column--;
		}
		return antiDiagonal.toString();
	}
}
