package Frame;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Class that creates everything in the left tabbed panel. 
 * 
 */
public class TabbedPane implements ChangeListener{

	// Variables declaration                  
    private JButton addTabButton;
    private JTabbedPane floorTabPanel;
	private MainLayeredPane selectedTab;
	private MainLayeredPane previousTab;
    
	private Component[] onGrid;
	private String wallType;
	private FloorComponent wallComponent;
	private AbstractFloorComponentFactory wallFactory = FloorComponentFactoryProducer.getFactory("WALL");
	
    private InnerPanel innerPanel;
    
    //Regular express to find wall components
    String pattern = ".*Wall..";
    
	private int tabNumber = 0;
	private int index = 0;
	
	public TabbedPane() {
		
	//Creates floorTabPanel
    floorTabPanel = new JTabbedPane();
    floorTabPanel.setBackground(new Color(155, 155, 155));
    floorTabPanel.setFocusable(false);
    
  //------------------------------------------------------------------------------
    
    //Adds the initial floor to the tab panel 
    floorTabPanel.addTab("Floor 1", new MainLayeredPane(tabNumber));
    
  //------------------------------------------------------------------------------

    //Creates the button that will add new tabs to the TabbedPane
    addTabButton = new JButton(); 
    addTabButton.setText("  +  ");
    addTabButton.setOpaque (false); //
    addTabButton.setBorder (null);
    addTabButton.setContentAreaFilled(false);
    addTabButton.setFocusPainted (false);
    addTabButton.setFocusable (false);
    addTabButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
        	insertTab();
        	addWallComponents();
        }
    });
    
    insertTab();
    
	}
	
	//Gets the current floorTabPanel
	public JTabbedPane getGUI(){
		return floorTabPanel;
	}
	
	
	private void insertTab(){
		tabNumber++;
		String title = "Floor " + String.valueOf (floorTabPanel.getTabCount());
		System.out.println(floorTabPanel.getTabCount());
	    System.out.println(title);
	    if (tabNumber >= 0 && tabNumber < 17) {
	        JPanel pnl = new JPanel();
	        pnl.setOpaque(false);
			floorTabPanel.insertTab(title, null, new MainLayeredPane(tabNumber), "", floorTabPanel.getTabCount() - 1);
	        pnl.add(addTabButton);
	        floorTabPanel.setTabComponentAt(floorTabPanel.getTabCount() - 1, pnl);
	        floorTabPanel.setSelectedIndex(floorTabPanel.getTabCount() - 2);
	        floorTabPanel.setEnabledAt(floorTabPanel.getTabCount()-1, false);	
	        floorTabPanel.addChangeListener(this);
	 
	    } 
    }
	
	//Removes all the current tabs and adds the default 
	public void removeAll(){
		for(int i = floorTabPanel.getTabCount(); i > 1  ; i--){
			floorTabPanel.remove(i-2);
		}
		tabNumber = floorTabPanel.getTabCount();
		insertTab();
	}
	
	//Adds copies of all wall components of the previous layer to the new layer 
	public void addWallComponents(){
		innerPanel = InnerPanel.getInstance();
		previousTab = (MainLayeredPane)floorTabPanel.getComponentAt(tabNumber - 2);
		onGrid = previousTab.getGlassPanel().getComponents();
		
		Pattern wallPattern = Pattern.compile(pattern);
		
		for(int i = 0; i < onGrid.length; i++){
			Matcher m = wallPattern.matcher(onGrid[i].toString());
			if(m.find()){
				wallType = ((FloorComponent) onGrid[i]).getComponentType();
				wallComponent = wallFactory.getComponent(wallType);
				innerPanel.getSelectedFloor().getGlassPanel().add(wallComponent);
				wallComponent.setLocation(onGrid[i].getLocation());
				wallComponent.setSize(onGrid[i].getSize());
				wallComponent.setVisible(true);
				wallComponent.setIsOnGrid(true);
				System.out.println(onGrid[i].toString());
			}
		}
		previousTab.repaint();
		previousTab.revalidate();
	}
	
	public String floorsToString(){
		
		String allComponents = "";
		
		innerPanel = InnerPanel.getInstance();
		
		for(int i = 0; i < tabNumber - 1; i++){
			MainLayeredPane currentFloor = (MainLayeredPane)floorTabPanel.getComponentAt(tabNumber);
			Component[] componentGrid = currentFloor.getGlassPanel().getComponents();
			for(int j = 0; j < onGrid.length; j++){
				String temp = componentGrid[i].toString();
				if(i == 0){
					allComponents = "$ " + temp + " || ";
				}
				else {
					allComponents = allComponents + temp + " || ";
				}
			}
			allComponents = allComponents + " %%%% ";
		}
		allComponents = allComponents + " $";
		
		return allComponents;
	}
	
	public void stateChanged(ChangeEvent event) {
    	
        if (event.getSource() instanceof JTabbedPane) {
        	innerPanel = InnerPanel.getInstance();
            JTabbedPane pane = (JTabbedPane)event.getSource();
            index = pane.getSelectedIndex();
            selectedTab = (MainLayeredPane)pane.getComponentAt(index);
            innerPanel.setSelectedFloor(selectedTab);             
        }

    }
	
}
