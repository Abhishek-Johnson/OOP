import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RaceGame extends JFrame implements ActionListener {
    private RaceTrack raceTrack;
    private JButton startButton;

    public RaceGame() {
        setTitle("2D Top-Down Race Game - Interactive");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        raceTrack = new RaceTrack();
        add(raceTrack, BorderLayout.CENTER);

        startButton = new JButton("Start Race");
        startButton.addActionListener(this);
        add(startButton, BorderLayout.SOUTH);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    raceTrack.getUserRacer().move();
                }
            }
        });

        setFocusable(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            raceTrack.startRace();
            this.requestFocus();
        }
    }

    public static void main(String[] args) {
        new RaceGame();
    }
}
