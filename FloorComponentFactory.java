package Frame;

public class FloorComponentFactory {

	public FloorComponent getComponent(String componentType){
		if(componentType == null){
			return null;
		}
		
		else if(componentType == "WALL"){
			return new WallComponent();
		}
		
		else
			return null;
	}
	
}
