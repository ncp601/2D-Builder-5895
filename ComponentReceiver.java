package Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComponentReceiver {

	private InnerPanel innerPanel;
	private Dimension componentSize = new Dimension(110, 110);
	private MainLayeredPane selectedTab;
	
	
	public void addComponent(FloorComponent currentComponent, Component sourceComponent, Point currentLocation){
		innerPanel = InnerPanel.getInstance();
		
		Component temp = innerPanel.getTabbedPane().getGUI().getSelectedComponent();
		selectedTab = (MainLayeredPane) temp;
		
		currentComponent.setIsNewComponent(true);
		innerPanel.getMenuPane().revalidate();
		innerPanel.getGUI().remove(currentComponent);
		currentComponent.setSize(componentSize);
    	selectedTab.getGlassPanel().add(currentComponent);
    	currentComponent.setLocation(sourceComponent.getX() - 210, sourceComponent.getY());
    	currentComponent.setVisible(true);
    	selectedTab.revalidate();
    	selectedTab.repaint();
	}
	
	public void moveComponent(Component currentComponent, Point currentLocation){
		innerPanel = InnerPanel.getInstance();
		selectedTab.getGlassPanel().remove(currentComponent);
		selectedTab.getGlassPanel().add(currentComponent);
    	selectedTab.revalidate();
    	selectedTab.repaint();
		
	}
	
	public void deleteComponent(Component currentComponent, Point currentLocation){
		innerPanel = InnerPanel.getInstance();
		selectedTab.getGlassPanel().remove(currentComponent);
		selectedTab.repaint();
		selectedTab.revalidate();
		}
	
	public void clearComponent() {
		
	}
	
	
}
