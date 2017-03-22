package Frame;

import java.awt.*;
import java.awt.event.*;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 * Class that creates everything in the left tabbed panel. 
 * 
 */
public class TabbedPane implements ChangeListener{

	// Variables declaration                  
    private JButton addTabButton;
    private JTabbedPane floorTabPanel;
	private MainLayeredPane selectedPane;
    
    private InnerPanel innerPanel;
    
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
	
	public void stateChanged(ChangeEvent event) {
    	
        if (event.getSource() instanceof JTabbedPane) {
        	innerPanel = InnerPanel.getInstance();
            JTabbedPane pane = (JTabbedPane)event.getSource();
            index = pane.getSelectedIndex();
            selectedPane = (MainLayeredPane)pane.getComponentAt(index);
            innerPanel.setSelectedFloor(selectedPane);             
        }

    }
	
}
