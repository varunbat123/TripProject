
public class test {
int switched=0;

public void switched(){
	switched++;
	System.out.println("itineraries switched");
}

public static void main( String[]args){
	test t = new test();
	t.switched();
	t.switched();
	t.switched();
	t.switched();
	t.switched();
	
	System.out.println(t.switched%2);
}
}
