package Frame;

import java.awt.*;

public class AddComponent implements ComponentCommands {
	
	ComponentReceiver compR;
	FloorComponent currentLabel;
	Component source;
	Point currentLocation;
	
	public AddComponent(ComponentReceiver r, Component s, FloorComponent c, Point l) {
		this.compR = r;
		this.currentLabel = c;
		this.source = s;
		this.currentLocation = l;
	}
	
	@Override 
	public void execute(){
		compR.addComponent(currentLabel, source,  currentLocation);
	}
	
	@Override 
	public void undo(){
		compR.deleteComponent(currentLabel, currentLocation);
	}
	
	@Override 
	public void redo(){
		compR.reAddComponent(currentLabel, source,  currentLocation);
	}
	
}
