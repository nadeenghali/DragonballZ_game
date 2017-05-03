package dragonball.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dragonball.controller.MainFrameGUI;

public class FetchInfoPanel extends JPanel implements ActionListener {
	private JLabel  playerName;
	private JLabel fighter;
	private  JLabel fighterName;
	private  JTextField textField;
	private JButton next;
	private MainFrameGUI mainFrame;
	private String[] fighterNames;
	private JTextField textField2;
	private JComboBox fighterList;
	
	public JLabel getPlayerName() {
		return playerName;
	}
	public JLabel getFighter() {
		return fighter;
	}
	public JLabel getFighterName() {
		return fighterName;
	}
	public JTextField getTextField() {
		return textField;
	}
	public JButton getNext() {
		return next;
	}
	public String[] getFighterNames() {
		return fighterNames;
	}
	public JTextField getTextField2() {
		return textField2;
	}
	public JComboBox getFighterList() {
		return fighterList;
	}
	public FetchInfoPanel(){
		
		this.setLayout( null);
		this.setSize(1700, 750);
	
	this.setOpaque(false);
	Dimension y=Toolkit.getDefaultToolkit().getScreenSize();
	next = new JButton("Next");
	next.setFont(new Font("Broadway", Font.BOLD, 45));
	next.setSize(200, 50);
	next.setForeground(Color.WHITE);
	next.setVisible(true);
	next.addActionListener(this);
	next.setLocation((int) ((y.getWidth()-150)/2)+100,((int) ((y.getHeight()-150)/2))+100);
	next.setBackground(Color.RED);
	this.add(next);
	next.addActionListener(this);
	
		
		playerName= new JLabel();
		playerName.setText("Enter player name:");
		playerName.setFont(new Font("Broadway", Font.BOLD, 45));
		playerName.setForeground(Color.WHITE);
		playerName.setOpaque(false);
		playerName.setSize(600,70);
		playerName.setLocation((int) ((y.getWidth()-150)/2)-795,((int) ((y.getHeight()-150)/2))-470);
		this.add(playerName);
		
		textField = new JTextField(10);
		textField.setFont(new Font("Broadway", Font.BOLD, 45));
		textField.setSize(300, 50);
		this.add(textField);
		textField.setLocation((int) ((y.getWidth()-150)/2)-350,((int) ((y.getHeight()-150)/2))-400);
		textField.setVisible(true);
		//textField.addActionListener(this);
		
		fighter= new JLabel();
		fighter.setText("Choose your fighter");
		fighter.setFont(new Font("Broadway", Font.BOLD, 45));
		fighter.setForeground(Color.WHITE);
		fighter.setOpaque(false);
		fighter.setLocation((int) ((y.getWidth()-150)/2)-795,((int) ((y.getHeight()-150)/2))-310);
		fighter.setVisible(true);
		fighter.setSize(600,70);
		this.add(fighter);
		
		String [] fighterNames1 =  { "Earthling", "Frieza", "Majin", "Namekian", "Saiyan" };
		fighterNames =fighterNames1;
		fighterList = new JComboBox(fighterNames);
		fighterList.setLocation((int) ((y.getWidth()-150)/2)-280,((int) ((y.getHeight()-150)/2))-300);
		fighterList.setVisible(true);
		fighterList.setSize(200,50);
		this.add(fighterList);
		
		fighterName= new JLabel();
		fighterName.setText("Give your fighter a name:");
		fighterName.setFont(new Font("Broadway", Font.BOLD, 45));
		fighterName.setForeground(Color.WHITE);
		fighterName.setOpaque(false);
		fighterName.setLocation((int) ((y.getWidth()-150)/2)-795,((int) ((y.getHeight()-150)/2))-140);
		fighterName.setVisible(true);
		fighterName.setSize(1000,70);
		this.add(fighterName);
		
		textField2 = new JTextField(10);
		textField2.setFont(new Font("Broadway", Font.BOLD, 45));
		textField2.setSize(300, 50);
		this.add(textField2);
		textField2.setLocation((int) ((y.getWidth()-150)/2)-350,((int) ((y.getHeight()-150)/2))-50);
		textField2.setVisible(true);
		//textField2.addActionListener(this);
		
		//fighterList.addActionListener(l);
		
		setVisible(true);
		this.validate();
		this.repaint();
		
	}
	public Image fitimage(Image img , int w , int h)
	{
	    BufferedImage resizedimage = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
	    Graphics2D g2 = resizedimage.createGraphics();
	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(img, 0, 0,w,h,null);
	    g2.dispose();
	    return resizedimage;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		/*String text = textField.getText();
		mainFrame.getMapPanel().getPlayerNameLabel().setText(" Welcome, "+text);
		
		String text2 = textField2.getText();
		mainFrame.getMapPanel().getFighterNameLabel().setText(" Active Fighter: "+text2);*/
		if((textField.getText().equals(""))||(textField2.getText().equals("")))
		{}else{
       
		mainFrame.actionPerformed(e);}}
		
	
	public MainFrameGUI getMainFrame() {
		return mainFrame;
	}
	public void setMainFrame(MainFrameGUI mainFrame) {
		this.mainFrame = mainFrame;
	}

}
