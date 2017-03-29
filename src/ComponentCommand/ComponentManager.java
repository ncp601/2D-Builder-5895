package ComponentCommand;

import java.util.*;

public class ComponentManager {

	private List<ComponentCommands> commandList = Collections.emptyList();

	private ComponentCommands lastCommand;
	private int index = 0;
	
	
	public void doCurrentCommand(ComponentCommands command) {
		List<ComponentCommands> newComponentCommandList = new ArrayList<ComponentCommands>(index + 1);
		
		for(int i = 0; i < index; i++){
			newComponentCommandList.add(commandList.get(i));
		}
		
		newComponentCommandList.add(command);
		commandList = newComponentCommandList;
		index++;
		
		command.execute();
	}
	

	public void undo() {
		if(isUndoAvailable()){
			index--;
			lastCommand = commandList.get(index);
			lastCommand.undo();
		}
		
		else {
			throw new IllegalStateException("Undo is not possible");
		}
	}
	
	public void redo() {
		if(isRedoAvailable()){
			lastCommand = commandList.get(index);
			index++;
			lastCommand.redo();
		}
		
		else {
			throw new IllegalStateException("Redo is not possible");
		}
	}
	
	
	public boolean isUndoAvailable() {
		return index > 0;
	}
	
	public boolean isRedoAvailable() {
		return index < commandList.size();
	}
	
}
