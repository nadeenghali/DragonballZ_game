package dragonball.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import dragonball.model.attack.PhysicalAttack;
import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.UltimateAttack;
import dragonball.model.battle.Battle;
import dragonball.model.battle.BattleEvent;
import dragonball.model.battle.BattleEventType;
import dragonball.model.cell.Collectible;
import dragonball.model.cell.CollectibleCell;
import dragonball.model.character.fighter.Earthling;
import dragonball.model.character.fighter.Fighter;
import dragonball.model.character.fighter.Frieza;
import dragonball.model.character.fighter.Majin;
import dragonball.model.character.fighter.Namekian;
import dragonball.model.character.fighter.NonPlayableFighter;
import dragonball.model.character.fighter.PlayableFighter;
import dragonball.model.character.fighter.Saiyan;
import dragonball.model.dragon.Dragon;
import dragonball.model.dragon.DragonWishType;
import dragonball.model.exceptions.DuplicateAttackException;
import dragonball.model.exceptions.MaximumAttacksLearnedException;
import dragonball.model.exceptions.MissingFieldException;
import dragonball.model.exceptions.NotASaiyanException;
import dragonball.model.exceptions.NotEnoughAbilityPointsException;
import dragonball.model.exceptions.NotEnoughKiException;
import dragonball.model.exceptions.NotEnoughSenzuBeansException;
import dragonball.model.exceptions.UnknownAttackTypeException;
import dragonball.model.game.Game;
import dragonball.model.game.GameListener;
import dragonball.view.BattlePanel;
import dragonball.view.DragonPanel;
import dragonball.view.MapPanel;
import dragonball.view.StartGamePanel;
import dragonball.view.WinnerLabel;



public class MainFrameGUI extends JFrame implements ActionListener, GameListener {
	private StartGamePanel startPanel;
	private MapPanel mapPanel;
	private BattlePanel battlePanel;
	private DragonPanel dragonPanel;
	private Dimension d;
	private Game game;
	private Battle battle;
	private Dragon dragon;
	private Boolean typeOfAttack ;
	
	private String lastSavedFile;

	
	public MainFrameGUI() throws MissingFieldException, UnknownAttackTypeException{
		
		game= new Game();
		game.setListener(this);
		lastSavedFile=game.getLastSavedFile();
		
		d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(d);
		this.setTitle("DragonBall");
		startPanel=new StartGamePanel();
		this.add(startPanel);
		startPanel.setVisible(true);
		
		mapPanel=new MapPanel();
		this.add(mapPanel);
		mapPanel.setVisible(false);
		mapPanel.setMainFrameGUI(this);
		
		mapPanel.getCreateFighterPanel().setMainFrameGUI(this);
		mapPanel.getChooseActiveFighterPanel().setMainFrameGUI(this);
		mapPanel.getUpgradePanel().setMainFrameGUI(this);
		mapPanel.getMovePanel().setMainFrameGUI(this);
		mapPanel.getSenzuFoundPanel().setMainFrameGUI(this);
		mapPanel.getDragonBallFoundPanel().setMainFrameGUI(this);
		mapPanel.getExceptionMessagePanel().setMainFrameGUI(this);
		mapPanel.getAssignAttackPanel().setMainFrameGUI(this);
		mapPanel.getWinnerLabel().setX(this);
		
		startPanel.getSb().setMainFrame(this);
		startPanel.getPlayerInfoPanel().setMainFrame(this);
		
		dragonPanel = new DragonPanel();
		this.add(dragonPanel);
		dragonPanel.setVisible(false);
		dragonPanel.setMainFrameGUI(this);
		
		battlePanel = new BattlePanel();
		this.add(battlePanel);
		battlePanel.setVisible(false);
		battlePanel.setMainFrameGUI(this);
		battlePanel.getExceptionKiMessagePanel().setMainFrameGUI(this);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		this.repaint();
		this.revalidate();


		
	}
	public StartGamePanel getStartPanel() {
		return startPanel;
	}

	public MapPanel getMapPanel() {
		return mapPanel;
	}

	public BattlePanel getBattlePanel() {
		return battlePanel;
	}

	public DragonPanel getDragonPanel() {
		return dragonPanel;
	}


	public Dimension getD() {
		return d;
	}

	 public static void main(String[] args) throws MissingFieldException, UnknownAttackTypeException {
		MainFrameGUI x= new MainFrameGUI();
		x.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		/*make sure when you add an if or else statement that it is in the BIG if statmenet that represents the panel you are in.
		for example all of the buttons that i check for which are in the startpanel are written in the if(startPanel.isVisible()==true)
		. the reason i used this "if" is so that i can have multiple buttons with the same name but in different panels without
		mixing up the action needed to be performed for each button*/
			
			
       if (source instanceof JButton) {
        	JButton button = (JButton) e.getSource();
        	
        //to check that all the buttons are in the start pannel
       if(startPanel.isVisible()==true){
    	   if(button.getText().equals("Saved Game")){
    		   try {
				game.load("saved_game.ser");
				startPanel.setVisible(false);
				
				mapPanel.getPlayerNameLabel().setText(" Welcome, "+game.getPlayer().getName());
				mapPanel.getSenzuBeansCollected().setText(" no. of Senzu Beans: "+game.getPlayer().getSenzuBeans());
				mapPanel.getDragonBallCollected().setText(" no. of Dragon Balls: "+game.getPlayer().getDragonBalls());
				mapPanel.getExploredMaps().setText(" no. of Explored Maps: "+game.getPlayer().getExploredMaps());
				mapPanel.getFighterNameLabel().setText(" Active Fighter: "+game.getPlayer().getActiveFighter().getName());
				//mapPanel.getFighterType().setText(" Fighter Type: "+fighterType);
				mapPanel.getFighterXpLabel().setText(" Xp: "+game.getPlayer().getActiveFighter().getXp());
				mapPanel.getFighterAbilityPointsLabel().setText(" Ability points: "+game.getPlayer().getActiveFighter().getAbilityPoints());
				mapPanel.getFighterLevelLabel().setText(" Level: "+game.getPlayer().getActiveFighter().getLevel());
				mapPanel.getChooseActiveFighterPanel().getChangeActiveFighterComboBox().addItem((String)startPanel.getPlayerInfoPanel().getTextField2().getText());
				Icon icon=((JButton)(mapPanel.getMap().getComponent(99))).getIcon();
				((JButton)(mapPanel.getMap().getComponent(99))).setIcon(null);
				int row=game.getWorld().getPlayerRow();
				int column=game.getWorld().getPlayerColumn();
				((JButton)(mapPanel.getMap().getComponent((10*row)+(column)))).setIcon(icon);
				
				
				this.mapPanel.setVisible(true);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		   
    		   
    	   }
    	   
		if(button.getText().equals("New Game")){
			startPanel.getStartPageLabel().add(startPanel.getPlayerInfoPanel());
			startPanel.getPlayerInfoPanel().setLocation((int) (d.getWidth()/2)-500,(int) (d.getHeight()/2)-250);
			startPanel.getPlayerInfoPanel().setVisible(true);
			//startPanel.add(startPanel.startPageLabel);
			startPanel.getSb().setVisible(false);
			this.add(startPanel);
			startPanel.setVisible(true);
			startPanel.getSb().setVisible(false);
		}else{
			if(button.getText().equals("Exit")){
				this.dispose();
				
			}else{
				if(button.getText().equals("Next")){
					
						this.startPanel.setVisible(false);
						game.getPlayer().setName(startPanel.getPlayerInfoPanel().getTextField().getText());
						mapPanel.getPlayerNameLabel().setText(" Welcome, "+game.getPlayer().getName());
						String fighterType = (String)startPanel.getPlayerInfoPanel().getFighterList().getSelectedItem();
						switch (fighterType) {
			    case "Earthling": game.getPlayer().createFighter('E', startPanel.getPlayerInfoPanel().getTextField2().getText());
	                     break;
	            case "Frieza":  game.getPlayer().createFighter('F', startPanel.getPlayerInfoPanel().getTextField2().getText());
	                     break;
	            case "Majin": game.getPlayer().createFighter('M', startPanel.getPlayerInfoPanel().getTextField2().getText());
	                     break;
	            case "Namekian": game.getPlayer().createFighter('N', startPanel.getPlayerInfoPanel().getTextField2().getText());
	                     break;
	            case "Saiyan":  game.getPlayer().createFighter('S', startPanel.getPlayerInfoPanel().getTextField2().getText());
	                     break;
						}
						
						mapPanel.getSenzuBeansCollected().setText(" no. of Senzu Beans: "+game.getPlayer().getSenzuBeans());
						mapPanel.getDragonBallCollected().setText(" no. of Dragon Balls: "+game.getPlayer().getDragonBalls());
						mapPanel.getExploredMaps().setText(" no. of Explored Maps: "+game.getPlayer().getExploredMaps());
						mapPanel.getFighterNameLabel().setText(" Active Fighter: "+game.getPlayer().getActiveFighter().getName());
						mapPanel.getFighterType().setText(" Fighter Type: "+fighterType);
						mapPanel.getFighterXpLabel().setText(" Xp: "+game.getPlayer().getActiveFighter().getXp());
						mapPanel.getFighterAbilityPointsLabel().setText(" Ability points: "+game.getPlayer().getActiveFighter().getAbilityPoints());
						mapPanel.getFighterLevelLabel().setText(" Level: "+game.getPlayer().getActiveFighter().getLevel());
						mapPanel.getChooseActiveFighterPanel().getChangeActiveFighterComboBox().addItem((String)startPanel.getPlayerInfoPanel().getTextField2().getText());
						this.mapPanel.setVisible(true);
					}
			}
		}
        }
         else{ 
        	 //to check all the buttons are in the map panel
        	if(mapPanel.isVisible()==true){
        		 if(button.getText().equals("SAVE & EXIT")){
          		   try {
      				game.save("saved_game.ser");
      				this.dispose();
      			} catch (IOException e1) {
      				// TODO Auto-generated catch block
      				e1.printStackTrace();
      			}
          	   }
        	
        		if(button.getText().equals("Continue"))
        		{
        			mapPanel.getWinnerLabel().setVisible(false);
        			mapPanel.getMap().setVisible(true);
        		}
						
        		
        		if(button.getText().equals("Create a Fighter")){
							mapPanel.getCreateFighterPanel().setVisible(true);
						}
						else{
							if(button.getText().equals("Create")){
								String text = (String)mapPanel.getCreateFighterPanel().getTextField().getText();
								mapPanel.getChooseActiveFighterPanel().getChangeActiveFighterComboBox().addItem(text);
								mapPanel.getCreateFighterPanel().setVisible(false);
								String fighterType = (String)mapPanel.getCreateFighterPanel().getFighterList().getSelectedItem();
								switch (fighterType) {
					    case "Earthling": game.getPlayer().createFighter('E', mapPanel.getCreateFighterPanel().getTextField().getText());
			                     break;
			            case "Frieza":  game.getPlayer().createFighter('F', mapPanel.getCreateFighterPanel().getTextField().getText());
			                     break;
			            case "Majin": game.getPlayer().createFighter('M', mapPanel.getCreateFighterPanel().getTextField().getText());
			                     break;
			            case "Namekian": game.getPlayer().createFighter('N', mapPanel.getCreateFighterPanel().getTextField().getText());
			                     break;
			            case "Saiyan":  game.getPlayer().createFighter('S',mapPanel.getCreateFighterPanel().getTextField().getText());
			                     break;
								}
								
								mapPanel.getCreateFighterPanel().getTextField().setText(null);
								
								
							}else{
								if(button.getText().equals("Change Fighter")){
									/*for(int i=0;i<game.getPlayer().getFighters().size();i++){
										mapPanel.getChangeActiveFighterComboBox().addItem((String)game.getPlayer().getFighters().get(i).getName());
										}*/
									
									mapPanel.getChooseActiveFighterPanel().setVisible(true);
								}
								
								
							
							else{if(button.getText().equals("Set")){
								mapPanel.getChooseActiveFighterPanel().setVisible(false);
								mapPanel.getChooseActiveFighter().setVisible(true);
								String fighterName= (String)mapPanel.getChooseActiveFighterPanel().getChangeActiveFighterComboBox().getSelectedItem();
								for(int i=0;i<game.getPlayer().getFighters().size();i++){
									if(game.getPlayer().getFighters().get(i).getName().equals(fighterName)){
										game.getPlayer().setActiveFighter(game.getPlayer().getFighters().get(i));
										break;
									}
								}
									//check type of the fighter
									String fighterType= "";
									if(game.getPlayer().getActiveFighter() instanceof Earthling){
										fighterType="Earthling";
									}else{if(game.getPlayer().getActiveFighter() instanceof Frieza){
										fighterType="Frieza";
									}else{if(game.getPlayer().getActiveFighter() instanceof Majin){
										fighterType="Majin";
									}else{if(game.getPlayer().getActiveFighter() instanceof Namekian){
										fighterType="Namekian";
									}else{if(game.getPlayer().getActiveFighter() instanceof Saiyan){
										fighterType="Saiyan";
									}
									}	
									}
									}
									}
									mapPanel.getFighterNameLabel().setText(" Active Fighter: "+fighterName);
									mapPanel.getFighterType().setText(" Fighter Type: "+fighterType);
									mapPanel.getFighterXpLabel().setText(" Xp: "+game.getPlayer().getActiveFighter().getXp());
									mapPanel.getFighterAbilityPointsLabel().setText(" Ability points: "+game.getPlayer().getActiveFighter().getAbilityPoints());
									mapPanel.getFighterLevelLabel().setText(" Level: "+game.getPlayer().getActiveFighter().getLevel());
								mapPanel.repaint();
								mapPanel.revalidate();
							}else{if(button.getText().equals("Upgrade Fighter")){
								mapPanel.getUpgradePanel().setVisible(true);
								mapPanel.getUpgradePanel().getMaxHealthPoints().setText(" maxHealthPoints: "+game.getPlayer().getActiveFighter().getMaxHealthPoints());
								mapPanel.getUpgradePanel().getPhysicalDamage().setText(" physicalDamage: "+game.getPlayer().getActiveFighter().getPhysicalDamage());
								mapPanel.getUpgradePanel().getBlastDamage().setText(" blastDamage: "+game.getPlayer().getActiveFighter().getBlastDamage());
								mapPanel.getUpgradePanel().getMaxKi().setText(" maxKi: "+game.getPlayer().getActiveFighter().getMaxKi());
								mapPanel.getUpgradePanel().getMaxStamina().setText(" maxStamina: "+game.getPlayer().getActiveFighter().getMaxStamina());
							}
								else{
									
								if(button.getText().equals("FINISH")){
									mapPanel.getUpgradePanel().setVisible(false);
									//after upgrading fighter, re-show fighter attributes becuase might have been changed(upgraded)
									mapPanel.getFighterXpLabel().setText(" Xp: "+game.getPlayer().getActiveFighter().getXp());
									mapPanel.getFighterAbilityPointsLabel().setText(" Ability points: "+game.getPlayer().getActiveFighter().getAbilityPoints());
									mapPanel.getFighterLevelLabel().setText(" Level: "+game.getPlayer().getActiveFighter().getLevel());
								mapPanel.repaint();
								mapPanel.revalidate();
								}
								else{
									if(button.getText().equals("CLOSE")){
									mapPanel.getDragonBallFoundPanel().setVisible(false);
									mapPanel.getSenzuFoundPanel().setVisible(false);
									mapPanel.getExceptionMessagePanel().setVisible(false);
									}
								
							else{
								if(button.getText().equals("Assign Attack")){
															
									mapPanel.getAssignAttackPanel().setVisible(true);}
									else{
										
										//false = super, true==ultimate
										if(button.getText().equals("SUPER ATTACK")){
											typeOfAttack=false;
												mapPanel.getAssignAttackPanel().getOldAttack().setVisible(true);
												mapPanel.getAssignAttackPanel().getListOfFighterAttacks().setVisible(true);
												mapPanel.getAssignAttackPanel().getNewAttack().setVisible(true);
												mapPanel.getAssignAttackPanel().getListOfPlayerAttacks().setVisible(true);
												mapPanel.getAssignAttackPanel().getSuperAttack().setVisible(false);
												mapPanel.getAssignAttackPanel().getUltimateAttack().setVisible(false);
												mapPanel.getAssignAttackPanel().getListOfFighterAttacks().removeAllItems();
												mapPanel.getAssignAttackPanel().getListOfPlayerAttacks().removeAllItems();
												//mapPanel.getAssignAttackPanel().getListOfFighterAttacks().addItem("");
												//game.getPlayer().getActiveFighter().getSuperAttacks().add(new SuperAttack("Bohsin dodo",100));
												for(int i=0;i<game.getPlayer().getActiveFighter().getSuperAttacks().size();i++){
													mapPanel.getAssignAttackPanel().getListOfFighterAttacks().addItem((String)game.getPlayer().getActiveFighter().getSuperAttacks().get(i).getName());
													
												}
													for(int i=0;i<game.getPlayer().getSuperAttacks().size();i++){
														mapPanel.getAssignAttackPanel().getListOfPlayerAttacks().addItem((String)game.getPlayer().getSuperAttacks().get(i).getName());
													}
													//mapPanel.getAssignAttackPanel().getListOfFighterAttacks().addItem("ba2laz");
													 mapPanel.repaint();
												       mapPanel.validate();
									
										}else{
										if(button.getText().equals("ULTIMATE ATTACK")){
											typeOfAttack=true;
											System.out.println(typeOfAttack);
												mapPanel.getAssignAttackPanel().getOldAttack().setVisible(true);
												mapPanel.getAssignAttackPanel().getListOfFighterAttacks().setVisible(true);
												mapPanel.getAssignAttackPanel().getNewAttack().setVisible(true);
												mapPanel.getAssignAttackPanel().getListOfPlayerAttacks().setVisible(true);
												mapPanel.getAssignAttackPanel().getSuperAttack().setVisible(false);
												mapPanel.getAssignAttackPanel().getUltimateAttack().setVisible(false);
												mapPanel.getAssignAttackPanel().getListOfFighterAttacks().removeAllItems();
												mapPanel.getAssignAttackPanel().getListOfPlayerAttacks().removeAllItems();
												//mapPanel.getAssignAttackPanel().getListOfFighterAttacks().addItem("");
												for(int i=0;i<game.getPlayer().getActiveFighter().getUltimateAttacks().size();i++){
													mapPanel.getAssignAttackPanel().getListOfFighterAttacks().addItem((String)game.getPlayer().getActiveFighter().getUltimateAttacks().get(i).getName());
													}
													for(int i=0;i<game.getPlayer().getUltimateAttacks().size();i++){
														mapPanel.getAssignAttackPanel().getListOfPlayerAttacks().addItem((String)game.getPlayer().getUltimateAttacks().get(i).getName());
													}
												mapPanel.repaint();
											       mapPanel.validate();
										}
										
									}
									}	
							//	System.out.print("hh");
								
									if(button.getText().equals("ASSIGN")){
										//System.out.println("lol yahbal");
										if((mapPanel.getAssignAttackPanel().getListOfPlayerAttacks().getSelectedItem()!=null)){
										
											//System.out.println("ahbal");
											if(typeOfAttack==false){
										//	System.out.println("lol ahbal");
											SuperAttack playerAttack = null ;
											SuperAttack fighterAttack = null ;
											if(mapPanel.getAssignAttackPanel().getListOfFighterAttacks().getSelectedItem()!=""){
											for(int i=0;i<game.getPlayer().getActiveFighter().getSuperAttacks().size();i++){
												if(mapPanel.getAssignAttackPanel().getListOfFighterAttacks().getSelectedItem().equals(game.getPlayer().getActiveFighter().getSuperAttacks().get(i).getName()))
												{
													fighterAttack=game.getPlayer().getActiveFighter().getSuperAttacks().get(i);
													//break;
												}
											
											}
											}
												for(int i=0;i<game.getPlayer().getSuperAttacks().size();i++){
													if(mapPanel.getAssignAttackPanel().getListOfPlayerAttacks().getSelectedItem().equals(game.getPlayer().getSuperAttacks().get(i).getName()))
													{
														playerAttack=game.getPlayer().getSuperAttacks().get(i);
														//break;
													}
												}
											
											try {
												
											
												game.getPlayer().assignAttack(game.getPlayer().getActiveFighter(), playerAttack, fighterAttack);
												//typeOfAttack=true;
											} catch (
													MaximumAttacksLearnedException
													| DuplicateAttackException
													| NotASaiyanException o) {
												mapPanel.getExceptionMessagePanel().getExceptionMessage().setText(o.getMessage());
												mapPanel.getExceptionMessagePanel().setVisible(true);
											}
											
										}
										if(typeOfAttack==true){
											
											UltimateAttack playerUAttack = null;
											UltimateAttack fighterUAttack = null;
											if(mapPanel.getAssignAttackPanel().getListOfFighterAttacks().getSelectedItem()!=""){
											for(int i=0;i<game.getPlayer().getActiveFighter().getUltimateAttacks().size();i++){
												if(mapPanel.getAssignAttackPanel().getListOfFighterAttacks().getSelectedItem().equals(game.getPlayer().getActiveFighter().getUltimateAttacks().get(i).getName()))
												{
													fighterUAttack=game.getPlayer().getActiveFighter().getUltimateAttacks().get(i);
													break;
												}
											
											}}
												for(int i=0;i<game.getPlayer().getUltimateAttacks().size();i++){
													if(mapPanel.getAssignAttackPanel().getListOfPlayerAttacks().getSelectedItem().equals(game.getPlayer().getUltimateAttacks().get(i).getName()))
													{
														playerUAttack=game.getPlayer().getUltimateAttacks().get(i);
														break;
													}
												}
											
											try {
												game.getPlayer().assignAttack(game.getPlayer().getActiveFighter(), playerUAttack, fighterUAttack);
											} catch (
													MaximumAttacksLearnedException
													| DuplicateAttackException
													| NotASaiyanException o) {
												mapPanel.getExceptionMessagePanel().getExceptionMessage().setText(o.getMessage());
												mapPanel.getExceptionMessagePanel().setVisible(true);
											}
											
										}
											
										}
										mapPanel.getAssignAttackPanel().setVisible(false);
										mapPanel.getAssignAttackPanel().getOldAttack().setVisible(false);
										mapPanel.getAssignAttackPanel().getListOfFighterAttacks().setVisible(false);
										mapPanel.getAssignAttackPanel().getNewAttack().setVisible(false);
										mapPanel.getAssignAttackPanel().getListOfPlayerAttacks().setVisible(false);
										mapPanel.getAssignAttackPanel().getSuperAttack().setVisible(true);
										mapPanel.getAssignAttackPanel().getUltimateAttack().setVisible(true);
										
									//	game.getPlayer().assignAttack(game.getPlayer().getActiveFighter(), , oldAttack);
									
								}
								
								switch(button.getText()){
								case"UP":if(game.getWorld().getPlayerRow()-1>=0){ 
									mapPanel.getArrayOfButtons()[game.getWorld().getPlayerRow()][game.getWorld().getPlayerColumn()].setIcon(null);
									mapPanel.getArrayOfButtons()[game.getWorld().getPlayerRow()-1][game.getWorld().getPlayerColumn()].setIcon(mapPanel.getPlayerImage());
									}
									game.getWorld().moveUp();
									mapPanel.getSenzuBeansCollected().setText(" no. of Senzu Beans: "+game.getPlayer().getSenzuBeans());
									mapPanel.getDragonBallCollected().setText(" no. of Dragon Balls: "+game.getPlayer().getDragonBalls());
									mapPanel.getExploredMaps().setText(" no. of Explored Maps: "+game.getPlayer().getExploredMaps());
									mapPanel.repaint();
									mapPanel.revalidate();
									
									break;
								case"DOWN":if(game.getWorld().getPlayerRow()+1<=9){
									mapPanel.getArrayOfButtons()[game.getWorld().getPlayerRow()][game.getWorld().getPlayerColumn()].setIcon(null);
								mapPanel.getArrayOfButtons()[game.getWorld().getPlayerRow()+1][game.getWorld().getPlayerColumn()].setIcon(mapPanel.getPlayerImage());
								}
								game.getWorld().moveDown();
								mapPanel.getSenzuBeansCollected().setText(" no. of Senzu Beans: "+game.getPlayer().getSenzuBeans());
								mapPanel.getDragonBallCollected().setText(" no. of Dragon Balls: "+game.getPlayer().getDragonBalls());
								mapPanel.getExploredMaps().setText(" no. of Explored Maps: "+game.getPlayer().getExploredMaps());
								mapPanel.repaint();
								mapPanel.revalidate();
									
									break;
								case"LEFT":if(game.getWorld().getPlayerColumn()-1>=0){
									mapPanel.getArrayOfButtons()[game.getWorld().getPlayerRow()][game.getWorld().getPlayerColumn()].setIcon(null);
								mapPanel.getArrayOfButtons()[game.getWorld().getPlayerRow()][game.getWorld().getPlayerColumn()-1].setIcon(mapPanel.getPlayerImage());
								}
								game.getWorld().moveLeft();
								mapPanel.getSenzuBeansCollected().setText(" no. of Senzu Beans: "+game.getPlayer().getSenzuBeans());
								mapPanel.getDragonBallCollected().setText(" no. of Dragon Balls: "+game.getPlayer().getDragonBalls());
								mapPanel.getExploredMaps().setText(" no. of Explored Maps: "+game.getPlayer().getExploredMaps());
								mapPanel.repaint();
								mapPanel.revalidate();
									
									break;
								case"RIGHT":if(game.getWorld().getPlayerColumn()+1<=9){
									mapPanel.getArrayOfButtons()[game.getWorld().getPlayerRow()][game.getWorld().getPlayerColumn()].setIcon(null);
								mapPanel.getArrayOfButtons()[game.getWorld().getPlayerRow()][game.getWorld().getPlayerColumn()+1].setIcon(mapPanel.getPlayerImage());
								}
								game.getWorld().moveRight();
								mapPanel.getSenzuBeansCollected().setText(" no. of Senzu Beans: "+game.getPlayer().getSenzuBeans());
								mapPanel.getDragonBallCollected().setText(" no. of Dragon Balls: "+game.getPlayer().getDragonBalls());
								mapPanel.getExploredMaps().setText(" no. of Explored Maps: "+game.getPlayer().getExploredMaps());
								mapPanel.repaint();
								mapPanel.revalidate();
								break;
								}
								
								switch(button.getText()){
								
								case "upMaxHealthPoints":
									//show the message of exception not enough ability points
									try{
										game.getPlayer().upgradeFighter(game.getPlayer().getActiveFighter(), 'H');
										}catch(NotEnoughAbilityPointsException a){
											mapPanel.getExceptionMessagePanel().getExceptionMessage().setText(a.getMessage());
											mapPanel.getExceptionMessagePanel().setVisible(true);
										}
									mapPanel.getUpgradePanel().getMaxHealthPoints().setText(" maxHealthPoints: "+game.getPlayer().getActiveFighter().getMaxHealthPoints());
									mapPanel.getUpgradePanel().getPhysicalDamage().setText(" physicalDamage: "+game.getPlayer().getActiveFighter().getPhysicalDamage());
									mapPanel.getUpgradePanel().getBlastDamage().setText(" blastDamage: "+game.getPlayer().getActiveFighter().getBlastDamage());
									mapPanel.getUpgradePanel().getMaxKi().setText(" maxKi: "+game.getPlayer().getActiveFighter().getMaxKi());
									mapPanel.getUpgradePanel().getMaxStamina().setText(" maxStamina: "+game.getPlayer().getActiveFighter().getMaxStamina());
									mapPanel.repaint();
									mapPanel.revalidate();
									break;
								case "upPhysicalDamage":
									//show the message of exception not enough ability points
									try{
										game.getPlayer().upgradeFighter(game.getPlayer().getActiveFighter(), 'P');
										}catch(NotEnoughAbilityPointsException a){
											mapPanel.getExceptionMessagePanel().getExceptionMessage().setText(a.getMessage());
											mapPanel.getExceptionMessagePanel().setVisible(true);
										}
									mapPanel.getUpgradePanel().getMaxHealthPoints().setText(" maxHealthPoints: "+game.getPlayer().getActiveFighter().getMaxHealthPoints());
									mapPanel.getUpgradePanel().getPhysicalDamage().setText(" physicalDamage: "+game.getPlayer().getActiveFighter().getPhysicalDamage());
									mapPanel.getUpgradePanel().getBlastDamage().setText(" blastDamage: "+game.getPlayer().getActiveFighter().getBlastDamage());
									mapPanel.getUpgradePanel().getMaxKi().setText(" maxKi: "+game.getPlayer().getActiveFighter().getMaxKi());
									mapPanel.getUpgradePanel().getMaxStamina().setText(" maxStamina: "+game.getPlayer().getActiveFighter().getMaxStamina());
									mapPanel.repaint();
									mapPanel.revalidate();
									break;
								case "upBlastDamage":
										try{
										game.getPlayer().upgradeFighter(game.getPlayer().getActiveFighter(), 'B');
										}catch(NotEnoughAbilityPointsException a){
											mapPanel.getExceptionMessagePanel().getExceptionMessage().setText(a.getMessage());
											mapPanel.getExceptionMessagePanel().setVisible(true);
										}
										mapPanel.getUpgradePanel().getMaxHealthPoints().setText(" maxHealthPoints: "+game.getPlayer().getActiveFighter().getMaxHealthPoints());
										mapPanel.getUpgradePanel().getPhysicalDamage().setText(" physicalDamage: "+game.getPlayer().getActiveFighter().getPhysicalDamage());
										mapPanel.getUpgradePanel().getBlastDamage().setText(" blastDamage: "+game.getPlayer().getActiveFighter().getBlastDamage());
										mapPanel.getUpgradePanel().getMaxKi().setText(" maxKi: "+game.getPlayer().getActiveFighter().getMaxKi());
										mapPanel.getUpgradePanel().getMaxStamina().setText(" maxStamina: "+game.getPlayer().getActiveFighter().getMaxStamina());
										mapPanel.repaint();
										mapPanel.revalidate();
									break;
								case "upMaxKi":
									try{
										game.getPlayer().upgradeFighter(game.getPlayer().getActiveFighter(), 'K');
										}catch(NotEnoughAbilityPointsException a){
											mapPanel.getExceptionMessagePanel().getExceptionMessage().setText(a.getMessage());
											mapPanel.getExceptionMessagePanel().setVisible(true);
										}
									mapPanel.getUpgradePanel().getMaxHealthPoints().setText(" maxHealthPoints: "+game.getPlayer().getActiveFighter().getMaxHealthPoints());
									mapPanel.getUpgradePanel().getPhysicalDamage().setText(" physicalDamage: "+game.getPlayer().getActiveFighter().getPhysicalDamage());
									mapPanel.getUpgradePanel().getBlastDamage().setText(" blastDamage: "+game.getPlayer().getActiveFighter().getBlastDamage());
									mapPanel.getUpgradePanel().getMaxKi().setText(" maxKi: "+game.getPlayer().getActiveFighter().getMaxKi());
									mapPanel.getUpgradePanel().getMaxStamina().setText(" maxStamina: "+game.getPlayer().getActiveFighter().getMaxStamina());
									mapPanel.repaint();
									mapPanel.revalidate();
									break;
								case "upMaxStamina":
									try{
										game.getPlayer().upgradeFighter(game.getPlayer().getActiveFighter(), 'S');
										}catch(NotEnoughAbilityPointsException a){
											mapPanel.getExceptionMessagePanel().getExceptionMessage().setText(a.getMessage());
											mapPanel.getExceptionMessagePanel().setVisible(true);
										}
									mapPanel.getUpgradePanel().getMaxHealthPoints().setText(" maxHealthPoints: "+game.getPlayer().getActiveFighter().getMaxHealthPoints());
									mapPanel.getUpgradePanel().getPhysicalDamage().setText(" physicalDamage: "+game.getPlayer().getActiveFighter().getPhysicalDamage());
									mapPanel.getUpgradePanel().getBlastDamage().setText(" blastDamage: "+game.getPlayer().getActiveFighter().getBlastDamage());
									mapPanel.getUpgradePanel().getMaxKi().setText(" maxKi: "+game.getPlayer().getActiveFighter().getMaxKi());
									mapPanel.getUpgradePanel().getMaxStamina().setText(" maxStamina: "+game.getPlayer().getActiveFighter().getMaxStamina());
									mapPanel.repaint();
									mapPanel.revalidate();
									break;
								}
								
								}
								}
							}
						}
					}
					
							
			}
		}
	}
	
       if(battlePanel.isVisible()==true){
   		if(button.getText().equals("CLOSE")){
   			
   			battlePanel.getExceptionKiMessagePanel().setVisible(false);
   			}
    	   
    	   if(button.getText().equals("ATTACK")){
    	String attackName =(String)battlePanel.getChooseAttack().getSelectedItem();
    	if(attackName.equals("Physical Attack")){
    		try{
    		battle.attack(new PhysicalAttack());}
    		catch(NotEnoughKiException k){
    			
    			
				
			}
    	}else{
    	for(int i=0;i<game.getPlayer().getActiveFighter().getSuperAttacks().size();i++){
			if(attackName.equals(game.getPlayer().getActiveFighter().getSuperAttacks().get(i).getName())){
				try{
				battle.attack(game.getPlayer().getActiveFighter().getSuperAttacks().get(i));
				}catch(NotEnoughKiException k){
					if(battle.getAttacker().equals(battle.getMe())){
					battlePanel.getExceptionKiMessagePanel().getExceptionMessage().setText(k.getMessage());
					battlePanel.getExceptionKiMessagePanel().setVisible(true);}
				}
				//break;
			}
			}
    	for(int i=0;i<game.getPlayer().getActiveFighter().getUltimateAttacks().size();i++){
			if(attackName.equals(game.getPlayer().getActiveFighter().getUltimateAttacks().get(i).getName())){
				try{
				battle.attack(game.getPlayer().getActiveFighter().getUltimateAttacks().get(i));
				}catch(NotEnoughKiException k){
					if(battle.getAttacker().equals(battle.getMe())){
					battlePanel.getExceptionKiMessagePanel().getExceptionMessage().setText(k.getMessage());
					battlePanel.getExceptionKiMessagePanel().setVisible(true);}
				}
			//	break;
			}
			}
    	
    
    	}
    	
    	try{
			battle.play();
		//	battle.endTurn();
			}catch(NotEnoughKiException d){}
			
    	
    	
    	   }else{
				if(button.getText().equals("USE")){
					try {
						battle.use(game.getPlayer(),Collectible.SENZU_BEAN);
						try{
							battle.play();
						//	battle.endTurn();
							}catch(NotEnoughKiException d){}
							
							
						
					} catch (NotEnoughSenzuBeansException t) {
						battlePanel.getExceptionKiMessagePanel().getExceptionMessage().setText(t.getMessage());
						battlePanel.getExceptionKiMessagePanel().setVisible(true);
					}
				}
				else{
					if(button.getText().equals("BLOCK")){
						battle.block();
						try{
							battle.play();
						//	battle.endTurn();
							}catch(NotEnoughKiException d){}
							
							
						
					}
				}
			}
    	   
    	   
    	   
    	   
       }
	}if(this.dragonPanel.isVisible()==true){
		if(button.getText().equals("Senzu Beans")){
			for(int i=0;i<dragon.getWishes().length;i++){
				
			if(dragon.getWishes()[i].getType().equals(DragonWishType.SENZU_BEANS)){
			game.getPlayer().chooseWish(dragon.getWishes()[i]);
			mapPanel.getSenzuBeansCollected().setText(" no. of Senzu Beans: "+game.getPlayer().getSenzuBeans());
			mapPanel.getDragonBallCollected().setText(" no. of Dragon Balls: "+game.getPlayer().getDragonBalls());
			mapPanel.getExploredMaps().setText(" no. of Explored Maps: "+game.getPlayer().getExploredMaps());
			mapPanel.getFighterNameLabel().setText(" Active Fighter: "+game.getPlayer().getActiveFighter().getName());
			mapPanel.getFighterXpLabel().setText(" Xp: "+game.getPlayer().getActiveFighter().getXp());
			mapPanel.getFighterAbilityPointsLabel().setText(" Ability points: "+game.getPlayer().getActiveFighter().getAbilityPoints());
			mapPanel.getFighterLevelLabel().setText(" Level: "+game.getPlayer().getActiveFighter().getLevel());

			
			mapPanel.repaint();
			mapPanel.revalidate();
			mapPanel.setVisible(true);
			this.dragonPanel.setVisible(false);
			break;
			
			}
			}
			
		}else{if(button.getText().equals("Ability Points")){
			for(int i=0;i<dragon.getWishes().length;i++){
				
				if(dragon.getWishes()[i].getType().equals(DragonWishType.ABILITY_POINTS)){
				game.getPlayer().chooseWish(dragon.getWishes()[i]);
				mapPanel.getSenzuBeansCollected().setText(" no. of Senzu Beans: "+game.getPlayer().getSenzuBeans());
				mapPanel.getDragonBallCollected().setText(" no. of Dragon Balls: "+game.getPlayer().getDragonBalls());
				mapPanel.getExploredMaps().setText(" no. of Explored Maps: "+game.getPlayer().getExploredMaps());
				mapPanel.getFighterNameLabel().setText(" Active Fighter: "+game.getPlayer().getActiveFighter().getName());
				mapPanel.getFighterXpLabel().setText(" Xp: "+game.getPlayer().getActiveFighter().getXp());
				mapPanel.getFighterAbilityPointsLabel().setText(" Ability points: "+game.getPlayer().getActiveFighter().getAbilityPoints());
				mapPanel.getFighterLevelLabel().setText(" Level: "+game.getPlayer().getActiveFighter().getLevel());

				
				mapPanel.repaint();
				mapPanel.revalidate();
				mapPanel.setVisible(true);
				this.dragonPanel.setVisible(false);
				break;
				
				}
				}
			
		}else{if(button.getText().equals("Super Attack")){
for(int i=0;i<dragon.getWishes().length;i++){
				
				if(dragon.getWishes()[i].getType().equals(DragonWishType.SUPER_ATTACK)){
				game.getPlayer().chooseWish(dragon.getWishes()[i]);
				mapPanel.getSenzuBeansCollected().setText(" no. of Senzu Beans: "+game.getPlayer().getSenzuBeans());
				mapPanel.getDragonBallCollected().setText(" no. of Dragon Balls: "+game.getPlayer().getDragonBalls());
				mapPanel.getExploredMaps().setText(" no. of Explored Maps: "+game.getPlayer().getExploredMaps());
				mapPanel.getFighterNameLabel().setText(" Active Fighter: "+game.getPlayer().getActiveFighter().getName());
				mapPanel.getFighterXpLabel().setText(" Xp: "+game.getPlayer().getActiveFighter().getXp());
				mapPanel.getFighterAbilityPointsLabel().setText(" Ability points: "+game.getPlayer().getActiveFighter().getAbilityPoints());
				mapPanel.getFighterLevelLabel().setText(" Level: "+game.getPlayer().getActiveFighter().getLevel());

				
				mapPanel.repaint();
				mapPanel.revalidate();
				mapPanel.setVisible(true);
				this.dragonPanel.setVisible(false);
				break;
				
				}
				}
			
		}else{if(button.getText().equals("Ulitmate Attack")){
for(int i=0;i<dragon.getWishes().length;i++){
				
				if(dragon.getWishes()[i].getType().equals(DragonWishType.ULTIMATE_ATTACK)){
				game.getPlayer().chooseWish(dragon.getWishes()[i]);
				mapPanel.getSenzuBeansCollected().setText(" no. of Senzu Beans: "+game.getPlayer().getSenzuBeans());
				mapPanel.getDragonBallCollected().setText(" no. of Dragon Balls: "+game.getPlayer().getDragonBalls());
				mapPanel.getExploredMaps().setText(" no. of Explored Maps: "+game.getPlayer().getExploredMaps());
				mapPanel.getFighterNameLabel().setText(" Active Fighter: "+game.getPlayer().getActiveFighter().getName());
				mapPanel.getFighterXpLabel().setText(" Xp: "+game.getPlayer().getActiveFighter().getXp());
				mapPanel.getFighterAbilityPointsLabel().setText(" Ability points: "+game.getPlayer().getActiveFighter().getAbilityPoints());
				mapPanel.getFighterLevelLabel().setText(" Level: "+game.getPlayer().getActiveFighter().getLevel());

				
				mapPanel.repaint();
				mapPanel.revalidate();
				mapPanel.setVisible(true);
				this.dragonPanel.setVisible(false);
				break;
				
				}
				}
			
		}
			
		}
			
		}
			
		}
		
		
		
	
		
		
		
	}
       
       
       }
      
	}
        
        
		
		
	

	@Override
	public void onDragonCalled(Dragon dragon) {
		this.dragon=dragon;
		mapPanel.setVisible(false);
		this.dragonPanel.setVisible(true);
		
	}

	@Override
	public void onCollectibleFound(Collectible collectible) {
		if(collectible.equals(collectible.SENZU_BEAN)){
			mapPanel.getSenzuFoundPanel().setVisible(true);
		}
		if(collectible.equals(collectible.DRAGON_BALL)){
			mapPanel.getDragonBallFoundPanel().setVisible(true);
		}
		
	}

	@Override
	public void onBattleEvent(BattleEvent e) {
		Battle b =(Battle) e.getSource();
		this.battle=b;
		NonPlayableFighter foe=(NonPlayableFighter)battle.getFoe();
		String attackerName=((Fighter)battle.getAttacker()).getName();
		String defenderName=((Fighter)battle.getDefender()).getName();
	
		battlePanel.getTurnIndicator().setText("It's "+"Fighter "+attackerName+"'s turn");
		 //  turnIndicator.setSize(500,60);
		 //  turnIndicator.setFont(new Font("Broadway", Font.BOLD, 20));
		 //  turnIndicator.setLocation( battlePanel.getBackg().getWidth()-1130, 80);
		 //  battlePanel.getBackg().add(turnIndicator);
		
		
		
		   
	if(e.getType().equals(BattleEventType.STARTED)){
		battlePanel.getChooseAttack().removeAllItems();
		for(int i =0;i<battle.getAssignedAttacks().size();i++){
			battlePanel.getChooseAttack().addItem((String)battle.getAssignedAttacks().get(i).getName());
		}
		/*for(int i=0;i<game.getPlayer().getActiveFighter().getSuperAttacks().size();i++){
			battlePanel.getChooseAttack().addItem((String)game.getPlayer().getActiveFighter().getSuperAttacks().get(i).getName());
		}
		for(int i=0;i<game.getPlayer().getActiveFighter().getUltimateAttacks().size();i++){
			battlePanel.getChooseAttack().addItem((String)game.getPlayer().getActiveFighter().getUltimateAttacks().get(i).getName());
		}*/
		//battlePanel.getChooseAttack().addItem("Physical Attack");
		battlePanel.getPlayerFighterName().setText(game.getPlayer().getActiveFighter().getName());
		battlePanel.getPlayerFighterHp().setMaximum(game.getPlayer().getActiveFighter().getMaxHealthPoints());
		battlePanel.getPlayerFighterHp().setValue(game.getPlayer().getActiveFighter().getMaxHealthPoints());
		battlePanel.getPlayerFighterStamina().setMaximum(game.getPlayer().getActiveFighter().getMaxStamina());
		battlePanel.getPlayerFighterStamina().setValue(game.getPlayer().getActiveFighter().getMaxStamina());
		battlePanel.getPlayerFigherKi().setMaximum(game.getPlayer().getActiveFighter().getMaxKi());
		battlePanel.getPlayerFigherKi().setValue(game.getPlayer().getActiveFighter().getKi());
		
		battlePanel.getFoeName().setText(foe.getName());
		battlePanel.getFoeHp().setMaximum(foe.getMaxHealthPoints());
		battlePanel.getFoeHp().setValue(foe.getHealthPoints());
		battlePanel.getFoeStamina().setMaximum(foe.getMaxStamina());
		battlePanel.getFoeStamina().setValue(foe.getStamina());
		battlePanel.getFoeKi().setMaximum(foe.getMaxKi());
		battlePanel.getFoeKi().setValue(foe.getKi());
	//	System.out.println(foe.getKi());
		mapPanel.setVisible(false);
		
		//battle.getFoe().
		
		this.battlePanel.setVisible(true);}

	
	
		battlePanel.getPlayerFighterHp().setValue(game.getPlayer().getActiveFighter().getHealthPoints());
		battlePanel.getPlayerFighterStamina().setValue(game.getPlayer().getActiveFighter().getStamina());
		battlePanel.getPlayerFigherKi().setValue(game.getPlayer().getActiveFighter().getKi());
	

		battlePanel.getFoeHp().setValue(foe.getHealthPoints());
		battlePanel.getFoeStamina().setValue(foe.getStamina());
		battlePanel.getFoeKi().setValue(foe.getKi());
		battlePanel.repaint();
		battlePanel.validate();
		if(e.getType().equals(BattleEventType.ATTACK)){
			
			battlePanel.getActionLabel().setText("ATTACK");
			/*if(battle.getAttacker().equals(battle.getFoe())){
				//	battlePanel.getTurnIndicator().setText("It's "+"Fighter "+attackerName+"'s turn");
				//	try { Thread.sleep(1000); } catch (InterruptedException exc) {}
					//try {TimeUnit.MILLISECONDS.sleep(1000);} catch (InterruptedException e1) {}
					    
					
					try{
					battle.play();
				//	battle.endTurn();
					}catch(NotEnoughKiException d){}
					
			}*/
		
		
		

	
	}
	if(e.getType().equals(BattleEventType.NEW_TURN)){
		
	/*	if(battle.getAttacker().equals(battle.getFoe())){
		//	battlePanel.getTurnIndicator().setText("It's "+"Fighter "+attackerName+"'s turn");
		//	try { Thread.sleep(1000); } catch (InterruptedException exc) {}
			
			    
			
			try{
			battle.play();
		//	battle.endTurn();
			}catch(NotEnoughKiException d){}
			
			
		}*/
		
		battlePanel.getPlayerFighterHp().setValue(game.getPlayer().getActiveFighter().getHealthPoints());
		battlePanel.getPlayerFighterStamina().setValue(game.getPlayer().getActiveFighter().getStamina());
		battlePanel.getPlayerFigherKi().setValue(game.getPlayer().getActiveFighter().getKi());
	

		battlePanel.getFoeHp().setValue(foe.getHealthPoints());
		battlePanel.getFoeStamina().setValue(foe.getStamina());
		battlePanel.getFoeKi().setValue(foe.getKi());
		battlePanel.repaint();
		battlePanel.validate();
	
	}
	if(e.getType().equals(BattleEventType.USE)){
		battlePanel.getPlayerFighterHp().setValue(game.getPlayer().getActiveFighter().getHealthPoints());
		battlePanel.getPlayerFighterStamina().setValue(game.getPlayer().getActiveFighter().getStamina());
		battlePanel.getPlayerFigherKi().setValue(game.getPlayer().getActiveFighter().getKi());
		//battle.endTurn();
	}
	if(e.getType().equals(BattleEventType.BLOCK)){
		battlePanel.getActionLabel().setText("BLOCK");
		battlePanel.getPlayerFighterHp().setValue(game.getPlayer().getActiveFighter().getHealthPoints());
		battlePanel.getPlayerFighterStamina().setValue(game.getPlayer().getActiveFighter().getStamina());
		battlePanel.getPlayerFigherKi().setValue(game.getPlayer().getActiveFighter().getKi());
		//battle.endTurn();
		
	
		
		
		}
		
	

	
if(e.getType().equals(BattleEventType.ENDED)){
	NonPlayableFighter foeFighter =(NonPlayableFighter)battle.getFoe();
	
	if(e.getWinner().equals(battle.getFoe())||((e.getWinner().equals(battle.getMe())&&foeFighter.isStrong()))){
		for (int r=0; r<mapPanel.getArrayOfButtons().length; r++) {
		     for (int c=0; c<mapPanel.getArrayOfButtons()[r].length; c++) {
		    	 
		    	 /* JButton x= new JButton();
					mapPanel.getMap().add(x);
					x.setBackground(new Color(13, 134, 145));
					x.setBorderPainted(true);
					//x.setIcon(new ImageIcon("earthling.png"));*/
					mapPanel.getArrayOfButtons()[r][c].setIcon(null);
		        // arrayOfButtons[r][c].setIcon(new ImageIcon("earthling.png"));
		     }
		}
		mapPanel.getArrayOfButtons()[0][0].setIcon(new ImageIcon("Boss2.png"));
		mapPanel.getArrayOfButtons()[9][9].setIcon(mapPanel.getPlayerImage());
	}
	mapPanel.getSenzuBeansCollected().setText(" no. of Senzu Beans: "+game.getPlayer().getSenzuBeans());
	mapPanel.getDragonBallCollected().setText(" no. of Dragon Balls: "+game.getPlayer().getDragonBalls());
	mapPanel.getExploredMaps().setText(" no. of Explored Maps: "+game.getPlayer().getExploredMaps());
	mapPanel.getFighterNameLabel().setText(" Active Fighter: "+game.getPlayer().getActiveFighter().getName());
	mapPanel.getFighterXpLabel().setText(" Xp: "+game.getPlayer().getActiveFighter().getXp());
	mapPanel.getFighterAbilityPointsLabel().setText(" Ability points: "+game.getPlayer().getActiveFighter().getAbilityPoints());
	mapPanel.getFighterLevelLabel().setText(" Level: "+game.getPlayer().getActiveFighter().getLevel());

	
	mapPanel.repaint();
	mapPanel.revalidate();
	mapPanel.setVisible(true);
	mapPanel.getMap().setVisible(false);
	this.battlePanel.setVisible(false);
	
	String winner="";
	if(e.getWinner()==((Battle)e.getSource()).getFoe())
	{
		winner="You Lost! ";
	}
	else{
		winner="You Won!";
	}
	mapPanel.getWinnerLabel().getText1().setText(winner);
	mapPanel.getWinnerLabel().setVisible(true);
	mapPanel.setVisible(true);
	/*winnerLabel.setLocation(((d.width)/2)-237,((d.height)/2)-250);
	winnerLabel.setVisible(true);
	mapPanel.getBackg().add(winnerLabel);*/
	
	this.repaint();
	this.revalidate();
	
	
	}
this.repaint();
this.revalidate();
	
}
}
		




