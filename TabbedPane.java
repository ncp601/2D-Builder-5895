package Frame;

import java.awt.*;
import javax.swing.*;

/**
 * Class that creates everything in the left tabbed panel. 
 * 
 */
public class TabbedPane {

	// Variables declaration                  
    private JLayeredPane addLayeredPanel;
    private JTabbedPane floorTabPanel;
    private JPanel glassPanel;
    private Grid gridPanel;
    private JLayeredPane mainLayeredPanel;
	
	public TabbedPane() {
		
	//Creates floorTabPanel
    floorTabPanel = new JTabbedPane();
    floorTabPanel.setBackground(new Color(255, 255, 255));
    floorTabPanel.setFocusable(false);

  //------------------------------------------------------------------------------
    
    //Creates mainLayeredPanel inside of the floorTabPanel
    mainLayeredPanel = new JLayeredPane();
    mainLayeredPanel.setOpaque(true);

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
    mainLayeredPanel.setLayer(glassPanel, JLayeredPane.DRAG_LAYER);
    mainLayeredPanel.setLayer(gridPanel, JLayeredPane.DEFAULT_LAYER);

    GroupLayout mainLayeredPanelLayout = new GroupLayout(mainLayeredPanel);
    mainLayeredPanel.setLayout(mainLayeredPanelLayout);
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

  //Adds the mainLayeredPanel to the floorTabPanel
    floorTabPanel.addTab("Floor 1", mainLayeredPanel);

  //------------------------------------------------------------------------------
    
  //Creates the addLayeredPanel tab that will be used to add new tabs(floors) to a plan
    addLayeredPanel = new JLayeredPane();	
    
  //Creates the layouts for the addLayeredPanel
    GroupLayout addLayeredPanelLayout = new GroupLayout(addLayeredPanel);
    addLayeredPanel.setLayout(addLayeredPanelLayout);
    addLayeredPanelLayout.setHorizontalGroup(
        addLayeredPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGap(0, 1050, Short.MAX_VALUE)
    );
    addLayeredPanelLayout.setVerticalGroup(
        addLayeredPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGap(0, 652, Short.MAX_VALUE)
    );

  //Adds the addLayeredPanel to the floorTabPanel
    floorTabPanel.addTab("+", addLayeredPanel);
	
	}
	
	//Gets the current floorTabPanel
	public JTabbedPane getGUI(){
		return floorTabPanel;
	}
	
}
