package Mine;

import java.awt.*;

public class ShapesToolbar extends Toolbar {

    Image imageRightAngleTriangleDepressed, imageRightAngleTrianglePressed, imageEquilateralTriangleDepressed, imageEquilateralTrianglePressed, imageRectangleDepressed, imageRectanglePressed, imageCircleDepressed, imageCirclePressed, imageHexagonDepressed, imageHexagonPressed, imagePentagramDepressed, imagePentagramPressed;

    public ShapesToolbar(int x, int y, int width, int height) {
        super(x, y, width, height);


        // Create the buttons and add them to the toolbar
        ToggleButton btnRightAngleTriangle = new ToggleButton(0, 0, 32, 32, imageRightAngleTriangleDepressed, imageRightAngleTrianglePressed, "Ctrl+R");
        ToggleButton btnEquilateralTriangle = new ToggleButton(32, 0, 32, 32, imageEquilateralTriangleDepressed, imageEquilateralTrianglePressed, "Ctrl+E");
        ToggleButton btnRectangle = new ToggleButton(64, 0, 32, 32, imageRectangleDepressed, imageRectanglePressed, "Ctrl+T");
        ToggleButton btnCircle = new ToggleButton(96, 0, 32, 32, imageCircleDepressed, imageCirclePressed, "Ctrl+C");
        ToggleButton btnHexagon = new ToggleButton(128, 0, 32, 32, imageHexagonDepressed, imageHexagonPressed, "Ctrl+H");
        ToggleButton btnPentagram = new ToggleButton(160, 0, 32, 32, imagePentagramDepressed, imagePentagramPressed, "Ctrl+P");

        AddButton(btnRightAngleTriangle);
        AddButton(btnEquilateralTriangle);
        AddButton(btnRectangle);
        AddButton(btnCircle);
        AddButton(btnHexagon);
        AddButton(btnPentagram);
    }

}
