public class Sting_into_int {
    public static void main(String[] args) {
        // Convert using Integer.toString(int)

        int number = -782;
        String numberAsString = Integer.toString(number);// 
        System.out.println(numberAsString);
    //he Integer class has a static method that returns a String object representing the specified int parameter.
   //public static String toString(int i) The argument i is converted and returned as a string instance. 
   //If the number is negative, the sign will be preserved. 
        //----------------------------------------------------------------------------------------------------------------


        //Convert using String.valueOf(int)
        int number1 = -782;
		String numberAsString1 = String.valueOf(number1);
		System.out.println(numberAsString1);
        
    }
   
}
//String s = String.valueOf(n);
//String s = Integer.toString(n);
//String s = "" + n;