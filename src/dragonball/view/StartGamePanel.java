package dragonball.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Label;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartGamePanel extends JPanel {

	private JLabel startPageLabel;
	private FetchInfoPanel playerInfoPanel;
	private StartButtons sb;
	private Dimension dimension;
	
	public JLabel getStartPageLabel() {
		return startPageLabel;
	}
	public FetchInfoPanel getPlayerInfoPanel() {
		return playerInfoPanel;
	}
	public StartButtons getSb() {
		return sb;
	}
	public Dimension getDimension() {
		return dimension;
	}
	public StartGamePanel()
	{	
		
		 startPageLabel=new JLabel();
		 dimension=Toolkit.getDefaultToolkit().getScreenSize();
		setSize(dimension);
		setLayout(null);
		
		sb=new StartButtons();
		startPageLabel.add(sb);
		sb.setLocation((int) ((dimension.getWidth()-150)/2)-100,((int) ((dimension.getHeight()-150)/2))+100);
		
		startPageLabel.setSize(dimension);
		
		BufferedImage image = null;
	    try {
			image = ImageIO.read(new File("Logo21.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon I = new ImageIcon(fitimage(image,startPageLabel.getWidth(),startPageLabel.getHeight()));
		
	    startPageLabel.setIcon(I);
	    startPageLabel.setOpaque(true);
	    
	     playerInfoPanel= new FetchInfoPanel();
	     
	  /* startPageLabel.add(playerInfoPanel);
		playerInfoPanel.setLocation((int) (y.getWidth()/2)-500,(int) (y.getHeight()/2)-250);
		playerInfoPanel.setVisible(true);
		x.setVisible(false);*/
		
		this.add(startPageLabel);
		
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

	
		
	}
	


