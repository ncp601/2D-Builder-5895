package Frame;

import java.awt.Color;

import javax.swing.*;

public class MainLayeredPane extends JLayeredPane {

    private JPanel glassPanel;
    private Grid gridPanel;
	
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
	        .addGap(0, 653, Short.MAX_VALUE)
	    );
	    
	  //Sets the layers in the layeredPanel
	    setLayer(glassPanel, JLayeredPane.DRAG_LAYER);
	    setLayer(gridPanel, JLayeredPane.DEFAULT_LAYER);

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
	
	public JPanel getGlassPanel(){
		return glassPanel;
	}
}
