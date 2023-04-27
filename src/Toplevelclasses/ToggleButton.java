package Toplevelclasses;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;

public class ToggleButton 
{
	public int x;
	public int y;
	public int width;
	public int height;
	public Image image_depressed;
	public Image image_pressed;
	public Image current_image;
	public boolean pressed;
	public String title;
	public Color currentColor;
	public Color unpressedColor;
	public Color pressedColor;

	
	
	public ToggleButton(int x, int y, int width, int height, Image i_depressed, Image i_pressed, String title)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.title=title;
		image_depressed = i_depressed;
		image_pressed = i_pressed;
		current_image = i_depressed;
		pressed = false;
	}	
	
	
	
	
	public ToggleButton(int x, int y, int width, int height, Color c_depressed, Color c_pressed, String title)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.title=title;
		this.unpressedColor = c_depressed;
		this.pressedColor = c_pressed;
		currentColor = c_depressed;
		
		pressed = false;
	}	






	public ToggleButton(int x, int y, int width, int height, String title)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.title=title;
		
		pressed = false;
	}
	public ToggleButton(int x, int y, int width, int height, String title, Color color)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.title=title;
		this.currentColor = color;
		pressed = false;
	}
	
	
	public ToggleButton( Color color, Point point, Dimension d, String title)
	{
		this.x = point.x;
		this.y = point.y;
		this.width = d.width;
		this.height = d.height;
		this.title=title;
		this.currentColor = color;
		pressed = false;
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
	
	public boolean IsClicked(int x, int y) {
		
        if (x > this.x && x < this.x + width && y > this.y && y < this.y + height) {
            pressed = !pressed;
            if (pressed) {
                current_image = image_pressed;
            } else {
                current_image = image_depressed;
            }
            return true;
        }
        return false;
    }
}
