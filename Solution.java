import java.util.*;

public class Solution<Key extends Comparable<Key>, Value> {
    private Node root;  // root of BST
    private int n;
     int nodeCount;


    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;
    

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
            left = null;
            right = null;
        }
    }
    //Initializes an empty symbol table.
    public Solution() {
        root = null;
        n = 0;
    }

    //Returns true if this symbol table is empty.
    public boolean isEmpty() {
        if (n ==0) {
            return true;    
        }
        return false;  
    }
    //Returns the number of key-value pairs in this symbol table.
    public int size() {
        return n;   
    }
   
    public Value get(Key key) {
        Node x = root;
        if (key == null) {
            throw new IllegalArgumentException("Key is Null");   
        }
        while( x.key != key){
            int temp = key.compareTo(x.key);
            if (temp < 0) {
                x = x.left;
            }
            else if (temp > 0) {
                x = x.right;   
            }
            if (x.key == key) {
                return x.val;
                
            }
        }
        return x.val;   
    }

    public void put(Key key, Value val) {
        if (key == null) {
            throw new IllegalArgumentException("Key is Null");    
        }
        else {
            Node newest = new Node(key,val,1);
            if(root == null){
                root = newest;
            }
            else{
                Node x = root;
                Node parent;
                while( x!=null ){
                    parent = x;
                    int temp = key.compareTo(x.key);
                    if(temp < 0){
                        x = x.left;
                        if(x == null){
                            parent.left = newest;
                            n = root.size++;
                            return;
                        }
                        else if(x.key == key){
                            x.val = val;
                            return;
                        }
                    }
                    else if(temp > 0){
                        x = x.right;
                        if(x == null){
                            parent.right = newest;
                            n = root.size++;
                            return;
                        }
                        else if(x.key == key){
                            x.val = val;
                            return;
                        }
                    }
                }
            }
        }

    }

    public Key min() {
        Node x = root;
        for (x = root; x.left != null; x = x.left ) {
            if (x == null) 
                throw new NoSuchElementException("Symbol Table is Empty");     
        }
        return x.key;
    }  
   
    public Key floor(Key key) {
        Node x = getNode(root, key);
        Node temp = x;
        if (key == null) {
            throw new IllegalArgumentException("Key is Null"); 
        }   
        else if (size() == 0) {
            throw new NoSuchElementException("No such Key");
        }
        if (x==null) {
            return null;
        } 
        if(x.left!=null){
            temp = x.left;
            
            while(temp.right!=null){
                temp = temp.right;
            }
        }
        return temp.key;
    }
    private Node getNode(Node x, Key key){
        Node node = null;
        if (key == null) {
            throw new IllegalArgumentException("Key is Null");   
        }
        while( x!= null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) {
                return x;
            }
            if (cmp > 0) {
                node = x;
                x = x.right;
            }
            else {
                x = x.left;
            }
        }
        return node;
    }

    
    public Key select(int k) {
        nodeCount=0;
        if ((k<0) || k>=size()) {
            throw new IllegalArgumentException("Rank should be between 0 ans its size");
        }
        return select(root, k+1).key;
    }
    
    // Return key of rank k. 
     private Node select(Node x, int k) {
        Stack<Node> stack = new Stack<Node>();
        Node curr = root;
        while (!stack.empty() || curr != null)
        {
            if (curr != null)
            {
                stack.push(curr);
                curr = curr.left;
            }
            else
            {
                curr = stack.pop();
                nodeCount++;
                if(nodeCount == k)
                    break;
                curr = curr.right;
            }
        }
        return curr;
    } 
    
    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) {
            throw new IllegalArgumentException("first argument to keys() is null");
        }
        if (hi == null) {
            throw new IllegalArgumentException("second argument to keys() is null");
        }

        Queue<Key> queue = new LinkedList<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x,Queue<Key> queue, Key lo, Key hi) { 
        if (x == null) {
            return;
        }
        while (x != null){
            int cmplo = x.key.compareTo(lo);
            int cmphi = x.key.compareTo(hi);
            
            if (x.left == null) {
                if (cmphi <= 0 && cmplo >= 0) {
                    queue.offer(x.key);
                }
                x = x.right;
            }
            else {
                Node node = x.left;
                while (node.right != null && node.right != x) {
                    node = node.right;
                }
            }
        }
    }

    public static void main(String[] args) { 
        Solution<String, Integer> obj = new Solution<String, Integer>();

       
    }
}