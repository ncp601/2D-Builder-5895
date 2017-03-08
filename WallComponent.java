package Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WallComponent extends FloorComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int xPosition;
	private int yPosition;
	private boolean isStackable = false;
	
	public WallComponent(){
		
		ImageIcon image = new ImageIcon("quality.png");
		setIcon(image);
		
	}
	
}
