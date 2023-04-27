package Mine;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class ColorGradient {
    private BufferedImage gradient;

    public ColorGradient(int width, int height, Color startColor, Color endColor) {
        gradient = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Loop through each pixel in the gradient
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                // Calculate the percentage of completion
                double percentage = (double) y / (double) height;

                // Get the color at the current percentage
                Color color = getColorBetween(startColor, endColor, percentage);

                // Set the pixel color
                gradient.setRGB(x, y, color.getRGB());
            }
        }
    }

    public BufferedImage getGradient() {
        return gradient;
    }

    public  Color getColorFromGradient(int x, int y) {
        // Get the color at the specified pixel
        return new Color(gradient.getRGB(x, y));
    }

    private Color getColorBetween(Color start, Color end, double percentage) {
        int red = (int) (start.getRed() + (end.getRed() - start.getRed()) * percentage);
        int green = (int) (start.getGreen() + (end.getGreen() - start.getGreen()) * percentage);
        int blue = (int) (start.getBlue() + (end.getBlue() - start.getBlue()) * percentage);

        return new Color(red, green, blue);
    }
}
