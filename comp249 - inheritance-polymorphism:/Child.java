public class Child extends Parent{
	
	public static void childStatic() {
		System.out.println("childStatic");
	}
	
	@Override
	public void makesound() {
		System.out.println("makesound parent");
	}
	
	public  void childOnlyMethod() {
		System.out.println("childOnlyMethod ");
	}
	
	
	


}

