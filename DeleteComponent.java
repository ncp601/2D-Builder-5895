package Frame;

import javax.swing.JLabel;

public class DeleteComponent implements ComponentCommands {

	ComponentReceiver compR;
	FloorComponent currentLabel;
	
	public DeleteComponent(ComponentReceiver r, FloorComponent l){
		this.compR = r;
		this.currentLabel = l;
	}
	
	@Override 
	public void execute(){
		compR.deleteComponent();
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
