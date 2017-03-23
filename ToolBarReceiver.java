package Frame;

import java.io.File;

import javax.swing.*;

/** 
 * Implements the code for the new, save and load commands 
 * from the toolbar.
 */
public class ToolBarReceiver {
	
	JFileChooser fileChooser = new JFileChooser();
	String applicationDirectory = "C:/Users/Nick/workspace/twoBuilder/FloorPlans";
	File currentFile;
	
	public void newPlan(TabbedPane currentMainPane){
		currentMainPane.removeAll();
	}
	
	public void savePlan(){
		fileChooser.setCurrentDirectory(new File(applicationDirectory));
		fileChooser.setDialogTitle("FloorPlans");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.showSaveDialog(fileChooser);
		currentFile = fileChooser.getSelectedFile();
		
	}
	
	public void loadPlan(TabbedPane currentMainPane){
		fileChooser.setCurrentDirectory(new File(applicationDirectory));
		fileChooser.setDialogTitle("FloorPlans");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.showOpenDialog(fileChooser);
		
		currentMainPane.removeAll();
	}
	
}
