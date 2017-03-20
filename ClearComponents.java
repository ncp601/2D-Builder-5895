package Frame;

import java.awt.*;

import javax.swing.*;

public class ClearComponents implements ComponentCommands {

	ComponentReceiver compR;
	Component currentLabel;
	Point currentLocation;
	
	public ClearComponents(){

	}
	
	@Override 
	public void execute(){
		compR.clearComponent();
	}
	
	@Override 
	public void undo(){
		  
	}
	
	@Override 
	public void redo(){
		compR.clearComponent(); 
	}
	
}
