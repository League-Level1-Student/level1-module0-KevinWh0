package _10_cuteness_tv;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Project implements ActionListener {
	JFrame frame= new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	void FRAME() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		panel.add(button1);
		button1.setText("Ducks!");
		panel.add(button2);
		button2.setText("Frogs!");
		panel.add(button3);
		button3.setText("Unicorns!");
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		
		
		frame.pack();
		
	}
	
	
	void showDucks() {
	     playVideo("https://www.youtube.com/watch?v=MtN1YnoL46Q");
	}

	void showFrog() {
	     playVideo("https://www.youtube.com/watch?v=cBkWhkAZ9ds");
	}

	void showFluffyUnicorns() {
	     playVideo("https://www.youtube.com/watch?v=a-xWhG4UU_Y");
	}

	void playVideo(String videoID) {
	     try {
	          URI uri = new URI(videoID);
	          java.awt.Desktop.getDesktop().browse(uri);
	     } catch (Exception e) {
	          e.printStackTrace();
	     }
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton buttonPressed = (JButton) arg0.getSource();
		if(buttonPressed == button1) {
			showDucks();
			
		}else if(buttonPressed == button2) {
			showFrog();

		}else if(buttonPressed == button3) {
			showFluffyUnicorns();
			
		}


		frame.pack();
	}
}
