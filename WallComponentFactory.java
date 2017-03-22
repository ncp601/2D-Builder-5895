package Frame;

public class WallComponentFactory extends AbstractFloorComponentFactory{
	
	@Override
	public FloorComponent getComponent(String componentType){
		if(componentType == null){
			return null;
		}
		
		else if(componentType == "WALLHALF"){
			return new WallComponentHalfBlock();
		}
		
		else if(componentType == "WALL1H"){
			return new WallComponentOneBlockHorizontal();
		}
		
		else if(componentType == "WALL1V"){
			return new WallComponentOneBlockVertical();
		}
		
		else if(componentType == "WALL2H"){
			return new WallComponentTwoHorizontal();
		}
		
		else if(componentType == "WALL3H"){
			return new WallComponentThreeHorizontal();
		}
		
		else if(componentType == "WALL2V"){
			return new WallComponentTwoBlockVertical();
		}
		
		else if(componentType == "WALL3V"){
			return new WallComponentThreeBlockVertical();
		}
		
		else
			return null;
	}
	
}
