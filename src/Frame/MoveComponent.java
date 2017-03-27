package Frame;

import java.awt.*;

import javax.swing.*;

public class MoveComponent implements ComponentCommands {

	ComponentReceiver compR;
	Component currentLabel;
	Point currentLocation;
	
	public MoveComponent(ComponentReceiver r, Component c, Point l){
		this.compR = r;
		this.currentLabel = c;
		this.currentLocation = l;
	}
	
	@Override 
	public void execute(){
		compR.moveComponent(currentLabel, currentLocation);
	}
	
	@Override 
	public void undo(){
		compR.moveComponent(currentLabel, currentLocation);
	}
	
	@Override 
	public void redo(){
		compR.moveComponent(currentLabel, currentLocation); 
	}
	
}
