package FloorComponent;

import Factories.AbstractFloorComponentFactory;

public class DoorComponentFactory extends AbstractFloorComponentFactory{
	
	@Override
	public FloorComponent getComponent(String componentType){
		if(componentType == null){
			return null;
		}
		
		else if(componentType == "DOORFDOL"){
			return new DoorComponentFacingDownOpenLeft(true);
		}
		
		else if(componentType == "DOORFDOR"){
			return new DoorComponentFacingDownOpenRight(true);
		}
		
		else if(componentType == "DOORFLOL"){
			return new DoorComponentFacingLeftOpenLeft(true);
		}
		
		else if(componentType == "DOORFLOR"){
			return new DoorComponentFacingLeftOpenRight(true);
		}
		
		else if(componentType == "DOORFROL"){
			return new DoorComponentFacingRightOpenLeft(true);
		}
		
		else if(componentType == "DOORFROR"){
			return new DoorComponentFacingRightOpenRight(true);
		}
		
		else if(componentType == "DOORFUOL"){
			return new DoorComponentFacingUpOpenLeft(true);
		}
		
		else if(componentType == "DOORFUOR"){
			return new DoorComponentFacingUpOpenRight(true);
		}
		else
			return null;
	}

	@Override
	public FloorComponent getGridComponent(String componentType) {
		if(componentType == null){
			return null;
		}
		
		else if(componentType == "DOORFDOL"){
			return new DoorComponentFacingDownOpenLeft(false);
		}
		
		else if(componentType == "DOORFDOR"){
			return new DoorComponentFacingDownOpenRight(false);
		}
		
		else if(componentType == "DOORFLOL"){
			return new DoorComponentFacingLeftOpenLeft(false);
		}
		
		else if(componentType == "DOORFLOR"){
			return new DoorComponentFacingLeftOpenRight(false);
		}
		
		else if(componentType == "DOORFROL"){
			return new DoorComponentFacingRightOpenLeft(false);
		}
		
		else if(componentType == "DOORFROR"){
			return new DoorComponentFacingRightOpenRight(false);
		}
		
		else if(componentType == "DOORFUOL"){
			return new DoorComponentFacingUpOpenLeft(false);
		}
		
		else if(componentType == "DOORFUOR"){
			return new DoorComponentFacingUpOpenRight(false);
		}
		else
			return null;
	}
	
}