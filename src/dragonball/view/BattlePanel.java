package dragonball.view;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

import dragonball.controller.MainFrameGUI;


public class BattlePanel extends JPanel implements ActionListener{
	private Dimension y;
	private JLabel backg;
	private JPanel foeInfo;
	private JLabel foeName;
	private JLabel playerFighterName;
	private JPanel playerFighterInfo;
	private JProgressBar foeHp;
	private JProgressBar playerFighterHp;
	private JProgressBar foeStamina;
	private JProgressBar playerFighterStamina;
	private JProgressBar foeKi;
	private JProgressBar playerFigherKi;
	private JButton attack1;
	private JButton block1;
	private JComboBox chooseAttack;
	private String [] listOfAttacks;
	private JLabel turnIndicator;
	private JLabel actionLabel;
	private JLabel meImage;
	private JLabel foeImage;
	
	
	public JLabel getActionLabel() {
		return actionLabel;
	}
	private JButton use;
	private MainFrameGUI mainFrameGUI;
	private ExceptionMessagePanel exceptionKiMessagePanel;
	
	public JButton getUse() {
		return use;
	}
	public MainFrameGUI getMainFrameGUI() {
		return mainFrameGUI;
	}
	public JPanel getFoeInfo() {
		return foeInfo;
	}
	public JLabel getFoeName() {
		return foeName;
	}
	public JProgressBar getFoeHp() {
		return foeHp;
	}
	public JProgressBar getPlayerFighterHp() {
		return playerFighterHp;
	}
	public JProgressBar getFoeStamina() {
		return foeStamina;
	}
	public JProgressBar getPlayerFighterStamina() {
		return playerFighterStamina;
	}
	public JProgressBar getFoeKi() {
		return foeKi;
	}
	public JProgressBar getPlayerFigherKi() {
		return playerFigherKi;
	}
	
	
	
	public JLabel getBackg() {
		return backg;
	}
	public JPanel getFighterInfo() {
		return foeInfo;
	}
	public JLabel getFighterName() {
		return foeName;
	}
	public JLabel getPlayerFighterName() {
		return playerFighterName;
	}
	public JPanel getPlayerFighterInfo() {
		return playerFighterInfo;
	}
	public JProgressBar getHp1() {
		return foeHp;
	}
	public JProgressBar getHp2() {
		return playerFighterHp;
	}
	public JProgressBar getStamina1() {
		return foeStamina;
	}
	public JProgressBar getStamina2() {
		return playerFighterStamina;
	}
	public JProgressBar getKi1() {
		return foeKi;
	}
	public JProgressBar getKi2() {
		return playerFigherKi;
	}
	public JButton getAttack1() {
		return attack1;
	}
	public JButton getBlock1() {
		return block1;
	}
	public JComboBox getChooseAttack() {
		return chooseAttack;
	}
	public String[] getListOfAttacks() {
		return listOfAttacks;
	}
	public JLabel getTurnIndicator() {
		return turnIndicator;
	}
	
	
	
	public BattlePanel()
	{
		 y=Toolkit.getDefaultToolkit().getScreenSize();
		 this.setLayout(null);
		 this.setSize(y);
		 backg=new JLabel();
		 backg.setLayout(null);
		 backg.setSize(y);
		 
		 
		 
		 meImage=new JLabel ();
		 meImage.setSize(200,300);
		 meImage.setLocation(backg.getWidth()-600, 600);
			BufferedImage image1 = null;
		    try {
				image1 = ImageIO.read(new File("fighter1.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ImageIcon I1 = new ImageIcon(image1);
			
			   meImage.setOpaque(false);
			   meImage.repaint();
			 	meImage.setIcon(I1);
			   backg.add(meImage);
			   setVisible(true);
			 
			   
			   
				 foeImage=new JLabel ();
					foeImage.setSize(300,450);
					foeImage.setLocation(backg.getWidth()-1675, 450);
					BufferedImage image2 = null;
				    try {
						image2 = ImageIO.read(new File("foe1.png"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ImageIcon I2 = new ImageIcon(image2);
					
					  foeImage.setOpaque(false);
					 	foeImage.setIcon(I2);
					   backg.add(foeImage);
					   foeImage.repaint();
					   setVisible(true);
		 
		 
		 
		BufferedImage image = null;
		    try {
				image = ImageIO.read(new File("BattleBackground1.jpg"));
				//image = ImageIO.read(new File("greybackground.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ImageIcon I = new ImageIcon(fitimage(image,(int)(backg.getWidth()),(int)(backg.getHeight())));
			
			
		   backg.setIcon(I);
		   backg.setOpaque(true);
		   this.add(backg);
		   setVisible(true);
		   
		   exceptionKiMessagePanel = new ExceptionMessagePanel();
			exceptionKiMessagePanel.setLocation((backg.getWidth()/2)-400, backg.getHeight()-800);
			exceptionKiMessagePanel.setVisible(false);
			backg.add(exceptionKiMessagePanel);
			
		   
		   attack1= new JButton("ATTACK");
			attack1.setSize(190,70);
			attack1.setFont(new Font("Broadway", Font.BOLD, 30));
			attack1.setForeground(Color.WHITE);
			attack1.setBackground(Color.RED);
			attack1.setBorderPainted(true);
			attack1.setLocation(y.width-500,y.height-200);
			backg.add(attack1);
			attack1.addActionListener(this);
			
			//String [] listOfAttacks1 =  { "yabnel kalb", "mamtak ma3erftsh terabyk" };
			//listOfAttacks =listOfAttacks1;
			chooseAttack = new JComboBox();
			chooseAttack.setLocation(y.width-700, y.height-200);
			chooseAttack.setVisible(true);
			chooseAttack.setSize(190,70);
			backg.add(chooseAttack);
			
			block1= new JButton("BLOCK");
			block1.setSize(190,70);
			block1.setFont(new Font("Broadway", Font.BOLD, 30));
			block1.setForeground(Color.WHITE);
			block1.setBackground(Color.BLUE);
			block1.setBorderPainted(true);
			block1.setLocation(y.width-300,y.height-200);
			backg.add(block1);
			block1.addActionListener(this);
	   
		   
		  foeInfo= new JPanel();
		   foeInfo.setSize(700,300 );
		 //  fighter1Info.setFont(new Font("Broadway", Font.BOLD, 30));
		  // fighter1Info.setForeground(Color.WHITE);
		   foeInfo.setLayout(new GridLayout(7,1));
		  // fighter1Info.setEditable(false);
		   foeInfo.setBackground(new Color(13,134,145,123));
		   backg.add(foeInfo);
		   foeInfo.setVisible(true);
		   foeName = new JLabel("Foe");
		   foeName.setFont(new Font("Broadway", Font.BOLD, 30));
		   foeName.setForeground(Color.WHITE);
		   
		   foeInfo.add(foeName);
		   
		   foeHp = new JProgressBar(0, 15);//this will change depending on players own hp
		   foeHp.setStringPainted(true);
		   foeHp.setForeground(Color.green);
		   foeHp.setOpaque(false);
			 foeHp.setValue(8);
			 foeHp.setSize(10, 5);
			foeHp.setString("HP");
			foeInfo.add(foeHp);
			
			 foeStamina = new JProgressBar(0, 10);//this will also change... you get the idea
			   foeStamina.setStringPainted(true);
			   foeStamina.setForeground(Color.ORANGE);
			   foeStamina.setOpaque(false);
				 foeStamina.setValue(8);
				 foeStamina.setSize(10, 5);
				foeStamina.setString("STAMINA");
				foeInfo.add(foeStamina);
				
				foeKi = new JProgressBar(0, 10);
				   foeKi.setStringPainted(true);
				   foeKi.setForeground(Color.BLUE);
				   foeKi.setOpaque(false);
					 foeKi.setValue(8);
					 foeKi.setSize(10, 5);
					foeKi.setString("KI");
					foeInfo.add(foeKi);

		   
		  playerFighterInfo=new JPanel();
		   playerFighterInfo.setLocation((int)(backg.getWidth()-700),0);
		   playerFighterInfo.setSize(700,300 );
		   playerFighterInfo.setLayout(new GridLayout(7,1));
		  // fighter2Info.setFont(new Font("Broadway", Font.BOLD, 30));
		  // fighter2Info.setForeground(Color.WHITE);
		   //fighter1Info.setText();
		  // fighter2Info.setEditable(false);
		   playerFighterInfo.setBackground(new Color(13,134,145,123));
		   backg.add(playerFighterInfo);
		   playerFighterInfo.setVisible(true);
		   
		   playerFighterName = new JLabel();
		   playerFighterName.setFont(new Font("Broadway", Font.BOLD, 30));
		   playerFighterName.setForeground(Color.WHITE);
		   playerFighterInfo.add(playerFighterName);
		   
		   playerFighterHp = new JProgressBar();
		   playerFighterHp.setStringPainted(true);
		   playerFighterHp.setForeground(Color.green);
		   playerFighterHp.setOpaque(false);
			 playerFighterHp.setValue(8);
			 playerFighterHp.setSize(10, 5);
			playerFighterHp.setString("HP");
			playerFighterInfo.add(playerFighterHp);
			
			playerFighterStamina = new JProgressBar();//this will also change... you get the idea
			   playerFighterStamina.setStringPainted(true);
			   playerFighterStamina.setForeground(Color.ORANGE);
			   playerFighterStamina.setOpaque(false);
				 playerFighterStamina.setValue(8);
				 playerFighterStamina.setSize(10, 5);
				playerFighterStamina.setString("STAMINA");
				playerFighterInfo.add(playerFighterStamina);
				
				playerFigherKi = new JProgressBar();//this will also change... you get the ide
				   playerFigherKi.setStringPainted(true);
				   playerFigherKi.setForeground(Color.BLUE);
				   playerFigherKi.setOpaque(false);
					 playerFigherKi.setValue(8);
					 playerFigherKi.setSize(10, 5);
					playerFigherKi.setString("KI");
					playerFighterInfo.add(playerFigherKi);
		   
		   
				 turnIndicator=new JLabel();
				   turnIndicator.setSize(500,60);
					   turnIndicator.setFont(new Font("Broadway", Font.BOLD, 20));
					 turnIndicator.setLocation(backg.getWidth()-1130, 80);
					   backg.add(turnIndicator);
					   
					   actionLabel = new JLabel();
					   actionLabel.setSize(500,60);
					   actionLabel.setFont(new Font("Broadway", Font.BOLD, 25));
					   actionLabel.setLocation(backg.getWidth()-1050, 200);
					   backg.add(actionLabel);
					   actionLabel.setVisible(true);
					
					   	use= new JButton("USE");
						use.setSize(190,70);
						use.setFont(new Font("Broadway", Font.BOLD, 30));
						use.setForeground(Color.BLUE);
						//use.setBackground(Color.WHITE);
						use.setBorderPainted(true);
						playerFighterInfo.add(use);
						use.addActionListener(this);
		   this.validate();
		   this.repaint();
		   
		   
		 
		
	}
	public ExceptionMessagePanel getExceptionKiMessagePanel() {
		return exceptionKiMessagePanel;
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
	
		mainFrameGUI.actionPerformed(e);
		
	}
	public void setMainFrameGUI(MainFrameGUI mainFrameGUI) {
		this.mainFrameGUI = mainFrameGUI;
	}
	

}
