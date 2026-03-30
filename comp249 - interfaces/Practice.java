// ===================== FULL EXAMPLE =====================

interface Flyable {
    int MAX_ALTITUDE = 10000; // constant → implicitly public static final

    void fly(); // abstract → implicitly public → MUST be implemented

    default void glide() { // concrete (default) → OPTIONAL to override
        System.out.println("Gliding...");
        helper(); // using private helper inside interface
    }

    static void info() { // static → NOT implemented by classes
        System.out.println("Flying capability");
    }

    private void helper() { // private → only usable inside this interface
        System.out.println("Helper inside interface");
    }
}

interface Swimmable {
    void swim(); // abstract → MUST be implemented
}

interface AnimalAbility extends Flyable, Swimmable {
    void live(); // abstract → MUST be implemented
}


// ================= ABSTRACT CLASS =================

abstract class Bird {
    int speed; // instance variable

    static final int MAX_SPEED = 200; // constant

    public Bird(int speed) {
        this.speed = speed;
        System.out.println("Creating a Bird...");
    }

    abstract void makeSound(); // MUST be implemented

    void eat() { // OPTIONAL to override
        System.out.println("Eating...");
        secret();
    }

    static void category() {
        System.out.println("All birds");
    }

    private void secret() {
        System.out.println("Bird secret...");
    }
}


// ================= CLASS =================

class Eagle extends Bird implements AnimalAbility {

    public Eagle(int speed) {
        super(speed);
        System.out.println("Creating an Eagle...");
    }

    @Override
    public void fly() {
        System.out.println("Flying at " + speed);
    }

    @Override
    public void swim() {
        System.out.println("Swimming...");
    }

    @Override
    public void live() {
        System.out.println("Living...");
    }

    @Override
    public void makeSound() {
        System.out.println("Screech!");
    }

    @Override
    void eat() {
        System.out.println("Eagle eating...");
    }

    @Override
    public void glide() {
        Flyable.super.glide();
        System.out.println("Eagle gliding...");
    }
}


// ===================== QUESTIONS =====================

// Can an interface have instance variables? → ______
// Can an interface have constants? → ______
// Can an interface have constructors? → ______
// Can an interface have private methods? → ______
// Can an interface extend multiple interfaces? → ______

// Can an abstract class have instance variables? → ______
// Can an abstract class have constructors? → ______
// Can an abstract class have private methods? → ______
// Can an abstract class have static methods? → ______

// Can a class extend multiple classes? → ______
// Can a class implement multiple interfaces? → ______
// Can a class extend an interface? → ______
// Can an interface extend a class? → ______

// Can Eagle skip implementing fly()? → ______ because __________________
// Can Eagle skip implementing makeSound()? → ______ because __________________
// Can Eagle skip implementing glide()? → ______ because __________________
// Can Eagle skip implementing eat()? → ______ because __________________
// Can Eagle skip implementing info()? → ______ because __________________

// Can Eagle call Flyable.super.glide()? → ______
// Can Eagle call helper() from Flyable? → ______ because __________________
// Can Eagle call secret() from Bird? → ______ because __________________

// Are interface methods public by default? → ______
// Must implemented methods be public? → ______


// ===================== LEGAL / ILLEGAL =====================

// Is this legal? → ______
Flyable f;

// Is this legal? → ______
Bird b;

// Is this legal? → ______
Flyable f2 = new Flyable();

// Is this legal? → ______
Bird b2 = new Bird(10);

// Is this legal? → ______
Flyable f3 = new Eagle(50);

// Is this legal? → ______
Bird b3 = new Eagle(60);

// Is this legal? → ______
Eagle e1 = new Eagle(70);

// Is this legal? → ______
AnimalAbility a1 = new Eagle(80);

// Is this legal? → ______
Eagle e2 = (Eagle) f3;

// Is this legal? → ______
Bird b4 = (Bird) f3;

// Is this legal? → ______
Flyable f4 = b3;

// Is this legal? → ______
Eagle e3 = (Eagle) new Bird(20);

// Is this legal? → ______
Flyable f5 = new Bird(30);




// ===================== ANSWERS =====================

// Can an interface have instance variables? → NO
// Can an interface have constants? → YES
// Can an interface have constructors? → NO
// Can an interface have private methods? → YES
// Can an interface extend multiple interfaces? → YES

// Can an abstract class have instance variables? → YES
// Can an abstract class have constructors? → YES
// Can an abstract class have private methods? → YES
// Can an abstract class have static methods? → YES

// Can a class extend multiple classes? → NO
// Can a class implement multiple interfaces? → YES
// Can a class extend an interface? → NO
// Can an interface extend a class? → NO

// Can Eagle skip implementing fly()? → NO because it is an abstract method from an interface
// Can Eagle skip implementing makeSound()? → NO because it is an abstract method from abstract class
// Can Eagle skip implementing glide()? → YES because it is a default method
// Can Eagle skip implementing eat()? → YES because it is a concrete method
// Can Eagle skip implementing info()? → YES because it is static

// Can Eagle call Flyable.super.glide()? → YES
// Can Eagle call helper() from Flyable? → NO because it is private
// Can Eagle call secret() from Bird? → NO because it is private

// Are interface methods public by default? → YES
// Must implemented methods be public? → YES


// ===================== LEGAL / ILLEGAL =====================

// Is this legal? → YES (just declaration)
Flyable flyableRef;

// Is this legal? → YES (just declaration)
Bird birdRef;

// Is this legal? → NO (cannot instantiate interface)
Flyable flyableObj = new Flyable();

// Is this legal? → NO (cannot instantiate abstract class)
Bird birdObj = new Bird(10);

// Is this legal? → YES (upcasting)
Flyable flyableFromEagle = new Eagle(50);

// Is this legal? → YES (upcasting)
Bird birdFromEagle = new Eagle(60);

// Is this legal? → YES
Eagle eagleObj = new Eagle(70);

// Is this legal? → YES (upcasting to interface)
AnimalAbility abilityFromEagle = new Eagle(80);

// Is this legal? → YES (downcasting, object is actually Eagle)
Eagle eagleFromFlyable = (Eagle) flyableFromEagle;

// Is this legal? → YES (downcasting, object is Eagle)
Bird birdFromFlyable = (Bird) flyableFromEagle;

// Is this legal? → YES (upcasting)
Flyable flyableFromBird = birdFromEagle;

// Is this legal? → NO (cannot instantiate abstract class + wrong cast)
Eagle eagleWrong = (Eagle) new Bird(20);

// Is this legal? → NO (Bird does not implement Flyable directly)
Flyable flyableWrong = new Bird(30);