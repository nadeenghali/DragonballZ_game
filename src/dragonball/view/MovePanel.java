package dragonball.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import dragonball.controller.MainFrameGUI;

public class MovePanel extends JPanel implements ActionListener{
	private JButton moveUp;
	private JButton moveDown;
	private JButton moveRight;
	private JButton moveLeft;
	private MainFrameGUI mainFrameGUI;
	
	public MainFrameGUI getMainFrameGUI() {
		return mainFrameGUI;
	}

	public void setMainFrameGUI(MainFrameGUI mainFrameGUI) {
		this.mainFrameGUI = mainFrameGUI;
	}

	public JButton getMoveUp() {
		return moveUp;
	}

	public JButton getMoveDown() {
		return moveDown;
	}

	public JButton getMoveRight() {
		return moveRight;
	}

	public JButton getMoveLeft() {
		return moveLeft;
	}

	public MovePanel(){
		
		this.setLayout(new BorderLayout());
	    this.setSize(350,100);
	    this.setOpaque(true);
	    this.setBackground(new Color(13, 134, 145,123));
	    
	    moveUp = new JButton("UP");
		 moveUp.setFont(new Font("Broadway", Font.BOLD, 25));
		 moveUp.setSize(50, 50);
		 moveUp.setForeground(Color.BLUE);
		 moveUp.setVisible(true);
		 moveUp.addActionListener(this);
		// moveUp.setBackground(Color.WHITE);
		this.add( moveUp, BorderLayout.NORTH);
		
		 moveLeft = new JButton("LEFT");
		 moveLeft.setFont(new Font("Broadway", Font.BOLD, 25));
		 moveLeft.setSize(50, 50);
		 moveLeft.setForeground(Color.BLUE);
		 moveLeft.setVisible(true);
		 moveLeft.addActionListener(this);
		// moveUp.setBackground(Color.WHITE);
		this.add( moveLeft, BorderLayout.WEST);
		
		 moveRight = new JButton("RIGHT");
		 moveRight.setFont(new Font("Broadway", Font.BOLD, 25));
		 moveRight.setSize(50, 50);
		 moveRight.setForeground(Color.BLUE);
		 moveRight.setVisible(true);
		 moveRight.addActionListener(this);
		// moveUp.setBackground(Color.WHITE);
		this.add( moveRight, BorderLayout.EAST);
		
		moveDown = new JButton("DOWN");
		 moveDown.setFont(new Font("Broadway", Font.BOLD, 25));
		 moveDown.setSize(50, 50);
		 moveDown.setForeground(Color.BLUE);
		 moveDown.setVisible(true);
		 moveDown.addActionListener(this);
		// moveUp.setBackground(Color.WHITE);
		this.add( moveDown, BorderLayout.CENTER);
		
		this.repaint();
		this.validate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mainFrameGUI.actionPerformed(e);
		
	}

	
	

}
