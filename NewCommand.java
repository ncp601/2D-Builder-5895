package Frame;

public class NewCommand implements ToolBarCommands{

	ToolBarReceiver toolbarR;
	
	@Override
	public void execute(){
		toolbarR.newPlan();
	}
}
