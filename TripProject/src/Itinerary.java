/*
 * This class implements an instance of itinerary which includes tripstops
 * @author Varun Batra
 * varun.batra@stonybrook.edu
 * 110256128
 */
public class Itinerary implements Cloneable{
	private TripStopNode head;// head of the list
	private TripStopNode tail;// tail of the list
	private TripStopNode cursor;// cursor
	boolean success = true;// exception thrown or not
	
	private int stops;// number of trip stops
	private int cursorNumber ;// number where cursor is
	public Itinerary(){// empty constructor
		
		
	}
	public TripStopNode getCursor(){
		return this.cursor;
	}
	public int getStopsCount(){
		return stops;
	}
	/*
	 * Returns the sum of distances over all TripStopNodes.
	 */
	public int getTotalDistance(){
		TripStopNode pointer= head;
		
		int answer = 0;
		for(int i =0; i<this.getStopsCount(); i++){
			answer+= pointer.getData().getDistance();
			pointer = pointer.getNext();
			}
	
	
		
		return answer;
		
	}
	/*
	 * Returns a reference to the TripStop wrapped by the TripStopNode that cursor points to.
If cursor is null, this returns null
	 */
	public TripStop getCursorStop(){
		if(cursor ==null){
			return null;
		}
		return cursor.getData();
		
	}
	/*
	 * Returns the cursor to the start of the list.
Postconditions:
If head is not null, the cursor now references the first TripStopNode in this list.
If head is null, the cursor is set to null as well (there are no TripStop objects in this list).
	 */
	public void resetCursorToHead(){
		cursorNumber=0;
		cursor = head;
	}
	/*
	 * reset cursorr to tail
	 */
	public void resetCursorToTail(){
		cursorNumber= this.getStopsCount();
		cursor = tail;
	}
	/*
	 * Moves the cursor to select the next TripStopNode in this list. If cursor == tail, throw an exception.
Throws:
EndOfItineraryException - Thrown if cursor is at the tail of the list.
	 */
	public void cursorForward() {
		try{
			
			if(cursor== tail){
			success = false;
			throw new EndOfItineraryException();
		}
		cursor = cursor.getNext();
		cursorNumber++;
		}
		catch(EndOfItineraryException e){
			System.out.println("End of Itinerary");
		}
	
		
	
	}
	/*
	 * Inserts the indicated TripStop after the tail of the list.
Parameters:
newStop
The TripStop object to be wrapped and inserted into the list after the tail of the list.
Preconditions:
newStop is not null.
Postconditions:
newStop has been wrapped in a new TripStopNode object
If tail was previously not null, the newly created TripStopNode has been inserted into the list after the tail.
If tail was previously null, the newly created TripStopNode has been set as the new head of the list (as well as the tail).
The tail now references the newly created TripStopNode.
Throws:
IllegalArgumentException
Thrown if newStop is null.
	 */
	public void appendToTail(TripStopNode newStop){
		try{
			if(newStop== null){
			success = false;
			throw new IllegalArgumentException();
			
		}
	
		if(tail!=null){newStop.setPrev(tail);
		newStop.setNext(tail.getNext());
		tail.setNext(newStop);
		tail= newStop;
		
		}
		
		else if(tail==null){
		newStop.setNext(head);
		newStop.setPrev(head);
		head = newStop;
		tail= head;
		
		cursor= head;
		}
		
		stops++;
		}
		catch(IllegalArgumentException e){
			System.out.println(" data cannot be null");
		}
	}
	/*
	 * Moves the cursor to select the previous TripStopNode in this list. If cursor == head, throw an exception (this includes the case where cursor and head are both null).
Throws:
EndOfItineraryException- Thrown if cursor is at the head of the list.
	 */
	public void cursorBackward(){
		try{

			
			if(cursor== head){
				throw new EndOfItineraryException();
			}
			
			cursor= cursor.getPrev();
			cursorNumber--;
		}
		
		catch(EndOfItineraryException e){
			System.out.println("End Of Itinerary");
		}
	}
	/*
	 * Inserts the indicated TripStop before the cursor.
Parameters:
newStop
The TripStop object to be wrapped and inserted into the list before the cursor.
Preconditions:
newStop is not null.
Postconditions:
newStop has been wrapped in a new TripStopNode object
If cursor was previously not null, the newly created TripStopNode has been inserted into the list before the cursor.
If cursor was previously null, the newly created TripStopNode has been set as the new head of the list (as well as the tail).
The cursor now references the newly created TripStopNode .
Throws: 
IllegalArgumentException
Thrown if newStop is null.
	 */
	public void insertBeforeCursor(TripStop newStop){
		TripStopNode t = new TripStopNode(newStop);
		try{if(newStop== null){
			throw new IllegalArgumentException();
		}
	
		if(cursor== head){
			t.setNext(cursor);
			head= t;
			
		}
		else if(cursor!=null& cursor!=head){
			
			t.setPrev(cursor.getPrev());
			cursor.setPrev(t);
			t.setNext(cursor);
			cursor.getPrev().setNext(t);}
			
		this.stops++;
		}
		catch(IllegalArgumentException e){
			System.out.println("Data cannot be null");
		}
		
		
	}
	/*
	 * Removes the TripStopNode referenced by cursor and returns the TripStop inside.
Preconditions
cursor != null
Postconditons
The TripStopNode referenced by cursor has been removed from the list.
All other TripStopNodes in the list exist in the same order as before.
The cursor now references the next TripStopNode
Exceptions: If the cursor was originally the tail, the cursor will now reference the current tail.
Returns
The TripStop that was removed
Throws
EndOfListException if cursor is null.
	 */
	public TripStop removeCursor(){TripStop removed = cursor.getData();
	try{ if(cursor == null){
		removed = null;
		throw new EndOfItineraryException();
	}
	
		if(cursor!= tail & cursor!= head){
		cursor.getPrev().setNext(cursor.getNext());
		cursor.getNext().setPrev(cursor.getPrev());
		cursor= cursor.getNext();
		cursorNumber--;
		this.stops --;
		}
		else if(cursor == head){
		System.out.println("Cannot remove head");
		throw new EndOfItineraryException();
	}
	else if(cursor== tail){
			tail= cursor.getPrev();
			cursor= cursor.getPrev();
			cursor.setNext(null);
			cursorNumber--;
			this.stops --;
	}
		
	}
	
	catch(EndOfItineraryException e){
		this.success= false;
		System.out.println("Cannot remove null reference");
	}
	return removed;

		
		
		
	}
	public void insertAfterCursor(TripStopNode newStop){
		try{if(newStop== null){
			success = false;
			throw new IllegalArgumentException();
			
		}
	
		if(cursor!=null){newStop.setPrev(cursor);
		newStop.setNext(cursor.getNext());
		cursor.setNext(newStop);
		
		
		}
		
		if(cursor==null){
		newStop.setNext(head);
		newStop.setPrev(head);
		head = newStop;
		tail= head;
		
		cursor= head;
		}
		
		stops++;
		}
		catch(IllegalArgumentException e){
			System.out.println(" data cannot be null");
		}
	}
	
	public Object clone(){
		Itinerary clone = new Itinerary();
		try {
			clone = (Itinerary) super.clone();
			
		} catch (CloneNotSupportedException e) {
			
			e.printStackTrace();
		}
TripStopNode pointer= head;
		
		
		for(int i = this.getStopsCount(); i>0; i--){
		clone.appendToTail((TripStopNode)pointer.clone());
			pointer = pointer.getNext();
			}
		return clone;
	}
	public void printItinerary(){
		TripStopNode pointer= head;
		String x = "";
		for(int i =0; i<this.getStopsCount(); i++){
			String trip = pointer.getData().getLocation();
			String description = pointer.getData().getActivity();
			int distance = pointer.getData().getDistance();
			x+=String.format("%-21s%-26s%19d", trip, description, distance);
			x+= " miles";
			x+="\n";
			
			
			pointer = pointer.getNext();
			
		}
		System.out.println(x);
		int before = this.getStopsCount()-(this.getStopsCount()-this.cursorNumber);
		int after = this.getStopsCount()-this.cursorNumber-1;
		System.out.println("This trip has "+ this.getStopsCount()+ " stops totaling "+ this.getTotalDistance()+ " miles "+ before+" stops before the cursor "+"and "+ after+ " stops after the cursor" );
		
	}
	public void clear(){
		
	
			this.head= null;
			this.tail=this.head;
			this.resetCursorToHead();
			this.stops=0;
		
	}
	public static void main(String [] args){
		TripStop t = new TripStop("d","d",4);
		TripStop z = new TripStop("d","3",4);
		TripStop u = new TripStop("d","u",4);
		TripStop x = new TripStop("c","3",5);
		TripStopNode d = new TripStopNode(t);
		TripStopNode b = new TripStopNode(z);
		TripStopNode c = new TripStopNode(x);
		Itinerary i = new Itinerary();
		i.appendToTail(d);
		i.appendToTail(b);
		i.appendToTail(c);
		i.printItinerary();
		

		System.out.println(i.head.getData());

		System.out.println(i.tail.getData());
		i.cursorForward();
		i.cursorForward();
		System.out.println(i.stops);
		i.removeCursor();
		System.out.println(i.stops);

	
		
		System.out.println(i.cursor.getData());
		

i.appendToTail(d);

	
	
		i.cursorForward();
	
		
		System.out.println(i.cursor.getData());

	
		
		
	}
	

}
