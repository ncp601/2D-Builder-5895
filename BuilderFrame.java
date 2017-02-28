package Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

    
public class BuilderFrame extends JFrame {

	private JLayeredPane addLayeredPanel;
    private JButton bathroomButton;
    private JPanel bathroomMenuPanel;
    private JButton bedroomButton;
    private JPanel bedroomMenuPanel;
    private JPanel contentPanel;
    private JButton dinningRoomButton;
    private JPanel dinningRoomMenuPanel;
    private JButton doorButton;
    private JPanel doorsMenuPanel;
    private JButton elevatorButton;
    private JPanel elevatorMenuPanel;
    private JTabbedPane floorTabPanel;
    private JButton flooringButton;
    private JLabel furnitureLabel;
    private JButton garageButton;
    private JPanel garageMenuPanel;
    private JPanel glassPanel;
    private Canvas gridCanvas;
    private JButton kitchenButton;
    private JPanel kitchenMenuPanel;
    private JButton laundryButton;
    private JPanel laundryMenuPanel;
    private JPanel leftMenuHeaderPanel;
    private JPanel leftMenuPanel;
    private JButton livingRoomButton;
    private JPanel livingRoomMenuPanel;
    private JButton loadFloorPlanButton;
    private JLayeredPane mainLayeredPanel;
    private JPanel mainMenuPanel;
    private JSeparator menuSeparator;
    private JButton newFloorPlanButton;
    private JButton officeButton;
    private JPanel officeMenuPanel;
    private JLabel overallHeaderLabel;
    private JPanel rootPanel;
    private JButton saveFloorPlanButton;
    private JButton stairsButton;
    private JPanel stairsMenuPanel;
    private JLabel structureLabel;
    private JPanel toolbarPanel;
    private JToolBar topToolBar;
    private JButton wallsButton;
    private JPanel wallsMenuPanel;
    private JButton windowsButton;
    private JPanel windowsMenuPanel;
	
    /**
     * Creates new form BuilderFrame
     */
    public BuilderFrame() {
        initComponents();
    }
                
    private void initComponents() {

        //rootPanel = new JPanel();
        //contentPanel = new JPanel();
        //floorTabPanel = new JTabbedPane();
        //mainLayeredPanel = new JLayeredPane();
        //gridCanvas = new Canvas();
        //glassPanel = new JPanel();
        //addLayeredPanel = new JLayeredPane();
        //leftMenuPanel = new JPanel();
        //wallsMenuPanel = new JPanel();
        //stairsMenuPanel = new JPanel();
        //elevatorMenuPanel = new JPanel();
        //doorsMenuPanel = new JPanel();
        //windowsMenuPanel = new JPanel();
        //livingRoomMenuPanel = new JPanel();
        //dinningRoomMenuPanel = new JPanel();
        //bedroomMenuPanel = new JPanel();
        //kitchenMenuPanel = new JPanel();
        //officeMenuPanel = new JPanel();
        //bathroomMenuPanel = new JPanel();
        //laundryMenuPanel = new JPanel();
        //garageMenuPanel = new JPanel();
        //mainMenuPanel = new JPanel();
        //structureLabel = new JLabel();
        //wallsButton = new JButton();
        //stairsButton = new JButton();
        //elevatorButton = new JButton();
        //doorButton = new JButton();
        //windowsButton = new JButton();
        //menuSeparator = new JSeparator();
        //furnitureLabel = new JLabel();
        //flooringButton = new JButton();
        //dinningRoomButton = new JButton();
        //kitchenButton = new JButton();
        //officeButton = new JButton();
        //bedroomButton = new JButton();
        //bathroomButton = new JButton();
        //laundryButton = new JButton();
        //garageButton = new JButton();
        //livingRoomButton = new JButton();
        //toolbarPanel = new JPanel();
        //topToolBar = new JToolBar();
        //newFloorPlanButton = new JButton();
        //loadFloorPlanButton = new JButton();
        //saveFloorPlanButton = new JButton();
        //leftMenuHeaderPanel = new JPanel();
        //overallHeaderLabel = new JLabel();

    	//Sets the properties for the JFrame
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("2d - Builder");
        setBackground(new Color(0, 0, 0));
        setMaximumSize(new Dimension(1280, 720));
        setPreferredSize(new Dimension(1280, 720));
        setResizable(false);
        setSize(new Dimension(1280, 720));

        //Creates root panel 
        rootPanel = new JPanel();
        	rootPanel.setBackground(new Color(0, 0, 0));
        
      //------------------------------------------------------------------------------
        
        //Creates content panel
        contentPanel = new JPanel();
        	contentPanel.setBackground(new Color(0, 0, 0));

      //------------------------------------------------------------------------------        
        
        //Creates floorTabPanel
        floorTabPanel = new JTabbedPane();
	        floorTabPanel.setBackground(new Color(255, 255, 255));
	        floorTabPanel.setFocusable(false);

      //------------------------------------------------------------------------------
        
        //Creates mainLayeredPanel inside of the floorTabPanel
        mainLayeredPanel = new JLayeredPane();
        	mainLayeredPanel.setOpaque(true);

      //------------------------------------------------------------------------------
        
        //Creates the Canvas layer that will display the grid 
        gridCanvas = new Canvas();
        
      //------------------------------------------------------------------------------
        
        //Creates the glassPanel layer that will lay on top of the canvas and act as the drag layer
        glassPanel = new JPanel();
	        glassPanel.setBackground(new Color(255, 255, 255));
	        glassPanel.setOpaque(false);

        //Creates the layouts for the mainLayeredPanel and the glassPanel 
        GroupLayout glassPanelLayout = new GroupLayout(glassPanel);
        glassPanel.setLayout(glassPanelLayout);
        glassPanelLayout.setHorizontalGroup(
            glassPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 1077, Short.MAX_VALUE)
        );
        glassPanelLayout.setVerticalGroup(
            glassPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 653, Short.MAX_VALUE)
        );

        //Sets the layers in the layeredPanel
        mainLayeredPanel.setLayer(gridCanvas, JLayeredPane.DEFAULT_LAYER);
        mainLayeredPanel.setLayer(glassPanel, JLayeredPane.DRAG_LAYER);

        GroupLayout mainLayeredPanelLayout = new GroupLayout(mainLayeredPanel);
        mainLayeredPanel.setLayout(mainLayeredPanelLayout);
        mainLayeredPanelLayout.setHorizontalGroup(
            mainLayeredPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(glassPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainLayeredPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(mainLayeredPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(gridCanvas, GroupLayout.PREFERRED_SIZE, 1077, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        
        mainLayeredPanelLayout.setVerticalGroup(
            mainLayeredPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(mainLayeredPanelLayout.createSequentialGroup()
                .addComponent(glassPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(mainLayeredPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(mainLayeredPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(gridCanvas, GroupLayout.PREFERRED_SIZE, 652, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
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
            .addGap(0, 1077, Short.MAX_VALUE)
        );
        addLayeredPanelLayout.setVerticalGroup(
            addLayeredPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 652, Short.MAX_VALUE)
        );

        //Adds the addLayeredPanel to the floorTabPanel
        floorTabPanel.addTab("+", addLayeredPanel);

      //------------------------------------------------------------------------------
        
        //Creates the leftMenuPanel that will hold all the components that can be dragged into a plan
        leftMenuPanel = new JPanel();
	        leftMenuPanel.setBackground(new Color(153, 153, 153));
	        leftMenuPanel.setForeground(new Color(255, 255, 255));
	        leftMenuPanel.setLayout(new CardLayout());

	  //------------------------------------------------------------------------------
	        
	    //Creates the wallsMenuPanel that will hold wall components    
	    wallsMenuPanel = new JPanel();    
	        wallsMenuPanel.setLayout(new GridLayout(5, 2));
	        leftMenuPanel.add(wallsMenuPanel, "card3");

	  //------------------------------------------------------------------------------	        
	        
	    //Creates the stairsMenuPanel that will hold stairs components   
	    stairsMenuPanel = new JPanel();
        	stairsMenuPanel.setLayout(new GridLayout(5, 2));
        	leftMenuPanel.add(stairsMenuPanel, "card3");
        	
      //------------------------------------------------------------------------------
        	
        //Creates the elevatorMenuPanel that will hold elevator components
        elevatorMenuPanel = new JPanel();
        	elevatorMenuPanel.setLayout(new GridLayout(5, 2));
        	leftMenuPanel.add(elevatorMenuPanel, "card3");

     //------------------------------------------------------------------------------
        	
        //Creates the doorsMenuPanel that will hold door components
        doorsMenuPanel = new JPanel();
        	doorsMenuPanel.setLayout(new GridLayout(5, 2));
        	leftMenuPanel.add(doorsMenuPanel, "card3");

     //------------------------------------------------------------------------------
        	
        //Creates the windowsMenuPanel that will hold window components
        windowsMenuPanel = new JPanel();
        	windowsMenuPanel.setLayout(new GridLayout(5, 2));
        	leftMenuPanel.add(windowsMenuPanel, "card3");
        	
     //------------------------------------------------------------------------------
        	
        //Creates the livingRoomMenuPanel that will hold living room components
        livingRoomMenuPanel = new JPanel();
        	livingRoomMenuPanel.setLayout(new GridLayout(5, 2));
        	leftMenuPanel.add(livingRoomMenuPanel, "card3");

     //------------------------------------------------------------------------------
        	
        //Creates the dinningRoomMenuPanel that will hold dinning room components
        dinningRoomMenuPanel = new JPanel();
	        dinningRoomMenuPanel.setLayout(new GridLayout(5, 2));
	        leftMenuPanel.add(dinningRoomMenuPanel, "card3");

	 //------------------------------------------------------------------------------
	        
        //Creates the bedroomMenuPanel that will hold wall components
        bedroomMenuPanel = new JPanel();
	        bedroomMenuPanel.setLayout(new GridLayout(5, 2));
	        leftMenuPanel.add(bedroomMenuPanel, "card3");

	 //------------------------------------------------------------------------------
	        
        //Creates the kitchenMenuPanel that will hold kitchen components
        kitchenMenuPanel = new JPanel();
	        kitchenMenuPanel.setLayout(new GridLayout(5, 2));
	        leftMenuPanel.add(kitchenMenuPanel, "card3");

	 //------------------------------------------------------------------------------
	        
        //Creates the officeMenuPanel that will hold office components
        officeMenuPanel = new JPanel();
	        officeMenuPanel.setLayout(new GridLayout(5, 2));
	        leftMenuPanel.add(officeMenuPanel, "card3");

	  //------------------------------------------------------------------------------  
	        
        //Creates the bathroomMenuPanel that will hold bathroom components
        bathroomMenuPanel = new JPanel();
	        bathroomMenuPanel.setLayout(new GridLayout(5, 2));
	        leftMenuPanel.add(bathroomMenuPanel, "card3");

	  //------------------------------------------------------------------------------ 
	        
        //Creates the laundryMenuPanel that will hold laundry components
        laundryMenuPanel = new JPanel();
	        laundryMenuPanel.setLayout(new GridLayout(5, 2));
	        leftMenuPanel.add(laundryMenuPanel, "card3");

	  //------------------------------------------------------------------------------   
	        
        //Creates the garageMenuPanel that will hold garage components
        garageMenuPanel = new JPanel();
	        garageMenuPanel.setLayout(new GridLayout(5, 2));
	        leftMenuPanel.add(garageMenuPanel, "card3");

	  //------------------------------------------------------------------------------
	        
	    //Creates the mainMenuPanel that will hold all the possible categories for components
	    //This Panel will also hold the controls for the card layout
	    mainMenuPanel = new JPanel();    
	    
	    //Creates the first header on the main menu
	    structureLabel = new JLabel();
        structureLabel.setText("Structure");
        
        //Creates the wallsButton button
        wallsButton = new JButton();
	        wallsButton.setText("Walls");
	        wallsButton.setBorder(null);
	        wallsButton.setBorderPainted(false);
	        wallsButton.setContentAreaFilled(false);
	        wallsButton.setDefaultCapable(false);
	        wallsButton.setFocusPainted(false);
	        wallsButton.setHorizontalAlignment(SwingConstants.LEFT);
	        wallsButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                wallsButtonActionPerformed(evt);
	            }
	        });
	        
	    //Creates the stairsButton button   
	    stairsButton = new JButton();
	        stairsButton.setText("Stairs");
	        stairsButton.setBorder(null);
	        stairsButton.setBorderPainted(false);
	        stairsButton.setContentAreaFilled(false);
	        stairsButton.setDefaultCapable(false);
	        stairsButton.setFocusPainted(false);
	        stairsButton.setHorizontalAlignment(SwingConstants.LEFT);
	        stairsButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                stairsButtonActionPerformed(evt);
	            }
	        });
	        
	    //Creates the elevatorButton button   
	    elevatorButton = new JButton();
	        elevatorButton.setText("Elevators");
	        elevatorButton.setBorder(null);
	        elevatorButton.setBorderPainted(false);
	        elevatorButton.setContentAreaFilled(false);
	        elevatorButton.setDefaultCapable(false);
	        elevatorButton.setFocusPainted(false);
	        elevatorButton.setHorizontalAlignment(SwingConstants.LEFT);
	        elevatorButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                elevatorButtonActionPerformed(evt);
	            }
	        });

	    //Creates the doorButton button    
	    doorButton = new JButton();
	        doorButton.setText("Doors");
	        doorButton.setBorder(null);
	        doorButton.setBorderPainted(false);
	        doorButton.setContentAreaFilled(false);
	        doorButton.setDefaultCapable(false);
	        doorButton.setFocusPainted(false);
	        doorButton.setHorizontalAlignment(SwingConstants.LEFT);
	        doorButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                doorButtonActionPerformed(evt);
	            }
	        });

        //Creates the windowsButton button
	    windowsButton = new JButton();
	        windowsButton.setText("Windows");
	        windowsButton.setBorder(null);
	        windowsButton.setBorderPainted(false);
	        windowsButton.setContentAreaFilled(false);
	        windowsButton.setDefaultCapable(false);
	        windowsButton.setFocusPainted(false);
	        windowsButton.setHorizontalAlignment(SwingConstants.LEFT);
	        windowsButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                windowsButtonActionPerformed(evt);
	            }
	        });

	     //Creates Separator   
	     menuSeparator = new JSeparator();
	        
        //Creates the second header on the main menu
	    furnitureLabel = new JLabel();
        	furnitureLabel.setText("Furniture");
        
        //Creates the flooringButton button	
        flooringButton = new JButton();
	        flooringButton.setText("Flooring");
	        flooringButton.setBorder(null);
	        flooringButton.setBorderPainted(false);
	        flooringButton.setContentAreaFilled(false);
	        flooringButton.setDefaultCapable(false);
	        flooringButton.setFocusPainted(false);
	        flooringButton.setHorizontalAlignment(SwingConstants.LEFT);
	        flooringButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                flooringButtonActionPerformed(evt);
	            }
	        });

	    //Creates the dinningRoomButton button 
        dinningRoomButton = new JButton();
	        dinningRoomButton.setText("Dinning Room");
	        dinningRoomButton.setBorder(null);
	        dinningRoomButton.setBorderPainted(false);
	        dinningRoomButton.setContentAreaFilled(false);
	        dinningRoomButton.setDefaultCapable(false);
	        dinningRoomButton.setFocusPainted(false);
	        dinningRoomButton.setHorizontalAlignment(SwingConstants.LEFT);
	        dinningRoomButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                dinningRoomButtonActionPerformed(evt);
	            }
	        });

	    //Creates the kitchenButton button
	    kitchenButton = new JButton();
	        kitchenButton.setText("Kitchen");
	        kitchenButton.setBorder(null);
	        kitchenButton.setBorderPainted(false);
	        kitchenButton.setContentAreaFilled(false);
	        kitchenButton.setDefaultCapable(false);
	        kitchenButton.setFocusPainted(false);
	        kitchenButton.setHorizontalAlignment(SwingConstants.LEFT);
	        kitchenButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                kitchenButtonActionPerformed(evt);
	            }
	        });

	    //Creates the officeButton button
	    officeButton = new JButton();
	        officeButton.setText("Office");
	        officeButton.setBorder(null);
	        officeButton.setBorderPainted(false);
	        officeButton.setContentAreaFilled(false);
	        officeButton.setDefaultCapable(false);
	        officeButton.setFocusPainted(false);
	        officeButton.setHorizontalAlignment(SwingConstants.LEFT);
	        officeButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                officeButtonActionPerformed(evt);
	            }
	        });

	    //Creates the bedroomButton button    
	    bedroomButton = new JButton();   
	        bedroomButton.setText("Bedroom");
	        bedroomButton.setBorder(null);
	        bedroomButton.setBorderPainted(false);
	        bedroomButton.setContentAreaFilled(false);
	        bedroomButton.setDefaultCapable(false);
	        bedroomButton.setFocusPainted(false);
	        bedroomButton.setHorizontalAlignment(SwingConstants.LEFT);
	        bedroomButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                bedroomButtonActionPerformed(evt);
	            }
	        });

	    //Creates the bathroomButton button    
	    bathroomButton = new JButton();   
	        bathroomButton.setText("Bathroom");
	        bathroomButton.setBorder(null);
	        bathroomButton.setBorderPainted(false);
	        bathroomButton.setContentAreaFilled(false);
	        bathroomButton.setDefaultCapable(false);
	        bathroomButton.setFocusPainted(false);
	        bathroomButton.setHorizontalAlignment(SwingConstants.LEFT);
	        bathroomButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                bathroomButtonActionPerformed(evt);
	            }
	        });

	    //Creates the laundryButton button
        laundryButton = new JButton();   
	        laundryButton.setText("Laundry");
	        laundryButton.setActionCommand("Laundry");
	        laundryButton.setBorder(null);
	        laundryButton.setBorderPainted(false);
	        laundryButton.setContentAreaFilled(false);
	        laundryButton.setDefaultCapable(false);
	        laundryButton.setFocusPainted(false);
	        laundryButton.setHorizontalAlignment(SwingConstants.LEFT);
	        laundryButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                laundryButtonActionPerformed(evt);
	            }
	        });

	    //Creates the garageButton button    
        garageButton = new JButton(); 
	        garageButton.setText("Garage");
	        garageButton.setBorder(null);
	        garageButton.setBorderPainted(false);
	        garageButton.setContentAreaFilled(false);
	        garageButton.setDefaultCapable(false);
	        garageButton.setFocusPainted(false);
	        garageButton.setHorizontalAlignment(SwingConstants.LEFT);
	        garageButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                garageButtonActionPerformed(evt);
	            }
	        });

	    //Creates the livingRoomButton button    
        livingRoomButton = new JButton();  
	        livingRoomButton.setText("Living Room");
	        livingRoomButton.setBorder(null);
	        livingRoomButton.setBorderPainted(false);
	        livingRoomButton.setContentAreaFilled(false);
	        livingRoomButton.setDefaultCapable(false);
	        livingRoomButton.setFocusPainted(false);
	        livingRoomButton.setHorizontalAlignment(SwingConstants.LEFT);
	        livingRoomButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                livingRoomButtonActionPerformed(evt);
	            }
	        });

	  //------------------------------------------------------------------------------
	        
	    //Creates the layouts for the mainMenuPanel    
        GroupLayout mainMenuPanelLayout = new GroupLayout(mainMenuPanel);
        mainMenuPanel.setLayout(mainMenuPanelLayout);
        mainMenuPanelLayout.setHorizontalGroup(
            mainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(mainMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(structureLabel, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(menuSeparator, GroupLayout.Alignment.TRAILING)
                    .addGroup(mainMenuPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(mainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(stairsButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                            .addComponent(wallsButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                            .addComponent(elevatorButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(mainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(mainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(windowsButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addComponent(doorButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                            .addComponent(flooringButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(mainMenuPanelLayout.createSequentialGroup()
                        .addGroup(mainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(mainMenuPanelLayout.createSequentialGroup()
                                .addComponent(furnitureLabel)
                                .addGap(31, 31, 31))
                            .addGroup(mainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(kitchenButton)
                                .addComponent(dinningRoomButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                .addComponent(bedroomButton)
                                .addComponent(livingRoomButton)))
                        .addGap(18, 18, 18)
                        .addGroup(mainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(bathroomButton)
                            .addComponent(officeButton)
                            .addComponent(garageButton)
                            .addComponent(laundryButton))))
                .addContainerGap())
        );
        
        mainMenuPanelLayout.setVerticalGroup(
            mainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(mainMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(structureLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(wallsButton)
                    .addComponent(doorButton))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(stairsButton)
                    .addComponent(windowsButton))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(elevatorButton)
                    .addComponent(flooringButton))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuSeparator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(furnitureLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(officeButton)
                    .addComponent(livingRoomButton))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(dinningRoomButton)
                    .addComponent(bathroomButton))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(bedroomButton)
                    .addComponent(laundryButton))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(kitchenButton)
                    .addComponent(garageButton))
                .addContainerGap(455, Short.MAX_VALUE))
        );

     //------------------------------------------------------------------------------
        
        //Adds the mainMenuPanel to the leftMenuPanel card layout
        leftMenuPanel.add(mainMenuPanel, "card3");

     //------------------------------------------------------------------------------
        
        //Creates the toolbarPanel
        toolbarPanel = new JPanel();
	    	toolbarPanel.setBackground(new Color(0, 102, 0));
	    	
	 //------------------------------------------------------------------------------
	    	
	    //Creates the topToolbar toolbar		
	    topToolBar = new JToolBar();
	        topToolBar.setRollover(true);
	        topToolBar.setMaximumSize(new Dimension(1280, 50));
	        topToolBar.setMinimumSize(new Dimension(1000, 10));
	        
	    //Creates the newFloorPlanButton button    
	    newFloorPlanButton = new JButton();
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
        loadFloorPlanButton = new JButton();
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
        saveFloorPlanButton = new JButton();
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
            .addComponent(topToolBar, GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        
        toolbarPanelLayout.setVerticalGroup(
            toolbarPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(topToolBar, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

      //------------------------------------------------------------------------------
        
        //Creates the leftMenuHeaderPanel
        leftMenuHeaderPanel = new JPanel();
	        leftMenuHeaderPanel.setBackground(new Color(0, 0, 0));
	        leftMenuHeaderPanel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

	  //------------------------------------------------------------------------------
	        
	    //Creates the overallHeaderLabel for the leftMenuPanel    
	    overallHeaderLabel = new JLabel();
	        overallHeaderLabel.setBackground(new Color(102, 102, 102));
	        overallHeaderLabel.setForeground(new Color(255, 255, 255));
	        overallHeaderLabel.setHorizontalAlignment(SwingConstants.LEFT);
	        overallHeaderLabel.setText("Building Parts");

	  //------------------------------------------------------------------------------
	        
	    //Creates layout for the leftMenuHeaderPanel    
        GroupLayout leftMenuHeaderPanelLayout = new GroupLayout(leftMenuHeaderPanel);
        leftMenuHeaderPanel.setLayout(leftMenuHeaderPanelLayout);
        leftMenuHeaderPanelLayout.setHorizontalGroup(
            leftMenuHeaderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, leftMenuHeaderPanelLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(overallHeaderLabel, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        
        leftMenuHeaderPanelLayout.setVerticalGroup(
            leftMenuHeaderPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(overallHeaderLabel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        );

      //------------------------------------------------------------------------------
        
        //Creates the layout for the contentPanel
        GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(toolbarPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(leftMenuPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(leftMenuHeaderPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(5, 5, 5)
                        .addComponent(floorTabPanel, GroupLayout.PREFERRED_SIZE, 1082, GroupLayout.PREFERRED_SIZE))))
        );
        
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addComponent(toolbarPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(leftMenuHeaderPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(leftMenuPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(floorTabPanel, GroupLayout.PREFERRED_SIZE, 680, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

      //------------------------------------------------------------------------------
        
        //Creates the layout for the rootPanel
        GroupLayout rootPanelLayout = new GroupLayout(rootPanel);
        rootPanel.setLayout(rootPanelLayout);
        rootPanelLayout.setHorizontalGroup(
            rootPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        
        rootPanelLayout.setVerticalGroup(
            rootPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

      //------------------------------------------------------------------------------
        
        //Creates the layout for the frame and gets the contentPanel
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(rootPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(rootPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

      //------------------------------------------------------------------------------
        
        //Packs the panels 
        pack();
    }                  
    
    private void newFloorPlanButtonActionPerformed(ActionEvent evt) {                                                   
        // TODO add your handling code here:
    }
    
    private void saveFloorPlanButtonActionPerformed(ActionEvent evt) {                                                    
        // TODO add your handling code here:
    }                                                   

    private void loadFloorPlanButtonActionPerformed(ActionEvent evt) {                                                    
        // TODO add your handling code here:
    } 
    
    private void stairsButtonActionPerformed(ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void elevatorButtonActionPerformed(ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void doorButtonActionPerformed(ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void windowsButtonActionPerformed(ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void flooringButtonActionPerformed(ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void dinningRoomButtonActionPerformed(ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    private void kitchenButtonActionPerformed(ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void officeButtonActionPerformed(ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                                                                              

    private void wallsButtonActionPerformed(ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void bedroomButtonActionPerformed(ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void bathroomButtonActionPerformed(ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void laundryButtonActionPerformed(ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void livingRoomButtonActionPerformed(ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    private void garageButtonActionPerformed(ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                                                                              

}
