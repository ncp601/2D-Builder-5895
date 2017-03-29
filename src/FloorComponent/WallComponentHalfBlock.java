//package Frame;
package FloorComponent;

import javax.swing.*;

import ComponentCommand.ComponentMover;

import java.awt.*;

public class WallComponentHalfBlock extends FloorComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	final private String componentType = "WALLHALF";

	private Dimension size = new Dimension(110, 110);
	private Dimension gridSize = new Dimension(16,16);
	
	private boolean inMenu;
	private ComponentMover compMove = new ComponentMover();
	
	public WallComponentHalfBlock(Boolean m){
		this.inMenu = m;
        addMouseListener(compMove);
        addMouseMotionListener(compMove);
		createComponent();
		setVisible(true);
	}
	
	@Override
	public void createComponent(){
		
		if(inMenu){
			ImageIcon image = new ImageIcon("images/halfBlockWall.png");
			setIcon(image);
			setMaximumSize(size);
			setMinimumSize(size);
	        setPreferredSize(size);
		}
		
		if(!inMenu){
			ImageIcon image = new ImageIcon("images/resizedHalfBlockWall.png");
			setIcon(image);
			setMaximumSize(gridSize);
			setMinimumSize(gridSize);
	        setPreferredSize(gridSize);
		}

	}
	
	public String getComponentType(){
		return componentType;
	}
	
	public Dimension getImageSize(){
		return size;
	}

	public Dimension getGridImageSize(){
		return gridSize;
	}

}