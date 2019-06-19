package _09_sound_effects_machine;

import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MAIN implements ActionListener{
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	
	void Sounds() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		panel.add(button1);
		button1.addActionListener(this);
		button1.setText("1");
		panel.add(button2);
		button2.addActionListener(this);
		button2.setText("2");
		frame.pack();
		
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton buttonPressed = (JButton) arg0.getSource();
		if(buttonPressed == button1) {
			playSound("cymbal.wav");
			
		}else if(buttonPressed == button2) {
			playSound("sawing-wood-daniel_simon.wav");
			//System.out.print("test");
		}


		frame.pack();
	}
	private void playSound(String fileName) {

	    AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName)); 

	    sound.play();

	}
}
