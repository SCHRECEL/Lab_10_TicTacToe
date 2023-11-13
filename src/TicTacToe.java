import java.util.Scanner;

public class TicTacToe {
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String[][] board = new String[ROWS][COLS];
    private static String player = "X";

    public static void main(String[] args) {
        initializeBoard();
        boolean playing = false;

        Scanner scanner = new Scanner(System.in);

        while (!playing) {
            displayBoard();

            int row = SafeInput.getRangedInt(scanner, "Enter row:", 1, 3) - 1;
            int col = SafeInput.getRangedInt(scanner, "Enter column:", 1, 3) - 1;

            if (isValidMove(row, col)) {
                board[row][col] = player;
                if (isWin()) {
                    displayBoard();
                    System.out.println("Player " + player + " wins!");
                    playing = true;
                } else if (isTie()) {
                    displayBoard();
                    System.out.println("It's a tie!");
                    playing = true;
                } else {
                    player = (player.equals("X")) ? "O" : "X";
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    private static void initializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = " ";
            }
        }
    }
//fix board not working
    private static void displayBoard() {
        System.out.println("-------------");
        for (int i = 0; i < ROWS; i++) {
            System.out.print("| ");
            for (int j = 0; j < COLS; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }
//I
    private static boolean isValidMove(int row, int col) {
        return board[row][col].equals(" ");
    }

    private static boolean isWin() {
        return checkRows() || checkColumns() || checkDiagonals();
    }
//hate
    private static boolean checkRows() {
        for (int i = 0; i < ROWS; i++) {
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                return true;
            }
        }
        return false;
    }
//checking
    private static boolean checkColumns() {
        for (int i = 0; i < COLS; i++) {
            if (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) {
                return true;
            }
        }
        return false;
    }
//things
    private static boolean checkDiagonals() {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }

    private static boolean isTie() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }
}
