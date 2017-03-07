package Frame;
import java.awt.*;
import javax.swing.*;

/**
 * Creates the overall frame and hold the root and content panes
 */
public class BuilderFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Variables declaration                  
    private JPanel contentPanel;
    private JPanel rootPanel;
    
    private JPanel leftMenuHeaderPanel;
    private JLabel overallHeaderLabel;
	
    MenuPane menuPane = new MenuPane();
    TabbedPane tabbedPane = new TabbedPane();
    ToolBarPane toolbarPane = new ToolBarPane(tabbedPane);
    
    public BuilderFrame() {
        initComponents();
    }
                   
    private void initComponents() {

        rootPanel = new JPanel();
        contentPanel = new JPanel();

        leftMenuHeaderPanel = new JPanel();
        overallHeaderLabel = new JLabel();
        
      //Sets the properties for the JFrame
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("2d - Builder");
        setBackground(new Color(0, 0, 0));
        setMaximumSize(new Dimension(1280, 720));
        setPreferredSize(new Dimension(1280, 720));
        setResizable(false);
        setSize(new Dimension(1280, 720));

      //Creates root panel 
        rootPanel.setBackground(new Color(0, 0, 0));

      //------------------------------------------------------------------------------
        
        //Creates content panel
        contentPanel.setBackground(new Color(0, 0, 0));

      //------------------------------------------------------------------------------
        
      //Creates the leftMenuHeaderPanel
        leftMenuHeaderPanel.setBackground(new Color(0, 0, 0));
        leftMenuHeaderPanel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

      //------------------------------------------------------------------------------
        
      //Creates the overallHeaderLabel for the leftMenuPanel 
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
                .addContainerGap()
                .addComponent(overallHeaderLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(toolbarPane.getGUI(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(menuPane.getGUI(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(leftMenuHeaderPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tabbedPane.getGUI(), GroupLayout.PREFERRED_SIZE, 1055, GroupLayout.PREFERRED_SIZE))))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addComponent(toolbarPane.getGUI(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(leftMenuHeaderPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(menuPane.getGUI(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(tabbedPane.getGUI(), GroupLayout.PREFERRED_SIZE, 650, GroupLayout.PREFERRED_SIZE))
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

        pack();
    }// </editor-fold>                                                                       
                 
}
