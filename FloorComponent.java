package Frame;

import java.awt.Dimension;

import javax.swing.*;


abstract public class FloorComponent extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
