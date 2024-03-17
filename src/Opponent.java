import java.util.Scanner;

public class Opponent {
    public static void chooseAnOpponent() {
        System.out.print("Do you want to play with a computer? (Type \"Y\" for yes): ");
        Scanner sc = new Scanner(System.in);
        String choseOfOpponent;
        choseOfOpponent = sc.nextLine();
        if (choseOfOpponent.equalsIgnoreCase("Y")) {
            System.out.println("Bot mod enabled.");
            TickTackToeBotVersion.chooseASimbol();
            TickTackToeBotVersion.displayTheBoard();
            TickTackToeBotVersion.enterAndCheckCoordinates();

        } else {
            TickTackToeHumanVersion.chooseASimbol();
            TickTackToeHumanVersion.displayTheBoard();
            TickTackToeHumanVersion.enterAndCheckCoordinates();
        }
    }
}
