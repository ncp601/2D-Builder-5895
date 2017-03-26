package Frame;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

/** 
 * Implements the code for the new, save and load commands 
 * from the toolbar.
 */
public class ToolBarReceiver {
	
	private JFileChooser fileChooser = new JFileChooser();
	private BufferedWriter saveStream;
	private File currentFile;
	private FileWriter fw;
	private String applicationDirectory = "C:/Users/Nick/workspace/twoBuilder/FloorPlans";
	
	private int returnFile;
	
	private InnerPanel innerPanel;
	
	public void newPlan(TabbedPane currentMainPane){
		currentMainPane.removeAll();
	}
	
	public void savePlan(){
		fileChooser.setCurrentDirectory(new File(applicationDirectory));
		fileChooser.setDialogTitle("FloorPlans");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		returnFile = fileChooser.showSaveDialog(fileChooser);
		
		if(returnFile == JFileChooser.APPROVE_OPTION){
			currentFile = new File(fileChooser.getSelectedFile().getPath());
			try {
				fw = new FileWriter(currentFile + ".txt");
				saveStream = new BufferedWriter(fw);
				fw.write(innerPanel.getTabbedPane().floorsToString());
				fw.close();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void loadPlan(TabbedPane currentMainPane){
		fileChooser.setCurrentDirectory(new File(applicationDirectory));
		fileChooser.setDialogTitle("FloorPlans");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.showOpenDialog(fileChooser);
		
		currentMainPane.removeAll();
	}
	
}
