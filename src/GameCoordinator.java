import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import enums.Color;
import enums.GameStatus;

public class GameCoordinator {

	public static void main(String[] args) {
		final int row = 6;
		final int column = 7;
		ConnectFourGame game = initializeGame(row, column);
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			System.out.println("Choose column between 1 to ".concat(String.valueOf(column)));
			System.out.println(game.getBoard().print());
			int playerNumber = 0;

			for (int i = 0; i < row * column; i++) {
				playerNumber %= 2;
				Player currentPlayerTurn = null;
				if (playerNumber == 0) {
					currentPlayerTurn = game.getPlayer1();
				} else {
					currentPlayerTurn = game.getPlayer2();
				}
				game.setCurrentTurn(currentPlayerTurn);
				System.out.println(
						String.format("Player %s turn, please choose column", game.getCurrentTurn().getColor()));
				int chosenColumn = chooseColumnForTurn(br, column);
				if (!game.move(chosenColumn)) {
					i--;
					continue;
				}
				System.out.println(game.getBoard().print());
				if (game.checkIfPlayerWon()) {
					game.setStatus(GameStatus.WIN);
					System.out.println(String.format("Player %s wins", game.getCurrentTurn().getColor()));
					return;
				}
				playerNumber++;
			}
			game.setStatus(GameStatus.DRAW);
			System.out.println("Its a DRAW");
		} catch (IOException e) {
			System.out.println("Something went wrong, restart the game");
		}
	}

	/**
	 * Initializes a new game
	 *
	 * @param row 				number of rows in board
	 * @param column 			number of columns in board
	 * @return ConnectFourGame 	Game object	
	 */

	private static ConnectFourGame initializeGame(int row, int column) {
		Board board = new Board(row, column);
		Player player1 = new Player(Color.RED);
		Player player2 = new Player(Color.GREEN);
		ConnectFourGame game = new ConnectFourGame(board, player1, player2);
		game.setStatus(GameStatus.ACTIVE);
		System.out.println("New Game Connect Four Started!");
		return game;
	}
	
	/**
	 * For player to choose a column
	 *
	 * @param br 			BufferedReader for input
	 * @param maxColumn 	max number of columns in board as per size
	 * @return integer 		chosen column by player
	 */


	private static int chooseColumnForTurn(BufferedReader br, int maxColumn) {
		do {
			try {
				int chosenColumn = Integer.parseInt(br.readLine());
				if (chosenColumn < 1 || chosenColumn > maxColumn) {
					System.out.println("Choose column between 1 to ".concat(String.valueOf(maxColumn)));
					continue;
				}
				return chosenColumn - 1;
			} catch (NumberFormatException e) {
				System.out.println("Chosen column should be valid integer");
			} catch (IOException e) {
				System.out.println("Something went wrong, please choose again");
			}
		} while (true);
	}
}
