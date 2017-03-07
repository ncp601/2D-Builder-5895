package Frame;

public class SaveCommand implements ToolBarCommands{

	ToolBarReceiver toolbarR;
	
	public SaveCommand(){
		
	}
	
	@Override
	public void execute(){
		toolbarR.savePlan();
	}
}
