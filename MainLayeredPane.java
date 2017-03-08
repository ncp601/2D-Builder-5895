package Frame;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;

public class MainLayeredPane extends JLayeredPane implements MouseListener {

    private JPanel glassPanel;
    private Grid gridPanel;
	
	public MainLayeredPane(){
		addMouseListener(this);
	    setOpaque(true);

	  //------------------------------------------------------------------------------
	        
	  //Creates the glassPanel layer that will lay on top of the canvas and act as the drag layer
	    glassPanel = new JPanel();
	    
	    glassPanel.setBackground(new Color(0, 0, 0, 0));
	    glassPanel.setOpaque(false);

	  //------------------------------------------------------------------------------
	    
	  //Creates the gridPanel that will represent the grid under the glassPanel
	    gridPanel = new Grid();
	    
	  //------------------------------------------------------------------------------  
	    
	  //Creates the layouts for the mainLayeredPanel and the glassPanel 
	    GroupLayout glassPanelLayout = new GroupLayout(glassPanel);
	    glassPanel.setLayout(glassPanelLayout);
	    glassPanelLayout.setHorizontalGroup(
	        glassPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	        .addGap(0, 1050, Short.MAX_VALUE)
	    );
	    glassPanelLayout.setVerticalGroup(
	        glassPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	        .addGap(0, 653, Short.MAX_VALUE)
	    );
	    
	  //Sets the layers in the layeredPanel
	    setLayer(glassPanel, JLayeredPane.DRAG_LAYER);
	    setLayer(gridPanel, JLayeredPane.DEFAULT_LAYER);

	    GroupLayout mainLayeredPanelLayout = new GroupLayout(this);
	    setLayout(mainLayeredPanelLayout);
	    mainLayeredPanelLayout.setHorizontalGroup(
	        mainLayeredPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	        .addComponent(glassPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        .addGroup(mainLayeredPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addComponent(gridPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	    );
	    mainLayeredPanelLayout.setVerticalGroup(
	        mainLayeredPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	        .addGroup(GroupLayout.Alignment.TRAILING, mainLayeredPanelLayout.createSequentialGroup()
	            .addComponent(glassPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	            .addGap(0, 0, Short.MAX_VALUE))
	        .addGroup(mainLayeredPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addComponent(gridPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	    );
	}
	
	public JPanel getGlassPanel(){
		return glassPanel;
	}
	

    private ByteArrayOutputStream baos;
    private ByteArrayInputStream bins;
    FloorComponent copyofdragLabel;

	public void setFC(FloorComponent c){
		copyofdragLabel = c;
		
	}
	public void setBaos(ByteArrayOutputStream baos){
		this.baos = baos;
	}


	@Override
    public void mousePressed(MouseEvent e){
		try 
		{
//			if(copyofdragLabel != null){
			deepCopy(copyofdragLabel);
			pasteLabel(e.getX(),e.getY());
        	System.out.println("MOUSE_CLICKED");
//			}
		}
        catch (Exception ex){}
	};


    public void pasteLabel(int x, int y)throws Exception
    {
        {
            bins = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream oins = new ObjectInputStream(bins);
            FloorComponent obj = (FloorComponent) oins.readObject();
        	System.out.println("MOUSE_CLIC4KED");
            glassPanel.add(obj);
        	System.out.println("MOUSE_CLICKE5D");
            obj.setBounds(x,y,obj.getWidth(),obj.getHeight());
            repaint();
        }
    }
    
    public void deepCopy(FloorComponent label)throws Exception
    {	
        System.out.println("DEEP_COPY");
        baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(label);
        oos.close();
    }

	@Override
    public void mouseEntered(MouseEvent e){};

//	@Override
//    public void mousePressed(MouseEvent e){};

	@Override
    public void mouseExited(MouseEvent e){};

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
    public void mouseClicked(MouseEvent e){};
    
	
	
}






