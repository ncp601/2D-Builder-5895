package ComponentCommand;

import java.awt.*;

import Frame.InnerPanel;

public class ClearComponents implements ComponentCommands {

	ComponentReceiver compR;
	Component currentLabel;
	Point currentLocation;
	InnerPanel innerPanel;
	
	public ClearComponents(){
		innerPanel = InnerPanel.getInstance();
		compR = innerPanel.getSelectedFloor().getComponentReceiver();
	}
	
	@Override 
	public void execute(){
		compR.clearComponents();
	}
	
	@Override 
	public void undo(){
		compR.unClearComponents();
	}
	
	@Override 
	public void redo(){
		compR.clearComponents(); 
	}
	
}
