package Frame;

import java.awt.*;
import javax.swing.*;

public class Grid extends JPanel{

	private int rowCount = 10;
	private int columnCount = 10; 
	private int borderWidth = 1;
	
	public Grid() {
		
		setBackground(new Color(255, 255, 255));
        setLayout(new GridLayout(10,10));
		
        for(int i =  0; i < rowCount; i++){
        	for(int j = 0; j < columnCount; j++){
        		final JLabel label = new JLabel();
                if (rowCount == 0) {
                    if (columnCount == 0) {
                        // Top left corner, draw all sides
                        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    }
                    else {
                        // Top edge, draw all sides except left edge
                        label.setBorder(BorderFactory.createMatteBorder(borderWidth, 
                                                                        0, 
                                                                        borderWidth, 
                                                                        borderWidth, 
                                                                        Color.BLACK));
                    }
                }
                else {
                    if (columnCount == 0) {
                        // Left-hand edge, draw all sides except top
                        label.setBorder(BorderFactory.createMatteBorder(0, 
                                                                        borderWidth, 
                                                                        borderWidth, 
                                                                        borderWidth, 
                                                                        Color.BLACK));
                    }
                    else {
                        // Neither top edge nor left edge, skip both top and left lines
                        label.setBorder(BorderFactory.createMatteBorder(0, 
                                                                        0, 
                                                                        borderWidth, 
                                                                        borderWidth, 
                                                                        Color.BLACK));
                    }
                }
                add(label);
        	}
        }
        
    }
}