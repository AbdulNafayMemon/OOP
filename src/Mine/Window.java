package Mine;

import java.util.ArrayList;

public class Window {
    private Toolbar toolbar;
    private ArrayList<MenuButton> menuButtons;
    private int x;
    private int y;
    private int width;
    private int height;

    public Window(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        menuButtons = new ArrayList<MenuButton>();
    }

    public void AddMenuButton(MenuButton button) {
        menuButtons.add(button);
    }

    public void SetToolbar(Toolbar toolbar) {
        this.toolbar = toolbar;
    }

    public Toolbar GetToolbar() {
        return toolbar;
    }

    public ArrayList<MenuButton> GetMenuButtons() {
        return menuButtons;
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
