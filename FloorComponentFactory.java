package Frame;

public class FloorComponentFactory {
	
	public FloorComponent getComponent(String componentType){
		if(componentType == null){
			return null;
		}
		
		else if(componentType == "WALL"){
			return new WallComponent();
		}
		
		else if(componentType == "WINDOW"){
			return new WindowComponent();
		}
		
		else if(componentType == "DOOR"){
			return new DoorComponent();
		}
		
		else
			return null;
	}
	
}
