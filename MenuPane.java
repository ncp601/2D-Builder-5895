package Frame;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

/**
 * Class that creates everything in the left menu panel 
 * as well as implements each action listener for the various
 * buttons.
 */
public class MenuPane extends MouseAdapter{
	
	private TabbedPane currentTabbedPane;
	private BackButton backButton;
	private JButton bathroomButton;
    private JPanel bathroomMenuPanel;
    private JButton bedroomButton;
    private JPanel bedroomMenuPanel;
    private JButton dinningRoomButton;
    private JPanel dinningRoomMenuPanel;
    private JButton doorButton;
    private JPanel doorsMenuPanel;
    private JButton elevatorButton;
    private JPanel elevatorMenuPanel;
    private JButton flooringButton;
    private JPanel flooringMenuPanel;
    private JLabel furnitureLabel;
    private JButton garageButton;
    private JPanel garageMenuPanel;
    private JButton kitchenButton;
    private JPanel kitchenMenuPanel;
    private JButton laundryButton;
    private JPanel laundryMenuPanel;
    private JPanel leftMenuPanel;
    private JButton livingRoomButton;
    private JPanel livingRoomMenuPanel;
    private JPanel mainMenuPanel;
    private JSeparator menuSeparator;
    private JButton officeButton;
    private JPanel officeMenuPanel;
    private JButton stairsButton;
    private JPanel stairsMenuPanel;
    private JLabel structureLabel;
    private JButton wallsButton;
    private JPanel wallsMenuPanel;
    private JButton windowsButton;
    private JPanel windowsMenuPanel; 
    
    private WallComponent fillLabel;
//    JLabel dragLabel;
    
    private ComponentReceiver compR = new ComponentReceiver();
    private ComponentManager compM = new ComponentManager();
    
    private ByteArrayOutputStream baos;
    private ByteArrayInputStream bins;
    
    private FloorComponent dragLabel = null;
    private int dragLabelWidthDiv2;
    private int dragLabelHeightDiv2;
    private JPanel clickedPanel = null;
    
    public MenuPane(TabbedPane t) {
    
    	this.currentTabbedPane = t;
    	
    	backButton = new BackButton();
    	leftMenuPanel = new JPanel();
        mainMenuPanel = new JPanel();
        structureLabel = new JLabel();
        wallsButton = new JButton();
        stairsButton = new JButton();
        elevatorButton = new JButton();
        doorButton = new JButton();
        windowsButton = new JButton();
        menuSeparator = new JSeparator();
        furnitureLabel = new JLabel();
        flooringButton = new JButton();
        dinningRoomButton = new JButton();
        kitchenButton = new JButton();
        officeButton = new JButton();
        bedroomButton = new JButton();
        bathroomButton = new JButton();
        laundryButton = new JButton();
        garageButton = new JButton();
        livingRoomButton = new JButton();
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
        
    	fillLabel = new WallComponent();
        fillLabel.addMouseListener(this);
      //Creates the leftMenuPanel that will hold all the components that can be dragged into a plan
        leftMenuPanel.setBackground(new Color(153, 153, 153));
        leftMenuPanel.setForeground(new Color(255, 255, 255));
        leftMenuPanel.setLayout(new CardLayout());

      //Creates the first header on the main menu
        structureLabel.setText("Structure");
        
      //Creates the wallsButton button
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

      //Creates the second header on the main menu
        furnitureLabel.setText("Furniture");

      //Creates the flooringButton button
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
        laundryButton.setText("Laundry");
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
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(mainMenuPanelLayout.createSequentialGroup()
                            .addGroup(mainMenuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(structureLabel, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
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
                .addContainerGap(455, Short.MAX_VALUE))
        );

      //------------------------------------------------------------------------------

      //Creates the leftMenuPanel that will hold all the components that can be dragged into a plan
        leftMenuPanel.add(mainMenuPanel, "MAIN");

        //GridLayout for the component panels
        GridLayout g = new GridLayout(5, 2);
        g.setHgap(0);
        g.setVgap(0);
        
      //Creates the wallsMenuPanel that will hold wall components 
        wallsMenuPanel.setLayout(g);
                
      //Creates the backButton that will redirect users from the various component tabs back to the main menu
        wallsMenuPanel.add(backButton = new BackButton());
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        wallsMenuPanel.add(fillLabel);
        fillLabel = new WallComponent();
        fillLabel.addMouseListener(this);
        wallsMenuPanel.add(fillLabel);

        fillLabel = new WallComponent();
        fillLabel.addMouseListener(this);
        wallsMenuPanel.add(fillLabel);

        fillLabel = new WallComponent();
        fillLabel.addMouseListener(this);
        wallsMenuPanel.add(fillLabel);

        fillLabel = new WallComponent();
        fillLabel.addMouseListener(this);
        wallsMenuPanel.add(fillLabel);

        fillLabel = new WallComponent();
        fillLabel.addMouseListener(this);
        wallsMenuPanel.add(fillLabel);
        
        leftMenuPanel.add(wallsMenuPanel, "WALLS");
        


      //Creates the stairsMenuPanel that will hold stairs components
        stairsMenuPanel.setLayout(g);
        
      //Creates the backButton that will redirect users from the various component tabs back to the main menu
        stairsMenuPanel.add(backButton = new BackButton());
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        leftMenuPanel.add(stairsMenuPanel, "STAIRS");

      //Creates the elevatorMenuPanel that will hold elevator components
        elevatorMenuPanel.setLayout(g);
        
      //Creates the backButton that will redirect users from the various component tabs back to the main menu
        elevatorMenuPanel.add(backButton = new BackButton());
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        leftMenuPanel.add(elevatorMenuPanel, "ELEVATORS");

      //Creates the doorsMenuPanel that will hold door components
        
        doorsMenuPanel.setLayout(g);
      //Creates the backButton that will redirect users from the various component tabs back to the main menu
        doorsMenuPanel.add(backButton = new BackButton());
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        leftMenuPanel.add(doorsMenuPanel, "DOORS");

      //Creates the flooringMenuPanel that will hold flooring components
        flooringMenuPanel.setLayout(g);
        
      //Creates the backButton that will redirect users from the various component tabs back to the main menu
        flooringMenuPanel.add(backButton = new BackButton());
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        
        leftMenuPanel.add(flooringMenuPanel, "FLOORING");
        
      //Creates the windowsMenuPanel that will hold window components
        windowsMenuPanel.setLayout(g);
        
      //Creates the backButton that will redirect users from the various component tabs back to the main menu
        windowsMenuPanel.add(backButton = new BackButton());
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        
        leftMenuPanel.add(windowsMenuPanel, "WINDOWS");

      //Creates the livingRoomMenuPanel that will hold living room components
        livingRoomMenuPanel.setLayout(g);
        
      //Creates the backButton that will redirect users from the various component tabs back to the main menu
        livingRoomMenuPanel.add(backButton = new BackButton());
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        
        leftMenuPanel.add(livingRoomMenuPanel, "LIVINGROOM");

      //Creates the dinningRoomMenuPanel that will hold dinning room components
        dinningRoomMenuPanel.setLayout(g);
        
        //Creates the backButton that will redirect users from the various component tabs back to the main menu
        dinningRoomMenuPanel.add(backButton = new BackButton());
          backButton.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(java.awt.event.ActionEvent evt) {
                  backButtonActionPerformed(evt);
              }
          });
          
        leftMenuPanel.add(dinningRoomMenuPanel, "DINNINGROOM");

      //Creates the bedroomMenuPanel that will hold wall components
        bedroomMenuPanel.setLayout(g);
        
        //Creates the backButton that will redirect users from the various component tabs back to the main menu
        bedroomMenuPanel.add(backButton = new BackButton());
          backButton.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(java.awt.event.ActionEvent evt) {
                  backButtonActionPerformed(evt);
              }
          });
          
        leftMenuPanel.add(bedroomMenuPanel, "BEDROOM");

      //Creates the kitchenMenuPanel that will hold kitchen components
        kitchenMenuPanel.setLayout(g);
        
        //Creates the backButton that will redirect users from the various component tabs back to the main menu
        kitchenMenuPanel.add(backButton = new BackButton());
          backButton.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(java.awt.event.ActionEvent evt) {
                  backButtonActionPerformed(evt);
              }
          });
          
        leftMenuPanel.add(kitchenMenuPanel, "KITCHEN");

      //Creates the officeMenuPanel that will hold office components
        officeMenuPanel.setLayout(g);
        
        //Creates the backButton that will redirect users from the various component tabs back to the main menu
        officeMenuPanel.add(backButton = new BackButton());
          backButton.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(java.awt.event.ActionEvent evt) {
                  backButtonActionPerformed(evt);
              }
          });
          
        leftMenuPanel.add(officeMenuPanel, "OFFICE");

      //Creates the bathroomMenuPanel that will hold bathroom components
        bathroomMenuPanel.setLayout(g);
        
        //Creates the backButton that will redirect users from the various component tabs back to the main menu
        bathroomMenuPanel.add(backButton = new BackButton());
          backButton.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(java.awt.event.ActionEvent evt) {
                  backButtonActionPerformed(evt);
              }
          });
          
        leftMenuPanel.add(bathroomMenuPanel, "BATHROOM");

      //Creates the laundryMenuPanel that will hold laundry components
        laundryMenuPanel.setLayout(g);
        
        //Creates the backButton that will redirect users from the various component tabs back to the main menu
        laundryMenuPanel.add(backButton = new BackButton());
          backButton.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(java.awt.event.ActionEvent evt) {
                  backButtonActionPerformed(evt);
              }
          });
          
        leftMenuPanel.add(laundryMenuPanel, "LAUNDRY");

      //Creates the garageMenuPanel that will hold garage components
        garageMenuPanel.setLayout(g);
        
        //Creates the backButton that will redirect users from the various component tabs back to the main menu
        garageMenuPanel.add(backButton = new BackButton());
          backButton.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(java.awt.event.ActionEvent evt) {
                  backButtonActionPerformed(evt);
              }
          });
          
        leftMenuPanel.add(garageMenuPanel, "GARAGE");
    	
    }
    
//-------------------------------------------------------------------------------------------------------------    
    
    @Override
    public void mousePressed(MouseEvent evt){
        try
        {
        	currentTabbedPane.mainLayeredPanel.setFC((FloorComponent)evt.getSource());
        	currentTabbedPane.mainLayeredPanel.setBaos(baos);
        }
        catch (Exception ex){}
    	
    	
    }
    
    

//-------------------------------------------------------------------------------------------------------------   
    
    //Gets the current leftMenuPanel
	public JPanel getGUI(){
		return leftMenuPanel;
	}
    
	private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
		CardLayout cardLayout = (CardLayout) leftMenuPanel.getLayout();
    	cardLayout.show(leftMenuPanel, "MAIN");
    } 
	
    private void stairsButtonActionPerformed(ActionEvent evt) {                                             
    	CardLayout cardLayout = (CardLayout) leftMenuPanel.getLayout();
    	cardLayout.show(leftMenuPanel, "STAIRS");
    }                                            

    private void elevatorButtonActionPerformed(ActionEvent evt) {                                               
    	CardLayout cardLayout = (CardLayout) leftMenuPanel.getLayout();
    	cardLayout.show(leftMenuPanel, "ELEVATORS");
    }                                              

    private void doorButtonActionPerformed(ActionEvent evt) {                                           
    	CardLayout cardLayout = (CardLayout) leftMenuPanel.getLayout();
    	cardLayout.show(leftMenuPanel, "DOORS");
    }                                          

    private void windowsButtonActionPerformed(ActionEvent evt) {                                              
    	CardLayout cardLayout = (CardLayout) leftMenuPanel.getLayout();
    	cardLayout.show(leftMenuPanel, "WINDOWS");
    }                                             

    private void flooringButtonActionPerformed(ActionEvent evt) {                                               
    	CardLayout cardLayout = (CardLayout) leftMenuPanel.getLayout();
    	cardLayout.show(leftMenuPanel, "FLOORING");
    }                                              

    private void dinningRoomButtonActionPerformed(ActionEvent evt) {                                                  
    	CardLayout cardLayout = (CardLayout) leftMenuPanel.getLayout();
    	cardLayout.show(leftMenuPanel, "DINNINGROOM");
    }                                                 

    private void kitchenButtonActionPerformed(ActionEvent evt) {                                              
    	CardLayout cardLayout = (CardLayout) leftMenuPanel.getLayout();
    	cardLayout.show(leftMenuPanel, "KITCHEN");
    }                                             

    private void officeButtonActionPerformed(ActionEvent evt) {                                             
    	CardLayout cardLayout = (CardLayout) leftMenuPanel.getLayout();
    	cardLayout.show(leftMenuPanel, "OFFICE");
    }                                                                                            

    private void wallsButtonActionPerformed(ActionEvent evt) {                                            
    	CardLayout cardLayout = (CardLayout) leftMenuPanel.getLayout();
    	cardLayout.show(leftMenuPanel, "WALLS");
    }                                           

    private void bedroomButtonActionPerformed(ActionEvent evt) {                                              
    	CardLayout cardLayout = (CardLayout) leftMenuPanel.getLayout();
    	cardLayout.show(leftMenuPanel, "BEDROOM");
    }                                             

    private void bathroomButtonActionPerformed(ActionEvent evt) {                                               
    	CardLayout cardLayout = (CardLayout) leftMenuPanel.getLayout();
    	cardLayout.show(leftMenuPanel, "BATHROOM"); 
    }                                              

    private void laundryButtonActionPerformed(ActionEvent evt) {                                              
    	CardLayout cardLayout = (CardLayout) leftMenuPanel.getLayout();
    	cardLayout.show(leftMenuPanel, "LAUNDRY");
    }                                             

    private void livingRoomButtonActionPerformed(ActionEvent evt) {                                                 
    	CardLayout cardLayout = (CardLayout) leftMenuPanel.getLayout();
    	cardLayout.show(leftMenuPanel, "LIVINGROOM");
    }                                                

    private void garageButtonActionPerformed(ActionEvent evt) {                                             
    	CardLayout cardLayout = (CardLayout) leftMenuPanel.getLayout();
    	cardLayout.show(leftMenuPanel, "GARAGE");
    	
    } 
    
    
    

		

}
