package lab08.swing;

import java.io.IOException;

import javax.swing.*;

public class IconTester
{
   public static void main(String[] args) throws IOException
   {
      
	   JOptionPane.showMessageDialog( null, 
            "Hello, World!", "Message",
            JOptionPane.INFORMATION_MESSAGE,
            new ImageIcon(IconTester.class.getResource("globe.jpg")));	   
      System.exit(0);
   }
}
