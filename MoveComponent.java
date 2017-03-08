package Frame;

import javax.swing.*;

public class MoveComponent implements ComponentCommands {

	ComponentReceiver compR;
	FloorComponent currentLabel;
	
	
	public MoveComponent(ComponentReceiver r, FloorComponent l){
		this.compR = r;
		this.currentLabel = l;
	}
	
	@Override 
	public void execute(){
		compR.moveComponent();
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
