import java.util.Arrays;

public class BoardAndCheckWin {
    static char[][] board = new char[3][3];
    static char symbol;

    public static void displayTheBoard() {

        int a = 0;

        System.out.println("  abc");
        for (char[] b : board) {
            System.out.print(a + " ");
            a++;
            System.out.println(b);
        }
    }

    public static boolean checkWinCombination() {

        for (int a = 0; a < 3; a++) {
            if (board[a][0] == symbol && board[a][1] == symbol && board[a][2] == symbol) {
                return true;
            }
        }
        for (int b = 0; b < 3; b++) {
            if (board[0][b] == symbol && board[1][b] == symbol && board[2][b] == symbol) {
                return true;
            }
        }
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true;
        }
        return board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol;
    }

    public static int convertStringToNumber(String letter) {
        if (letter.equalsIgnoreCase("a")) {
            return 0;
        }
        if (letter.equalsIgnoreCase("b")) {
            return 1;
        }
        if (letter.equalsIgnoreCase("c")) {
            return 2;
        }
        return 0;
    }
}
