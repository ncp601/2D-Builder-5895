package Frame;

import javax.swing.*;

public class NewCommand implements ToolBarCommands{

	ToolBarReceiver toolbarR;
	TabbedPane currentMainPane;
	
	public NewCommand(TabbedPane p){
		this.currentMainPane = p;
	}
	
	@Override
	public void execute(){
		toolbarR.newPlan(currentMainPane);
	}
}
