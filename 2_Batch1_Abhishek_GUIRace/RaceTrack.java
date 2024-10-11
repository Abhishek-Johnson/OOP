import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RaceTrack extends JPanel {
    private static final int NUM_RACERS = 4; 
    private Racer[] racers; 
    private Timer timer; 
    private boolean raceStarted = false;

    public RaceTrack() {
        racers = new Racer[NUM_RACERS];
        Random random = new Random();

        racers[0] = new Racer(50, 100, 0, Racer.COLOR_RED); 
        racers[1] = new Racer(50, 200, random.nextInt(3) + 2, Racer.COLOR_BLUE); 
        racers[2] = new Racer(50, 300, random.nextInt(3) + 2, Racer.COLOR_GREEN); 
        racers[3] = new Racer(50, 400, random.nextInt(3) + 2, Racer.COLOR_YELLOW); 

        timer = new Timer(50, e -> updateRace());
    }

    public void startRace() {
        raceStarted = true;
        timer.start();
    }

    public Racer getUserRacer() {
        return racers[0]; 
    }

    public void updateRace() {
        racers[0].move();

        for (int i = 1; i < racers.length; i++) { 
            racers[i].move(); 
        }

        repaint(); 

        for (Racer racer : racers) {
            if (racer.getX() >= getWidth() - 50) { 
                timer.stop();
                raceStarted = false; 
                JOptionPane.showMessageDialog(this, "Racer " + (racer.getId() + 1) + " wins!");
                break;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawParkBackground(g);

        for (Racer racer : racers) {
            racer.draw(g);
        }
    }

    private void drawParkBackground(Graphics g) {
        g.setColor(new Color(34, 139, 34));
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.GRAY);
        for (int i = 0; i < NUM_RACERS; i++) {
            g.fillRect(0, 100 + (i * 100), getWidth(), 50);
        }

        g.setColor(new Color(0, 100, 0)); 
        for (int i = 0; i < 10; i++) {
            g.fillOval(50 + (i * 150), 50, 40, 40); 
            g.fillOval(50 + (i * 150), getHeight() - 80, 40, 40); 
        }
    }
}
