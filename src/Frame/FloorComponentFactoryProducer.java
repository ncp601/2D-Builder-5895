package Frame;

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
	      
	      return null;
	   }
	}