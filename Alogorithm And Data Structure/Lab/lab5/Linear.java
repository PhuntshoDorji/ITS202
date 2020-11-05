public class Linear{    
public static int linearSearch(int[] arr1, int key){    
        for(int i=0;i<arr1.length;i++){    
            if(arr1[i] == key){    
                return i;    
            }    
        }    
        return -1;    
    }    
    public static void main(String a[]){    
        int[] arr= {8,5,2,6,3,1,7};    
        int key = 6;    
        System.out.println(key+" is found at index: "+linearSearch(arr, key));    
    }    
}