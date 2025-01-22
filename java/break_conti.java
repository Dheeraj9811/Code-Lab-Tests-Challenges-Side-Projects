public class break_conti {
    public static void main(String[] args) {
        for( int i = 1 ; i <=100 ; i++ ) {
            if (i == 51 ) {
                break;
            } 
            if ( i == 31 ) {
                continue;
            }
            System.out.println(i);
        }
    }
    
}
