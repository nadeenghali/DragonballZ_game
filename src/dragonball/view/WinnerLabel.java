package dragonball.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dragonball.controller.MainFrameGUI;
import dragonball.model.battle.Battle;
import dragonball.model.battle.BattleEvent;
import dragonball.model.character.fighter.Fighter;

public class WinnerLabel extends JLabel implements ActionListener{
	 private String winner="";
	 private JLabel text1; 
	 private JButton cont ;
	 private MainFrameGUI x;
			public WinnerLabel()
			{
				//x=controller;
				this.setLayout(null);
				this.setSize(500,500);
				/*if(be.getWinner()==((Battle)be.getSource()).getFoe())
				{
					winner="You Lost! ";
				}
				else{
					winner="You Won!";
				}*/
				text1=new JLabel();
				//text.setText(winner);
				text1.setSize(250,50);
				text1.setFont(new Font("Broadway", Font.BOLD, 40));
				text1.setLocation(150, 100);
				text1.setForeground(Color.WHITE);
				//text.setBackground(new Color(13, 134, 145,123));
				text1.setVisible(true);
				text1.setOpaque(false);
				this.add(text1);
				cont=new JButton();
				cont.setSize(300, 100);
				cont.setLocation(100,300);
				cont.setText("Continue");
				cont.setFont(new Font("Broadway", Font.BOLD, 30));
				cont.setVisible(true);
				cont.setBackground(new Color(13, 134, 145));
				cont.setForeground(Color.WHITE);
				cont.addActionListener(this);
				cont.setOpaque(true);
				cont.setBorderPainted(false);
				this.add(cont);
				this.setBackground(new Color(13, 134, 145,123));
				this.setOpaque(true);
				
				this.repaint();
				this.revalidate();
				this.setVisible(false);
				
				
			}
			public JLabel getText1() {
				return text1;
			}
			public String getWinner() {
				return winner;
			}
			
			public void setX(MainFrameGUI x) {
				this.x = x;
			}
			public JButton getCont() {
				return cont;
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				x.actionPerformed(e);
			}

}
