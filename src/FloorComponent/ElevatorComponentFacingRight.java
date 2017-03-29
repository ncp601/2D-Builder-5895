package FloorComponent;

import java.awt.Dimension;
import javax.swing.ImageIcon;

import ComponentCommand.ComponentMover;

public class ElevatorComponentFacingRight extends FloorComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	final private String componentType = "ELEVATORRIGHT";
	
	private Dimension size = new Dimension(110, 110);
	private Dimension gridSize = new Dimension(100, 95);
	
	private boolean inMenu;
	private ComponentMover compMove = new ComponentMover();
	
	public ElevatorComponentFacingRight(boolean m){
		this.inMenu = m;
        addMouseListener(compMove);
        addMouseMotionListener(compMove);
		createComponent();
		setVisible(true);
	}
	
	@Override
	public void createComponent(){
		
		if(inMenu){
			ImageIcon image = new ImageIcon("images/elevatorFacingRight.png");
			setIcon(image);
			setMaximumSize(size);
			setMinimumSize(size);
	        setPreferredSize(size);
		}
		
		if(!inMenu){
			ImageIcon image = new ImageIcon("images/resizedElevatorFacingRight.png");
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
