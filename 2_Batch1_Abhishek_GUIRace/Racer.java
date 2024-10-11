import java.awt.*;

public class Racer {
    private int x;
    private int y;
    private int speed;
    private Color color;
    private int id;
    private static int count = 0;
    //private final int MAX_SPEED = 3;

    public static final Color COLOR_RED = Color.RED;
    public static final Color COLOR_BLUE = Color.BLUE;
    public static final Color COLOR_GREEN = Color.GREEN;
    public static final Color COLOR_YELLOW = Color.YELLOW;

    public Racer(int x, int y, int speed, Color color) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.color = color;
        this.id = count++;
    }

    public void move() {
        x += speed;
        if (speed < 1) {
            speed += 2;
        }
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, 50, 50);
    }

    public int getX() {
        return x;
    }

    public int getId() {
        return id;
    }
}
