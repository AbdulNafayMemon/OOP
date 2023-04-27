package LayerBar;

import Toplevelclasses.ToggleButton;

import java.awt.*;
import java.util.ArrayList;

public class Layer extends ToggleButton {

    ArrayList<Shape> shapes;

    public Layer(int x, int y, int width, int height, String title) {
        //super(x, y, width, height, title);
        super(x,y,width,height, new Color(100, 200, 255), new Color(255, 100, 100), title);
        shapes = new ArrayList<>();
    }


    public void paint(Graphics g) {

        g.setColor(currentColor);

        g.fillRect(x, y, width, height);
        g.setColor(Color.black);
        g.drawString(title, x + 8, y + 15);
    }


    public boolean IsClicked(int x, int y) {

        if (x > this.x && x < this.x + width && y > this.y && y < this.y + height) {
            pressed = !pressed;
            if (pressed) {
                currentColor = pressedColor;
            } else {
                currentColor = unpressedColor;
            }
            return true;
        }
        return false;
    }
}
