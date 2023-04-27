package Mine;

import java.util.ArrayList;

public class Toolbar {
    private ArrayList<Button> buttons;
    private int x;
    private int y;
    private int width;
    private int height;

    public Toolbar(int x, int y, int width, int height) {
        buttons = new ArrayList<Button>();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void AddButton(Button button) {
        buttons.add(button);
    }

    public ArrayList<Button> GetButtons() {
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
