package Frame;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Factories.AbstractFloorComponentFactory;
import Factories.FloorComponentFactoryProducer;
import FloorComponent.*;

/**
 * Class that creates everything in the left menu panel 
 * as well as implements each action listener for the various
 * buttons.
 */
public class MenuPane extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BackButton backButton;
	private MenuButton bathroomButton;
    private JPanel bathroomMenuPanel;
    private MenuButton bedroomButton;
    private JPanel bedroomMenuPanel;
    private MenuButton dinningRoomButton;
    private JPanel dinningRoomMenuPanel;
    private MenuButton doorButton;
    private JPanel doorsMenuPanel;
    private MenuButton elevatorButton;
    private JPanel elevatorMenuPanel;
    private MenuButton flooringButton;
    private JPanel flooringMenuPanel;
    private JLabel furnitureLabel;
    private MenuButton garageButton;
    private JPanel garageMenuPanel;
    private MenuButton kitchenButton;
    private JPanel kitchenMenuPanel;
    private MenuButton laundryButton;
    private JPanel laundryMenuPanel;
    private MenuButton livingRoomButton;
    private JPanel livingRoomMenuPanel;
    private JPanel mainMenuPanel;
    private JSeparator menuSeparator;
    private MenuButton officeButton;
    private JPanel officeMenuPanel;
    private MenuButton stairsButton;
    private JPanel stairsMenuPanel;
    private JLabel structureLabel;
    private MenuButton wallsButton;
    private JPanel wallsMenuPanel;
    private MenuButton windowsButton;
    private JPanel windowsMenuPanel; 
    
    private TabbedPane tabbedPane;
    
    private AbstractFloorComponentFactory wallFactory;
    private AbstractFloorComponentFactory windowFactory;
    private AbstractFloorComponentFactory doorFactory;
    private AbstractFloorComponentFactory stairsFactory;
    private AbstractFloorComponentFactory elevatorFactory;
    private AbstractFloorComponentFactory flooringFactory;
    private AbstractFloorComponentFactory dinningRoomFactory;
    private AbstractFloorComponentFactory bedroomFactory;
    private AbstractFloorComponentFactory bathroomFactory;
    private AbstractFloorComponentFactory laundryFactory;
    private AbstractFloorComponentFactory garageFactory;
    
    private String type = "";
    private FloorComponent fillLabel;
    private FloorComponent newComponent;
    private FloorComponent currentComponent;
    private Boolean componentSet = false;
    
    private InnerPanel innerPanel;
    
    public MenuPane(TabbedPane tab) {
    	
    	this.tabbedPane = tab;
    	
    	backButton = new BackButton();
        mainMenuPanel = new JPanel();
        structureLabel = new JLabel();
        wallsButton = new MenuButton();
        stairsButton = new MenuButton();
        elevatorButton = new MenuButton();
        doorButton = new MenuButton();
        windowsButton = new MenuButton();
        menuSeparator = new JSeparator();
        furnitureLabel = new JLabel();
        flooringButton = new MenuButton();
        dinningRoomButton = new MenuButton();
        kitchenButton = new MenuButton();
        officeButton = new MenuButton();
        bedroomButton = new MenuButton();
        bathroomButton = new MenuButton();
        laundryButton = new MenuButton();
        garageButton = new MenuButton();
        livingRoomButton = new MenuButton();
        wallsMenuPanel = new JPanel();
        stairsMenuPanel = new JPanel();
        elevatorMenuPanel = new JPanel();
        doorsMenuPanel = new JPanel();
        flooringMenuPanel = new JPanel();
        windowsMenuPanel = new JPanel();
        livingRoomMenuPanel = new JPanel();
        dinningRoomMenuPanel = new JPanel();
        bedroomMenuPanel = new JPanel();
        kitchenMenuPanel = new JPanel();
        officeMenuPanel = new JPanel();
        bathroomMenuPanel = new JPanel();
        laundryMenuPanel = new JPanel();
        garageMenuPanel = new JPanel();
        
      //------------------------------------------------------------------------------      
        
      //Creates the leftMenuPanel that will hold all the components that can be dragged into a plan
        setBackground(new Color(153, 153, 153));
        setForeground(new Color(255, 255, 255));
        setMaximumSize(new Dimension(300, 700));
        setPreferredSize(new Dimension(300, 700));
        setMinimumSize(new Dimension(0, 0));
        setLayout(new CardLayout());
        
        wallsMenuPanel.setMaximumSize(new Dimension(300, 700));

      //Creates the first header on the main menu
        structureLabel.setText("Structure");
        
      //Creates the wallsButton button
        wallsButton.setText("Walls");
        wallsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                wallsButtonActionPerformed(evt);
            }
        });

      //Creates the stairsButton button  
        stairsButton.setText("Stairs");
        stairsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                stairsButtonActionPerformed(evt);
            }
        });
	    
      //Creates the elevatorButton button 
        elevatorButton.setText("Elevators");
        elevatorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                elevatorButtonActionPerformed(evt);
            }
        });

      //Creates the doorButton button   
        doorButton.setText("Doors");
        doorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                doorButtonActionPerformed(evt);
            }
        });
        
      //Creates the windowsButton button
        windowsButton.setText("Windows");
        windowsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                windowsButtonActionPerformed(evt);
            }
        });
        
      //Creates the second header on the main menu
        furnitureLabel.setText("Furniture");

      //Creates the flooringButton button
        flooringButton.setText("Flooring");
        flooringButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                flooringButtonActionPerformed(evt);
            }
        });
        
      //Creates the dinningRoomButton button 
        dinningRoomButton.setText("Dinning Room");
        dinningRoomButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dinningRoomButtonActionPerformed(evt);
            }
        });
        
      //Creates the kitchenButton button
        kitchenButton.setText("Kitchen");
        kitchenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                kitchenButtonActionPerformed(evt);
            }
        });
        
      //Creates the officeButton button
        officeButton.setText("Office");
        officeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                officeButtonActionPerformed(evt);
            }
        });
        
      //Creates the bedroomButton button  
        bedroomButton.setText("Bedroom");
        bedroomButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bedroomButtonActionPerformed(evt);
            }
        });
        
      //Creates the bathroomButton button  
        bathroomButton.setText("Bathroom");
        bathroomButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bathroomButtonActionPerformed(evt);
            }
        });
        
      //Creates the laundryButton button
        laundryButton.setText("Laundry");
        laundryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                laundryButtonActionPerformed(evt);
            }
        });
        
      //Creates the garageButton button 
        garageButton.setText("Garage");
        garageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                garageButtonActionPerformed(evt);
            }
        });
        
      //Creates the livingRoomButton button
        livingRoomButton.setText("Living Room");
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
                    .addGroup(mainMenuPanelLayout.createSequentialGroup()
                        .addGroup(mainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(mainMenuPanelLayout.createSequentialGroup()
                                .addComponent(furnitureLabel)
                                .addGap(58, 58, 58))
                            .addGroup(mainMenuPanelLayout.createSequentialGroup()
                                .addGroup(mainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(dinningRoomButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kitchenButton)
                                    .addComponent(bedroomButton)
                                    .addComponent(livingRoomButton))
                                .addGap(12, 12, 12)))
                        .addGroup(mainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(garageButton)
                            .addComponent(officeButton)
                            .addComponent(bathroomButton)
                            .addComponent(laundryButton)))
                    .addGroup(mainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainMenuPanelLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(mainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(mainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(mainMenuPanelLayout.createSequentialGroup()
                                        .addComponent(wallsButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(doorButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(GroupLayout.Alignment.LEADING, mainMenuPanelLayout.createSequentialGroup()
                                        .addComponent(elevatorButton, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(flooringButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(mainMenuPanelLayout.createSequentialGroup()
                                    .addComponent(stairsButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                    .addGap(46, 46, 46)
                                    .addComponent(windowsButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)))
                            .addGap(0, 0, 0))
                        .addGroup(mainMenuPanelLayout.createSequentialGroup()
                            .addGroup(mainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(structureLabel, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                .addComponent(menuSeparator, GroupLayout.Alignment.TRAILING))
                            .addContainerGap()))))
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
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

      //------------------------------------------------------------------------------

      //CrethisMenuPanel that will hold all the components that can be dragged into a plan
        add(mainMenuPanel, "MAIN");

        //GridLayout for the component panels
        GridLayout g = new GridLayout(5, 2);
        g.setHgap(0);
        g.setVgap(0);
        
      //Creates the wallsMenuPanel that will hold wall components 
        wallsMenuPanel.setLayout(g);
                
      //------------------------------------------------------------------------------
        
      //Assigns the factories for each type of component
        wallFactory = FloorComponentFactoryProducer.getFactory("WALL");
        windowFactory = FloorComponentFactoryProducer.getFactory("WINDOW");
        doorFactory = FloorComponentFactoryProducer.getFactory("DOOR");
        stairsFactory = FloorComponentFactoryProducer.getFactory("STAIRS");
        elevatorFactory = FloorComponentFactoryProducer.getFactory("ELEVATOR");
        flooringFactory = FloorComponentFactoryProducer.getFactory("FLOORING");
        dinningRoomFactory = FloorComponentFactoryProducer.getFactory("DINNINGROOM");
        bedroomFactory = FloorComponentFactoryProducer.getFactory("BEDROOM");
        bathroomFactory = FloorComponentFactoryProducer.getFactory("BATHROOM");
        laundryFactory = FloorComponentFactoryProducer.getFactory("LAUNDRY");
        garageFactory = FloorComponentFactoryProducer.getFactory("GARAGE");
        
      //------------------------------------------------------------------------------
        
      //Creates the backButton that will redirect users from the various component tabs back to the main menu
        wallsMenuPanel.add(backButton = new BackButton());
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        wallsMenuPanel.add(wallFactory.getComponent("WALLHALF"));
        wallsMenuPanel.add(wallFactory.getComponent("WALL1H"));
        wallsMenuPanel.add(wallFactory.getComponent("WALL1V"));
        wallsMenuPanel.add(wallFactory.getComponent("WALL2H"));
        wallsMenuPanel.add(wallFactory.getComponent("WALL3H"));
        wallsMenuPanel.add(wallFactory.getComponent("WALL2V"));
        wallsMenuPanel.add(wallFactory.getComponent("WALL3V"));
        
        add(wallsMenuPanel, "WALLS");
        
      //Creates the stairsMenuPanel that will hold stairs components
        stairsMenuPanel.setLayout(g);
        
      //Creates the backButton that will redirect users from the various component tabs back to the main menu
        stairsMenuPanel.add(backButton = new BackButton());
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        add(stairsMenuPanel, "STAIRS");

      //Creates the elevatorMenuPanel that will hold elevator components
        elevatorMenuPanel.setLayout(g);
        
      //Creates the backButton that will redirect users from the various component tabs back to the main menu
        elevatorMenuPanel.add(backButton = new BackButton());
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        
        elevatorMenuPanel.add(elevatorFactory.getComponent("ELEVATORRIGHT"));
        elevatorMenuPanel.add(elevatorFactory.getComponent("ELEVATORLEFT"));
        elevatorMenuPanel.add(elevatorFactory.getComponent("ELEVATORUP"));
        elevatorMenuPanel.add(elevatorFactory.getComponent("ELEVATORDOWN"));
        
        add(elevatorMenuPanel, "ELEVATORS");

      //Creates the doorsMenuPanel that will hold door components
        
        doorsMenuPanel.setLayout(g);
      //Creates the backButton that will redirect users from the various component tabs back to the main menu
        doorsMenuPanel.add(backButton = new BackButton());
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        doorsMenuPanel.add(doorFactory.getComponent("DOORFDOL"));
        doorsMenuPanel.add(doorFactory.getComponent("DOORFDOR"));
        doorsMenuPanel.add(doorFactory.getComponent("DOORFLOL"));
        doorsMenuPanel.add(doorFactory.getComponent("DOORFLOR"));
        doorsMenuPanel.add(doorFactory.getComponent("DOORFROL"));
        doorsMenuPanel.add(doorFactory.getComponent("DOORFROR"));
        doorsMenuPanel.add(doorFactory.getComponent("DOORFUOL"));
        doorsMenuPanel.add(doorFactory.getComponent("DOORFUOR"));
        
        add(doorsMenuPanel, "DOORS");

      //Creates the flooringMenuPanel that will hold flooring components
        flooringMenuPanel.setLayout(g);
        
      //Creates the backButton that will redirect users from the various component tabs back to the main menu
        flooringMenuPanel.add(backButton = new BackButton());
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        
        add(flooringMenuPanel, "FLOORING");
        
      //Creates the windowsMenuPanel that will hold window components
        windowsMenuPanel.setLayout(g);
        
      //Creates the backButton that will redirect users from the various component tabs back to the main menu
        windowsMenuPanel.add(backButton = new BackButton());
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        
        windowsMenuPanel.add(windowFactory.getComponent("WINDOW1H"));
        windowsMenuPanel.add(windowFactory.getComponent("WINDOW1V"));
        windowsMenuPanel.add(windowFactory.getComponent("WINDOW2H"));
        windowsMenuPanel.add(windowFactory.getComponent("WINDOW2V"));
        windowsMenuPanel.add(windowFactory.getComponent("WINDOW3H"));
        windowsMenuPanel.add(windowFactory.getComponent("WINDOW3V"));
        
        add(windowsMenuPanel, "WINDOWS");

      //Creates the livingRoomMenuPanel that will hold living room components
        livingRoomMenuPanel.setLayout(g);
        
      //Creates the backButton that will redirect users from the various component tabs back to the main menu
        livingRoomMenuPanel.add(backButton = new BackButton());
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        add(livingRoomMenuPanel, "LIVINGROOM");

      //Creates the dinningRoomMenuPanel that will hold dinning room components
        dinningRoomMenuPanel.setLayout(g);
        
        //Creates the backButton that will redirect users from the various component tabs back to the main menu
        dinningRoomMenuPanel.add(backButton = new BackButton());
          backButton.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent evt) {
                  backButtonActionPerformed(evt);
              }
          });
          
        add(dinningRoomMenuPanel, "DINNINGROOM");

      //Creates the bedroomMenuPanel that will hold wall components
        bedroomMenuPanel.setLayout(g);
        
        //Creates the backButton that will redirect users from the various component tabs back to the main menu
        bedroomMenuPanel.add(backButton = new BackButton());
          backButton.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent evt) {
                  backButtonActionPerformed(evt);
              }
          });
          
        add(bedroomMenuPanel, "BEDROOM");

      //Creates the kitchenMenuPanel that will hold kitchen components
        kitchenMenuPanel.setLayout(g);
        
        //Creates the backButton that will redirect users from the various component tabs back to the main menu
        kitchenMenuPanel.add(backButton = new BackButton());
          backButton.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent evt) {
                  backButtonActionPerformed(evt);
              }
          });
          
        add(kitchenMenuPanel, "KITCHEN");

      //Creates the officeMenuPanel that will hold office components
        officeMenuPanel.setLayout(g);
        
        //Creates the backButton that will redirect users from the various component tabs back to the main menu
        officeMenuPanel.add(backButton = new BackButton());
          backButton.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent evt) {
                  backButtonActionPerformed(evt);
              }
          });
          
        add(officeMenuPanel, "OFFICE");

      //Creates the bathroomMenuPanel that will hold bathroom components
        bathroomMenuPanel.setLayout(g);
        
        //Creates the backButton that will redirect users from the various component tabs back to the main menu
        bathroomMenuPanel.add(backButton = new BackButton());
          backButton.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent evt) {
                  backButtonActionPerformed(evt);
              }
          });
          
        add(bathroomMenuPanel, "BATHROOM");

      //Creates the laundryMenuPanel that will hold laundry components
        laundryMenuPanel.setLayout(g);
        
        //Creates the backButton that will redirect users from the various component tabs back to the main menu
        laundryMenuPanel.add(backButton = new BackButton());
          backButton.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent evt) {
                  backButtonActionPerformed(evt);
              }
          });
          
        add(laundryMenuPanel, "LAUNDRY");

      //Creates the garageMenuPanel that will hold garage components
        garageMenuPanel.setLayout(g);
        
        //Creates the backButton that will redirect users from the various component tabs back to the main menu
        garageMenuPanel.add(backButton = new BackButton());
          backButton.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent evt) {
                  backButtonActionPerformed(evt);
              }
          });
          
        add(garageMenuPanel, "GARAGE");
        
        addMouseListener(new MouseAdapter(){
			@Override 
			public void mouseEntered(MouseEvent e){
				if(e.getSource() instanceof MenuPane){
					System.out.println("Entered the MenuPane");
					if(e.getSource() instanceof FloorComponent){
						innerPanel = InnerPanel.getInstance();
						System.out.println("Component on the MenuPane");
						innerPanel.setInMenuPane(true);
					}
				}		
			}
			
			@Override 
			public void mouseExited(MouseEvent e){
				if((e.getSource() instanceof MenuPane)){
					innerPanel = InnerPanel.getInstance();
					System.out.println("Exited the MenuPane");
					innerPanel.setInMenuPane(false);
				}	
			}               
	    });      
    }
    
  //-------------------------------------------------------------------------------------------------------------     
    
    public void setAddComponent(boolean b){
    	componentSet = b;
    }
    
    public Boolean isComponentSet(){
    	return componentSet;
    }
    
    public FloorComponent getFloorComponent(){
    	return newComponent;
    }
    
    public void addToWallsPanel(FloorComponent c){
    	wallsMenuPanel.add(c);
    }
    
    //Gets the current leftMenuPanel
	public JPanel getGUI(){
		return this;
	}
    
	private void backButtonActionPerformed(ActionEvent evt) {                                           
		CardLayout cardLayout = (CardLayout) getLayout();
    	cardLayout.show(this, "MAIN");
    } 
	
    private void stairsButtonActionPerformed(ActionEvent evt) {                                             
    	CardLayout cardLayout = (CardLayout) getLayout();
    	cardLayout.show(this, "STAIRS");
    }                                            

    private void elevatorButtonActionPerformed(ActionEvent evt) {                                               
    	CardLayout cardLayout = (CardLayout) getLayout();
    	cardLayout.show(this, "ELEVATORS");
    }                                              

    private void doorButtonActionPerformed(ActionEvent evt) {                                           
    	CardLayout cardLayout = (CardLayout) getLayout();
    	cardLayout.show(this, "DOORS");
    }                                          

    private void windowsButtonActionPerformed(ActionEvent evt) {                                              
    	CardLayout cardLayout = (CardLayout) getLayout();
    	cardLayout.show(this, "WINDOWS");
    }                                             

    private void flooringButtonActionPerformed(ActionEvent evt) {                                               
    	CardLayout cardLayout = (CardLayout) getLayout();
    	cardLayout.show(this, "FLOORING");
    }                                              

    private void dinningRoomButtonActionPerformed(ActionEvent evt) {                                                  
    	CardLayout cardLayout = (CardLayout) getLayout();
    	cardLayout.show(this, "DINNINGROOM");
    }                                                 

    private void kitchenButtonActionPerformed(ActionEvent evt) {                                              
    	CardLayout cardLayout = (CardLayout) getLayout();
    	cardLayout.show(this, "KITCHEN");
    }                                             

    private void officeButtonActionPerformed(ActionEvent evt) {                                             
    	CardLayout cardLayout = (CardLayout) getLayout();
    	cardLayout.show(this, "OFFICE");
    }                                                                                            

    private void wallsButtonActionPerformed(ActionEvent evt) {                                            
    	CardLayout cardLayout = (CardLayout) getLayout();
    	cardLayout.show(this, "WALLS");
    }                                           

    private void bedroomButtonActionPerformed(ActionEvent evt) {                                              
    	CardLayout cardLayout = (CardLayout) getLayout();
    	cardLayout.show(this, "BEDROOM");
    }                                             

    private void bathroomButtonActionPerformed(ActionEvent evt) {                                               
    	CardLayout cardLayout = (CardLayout) getLayout();
    	cardLayout.show(this, "BATHROOM"); 
    }                                              

    private void laundryButtonActionPerformed(ActionEvent evt) {                                              
    	CardLayout cardLayout = (CardLayout) getLayout();
    	cardLayout.show(this, "LAUNDRY");
    }                                             

    private void livingRoomButtonActionPerformed(ActionEvent evt) {                                                 
    	CardLayout cardLayout = (CardLayout) getLayout();
    	cardLayout.show(this, "LIVINGROOM");
    }                                                

    private void garageButtonActionPerformed(ActionEvent evt) {                                             
    	CardLayout cardLayout = (CardLayout) getLayout();
    	cardLayout.show(this, "GARAGE");
    	
    } 
	
}
