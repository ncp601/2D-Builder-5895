package Frame;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class BackButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BackButton() {
		setText("Back");
	    setBorder(null);
	    setBorderPainted(false);
	    setContentAreaFilled(false);
	    setDefaultCapable(false);
	    setFocusPainted(false);
	    
	    addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
            	setForeground(Color.BLUE);
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	setForeground(Color.BLACK);
            }               
        });
	}
}
