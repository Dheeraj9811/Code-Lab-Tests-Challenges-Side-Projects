public class Imp_fn {
    public static void main(String[] args) {
        // The method compareTo() is used for comparing two strings lexicographically.

        // Here the comparison is between string literals. For e.g. A.compareTo(B) where
        // A and B are String literals.

        // This method returns a negative integer, zero or positive integer if the
        // string calling the method
        // (which is string here) is lexicographically smaller, equal or larger than the
        // string given as the method argument.

        String A = "StringA";
        String B = "StringB";

        int result = A.compareTo(B);

        if (result > 0)
            System.out.println("A is lexicographically larger than B");
        else if (result < 0)
            System.out.println("A is lexicographically smaller than B");
        else
            System.out.println("A is lexicographically equal to B");

        // ------------------------------------------------------------------------------------------------------

        /*
         * Capitalize the first letter and print them on a single line, separated by a
         
         
         * space. given string from specified startIndex (inclusive) to endIndex
         * (exclusive).
         * 
         * Take the first letter of the string A using substring(int startIndex, int
         * endIndex) method and capitalize the first letter using toUpperCase() method.
         * A.substring(0, 1).toUpperCase() Concatenate the above string with the rest of
         * the string using substring(int startIndex) A.substring(0, 1).toUpperCase() +
         * A.substring(1)
         */


         // split function 
         
         /*limit > 0 : If this is the case then the pattern will be
            applied at most limit-1 times, the resulting 
            array’s length will not be more than n, and 
            the resulting array’s last entry will contain
            all input beyond the last matched pattern.
        limit < 0 : In this case, the pattern will be applied as
            many times as possible, and the resulting 
            array can be of any size.
        limit = 0 : In this case, the pattern will be applied as 
            many times as possible, the resulting array can 
            be of any size, and trailing empty strings will
            be discarded.
         */

            
        String str = "geekss@for@geekss";
        String[] arrOfStr = str.split("@", 2);
          
        for (String a : arrOfStr)
            System.out.println(a);

        /*
         * We can eliminate the leading and trailing spaces of a string in Java with the
         * help of trim(). It does not eliminated the middle spaces of the string. It
         * doesn’t replace the value of String object. Therefore if we want the access
         * to the new String object, we just need to reassign it to the old String or
         * assign it to a new variable.
         */

            
        

         

    }

}
