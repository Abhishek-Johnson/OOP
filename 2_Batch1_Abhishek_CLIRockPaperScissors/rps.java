import java.util.Random;
import java.util.Scanner;

public class rps {
    private static final String[] OPTIONS = { "Rock", "Paper", "Scissors" };
    private static final Random RANDOM = new Random();
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Rock, Paper, & Scissors!");

        while (true) {
            System.out.println("\nChoose your move:");
            System.out.println("1 for Rock");
            System.out.println("2 for Paper");
            System.out.println("3 for Scissors");
            System.out.println("4 for exiting the game\n");

            int userChoice = SCANNER.nextInt();
            System.out.println("");
            if (userChoice == 4) {
                System.out.println("Exiting the game... Goodbye!");
                break;
            }

            if (userChoice < 1 || userChoice > 4) {
                System.out.println("Invalid choice. Please select a number between 1 and 4.");
                continue;
            }

            String userMove = OPTIONS[userChoice - 1];
            String computerMove = OPTIONS[RANDOM.nextInt(3)];

            System.out.println("You chose: " + userMove);
            System.out.println("Computer chose: " + computerMove);

            String result = determineWinner(userMove, computerMove);
            System.out.println(result);
        }

        SCANNER.close();
    }

    private static String determineWinner(String userMove, String computerMove) {
        if (userMove.equals(computerMove)) {
            return "It's a tie!";
        }

        switch (userMove) {
            case "Rock":
                return (computerMove.equals("Scissors")) ? "You win!" : "Computer wins!";
            case "Paper":
                return (computerMove.equals("Rock")) ? "You win!" : "Computer wins!";
            case "Scissors":
                return (computerMove.equals("Paper")) ? "You win!" : "Computer wins!";
            default:
                return "Error in determining the winner.";
        }
    }
}
