package Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UIPanel extends JLayeredPane{

//Variables declaration                    

private JPanel leftMenuHeaderPanel;
private JLabel overallHeaderLabel;

private JPanel mainGlassPanel;
private JLayeredPane innerContentPanel;

TabbedPane tabbedPane = new TabbedPane();
MenuPane menuPane = new MenuPane(tabbedPane);
ComponentMover compMover = new ComponentMover(tabbedPane, menuPane);

public UIPanel() {

	innerContentPanel  = new JLayeredPane();
    leftMenuHeaderPanel = new JPanel();
    overallHeaderLabel = new JLabel();
    mainGlassPanel = new JPanel();

    innerContentPanel.setPreferredSize(new Dimension(1260, 690));

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

    mainGlassPanel.setBackground(new Color(0, 0, 0, 0));
    mainGlassPanel.setMaximumSize(innerContentPanel.getMaximumSize());
    mainGlassPanel.setMinimumSize(innerContentPanel.getMinimumSize());
    mainGlassPanel.setOpaque(false);
    mainGlassPanel.setPreferredSize(innerContentPanel.getPreferredSize());

    
    //MainGlassPanel group layout 
    GroupLayout mainGlassPanelLayout = new GroupLayout(mainGlassPanel);
    mainGlassPanel.setLayout(mainGlassPanelLayout);
    mainGlassPanelLayout.setHorizontalGroup(
        mainGlassPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGap(0, 0, Short.MAX_VALUE)
    );
    mainGlassPanelLayout.setVerticalGroup(
        mainGlassPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGap(0, 0, Short.MAX_VALUE)
    );

    //Adds panels to the LayeredPane
    innerContentPanel.setLayer(menuPane.getGUI(), JLayeredPane.DEFAULT_LAYER);
    innerContentPanel.setLayer(tabbedPane.getGUI(), JLayeredPane.DEFAULT_LAYER);
    innerContentPanel.setLayer(leftMenuHeaderPanel, JLayeredPane.DEFAULT_LAYER);
    innerContentPanel.setLayer(mainGlassPanel, JLayeredPane.DRAG_LAYER);

    
    //Creates the group layout for the innerContentPane
    GroupLayout innerContentPaneLayout = new GroupLayout(innerContentPanel);
    innerContentPanel.setLayout(innerContentPaneLayout);
    innerContentPaneLayout.setHorizontalGroup(
        innerContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(innerContentPaneLayout.createSequentialGroup()
            .addGroup(innerContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(menuPane.getGUI(), GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addComponent(leftMenuHeaderPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(tabbedPane.getGUI(), GroupLayout.PREFERRED_SIZE, 1200, GroupLayout.PREFERRED_SIZE)
            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(innerContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(innerContentPaneLayout.createSequentialGroup()
                .addComponent(mainGlassPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 111, Short.MAX_VALUE)))
    );
    
    innerContentPaneLayout.setVerticalGroup(
        innerContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(innerContentPaneLayout.createSequentialGroup()
            .addGroup(innerContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(innerContentPaneLayout.createSequentialGroup()
                    .addComponent(leftMenuHeaderPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(menuPane.getGUI(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(tabbedPane.getGUI()))
            .addContainerGap())
        .addGroup(innerContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(innerContentPaneLayout.createSequentialGroup()
                .addComponent(mainGlassPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)))
    );
            
}

public JLayeredPane getGUI(){
	return innerContentPanel;
}

}