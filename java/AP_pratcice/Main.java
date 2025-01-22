

public class Main extends subclass {
    int main;
    Main(){
        System.out.println("main constructor");
    }
        
    
    void printmain(){
        System.out.println("main class");
    }

    public static void main(String[] args) {
        subclass object = new Main();
        object.printsub();
        
    }
}

class subclass{
    int sub;
    subclass(){System.out.println("sub class constructor");}
    void printsub(){
        System.out.println("sub class");
    }
}