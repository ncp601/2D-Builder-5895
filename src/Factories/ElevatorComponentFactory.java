package Factories;

import FloorComponent.ElevatorComponentFacingDown;
import FloorComponent.ElevatorComponentFacingLeft;
import FloorComponent.ElevatorComponentFacingRight;
import FloorComponent.ElevatorComponentFacingUp;
import FloorComponent.FloorComponent;

public class ElevatorComponentFactory extends AbstractFloorComponentFactory{
	
	@Override
	public FloorComponent getComponent(String componentType){
		if(componentType == null){
			return null;
		}
		
		else if(componentType == "ELEVATORUP"){
			return new ElevatorComponentFacingUp(true);
		}
		
		else if(componentType == "ELEVATORDOWN"){
			return new ElevatorComponentFacingDown(true);
		}
		
		else if(componentType == "ELEVATORRIGHT"){
			return new ElevatorComponentFacingRight(true);
		}
		
		else if(componentType == "ELEVATORLEFT"){
			return new ElevatorComponentFacingLeft(true);
		}
		
		else
			return null;
	}

	@Override
	public FloorComponent getGridComponent(String componentType) {
		if(componentType == null){
			return null;
		}
		
		else if(componentType == "ELEVATORUP"){
			return new ElevatorComponentFacingUp(false);
		}
		
		else if(componentType == "ELEVATORDOWN"){
			return new ElevatorComponentFacingDown(false);
		}
		
		else if(componentType == "ELEVATORRIGHT"){
			return new ElevatorComponentFacingRight(false);
		}
		
		else if(componentType == "ELEVATORLEFT"){
			return new ElevatorComponentFacingLeft(false);
		}
		
		else
			return null;
	}
	
}