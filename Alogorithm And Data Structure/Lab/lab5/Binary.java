public class Binary{    
 	public static void main(String args[]){  
        int arr[] = {1,2,3,4,5,6,7,8,9};  
        int value = 4;  
        int first=0;
        int last=arr.length-1;  
            
        int mid = (first + last)/2;  
   		while( first <= last ){  
      		if ( arr[mid] < value){  
        		first = mid + 1;     
      		}
      		else if ( arr[mid] == value )
      		{  
        		System.out.println("Element is found at index: " + mid);  
        		break;  
      		}
      		else{  
         	last = mid - 1;  
      		}  
      		mid = (first + last)/2;  
   		}  
   		if ( first > last ){  
      		System.out.println("Element is not found!");  
   		}    
 	}  
}  