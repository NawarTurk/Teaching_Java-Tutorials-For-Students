public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Parent parent = new Parent();
		Child child = new Child();
		
		System.out.println("parent = new parent ");

		parent.parentStatic();
		parent.instanceParent();
		parent.makesound();
		
		
		System.out.println("\n\nchild = new child ");

		child.parentStatic();
		child.instanceParent();
		child.makesound();  
		child.childOnlyMethod();
		child.childStatic();
		
		
		System.out.println("\n\nParent = new child ");

		Parent pChild = new Child();   // upcasting (always safe)
		pChild.parentStatic();  // static method → chosen by reference type
		pChild.instanceParent();
		pChild.makesound();  // // polymorphism (runtime binding / dynamic binding) (Child version runs)
		
		// safe downcasting: actual object is Child
		// downcasting; it is safe here because
		// pChild was upcast from a Child object
		Child goodChild = (Child) pChild;
		goodChild.childOnlyMethod();

		
		/*
Method behavior summary

+------------------------------+---------------+--------------+-----------------------------------+-----------------------------------+---------------------------+
| Call site                    | Parent static | Child static | Parent instance (not overridden)  | Parent instance (overridden)      | Child-only instance       |
+------------------------------+---------------+--------------+-----------------------------------+-----------------------------------+---------------------------+
| Parent parent = new Parent() | Parent        | -            | Parent                            | Parent                            | -                         |
| Child child = new Child()    | Parent        | Child        | Parent                            | Child                             | Child                     |
| Parent pChild = new Child()  | Parent        | -            | Parent                            | Child                             | -                         |
+------------------------------+---------------+--------------+-----------------------------------+-----------------------------------+---------------------------+

Notes:
- "Overridden" only matters when the object is Child
- Static methods → reference type
- Instance methods → object type (only if overridden)
*/
		

	}

}
