package Mine;

import java.awt.*;


public class MenuButton extends Button {

    private String keyboardShortcut;

    public MenuButton(int x, int y, int width, int height, Image i_depressed, Image i_pressed, String keyboardShortcut) {
        super(x, y, width, height, i_depressed, i_pressed);
        this.keyboardShortcut = keyboardShortcut;
    }

    public String getKeyboardShortcut() {
        return keyboardShortcut;
    }
}
