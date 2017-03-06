package Frame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * Class that creates everything in the left tabbed panel. 
 * 
 */
public class TabbedPane extends MouseAdapter {

	// Variables declaration                  
    private JButton addTabButton;
    private JTabbedPane floorTabPanel;
    private JLayeredPane mainLayeredPanel;
    private int tabCounter = 1;
	
	public TabbedPane() {
		
	//Creates floorTabPanel
    floorTabPanel = new JTabbedPane();
    floorTabPanel.setBackground(new Color(255, 255, 255));
    floorTabPanel.setFocusable(false);

  //------------------------------------------------------------------------------
    
    //Creates mainLayeredPanel inside of the floorTabPanel
    mainLayeredPanel = new MainLayeredPane();

  //Adds the mainLayeredPanel to the floorTabPanel
    floorTabPanel.addTab("Floor 1", mainLayeredPanel);

  //------------------------------------------------------------------------------

    //Creates the button that will add new tabs to the TabbedPane
    addTabButton = new JButton(); 
    addTabButton.setText("+");
    addTabButton.setOpaque (false); //
    addTabButton.setBorder (null);
    addTabButton.setContentAreaFilled (false);
    addTabButton.setFocusPainted (false);
    addTabButton.setFocusable (false);
    addTabButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
        	insertTab();
//        	addTabButtonActionPerformed(evt);
        }
    });
    
    //Adds the button to the TabbedPane
//    floorTabPanel.addTab("+", addTabButton);
    insertTab();
	}
	
	
	public void mouseClicked(MouseEvent e){
		
	}
	
	//Gets the current floorTabPanel
	public JTabbedPane getGUI(){
		return floorTabPanel;
	}
	private void insertTab(){
		String title = "Floor " + String.valueOf (floorTabPanel.getTabCount ());

		floorTabPanel.insertTab(title, null, new MainLayeredPane(), "", floorTabPanel.getTabCount() - 1 );
	    
	    if (tabCounter >= 0) {
	        JPanel pnl = new JPanel();
	        pnl.setOpaque(false);
	        pnl.add(addTabButton);
	        floorTabPanel.setTabComponentAt(floorTabPanel.getTabCount() - 1, pnl);
	        floorTabPanel.setSelectedIndex(floorTabPanel.getTabCount() - 2);
	        floorTabPanel.setEnabledAt(floorTabPanel.getTabCount()-1, false);	    	
	      }

	      tabCounter++;
	    }

//	}
	
	//Removes all the current tabs and adds the default 
	public void removeAll(){
		
		
	}
	
}
