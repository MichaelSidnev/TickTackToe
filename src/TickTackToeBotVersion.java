import java.util.Random;
import java.util.Scanner;

public class TickTackToeBotVersion {
    static String fpSymbol;
    static String spSymbol = "0";
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
        BoardAndCheckWin.symbol = fpSymbol.charAt(0);
    }

    public static void enterAndCheckCoordinates() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String firstCharCoordinate;
            String secondCoordinate;
            System.out.println("Player " + BoardAndCheckWin.symbol + "! It's your turn!");
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

            int firstInt = BoardAndCheckWin.convertStringToNumber(firstCharCoordinate);
            int secondInt = Integer.parseInt(secondCoordinate);
            if (Character.toString(BoardAndCheckWin.board[secondInt][firstInt]).equals(fpSymbol) || Character.toString(BoardAndCheckWin.board[secondInt][firstInt]).equals(spSymbol)) {
                System.out.println("The Place has already taken");
            } else {
                BoardAndCheckWin.board[secondInt][firstInt] = BoardAndCheckWin.symbol;

                if (BoardAndCheckWin.checkWinCombination()) {
                    System.out.println("Player " + BoardAndCheckWin.symbol + " win!");
                    BoardAndCheckWin.displayTheBoard();
                    break;
                }

                botPlays();
                BoardAndCheckWin.symbol = spSymbol.charAt(0);
                if (BoardAndCheckWin.checkWinCombination()) {
                    System.out.println("Player " + BoardAndCheckWin.symbol + " win!");
                    BoardAndCheckWin.displayTheBoard();
                    break;
                }
                BoardAndCheckWin.symbol = fpSymbol.charAt(0);

                BoardAndCheckWin.displayTheBoard();
            }
        }
    }

    public static void botPlays() {
        Random ran = new Random();
        while (true) {
            int firstRandom = ran.nextInt(3);
            int secondRandom = ran.nextInt(3);

            if (!Character.toString(BoardAndCheckWin.board[firstRandom][secondRandom]).equals(fpSymbol) && !Character.toString(BoardAndCheckWin.board[firstRandom][secondRandom]).equals(spSymbol)) {
                BoardAndCheckWin.board[firstRandom][secondRandom] = spSymbol.charAt(0);
                break;
            }
        }
    }

}

