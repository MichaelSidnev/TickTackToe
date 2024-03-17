import java.util.Scanner;

public class TickTackToeHumanVersion {
    static String fpSymbol;
    static String spSymbol;
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

                BoardAndCheckWin.symbol = (BoardAndCheckWin.symbol == spSymbol.charAt(0)) ? fpSymbol.charAt(0) : spSymbol.charAt(0);
                BoardAndCheckWin.displayTheBoard();

            }
        }
    }

}
