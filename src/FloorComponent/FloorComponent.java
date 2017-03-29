//package Frame;
package FloorComponent;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.*;


abstract public class FloorComponent extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected boolean isOnGrid = false;
	protected Point previousLocation;
	protected Point currentLocation;
	
	abstract public void createComponent();
	abstract public String getComponentType();
	abstract public Dimension getImageSize();
	abstract public Dimension getGridImageSize();
	
	public void setIsOnGrid(boolean m){
		isOnGrid = m;
	}
	 
	public boolean getIsOnGrid(){
		return isOnGrid;
	}
	
	public void setPreviousLocation(Point prev){
		previousLocation = prev;
	}
	
	public void setCurrentLocation(Point c){
		currentLocation = c;
	}
	
	public Point getPreviousLocation(){
		return previousLocation;
	}
	
	public Point getCurrentLocation(){
		return currentLocation;
	}
	
}
