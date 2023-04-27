package Shapes;

import java.awt.*;

public class Circle extends Shape {

    private int radius; // radius of circle
    public boolean resizing = false; // flag to indicate if circle is being resized


    public void setRadius(int radius) {
        this.radius = radius;
    }


    public Circle(int x, int y, Color fill, Color stroke) {
        this.x = x;
        this.y = y;
        this.radius = 0; // set initial radius to zero
        this.fill = fill;
        this.stroke = stroke;
    }

    // draw method to draw the circle using Graphics object
    @Override
    public void draw(Graphics g) {
        g.setColor(fill);
        g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }

    // details method to return details of the circle as a string
    @Override
    public String details() {
        // return details as a string with newline separator
        return "Circle\n" + String.valueOf(x) + "\n" + String.valueOf(y) + "\n" + String.valueOf(radius) + "\n" + fill;
    }
}
