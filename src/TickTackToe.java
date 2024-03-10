import java.util.Scanner;

public class TickTackToe {
    static char symbol;
    static String fpSymbol;
    static String spSymbol;
    static char[][] board = new char[3][3];
    static boolean exit = false;

    public static void symbolChooser() {
        System.out.print("Enter first player symbol: ");
        Scanner sc = new Scanner(System.in);
        String emptyCatcher;
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

    public static void gameStarter() {

        int a = 0;
        System.out.println("  abc");
        for (char[] board : board) {
            System.out.print(a + " ");
            a++;
            System.out.println(board);
        }
    }

    public static void placeChooser() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String firstCharCoordinate;
            String secondCoordinate;
            String emptyCatcher;
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

            int firstInt = convert(firstCharCoordinate);
            int secondInt = Integer.parseInt(secondCoordinate);
            if (Character.isAlphabetic(board[secondInt][firstInt])) {
                System.out.print("The Place has already taken");
                placeChooser();
            }
            board[secondInt][firstInt] = symbol;
            winnerCheck();

            if (exit){
                break;
            }

            symbol = (symbol == spSymbol.charAt(0)) ? fpSymbol.charAt(0) : spSymbol.charAt(0);
            gameStarter();
        }
    }

    public static int convert(String letter) {
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

    public static String winnerCheck() {

        for (int a = 0; a < 3; a++) {
            if (board[a][0] == symbol && board[a][1] == symbol && board[a][2] == symbol) {
                System.out.println("Player " + symbol + " win!");
                exit = true;
            }
        }
        for (int b = 0; b < 3; b++) {
            if (board[0][b] == symbol && board[1][b] == symbol && board[2][b] == symbol) {
                System.out.println("Player " + symbol + " win!");
                exit = true;
            }
        }
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            System.out.println("Player " + symbol + " win!");
            exit = true;
        }
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            System.out.println("Player " + symbol + " win!");
            exit = true;
        }
        return "Player " + symbol + " win!";
    }
}
