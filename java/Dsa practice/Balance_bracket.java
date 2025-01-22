public class Balance_bracket {

    static boolean checkclose(Mystack<Character> stack,char ch_opeing){
        if(stack.isempty()){
            return false;
        } else if(stack.peek() != ch_opeing){
            return false;
        } else{
            stack.pop();
            return true;
        }


    }
    
    public static void main(String[] args) {
        Mystack<Character> stack = new Mystack<>();
        String str = "{(a+b) + ((c+d))";
        boolean var;
        
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '('  || c == '{' ||  c == '[' ){
                stack.push(c);
            
            }else if(c == ')'){
                var = checkclose(stack, '(');
                if(!var){
                    System.out.println(false);
                    return;
                }
            }
            else if(c == '}'){
                var = checkclose(stack, '{');
                if(!var){
                    System.out.println(false);
                    return;
                }
            }   
            else if(c == ']'){
                var = checkclose(stack, '[');
                if(!var){
                    System.out.println(false);
                    return;
                }
            }
            
        }
        if(!stack.isempty()) {
            System.out.println(false);
            
        }else
            System.out.println(true);
        
    }
}

