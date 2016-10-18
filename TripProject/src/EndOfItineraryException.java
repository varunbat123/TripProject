/*
 * End of itinerary exception
 * Varun Batra
 * varun.batra2stonybrook.edu
 * 110256128
 */
public class EndOfItineraryException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -881518641889991603L;
	
	EndOfItineraryException(){
		super();
	}

	EndOfItineraryException(String message){
		super(message);
	}
}
