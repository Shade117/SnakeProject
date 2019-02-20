
import java.awt.*; 
import java.awt.event.KeyEvent; 
import java.awt.image.BufferedImage; 
import javax.swing.JFrame; 

public class GameLoop extends JFrame {
    private boolean isRunning = true;
    private int fps = 30;
    private int windowWidth = 500;
    private int windowHeight = 500;
    private long time = 1;
    private BufferedImage backBuffer;
    private Insets insets;

    private int x = 0;

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
        x++;
        if(x == 500) {
            x = 1;
        }
    }

    private void draw()
    {               
        Graphics g = getGraphics(); 

        Graphics bbg = backBuffer.getGraphics(); 

        bbg.setColor(Color.WHITE); 
        bbg.fillRect(0, 0, windowWidth, windowHeight); 

        bbg.setColor(Color.BLACK); 
        bbg.drawOval(x, 10, 20, 20); 

        g.drawImage(backBuffer, insets.left, insets.top, this); 
    } 
}
