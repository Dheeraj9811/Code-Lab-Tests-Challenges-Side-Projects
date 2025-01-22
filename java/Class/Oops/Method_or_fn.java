// how to create fn 

public class Method_or_fn { 
     public static void main(String[] args) { // static class ek ander static fn he call hota hn
        
         int FIrstNumber = 34 , SecondNumber = 23;
         int result = maxOf(FIrstNumber, SecondNumber) ;
         System.out.println(result);



     }

     static int maxOf (int a , int b ) {
         if(a> b) {
             return a;
         } else {
             return b ;
         }
     }


    

}
    

