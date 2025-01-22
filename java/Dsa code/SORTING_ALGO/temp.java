public class temp {
    static int fn(int count ){
        System.out.println(count);
        if(count <3 ){
            fn(fn(fn(++count)));

        }return count;
    }

    public static void main(String[] args) {
        fn(1);
        
    }
}
