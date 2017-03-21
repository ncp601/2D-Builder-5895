package Frame;

import javax.swing.*;

public class FillLabel extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int xPosition;
	private int yPosition;
	private boolean isStackable = false;
	
	public FillLabel(){
		
		ImageIcon image = new ImageIcon("quality.png");
		setIcon(image);
	}
	
}
