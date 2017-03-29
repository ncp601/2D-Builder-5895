package Factories;

import FloorComponent.*;

public class OfficeComponentFactory extends AbstractFloorComponentFactory{
	
	@Override
	public FloorComponent getComponent(String componentType){
		if(componentType == null){
			return null;
		}
		
		else
			return null;
	}

	@Override
	public FloorComponent getGridComponent(String componentType) {
		// TODO Auto-generated method stub
		return null;
	}
	
}