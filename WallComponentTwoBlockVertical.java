package Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WallComponentTwoBlockVertical extends FloorComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	final private String componentType = "WALL2V";
	private int xPosition;
	private int yPosition;
	private boolean isStackable = false;
	private boolean isNewComponent;
	private Dimension size = new Dimension(110, 110);
	
	private ComponentMover compMove = new ComponentMover();
	
	public WallComponentTwoBlockVertical(){
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
		ImageIcon image = new ImageIcon("twoBlockWallVertical.png");
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