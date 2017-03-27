package Frame;

import javax.swing.*;

public class NewCommand implements ToolBarCommands{

	ToolBarReceiver toolbarR;
	TabbedPane currentTabbedPane;
	
	public NewCommand(ToolBarReceiver r ,TabbedPane p) {
		this.toolbarR = r;
		this.currentTabbedPane = p;
	}
	
	@Override
	public void execute(){
		toolbarR.newPlan(currentTabbedPane);
	}
}
