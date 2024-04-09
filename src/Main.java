import java.util.Scanner;

public class Main {

    // 3x3
    private static final int COL = 3;
    private static final int ROW = 3;

    // Board
    private static String [][] board = new String[ROW][COL];

    private static String currentPlayer = "x"; // X goes first



    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        boolean playAgain = true;

        while (playAgain) {
            clearBoard();
            display();

            while (true) {

                int row = SafeInput.getRangedInt(in, "Enter row [1-3]: ", 1, 3) - 1;
                int col = SafeInput.getRangedInt(in, "Enter column [1-3]: ", 1, 3) - 1;

                if (isValidMove(row, col)) {
                    board[row][col] = currentPlayer;
                    if (winCondition(currentPlayer)) {
                        display();
                        System.out.println("Player " + currentPlayer + " is victorious!");
                        break;
                    } else if (isTie()) {
                        display();
                        System.out.println("It's a tie. Nobody wins or loses.");
                        break;
                    }

                    // Player switch
                    currentPlayer = (currentPlayer.equals("x")) ? "o" : "x";

                } else {

                    System.out.println("Invalid move. Please input a valid move.");

                }
            }
            // Play again?
            playAgain = SafeInput.getYNConfirm(in, "Play Again? [Y/N]: ");
            // Resets player
            currentPlayer = "x";
        }
        in.close(); // Close scanner
    }
        private static void clearBoard() {
            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < COL; j++) {
                    board[i][j] = " ";
                }
            }
        }

        private static void display() {
            System.out.println("  1 2 3");
            for (int i=0;i<ROW;i++) {
                System.out.print((i+1) + " ");
                for (int j=0;j<COL;j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }
    // Checks for empty space for a move
    private static boolean isValidMove(int row, int col) {
        return board[row][col].equals(" ");
    }
    // Checks for a win condition on the board
    // Uses isColWin, isRowWin, isDiagonalWin
    private static boolean winCondition(String player) {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }
    // Checks for a column win (Vertical)
    private static boolean isColWin(String player) {
        for (int i=0;i<COL;i++) {
            if (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) {
                return true;
            }
        }
        return false;
    }
    // Checks for a row win (Horizontal)
    private static boolean isRowWin(String player) {
        for (int i=0;i<ROW;i++) {
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                return true;
            }
        }
        return false;
    }
    // Checks for a diagonal win
    private static boolean isDiagonalWin(String player) {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player) || board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }
    // Checks for a tie scenario
    private static boolean isTie() {
        for (int i=0;i<ROW;i++) {
            for (int j=0;j<COL;j++) {
                if (board[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }
}