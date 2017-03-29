//package Frame;
package FloorComponent;

import Factories.AbstractFloorComponentFactory;

public class WindowComponentFactory extends AbstractFloorComponentFactory{
	
	@Override
	public FloorComponent getComponent(String componentType){
		if(componentType == null){
			return null;
		}
		
		else if(componentType == "WINDOW1H"){
			return new WindowComponentOneHorizontal(true);
		}
		
		else if(componentType == "WINDOW1V"){
			return new WindowComponentOneVertical(true);
		}
		
		else if(componentType == "WINDOW2H"){
			return new WindomComponentTwoHorizontal(true);
		}
		
		else if(componentType == "WINDOW3H"){
			return new WindowComponentThreeHorizontal(true);
		}
		
		else if(componentType == "WINDOW2V"){
			return new WindowComponentTwoVertical(true);
		}
		
		else if(componentType == "WINDOW3V"){
			return new WindowComponentThreeVertical(true);
		}

		else
			return null;
	}

	@Override
	public FloorComponent getGridComponent(String componentType) {
		if(componentType == null){
			return null;
		}
		
		else if(componentType == "WINDOW1H"){
			return new WindowComponentOneHorizontal(false);
		}
		
		else if(componentType == "WINDOW1V"){
			return new WindowComponentOneVertical(false);
		}
		
		else if(componentType == "WINDOW2H"){
			return new WindomComponentTwoHorizontal(false);
		}
		
		else if(componentType == "WINDOW3H"){
			return new WindowComponentThreeHorizontal(false);
		}
		
		else if(componentType == "WINDOW2V"){
			return new WindowComponentTwoVertical(false);
		}
		
		else if(componentType == "WINDOW3V"){
			return new WindowComponentThreeVertical(false);
		}

		else
			return null;
	}
	
}