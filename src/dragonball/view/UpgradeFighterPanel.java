package dragonball.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dragonball.controller.MainFrameGUI;

public class UpgradeFighterPanel extends JPanel implements ActionListener{
	JLabel maxHealthPoints;
	JLabel physicalDamage;
	JLabel blastDamage;
	JLabel maxKi;
	JLabel maxStamina;
	JButton finish;
	JButton upMaxHealthPoints;
	JButton upPhysicalDamage;
	JButton upBlastDamage;
	JButton upMaxKi;
	JButton upMaxStamina;
	MainFrameGUI mainFrameGUI;
	
	public JButton getUpMaxHealthPoints() {
		return upMaxHealthPoints;
	}

	public void setUpMaxHealthPoints(JButton upMaxHealthPoints) {
		this.upMaxHealthPoints = upMaxHealthPoints;
	}

	public JButton getUpPhysicalDamage() {
		return upPhysicalDamage;
	}

	public void setUpPhysicalDamage(JButton upPhysicalDamage) {
		this.upPhysicalDamage = upPhysicalDamage;
	}

	public JButton getUpBlastDamage() {
		return upBlastDamage;
	}

	public void setUpBlastDamage(JButton upBlastDamage) {
		this.upBlastDamage = upBlastDamage;
	}

	public JButton getUpMaxKi() {
		return upMaxKi;
	}

	public void setUpMaxKi(JButton upMaxKi) {
		this.upMaxKi = upMaxKi;
	}

	public JButton getUpMaxStamina() {
		return upMaxStamina;
	}

	public void setUpMaxStamina(JButton upMaxStamina) {
		this.upMaxStamina = upMaxStamina;
	}

	public MainFrameGUI getMainFrameGUI() {
		return mainFrameGUI;
	}

	public void setMainFrameGUI(MainFrameGUI mainFrameGUI) {
		this.mainFrameGUI = mainFrameGUI;
	}

	public void setMaxHealthPoints(JLabel maxHealthPoints) {
		this.maxHealthPoints = maxHealthPoints;
	}

	public void setPhysicalDamage(JLabel physicalDamage) {
		this.physicalDamage = physicalDamage;
	}

	public void setBlastDamage(JLabel blastDamage) {
		this.blastDamage = blastDamage;
	}

	public void setMaxKi(JLabel maxKi) {
		this.maxKi = maxKi;
	}

	public void setMaxStamina(JLabel maxStamina) {
		this.maxStamina = maxStamina;
	}

	public void setFinish(JButton finish) {
		this.finish = finish;
	}

	public UpgradeFighterPanel(){
		
		Dimension y=Toolkit.getDefaultToolkit().getScreenSize();
		 this.setLayout(new GridLayout(13,1));
		    this.setSize(400,300);
		    this.setOpaque(true);
		    this.setBackground(new Color(13, 134, 145,123));
		    
		    maxHealthPoints= new JLabel();
			//maxHealthPoints.setText(" maxHealthPoints: ");
			maxHealthPoints.setFont(new Font("Broadway", Font.BOLD, 25));
			maxHealthPoints.setForeground(Color.WHITE);
			maxHealthPoints.setOpaque(false);
			maxHealthPoints.setVisible(true);
			maxHealthPoints.setSize(600,70);
			this.add(maxHealthPoints);
 
			
			upMaxHealthPoints = new JButton("upMaxHealthPoints");
			upMaxHealthPoints.setFont(new Font("Broadway", Font.BOLD, 25));
			upMaxHealthPoints.setSize(200, 50);
			upMaxHealthPoints.setForeground(Color.GREEN);
			upMaxHealthPoints.setVisible(true);
			upMaxHealthPoints.addActionListener(this);
			upMaxHealthPoints.setBackground(Color.WHITE);
			this.add(upMaxHealthPoints);
			
			physicalDamage= new JLabel();
			//physicalDamage.setText(" physicalDamage: ");
			physicalDamage.setFont(new Font("Broadway", Font.BOLD, 25));
			physicalDamage.setForeground(Color.WHITE);
			physicalDamage.setOpaque(false);
			physicalDamage.setVisible(true);
			physicalDamage.setSize(600,70);
			this.add(physicalDamage);

			
			upPhysicalDamage = new JButton("upPhysicalDamage");
			upPhysicalDamage.setFont(new Font("Broadway", Font.BOLD, 25));
			upPhysicalDamage.setSize(200, 50);
			upPhysicalDamage.setForeground(Color.GREEN);
			upPhysicalDamage.setVisible(true);
			upPhysicalDamage.addActionListener(this);
			upPhysicalDamage.setBackground(Color.WHITE);
			this.add(upPhysicalDamage);
			
			blastDamage= new JLabel();
			//blastDamage.setText(" blastDamage: ");
			blastDamage.setFont(new Font("Broadway", Font.BOLD, 25));
			blastDamage.setForeground(Color.WHITE);
			blastDamage.setOpaque(false);
			blastDamage.setVisible(true);
			blastDamage.setSize(600,70);
			this.add(blastDamage);

			
			upBlastDamage = new JButton("upBlastDamage");
			upBlastDamage.setFont(new Font("Broadway", Font.BOLD, 25));
			upBlastDamage.setSize(200, 50);
			upBlastDamage.setForeground(Color.GREEN);
			upBlastDamage.setVisible(true);
			upBlastDamage.addActionListener(this);
			upBlastDamage.setBackground(Color.WHITE);
			this.add(upBlastDamage);
			
			maxKi= new JLabel();
			//maxKi.setText(" maxKi: ");
			maxKi.setFont(new Font("Broadway", Font.BOLD, 25));
			maxKi.setForeground(Color.WHITE);
			maxKi.setOpaque(false);
			maxKi.setVisible(true);
			maxKi.setSize(600,70);
			this.add(maxKi);

			
			upMaxKi = new JButton("upMaxKi");
			upMaxKi.setFont(new Font("Broadway", Font.BOLD, 25));
			upMaxKi.setSize(200, 50);
			upMaxKi.setForeground(Color.GREEN);
			upMaxKi.setVisible(true);
			upMaxKi.addActionListener(this);
			upMaxKi.setBackground(Color.WHITE);
			this.add(upMaxKi);
			
			maxStamina= new JLabel();
			//maxStamina.setText(" maxStamina: ");
			maxStamina.setFont(new Font("Broadway", Font.BOLD, 25));
			maxStamina.setForeground(Color.WHITE);
			maxStamina.setOpaque(false);
			maxStamina.setVisible(true);
			maxStamina.setSize(600,70);
			this.add(maxStamina);

			
			 upMaxStamina = new JButton("upMaxStamina");
			 upMaxStamina.setFont(new Font("Broadway", Font.BOLD, 25));
			 upMaxStamina.setSize(200, 50);
			 upMaxStamina.setForeground(Color.GREEN);
			 upMaxStamina.setVisible(true);
			 upMaxStamina.addActionListener(this);
			 upMaxStamina.setBackground(Color.WHITE);
			this.add( upMaxStamina);
			
			 finish= new JButton("FINISH");
			 finish.setFont(new Font("Broadway", Font.BOLD, 25));
			 finish.setSize(200, 50);
				finish.setForeground(Color.RED);
				finish.setVisible(true);
				finish.addActionListener(this);
				finish.setBackground(Color.WHITE);
				this.add(finish);
			 
			
			
			
		

			this.setVisible(true);
			this.repaint();
			this.validate();
		
	}

	public JLabel getMaxHealthPoints() {
		return maxHealthPoints;
	}

	public JLabel getPhysicalDamage() {
		return physicalDamage;
	}

	public JLabel getBlastDamage() {
		return blastDamage;
	}

	public JLabel getMaxKi() {
		return maxKi;
	}

	public JLabel getMaxStamina() {
		return maxStamina;
	}

	public JButton getFinish() {
		return finish;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mainFrameGUI.actionPerformed(e);
		
	}
	

}
