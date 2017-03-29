package Factories;

import FloorComponent.DinningRoomComponentFactory;
import FloorComponent.DoorComponentFactory;
import FloorComponent.WindowComponentFactory;

public class FloorComponentFactoryProducer {
	   public static AbstractFloorComponentFactory getFactory(String type){
	   
	      if(type == "WALL"){
	         return new WallComponentFactory();
	      }
	      
	      else if(type == "DOOR"){
	         return new DoorComponentFactory();
	      }
	      
	      else if(type == "WINDOW"){
		     return new WindowComponentFactory();
		  }
	      
	      else if(type == "STAIRS"){
			     return new StairsComponentFactory();
	      }
	      
	      else if(type == "ELEVATOR"){
			     return new ElevatorComponentFactory();
	      }
	      
	      else if(type == "FLOORING"){
			     return new FlooringComponentFactory();
	      }
	      
	      else if(type == "DINNINGROOM"){
			     return new DinningRoomComponentFactory();
	      }
	      
	      else if(type == "KITCHEN"){
			     return new KitchenComponentFactory();
	      }
	      
	      else if(type == "OFFICE"){
			     return new OfficeComponentFactory();
	      }
	      
	      else if(type == "BEDROOM"){
			     return new BedroomComponentFactory();
	      }
	      
	      else if(type == "BATHROOM"){
			     return new BathroomComponentFactory();
	      }
	      
	      else if(type == "LAUNDRY"){
			     return new LaundryComponentFactory();
	      }
	      
	      else if(type == "GARAGE"){
			     return new GarageComponentFactory();
	      }
	      
	      return null;
	   }
	}