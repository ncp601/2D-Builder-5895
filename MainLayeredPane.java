package Frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.*;
import javax.swing.*;

public class MainLayeredPane extends JLayeredPane /*implements MouseListener, MouseMotionListener*/{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private FloorComponentFactory compFactory;
	
	private JPanel glassPanel;
    private Grid gridPanel;
	private MenuPane menuPane;
	private JPanel dragLayer;
	
	private FloorComponent currentComponent;
    private Component movingComponent;
	
	private ComponentMover compMove = new ComponentMover();
	
	public MainLayeredPane(){
		
	    setOpaque(true);

	  //------------------------------------------------------------------------------
	        
	  //Creates the glassPanel layer that will lay on top of the canvas and act as the drag layer
	    glassPanel = new JPanel();
	    glassPanel.setBackground(new Color(0, 0, 0, 0));
	    glassPanel.setOpaque(false);

	  //------------------------------------------------------------------------------
	    
	  //Creates the gridPanel that will represent the grid under the glassPanel
	    gridPanel = new Grid();
	    
	  //------------------------------------------------------------------------------  
	    
	  //Creates the layouts for the mainLayeredPanel and the glassPanel 
	    GroupLayout glassPanelLayout = new GroupLayout(glassPanel);
	    glassPanel.setLayout(glassPanelLayout);
	    glassPanelLayout.setHorizontalGroup(
	        glassPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	        .addGap(0, 1050, Short.MAX_VALUE)
	    );
	    glassPanelLayout.setVerticalGroup(
	        glassPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	        .addGap(0, 150, Short.MAX_VALUE)
	    );
	    
	  //Sets the layers in the layeredPanel
	    setLayer(gridPanel, JLayeredPane.DEFAULT_LAYER);
	    setLayer(glassPanel, JLayeredPane.DRAG_LAYER);
	    
	    GroupLayout mainLayeredPanelLayout = new GroupLayout(this);
	    setLayout(mainLayeredPanelLayout);
	    mainLayeredPanelLayout.setHorizontalGroup(
	        mainLayeredPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	        .addComponent(glassPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        .addGroup(mainLayeredPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addComponent(gridPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	    );
	    mainLayeredPanelLayout.setVerticalGroup(
	        mainLayeredPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	        .addGroup(GroupLayout.Alignment.TRAILING, mainLayeredPanelLayout.createSequentialGroup()
	            .addComponent(glassPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	            .addGap(0, 0, Short.MAX_VALUE))
	        .addGroup(mainLayeredPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addComponent(gridPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	    );
	}
	
	public void addToGlassPane(Component c){
		glassPanel.add(c);
	}
	
	public JPanel getGlassPanel(){
		return glassPanel;
	}

//	@Override
//	public void mouseDragged(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseMoved(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mousePressed(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseReleased(MouseEvent e) {
//		
//		
//	}
//
////	@Override
////	public void mouseEntered(MouseEvent e) {
////		if(menuPane.isComponentSet()){
//////			currentComponent = menuPane.getFloorComponent();
//////			compFactory.getComponent(currentComponent.getComponentType());
//////			currentComponent.createComponent();
//////			glassPanel.add(currentComponent);
////			///////
//////			dragLayer = frame.getContentPanel();
//////    		dragLayer.remove(menuPane.getFloorComponent());
//////
//////	    	dragLayer.add(currentComponent);
////			
////		}
////		
////	}
////
////	@Override
////	public void mouseExited(MouseEvent e) {
////		// TODO Auto-generated method stub
////		
////	}
	
}






