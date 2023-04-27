package MainClasses;

import ColorBar.ColorToolBar;
import LayerBar.LayersToolBar;
import ShapeBar.ShapeToolBar;
import Toplevelclasses.Toolbar;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Window extends JPanel implements MouseInputListener, KeyListener {

    public final int s_width = Toolkit.getDefaultToolkit().getScreenSize().width;
    public final int s_height = Toolkit.getDefaultToolkit().getScreenSize().height;


    JPanel panel = this;
    ArrayList<Toolbar> toolbars;

    private Timer timer;

    public Window() {

        initBoard();
    }

    private void InitializeAssets() {
        toolbars = new ArrayList<>();


        toolbars.add(new ColorToolBar());
        toolbars.add(new ShapeToolBar(panel));
        toolbars.add(new LayersToolBar(panel));


    }

    private void initBoard() {

        addMouseListener(this);
        addMouseMotionListener(this);
        addKeyListener(this);

        setBackground(Color.gray);
        setPreferredSize(new Dimension(400, 400));
        setFocusable(true);

        InitializeAssets();

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Toolkit.getDefaultToolkit().sync();
                repaint();
            }
        }, 0, 25);

    }

    void paintPanel(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, s_width, s_height);


        g.setColor(Color.gray);
        g.fillRect(0, 0, s_width, 120);
        g.fillRect(0, 0, 120, s_height);
        g.fillRect(0, s_height-80, s_width, 500);
        g.fillRect(toolbars.get(3).startPosition.x - 20, toolbars.get(3).startPosition.y, 20, s_height);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        paintPanel(g);

        for (int i = 3; i >= 0; i--)
            toolbars.get(i).paint(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        for (Toolbar toolbar : toolbars)
            toolbar.mousePress(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {


    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        for (Toolbar toolbar : toolbars) {
            try {
                toolbar.keyPress(e);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}