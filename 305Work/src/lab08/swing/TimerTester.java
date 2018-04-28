package lab08.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TimerTester extends JFrame implements ActionListener {


  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private final JTextField textField1;

  private final JButton button1; //button


  public TimerTester() {

      super();
      setLayout(new FlowLayout());

      textField1 = new JTextField(15);
      textField1.setVisible(false);
      add(textField1);

      ActionListener listener = new
    	         ActionListener()
    	         {
    	            public void actionPerformed(ActionEvent event)
    	            {
    	               Date now = new Date();
    	               textField1.setText(now.toString());
    	            }
    	         };
    	      final int DELAY = 1000;
    	         // Milliseconds between timer ticks
    	      Timer t = new Timer(DELAY, listener);
    	      t.start();
      
      
      button1 = new JButton("Timer");
      add(button1);


      button1.addActionListener(this);
      textField1.addActionListener(this);
      pack();
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
    } 
  
  @Override
  public void actionPerformed(ActionEvent event) {
       if (event.getSource() == button1) {
        textField1.setVisible(true);
        pack();
       }
     } 
  public static void main (String args[]) {
    new TimerTester();
  }
}

