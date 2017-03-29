package ComponentCommand;

import javax.swing.*;

import FloorComponent.*;
import Frame.InnerPanel;
import Frame.MainLayeredPane;

import java.awt.*;

public class ComponentReceiver {

	private InnerPanel innerPanel;
	private MainLayeredPane selectedTab;
	private Component[] onGrid;
	
	
	public void addComponent(FloorComponent currentComponent, Component sourceComponent, Point currentLocation){
		innerPanel = InnerPanel.getInstance();
		selectedTab = innerPanel.getSelectedFloor();
		
		currentComponent.setIsOnGrid(true);
		innerPanel.getMenuPane().revalidate();
		innerPanel.getGUI().remove(currentComponent);
		currentComponent.setSize(currentComponent.getGridImageSize());
    	selectedTab.getGlassPanel().add(currentComponent);
    	currentComponent.setLocation(currentLocation.x - 218, currentLocation.y - 105);
    	currentComponent.setVisible(true);
    	selectedTab.revalidate();
    	selectedTab.repaint();
	}
	
	public void reAddComponent(FloorComponent currentComponent, Component sourceComponent, Point currentLocation){
		innerPanel = InnerPanel.getInstance();
		selectedTab = innerPanel.getSelectedFloor();
		
		currentComponent.setIsOnGrid(true);
		innerPanel.getMenuPane().revalidate();
		innerPanel.getGUI().remove(currentComponent);
		currentComponent.setSize(currentComponent.getGridImageSize());
    	selectedTab.getGlassPanel().add(currentComponent);
    	currentComponent.setLocation(currentComponent.getX(), currentComponent.getY());
    	((FloorComponent) currentComponent).setCurrentLocation(currentLocation);
    	currentComponent.setVisible(true);
    	selectedTab.revalidate();
    	selectedTab.repaint();
	}
	
	public void moveComponent(Component currentComponent, Point currentLocation){
		innerPanel = InnerPanel.getInstance();
		selectedTab = innerPanel.getSelectedFloor();
		selectedTab.getGlassPanel().remove(currentComponent);
		selectedTab.getGlassPanel().add(currentComponent);
		currentComponent.setLocation(currentLocation);
		((FloorComponent) currentComponent).setCurrentLocation(currentLocation);
    	selectedTab.revalidate();
    	selectedTab.repaint();
		
	}
	
	public void deleteComponent(Component currentComponent, Point currentLocation){
		innerPanel = InnerPanel.getInstance();
		selectedTab = innerPanel.getSelectedFloor();
		selectedTab.getGlassPanel().remove(currentComponent);
		selectedTab.repaint();
		selectedTab.revalidate();
		}
	
	public void clearComponents() {
		innerPanel = InnerPanel.getInstance();
		selectedTab = innerPanel.getSelectedFloor();
		
		onGrid = selectedTab.getGlassPanel().getComponents();
		for(int i = 0; i < onGrid.length; i++){
			if(onGrid[i] instanceof JLabel){
				selectedTab.getGlassPanel().remove(onGrid[i]);
				System.out.println(onGrid[i].toString());
			}
		}
		
		selectedTab.repaint();
		selectedTab.revalidate();
	}
	
	public void unClearComponents() {
		innerPanel = InnerPanel.getInstance();
		selectedTab = innerPanel.getSelectedFloor();
		
		for(int i = 0; i < onGrid.length; i++){
			selectedTab.getGlassPanel().add(onGrid[i]);
			System.out.println(onGrid[i].toString());
		}
		selectedTab.repaint();
		selectedTab.revalidate();
	}
	
}
