package Frame;

import javax.swing.*;

import ComponentCommand.ComponentManager;
import ComponentCommand.ComponentMover;
import ComponentCommand.ComponentReceiver;

import java.awt.*;


public class InnerPanel {
	
	private JPanel leftMenuHeaderPanel;
	private JLabel overallHeaderLabel;

	private JLayeredPane innerContentPanel;
	private TabbedPane tabbedPane;
	private MenuPane menuPane;
	private MainLayeredPane selectedFloor;
	
	private boolean inMenuPane;
	private boolean inMainLayeredPane;
	private boolean createComponent;
	
	private Dimension size = new Dimension(1260, 680);
	
	private String loadedComponents;
	
	private ComponentManager compM;
    private ComponentReceiver compR;
    
	private ComponentMover compMove = new ComponentMover();
	
	private static InnerPanel instance = null;
	
	protected InnerPanel() {
		
		tabbedPane = new TabbedPane();
		menuPane = new MenuPane(tabbedPane);
		innerContentPanel  = new JLayeredPane();
	    leftMenuHeaderPanel = new JPanel();
	    overallHeaderLabel = new JLabel();
	    
	    selectedFloor = (MainLayeredPane)tabbedPane.getGUI().getComponentAt(0);
	    
	    innerContentPanel.addMouseListener(compMove);
	    innerContentPanel.addMouseMotionListener(compMove);
	    
	    innerContentPanel.setPreferredSize(size);
	    innerContentPanel.setMaximumSize(size);
	    
	    leftMenuHeaderPanel.setBackground(new Color(0, 0, 0));
	    leftMenuHeaderPanel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

	    overallHeaderLabel.setBackground(new Color(102, 102, 102));
	    overallHeaderLabel.setForeground(new Color(255, 255, 255));
	    overallHeaderLabel.setHorizontalAlignment(SwingConstants.LEFT);
	    overallHeaderLabel.setText("Building Parts");

	    GroupLayout leftMenuHeaderPanelLayout = new GroupLayout(leftMenuHeaderPanel);
	    leftMenuHeaderPanel.setLayout(leftMenuHeaderPanelLayout);
	    leftMenuHeaderPanelLayout.setHorizontalGroup(
	        leftMenuHeaderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	        .addGroup(leftMenuHeaderPanelLayout.createSequentialGroup()
	            .addContainerGap()
	            .addComponent(overallHeaderLabel, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
	            .addContainerGap(33, Short.MAX_VALUE))
	    );
	    
	    leftMenuHeaderPanelLayout.setVerticalGroup(
	        leftMenuHeaderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	        .addGroup(GroupLayout.Alignment.TRAILING, leftMenuHeaderPanelLayout.createSequentialGroup()
	            .addGap(0, 0, Short.MAX_VALUE)
	            .addComponent(overallHeaderLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
	    );

	    //Adds panels to the LayeredPane
	    innerContentPanel.setLayer(menuPane.getGUI(), JLayeredPane.DEFAULT_LAYER);
	    innerContentPanel.setLayer(tabbedPane.getGUI(), JLayeredPane.DEFAULT_LAYER);
	    innerContentPanel.setLayer(leftMenuHeaderPanel, JLayeredPane.DEFAULT_LAYER);
	    
	    //Creates the group layout for the innerContentPane
	    GroupLayout innerContentPaneLayout = new GroupLayout(innerContentPanel);
	    innerContentPanel.setLayout(innerContentPaneLayout);
	    innerContentPaneLayout.setHorizontalGroup(
	        innerContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	        .addGroup(innerContentPaneLayout.createSequentialGroup()
	            .addGroup(innerContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
	                .addComponent(menuPane.getGUI(), GroupLayout.PREFERRED_SIZE, 0, 300)
	                .addComponent(leftMenuHeaderPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	            .addComponent(tabbedPane.getGUI(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	    );
	    
	    innerContentPaneLayout.setVerticalGroup(
	        innerContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	        .addGroup(innerContentPaneLayout.createSequentialGroup()
	            .addGroup(innerContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                .addGroup(innerContentPaneLayout.createSequentialGroup()
	                    .addComponent(leftMenuHeaderPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                    .addComponent(menuPane.getGUI(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 605))
	                .addComponent(tabbedPane.getGUI(), 0, 650, GroupLayout.PREFERRED_SIZE))
	            .addContainerGap())
	    );    
	    
	}

	//------------------------------------------------------------------------------------------------
	
	public static InnerPanel getInstance() {
		   if(instance == null) {
		      instance = new InnerPanel();
		   }
		   return instance;
	}
	
	//------------------------------------------------------------------------------------------------
	
	public JLayeredPane getGUI(){
		return innerContentPanel;
	}

	public TabbedPane getTabbedPane(){
		return tabbedPane;
	}
	
	public MainLayeredPane getSelectedFloor(){
		return selectedFloor;
	}
	
	public JPanel getMenuPane(){
		return menuPane;
	}

	public boolean getInMenuPane(){
		return inMenuPane;
	}
	
	public boolean getInMainLayeredPane(){
		return inMainLayeredPane;
	}
	
	public boolean getCreateComponent(){
		return createComponent;
	}
	
	public ComponentManager getComponentManager(){
		return compM;
	}
	
	public ComponentReceiver getComponentReceiver(){
		return compR;
	}
	
	public String getLoadedComponents(){
		return loadedComponents;
	}
	
	//------------------------------------------------------------------------------------------------
	
	public void setSelectedFloor(MainLayeredPane m){
		selectedFloor = m;
	}
	
	public void setInMenuPane(Boolean m){
		inMenuPane = m;
	}
	
	public void setInMainLayeredPane(Boolean m){
		inMainLayeredPane = m;
	}
	
	public void setCreateComponent(Boolean m){
		createComponent = m;
	}
	
	public void setComponentManager(ComponentManager cM){
		compM = cM;
	}
	
	public void setComponentReceiver(ComponentReceiver cR){
		compR = cR;
	}
	
	public void setLoadedComponents(String loaded){
		loadedComponents = loaded;
	}
	
	//------------------------------------------------------------------------------------------------
	
}