package Mine;

import java.awt.*;

public class ActiveButton extends Button {

    private String keyboardShortcut;

    public ActiveButton(int x, int y, int width, int height, Image i_depressed, Image i_pressed, String shortcut) {
        super(x, y, width, height, i_depressed, i_pressed);
        this.keyboardShortcut = shortcut;
    }

    public String getKeyboardShortcut() {
        return keyboardShortcut;
    }

    public void setKeyboardShortcut(String shortcut) {
        this.keyboardShortcut = shortcut;
    }

    @Override
    public boolean IsClicked(int x, int y) {
        if(super.IsClicked(x, y)) {
            try {
                Thread.sleep(100); // wait for 100 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SetPressed(false);
            current_image = image_depressed;
            return true;
        }
        return false;
    }
}
