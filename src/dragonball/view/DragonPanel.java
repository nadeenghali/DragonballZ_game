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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import dragonball.controller.MainFrameGUI;

public class DragonPanel extends JPanel implements ActionListener{
	private JLabel backg;
	private JTextArea text;
	private JPanel textPanel;
	private Dimension y;
	private JButton senzuBeansWish;
	private JButton abilityPointsWish;
	private JButton superAttackWish;
	private JButton ultimateAttackWish;
	private MainFrameGUI mainFrameGUI;
	
	
	public MainFrameGUI getMainFrameGUI() {
		return mainFrameGUI;
	}
	public void setMainFrameGUI(MainFrameGUI mainFrameGUI) {
		this.mainFrameGUI = mainFrameGUI;
	}
	public DragonPanel(){
		 y=Toolkit.getDefaultToolkit().getScreenSize();
			setSize(y);
			setLayout(null);
			
			//ana 3arf eno msh hay3gebyk bas nezabat fy ba3dein ba2a law msh 3agbyk :p
			
			ImageIcon senzuBeans=new ImageIcon("senzu.png");
			Image senzu=senzuBeans.getImage();
		    senzu = senzu.getScaledInstance(senzu.getWidth(null)/3, senzu.getHeight(null)/3, Image.SCALE_SMOOTH);
		    senzuBeans.setImage(senzu);
			senzuBeansWish =new JButton("Senzu Beans",senzuBeans);
			senzuBeansWish.setVerticalTextPosition(SwingConstants.TOP);
			senzuBeansWish.setHorizontalTextPosition(SwingConstants.CENTER);
			senzuBeansWish.setSize(120, 80);
			senzuBeansWish.setToolTipText("Senzu Beans");
			senzuBeansWish.addActionListener(this);
			
			
			
			ImageIcon abilityPoints=new ImageIcon("ability.png");
			Image points=abilityPoints.getImage();
		    points = points.getScaledInstance(points.getWidth(null)/2, points.getHeight(null)/2, Image.SCALE_SMOOTH);
		    abilityPoints.setImage(points);
			abilityPointsWish =new JButton("Ability Points",abilityPoints);
			abilityPointsWish.setVerticalTextPosition(SwingConstants.TOP);
			abilityPointsWish.setHorizontalTextPosition(SwingConstants.CENTER);
			abilityPointsWish.setSize(120, 80);
			abilityPointsWish.setToolTipText("Ability Points");
			abilityPointsWish.addActionListener(this);
			

			ImageIcon sAttacks=new ImageIcon("attacks2.png");
			Image s=sAttacks.getImage();
		    s = s.getScaledInstance((int)(s.getWidth(null)/1.2),(int)( s.getHeight(null)/1.2), Image.SCALE_SMOOTH);
		    sAttacks.setImage(s);
			superAttackWish =new JButton("Super Attack",sAttacks);
			superAttackWish.setVerticalTextPosition(SwingConstants.TOP);
			superAttackWish.setHorizontalTextPosition(SwingConstants.CENTER);
			superAttackWish.setSize(120, 80);
			superAttackWish.setToolTipText("Super Attack");
			superAttackWish.addActionListener(this);
		
			
			ImageIcon uAttacks=new ImageIcon("attacks1 (1).png");
			Image ult=uAttacks.getImage();
		    ult = ult.getScaledInstance((int)(ult.getWidth(null)/1.2),(int)( ult.getHeight(null)/1.2), Image.SCALE_SMOOTH);
		    uAttacks.setImage(ult);
		    ultimateAttackWish =new JButton("Ulitmate Attack",uAttacks);
		    ultimateAttackWish.setVerticalTextPosition(SwingConstants.TOP);
			ultimateAttackWish.setHorizontalTextPosition(SwingConstants.CENTER);
			ultimateAttackWish.setSize(121, 80);
			ultimateAttackWish.setToolTipText("Ultimate Attack");
			ultimateAttackWish.addActionListener(this);
		
		backg= new JLabel();
		textPanel= new JPanel();
	    textPanel.setLayout(null);
	    textPanel.setSize(500,300);
	    textPanel.setOpaque(true);
	    textPanel.setBackground(new Color(80, 14, 145,123));
		text = new JTextArea("Congratulations,\n you have successfully collected 7 \n dragon balls.\n You may choose your wish");
		text.setFont(new Font("Broadway", Font.BOLD, 25));
		text.setForeground(Color.WHITE);
		text.setOpaque(false);
		text.setSize(2000,200);
		text.setEditable(false);
		
		
		textPanel.add(text);
		textPanel.add(senzuBeansWish);
		senzuBeansWish.setLocation(textPanel.getWidth()-490,textPanel.getHeight()-95);
		textPanel.add(abilityPointsWish);
		abilityPointsWish.setLocation(textPanel.getWidth()-370,textPanel.getHeight()-95);
		textPanel.add(superAttackWish);
		superAttackWish.setLocation(textPanel.getWidth()-250,textPanel.getHeight()-95);
		textPanel.add(ultimateAttackWish);
		ultimateAttackWish.setLocation(textPanel.getWidth()-130,textPanel.getHeight()-95);
		backg.add(textPanel);
		
		textPanel.setLocation(y.width-2000, y.height-420);
		
		backg.setSize(y);
		
		BufferedImage image = null;
	    try {
			image = ImageIO.read(new File("dragon.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon I = new ImageIcon(fitimage(image,y.width,y.height));
		
	    backg.setIcon(I);
	   backg.setOpaque(true);
	   
	   this.add(backg);
	   
	   this.repaint();
		this.revalidate();
		
		
	}
	public JLabel getBackg() {
		return backg;
	}
	public JTextArea getText() {
		return text;
	}
	public JPanel getTextPanel() {
		return textPanel;
	}
	public JButton getSenzuBeansWish() {
		return senzuBeansWish;
	}
	public JButton getAbilityPointsWish() {
		return abilityPointsWish;
	}
	public JButton getSuperAttackWish() {
		return superAttackWish;
	}
	public JButton getUltimateAttackWish() {
		return ultimateAttackWish;
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

}
