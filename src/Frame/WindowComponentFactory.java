package Frame;

public class WindowComponentFactory extends AbstractFloorComponentFactory{
	
	@Override
	public FloorComponent getComponent(String componentType){
		if(componentType == null){
			return null;
		}
		
		else if(componentType == "WINDOW2H"){
			return new WindomComponentTwoHorizontal();
		}
		
		else if(componentType == "WINDOW3H"){
			return new WindowComponentThreeHorizontal();
		}
		
		else if(componentType == "WINDOW2V"){
			return new WindowComponentTwoVertical();
		}
		
		else if(componentType == "WINDOW3V"){
			return new WindowComponentThreeVertical();
		}

		else
			return null;
	}
	
}