import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Maze {

	private Scanner input;
	private int rowSize;
	private int colSize;
	private Square[][] board;
	private Square start;
	private Square exit;

	public Maze() {

	}

	public boolean loadMaze(String fileName) {
		File file = new File(fileName);
		try {
			input = new Scanner(file);
			rowSize = input.nextInt();
			colSize = input.nextInt();
			board = new Square[rowSize][colSize];
			for (int r = 0; r < rowSize; r++) {
				for (int c = 0; c < colSize; c++) {
					Square add = new Square(r, c, input.nextInt());
					if (add.toString().equals("S")) {
						start = add;
					}
					if (add.toString().equals("E")) {
						exit = add;
					}
					board[r][c] = add;
				}
			}
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	public List<Square> getNeighbors(Square s) {
		List<Square> returnList = new ArrayList<Square>();
		int row = s.getRow();
		int col = s.getCol();
		try {
			returnList.add(board[row + 1][col]);
		} catch (IndexOutOfBoundsException e) {
		}
		try {
			returnList.add(board[row - 1][col]);
		} catch (IndexOutOfBoundsException e) {
		}
		try {
			returnList.add(board[row][col + 1]);
		} catch (IndexOutOfBoundsException e) {
		}
		try {
			returnList.add(board[row][col - 1]);
		} catch (IndexOutOfBoundsException e) {
		}
		return returnList;
	}

	public Square getStart() {
		return start;
	}

	public Square getExit() {
		return exit;
	}

	public void reset() {
		for (int r = 0; r < rowSize; r++) {
			for (int c = 0; c < colSize; c++) {
				board[r][c].reset();
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Square[] row : board) {
			for (Square s : row) {
//		    sb.append(Arrays.toString(s1)).append('\n');
				sb.append(s.toString() + " ");
			}
			sb.append("\n");
		}
		String s = sb.toString();
		return s;
	}

	public static void main(String[] args) {
		Maze m = new Maze();
		System.out.println(m.loadMaze("maze-2"));
		System.out.println(m);
		System.out.println(m.getStart());
		System.out.println(m.getExit());
	}
}
