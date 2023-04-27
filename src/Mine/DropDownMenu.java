package Mine;

import java.util.ArrayList;

public class DropDownMenu {
    private ArrayList<MenuButton> buttons;
    private int x;
    private int y;
    private int width;
    private int height;

    public DropDownMenu(int x, int y, int width, int height) {
        buttons = new ArrayList<MenuButton>();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void AddButton(MenuButton button) {
        buttons.add(button);
    }

    public ArrayList<MenuButton> GetButtons() {
        return buttons;
    }

    public int GetX() {
        return x;
    }

    public int GetY() {
        return y;
    }

    public int GetWidth() {
        return width;
    }

    public int GetHeight() {
        return height;
    }
}