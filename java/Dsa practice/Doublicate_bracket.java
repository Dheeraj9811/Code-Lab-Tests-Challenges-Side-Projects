public class Doublicate_bracket {

    public static void main(String[] args) {
        Mystack<Character> stack = new Mystack<>();
        String str = "(a+b) + ((c+d))";
        for (int i = 0; i <str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == ')'){
                if(stack.peek() == '('){
                    System.out.println(true);
                    return;
                } else{
                    while(stack.peek() != '('){
                        stack.pop();
                    }
                    stack.pop();
                }

            }
             else{
                stack.push(ch);
            }
        }
        System.out.println(false);
    }
    
}

class Mystack<E> {
    listNode<E> Top;
    int length;

    static class listNode<E>{
        E data;
        listNode<E> next;

        public listNode(E data){
            this.data = data;
        }
    }
    Mystack(){
        Top = null;
        length = 0;
    }
    int length(){
        return length;
    }
    boolean isempty(){
        return length ==0 ;
    }

    public void push(E data){
        listNode<E> temp = new listNode<E>(data);
        temp.next = Top;
        Top = temp;
        length++;
        
    }
    public E pop(){
                                                                                /*if(Top == null){
                                                                                System.out.println("stack is empty ");
                                                                            }*/
        if(isempty()){
            System.out.println("stack is empty");
        }
        E result = Top.data;
        Top = Top.next;
        length--;
        return result;
    }
    public E peek(){
        if(isempty()){
             System.out.println("stack is empty");
             return null;
            
        
        }else{
            return Top.data;
        }
    }
}
