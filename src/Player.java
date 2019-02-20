import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {
    Double x = 50.0;
    Double y = 50.0;
    String direction = "right";
    double buff = 0.2;


    public void draw(Graphics game, Graphics gamebi) {
        gamebi.setColor(Color.BLACK);
        Move();
        gamebi.drawOval(x.intValue(), y.intValue(), 20, 20);
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    private void Move() {
            if(direction.equals("left")) {
                x = x - buff;
            }
            if(direction.equals("right")) {
                x = x + buff;
            }
            if(direction.equals("up")) {
                y = y - buff ;
            }
            if(direction.equals("down")) {
                y = y + buff;
            }
    }
}
