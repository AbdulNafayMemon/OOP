package Mine;

public class MenuBar {
    private MenuButton fileButton;
    private MenuButton editButton;
    private DropDownMenu fileMenu;
    private DropDownMenu editMenu;
    private int x;
    private int y;
    private int width;
    private int height;

    public MenuBar(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        fileButton = new MenuButton(x, y, width / 2, height, fileButton.image_depressed, fileButton.image_pressed,  "F");
        editButton = new MenuButton(x + width / 2, y, width / 2, height, editButton.image_depressed, editButton.image_pressed,  "E");
        fileMenu = new DropDownMenu(x, y + height, width / 2, height * 3);
        editMenu = new DropDownMenu(x + width / 2, y + height, width / 2, height * 2);
    }

    public void AddFileMenuItem(MenuButton button) {
        fileMenu.AddButton(button);
    }

    public void AddEditMenuItem(MenuButton button) {
        editMenu.AddButton(button);
    }

    public MenuButton GetFileButton() {
        return fileButton;
    }

    public MenuButton GetEditButton() {
        return editButton;
    }

    public DropDownMenu GetFileMenu() {
        return fileMenu;
    }

    public DropDownMenu GetEditMenu() {
        return editMenu;
    }

    public int GetX() {
        return x;
    }

    public int GetY() {
        return y;
    }

    public int GetWidth() {
        return width;
    }

    public int GetHeight() {
        return height;
    }
}