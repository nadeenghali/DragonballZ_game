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
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dragonball.controller.MainFrameGUI;
import dragonball.model.character.fighter.PlayableFighter;

public class MapPanel extends JPanel implements ActionListener{

	private JLabel map;
	private JLabel backg;
	private JPanel playerInfo;
	private JPanel fighterInfo;
	private JLabel fighterType;
	private JLabel playerNameLabel;
	private JLabel fighterNameLabel;
	private JLabel fighterXpLabel;
	private JLabel fighterAbilityPointsLabel;
	private JLabel fighterLevelLabel;
	private JLabel senzuBeansCollected;
	private JLabel dragonBallCollected;
	private JLabel exploredMaps;
	private ChooseActiveFighterPanel chooseActiveFighterPanel;
	private JButton saveGameButton;
	private JButton chooseActiveFighter;
	private ArrayList <String> listOfFighters;
	private JButton createFighter;
	private CreateFighterPanel createFighterPanel;
	private JButton upgradeFighter;
	private JButton assignAttack;
	private UpgradeFighterPanel upgradePanel;
	private Dimension y;
	private MainFrameGUI mainFrameGUI;
	private MovePanel movePanel;
	private JButton[][] arrayOfButtons;
	private ImageIcon playerImage;
	private SenzuFoundPanel senzuFoundPanel;
	private DragonBallFoundPanel dragonBallFoundPanel;
	private ExceptionMessagePanel exceptionMessagePanel;
	private AssignAttackPanel assignAttackPanel;
	private WinnerLabel winnerLabel;





	public AssignAttackPanel getAssignAttackPanel() {
		return assignAttackPanel;
	}






	public SenzuFoundPanel getSenzuFoundPanel() {
		return senzuFoundPanel;
	}






	public DragonBallFoundPanel getDragonBallFoundPanel() {
		return dragonBallFoundPanel;
	}






	public MovePanel getMovePanel() {
		return movePanel;
	}






	public ChooseActiveFighterPanel getChooseActiveFighterPanel() {
		return chooseActiveFighterPanel;
	}

	



	
	public JButton getChooseActiveFighter() {
		return chooseActiveFighter;
	}

	

	
	
	
	public JLabel getMap() {
		return map;
	}

	public JLabel getBackg() {
		return backg;
	}

	public JPanel getPlayerInfo() {
		return playerInfo;
	}

	public JPanel getFighterInfo() {
		return fighterInfo;
	}

	public JLabel getFighterType() {
		return fighterType;
	}

	public JLabel getPlayerNameLabel() {
		return playerNameLabel;
	}

	public JLabel getFighterNameLabel() {
		return fighterNameLabel;
	}

	public JLabel getFighterXpLabel() {
		return fighterXpLabel;
	}

	public JLabel getFighterAbilityPointsLabel() {
		return fighterAbilityPointsLabel;
	}

	public JLabel getFighterLevelLabel() {
		return fighterLevelLabel;
	}

	public JLabel getSenzuBeansCollected() {
		return senzuBeansCollected;
	}

	public JLabel getDragonBallCollected() {
		return dragonBallCollected;
	}

	public JLabel getExploredMaps() {
		return exploredMaps;
	} 

	public JButton getSaveGameButton() {
		return saveGameButton;
	}

	

	public FetchInfoPanel getFetchInfoPanel() {
		return fetchInfoPanel;
	}

	FetchInfoPanel fetchInfoPanel;
	
	public MapPanel()
	{	map=new JLabel();
        backg=new JLabel();

        
        fighterXpLabel= new JLabel();
        fighterAbilityPointsLabel= new JLabel();
        fighterLevelLabel= new JLabel();
        senzuBeansCollected= new JLabel();
    	dragonBallCollected= new JLabel();
    	exploredMaps= new JLabel();
		
		fetchInfoPanel= new FetchInfoPanel();
		
	    playerInfo= new JPanel();
	    playerInfo.setLayout(new GridLayout(10,1));
	    playerInfo.setSize(400,450);
	    playerInfo.setOpaque(true);
	    playerInfo.setBackground(new Color(13, 134, 145,123));
	    playerNameLabel= new JLabel();
	    playerNameLabel.setFont(new Font("Broadway", Font.BOLD, 25));
		playerNameLabel.setForeground(Color.WHITE);
		playerNameLabel.setOpaque(false);
		playerNameLabel.setSize(600,50);
		//playerNameLabel.setText("Welcome, "+playerInfoPanel.textField.getText());
		playerInfo.add(playerNameLabel);
		
		
		fighterInfo= new JPanel();
	    fighterInfo.setLayout(new GridLayout(10,1));
	    fighterInfo.setSize(400,450);
	    fighterInfo.setOpaque(true);
	    fighterInfo.setBackground(new Color(13, 134, 145,123));

		
		senzuBeansCollected.setFont(new Font("Broadway", Font.BOLD, 25));
		senzuBeansCollected.setForeground(Color.WHITE);
		senzuBeansCollected.setOpaque(false);
		senzuBeansCollected.setSize(600,50);
		//senzuBeansCollected.setText(" no. of Senzu Beans: ");
		playerInfo.add(senzuBeansCollected);
		
		 dragonBallCollected.setFont(new Font("Broadway", Font.BOLD, 25));
		 dragonBallCollected.setForeground(Color.WHITE);
		 dragonBallCollected.setOpaque(false);
		 dragonBallCollected.setSize(600,50);
		// dragonBallCollected.setText(" no. of Dragon Balls: ");
		playerInfo.add( dragonBallCollected);
		
		exploredMaps.setFont(new Font("Broadway", Font.BOLD, 25));
		exploredMaps.setForeground(Color.WHITE);
		exploredMaps.setOpaque(false);
		exploredMaps.setSize(600,50);
		//exploredMaps.setText(" no. of Explored Maps: ");
		playerInfo.add( exploredMaps);
		
		fighterNameLabel= new JLabel();
	    fighterNameLabel.setFont(new Font("Broadway", Font.BOLD, 25));
		fighterNameLabel.setForeground(Color.WHITE);
		fighterNameLabel.setOpaque(false);
		fighterNameLabel.setSize(600,50);
		//fighterNameLabel.setText("kk");
		fighterInfo.add(fighterNameLabel);
		
		fighterType = new JLabel();
		fighterType.setFont(new Font("Broadway", Font.BOLD, 25));
		fighterType.setForeground(Color.WHITE);
		fighterType.setOpaque(false);
		fighterType.setSize(600,50);
		//fighterType.setText(" Fighter Type: ");
		fighterInfo.add(fighterType);
		
		fighterXpLabel.setFont(new Font("Broadway", Font.BOLD, 25));
		fighterXpLabel.setForeground(Color.WHITE);
		fighterXpLabel.setOpaque(false);
		fighterXpLabel.setSize(600,50);
		//fighterXpLabel.setText(" Xp: ");
		fighterInfo.add(fighterXpLabel);
		
		fighterAbilityPointsLabel.setFont(new Font("Broadway", Font.BOLD, 25));
		fighterAbilityPointsLabel.setForeground(Color.WHITE);
		fighterAbilityPointsLabel.setOpaque(false);
		fighterAbilityPointsLabel.setSize(600,50);
		//fighterAbilityPointsLabel.setText(" Ability points: ");
		fighterInfo.add(fighterAbilityPointsLabel);
		
		fighterLevelLabel.setFont(new Font("Broadway", Font.BOLD, 25));
		fighterLevelLabel.setForeground(Color.WHITE);
		fighterLevelLabel.setOpaque(false);
		fighterLevelLabel.setSize(600,50);
		//fighterLevelLabel.setText(" Level: ");
		fighterInfo.add(fighterLevelLabel);
		
		
		
		y=Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(y);
		this.setLayout(null);
		backg.setSize(y);
		backg.setLayout(null);
		this.add(backg);
		map.setSize(y.height-200,y.height-200);
		map.setLayout(new GridLayout(10,10));
	    int i=1;
	    
	   
	   //// JButton boss= new JButton(new ImageIcon("Boss2.png"));
		//map.add(boss);
		//boss.setBackground(new Color(13, 134, 145));
		//boss.setBorderPainted(true);
	    playerImage = new ImageIcon("earthling.png");
		arrayOfButtons= new JButton[10][10];
		for (int r=0; r<arrayOfButtons.length; r++) {
		     for (int c=0; c<arrayOfButtons[r].length; c++) {
		    	 
		    	 JButton x= new JButton();
					map.add(x);
					x.setBackground(new Color(13, 134, 145));
					x.setBorderPainted(true);
					//x.setIcon(new ImageIcon("earthling.png"));
		         arrayOfButtons[r][c]= x;
		        // arrayOfButtons[r][c].setIcon(new ImageIcon("earthling.png"));
		     }
		}
		    arrayOfButtons[0][0].setIcon(new ImageIcon("Boss2.png"));
		    arrayOfButtons[9][9].setIcon(playerImage);
		
	
		
	//	map.setBackground(new Color(13, 134, 145, 123));
		   chooseActiveFighter = new JButton("Change Fighter");
		   chooseActiveFighter.setFont(new Font("Broadway", Font.BOLD, 20));
		   chooseActiveFighter.setSize(300,80);
		   chooseActiveFighter.setLocation(backg.getWidth()-1950, backg.getHeight()-600);
		   chooseActiveFighter.setVisible(true);
		   chooseActiveFighter.setLocation(backg.getWidth()-1950, backg.getHeight()-600);
		   chooseActiveFighter.setForeground(Color.BLUE);
		   backg.add(chooseActiveFighter);
		   chooseActiveFighter.addActionListener(this);
		   
		   chooseActiveFighterPanel= new ChooseActiveFighterPanel();
		   chooseActiveFighterPanel.setLocation(backg.getWidth()-1950, backg.getHeight()-400);
		   chooseActiveFighterPanel.setVisible(false);
		   backg.add(chooseActiveFighterPanel);
		   
		   assignAttackPanel= new AssignAttackPanel();
		   assignAttackPanel.setLocation(backg.getWidth()-1990, backg.getHeight()-400);
		   assignAttackPanel.setVisible(false);
		   backg.add(assignAttackPanel);
		  
		   senzuFoundPanel = new SenzuFoundPanel();
			senzuFoundPanel.setLocation(backg.getWidth()-1990, backg.getHeight()-400);
			senzuFoundPanel.setVisible(false);
			backg.add(senzuFoundPanel);
			
			dragonBallFoundPanel = new DragonBallFoundPanel();
			dragonBallFoundPanel.setLocation(backg.getWidth()-1990, backg.getHeight()-400);
			dragonBallFoundPanel.setVisible(false);
			backg.add(dragonBallFoundPanel);
			
			exceptionMessagePanel = new ExceptionMessagePanel();
			exceptionMessagePanel.setLocation(backg.getWidth()/2, backg.getHeight()-200);
			exceptionMessagePanel.setVisible(false);
			backg.add(exceptionMessagePanel);
		   
		   createFighter = new JButton("Create a Fighter");
		   createFighter.setFont(new Font("Broadway", Font.BOLD, 20));
			createFighter.setForeground(Color.GREEN);
			createFighter.setSize(300,80);
			createFighter.setLocation(backg.getWidth()-1950, backg.getHeight()-500);
			//createFighter.setLocation(backg.getWidth()-2000, backg.getHeight()-500);
			backg.add(createFighter);
			createFighter.addActionListener(this);
			
			movePanel= new MovePanel();
			movePanel.setLocation(backg.getWidth()-470, backg.getHeight()-320);
			backg.add(movePanel);
			
			saveGameButton = new JButton("SAVE & EXIT");
			saveGameButton.setFont(new Font("Broadway", Font.BOLD, 25));
			saveGameButton.setSize(250, 50);
			saveGameButton.setForeground(Color.WHITE);
			saveGameButton.setVisible(true);
			saveGameButton.addActionListener(this);
			saveGameButton.setLocation(backg.getWidth()-420, backg.getHeight()-400);
			saveGameButton.setBackground(Color.RED);
			backg.add(saveGameButton);
			
			
			createFighterPanel= new CreateFighterPanel();
			createFighterPanel.setLocation(backg.getWidth()-1950, backg.getHeight()-400);
			createFighterPanel.setVisible(false);
			backg.add(createFighterPanel);
			
			upgradeFighter = new JButton("Upgrade Fighter");
			upgradeFighter.setFont(new Font("Broadway", Font.BOLD, 20));
			upgradeFighter.setForeground(Color.RED);
			upgradeFighter.setSize(300,80);
			upgradeFighter.setLocation(backg.getWidth()-450, backg.getHeight()-600);
			upgradeFighter.addActionListener(this);
			backg.add(upgradeFighter);
			
			upgradePanel= new UpgradeFighterPanel();
			upgradePanel.setLocation(backg.getWidth()-1950, backg.getHeight()-400);
			upgradePanel.setVisible(false);
			backg.add(upgradePanel);
			
			winnerLabel=new WinnerLabel();
			winnerLabel.setLocation(((y.width)/2)-237,((y.height)/2)-250);
			winnerLabel.setVisible(false);
			backg.add(winnerLabel);
			
			
			assignAttack = new JButton("Assign Attack");
			assignAttack.setFont(new Font("Broadway", Font.BOLD, 20));
			assignAttack.setForeground(Color.RED);
			assignAttack.setSize(300,80);
			assignAttack.setLocation(backg.getWidth()-450, backg.getHeight()-500);
			assignAttack.addActionListener(this);
			backg.add(assignAttack);
			   
			
		
		backg.add(map);
		backg.add(playerInfo);
		backg.add(fighterInfo);
		map.setLocation(y.width-1500, y.height-1100);
		fighterInfo.setLocation(y.width-2000,y.height-1100);
		playerInfo.setLocation(y.width-500,y.height-1100);
		
		
		BufferedImage image = null;
	    try {
			image = ImageIO.read(new File("Logo1.jpg"));
			//image = ImageIO.read(new File("greybackground.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon I = new ImageIcon(fitimage(image,backg.getWidth(),backg.getHeight()));
		
		
	   backg.setIcon(I);
	   backg.setOpaque(true);
	   map.setVisible(true);
	   map.setOpaque(false);
	   playerInfo.setVisible(true);
	   
		repaint();
		revalidate();

		
		setVisible(true);
		
	}
	
	public WinnerLabel getWinnerLabel() {
		return winnerLabel;
	}






	public ExceptionMessagePanel getExceptionMessagePanel() {
		return exceptionMessagePanel;
	}






	public JButton[][] getArrayOfButtons() {
		return arrayOfButtons;
	}






	public JButton getAssignAttack() {
		return assignAttack;
	}






	public UpgradeFighterPanel getUpgradePanel() {
		return upgradePanel;
	}






	public JButton getCreateFighter() {
		return createFighter;
	}

	public CreateFighterPanel getCreateFighterPanel() {
		return createFighterPanel;
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

	public MainFrameGUI getMainFrameGUI() {
		return mainFrameGUI;
	}

	public void setMainFrameGUI(MainFrameGUI mainFrameGUI) {
		this.mainFrameGUI = mainFrameGUI;
	}

	public ArrayList<String> getListOfFighters() {
		return listOfFighters;
	}

	public void setListOfFighters(ArrayList<String> list) {
		this.listOfFighters = list;
	}

	public JButton getUpgradeFighter() {
		return upgradeFighter;
	}

	public void setUpgradeFighter(JButton upgradeFighter) {
		this.upgradeFighter = upgradeFighter;
	}






	public ImageIcon getPlayerImage() {
		return playerImage;
	}






	public void setPlayerImage(ImageIcon playerImage) {
		this.playerImage = playerImage;
	}

	
}

