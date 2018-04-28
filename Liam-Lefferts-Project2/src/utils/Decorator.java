package utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JComponent;

public class Decorator
    {

	public static void setFontBold(JComponent comp)
	    {
		Font font = comp.getFont();
		comp.setFont(
			new Font(font.getName(), Font.BOLD, font.getSize()));
	    }

	public static void setFontItalic(JComponent comp)
	    {
		Font font = comp.getFont();
		comp.setFont(
			new Font(font.getName(), Font.ITALIC, font.getSize()));
	    }

	public static void setFontSize(JComponent comp, int size)
	    {
		Font font = comp.getFont();
		comp.setFont(new Font(font.getName(), Font.PLAIN, size));
	    }

	public static void setFontColor(JComponent comp, String option)
	    {
		Component[] options = comp.getComponents();
		Color color = Color.black;

		switch (option)
		    {
		    case "red":
			color = Color.red;
			break;
		    case "magenta":
			color = Color.magenta;
			break;
		    case "pink":
			color = Color.pink;
			break;
		    case "orange":
			color = Color.orange;
			break;
		    case "yellow":
			color = Color.yellow;
			break;
		    case "green":
			color = Color.green;
			break;
		    case "blue":
			color = Color.blue;
			break;
		    case "cyan":
			color = Color.cyan;
			break;
		    case "white":
			color = Color.white;
			break;
		    case "gary":
			color = Color.gray;
			break;
		    case "darkGray":
			color = Color.darkGray;
			break;
		    default:
			color = Color.black;
		    }

		comp.setForeground(color);
	    }
    }
