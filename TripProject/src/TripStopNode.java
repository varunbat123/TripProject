import java.util.Stack;

/*
 * This class implents a node used to wrap a tripstop data type which will be used in linked list
 * @author Varun Batra
 * varun.batra@stonybrook.edu
 * 110256128
 */
public class TripStopNode implements Cloneable {
	private TripStop data; // E Data
	private TripStopNode next;// link next
	private TripStopNode prev;// link previous
	/*
	 * Default constructor.
Parameters:
initData - The data to be wrapped by this TripStopNode. This parameter should not be null, since we should never have a TripStopNode with null data (remember, this class serves only as a wrapper for the TripStop class).
Preconditions:
initData is not null.
Postconditions:
This TripStopNode has been initialized to wrap the indicated TripStop, and prev and next have been set to null.
Throws: 
IllegalArgumentException 
Thrown if initData is null.
	 */
	public TripStopNode(TripStop initData){
		if(initData== null){
			throw new NullPointerException();
		}
		this.data= initData;
	}
	/*
	 * Returns the reference to the data member variable of the list node.
	 */
	public TripStop getData(){
		return this.data;
	}
	/*
	 * Sets the data private field to the one passed as a parameter.
Parameters:
newData  - Reference to a new TripStop object to update the data member variable. This parameter must not be null, since we should never have a TripStopNode with null data (remember, this class serves only as a wrapper for the TripStop class).
Preconditions:
newData is not null.
Throws:
IllegalArgumentException - Thrown if newData is null.
	 */
	public void setData(TripStop data){
		if(data== null){
			throw new IllegalArgumentException();
		}
		this.data = data;
	}
	/*
	 * Returns the reference to the next member variable of the list node. Can be null, means there's no next TripStopNode.
	 */
	public TripStopNode getNext(){
		return this.next;
	}
	/*
	 * Updates the next member variable with a new TripStopNode reference.
Parameters:
newNext - Reference to a new TripStopNode object to update the next member variable. 
	 */
	public void setNext(TripStopNode next){
		this.next = next;
	}
	/*
	 * return previous
	 */
	public TripStopNode getPrev(){
		return this.prev;
	}
	public void setPrev(TripStopNode prev){// set previous
		
	
			this.prev= prev;
			
	
	}
	public Object clone(){// clone
		TripStopNode clone = new TripStopNode((TripStop)data.clone());
		try {
			clone = (TripStopNode) super.clone();
		} catch (CloneNotSupportedException e) {
			
			e.printStackTrace();
		}
		return clone;
	}

public static void main(String args[]){
	Stack<Integer> numbers = new Stack<Integer>();
	Stack<Character> operations = new Stack<Character>();
int y;
int x;
char operation;
	String s = "(1+1) + (2+2)";
	for(int i =0; i<s.length(); i++){
		if(Character.isDigit(s.charAt(i))){
			numbers.push((int) s.charAt(i));
		}
		else if(s.charAt(i)==')'){
			 y = numbers.pop()-48;
			 operation = operations.pop();
	 x = numbers.pop()-48;
	 System.out.print(x +y );
		}
		else if(s.charAt(i)=='+'){
			operations.push(s.charAt(i));
		}
		
			
		}
	}
	
	
	
}
