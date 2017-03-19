package Frame;

import java.awt.*;
import java.awt.event.*;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 * Class that creates everything in the left tabbed panel. 
 * 
 */
public class TabbedPane {

	// Variables declaration                  
    private JButton addTabButton;
    protected JTabbedPane floorTabPanel;
    public MainLayeredPane mainLayeredPanel;
    private int tabCounter = 1;
	private TabButton removeButton;
	
	
	public TabbedPane() {
		
	//Creates floorTabPanel
    floorTabPanel = new JTabbedPane();
    floorTabPanel.setBackground(new Color(155, 155, 155));
    floorTabPanel.setFocusable(false);

  //------------------------------------------------------------------------------
    
    //Creates mainLayeredPanel inside of the floorTabPanel
    mainLayeredPanel = new MainLayeredPane();

  //Adds the mainLayeredPanel to the floorTabPanel
    removeButton = new TabButton();
	mainLayeredPanel.add(removeButton);
	
    floorTabPanel.addTab("Floor 1", mainLayeredPanel);

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
	
	public MainLayeredPane getMainLayeredPanel(){
    	return mainLayeredPanel;
    }
	
	private void insertTab(){
		String title = "Floor " + String.valueOf (floorTabPanel.getTabCount ());
	    
	    if (tabCounter >= 0 && tabCounter < 100) {
	        JPanel pnl = new JPanel();
	        pnl.setOpaque(false);
			floorTabPanel.insertTab(title, null, new MainLayeredPane(), "", floorTabPanel.getTabCount() - 1 );
	        pnl.add(addTabButton);
	        floorTabPanel.setTabComponentAt(floorTabPanel.getTabCount() - 1, pnl);
	        floorTabPanel.setSelectedIndex(floorTabPanel.getTabCount() - 2);
	        floorTabPanel.setEnabledAt(floorTabPanel.getTabCount()-1, false);	    	
		    tabCounter++;  
	    }
	   
    }
	
	//Removes all the current tabs and adds the default 
	public void removeAll(){
		for(int i = floorTabPanel.getTabCount(); i > 1  ; i--){
			floorTabPanel.remove(i-2);			
		}
		tabCounter = floorTabPanel.getTabCount();

		insertTab();
	}
	
	
	private class TabButton extends JButton implements ActionListener {
		
	    public TabButton() {
	        int size = 17;
	        setPreferredSize(new Dimension(size, size));
	        setToolTipText("close this tab");
	        //Make the button looks the same for all Laf's
	        setUI(new BasicButtonUI());
	        //Make it transparent
	        setContentAreaFilled(false);
	        //No need to be focusable
	        setFocusable(false);
	        setBorder(BorderFactory.createEtchedBorder());
	        setBorderPainted(false);
	        //Making nice rollover effect
	        //we use the same listener for all buttons
	        addMouseListener(buttonMouseListener);
	        setRolloverEnabled(true);
	        //Close the proper tab by clicking the button
	        addActionListener(this);
	    }
	    

	    public void actionPerformed(ActionEvent e) {
	        int i = floorTabPanel.indexOfTabComponent(floorTabPanel);
	        if (i != -1) {
	            floorTabPanel.remove(i);
	        }
	    }

	    //we don't want to update UI for this button
	    public void updateUI() {
	    }

	    //paint the cross
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        Graphics2D g2 = (Graphics2D) g.create();
	        //shift the image for pressed buttons
	        if (getModel().isPressed()) {
	            g2.translate(1, 1);
	        }
	        g2.setStroke(new BasicStroke(2));
	        g2.setColor(Color.BLACK);
	        if (getModel().isRollover()) {
	            g2.setColor(Color.MAGENTA);
	        }
	        int delta = 6;
	        g2.drawLine(delta, delta, getWidth() - delta - 1, getHeight() - delta - 1);
	        g2.drawLine(getWidth() - delta - 1, delta, delta, getHeight() - delta - 1);
	        g2.dispose();
	    }
	}

	private final static MouseListener buttonMouseListener = new MouseAdapter() {
	    public void mouseEntered(MouseEvent e) {
	        Component component = e.getComponent();
	        if (component instanceof AbstractButton) {
	            AbstractButton button = (AbstractButton) component;
	            button.setBorderPainted(true);
	        }
	    }

	    public void mouseExited(MouseEvent e) {
	        Component component = e.getComponent();
	        if (component instanceof AbstractButton) {
	            AbstractButton button = (AbstractButton) component;
	            button.setBorderPainted(false);
	        }
	    }
	};
	
	
	



}
