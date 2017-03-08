package Frame;

import javax.swing.*;

public class AddComponent implements ComponentCommands {
	
	ComponentReceiver compR;
	FloorComponent currentLabel;
	
	public AddComponent(ComponentReceiver r, FloorComponent l) {
		this.compR = r;
		this.currentLabel = l;
	}
	
	@Override 
	public void execute(){
		compR.addComponent();
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
