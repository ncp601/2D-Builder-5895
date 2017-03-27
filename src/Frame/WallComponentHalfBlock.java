package Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WallComponentHalfBlock extends FloorComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	final private String componentType = "WALLHALF";
//	private Point previousLocation;
//	private Point currentLocation;
	private boolean isStackable = false;
//	private boolean isOnGrid;
	private Dimension size = new Dimension(110, 110);
	
	private ComponentMover compMove = new ComponentMover();
	
	public WallComponentHalfBlock(){
        addMouseListener(compMove);
        addMouseMotionListener(compMove);
        setPreferredSize(size);
		createComponent();
		setVisible(true);
		setMaximumSize(size);
		setMinimumSize(size);
	}
	
	@Override
	public void createComponent(){
		ImageIcon image = new ImageIcon("images/halfBlockWall.png");
		setIcon(image);
	}
	
	public String getComponentType(){
		return componentType;
	}
	
	public Dimension getImageSize(){
		return size;
	}
	
}