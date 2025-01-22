class count{
    public static void main(String[] args) {
        
        print(5);
    }

    static void  print(int n){
        if(n == 0){
            System.out.println(n);
        }
        else{
            System.out.println(n);
            print(n-1);

        }
    }
}