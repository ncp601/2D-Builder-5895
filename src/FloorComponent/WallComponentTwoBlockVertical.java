//package Frame;
package FloorComponent;

import javax.swing.*;

import ComponentCommand.ComponentMover;

import java.awt.*;

public class WallComponentTwoBlockVertical extends FloorComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	final private String componentType = "WALL2V";

	private Dimension size = new Dimension(110, 110);
	private Dimension gridSize = new Dimension(17, 62);
	
	private boolean inMenu;
	private ComponentMover compMove = new ComponentMover();
	
	public WallComponentTwoBlockVertical(boolean m){
		this.inMenu = m;
        addMouseListener(compMove);
        addMouseMotionListener(compMove);
		createComponent();
		setVisible(true);
	}
	
	@Override
	public void createComponent(){

		if(inMenu){
			ImageIcon image = new ImageIcon("images/twoBlockWallVertical.png");
			setIcon(image);
			setMaximumSize(size);
			setMinimumSize(size);
	        setPreferredSize(size);
		}
		
		if(!inMenu){
			ImageIcon image = new ImageIcon("images/resizedTwoBlockWallVertical.png");
			setIcon(image);
			setMaximumSize(gridSize);
			setMinimumSize(gridSize);
	        setPreferredSize(gridSize);
		}
	}
	
	@Override
	public String getComponentType(){
		return componentType;
	}
	
	@Override
	public Dimension getImageSize(){
		return size;
	}
	
	@Override
	public Dimension getGridImageSize(){
		return gridSize;
	}
	
}