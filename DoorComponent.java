package Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DoorComponent extends FloorComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	final private String componentType = "DOOR";
	private int xPosition;
	private int yPosition;
	private boolean isStackable = false;
	
	public DoorComponent(){
		createComponent();
	}
	
	@Override
	public void createComponent(){
		ImageIcon image = new ImageIcon("quality.png");
		setIcon(image);
	}
	
	@Override
	public String getComponentType(){
		return componentType;
	}
}
