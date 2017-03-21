package Frame;

public class LoadCommand implements ToolBarCommands{

	ToolBarReceiver toolbarR;
	
	public LoadCommand(){
		
	}
	
	@Override
	public void execute(){
		toolbarR.loadPlan();
	}
	
}
