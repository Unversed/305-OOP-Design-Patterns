package lab07d.frame;

import java.awt.*;
import javax.swing.*;

public class FrameTest
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      JButton helloButton = new JButton("Say Hello");
      JButton goodbyeButton = new JButton("Say Goodbye");

      final int FIELD_WIDTH = 20;
      JTextField textField = new JTextField(FIELD_WIDTH);
      textField.setText("Click a button!");

      Container contentPane = frame.getContentPane();
      contentPane.setLayout(new FlowLayout());

      contentPane.add(helloButton);
      contentPane.add(goodbyeButton);
      contentPane.add(textField);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }
}
