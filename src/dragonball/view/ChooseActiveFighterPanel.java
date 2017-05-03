package dragonball.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import dragonball.controller.MainFrameGUI;

public class ChooseActiveFighterPanel extends JPanel implements ActionListener{
	private JComboBox changeActiveFighterComboBox;
	private MainFrameGUI mainFrameGUI;
	private Dimension y;
	private JButton set;
	
	public ChooseActiveFighterPanel(){
		y=Toolkit.getDefaultToolkit().getScreenSize();
		 this.setLayout(new GridLayout(6,1));
		    this.setSize(400,300);
		    this.setOpaque(true);
		    this.setBackground(new Color(13, 134, 145,123));
		
		   changeActiveFighterComboBox = new JComboBox();
		   changeActiveFighterComboBox.setSize(300,80);
		   changeActiveFighterComboBox.setVisible(true);
		   this.add(changeActiveFighterComboBox);
		   changeActiveFighterComboBox.addActionListener(this);
		   
		   set = new JButton("Set");
			set.setFont(new Font("Broadway", Font.BOLD, 25));
			set.setSize(200, 50);
			set.setForeground(Color.GREEN);
			set.setVisible(true);
			set.addActionListener(this);
			set.setBackground(Color.WHITE);
			this.add(set);
			set.addActionListener(this);
			
			this.setVisible(true);
			this.repaint();
			this.validate();
	}
	public void setMainFrameGUI(MainFrameGUI mainFrameGUI) {
		this.mainFrameGUI = mainFrameGUI;
	}
	public JComboBox getChangeActiveFighterComboBox() {
		return changeActiveFighterComboBox;
	}
	public MainFrameGUI getMainFrameGUI() {
		return mainFrameGUI;
	}
	
	public JButton getSet() {
		return set;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		mainFrameGUI.actionPerformed(e);
		
	}

}
