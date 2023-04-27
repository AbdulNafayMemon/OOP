package LayerBar;

import Toplevelclasses.ActiveButton;
import Toplevelclasses.ToggleButton;
import Toplevelclasses.Toolbar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;


public class LayersToolBar extends Toolbar {
    ArrayList<ImageIcon> images = new ArrayList<>();
    ArrayList<Layer> layers = new ArrayList<>();
    Layer activeLayer;
    JPanel panel;
    Method[] methods = LayersToolBar.class.getDeclaredMethods();

    ArrayList<ActiveButton> toolButtons;

    public LayersToolBar(JPanel panel) {
        super(new Point(0, 0), new Dimension(300, (int) Toolkit.getDefaultToolkit().getScreenSize().width), Color.lightGray, "Layers Tool Bar");
        this.panel = panel;
        this.startPosition.x = s_width - this.dimension.width;
        initialize();
    }

    @Override
    public void paint(Graphics g) {

        g.setColor(backgroundColor);
        g.fillRect(startPosition.x, startPosition.y, dimension.width, dimension.height);

        for (ActiveButton toolButton : toolButtons) {
            g.drawImage(toolButton.current_image, toolButton.x, toolButton.y, panel);

        }

        paintLayerPanel(g);


    }

    public void add() {
        if (layers.size() <= 14) {
            if (layers.size() == 0) {
                layers.add(new Layer(startPosition.x + 30, startPosition.y + 340, 80, 20, "Layer 0"));
            } else {
                int x = layers.get(layers.size() - 1).x;
                int y = layers.get(layers.size() - 1).y;

                layers.add(new Layer(x, y + 20 + 10, 80, 20, "Layer " + layers.size()));

            }
        }

    }

    public void remove() {
        if (activeLayer != null) {
            ToggleButton temp = activeLayer;
            layers.remove(activeLayer);
            if (layers.size() == 0) {
                activeLayer = null;
                return;
            }

            if (temp != layers.get(layers.size() - 1)) {
                //int i = layers.indexOf(temp);
                int i = 0;

                for (ToggleButton layer : layers) {
                    layer.title = "Layer "+(i);
                    if (layer.y > temp.y) {
                        layer.y -= (layer.height + 10);
                        //layer.title = "Layer " + (i + 1);
                    }
                    i++;
                }
            }
        }
        activeLayer = null;

    }

    public void up() {
        if (activeLayer != null) {
            int index = layers.indexOf(activeLayer);
            if (index > 0) {
                // Swap the active layer with the layer above it
                int temp = activeLayer.y;
                activeLayer.y = layers.get(index - 1).y;
                layers.get(index - 1).y = temp;
                Collections.swap(layers, index, index - 1);
            }
        }
    }

    public void down() {
        if (activeLayer != null) {
            int index = layers.indexOf(activeLayer);
            if (index < layers.size() - 1) {
                // Swap the active layer with the layer below it
                int temp = activeLayer.y;
                activeLayer.y = layers.get(index + 1).y;
                layers.get(index + 1).y = temp;
                Collections.swap(layers, index, index + 1);
            }
        }
    }


    public void paintLayerPanel(Graphics g) {


        // Draw shadow
        Color shadowColor = new Color(0, 0, 0, 100); // semi-transparent black
        g.setColor(shadowColor);
        Point panel = new Point(startPosition.x + 25, startPosition.y + 305);
        g.fillRect(panel.x, panel.y, 250, 500);

        // Draw panel
        g.setColor(Color.white);
        g.fillRect(startPosition.x + 21, startPosition.y + 300, 250, 500);
        g.setColor(Color.black);
        g.drawRect(startPosition.x + 21, startPosition.y + 300, 250, 500);
        g.drawLine(startPosition.x + 21, startPosition.y + 330, startPosition.x + 21 + 250, startPosition.y + 330);
        g.setFont(new Font("Arial", Font.BOLD, 15));
        g.drawString("Layers", startPosition.x + 30, startPosition.y + 320);
        g.setFont(new Font("Arial", Font.PLAIN, 12));

        for (Layer layer : layers) {

            layer.paint(g);
        }

    }

    public void initialize() {

        for (String shapeName : new String[]{"ArrowUp", "ArrowDown", "Add", "remove"}) {
            String pressedFilename = String.format("..\\JavaPainter\\icons\\%s pressed.png", shapeName);
            String unpressedFilename = String.format("..\\JavaPainter\\icons\\%s unpressed.png", shapeName);
            images.add(new ImageIcon(pressedFilename));
            images.add(new ImageIcon(unpressedFilename));
        }


        toolButtons = new ArrayList<>();
        toolButtons.add(new ActiveButton(startPosition.x + 85, startPosition.y + 150, 50, 50, images.get(1).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH), images.get(0).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH), "up"));
        toolButtons.add(new ActiveButton(startPosition.x + 150, startPosition.y + 150, 50, 50, images.get(3).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH), images.get(2).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH), "down"));
        toolButtons.add(new ActiveButton(startPosition.x + 85, startPosition.y + 220, 50, 50, images.get(5).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH), images.get(4).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH), "add"));
        toolButtons.add(new ActiveButton(startPosition.x + 150, startPosition.y + 220, 50, 50, images.get(7).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH), images.get(6).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH), "remove"));

    }

    @Override
    public void mousePress(MouseEvent e) {
        for (ActiveButton toolButton : toolButtons) {
            if (toolButton.IsClicked(e.getX(), e.getY())) {

                for (Method method : methods) {
                    if (method.getName().equals(toolButton.title)) {
                        try {
                            method.invoke(this);
                        } catch (IllegalAccessException | InvocationTargetException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }

        }

        for (Layer layer : layers) {
            if (layer.IsClicked(e.getX(), e.getY())) {
                if (activeLayer != layer) {
                    // A different layer was clicked, so select it and deselect others
                    activeLayer = layer;
                    for (Layer otherLayer : layers) {
                        if (otherLayer != layer) {
                            otherLayer.pressed = false;
                            otherLayer.currentColor = otherLayer.unpressedColor;
                        }
                    }
                    layer.pressed = true;
                } else {
                    // The same layer was clicked again, so deselect it
                    activeLayer = null;
                    layer.pressed = false;
                }

            }

        }


    }

    @Override
    public void keyPress(KeyEvent e) {

    }


}
