/*
 * This class implements an instance of TripStop which includes a location, activity, and distance
 * Varun Batra
 * varun.batra@stonybrook.edu
 * 110256128
 */
public class TripStop implements Cloneable{
	private String location;// location of trip
	private String activity;// activity of trip
	private int distance;// distance of trip
	/*
	 * default constructor
	 */
	public TripStop(){
		
	}
	/*
	 * construct TripStop with location activity and distance
	 * if distance is not valid throw illegal argument exception
	 */
	public TripStop(String location, String activity, int distance){
		try{
			if(distance<0){
				throw new IllegalArgumentException();
			}
		this.location=location;
		this.activity = activity;
		this.distance = distance;
		}
		catch(IllegalArgumentException e){
			System.out.println("Distance cannot be less than 0");
		}
		}
	/*
	 * returns location
	 */
	public String getLocation(){
		return this.location;
		
	}
	/*
	 * returns this activity
	 */
	public String getActivity(){
		return this.activity;
		
	}
	/*
	 * returns this distance
	 */
	public int getDistance(){
		return this.distance;
		
	}
	/*
	 * set this location to location
	 */
	public void setLocation(String location){
		this.location= location;
		
	}
	/*
	 * set activity variable to activity
	 */
	public void setActivity(String activity){
		this.activity = activity;
	}
	/* 
	 * set this distance to distance
	 */
	public void setDistance(int distance){
		this.distance=distance;
	}
		
/*
 * (non-Javadoc)
 * @see java.lang.Object#toString()
 * return this object as a string
 */
	public String toString(){
		return this.location + " "+ this.activity+ " "+ this.distance+ " miles";
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 * clone this object
	 */
	public Object clone(){
		TripStop clone = new TripStop();
		try {
			clone = (TripStop) super.clone();
		} catch (CloneNotSupportedException e) {
			
			e.printStackTrace();
		}
		return clone;
	}
	
}
