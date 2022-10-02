import java.util.Scanner;

import enums.GameStatus;

public class ConnectFourGame {

	private Player player1;
	private Player player2;
	private Board board;
	private Player currentTurn;
	private GameStatus status;
	private int lastFilledRow;
	private int lastFilledColumn;

	public ConnectFourGame(Board board, Player player1, Player player2) {
		this.board = board;
		this.player1 = player1;
		this.player2 = player2;
		this.lastFilledRow = -1;
		this.lastFilledColumn = -1;
	}

	public boolean move(int chosenColumn) {
		int rowCount = board.getRowCount();

		for (int i = rowCount - 1; i >= 0; i--) {
			if (board.getValue(i, chosenColumn) == '_') {
				board.setValue(i, chosenColumn, currentTurn.getColor().getLabel());
				lastFilledRow = i;
				lastFilledColumn = chosenColumn;
				return true;
			}
		}

		System.out.println(
				String.format("Column %s is full, please choose different column", String.valueOf(chosenColumn + 1)));
		return false;
	}

	public boolean checkIfPlayerWon() {
		String horizontal = board.getHorizontal(lastFilledRow, lastFilledColumn);
		String vertical = board.getVertical(lastFilledRow, lastFilledColumn);
		String diagonal = board.getDiagonal(lastFilledRow, lastFilledColumn);
		String antiDiagonal = board.getAntiDiagonal(lastFilledRow, lastFilledColumn);
		char color = currentTurn.getColor().getLabel();
		String connectFourString = String.format("%c%c%c%c", color, color, color, color);

		return contains(horizontal, connectFourString) || contains(vertical, connectFourString)
				|| contains(diagonal, connectFourString) || contains(antiDiagonal, connectFourString);
	}

	private boolean contains(String str, String match) {
		return str.contains(match);
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public Player getCurrentTurn() {
		return currentTurn;
	}

	public void setCurrentTurn(Player currentTurn) {
		this.currentTurn = currentTurn;
	}

	public GameStatus getStatus() {
		return status;
	}

	public void setStatus(GameStatus status) {
		this.status = status;
	}

	public Board getBoard() {
		return board;
	}

}
