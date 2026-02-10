public class Parent {
	
	public static void parentStatic() {
		System.out.println("parentStatic");
	}
	
	// will not be overidden
	public  void instanceParent() {
		System.out.println("instanceParent");
	}
	
	// is overridden in Child
	public void makesound() {
		System.out.println("makesound parent");
	}
	
	
	
	

}
