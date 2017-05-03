package dragonball.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import dragonball.controller.MainFrameGUI;

public class DragonBallFoundPanel extends JPanel implements ActionListener{
	private JTextArea dragonBallFoundMessage;
	private JButton closeButton;
	private MainFrameGUI mainFrameGUI;
	
	public DragonBallFoundPanel(){
		this.setSize(370,100);
		this.setOpaque(true);
		//this.setLayout(new GridLayout(13,1));
	    this.setBackground(new Color(13, 134, 145,123));
	    
	    
	    dragonBallFoundMessage = new JTextArea("Congratulations,\n you have found a Dragon Ball.");
		dragonBallFoundMessage.setFont(new Font("Broadway", Font.BOLD, 20));
		dragonBallFoundMessage.setForeground(Color.WHITE);
		dragonBallFoundMessage.setOpaque(false);
		dragonBallFoundMessage.setSize(2000,200);
		dragonBallFoundMessage.setEditable(false);
		this.add(dragonBallFoundMessage);
		
		closeButton = new JButton("CLOSE");
		closeButton.setFont(new Font("Broadway", Font.BOLD, 20));
		 closeButton.setSize(100, 50);
			closeButton.setForeground(Color.BLUE);
			closeButton.setVisible(true);
			closeButton.addActionListener(this);
			this.add(closeButton);
		
	
		this.setVisible(true);
		
		this.repaint();
		this.revalidate();
	    
	}

	public JTextArea getDragonBallFoundMessage() {
		return dragonBallFoundMessage;
	}

	public JButton getCloseButton() {
		return closeButton;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mainFrameGUI.actionPerformed(e);
		
	}

	public MainFrameGUI getMainFrameGUI() {
		return mainFrameGUI;
	}

	public void setMainFrameGUI(MainFrameGUI mainFrameGUI) {
		this.mainFrameGUI = mainFrameGUI;
	}


}
