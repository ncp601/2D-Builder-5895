package Frame;

import javax.swing.*;

public class AddComponent implements ComponentCommands {
	
	ComponentReceiver compR;
	FloorComponent currentLabel;
	
	public AddComponent(ComponentReceiver r, FloorComponent l) {
		this.currentLabel = l;
	}
	
	@Override 
	public void execute(){
		compR.addComponent(currentLabel);
	}
	
	@Override 
	public void undo(){
		//TODO 
	}
	
	@Override 
	public void redo(){
		//TODO 
	}
	
}
