package Frame;

public class DoorComponentFactory extends AbstractFloorComponentFactory{
	
	@Override
	public FloorComponent getComponent(String componentType){
		if(componentType == null){
			return null;
		}
		
		else if(componentType == "DOORFDOL"){
			return new DoorComponentFacingDownOpenLeft();
		}
		
		else if(componentType == "DOORFDOR"){
			return new DoorComponentFacingDownOpenRight();
		}
		
		else if(componentType == "DOORFLOL"){
			return new DoorComponentFacingLeftOpenLeft();
		}
		
		else if(componentType == "DOORFLOR"){
			return new DoorComponentFacingLeftOpenRight();
		}
		
		else if(componentType == "DOORFROL"){
			return new DoorComponentFacingRightOpenLeft();
		}
		
		else if(componentType == "DOORFROR"){
			return new DoorComponentFacingRightOpenRight();
		}
		
		else if(componentType == "DOORFUOL"){
			return new DoorComponentFacingUpOpenLeft();
		}
		
		else if(componentType == "DOORFUOR"){
			return new DoorComponentFacingUpOpenRight();
		}
		else
			return null;
	}
	
}