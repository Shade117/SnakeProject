import java.awt.*;

class Player {
    private Double x = 50.0;
    private Double y = 50.0;
    private String direction = "right";
    private double speed = 0.2;


    void draw(Graphics game, Graphics gamebi) {
        gamebi.setColor(Color.BLACK);
        Move();
        gamebi.drawOval(x.intValue(), y.intValue(), 20, 20);
    }

    void setDirection(String direction) {
        this.direction = direction;
    }

    private void Move() {
            if(direction.equals("left")) {
                x = x - speed;
            }
            if(direction.equals("right")) {
                x = x + speed;
            }
            if(direction.equals("up")) {
                y = y - speed;
            }
            if(direction.equals("down")) {
                y = y + speed;
            }
    }
}
