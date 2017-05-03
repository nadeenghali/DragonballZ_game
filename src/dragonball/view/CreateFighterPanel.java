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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dragonball.controller.MainFrameGUI;

public class CreateFighterPanel extends JPanel implements ActionListener{
	public JLabel getFighterName() {
		return fighterName;
	}

	public JTextField getTextField() {
		return textField;
	}

	public JComboBox getFighterList() {
		return fighterList;
	}

	public String[] getFighterNames() {
		return fighterNames;
	}

	public JLabel getFighterType() {
		return fighterType;
	}

	

	private JLabel fighterName;
	private  JTextField textField;
	private JComboBox fighterList;
	private String[] fighterNames;
	private JLabel fighterType;
	private Dimension y;
	private MainFrameGUI mainFrameGUI;
	private JButton create;
	
	public CreateFighterPanel(){
		y=Toolkit.getDefaultToolkit().getScreenSize();
		 this.setLayout(new GridLayout(6,1));
		    this.setSize(400,300);
		    this.setOpaque(true);
		    this.setBackground(new Color(13, 134, 145,123));
		    
		
		fighterName= new JLabel();
		fighterName.setText(" Name: ");
		fighterName.setFont(new Font("Broadway", Font.BOLD, 25));
		fighterName.setForeground(Color.WHITE);
		fighterName.setOpaque(false);
		fighterName.setVisible(true);
		fighterName.setSize(600,70);
		this.add(fighterName);
		
		textField = new JTextField(10);
		textField.setFont(new Font("Broadway", Font.BOLD, 25));
		textField.setSize(300, 50);
		this.add(textField);
		textField.setVisible(true);
		
		fighterName= new JLabel();
		fighterName.setText(" Type: ");
		fighterName.setFont(new Font("Broadway", Font.BOLD, 25));
		fighterName.setForeground(Color.WHITE);
		fighterName.setOpaque(false);
		fighterName.setVisible(true);
		fighterName.setSize(600,70);
		this.add(fighterName);
		
		String [] fighterNames1 =  { "Earthling", "Frieza", "Majin", "Namekian", "Saiyan" };
		fighterNames =fighterNames1;
		fighterList = new JComboBox(fighterNames);
		fighterList.setLocation((int) ((y.getWidth()-150)/2)-280,((int) ((y.getHeight()-150)/2))-300);
		fighterList.setVisible(true);
		fighterList.setSize(200,50);
		this.add(fighterList);
		//fighterList.addActionListener(this);
		
		create = new JButton("Create");
		create.setFont(new Font("Broadway", Font.BOLD, 25));
		create.setSize(200, 50);
		create.setForeground(Color.GREEN);
		create.setVisible(true);
		create.addActionListener(this);
		create.setBackground(Color.WHITE);
		this.add(create);
		create.addActionListener(this);
		
		this.setVisible(true);
		this.repaint();
		this.validate();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if((textField.getText().equals(""))){}else{
		mainFrameGUI.actionPerformed(e);}
		
		
	}

	public MainFrameGUI getMainFrameGUI() {
		return mainFrameGUI;
	}

	public void setMainFrameGUI(MainFrameGUI mainFrameGUI) {
		this.mainFrameGUI = mainFrameGUI;
	}

	public JButton getCreate() {
		return create;
	}

	public void setCreate(JButton create) {
		this.create = create;
	}
}
