import java.util.Vector;

public class possible_subset {
    
    public static void main(String[] args) {
        Vector<Integer> input = new Vector<>();
        Vector<Integer> output = new Vector<>();

        input.add(1);
        input.add(2);
        input.add(3);
        print_subest(input, output, 0);
    }

    static void print_subest(Vector<Integer> input , Vector<Integer> output, int index){
        if(index >= input.size()){

            for (Integer integer : output) {
                System.out.print(integer);
            }
                
            
            System.out.println();
           
                
                return;
            
        }else{
            // not taking
            print_subest(input, output, index+1);

            // taking
            output.add(input.get(index));
            print_subest(input, output, index+1);
        }
    }
}
