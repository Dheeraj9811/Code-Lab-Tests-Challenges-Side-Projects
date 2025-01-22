class is_sorted{

    public static void main(String[] args) {
        int arr[] ={1,5,10,12,15,16};
        int index = 0;
        System.out.println(check(arr, index)); 
    }

    static Boolean check(int arr[] , int index){
        
        Boolean flag = true;
        if(index >=arr.length-1 ){
            return flag;
        }
        else if(arr[index] > arr[index+1]){
            return flag = false;
        }
        else{
            return check(arr, index+1);
        }
    }
}