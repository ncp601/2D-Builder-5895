package Frame;

import java.awt.Dimension;

import javax.swing.*;


abstract public class FloorComponent extends JLabel{

	abstract public void createComponent();
	abstract public String getComponentType();
	abstract public Dimension getImageSize();
	
}
