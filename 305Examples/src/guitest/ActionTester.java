package guitest;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

public class ActionTester
{
	public  void draw  () 
   {
      JFrame frame = new JFrame();
   
    
      final int FIELD_WIDTH = 75;
     // JTextField textField = new JTextField(FIELD_WIDTH);
      JTextField textField = new JTextField(FIELD_WIDTH);
      textField.setText("Click a button!");

      JButton helloButton = new JButton("Say Hello");
      textField.setText("Click a button2");
      helloButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               textField.setText("Hello, World!");
            }
         });

      JButton goodbyeButton = new JButton("select a file");

      goodbyeButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               
           	JFileChooser jFileChooser = new JFileChooser();
    		jFileChooser.setCurrentDirectory(new File("~/sbh"));
    		
    		int result = jFileChooser.showOpenDialog(new JFrame());
    	
    	
    		if (result == JFileChooser.APPROVE_OPTION) {
    		    File selectedFile = jFileChooser.getSelectedFile();
    		    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
    		    textField.setText(selectedFile.getAbsolutePath());
					//Image image = ImageIO.read (selectedFile);
    		}
            }
         });

     
      frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
      
      frame.add(helloButton);
      frame.add(goodbyeButton);
      frame.add(textField);
      frame.add(new JLabel(new ImageIcon(ActionTester.class.getResource("globe.gif"))));
      frame.setLayout(new FlowLayout());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //frame.setUndecorated(true);
      frame.setVisible(true);
      //frame.pack();
      frame.setVisible(true);
   }
}

