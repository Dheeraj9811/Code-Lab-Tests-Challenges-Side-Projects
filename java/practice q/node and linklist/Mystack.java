
public class Mystack<E> {
    listNode<E> Top;
    int length;

    static class listNode<E>{
        E data;
        listNode<E> next;

        public listNode(E data){
            this.data = data;
        }
    }
    public Mystack(){
        Top = null;
        length = 0;
    }
    public int length(){
        return length;
    }
    public boolean isempty(){
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
    public void peek(){
        if(isempty()){
             System.out.println("stack is empty");
             
            
        
        }else{
            System.out.println(Top.data);
        }
    }
    public static void main(String[] args) {
        Mystack<Integer> stack = new Mystack<Integer>();
        stack.push(21);
        stack.push(15);
        stack.push(20);
        stack.peek();
        stack.pop();
        stack.pop();
        stack.peek();
        
        
    }
}
