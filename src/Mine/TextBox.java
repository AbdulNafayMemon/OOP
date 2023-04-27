package Mine;

public class TextBox {
    private String text;
    private int x;
    private int y;
    private int width;
    private int height;

    public TextBox(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        text = "";
    }

    public void AddText(String text) {
        this.text += text;
    }

    public void RemoveLastCharacter() {
        if(text.length() > 0) {
            text = text.substring(0, text.length() - 1);
        }
    }

    public void ClearText() {
        text = "";
    }

    public String GetText() {
        return text;
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

