package ToolBarCommand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Manages the various commands from the toolbar  
 */
public class ToolBarManager {

	private List<ToolBarCommands> commandList = Collections.emptyList();

	private int index = 0;
	
	
	public void doCurrentCommand(ToolBarCommands command) {
		List<ToolBarCommands> newToolBarCommandList = new ArrayList<ToolBarCommands>(index + 1);
		
		for(int i = 0; i < index; i++){
			newToolBarCommandList.add(commandList.get(i));
		}
		
		newToolBarCommandList.add(command);
		commandList = newToolBarCommandList;
		index++;
		
		command.execute();
	}
	
}
