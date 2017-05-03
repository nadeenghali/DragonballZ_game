package dragonball.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import dragonball.controller.MainFrameGUI;

public class ExceptionMessagePanel extends JPanel implements ActionListener {
	
	private JTextArea exceptionMessage;
	private JButton closeButton;
	private MainFrameGUI mainFrameGUI;
	
	public ExceptionMessagePanel(){
		this.setSize(800,100);
		this.setOpaque(true);
		//this.setLayout(new GridLayout(13,1));
	    this.setBackground(new Color(13, 134, 145,123));
	    
	    
	    exceptionMessage = new JTextArea();
		exceptionMessage.setFont(new Font("Broadway", Font.BOLD, 20));
		exceptionMessage.setForeground(Color.WHITE);
		exceptionMessage.setOpaque(false);
		exceptionMessage.setSize(200,200);
		exceptionMessage.setEditable(false);
		this.add(exceptionMessage);
		
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

	public MainFrameGUI getMainFrameGUI() {
		return mainFrameGUI;
	}

	public void setMainFrameGUI(MainFrameGUI mainFrameGUI) {
		this.mainFrameGUI = mainFrameGUI;
	}

	public JTextArea getExceptionMessage() {
		return exceptionMessage;
	}

	public JButton getCloseButton() {
		return closeButton;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	/*	if (e.getSource() instanceof JButton) {
        	JButton button = (JButton) e.getSource();
		if(button.getText().equals("CLOSE")){
			
			this.setVisible(false);
			}
		}*/
		mainFrameGUI.actionPerformed(e);
		
		
	}


}
