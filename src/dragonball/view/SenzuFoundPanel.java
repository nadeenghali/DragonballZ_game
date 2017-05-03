package dragonball.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import dragonball.controller.MainFrameGUI;

public class SenzuFoundPanel extends JPanel implements ActionListener{
	public JTextArea getSenzuFoundMessage() {
		return senzuFoundMessage;
	}

	public JButton getCloseButton() {
		return closeButton;
	}

	private JTextArea senzuFoundMessage;
	private JButton closeButton;
	private MainFrameGUI mainFrameGUI;
	
	public SenzuFoundPanel(){
		this.setSize(370,100);
		this.setOpaque(true);
		//this.setLayout(new GridLayout(13,1));
	    this.setBackground(new Color(13, 134, 145,123));
	    
	    
	    senzuFoundMessage = new JTextArea("Congratulations,\n you have found a Senzu Bean.");
		senzuFoundMessage.setFont(new Font("Broadway", Font.BOLD, 20));
		senzuFoundMessage.setForeground(Color.WHITE);
		senzuFoundMessage.setOpaque(false);
		senzuFoundMessage.setSize(2000,200);
		senzuFoundMessage.setEditable(false);
		this.add(senzuFoundMessage);
		
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
