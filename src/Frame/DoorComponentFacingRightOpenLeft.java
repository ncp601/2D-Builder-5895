package Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DoorComponentFacingRightOpenLeft extends FloorComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	final private String componentType = "DOORFROL";
	private int xPosition;
	private int yPosition;
	private boolean isStackable = false;
	private Dimension size = new Dimension(110, 110);
	
	private ComponentMover compMove = new ComponentMover();
	
	public DoorComponentFacingRightOpenLeft(){
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
		ImageIcon image = new ImageIcon("images/doorFacingRightOpenLeft.png");
		setIcon(image);
	}
	
	@Override
	public String getComponentType(){
		return componentType;
	}
	
	@Override
	public Dimension getImageSize(){
		return size;
	}
}
