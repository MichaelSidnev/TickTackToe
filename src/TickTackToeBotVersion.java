import java.util.Random;
import java.util.Scanner;

public class TickTackToeBotVersion {
    static char symbol;
    static String fpSymbol;
    static String spSymbol = "0";
    static char[][] board = new char[3][3];
    static boolean exit = false;

    public static void chooseASimbol() {
        System.out.print("Enter your symbol: ");
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

        if (fpSymbol.equals("0") || fpSymbol.equalsIgnoreCase("O")) {
            spSymbol = "X";
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

                botPlays();
                symbol = spSymbol.charAt(0);
                if (checkWinCombination()) {
                    System.out.println("Player " + symbol + " win!");
                    displayTheBoard();
                    break;
                }
                symbol = fpSymbol.charAt(0);

                displayTheBoard();
            }
        }
    }

    public static void botPlays() {
        Random ran = new Random();
        while (true) {
            int firstRandom = ran.nextInt(3);
            int secondRandom = ran.nextInt(3);

            if (!Character.toString(board[firstRandom][secondRandom]).equals(fpSymbol) && !Character.toString(board[firstRandom][secondRandom]).equals(spSymbol)) {
                board[firstRandom][secondRandom] = spSymbol.charAt(0);
                break;
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

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true;
            }
        }
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == symbol && board[1][j] == symbol && board[2][j] == symbol) {
                return true;
            }
        }
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true;
        }
        return board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol;
    }
}

