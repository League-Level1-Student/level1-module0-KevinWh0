package _08_jack_in_the_box;

import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Jack  implements ActionListener{
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton();
	int pressAmt = 0;
	void MAIN(){
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.add(button);
		button.setName("Surprise!");
		button.addActionListener((ActionListener) this);
		frame.pack();
		
		
		
		
		
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton buttonPressed = (JButton) arg0.getSource();
		if(buttonPressed == button) {
			pressAmt++;
			if(pressAmt > 4){
				playSound("homer-woohoo.wav");
				showPicture("jackInTheBox.png");
			}
			
		}


		frame.pack();
	}
	private void playSound(String soundFile) { 
	     try {
	          AudioClip sound = JApplet.newAudioClip(getClass().getResource(soundFile));
	          sound.play();
	     } catch (Exception e) {
	          e.printStackTrace();
	     }
	}
	private void showPicture(String fileName) { 
	     try {
	          JLabel imageLabel = createLabelImage(fileName);
	          JFrame frame = new JFrame();
	          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	          frame.add(imageLabel);
	          frame.setVisible(true);
	          frame.pack();
	     } catch (Exception e) {
	          e.printStackTrace();
	     }
	}

	private JLabel createLabelImage(String fileName) {
	     try {
	          URL imageURL = getClass().getResource(fileName);
	          if (imageURL == null) {
	               System.err.println("Could not find image " + fileName);
	               return new JLabel();
	          } else {
	               Icon icon = new ImageIcon(imageURL);
	               JLabel imageLabel = new JLabel(icon);
	               return imageLabel;
	          }
	     } catch (Exception e) {
	          System.err.println("Could not find image " + fileName);
	          return new JLabel();
	     }
	}

}
