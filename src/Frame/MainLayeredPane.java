package Frame;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import ComponentCommand.ComponentManager;
import ComponentCommand.ComponentReceiver;
import FloorComponent.*;

public class MainLayeredPane extends JLayeredPane {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel glassPanel;
    private Grid gridPanel;
	
    private int tabNumber = 0;
    
    private ComponentManager compM;
    private ComponentReceiver compR;
    
    private InnerPanel innerPanel;
    
    private Dimension size = new Dimension(1050, 600);
    
	public MainLayeredPane(int num){
		
		this.tabNumber = num;
		
	    setOpaque(true);
	    setVisible(true);

	 //------------------------------------------------------------------------------
	    
	  //Creates the Command pattern for each floor
	    compM = new ComponentManager();
	    compR = new ComponentReceiver();
	    
	 //------------------------------------------------------------------------------
	    
	  //Creates the glassPanel layer that will lay on top of the canvas and act as the drag layer
	    glassPanel = new JPanel();
	    glassPanel.setBackground(new Color(0, 0, 0));
	    glassPanel.setOpaque(false);
	    glassPanel.setPreferredSize(size);
	    
	 //------------------------------------------------------------------------------
	    
	  //Creates the gridPanel that will represent the grid under the glassPanel
	    gridPanel = new Grid();
	    gridPanel.setPreferredSize(size);
	    
	 //------------------------------------------------------------------------------  
	    
	  //Creates the layouts for the mainLayeredPanel and the glassPanel 
	    GroupLayout glassPanelLayout = new GroupLayout(glassPanel);
	    glassPanel.setLayout(glassPanelLayout);
	    glassPanelLayout.setHorizontalGroup(
	        glassPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	        .addGap(0, 0, Short.MAX_VALUE)
	    );
	    glassPanelLayout.setVerticalGroup(
	        glassPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	        .addGap(0, 0, Short.MAX_VALUE)
	    );
	    
	  //Sets the layers in the layeredPanel
	    setLayer(gridPanel, JLayeredPane.DEFAULT_LAYER);
	    setLayer(glassPanel, JLayeredPane.DRAG_LAYER);
	    
	    GroupLayout mainLayeredPanelLayout = new GroupLayout(this);
	    setLayout(mainLayeredPanelLayout);
	    mainLayeredPanelLayout.setHorizontalGroup(
	        mainLayeredPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	        .addComponent(glassPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 1060)
	        .addGroup(mainLayeredPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addComponent(gridPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE))
	    );
	    mainLayeredPanelLayout.setVerticalGroup(
	        mainLayeredPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	        .addGroup(GroupLayout.Alignment.TRAILING, mainLayeredPanelLayout.createSequentialGroup()
	            .addComponent(glassPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, 600)
	            .addGap(0, 0, Short.MAX_VALUE))
	        .addGroup(mainLayeredPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addComponent(gridPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE))
	    );
	    
	 //------------------------------------------------------------------------------
	    
	    addMouseListener(new MouseAdapter(){
			@Override 
			public void mouseEntered(MouseEvent e){			
				if(e.getSource() instanceof MainLayeredPane){
					System.out.println("Entered the MainLayeredPane");
					if(e.getSource() instanceof FloorComponent){
						innerPanel = InnerPanel.getInstance();
						System.out.println("Component on the MainLayeredPane");
						innerPanel.setInMainLayeredPane(true);
					}
				}
			}
			
			@Override 
			public void mouseExited(MouseEvent e){
				if((e.getSource() instanceof MainLayeredPane)){
					innerPanel = InnerPanel.getInstance();
					System.out.println("Exited the MainLayeredPane");
					innerPanel.setInMainLayeredPane(false);
				}
			}               
	    });
	    
	//------------------------------------------------------------------------------
	    
	}

	//------------------------------------------------------------------------------
	
	public ComponentManager getComponentManager(){
		return compM;
	}
	
	public ComponentReceiver getComponentReceiver(){
		return compR;
	}
	
	//------------------------------------------------------------------------------
	
	public void addToGlassPane(Component c){
		glassPanel.add(c);
	}
	
	public JPanel getGlassPanel(){
		return glassPanel;
	}
	
	//------------------------------------------------------------------------------
}

	






