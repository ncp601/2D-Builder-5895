package ToolBarCommand;

import Frame.TabbedPane;

public class LoadCommand implements ToolBarCommands{

	ToolBarReceiver toolbarR;
	TabbedPane currentTabbedPane;
	
	public LoadCommand(ToolBarReceiver r ,TabbedPane p){
		this.toolbarR = r;
		this.currentTabbedPane = p;
	}
	
	@Override
	public void execute(){
		toolbarR.loadPlan();
	}
	
}
