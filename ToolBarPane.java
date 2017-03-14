package Frame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Class that creates everything in the toolbar panel and 
 * implements the actions for the buttons.
 */
public class ToolBarPane {
	
	private JPanel toolbarPanel;
    private JToolBar topToolBar;
    
    private JButton newFloorPlanButton;
    private JButton saveFloorPlanButton;
    private JButton loadFloorPlanButton;
   
    private ToolBarReceiver tbR = new ToolBarReceiver();
    private ToolBarManager tbM = new ToolBarManager();
    
    private ToolBarCommands newPlan;
    private ToolBarCommands loadPlan;
    private ToolBarCommands savePlan;
    
    private TabbedPane currentTabbedPane;
    private UIPanel innerContentPane;
    
    //tbM.doCurrentCommand(tbR, newPlan);
    //tbM.doCurrentCommand(tbR, loadPlan);
    //tbM.doCurrentCommand(tbR, savePlan);
    
	public ToolBarPane(UIPanel innerPane){
	    
		this.innerContentPane = innerPane;
		
		toolbarPanel = new JPanel();
        topToolBar = new JToolBar();
        newFloorPlanButton = new JButton();
        loadFloorPlanButton = new JButton();
        saveFloorPlanButton = new JButton();
        
	      //Creates the topToolbar toolbar
	        topToolBar.setFloatable(false);
	        topToolBar.setRollover(true);
	        topToolBar.setMaximumSize(new Dimension(1280, 50));
	        topToolBar.setMinimumSize(new Dimension(1000, 10));
	        topToolBar.setOpaque(false);

	      //Creates the newFloorPlanButton button  
	        newFloorPlanButton.setText("New");
	        newFloorPlanButton.setFocusable(false);
	        newFloorPlanButton.setHorizontalTextPosition(SwingConstants.CENTER);
	        newFloorPlanButton.setMaximumSize(new Dimension(50, 40));
	        newFloorPlanButton.setMinimumSize(new Dimension(29, 30));
	        newFloorPlanButton.setVerticalTextPosition(SwingConstants.BOTTOM);
	        newFloorPlanButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                newFloorPlanButtonActionPerformed(evt);
	            }
	        });
	        
	      //Adds the newFloorPlanButton to the toolbar
	        topToolBar.add(newFloorPlanButton);

	      //Creates the loadFloorPlanButton 
	        loadFloorPlanButton.setText("Load");
	        loadFloorPlanButton.setFocusable(false);
	        loadFloorPlanButton.setHorizontalTextPosition(SwingConstants.CENTER);
	        loadFloorPlanButton.setMaximumSize(new Dimension(50, 40));
	        loadFloorPlanButton.setMinimumSize(new Dimension(29, 30));
	        loadFloorPlanButton.setVerticalTextPosition(SwingConstants.BOTTOM);
	        loadFloorPlanButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                loadFloorPlanButtonActionPerformed(evt);
	            }
	        });
	        
	      //Adds the loadFloorPlanButton to the toolbar  
	        topToolBar.add(loadFloorPlanButton);

	      //Creates the saveFloorPlanButton 
	        saveFloorPlanButton.setText("Save");
	        saveFloorPlanButton.setFocusable(false);
	        saveFloorPlanButton.setHorizontalTextPosition(SwingConstants.CENTER);
	        saveFloorPlanButton.setMaximumSize(new Dimension(50, 40));
	        saveFloorPlanButton.setMinimumSize(new Dimension(29, 30));
	        saveFloorPlanButton.setVerticalTextPosition(SwingConstants.BOTTOM);
	        saveFloorPlanButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                saveFloorPlanButtonActionPerformed(evt);
	            }
	        });
	        
	      //Adds the saveFloorPlanButton to the toolbar
	        topToolBar.add(saveFloorPlanButton);

	      //------------------------------------------------------------------------------
	        
	      //Creates the layouts for the toolbarPanel
	        GroupLayout toolbarPanelLayout = new GroupLayout(toolbarPanel);
	        toolbarPanel.setLayout(toolbarPanelLayout);
	        toolbarPanelLayout.setHorizontalGroup(
	            toolbarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGap(0, 1320, Short.MAX_VALUE)
	            .addGroup(toolbarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                .addGroup(toolbarPanelLayout.createSequentialGroup()
	                    .addContainerGap()
	                    .addComponent(topToolBar, GroupLayout.PREFERRED_SIZE, 1290, GroupLayout.PREFERRED_SIZE)
	                    .addContainerGap(20, Short.MAX_VALUE)))
	        );
	        toolbarPanelLayout.setVerticalGroup(
	            toolbarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGap(0, 40, Short.MAX_VALUE)
	            .addGroup(toolbarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                .addComponent(topToolBar, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
	        );

	}
	
	//Gets the current toolbarPanel 
	public JPanel getGUI(){
		return toolbarPanel;
	}
	
    private void saveFloorPlanButtonActionPerformed(ActionEvent evt) {                                                    
        // TODO 
    }                                                   

    private void newFloorPlanButtonActionPerformed(ActionEvent evt) {                                                   
    	newPlan = new NewCommand(tbR ,currentTabbedPane);
    	tbM.doCurrentCommand(newPlan);
    }                                                  

    private void loadFloorPlanButtonActionPerformed(ActionEvent evt) {                                                    
        // TODO 
    }    
	
}
