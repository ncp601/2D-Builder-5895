package Frame;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ComponentMover extends MouseAdapter
{
	private Insets dragInsets = new Insets(0, 0, 0, 0);
	private Dimension snapSize = new Dimension(1, 1);
	private Insets edgeInsets = new Insets(0, 0, 0, 0);
	private boolean changeCursor = true;
	private boolean autoLayout = false;

	private Component destination;
	private Component source;

	private Point pressed;
	private Point location;
	private Point releaseLocation;

	private Cursor originalCursor;
	private boolean autoscrolls;
	private boolean potentialDrag;

	private JLayeredPane innerContentPanel;
    private FloorComponentFactory factory = new FloorComponentFactory();
    private String type = "";
    private FloorComponent newComponent;
    private FloorComponent currentComponent;
    private Component[] onGrid;
	
    private int dragX = 0;
	private int dragY = 0;
	
	private int locationX = 0;
	private int locationY = 0;
    
	private boolean pressedOperation;
	private boolean releasedOperaion;
	private boolean releasedOperationInside;
	
    private Dimension componentSize = new Dimension(110, 110);
    
	private InnerPanel innerPanel;

//	/**
//	 *  Constructor for moving individual components. The components must be
//	 *  regisetered using the registerComponent() method.
//	 */
//	public ComponentMover(UIPanel inner, MenuPane menu)
//	{
//		this.innerContentPanel = inner;
//		this.menuPane = menu;
//	}

	/**
	 *  Constructor for moving individual components. The components must be
	 *  regisetered using the registerComponent() method.
	 */
	public ComponentMover(){	
	}

	/**
	 *  Get the auto layout property
	 *
	 *  @return  the auto layout property
	 */
	public boolean isAutoLayout()
	{
		return autoLayout;
	}

	/**
	 *  Set the auto layout property
	 *
	 *  @param  autoLayout when true layout will be invoked on the parent container
	 */
	public void setAutoLayout(boolean autoLayout)
	{
		this.autoLayout = autoLayout;
	}

	/**
	 *  Get the change cursor property
	 *
	 *  @return  the change cursor property
	 */
	public boolean isChangeCursor()
	{
		return changeCursor;
	}

	/**
	 *  Set the change cursor property
	 *
	 *  @param  changeCursor when true the cursor will be changed to the
	 *                       Cursor.MOVE_CURSOR while the mouse is pressed
	 */
	public void setChangeCursor(boolean changeCursor)
	{
		this.changeCursor = changeCursor;
	}

	/**
	 *  Get the drag insets
	 *
	 *  @return  the drag insets
	 */
	public Insets getDragInsets()
	{
		return dragInsets;
	}

	/**
	 *  Set the drag insets. The insets specify an area where mouseDragged
	 *  events should be ignored and therefore the component will not be moved.
	 *  This will prevent these events from being confused with a
	 *  MouseMotionListener that supports component resizing.
	 *
	 *  @param  dragInsets
	 */
	public void setDragInsets(Insets dragInsets)
	{
		this.dragInsets = dragInsets;
	}

	/**
	 *  Get the bounds insets
	 *
	 *  @return  the bounds insets
	 */
	public Insets getEdgeInsets()
	{
		return edgeInsets;
	}

	/**
	 *  Set the edge insets. The insets specify how close to each edge of the parent
	 *  component that the child component can be moved. Positive values means the
	 *  component must be contained within the parent. Negative values means the
	 *  component can be moved outside the parent.
	 *
	 *  @param  edgeInsets
	 */
	public void setEdgeInsets(Insets edgeInsets)
	{
		this.edgeInsets = edgeInsets;
	}

	/**
	 *	Get the snap size
	 *
	 *  @return the snap size
	 */
	public Dimension getSnapSize()
	{
		return snapSize;
	}

	/**
	 *  Set the snap size. Forces the component to be snapped to
	 *  the closest grid position. Snapping will occur when the mouse is
	 *  dragged half way.
	 */
	public void setSnapSize(Dimension snapSize)
	{
		if (snapSize.width < 1
		||  snapSize.height < 1)
			throw new IllegalArgumentException("Snap sizes must be greater than 0");

		this.snapSize = snapSize;
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
		
			if(!(innerPanel.getInMainLayeredPane()) && !(currentComponent.getIsNewComponent()) && pressedOperation){
				pressedOperation = false;
				innerPanel.setCreateComponent(false);
				currentComponent = (FloorComponent)e.getSource();
	    		type = currentComponent.getComponentType();
	    		System.out.println(type);
		    	newComponent = factory.getComponent(type);
		    	
		    	newComponent.setVisible(true);
		    	innerPanel.getTabbedPane().getMainLayeredPanel().setVisible(true);
		    	
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
				
			if(!(innerPanel.getInMenuPane()) && currentComponent.getIsNewComponent() && pressedOperation){
				pressedOperation = false;
				int width  = source.getSize().width  - dragInsets.left - dragInsets.right;
				int height = source.getSize().height - dragInsets.top - dragInsets.bottom;
				Rectangle r = new Rectangle(dragInsets.left, dragInsets.top, width, height);
				
				if (r.contains(e.getPoint()))
					setupForDragging(e);
				
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

	/*
	 *  Get the bounds of the parent of the dragged component.
	 */
	private Dimension getBoundingSize(Component source)
	{
		if (source instanceof Window)
		{
			GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Rectangle bounds = env.getMaximumWindowBounds();
			return new Dimension(bounds.width, bounds.height);
		}
		else
		{
			return source.getParent().getSize();
		}
	}

	/**
	 *  Restore the original state of the Component
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		
		innerPanel = InnerPanel.getInstance();
		releasedOperaion = true;
		releasedOperationInside = true;
		
		releaseLocation = e.getLocationOnScreen();
		System.out.println(releaseLocation);
		
		if (!potentialDrag) return;
		
		innerContentPanel = innerPanel.getGUI();
		
		if(!(innerPanel.getInMainLayeredPane()) && !(currentComponent.getIsNewComponent()) && releasedOperaion){
			if((releaseLocation.x < 1260 && releaseLocation.x > 220) && (releaseLocation.y < 720 && releaseLocation.y > 110)  && releasedOperationInside){
				newComponent.setIsNewComponent(true);
				releasedOperaion = false;
				innerPanel.getMenuPane().revalidate();
				innerContentPanel.remove(newComponent);
				newComponent.setSize(componentSize);
		    	innerPanel.getTabbedPane().getMainLayeredPanel().getGlassPanel().add(newComponent);
		    	newComponent.setLocation(source.getX() - 220, source.getY());
		    	innerPanel.getTabbedPane().getMainLayeredPanel().revalidate();
		    	System.out.println("Adding Component to Grid");
			}
			
			else {
				innerPanel.getTabbedPane().getMainLayeredPanel().getGlassPanel().remove(newComponent);
				System.out.println("Couldn't add component - Out of bounds");
				innerPanel.getTabbedPane().getMainLayeredPanel().revalidate();
		    	innerPanel.getTabbedPane().getMainLayeredPanel().repaint();
			}
		}
		
		if(!(innerPanel.getInMenuPane()) && currentComponent.getIsNewComponent() && releasedOperaion){
			if((releaseLocation.x < 1260 && releaseLocation.x > 220) && (releaseLocation.y < 720 && releaseLocation.y > 110)  && releasedOperationInside){
				releasedOperaion = false;
				releasedOperationInside = false;
				innerPanel.getTabbedPane().getMainLayeredPanel().getGlassPanel().remove(source);
				innerPanel.getTabbedPane().getMainLayeredPanel().getGlassPanel().add(source);
		    	innerPanel.getTabbedPane().getMainLayeredPanel().revalidate();
		    	innerPanel.getTabbedPane().getMainLayeredPanel().repaint();
		    	System.out.println("Component inside of the grid");	
			}
			
	    	if((releaseLocation.x > 1260 | releaseLocation.x < 220) | (releaseLocation.y > 720 | releaseLocation.y < 110) && releasedOperationInside){
	    		releasedOperationInside = false;
	    		releasedOperaion = false;
	    		innerPanel.getTabbedPane().getMainLayeredPanel().getGlassPanel().remove(source);
	    		innerPanel.getTabbedPane().getMainLayeredPanel().revalidate();
		    	innerPanel.getTabbedPane().getMainLayeredPanel().repaint();
		    	System.out.println("Component outside of the grid");	
	    	}
		}
		
    	onGrid = innerPanel.getTabbedPane().getMainLayeredPanel().getGlassPanel().getComponents();
    	
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