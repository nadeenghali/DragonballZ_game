package dragonball.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import dragonball.controller.MainFrameGUI;

public class StartButtons extends JPanel implements ActionListener {
	private JButton x;
	private JButton y;
	private JButton z;
	private MainFrameGUI mainFrame;
	
	public void setMainFrame(MainFrameGUI mainFrame) {
		this.mainFrame = mainFrame;
	}

	public StartButtons()
	{	//Color Nadeen=new Color(147,205,247); how to make new colors
		
		//startGamePanel = new StartGamePanel();
		x=new JButton("New Game");
		x.setFont(new Font("Broadway", Font.BOLD, 45));
		x.setForeground(Color.WHITE);
		//x.setBackground(Color.BLUE);
		x.addActionListener(this);
		y =new JButton("Saved Game");
		y.setFont(new Font("Broadway", Font.BOLD, 45));
		y.setForeground(Color.WHITE);
		//y.setBackground(Color.BLUE);
		y.addActionListener(this);
		z =new JButton("Exit");
		z.setFont(new Font("Broadway", Font.BOLD, 45));
		z.setForeground(Color.RED);
		//z.setBackground(Color.white);
		z.addActionListener(this);
		setSize(400,250);
		setLayout(new GridLayout(3,1));
		
		x.setBorderPainted(false);
		x.setOpaque(false);
		x.setContentAreaFilled(false);
		add(x);
		
		y.setBorderPainted(false);
		y.setOpaque(false);
		y.setContentAreaFilled(false);
		add(y);
		
	
		
		z.setBorderPainted(false);
		z.setOpaque(false);
		z.setContentAreaFilled(false);
		add(z);
		repaint();
		revalidate();

		
		setVisible(true);
		this.setOpaque(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		mainFrame.actionPerformed(e);
		
	}

	
	
}
