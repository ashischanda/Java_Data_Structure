public class LinkedList{
  public Node head;
  
  /* First Constructor:
   * Creates a linked list using the values from the given array. head will refer
   * to the Node that contains the element from a[0]
   */ 
  public LinkedList(Object [] a){
    head = new Node(a[0], null);
    Node tail = head;
    
    for(int i = 1; i<a.length; i++){
      Node mn = new Node(a[i], null);
      tail.next = mn;
      tail=tail.next;// this line is important. Here, tail will take the address of tail.next
      // Because, in next step of loop we need to add new item on same tail 
    }  
  }
  
  /* Second Constructor:
   * Sets the value of head. head will refer
   * to the given LinkedList
   */
  public LinkedList(Node h){
    head = h;
  }
  
  /* Counts the number of Nodes in the list */
  public int countNode(){
    int count = 0;
    for(Node n = head; n!=null; n=n.next){
      count++;
    }
    return count;
  }
  
  /* prints the elements in the list */
  public void printList(){
    for(Node n = head; n!=null; n=n.next){
      if(n.next!=null){
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
    // Solution 1
    int size = countNode();
    if(idx<0 || idx> (size-1) ){
      System.out.println("Invalid index: " + idx);  
      return null;
    }
    else{
      Node n = head;
      for(int i = 0; i<idx; n = n.next){
        // note: i<idx , not i<=idx, because value is returned outside the loop
        i++;
      }
      return n;  // here i==idx
    }
    
    /*
     Solution 2: if size/countNode() is not available
     */
    
//    if(idx<0){
//      System.out.println("Invalid index: " + idx); 
//      return null;
//    }
//    Node n = head;
//    for(int i = 0; n!=null; n = n.next){
//      // note: i<idx , not i<=idx, because value is returned outside the loop
//      if(i==idx){
//        return n;
//      }
//      else{
//        i++;
//      }
//    }
//    System.out.println("Invalid index: " + idx); // idx > size
//    return null;
    
  }
  
  
// returns the element of the Node at the given index. For invalid idx return null.
  public Object get(int idx){
    int size = countNode();
    if(idx<0 || idx> (size-1) ){
      System.out.println("Invalid index: " + idx);  
      return null;
    }
    else{
      Node n = head;
      for(int i = 0; i<idx; n = n.next){
        // note: i<idx , not i<=idx, because value is returned outside the loop
        i++;
      }
      return n.element; // here i==idx
    }
  }
  
  
  
  /* updates the element of the Node at the given index. 
   * Returns the old element that was replaced. For invalid index return null.
   * parameter: index, new element
   */
  public Object set(int idx, Object elem){
    int size = countNode();
    if(idx<0 || idx> (size-1) ){
      return null;
    }
    else{
      Node n = head;
      for(int i = 0; i<idx; n = n.next){
        // note: i<idx , not i<=idx, because value is returned outside the loop
        i++;
      }
      Object oldElement = n.element;
      n.element=elem; // here i==idx
      
      return oldElement;
    }
  }
  
  
  /* returns the index of the Node containing the given element.
   if the element does not exist in the List, return -1.
   */
  public int indexOf(Object elem){
    int i = 0;     
    for( Node n = head; n!=null; n = n.next){
      if(n.element.equals(elem)){
        return i;
      }
      i++;
    }
    return -1; 
  }
  
  // returns true if the element exists in the List, return false otherwise.
  public boolean contains(Object elem){
    for( Node n = head; n!=null; n = n.next){
      if(n.element.equals(elem)){
        return true;
      }
    }
    return false; 
  }
  
  // Makes a duplicate copy of the given List. Returns the reference of the duplicate list.
  public Node copyList(){
    Node copyHead = new Node(head.element, null);
    Node copyTail = copyHead;
    
    for(Node n = head.next; n!=null; n=n.next){
      Node mn = new Node(n.element, null);
      copyTail.next = mn;
      copyTail=copyTail.next;
    } 
    return copyHead;
    
  }
  
  // Makes a reversed copy of the given List. Returns the head reference of the reversed list.
  public Node reverseList(){
    Node revHead = new Node(head.element, null);
    for(Node n = head.next; n!=null; n=n.next){
      Node mn = new Node(n.element, null);
      mn.next = revHead;
      revHead=mn;
    } 
    return revHead;
    
  }
  
  /* inserts Node containing the given element at the given index
   * Check validity of index.
   */
  public void insert(Object elem, int idx){
    if(idx<0 || idx > countNode()){
      System.out.println("Invalid Index");
    }
    else{
      Node mn = new Node(elem, null);
      if(idx==0){
        mn.next = head; 
        head = mn; // Note head CHANGES.
      }
      else{
        Node pred = nodeAt(idx-1);
        mn.next=pred.next;
        pred.next=mn;
        
      }
    }
  }
  
  
  /* removes Node at the given index. returns element of the removed node.
   * Check validity of index. return null if index is invalid.
   */
  public Object remove(int index){
    int size = countNode();
    if(index<0 || index> (size-1) ){
      System.out.println("Invalid Index");
      return null;
    }
    
    else{
      if(index==0){
        Node removedNode = head; // to help the Garbage Collector
        Object removedElement = head.element; // to be returned
        head=head.next;
        
        removedNode.element = null; // to help the Garbage Collector
        removedNode.next= null; // to help the Garbage Collector
        return removedElement;
      }
      
      else{
        Node pred = nodeAt(index-1);
        
        Node removedNode = pred.next; // to help the Garbage Collector
        Object removedElement = pred.next.element; // to be returned
        pred.next=pred.next.next;
        
        removedNode.element = null; // to help the Garbage Collector
        removedNode.next= null; // to help the Garbage Collector
        return removedElement;
        
      }
      
    }
  }
  
  // Rotates the list to the left by 1 position.
  public void rotateLeft(){
    Node mn = head; // the node to be rotated to the left, thus appending at the end
    head = head.next; // Removed mn from the begining.
    mn.next = null; // Makeing it sequential.
    
    // Find the tail node
    Node tail = head;
    for(; tail.next!=null; tail= tail.next){
      
    }
    
    tail.next=mn; // add the node
    
  }
  
  // Rotates the list to the right by 1 position.
  public void rotateRight(){
    
    // Find the predecessor of the tail node, whose next ref should be null
    Node ptail = head;
    for(; ptail.next.next!=null; ptail= ptail.next){
      
    }
    
    Node tail = ptail.next; // current tail is the node to be rotated to the right,
    //thus to be inserted at the begining
    ptail.next=null; // Making it sequential
    
    // inserting at the begining
    tail.next = head;
    head = tail;  
    
  }
  
}
