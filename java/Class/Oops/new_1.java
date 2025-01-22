class Cat {
    boolean hasFur;
    String colour , breed ;
    int legs , eyes; // default value is alwys 0 in int 
    public void walk() {                // this is eg of fn in class
        System.out.println("Cat is walking");

    }
    
    public void eat() {
        System.out.println("cat is eating");
    }

    public void discription(){
        System.out.println("this cat has legs = " + legs + " and eyes = " + eyes);
    }


}

class Dog{

}

// only one class cane be public  
// prograem looks for public class then inside it main class to start reading code
public class new_1 { 
    public static void main(String[] args) { // this is the method to decleare main 

        Cat cat1 = new Cat();   // object of class
        // classname classobject_name = new classname();  this how we createw class object eg above
        // calling fn now below 
        cat1.walk();

        // how to acces variable outside class 
        cat1.legs = 3;

        cat1.discription();
        
    }
    
}
