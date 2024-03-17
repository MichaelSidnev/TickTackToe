import java.util.Scanner;

public class TickTackToeHumanVersion {
    static char symbol;
    static String fpSymbol;
    static String spSymbol;
    static char[][] board = new char[3][3];
    static boolean exit = false;

    public static void chooseASimbol() {
        System.out.print("Enter first player symbol: ");
        Scanner sc = new Scanner(System.in);
        while (true) {
            fpSymbol = sc.nextLine();
            if (fpSymbol.isEmpty()) {
                System.out.print("Enter something: ");
            } else {
                break;
            }
        }
        fpSymbol = fpSymbol.substring(0, 1);

        System.out.print("Enter second player symbol: ");
        while (true) {
            spSymbol = sc.nextLine();
            if (spSymbol.isEmpty() || spSymbol.substring(0, 1).equals(fpSymbol)) {
                System.out.print("First symbol is wrong or already in use.Try again: ");
            } else {
                break;
            }
        }
        symbol = fpSymbol.charAt(0);
    }

    public static void displayTheBoard() {

        int a = 0;
        System.out.println("  abc");
        for (char[] board : board) {
            System.out.print(a + " ");
            a++;
            System.out.println(board);
        }
    }

    public static void enterAndCheckCoordinates() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String firstCharCoordinate;
            String secondCoordinate;
            System.out.println("Player " + symbol + "! It's your turn!");
            System.out.print("Enter your first game coordinates: ");
            while (true) {
                firstCharCoordinate = scanner.nextLine();
                if (firstCharCoordinate.isEmpty() || (!firstCharCoordinate.equals("a") && !firstCharCoordinate.equals("b") && !firstCharCoordinate.equals("c"))) {
                    System.out.print("Wrong character, please try again: ");
                } else {
                    break;
                }
            }

            System.out.print("Enter your second game coordinates: ");
            while (true) {
                secondCoordinate = scanner.nextLine();
                if (secondCoordinate.isEmpty() || (!secondCoordinate.equals("0") && !secondCoordinate.equals("1") && !secondCoordinate.equals("2"))) {
                    System.out.print("Wrong digit, please try again: ");
                } else {
                    break;
                }
            }


            int firstInt = convertStringToNumber(firstCharCoordinate);
            int secondInt = Integer.parseInt(secondCoordinate);
            if (Character.toString(board[secondInt][firstInt]).equals(fpSymbol) || Character.toString(board[secondInt][firstInt]).equals(spSymbol)) {
                System.out.println("The Place has already taken");
            } else {
                board[secondInt][firstInt] = symbol;

                if (checkWinCombination()) {
                    System.out.println("Player " + symbol + " win!");
                    displayTheBoard();
                    break;
                }

                symbol = (symbol == spSymbol.charAt(0)) ? fpSymbol.charAt(0) : spSymbol.charAt(0);
                displayTheBoard();

            }
        }
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
}
