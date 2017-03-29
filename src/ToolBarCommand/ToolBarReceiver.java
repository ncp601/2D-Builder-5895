package ToolBarCommand;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;

import Frame.InnerPanel;
import Frame.TabbedPane;

/** 
 * Implements the code for the new, save and load commands 
 * from the toolbar.
 */
public class ToolBarReceiver {
	
	private JFileChooser fileChooser = new JFileChooser();
	
	private BufferedWriter saveStream;
	private BufferedReader loadStream;
	
	private File currentFile;
	
	private StringBuilder sb;
	private String loadedComponents;
	
	private FileWriter fw;
	private FileReader fr;
	
	private PrintWriter out;
	
	private String applicationDirectory = "C:/Users/Nick/workspace/twoBuilder/FloorPlans";
	
	private int returnFile;
	
	private InnerPanel innerPanel;
	
	public void newPlan(TabbedPane currentMainPane){
		currentMainPane.removeAll();
	}
	
	public void savePlan(){
		innerPanel = InnerPanel.getInstance();
		
		fileChooser.setCurrentDirectory(new File(applicationDirectory));
		fileChooser.setDialogTitle("FloorPlans");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		returnFile = fileChooser.showSaveDialog(fileChooser);
		
		if(returnFile == JFileChooser.APPROVE_OPTION){
			currentFile = new File(fileChooser.getSelectedFile().getPath());
			try {
				fw = new FileWriter(currentFile + ".txt");
				saveStream = new BufferedWriter(fw);
				out = new PrintWriter(saveStream);
				out.println(innerPanel.getTabbedPane().floorsToString());
				out.close();
				saveStream.close();
				fw.close();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void loadPlan(){
		innerPanel = InnerPanel.getInstance();
		
		fileChooser.setCurrentDirectory(new File(applicationDirectory));
		fileChooser.setDialogTitle("FloorPlans");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		returnFile = fileChooser.showOpenDialog(fileChooser);
		
		if(returnFile == JFileChooser.APPROVE_OPTION){
			currentFile = new File(fileChooser.getSelectedFile().getPath());
			try {
				fr = new FileReader(fileChooser.getSelectedFile());
				loadStream = new BufferedReader(fr);
				
				sb = new StringBuilder();
				loadedComponents = loadStream.readLine();
				
				while (loadedComponents != null) {
		            sb.append(loadedComponents);
		            sb.append("\n");
		            loadedComponents = loadStream.readLine();
		        }
				loadStream.close();
				fr.close();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		innerPanel.setLoadedComponents(sb.toString());
		innerPanel.getTabbedPane().removeAll();
		System.out.println(innerPanel.getLoadedComponents());
	}
	
}
