package ToolBarCommand;

import Frame.TabbedPane;

public class SaveCommand implements ToolBarCommands{

	ToolBarReceiver toolbarR;
	TabbedPane currentTabbedPane;
	
	public SaveCommand(ToolBarReceiver r ,TabbedPane p){
		this.toolbarR = r;
		this.currentTabbedPane = p;
		
	}
	
	@Override
	public void execute(){
		toolbarR.savePlan();
	}
}
