//package Frame;
package FloorComponent;

//import Frame;
import javax.swing.*;

import ComponentCommand.ComponentMover;

import java.awt.*;

public class WindowComponentTwoVertical extends FloorComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	final private String componentType = "WINDOW2V";

	private Dimension size = new Dimension(110, 110);
	private Dimension gridSize = new Dimension(17, 62);
	
	private boolean inMenu;
	private ComponentMover compMove = new ComponentMover();
	
	public WindowComponentTwoVertical(boolean m){
		this.inMenu = m;
        addMouseListener(compMove);
        addMouseMotionListener(compMove);
		createComponent();
		setVisible(true);
	}
	
	@Override
	public void createComponent(){

		if(inMenu){
			ImageIcon image = new ImageIcon("images/twoBlockWindowVertical.png");
			setIcon(image);
			setMaximumSize(size);
			setMinimumSize(size);
	        setPreferredSize(size);
		}
		
		if(!inMenu){
			ImageIcon image = new ImageIcon("images/resizedTwoBlockWindowVertical.png");
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
