package Shapes;
import java.awt.*;


public abstract class Shape {
   int x,y;
   Color fill,stroke;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract void draw(Graphics g);

    public abstract String details();
}
