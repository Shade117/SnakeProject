
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage; 
import javax.swing.JFrame; 

public class GameLoop extends JFrame {
    private boolean isRunning = true;
    private int fps = 60;
    private int windowWidth = 500;
    private int windowHeight = 500;
    private long time = 1000;
    private BufferedImage backBuffer;
    private Insets insets;
    private AL AL = new AL();
    private Double x = 50.0;
    private Double y = 50.0;

    private Player player = new Player();

    public void Run() {
        init();
        while(isRunning) {
            update();
            draw();
            time = (1000 /fps) - (System.currentTimeMillis() - time);
            if (time > 0) {
                try {
                    Thread.sleep(time);
                }
                catch(Exception e) {
                    System.out.print("IT BROKE");
                }
            }
        }
    }

    private void init() {
        setTitle("Snake");
        setSize(windowWidth, windowHeight);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        insets = getInsets();
        setSize(insets.left + windowWidth + insets.right, insets.top + windowHeight + insets.bottom);
        backBuffer = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_RGB);
    }

    private void update()
    {
        addKeyListener(AL);
    }

    private void draw() {
        Graphics g = getGraphics();
        Graphics bbg = backBuffer.getGraphics();
        bbg.setColor(Color.WHITE);
        bbg.fillRect(0, 0, windowWidth, windowHeight);
        bbg.setColor(Color.BLACK);
        player.draw(g, bbg);
        g.drawImage(backBuffer, insets.left, insets.top, this);
    }


    public class AL extends KeyAdapter {
        private double buff = 0.001;
        String direction = "null";
        @Override
        public void keyPressed(KeyEvent event) {
            int keyCode = event.getKeyCode();
            if (keyCode == event.VK_LEFT)
            {
                player.setDirection("left");
            }
            if (keyCode == event.VK_RIGHT)
            {
                player.setDirection("right");
            }
            if (keyCode == event.VK_UP)
            {
                player.setDirection("up");
            }
            if (keyCode == event.VK_DOWN)
            {
                player.setDirection("down");
            }
        }

        @Override
        public void keyReleased(KeyEvent event) {
        }
    }
}


