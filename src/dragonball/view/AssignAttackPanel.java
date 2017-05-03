package dragonball.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dragonball.controller.MainFrameGUI;

public class AssignAttackPanel extends JPanel implements ActionListener {
	
private JComboBox listOfFighterAttacks;
private JComboBox listOfPlayerAttacks;
private JLabel oldAttack;
private JLabel newAttack;
private JButton assign;
private MainFrameGUI mainFrameGUI;
private JButton superAttack;
private JButton ultimateAttack;

public MainFrameGUI getMainFrameGUI() {
	return mainFrameGUI;
}

public void setMainFrameGUI(MainFrameGUI mainFrameGUI) {
	this.mainFrameGUI = mainFrameGUI;
}

public JComboBox getListOfFighterAttacks() {
	return listOfFighterAttacks;
}

public JComboBox getListOfPlayerAttacks() {
	return listOfPlayerAttacks;
}

public JLabel getOldAttack() {
	return oldAttack;
}

public JLabel getNewAttack() {
	return newAttack;
}

public JButton getAssign() {
	return assign;
}

public AssignAttackPanel(){
	this.setLayout(new GridLayout(7,1));
    this.setSize(400,300);
    this.setOpaque(true);
    this.setBackground(new Color(13, 134, 145,123));
    
    superAttack = new JButton("SUPER ATTACK");
	superAttack.setFont(new Font("Broadway", Font.BOLD, 25));
	superAttack.setSize(200, 50);
	superAttack.setForeground(Color.BLUE);
	superAttack.setVisible(true);
	superAttack.addActionListener(this);
	//assign.setBackground(Color.WHITE);
	this.add(superAttack);
	superAttack.setVisible(true);
	
	ultimateAttack = new JButton("ULTIMATE ATTACK");
	ultimateAttack.setFont(new Font("Broadway", Font.BOLD, 25));
	ultimateAttack.setSize(200, 50);
	ultimateAttack.setForeground(Color.BLUE);
	ultimateAttack.setVisible(true);
	ultimateAttack.addActionListener(this);
	//assign.setBackground(Color.WHITE);
	this.add(ultimateAttack);
	ultimateAttack.setVisible(true);
	
	oldAttack= new JLabel(" Choose Attack to replace:");
	oldAttack.setFont(new Font("Broadway", Font.BOLD, 25));
	oldAttack.setForeground(Color.WHITE);
	oldAttack.setOpaque(false);
	oldAttack.setVisible(false);
	oldAttack.setSize(600,70);
	this.add(oldAttack);
	
	listOfFighterAttacks= new JComboBox();
	listOfFighterAttacks.setSize(300,80);
	listOfFighterAttacks.addItem(null);
	listOfFighterAttacks.setVisible(false);
	this.add(listOfFighterAttacks);
	//listOfFighterAttacks.addActionListener(this);
	   
	   newAttack= new JLabel(" Choose new Attack:");
	   newAttack.setFont(new Font("Broadway", Font.BOLD, 25));
	   newAttack.setForeground(Color.WHITE);
	   newAttack.setOpaque(false);
	   newAttack.setVisible(false);
		newAttack.setSize(600,70);
		this.add(newAttack);
		
		listOfPlayerAttacks= new JComboBox();
		listOfPlayerAttacks.setSize(300,80);
		   listOfPlayerAttacks.setVisible(false);
		   this.add(listOfPlayerAttacks);
		 //  listOfPlayerAttacks.addActionListener(this);
		   
		   assign = new JButton("ASSIGN");
			assign.setFont(new Font("Broadway", Font.BOLD, 25));
			assign.setSize(200, 50);
			assign.setForeground(Color.RED);
			assign.setVisible(true);
			assign.addActionListener(this);
			//assign.setBackground(Color.WHITE);
			this.add(assign);
			assign.addActionListener(this);
	   
			
			
	   this.repaint();
	   this.validate();
	   
}

public JButton getSuperAttack() {
	return superAttack;
}

public JButton getUltimateAttack() {
	return ultimateAttack;
}

@Override
public void actionPerformed(ActionEvent e) {
	mainFrameGUI.actionPerformed(e);
	
}


}
