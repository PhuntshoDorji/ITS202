//Creating a class Stack
public class Stack{
    //declaring variables
	int[] arr; 
	int top;
	int size;

    //Constructor 
	public Stack(int x){
        //declaring variables
        size = 0;
        top = -1; 
        arr = new int[x];
    }

    //method to test if the array is empty or not
    public  boolean isEmpty(){
        if (size==0) {
            return true;  
        }
        return false;
    }
    //checking size of array
    public  int size(){
        return size;
    }

    //getting the value that is at the top of the stack
    public  int top(){
        if (isEmpty()) {
            return 0;
        }
        return arr[top];
    }
    //adding value to the stack
    public  void push(int n){
        top = top + 1;
        if (isEmpty()){ // if the array is empty
            arr[0] = n;
            top = arr[0];
            top = 0;

        }
        else //if the array isnt empty
        {
            arr[top] = n;
        }
        size = size + 1; //increase the size after adding the value

    }
    //removing a value from the stack
    public  int pop(){
        if (isEmpty()) {
            return 0;
        }
        else{

            top = top - 1;
        }
        size = size - 1;
        return arr[top + 1];
    }
    //main method
    public static void main(String[] args) {        
        Stack  = new Stack(8); //stack object declaration
        //pushing values
        p.push(46);p
        p.push(45);
        p.push(44);
        p.push(43);
        //calling the functions
        System.out.println(p.isEmpty());
        System.out.println(p.size());
        System.out.println(p.top());
        System.out.println(p.pop());
        System.out.println(p.size());   
        System.out.println(p.top());  
    }

}
	
