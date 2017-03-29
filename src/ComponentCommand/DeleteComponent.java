package ComponentCommand;

import java.awt.*;

public class DeleteComponent implements ComponentCommands {

	ComponentReceiver compR;
	Component currentLabel;
	Point currentLocation;
	
	public DeleteComponent(ComponentReceiver r, Component c, Point l){
		this.compR = r;
		this.currentLabel = c;
		this.currentLocation = l;
	}
	
	@Override 
	public void execute(){
		compR.deleteComponent(currentLabel, currentLocation);
	}
	
	@Override 
	public void undo(){
		
	}
	
	@Override 
	public void redo(){
		 
	}
	
}
