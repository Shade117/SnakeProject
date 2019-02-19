import input.InputHandler; 

import java.awt.*; 
import java.awt.event.KeyEvent; 
import java.awt.image.BufferedImage; 
import javax.swing.JFrame; 

public class GameLoop extends JFrame {
    boolean isRunning = true;
    int fps = 30;
    int windowWidth = 500;
    int windowHight = 500;

    BufferedImage backbuffer;
    Insets insets;
    InputHandler input;

    int x = 0;

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
                    
                }
            }
        }
    }

    void init() {
        setTitle("Snake");
        setSize(windowWidth, windowHight);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        insets = getInsets();
        setSize(insets.left + windowWidth + insets.right, insets.top + windowHeight + insets.bottom);
        backbuffer = new BufferedImage(windowWidth, windowHeight, BufferdImage.TYPE_INT_RGB);
        input = new InputHandler(this);
    }

    void update() 
    { 
        if (input.isKeyDown(KeyEvent.VK_RIGHT)) 
            { 
                x += 5; 
            } 
        if (input.isKeyDown(KeyEvent.VK_LEFT)) 
            { 
                x -= 5; 
            } 
    } 

    /** 
     * This method will draw everything 
     */ 
    void draw() 
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
