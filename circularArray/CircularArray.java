public class CircularArray{
  
  private int start;
  private int size;
  private Object [] cir;
  
  /*
   * if Object [] lin = {10, 20, 30, 40, null}
   * then, CircularArray(lin, 2, 4) will generate
   * Object [] cir = {40, null, 10, 20, 30}
   */
  public CircularArray(Object [] lin, int st, int sz){
    cir = new Object[lin.length];
    start = st;
    size=sz;
    int k = start;
    for(int i = 0; i<size; i++){
      cir[k]=lin[i];
      k=(k+1)%cir.length;
    }
    
  }
  
  //Prints from index --> 0 to cir.length-1
  public void printFullLinear(){
    
    for(int i = 0; i<cir.length; i++){
      if(i<(cir.length-1))
        System.out.print(cir[i]+", ");
      else
        System.out.print(cir[i]+". ");
      
    }
    
    System.out.println();
  }
  
  // Starts Printing from index start. Prints a total of size elements
  public void printForward(){
    int k = start;
    for(int i = 0; i<size; i++){
      if(i<(size-1))
        System.out.print(cir[k]+", ");
      else
        System.out.print(cir[k]+". ");
      k=(k+1)%cir.length;
    }
    System.out.println();
  }
  
  
  public void printBackward(){
    int k = (start+size-1)%cir.length;
    for(int i = 0; i<size; i++){
      if(i<(size-1))
        System.out.print(cir[k]+", ");
      else
        System.out.print(cir[k]+". ");
      k--;
      if(k<0){
        k=cir.length-1;
      }
    }
    System.out.println();
  }
  
  
   // With no null cells
  public void linearize(){
    Object [] temp = new Object[size];    
    int k = start;
    for(int i = 0; i<size; i++){
      temp[i]=cir[k];
      k=(k+1)%cir.length;
    }
    cir=temp;
    start=0;
  }
  
  // Do not change the Start index
  public void resizeStartUnchanged(int newcapacity){
    Object [] temp = new Object[newcapacity];
    
    int k = start;
    int p = start;
    
    for(int i = 0; i<size; i++){
      temp[p] = cir[k];
      p= (p+1)%temp.length;
      k=(k+1)%cir.length;
      
    }
    
    cir=temp;
  }
  
  // Start index becomes zero
  public void resizeByLinearize(int newcapacity){
    Object [] temp = new Object[newcapacity];    
    
    int k = start;
    for(int i = 0; i<size; i++){
      temp[i]=cir[k];
      k=(k+1)%cir.length;
    }
    cir = temp;
    start = 0; //Important for students to understand;
    
  }
  
  /* pos --> position relative to start. Valid range of pos--> 0 to size.
   * Increase array length by 3 if size==cir.length
   * use resizeStartUnchanged() for resizing.
   */
  public void insertByRightShift(Object elem, int pos){
    if(pos<0 || pos>size){
      System.out.println("Position is invalid");
    }
    else{
      if(size==cir.length){
        resizeStartUnchanged(cir.length+3);
      }
      
      int nshift = size-pos;
      int from = (start+size-1)%cir.length;
      int to = (from+1)%cir.length;
      
      for(int i = 0; i<nshift; i++){
        cir[to] = cir[from];
        to = from;
        from--;
        if(from <0){
          from = cir.length-1;
        }
      }
      
      int index = (start+pos)%cir.length;
      cir[index]=elem;
      size++;
    }
  }
  
  public void insertByLeftShift(Object elem, int pos){
    if(pos<0 || pos>size){
      System.out.println("Position is invalid");
    }
    else{
      if(size==cir.length){
        resizeStartUnchanged(cir.length+3);
      }
      
      int nshift = pos+1;
      int from = start;
      int to = from-1;
      if(to <0){
        to = cir.length-1;
      }
      
      for(int i = 0; i<nshift; i++){
        cir[to] = cir[from];
        to = (to+1)%cir.length;
        from = (from+1)%cir.length;
      }
      
      int index = (start+pos)%cir.length;
      cir[index]=elem;
      size++;
      
      start = start-1; //Important for students to understand;
      if(start <0){
        start = cir.length-1;
      }
    }
  }
  
  /* parameter--> pos. pos --> position relative to start.
   * Valid range of pos--> 0 to size-1
   */
  public void removeByLeftShift(int pos){
    int nshift = size-pos-1;
    int to = (start + pos)%cir.length;
    int from = (to+1)%cir.length;
    
    for(int i = 0; i<nshift; i++){
      cir[to] = cir[from];
      to = (to+1)%cir.length;
      from = (from+1)%cir.length;
    }
    
    cir[(start+size-1)%cir.length]=null;
    size--;
    
  }
  
  /* parameter--> pos. pos --> position relative to start.
   * Valid range of pos--> 0 to size-1
   */
  public void removeByRightShift(int pos){
    int nshift = pos;
    int to = (start + pos)%cir.length;
    int from = to-1;
    if(from <0){
      from = cir.length-1;
    }
    
    for(int i = 0; i<nshift; i++){
      cir[to] = cir[from];
      to = from;
      from--;
        if(from <0){
          from = cir.length-1;
        }
    }
    
    cir[start]=null;
    start=(start+1)%cir.length;
    size--;
    
  }
  
}
