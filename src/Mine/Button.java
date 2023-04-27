package Mine;

import java.awt.Image;

public class Button 
{
	public int x;
	public int y;
	int width;
	int height;
	Image image_depressed;
	Image image_pressed;
	Image current_image;
	boolean pressed;
	
	public Button(int x, int y, int width, int height, Image i_depressed, Image i_pressed)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		image_depressed = i_depressed;
		image_pressed = i_pressed;
		current_image = i_depressed;
	}	
		
	public Image GetImage() 
	{
		return current_image;
	}
	
	public Boolean IsPressed()
	{
		return pressed;
	}
	
	public void SetPressed(boolean pressed)
	{
		this.pressed = pressed;
	}
	
	public boolean IsClicked(int x, int y)
	{
		if(x > this.x && x < this.x + width && y > this.y && y < this.y + height)
		{
			pressed = true;
			current_image = image_pressed;
			return true;
		}
		return false;
	}
}
