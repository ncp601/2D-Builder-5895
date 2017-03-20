package Frame;

import java.awt.Dimension;

import javax.swing.*;


abstract public class FloorComponent extends JLabel{

	protected boolean isNewComponent;
	
	abstract public void createComponent();
	abstract public String getComponentType();
	abstract public Dimension getImageSize();
	
	public void setIsNewComponent(boolean m){
		isNewComponent = m;
	}
	
	 
	public boolean getIsNewComponent(){
		return isNewComponent;
	}
	
}
