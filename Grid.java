package Frame;

import java.awt.*;
import javax.swing.*;

public class Grid extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int rowCount = 20;
	private int columnCount = 35; 
	private int borderWidth = 1;
	
	public Grid() {
		
		setBackground(new Color(255, 255, 255));
        setLayout(new GridLayout(rowCount,columnCount));
		
        for(int i =  0; i < rowCount; i++){
        	for(int j = 0; j < columnCount; j++){
        		final JLabel label = new JLabel();

                        label.setBorder(BorderFactory.createMatteBorder(borderWidth, 
                        												borderWidth,
                                                                        borderWidth, 
                                                                        borderWidth, 
                                                                        new Color(190,190,190) 
                                                                        ));

//                }
                add(label);
        	}
        }
        
    }
}
