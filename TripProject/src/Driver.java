/*
 * This Class is used as an interface for the itinerary class
 * @author Varun Batra
 * varun.batra@stonybrook.edu
 * 110256128
 */
import java.util.Scanner;
public class Driver {
	int switched =0;
	Itinerary i = new Itinerary();
	Itinerary second = new Itinerary();
	Scanner scan = new Scanner(System.in);

	public void Operations() throws NumberFormatException{
		
		i.success= true;// successful if exception not thrown
		second.success=true;
	
		System.out.println("Select an operation");
		switch(scan.nextLine().toLowerCase()){// not case sensitive
		
		case "f" :if(switched%2==0){ i.cursorForward();// if not switched then use object i
		if(i.success){
			System.out.println("Cursor moved forward");
		}
		}
		if(switched%2==1){// if switched use object second
			second.cursorForward();
			if(second.success){
				System.out.println("Cursor moved forward");
			}
			
			
		}
		Operations();
		break;
		
	case "b" : if(switched%2==0){i.cursorBackward();// move cursor back
	if(i.success){
		System.out.println("Cursor moved backward");
	}
	}
	if(switched%2==1){second.cursorBackward();
	if(second.success){
		System.out.println("Cursor moved backward");
	}
	}
	Operations();
	break;
	
	case "i" : try{if(switched%2==0){System.out.println("Enter Location:");// insert before cursor
	String location = scan.nextLine();
	System.out.println(" Enter Activity");
	String activity = scan.nextLine();
	System.out.println("Enter distance");
	int distance = Integer.parseInt(scan.nextLine());
	TripStop t = new TripStop(location,activity,distance);
	i.insertBeforeCursor(t);
	if(i.success){
		System.out.println("Added");
	}
	}
	if(switched%2==1){System.out.println("Enter Location:");
	String location = scan.nextLine();
	System.out.println(" Enter Activity");
	String activity = scan.nextLine();
	System.out.println("Enter distance");
	int distance = Integer.parseInt(scan.nextLine());
	TripStop t = new TripStop(location,activity,distance);
	second.insertBeforeCursor(t);
	if(second.success){
		System.out.println("Added");
	}
	}
	Operations();
	break;
	}
	catch(NumberFormatException e){
		System.out.println(" enter a valid number");
		Operations();
		break;
	}
	case"a" :try{if(switched%2==0){System.out.println("Enter Location:");// append to tail
	String locatio = scan.nextLine();
	System.out.println(" Enter Activity");
	String activit = scan.nextLine();
	System.out.println("Enter distance");
	int distanc = Integer.parseInt(scan.nextLine());
	TripStop trip = new TripStop(locatio,activit,distanc);
	TripStopNode a = new TripStopNode(trip);
	i.appendToTail(a);
	if(i.success){
		System.out.println("Added");
	}
	}
	if(switched%2==1){System.out.println("Enter Location:");
	String locatio = scan.nextLine();
	System.out.println(" Enter Activity");
	String activit = scan.nextLine();
	System.out.println("Enter distance");
	int distanc = Integer.parseInt(scan.nextLine());
	TripStop trip = new TripStop(locatio,activit,distanc);
	TripStopNode a = new TripStopNode(trip);
	second.appendToTail(a);
	if(second.success){
		System.out.println("Added");
	}
	}
	
	Operations();
	break;
	}
	catch(NumberFormatException e){
		System.out.println(" Enter a valid number");
		Operations();
		break;
	}
	case"d" : if(switched%2==0){i.removeCursor();// remove cursor
	if(i.success){
		System.out.println("Removed");
	}
	}
	 if(switched%2==1){second.removeCursor();
		if(second.success){
			System.out.println("Removed");
		}
		}
	 Operations();
	 break;
	case"h" : if(switched%2==0){i.resetCursorToHead();;// reset to head
	if(i.success){
		System.out.println("Cursor reset to head");
	}
	}
	 if(switched%2==1){second.resetCursorToHead();;
		if(second.success){
			System.out.println("Cursor reset to head");
		}
		}
	 Operations();
	 break;
	case"t" : if(switched%2==0){i.resetCursorToTail();;// reset to tail
	if(i.success){
		System.out.println("Cursor reset to tail");
	}
	}
	 if(switched%2==1){second.resetCursorToTail();;
		if(second.success){
			System.out.println("Cursor reset to head");
		}
		}
	 Operations();
	 break;

	
		

	case "s" :switched++;// switch itineraries
		System.out.println("itineraries switched");
	

	Operations();
	break;
	case "o": if(switched%2==0){// insert before cursor of this itinerary from other itinerary
		i.insertBeforeCursor((TripStop) second.getCursor().getData().clone());
		Operations();
	}
		if(switched%2==1){
			second.insertBeforeCursor(((TripStop) i.getCursor().getData().clone()));
			Operations();
		}
		break;
		
		case "r": if(switched%2==0){// replace with clone
			i= (Itinerary) second.clone();
		}
		if(switched%2==1){
			second = (Itinerary) i.clone();
	}
		Operations();
		break;
		
		case "p": if(switched %2==0){// print itinerary
			i.printItinerary();
		}
		if(switched %2==1){
			second.printItinerary();
		}
		Operations();
		break;
		
		case"c": if(switched%2==0){// clear
			i.clear();
		}
		if(switched%2==1){
			second.clear();
		}
		Operations();
		break;
		// edit
		case"e" : try{if(switched%2==0){System.out.println("Edit Location, or press enter without typing anything to keep:");
			i.getCursor().getData().setLocation(scan.nextLine());
			System.out.println("Edit Activity, or press enter without typing anything to keep:");
			i.getCursor().getData().setActivity(scan.nextLine());
			System.out.println("Edit Distance, or press enter without typing anything to keep:");
			i.getCursor().getData().setDistance(scan.nextInt());

			
			
		
			
		
		}
		else if(switched%2==1){System.out.println("Edit Location, or press enter without typing anything to keep:");
		second.getCursor().getData().setLocation(scan.nextLine());
		System.out.println("Edit Activity, or press enter without typing anything to keep:");
		second.getCursor().getData().setActivity(scan.nextLine());
		System.out.println("Edit Distance, or press enter without typing anything to keep:");

		second.getCursor().getData().setDistance(scan.nextInt());
		

		
		
	}
		

			
		}
		
		catch(NumberFormatException e){
			System.out.println("Enter a valid number");
		}

		Operations();
		case"l":
		Operations();
			break;
		case "q": System.out.println("Exiting Program...");// quit
		
		break;
		}
	


		
		
		
		}
		
		
		
	
	public static void main(String[] args){
		Driver d = new Driver();
		System.out.println("Main Menu: " );
		System.out.println("F-Cursor forward" );
		System.out.println("B-Cursor backward" );
		System.out.println("I-Insert before cursor" );
		System.out.println("A-Append to tail" );
		System.out.println("D-Delete and move cursor forward" );
		System.out.println("H-Cursor to Head" );
		System.out.println("T-Cursor to Tail" );
		System.out.println("E-Edit cursor" );
		System.out.println("S-Switch itinerary" );
		System.out.println("O-Insert cursor from other itinerary before cursor from this itinerary" );
		System.out.println("R-Replace this itinerary with a copy of the other itinerary" );
		System.out.println("P-Print current itinerary, including summary" );
		System.out.println("C-Clear current itinerary" );
		System.out.println("Q) Quit" );
		d.Operations();

	}
}
