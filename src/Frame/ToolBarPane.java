package Frame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import ComponentCommand.ClearComponents;
import ComponentCommand.ComponentCommands;
import ToolBarCommand.LoadCommand;
import ToolBarCommand.NewCommand;
import ToolBarCommand.SaveCommand;
import ToolBarCommand.ToolBarCommands;
import ToolBarCommand.ToolBarManager;
import ToolBarCommand.ToolBarReceiver;

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
    private JButton undoButton;
    private JButton redoButton;
    private JButton clearButton;
    private JButton removeFloorButton;
   
    private ToolBarReceiver tbR = new ToolBarReceiver();
    private ToolBarManager tbM = new ToolBarManager();
    
    private ToolBarCommands newPlan;
    private ToolBarCommands loadPlan;
    private ToolBarCommands savePlan;
    private ComponentCommands clearPlan;
    
    private TabbedPane currentTabbedPane;
    
    private InnerPanel innerPanel;
    
	public ToolBarPane(){
		
		toolbarPanel = new JPanel();
        topToolBar = new JToolBar();
        newFloorPlanButton = new JButton();
        loadFloorPlanButton = new JButton();
        saveFloorPlanButton = new JButton();
        undoButton = new JButton();
        redoButton = new JButton();
        clearButton = new JButton();
        removeFloorButton = new JButton();
        
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

	      //Creates the undo button 
	        undoButton.setText("Undo");
	        undoButton.setFocusable(false);
	        undoButton.setHorizontalTextPosition(SwingConstants.CENTER);
	        undoButton.setMaximumSize(new Dimension(50, 40));
	        undoButton.setMinimumSize(new Dimension(29, 30));
	        undoButton.setVerticalTextPosition(SwingConstants.BOTTOM);
	        undoButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	            	undoButtonActionPerformed(evt);
	            }
	        });
	        
	      //Adds the undo button to the toolbar
	        topToolBar.add(undoButton);
	        
	      //Creates the redo button 
	        redoButton.setText("Redo");
	        redoButton.setFocusable(false);
	        redoButton.setHorizontalTextPosition(SwingConstants.CENTER);
	        redoButton.setMaximumSize(new Dimension(50, 40));
	        redoButton.setMinimumSize(new Dimension(29, 30));
	        redoButton.setVerticalTextPosition(SwingConstants.BOTTOM);
	        redoButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	            	redoButtonActionPerformed(evt);
	            }
	        });
	        
	      //Adds the redo button to the toolbar
	        topToolBar.add(redoButton);
	        
	      //Creates the clear button 
	        clearButton.setText("Clear");
	        clearButton.setFocusable(false);
	        clearButton.setHorizontalTextPosition(SwingConstants.CENTER);
	        clearButton.setMaximumSize(new Dimension(50, 40));
	        clearButton.setMinimumSize(new Dimension(29, 30));
	        clearButton.setVerticalTextPosition(SwingConstants.BOTTOM);
	        clearButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	            	clearButtonActionPerformed(evt);
	            }
	        });
	        
	      //Adds the clear button to the toolbar
	        topToolBar.add(clearButton);
	        
		      //Creates the clear button 
	        removeFloorButton.setText("Delete Floor");
	        removeFloorButton.setFocusable(false);
	        removeFloorButton.setHorizontalTextPosition(SwingConstants.CENTER);
	        removeFloorButton.setMaximumSize(new Dimension(100, 40));
	        removeFloorButton.setMinimumSize(new Dimension(29, 30));
	        removeFloorButton.setVerticalTextPosition(SwingConstants.BOTTOM);
	        removeFloorButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	            	removeFloorButtonActionPerformed(evt);
	            }
	        });
	        
	      //Adds the clear button to the toolbar
	        topToolBar.add(removeFloorButton);
	        
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
    	innerPanel = InnerPanel.getInstance();
    	currentTabbedPane = innerPanel.getTabbedPane();
    	savePlan = new SaveCommand(tbR ,currentTabbedPane);
    	tbM.doCurrentCommand(savePlan);
    }                                                   

    private void loadFloorPlanButtonActionPerformed(ActionEvent evt) {                                                    
    	innerPanel = InnerPanel.getInstance();
    	currentTabbedPane = innerPanel.getTabbedPane();
    	loadPlan = new LoadCommand(tbR ,currentTabbedPane);
    	tbM.doCurrentCommand(loadPlan);
    }
    
    private void newFloorPlanButtonActionPerformed(ActionEvent evt) {    
    	innerPanel = InnerPanel.getInstance();
    	currentTabbedPane = innerPanel.getTabbedPane();
    	newPlan = new NewCommand(tbR ,currentTabbedPane);
    	tbM.doCurrentCommand(newPlan);
    }                                                      
	
    private void undoButtonActionPerformed(ActionEvent evt) {                                                    
    	innerPanel = InnerPanel.getInstance();
    	innerPanel.getSelectedFloor().getComponentManager().undo(); 
    } 
    
    private void redoButtonActionPerformed(ActionEvent evt) {                                                    
    	innerPanel = InnerPanel.getInstance();
    	innerPanel.getSelectedFloor().getComponentManager().redo();
    } 
    
    private void clearButtonActionPerformed(ActionEvent evt) {                                                    
    	innerPanel = InnerPanel.getInstance();
    	clearPlan = new ClearComponents();
    	innerPanel.getSelectedFloor().getComponentManager().doCurrentCommand(clearPlan);
    } 
    
    private void removeFloorButtonActionPerformed(ActionEvent evt) {                                                    
    	innerPanel = InnerPanel.getInstance();
    	clearPlan = new ClearComponents();
    	innerPanel.getSelectedFloor().getComponentManager().doCurrentCommand(clearPlan);
    } 
    
}
