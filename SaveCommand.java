package Frame;

public class SaveCommand implements ToolBarCommands{

ToolBarReceiver toolbarR;
	
	@Override
	public void execute(){
		toolbarR.savePlan();
	}
}
