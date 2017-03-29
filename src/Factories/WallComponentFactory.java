package Factories;

import FloorComponent.*;

public class WallComponentFactory extends AbstractFloorComponentFactory{
	
	@Override
	public FloorComponent getComponent(String componentType){
		if(componentType == null){
			return null;
		}
		
		else if(componentType == "WALLHALF"){
			return new WallComponentHalfBlock(true);
		}
		
		else if(componentType == "WALL1H"){
			return new WallComponentOneBlockHorizontal(true);
		}
		
		else if(componentType == "WALL1V"){
			return new WallComponentOneBlockVertical(true);
		}
		
		else if(componentType == "WALL2H"){
			return new WallComponentTwoBlockHorizontal(true);
		}
		
		else if(componentType == "WALL3H"){
			return new WallComponentThreeBlockHorizontal(true);
		}
		
		else if(componentType == "WALL2V"){
			return new WallComponentTwoBlockVertical(true);
		}
		
		else if(componentType == "WALL3V"){
			return new WallComponentThreeBlockVertical(true);
		}
		
		else
			return null;
	}
	
	@Override
	public FloorComponent getGridComponent(String componentType){
		if(componentType == null){
			return null;
		}
		
		else if(componentType == "WALLHALF"){
			return new WallComponentHalfBlock(false);
		}
		
		else if(componentType == "WALL1H"){
			return new WallComponentOneBlockHorizontal(false);
		}
		
		else if(componentType == "WALL1V"){
			return new WallComponentOneBlockVertical(false);
		}
		
		else if(componentType == "WALL2H"){
			return new WallComponentTwoBlockHorizontal(false);
		}
		
		else if(componentType == "WALL3H"){
			return new WallComponentThreeBlockHorizontal(false);
		}
		
		else if(componentType == "WALL2V"){
			return new WallComponentTwoBlockVertical(false);
		}
		
		else if(componentType == "WALL3V"){
			return new WallComponentThreeBlockVertical(false);
		}
		
		else
			return null;
	}
	
}
