import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.Random;
import javax.swing.*;

public class rps2 {
    private static final String[] OPTIONS = { "Rock", "Paper", "Scissors" };
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(rps2::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Rock, Paper, & Scissors");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.white);

        JPanel panel = new JPanel();
        JButton rockButton = new JButton("Rock ✊");
        JButton paperButton = new JButton("Paper 🖐");
        JButton scissorsButton = new JButton("Scissors ✌");
        JButton exitButton = new JButton("Exit");

        JLabel userMoveLabel = new JLabel();
        JLabel computerMoveLabel = new JLabel();
        JLabel resultLabel = new JLabel("", JLabel.CENTER);

        panel.add(rockButton);
        panel.add(paperButton);
        panel.add(scissorsButton);
        panel.add(exitButton);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(userMoveLabel, BorderLayout.WEST);
        frame.add(computerMoveLabel, BorderLayout.EAST);
        frame.add(resultLabel, BorderLayout.SOUTH);

        rockButton.addActionListener((ActionEvent e) -> {
            playGame("Rock", userMoveLabel, computerMoveLabel, resultLabel);
        });

        paperButton.addActionListener((ActionEvent e) -> {
            playGame("Paper", userMoveLabel, computerMoveLabel, resultLabel);
        });

        scissorsButton.addActionListener((ActionEvent e) -> {
            playGame("Scissors", userMoveLabel, computerMoveLabel, resultLabel);
        });

        exitButton.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        frame.setVisible(true);
    }

    private static void playGame(String userMove, JLabel userMoveLabel, JLabel computerMoveLabel, JLabel resultLabel) {
        String computerMove = OPTIONS[RANDOM.nextInt(3)];
        String result = determineWinner(userMove, computerMove);

        userMoveLabel.setIcon(loadImage(userMove));
        computerMoveLabel.setIcon(loadImage(computerMove));
        resultLabel.setText(result);
    }

    private static ImageIcon loadImage(String move) {
        String filename = move.toLowerCase() + ".jpg";
        URL imageUrl = rps2.class.getResource("/images/" + filename);
        if (imageUrl != null) {
            return new ImageIcon(imageUrl);
        } else {
            return new ImageIcon();
        }
    }

    private static String determineWinner(String userMove, String computerMove) {
        if (userMove.equals(computerMove)) {
            return "It's a tie!";
        }

        return switch (userMove) {
            case "Rock" -> (computerMove.equals("Scissors")) ? "You win!" : "Computer wins!";
            case "Paper" -> (computerMove.equals("Rock")) ? "You win!" : "Computer wins!";
            case "Scissors" -> (computerMove.equals("Paper")) ? "You win!" : "Computer wins!";
            default -> "Error in determining the winner.";
        };
    }
}
