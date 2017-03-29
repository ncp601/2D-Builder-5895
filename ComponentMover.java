package Frame;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ComponentMover extends MouseAdapter
{
	private Insets dragInsets = new Insets(0, 0, 0, 0);
	private Dimension snapSize = new Dimension(1, 1);
	private boolean changeCursor = true;
	private boolean autoLayout = false;

	private Component destination;
	private Component source;

	private Point pressed;
	private Point location;
	private Point releaseLocation;
	private Point previousLocation;

	private Cursor originalCursor;
	private boolean autoscrolls;
	private boolean potentialDrag;

	private AbstractFloorComponentFactory wallFactory = FloorComponentFactoryProducer.getFactory("WALL");
    private AbstractFloorComponentFactory windowFactory = FloorComponentFactoryProducer.getFactory("WINDOW");
    private AbstractFloorComponentFactory doorFactory = FloorComponentFactoryProducer.getFactory("DOOR");
    private AbstractFloorComponentFactory stairsFactory = FloorComponentFactoryProducer.getFactory("STAIRS");
    private AbstractFloorComponentFactory elevatorFactory = FloorComponentFactoryProducer.getFactory("ELEVATOR");
    private AbstractFloorComponentFactory flooringFactory = FloorComponentFactoryProducer.getFactory("FLOORING");
    private AbstractFloorComponentFactory dinningRoomFactory = FloorComponentFactoryProducer.getFactory("DINNINGROOM");
    private AbstractFloorComponentFactory bedroomFactory = FloorComponentFactoryProducer.getFactory("BEDROOM");
    private AbstractFloorComponentFactory bathroomFactory = FloorComponentFactoryProducer.getFactory("BATHROOM");
    private AbstractFloorComponentFactory laundryFactory = FloorComponentFactoryProducer.getFactory("LAUNDRY");
    private AbstractFloorComponentFactory garageFactory = FloorComponentFactoryProducer.getFactory("GARAGE");
    
	private JLayeredPane innerContentPanel;
	private MainLayeredPane selectedTab;
    private String type = "";
    private FloorComponent newComponent;
    private FloorComponent currentComponent;
    private Component[] onGrid;
    
    private ComponentCommands addComp;
    private ComponentCommands moveComp;
    private ComponentCommands deleteComp;
    
    private int dragX = 0;
	private int dragY = 0;
	
	private int locationX = 0;
	private int locationY = 0;
    
	private boolean pressedOperation;
	private boolean releasedOperaion;
	private boolean releasedOperationInside;
	
    private Dimension componentSize = new Dimension(110, 110);
    
	private InnerPanel innerPanel;

	/**
	 *  Constructor for moving individual components. The components must be
	 *  regisetered using the registerComponent() method.
	 */
	public ComponentMover(){	
	}

	
	/**
	 *  Setup the variables used to control the moving of the component:
	 *
	 *  source - the source component of the mouse event
	 *  destination - the component that will ultimately be moved
	 *  pressed - the Point where the mouse was pressed in the destination
	 *      component coordinates.
	 */
	@Override
	public void mousePressed(MouseEvent e){
		
		innerPanel = InnerPanel.getInstance();
		source = e.getComponent();
		currentComponent = (FloorComponent)e.getSource();
		pressedOperation = true;
		
			if(!(innerPanel.getInMainLayeredPane()) && !(currentComponent.getIsOnGrid()) && pressedOperation){
				pressedOperation = false;
				innerPanel.setCreateComponent(false);
				currentComponent = (FloorComponent)e.getSource();
	    		type = currentComponent.getComponentType();
	    		System.out.println(type);
	    		
		    	if(wallFactory.getComponent(type) != null){
		    		newComponent = wallFactory.getComponent(type);
		    	}
		    	
		    	if(windowFactory.getComponent(type) != null){
		    		newComponent = windowFactory.getComponent(type);
		    	}
		    	
		    	if(doorFactory.getComponent(type) != null){
		    		newComponent = doorFactory.getComponent(type);
		    	}
		    	
		    	if(stairsFactory.getComponent(type) != null){
		    		newComponent = stairsFactory.getComponent(type);
		    	}
		    	
		    	if(elevatorFactory.getComponent(type) != null){
		    		newComponent = elevatorFactory.getComponent(type);
		    	}
		    	
		    	if(flooringFactory.getComponent(type) != null){
		    		newComponent = flooringFactory.getComponent(type);
		    	}
		    	
		    	if(dinningRoomFactory.getComponent(type) != null){
		    		newComponent = dinningRoomFactory.getComponent(type);
		    	}
		    	
		    	if(bathroomFactory.getComponent(type) != null){
		    		newComponent = bathroomFactory.getComponent(type);
		    	}
		    	
		    	if(bedroomFactory.getComponent(type) != null){
		    		newComponent = bedroomFactory.getComponent(type);
		    	}
		    	
		    	if(laundryFactory.getComponent(type) != null){
		    		newComponent = laundryFactory.getComponent(type);
		    	}
		    	
		    	if(garageFactory.getComponent(type) != null){
		    		newComponent = garageFactory.getComponent(type);
		    	}
		    	
		    	newComponent.setVisible(true);
		    	
		    	int width  = newComponent.getImageSize().width  - dragInsets.left - dragInsets.right;
				int height = newComponent.getImageSize().height - dragInsets.top - dragInsets.bottom;
				Rectangle r = new Rectangle(dragInsets.left, dragInsets.top, width, height);
		    	
				innerContentPanel = innerPanel.getGUI();
				innerContentPanel.add(newComponent, JLayeredPane.DRAG_LAYER);
				
				if (r.contains(e.getPoint()))
					setupForDragging(e);
				
				innerPanel.getMenuPane().repaint();
		    	innerPanel.getGUI().revalidate();
		    	System.out.println("Add Operation");
			}
				
			if(currentComponent.getIsOnGrid() && pressedOperation){
				pressedOperation = false;
				int width  = source.getSize().width  - dragInsets.left - dragInsets.right;
				int height = source.getSize().height - dragInsets.top - dragInsets.bottom;
				Rectangle r = new Rectangle(dragInsets.left, dragInsets.top, width, height);
				
				if (r.contains(e.getPoint()))
					setupForDragging(e);
				
				currentComponent.setPreviousLocation(currentComponent.getLocation());
				innerPanel.getMenuPane().repaint();
		    	innerPanel.getGUI().revalidate();
		    	System.out.println("Moving Operation");
			}
			
			else {
				return;
			}
		    	
			
	}
	
	//Sets up the component for the dragging operation 
	private void setupForDragging(MouseEvent e)
	{
		source.addMouseMotionListener( this );
		potentialDrag = true;

		destination = source;

		pressed = e.getLocationOnScreen();
		location = destination.getLocation();

		if (changeCursor)
		{
			originalCursor = source.getCursor();
			destination.setCursor( Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR) );
		}

		//  Making sure autoscrolls is false will allow for smoother dragging of
		//  individual components

		if (destination instanceof JComponent)
		{
			JComponent jc = (JComponent)destination;
			autoscrolls = jc.getAutoscrolls();
			jc.setAutoscrolls( false );
		}
	}

	/**
	 *  Move the component to its new location. The dragged Point must be in
	 *  the destination coordinates.
	 */
	@Override
	public void mouseDragged(MouseEvent e)
	{
		Point dragged = e.getLocationOnScreen();
		dragX = getDragDistance(dragged.x, pressed.x, snapSize.width);
		dragY = getDragDistance(dragged.y, pressed.y, snapSize.height);

		locationX = location.x + dragX;
		locationY = location.y + dragY;

		//  Mouse dragged events are not generated for every pixel the mouse
		//  is moved. Adjust the location to make sure we are still on a
		//  snap value.

//		while (locationX < edgeInsets.left)
//			locationX += snapSize.width;
//
//		while (locationY < edgeInsets.top)
//			locationY += snapSize.height;
//
//		Dimension d = getBoundingSize( destination );
//
//		while (locationX + destination.getSize().width + edgeInsets.right > d.width)
//			locationX -= snapSize.width;
//
//		while (locationY + destination.getSize().height + edgeInsets.bottom > d.height)
//			locationY -= snapSize.height;

		//  Adjustments are finished, move the component

		innerPanel.getGUI().repaint();
		destination.setLocation(locationX, locationY);
	}

	/*
	 *  Determine how far the mouse has moved from where dragging started
	 *  (Assume drag direction is down and right for positive drag distance)
	 */
	private int getDragDistance(int larger, int smaller, int snapSize)
	{
		int halfway = snapSize / 2;
		int drag = larger - smaller;
		drag += (drag < 0) ? -halfway : halfway;
		drag = (drag / snapSize) * snapSize;

		return drag;
	}

	/**
	 *  Restore the original state of the Component
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		
		innerPanel = InnerPanel.getInstance();
		releasedOperaion = true;
		releasedOperationInside = true;

		selectedTab = innerPanel.getSelectedFloor();
		
		releaseLocation = e.getLocationOnScreen();
		System.out.println(releaseLocation);
		
		if (!potentialDrag) return;
		
		innerContentPanel = innerPanel.getGUI();
		
		if(!(innerPanel.getInMainLayeredPane()) && !(currentComponent.getIsOnGrid()) && releasedOperaion && selectedTab != null){
			if((releaseLocation.x < 1260 && releaseLocation.x > 220) && (releaseLocation.y < 720 && releaseLocation.y > 110)  && releasedOperationInside){
				releasedOperaion = false;
		    	System.out.println("Adding Component to Grid");
		    	addComp = new AddComponent(selectedTab.getComponentReceiver(), source, newComponent, releaseLocation);
		    	selectedTab.getComponentManager().doCurrentCommand(addComp);
			}
			
			else {
				selectedTab.getGlassPanel().remove(newComponent);
				System.out.println("Couldn't add component - Out of bounds");
		    	selectedTab.revalidate();
		    	selectedTab.repaint();
			}
		}
		
		if(!(innerPanel.getInMenuPane()) && currentComponent.getIsOnGrid() && releasedOperaion && selectedTab != null){
			if((releaseLocation.x < 1260 && releaseLocation.x > 160) && (releaseLocation.y < 720 && releaseLocation.y > 60)  && releasedOperationInside){
				releasedOperaion = false;
				releasedOperationInside = false;
		    	System.out.println("Component inside of the grid");	
		    	moveComp = new MoveComponent(selectedTab.getComponentReceiver(), source, source.getLocation());
		    	selectedTab.getComponentManager().doCurrentCommand(moveComp);
			}
			
	    	if((releaseLocation.x > 1260 | releaseLocation.x < 160) | (releaseLocation.y > 720 | releaseLocation.y < 60) && releasedOperationInside && selectedTab != null){
	    		releasedOperationInside = false;
	    		releasedOperaion = false;
		    	System.out.println("Component outside of the grid");
		    	deleteComp = new DeleteComponent(selectedTab.getComponentReceiver(), source, releaseLocation);
		    	selectedTab.getComponentManager().doCurrentCommand(deleteComp);
	    	}
		}
		
		onGrid = selectedTab.getGlassPanel().getComponents();
		
    	for(int i = 0; i < onGrid.length; i++ ){
    		type = onGrid[i].toString();
    		System.out.println(type);
    	}
		
		source.removeMouseMotionListener( this );
		potentialDrag = false;

		if (changeCursor)
			source.setCursor( originalCursor );

		if (destination instanceof JComponent)
		{
			((JComponent)destination).setAutoscrolls( autoscrolls );
		}

		//  Layout the components on the parent container

		if (autoLayout)
		{
			if (destination instanceof JComponent)
			{
				((JComponent)destination).revalidate();
			}
			else
			{
				destination.validate();
			}
		}
	}
		
}