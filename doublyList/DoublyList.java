public class DoublyList{
    public Node head;
    
    
    /* First Constructor:
     * Creates a linked list using the values from the given array. head will refer
     * to the Node that contains the element from a[0]
     */ 
    public DoublyList(Object [] a){
        head = new Node(null, null, null);
        Node tail = head;
        
        for(int i = 0; i<a.length; i++){
            Node mn = new Node(a[i], null, null);
            tail.next = mn;
            mn.prev=tail;
            tail=tail.next;
        }
        tail.next=head; // Making it circular
        head.prev=tail;
    }
    
    /* Second Constructor:
     * Sets the value of head. head will refer
     * to the given LinkedList
     */
    public DoublyList(Node h){
        head = h;
    }
    
    /* Counts the number of Nodes in the list */
    public int countNode(){
        int count = 0;
        for(Node n = head.next; n!=head; n=n.next){
            count++;
        }
        return count;
        //  return -100; // please remove this line!
    }
    
    /* prints the elements in the list */
    public void forwardprint(){
        for(Node n = head.next; n!=head; n=n.next){
            if(n.next!=head){
                System.out.print(n.element + ",");         
            }
            else{
                System.out.print(n.element + ".");   
            }
        }
        System.out.println();     
    }
    
    public void backwardprint(){
        for(Node n = head.prev; n!=head; n=n.prev){
            if(n.prev!=head){
                System.out.print(n.element + ",");         
            }
            else{
                System.out.print(n.element + ".");   
            }
        }
        System.out.println();     
    }
    
    
    // returns the reference of the Node at the given index. For invalid index return null.
    public Node nodeAt(int idx){
        // TO DO
        // Solution 1
        int size = countNode();
        if(idx == -1){
            return head;  // reference of DUMMY HEAD <-- VERY IMPORTANT
        }
        else if(idx<-1 || idx> (size-1) ){
            System.out.println("Invalid index: " + idx);  
            return null;
        }
        else{
            Node n = head.next;
            for(int i = 0; i<idx; n = n.next){
                // note: i<idx , not i<=idx, because value is returned outside the loop
                i++;
            }
            return n;  // here i==idx
            // return null; // please remove this line!
        }
    }
    
    
    /* returns the index of the Node containing the given element.
     if the element does not exist in the List, return -1.
     */
    public int indexOf(Object elem){
        // TO DO
        int i = 0;      
        for( Node n = head.next; n!=head; n = n.next){ 
            if(n.element.equals(elem)){ 
                return i; 
            } 
            i++; 
        } 
        return -1; 
        
        //     return -100; // please remove this line!
    }
    
    
    
    /* inserts Node containing the given element at the given index
     * Check validity of index.
     */
    public void insert(Object elem, int idx){
        // TO DO
        if(idx<0 || idx > countNode()){ 
            System.out.println("Invalid Index"); 
        } 
        else{ 
            Node mn = new Node(elem, null, null); 
            
            Node pred = nodeAt(idx-1);
            Node succ = pred.next;
            mn.next=succ;
            mn.prev=pred;
            pred.next=mn; 
            succ.prev=mn; 
        } 
    }
    
    
    
    
    /* removes Node at the given index. returns element of the removed node.
     * Check validity of index. return null if index is invalid.
     */
    public Object remove(int index){
        // TO DO
        int size = countNode(); 
        if(index<0 || index> (size-1) ){ 
            System.out.println("Invalid Index"); 
            return null; 
        } 
        
        else{  
            Node pred = nodeAt(index-1); 
            Node removedNode = pred.next; // to help the Garbage Collector 
            Node succ = removedNode.next; // to help the Garbage Collector 
            Object removedElement = removedNode.element; // to be returned 
            
            pred.next = succ; 
            succ.prev = pred;
            
            removedNode.element = null; // to help the Garbage Collector 
            removedNode.next= null; // to help the Garbage Collector 
            removedNode.prev= null; // to help the Garbage Collector 
            return removedElement; 
            
        } 
        
        
        
        // return null; // please remove this line!
    }
    
    
    
}
