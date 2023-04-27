package Menubar;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import Toplevelclasses.*;
public class Menu extends ToggleButton {

    ArrayList<SubMenu> subMenus;

    public Menu(String title, ArrayList<SubMenu> subMenus, int x, int y) {

        super(x, y, 30, 20, Color.BLACK, Color.blue, title);

        this.subMenus = subMenus;

    }

    public void paintMenu(Graphics g) {
        g.setColor(currentColor);
        g.fillRect(x, y, width, height);
        g.setColor(Color.white);
        g.drawString(title, x + 5, y + 13);

        if (pressed) {
            for (SubMenu item : subMenus) {
                item.paintMenuItem(g, this);
            }

        }
    }

    @Override
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
