package Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComponentReceiver {

	private InnerPanel innerPanel;
	private Dimension componentSize = new Dimension(110, 110);
	
	public void addComponent(FloorComponent currentComponent, Component sourceComponent, Point currentLocation){
		innerPanel = InnerPanel.getInstance();
		currentComponent.setIsNewComponent(true);
		innerPanel.getMenuPane().revalidate();
		innerPanel.getGUI().remove(currentComponent);
		currentComponent.setSize(componentSize);
    	innerPanel.getTabbedPane().getMainLayeredPanel().getGlassPanel().add(currentComponent);
    	currentComponent.setLocation(sourceComponent.getX() - 220, sourceComponent.getY());
    	currentComponent.setVisible(true);
    	innerPanel.getTabbedPane().getMainLayeredPanel().revalidate();
    	innerPanel.getTabbedPane().getMainLayeredPanel().repaint();
	}
	
	public void moveComponent(Component currentComponent, Point currentLocation){
		innerPanel = InnerPanel.getInstance();
		innerPanel.getTabbedPane().getMainLayeredPanel().getGlassPanel().remove(currentComponent);
		innerPanel.getTabbedPane().getMainLayeredPanel().getGlassPanel().add(currentComponent);
    	innerPanel.getTabbedPane().getMainLayeredPanel().revalidate();
    	innerPanel.getTabbedPane().getMainLayeredPanel().repaint();
		
	}
	
	public void deleteComponent(Component currentComponent, Point currentLocation){
		innerPanel = InnerPanel.getInstance();
		innerPanel.getTabbedPane().getMainLayeredPanel().getGlassPanel().remove(currentComponent);
		innerPanel.getTabbedPane().getMainLayeredPanel().revalidate();
    	innerPanel.getTabbedPane().getMainLayeredPanel().repaint();
	}
	
	public void clearComponent() {
		
	}
	
	
}
