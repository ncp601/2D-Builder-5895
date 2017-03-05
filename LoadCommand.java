package Frame;

public class LoadCommand implements ToolBarCommands{

ToolBarReceiver toolbarR;
	
	@Override
	public void execute(){
		toolbarR.loadPlan();
	}
	
}
