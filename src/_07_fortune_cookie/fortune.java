package _07_fortune_cookie;

import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class fortune implements ActionListener{
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton();
	JOptionPane pane = new JOptionPane();
		
	public void showButton() {



		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(button);
		button.setText("Click me for a fortune!");
		//frame.add(pane);
		frame.pack();
		button.addActionListener((ActionListener) this);
				
		
		
		
		
		System.out.println("Button clicked");
		

		
		
	}
@Override
		public void actionPerformed(ActionEvent arg0) {
			JButton buttonPressed = (JButton) arg0.getSource();

			/* If the buttonPressed was the leftButton.... */
			if(buttonPressed == button) {
				String msg[] = {"You will find great fortune","You will be rich","You are successfull","The ok button works!","You have good luck!"};
				int rand = new Random().nextInt(5);
				pane.setName(msg[rand]);
				pane.setMessage(msg[rand]);
				JOptionPane.showMessageDialog(pane, msg[rand]);
			}


			frame.pack();
		}
	
}
