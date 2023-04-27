package Mine;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ColorsToolbar {
    private Color[] colors;
    private int selectedColorIndex;
    private int x, y, width, height;
    private BufferedImage gradient;
    private int gradientWidth = 80;
    private int gradientHeight = 16;

    public ColorsToolbar(int x, int y, int width, int height) {
        // Initialize the array of colors
        colors = new Color[]{
                Color.BLACK,
                Color.WHITE,
                Color.RED,
                Color.GREEN,
                Color.BLUE,
                Color.YELLOW,
                Color.ORANGE,
                Color.PINK
        };

        // Default selected color is black
        selectedColorIndex = 0;

        // Initialize the position and size of the toolbar
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        // Initialize the color gradient
        gradient = new BufferedImage(gradientWidth, gradientHeight, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < gradientWidth; i++) {
            for (int j = 0; j < gradientHeight; j++) {
                // Calculate the percentage of completion
                double percentage = (double) i / (double) gradientWidth;

                // Get the color at the current percentage
                Color color = Color.getColor("percentage");

                // Set the pixel color
                gradient.setRGB(i, j, color.getRGB());
            }
        }
    }

    public void draw(Graphics g) {
        // Draw the colors in the toolbar
        for (int i = 0; i < colors.length; i++) {
            g.setColor(colors[i]);
            g.fillRect(x + i * (height + 5), y, height, height);
            if (i == 0) {
                g.setColor(Color.WHITE);
                g.drawRect(x + i * (height + 5), y, height, height);
                g.drawString("Stroke", x + i * (height + 5) + 2, y + height + 10);
            } else if (i == 1) {
                g.setColor(Color.WHITE);
                g.drawRect(x + i * (height + 5), y, height, height);
                g.drawString("Fill", x + i * (height + 5) + 12, y + height + 10);
            }
        }

        // Draw the selected color border
        g.setColor(Color.WHITE);
        g.drawRect(x + selectedColorIndex * (height + 5), y, height, height);

        // Draw the fill color box
        g.setColor(colors[1]);
        g.fillRect(x + colors.length * (height + 5) + 10, y, height, height);
        g.setColor(Color.WHITE);
        g.drawRect(x + colors.length * (height + 5) + 10, y, height, height);
        g.setColor(Color.BLACK);
        g.drawRect(x + colors.length * (height + 5) + 11, y + 1, height - 2, height - 2);

        // Draw the color gradient
        g.drawImage(gradient, x + colors.length * (height + 5) + 10 + height + 10, y + (height - gradientHeight) / 2, gradientWidth, gradientHeight, null);
    }

    public void onClick(int mouseX, int mouseY) {
        // Check if the user clicked on a color in the toolbar
        for (int i = 0; i < colors.length; i++) {
            if (mouseX >= x + i * (height + 5) && mouseX < x + i * (gradientWidth = width * 2));
        }}}
