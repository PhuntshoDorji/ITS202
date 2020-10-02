//Creating class
public class Queue{
	int[] arr;
	int rear;
	int len;
	int front;
	int first;

	//constructor
	public Queue(int x){
		len = 0;
		rear = -1;
		front = -1;
		first = -1;
		arr = new int[x];
	}

	//cjecking array is empty or not
	public boolean isEmpty(){
		if (len == 0) {
			return true;	
		}
		return false;

	}
	//size of the array
	public int len(){
		return len;
	}

	//value that is at the front of the queue
	public int first(){
		if (isEmpty()) {
			return 0;	
		}
		else
		{
			return arr[front];
		}
	}

	//adding values
	public void enqueue(int x){
		if (isEmpty()) {
			arr[0] = x;
			front = 0;
			rear = 0;
			first = arr[0];
		}
		else
		{
			arr[rear + 1] = x;
			rear = rear + 1;
		}
		len = len + 1;
	}

	//removing values
	public int dequeue(){
		if (isEmpty()) {
			return 0;
		}
		else
		{
			front = front + 1; 
		}
		len = len - 1;
		return arr[front-1];
	}
	//main method
	public static void main(String[] args) {		
        Queue s = new Queue(8); //object declaration
        p.enqueue(45);
        p.enqueue(44);
        p.enqueue(43);
        p.enqueue(42);
    
        System.out.println(p.isEmpty());
        System.out.println(p.len());
        System.out.println(p.first());
        System.out.println(p.dequeue());
        System.out.println(p.len());        

	}
}