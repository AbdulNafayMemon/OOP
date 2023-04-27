package Mine;

import java.awt.*;

public class ToggleButton extends Button {

    private String keyboardShortcut;

    public ToggleButton(int x, int y, int width, int height, Image i_depressed, Image i_pressed, String shortcut) {
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
            SetPressed(!IsPressed());
            if(IsPressed()) {
                current_image = image_pressed;
            } else {
                current_image = image_depressed;
            }
            return true;
        }
        return false;
    }
}
