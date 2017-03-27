package Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WallComponentOneBlockHorizontal extends FloorComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	final private String componentType = "WALL1H";
	private int xPosition;
	private int yPosition;
	private boolean isStackable = false;
	private boolean isNewComponent;
	private Dimension size = new Dimension(110, 110);
	
	private ComponentMover compMove = new ComponentMover();
	
	public WallComponentOneBlockHorizontal(){
        addMouseListener(compMove);
        addMouseMotionListener(compMove);
        setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);
		setVisible(true);
		createComponent();
	}
	
	@Override
	public void createComponent(){
		ImageIcon image = new ImageIcon("images/oneBlockWallHorizontal.png");
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