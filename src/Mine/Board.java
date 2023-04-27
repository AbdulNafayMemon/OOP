package Mine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.MouseInputListener;

public class Board extends JPanel
        implements ActionListener , MouseInputListener{

    private final int B_WIDTH = 400;
    private final int B_HEIGHT = 400;
    private final int DELAY = 25;

    private Timer timer;
    private int key = 0;
    private boolean keyPressed = false;
    private boolean mousePressed = false;
    
    private boolean start_drawing = false;
    
    private int x_init;
    private int y_init;
    private int x_final;
    private int y_final;
    
    private Button button;
    
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            
            int key = e.getKeyCode();
            keyPressed = false;

            if (key == KeyEvent.VK_SPACE) {
                
            }

        }

        @Override
        public void keyPressed(KeyEvent e) {

        	keyPressed = true;
            key = e.getKeyCode();

            if (key == KeyEvent.VK_SPACE) {
                
            }

        }
    }

    public Board() {

        initBoard();
    }

    private void InitializeAssets() {

        
        ImageIcon button_dep = new ImageIcon("src/square_depressed.png");
        ImageIcon button_pre = new ImageIcon("src/square_pressed.png");
        
        button = new Button(200, 200, 64, 64, button_dep.getImage(), button_pre.getImage());
    }

    private void initBoard() {

    	addMouseListener( this );
    	addMouseMotionListener( this );
    	addKeyListener(new TAdapter());
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setFocusable(true);

        InitializeAssets();
        
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawButton(g);
        
        if(keyPressed)
        {
        	drawNotification("key ", g);
        }
        
        if(mousePressed)
        {
        	drawNotification("mouse ", g);
        }
        
        if(start_drawing == true)
        {
        	g.setColor(Color.RED);
        	g.drawRect(x_init, y_init, x_final, y_final);
        }
    }
    
    private void drawNotification(String text, Graphics g)
    {
    	g.setColor(Color.RED);
    	g.drawString(text + key + " pressed", 20, 20);
    }

    private void drawButton(Graphics g) {

        g.drawImage(button.GetImage(), button.x, button.y, this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        
        Toolkit.getDefaultToolkit().sync();
        repaint();
    }
    
    public void IsClicked(int x, int y)
    {
    	button.IsClicked(x, y);
    }
    

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		IsClicked(e.getX(), e.getY());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		x_init = e.getX();
		y_init = e.getY();
		mousePressed = true;
		start_drawing = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		mousePressed = false;
		//start_drawing = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		x_final = e.getX() - x_init;
		y_final = e.getY() - y_init;
	}
}