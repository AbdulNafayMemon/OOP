package Toplevelclasses;

import java.awt.*;


public abstract class Toolbar implements toolbarFuncs {
    public Point startPosition;
    public Dimension dimension;
    public Color backgroundColor;

    public String title;

    public final int s_width = Toolkit.getDefaultToolkit().getScreenSize().width;
    public final int s_height = Toolkit.getDefaultToolkit().getScreenSize().height;

    public abstract void paint(Graphics g);
    public abstract void initialize();

    public Toolbar(Point startPosition, Dimension dimension, Color backgroundColor, String title) {
        this.startPosition = startPosition;
        this.dimension = dimension;
        this.backgroundColor = backgroundColor;
        this.title = title;
    }

    
}
