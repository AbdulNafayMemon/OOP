package ColorBar;

import Toplevelclasses.ActiveButton;
import Toplevelclasses.ToggleButton;
import Toplevelclasses.Toolbar;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class ColorToolBar extends Toolbar {

    ArrayList<ToggleButton> colorButtons = new ArrayList<>();
    ArrayList<ToggleButton> colorButtons1 = new ArrayList<>();
    ToggleButton editColors;

    ToggleButton fill;
    ToggleButton stroke;
    int strokeVal = 0;
    ActiveButton strokePlus;
    ActiveButton strokeMinus;
    ArrayList<ToggleButton> fillStroke = new ArrayList<>();
    //current color which the toolbar is using
    Color activeColor = Color.black;

    //Color to show in the edit color panel
    Color tempColor = Color.black;
    //select button to select color from the gradient
    ActiveButton selectButton;

    //color gradient for the edit colors
    Color[][] gradient;

    //Closing button for edit colors
    ActiveButton closeEditColors;

    public ColorToolBar() {
        super(new Point(0, 20), new Dimension((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), 80),
                new Color(150, 150, 150), "Color Tool Bar");
        initialize();

    }

    public void initialize() {

        colorButtons = createRandomColorButtons(120, 35, 2, 10);


        editColors = new ToggleButton(580, 30, 50, 60, "Edit Colors");
        closeEditColors = new ActiveButton(editColors.x + 290, editColors.y + 175, 60, 20, "Close");
        selectButton = new ActiveButton(editColors.x + 125, editColors.y + 450, 60, 20, "Select");

        colorButtons1 = createRandomColorButtons(editColors.x + 280, editColors.y + 255, 5, 2);

        gradient = new Color[200][200];

        fill = new ToggleButton(430, 30, 50, 60, "Fill", activeColor);
        stroke = new ToggleButton(490, 30, 50, 60, "Stroke", activeColor);
        strokePlus = new ActiveButton(stroke.x + stroke.width + 5, stroke.y, 15, 15, "+", Color.black, Color.blue);
        strokeMinus = new ActiveButton(stroke.x + stroke.width + 5, stroke.y + 20, 15, 15, "-", Color.black, Color.blue);


        fillStroke.add(fill);
        fillStroke.add(stroke);

    }

    protected void paintComponent(Graphics g) {


        g.setColor(this.backgroundColor);
        g.fillRect(super.startPosition.x, super.startPosition.y, dimension.width, dimension.height);


        paintColorButtons(colorButtons, g, 110, 30);


        paintFillStroke(g);

        paintEditColors(g);
        if (editColors.pressed) {
            buttonSelected(editColors, g);
            paintGradient(g);

            paintColorButtons(colorButtons1, g, editColors.x + 275, editColors.y + 245);


        }


        if (fill.pressed) {
            buttonSelected(fill, g);
        }
        if (stroke.pressed) {
            buttonSelected(stroke, g);
        }


    }

    public void paintColorButtons(ArrayList<ToggleButton> buttons, Graphics g, int xOffset, int yOffset) {
        g.setColor(Color.white);
        if (buttons == colorButtons1) {
            g.fillRect(xOffset, yOffset, 60, 157);
        } else g.fillRect(xOffset, yOffset, 310, 60);


        for (ToggleButton button : buttons) {
            if (button.pressed) {
                buttonSelected(button, g);
            }

            g.setColor(button.currentColor);
            g.fillRect(button.x, button.y, button.width, button.height);
        }
    }


    public void buttonSelected(ToggleButton button, Graphics g) {

        g.setColor(Color.black);
        g.drawRect(button.x - 2, button.y - 2, button.width + 4, button.height + 4);
    }

    public void paintEditColors(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(editColors.x, editColors.y, editColors.width, editColors.height);
        g.setColor(Color.white);
        g.drawString(editColors.title.substring(0, 4), editColors.x + 14, editColors.y + 17);
        g.drawString(editColors.title.substring(4), editColors.x + 5, editColors.y + 30);
    }

    public void paintGradient(Graphics g) {
        int WIDTH = 200;
        int HEIGHT = 200;

        // 2D array to store color gradient

        Color[] colors = {
                new Color(255, 0, 0), // Red
                new Color(255, 255, 0), // Yellow
                new Color(0, 255, 0), // Green
                new Color(0, 255, 255), // Turquoise
                new Color(0, 0, 255), // Blue
                new Color(255, 0, 255) // Purple
        };

        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                double t = (double) y / HEIGHT; // calculate interpolation factor

                // interpolate RGB values between colors
                int index1 = (int) (t * (colors.length - 1));
                int index2 = index1 + 1;
                double fraction = t * (colors.length - 1) - index1;
                int red = (int) ((1 - fraction) * colors[index1].getRed() + fraction * colors[index2].getRed());
                int green = (int) ((1 - fraction) * colors[index1].getGreen() + fraction * colors[index2].getGreen());
                int blue = (int) ((1 - fraction) * colors[index1].getBlue() + fraction * colors[index2].getBlue());

                gradient[x][y] = new Color(red, green, blue); // create color object and store in gradient array
            }
        }

        int startx = editColors.x + 50;
        int starty = editColors.y + 200;


        g.setColor(Color.gray);
        g.fillRect(startx - 30, starty - 30, 350, 350);


        g.setColor(Color.lightGray);
        g.fillRect(startx - 35, starty - 35, 350, 350);


        for (int x = startx; x < WIDTH + startx; x++) {
            for (int y = starty; y < HEIGHT + starty; y++) {
                g.setColor(gradient[x - startx][y - starty]); // set color of square
                g.fillRect(x, y, 1, 1); // draw small square at current position
            }
        }

        g.setColor(Color.black);
        g.drawRect(startx + 93 - 2, starty + 215 - 2, 25, 25);

        g.setColor(tempColor);
        g.fillRect(startx + 93, starty + 215, 22, 22);

        g.setColor(Color.white);
        g.fillRect(selectButton.x, selectButton.y, selectButton.width, selectButton.height);
        g.setColor(Color.black);
        g.drawString(selectButton.title, selectButton.x + 12, selectButton.y + 14);


        //paint close button
        g.setColor(Color.red);
        g.fillRect(closeEditColors.x, closeEditColors.y, closeEditColors.width, closeEditColors.height);
        g.setColor(Color.white);
        g.drawString(closeEditColors.title, closeEditColors.x + 14, closeEditColors.y + 13);

    }

    public void isGradientClicked(int x, int y) {
        if (x > editColors.x + 50 && x < editColors.x + 50 + 200 && y > editColors.y + 200 && y < editColors.y + 200 + 200)
            tempColor = gradient[x - (editColors.x + 50)][y - (editColors.y + 200)];
    }

    public void paint(Graphics g) {
        paintComponent(g);

    }

    public ArrayList<ToggleButton> createRandomColorButtons(int startX, int startY, int rows, int cols) {
        ArrayList<ToggleButton> buttons = new ArrayList<>();
        Random r = new Random();

        int x = startX;
        int y = startY;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                buttons.add(new ToggleButton(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)),
                        new Point(x, y), new Dimension(20, 20), "Color"));
                x += 30;
            }
            y += 30;
            x = startX;
        }

        return buttons;
    }


    public void paintFillStroke(Graphics g) {

        g.setColor(Color.white);
        g.fillRect(fill.x, fill.y, fill.width, fill.height);
        g.fillRect(stroke.x, stroke.y, stroke.width, stroke.height);

        g.setColor(Color.black);
        g.drawString(fill.title, fill.x + 17, fill.y + 15);
        g.drawString(stroke.title, stroke.x + 7, stroke.y + 15);

        g.drawRect(fill.x + 15, fill.y + 25, 20, 20);

        g.drawRect(stroke.x + 15, stroke.y + 25, 20, 20);

        g.setColor(fill.currentColor);
        g.fillRect(fill.x + 15 + 2, fill.y + 25 + 2, 17, 17);
        g.setColor(stroke.currentColor);
        g.fillRect(stroke.x + 17, stroke.y + 25 + 2, 17, 17);


        //painting stroke plus
        g.setColor(strokePlus.c_current);
        g.fillRect(strokePlus.x, strokePlus.y, strokePlus.width, strokePlus.height);
        g.setColor(Color.white);
        g.drawString(strokePlus.title, strokePlus.x + 4, strokePlus.y + 11);

        //painting stroke minus
        g.setColor(strokeMinus.c_current);
        g.fillRect(strokeMinus.x, strokeMinus.y, strokeMinus.width, strokeMinus.height);
        g.setColor(Color.white);
        g.drawString(strokeMinus.title, strokeMinus.x + 6, strokeMinus.y + 11);
        g.drawString(String.valueOf(strokeVal), stroke.x + 60, stroke.y + 50);
    }


    @Override
    public void mousePress(MouseEvent e) {
        for (ToggleButton colorButton : colorButtons) {


            if (colorButton.IsClicked(e.getX(), e.getY())) {
                if (colorButton.pressed) {
                    activeColor = colorButton.currentColor;
                }

                // Preventing other colours from being selected at the same time
                for (ToggleButton button1 : colorButtons) {
                    if (button1.pressed) {
                        button1.pressed = false;
                        colorButton.pressed = true;

                    }
                }
            }


        }

        // Checking edit Colors dialog box
        editColors.IsClicked(e.getX(), e.getY());

        // Checking whether fill is selected or stroke
        for (ToggleButton fillOrStroke : fillStroke) {

            if (fillOrStroke.IsClicked(e.getX(), e.getY())) {
                if (fillOrStroke.pressed) {
                    for (ToggleButton fillOrStroke1 : fillStroke) {
                        if (fillOrStroke1 != fillOrStroke) {
                            fillOrStroke1.pressed = false;
                        }
                    }
                }
            }


            if (fillOrStroke.pressed) {

                fillOrStroke.currentColor = activeColor;
            }
        }

        // checking if you want to edit colors so u can check whether gradient is
        // clicked or not
        if (editColors.pressed) {
            // If the gradient is clicked it updates the temp color to a color from the
            // gradient
            isGradientClicked(e.getX(), e.getY());

            // Calling so select goes back to being unpressed
            selectButton.IsClicked(e.getX(), e.getY());
            if (selectButton.pressed) {

                for (ToggleButton button : colorButtons) {
                    if (button.pressed) {


                        button.currentColor = tempColor;

                        for (ToggleButton fillStrokeButton : fillStroke) {
                            if (fillStrokeButton.pressed) {

                                fillStrokeButton.currentColor = button.currentColor;
                            }
                        }
                        activeColor = button.currentColor;
                        break;
                    }

                }

            }


            for (ToggleButton colorButton1 : colorButtons1) {


                if (colorButton1.IsClicked(e.getX(), e.getY())) {
                    if (colorButton1.pressed) {
                        activeColor = colorButton1.currentColor;
                    }

                    // Preventing other colours from being selected at the same time
                    for (ToggleButton button1 : colorButtons1) {
                        if (button1 != colorButton1) {
                            button1.pressed = false;

                        }

                    }
                }
            }
        }

        if (strokeVal == 0 || (strokeVal > 0 && strokeVal <= 10)) {
            if (strokePlus.IsClicked(e.getX(), e.getY())) {
                strokeVal++;
                if (strokeVal > 10) {
                    strokeVal = 10;
                }
            } else if (strokeMinus.IsClicked(e.getX(), e.getY())) {
                strokeVal--;
                if (strokeVal < 0) {
                    strokeVal = 0;
                }
            }
        }


        if (closeEditColors.IsClicked(e.getX(), e.getY())) {
            editColors.pressed = false;
        }
    }

    @Override
    public void keyPress(KeyEvent e) {

    }


}
