package ShapeBar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Toplevelclasses.*;

public class ShapeToolBar extends Toolbar {
    ArrayList<ToggleButton> shapebuttons = new ArrayList<>(7);
    JPanel panel;
    ArrayList<ImageIcon> images = new ArrayList<>();
    public ToggleButton activeShape;

    public ShapeToolBar(JPanel panel) {

        super(new Point(0, 0), new Dimension(100, (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()),
                Color.lightGray, "Shapes Tool Bar");
        this.panel = panel;
        initialize();
    }

    public void initialize() {

        for (String shapeName : new String[] { "Circle", "EQ triangle", "Hexagon", "pentagram", "RA triangle",
                "Rectangle", "FreeDraw" }) {
            String pressedFilename = String.format("..\\JavaPainter\\icons\\%s pressed.png", shapeName);
            String unpressedFilename = String.format("..\\JavaPainter\\icons\\%s unpressed.png", shapeName);
            images.add(new ImageIcon(pressedFilename));
            images.add(new ImageIcon(unpressedFilename));
        }

        int y = 150;
        for (int i = 0; i < 14; i += 2) {
            ImageIcon icon1 = images.get(i + 1);
            ImageIcon icon2 = images.get(i);
            shapebuttons.add(new ToggleButton(28, y, 50, 50,
                    icon1.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH),
                    icon2.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH),
                    icon2.getDescription().substring(icon2.getDescription().lastIndexOf("\\") + 1)));
            y += 80;
        }


    }

    @Override
    public void paint(Graphics g) {
        g.setColor(backgroundColor);
        g.fillRect(startPosition.x, startPosition.y, dimension.width, dimension.height);

        for (ToggleButton shapeButton : shapebuttons) {

            g.drawImage(shapeButton.current_image, shapeButton.x, shapeButton.y, panel);

        }

    }

    @Override
    public void mousePress(MouseEvent e) {
        for (ToggleButton shapeButton : shapebuttons) {

            if (shapeButton.IsClicked(e.getX(), e.getY())) {
                if (shapeButton.pressed) {
                    activeShape = shapeButton;
                    for (ToggleButton shapeButton1 : shapebuttons) {
                        if (shapeButton1 != shapeButton) {
                            shapeButton1.pressed = false;
                            shapeButton1.current_image = shapeButton1.image_depressed;
                        }
                    }
                }
            }

        }
    }

    @Override
    public void keyPress(KeyEvent e) throws FileNotFoundException {

    }

}
