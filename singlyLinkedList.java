package singlyLinkedList;

public class testSinglyLinkedList {
    public static void main(String[] args) {
      //linked list
      linkedList<String> Students=new linkedList<>();
      String[] studentsList={"StudentA","StudentB","StudentC","StudentD","StudentE"};
      for(String i : studentsList){
        Students.insertAtLast(i);
      }
      //Let's us display the list of students 
      System.out.println("21SW students list");
      Students.display();
      Students.deleteByValue("StudentC");
      System.out.println("After deleting element StudentC");
      Students.display();
      Students.deleteFirstNode();
      System.out.println("Students list after deleting first node : ");
      Students.display();
      Students.deleteLastNode();
      System.out.println("Students list after deleting last node");
      Students.display();
      Students.deteleAtAnyPos(2);
      System.out.println("Students list after deleting element at pos : 2");
      Students.display();

    }
}
//singly linked list class
class singlyLinkedList<T>{ 
   //Nested node class; it is a static class
   static class Node<L>{
    //proeprties
    L data;
    Node<L> nextNode;
    Node(L data){
        this.data=data;
        nextNode=null;
    }
   }
   //linked list class properties/Data members
   int size;
   Node<T> head, tail;
   //constructor; initialized the default values
   linkedList(){
    size=0;
    head=null;
    tail=null;
   }
   public Node<T> getTail() {
        Node<T> tempNode=head;
        while(tempNode.nextNode!=null){
            tempNode=tempNode.nextNode;
        }
        tail=tempNode;
        return tail;
    }
    //isEmpty method
    public boolean isEmpty(){
        if(size==0)
            return true;
        else
            return false;
    }
    // Size method
    public int sizeOfLinkedList(){
        return size;
    }
    
   //insertion at first 
   public void insertAtFirst(T data){
    //create new node
    Node<T> newNode=new Node<T>(data);
    if(isEmpty()){
        head=newNode;
        tail=newNode;
    }
    else{
        newNode.nextNode=head;
        head=newNode;
        tail=getTail();
    }
    size++;

   }
    // insertAtLast method
    public void insertAtLast(T data){
        Node<T> newNode=new Node<T>(data);//create a new node to be inserted at last
        //if linked list is empty than call insert at first method
        if(isEmpty()){
            insertAtFirst(data);
        }
        else{
            getTail().nextNode=newNode;
            size++;
            // System.out.println(data+" is inserted.");
        }  
    }
    // insert at any position
    public void insertAtAnyPos(T data, int pos){
        if(pos==1 || isEmpty()){
            insertAtFirst(data);
        }
        else if(pos>=size+1 ){
            insertAtLast(data);
        }
        else if(pos>1 && pos<=size){
            Node<T> newNode, pointerNode=head;
            newNode=new Node<T>(data);//create a new node
            for(int i=1; i<pos-1; i++){
                pointerNode=pointerNode.nextNode;
            }
            newNode.nextNode=pointerNode.nextNode;
            pointerNode.nextNode=newNode;
            size++;
            // System.out.println(data+" is inserted.");
        }
    }
    //delete first node
    public void deleteFirstNode(){
        if(isEmpty()){
            System.out.println("Linked list is empty");
        }
        else{
            Node<T> tempNode=head;
            head=tempNode.nextNode;
            tempNode.nextNode=null;
            tail=getTail();
            size--;
            // System.out.println(head.data+" is deleted.");       
        }
    }
   //delete last node
    public void deleteLastNode(){
        if(isEmpty()){
            System.out.println("Underflow condition : Linked list is empty");
        }
        else{
            Node<T> tempNode=head;
            for(int i=1; i<size-1; i++){
                tempNode=tempNode.nextNode;
            }
            tempNode.nextNode=null;
            tail=tempNode;
            size--;
        }
    }
    //delete node at any position
    public void deteleAtAnyPos(int pos){
        if(pos==1){
            deleteFirstNode();
        }
        else if(pos>=size){
            deleteLastNode();
        }
        else if(pos>1 && pos<size){
            Node<T> tempNode=head;
            for(int i=1; i<pos-1; i++){
                tempNode=tempNode.nextNode;
            }
            // System.out.println(tempNode.nextNode.data+" is deleted.");
            tempNode.nextNode=tempNode.nextNode.nextNode;
            size--;
        }
    }
    //Delete by a given value
    public void deleteByValue(T data){
        int nodeNum=searchValue(data);
        if(nodeNum!=0){
            deteleAtAnyPos(nodeNum);
        }
    }
    //Search method 
    public int searchValue(T data){
            Node<T> tempNode=head;
            int nodeNum=0;
            //search node if it exists return it 
            if(isEmpty()){
                System.out.println("Linked list is empty");
                return nodeNum;
            }        
            else{
                while(tempNode!=null){
                    nodeNum++;
                    if(tempNode.data==data){
                        break;
                    }
                    else{
                        tempNode=tempNode.nextNode;
                    }
                }
               return nodeNum; 
            }
           
        }
    //Search method 
    Node<T> search(T data){
        Node<T> tempNode=head;
        //search node if it exists return it 
        if(isEmpty())
            System.out.println("Linked list is empty");
        else{
            
        }

        return tempNode;
    }

//display
   public void display(){
        Node<T> tempNode=head;
        //for(i=1; to size)
        //while(tempNode!=null)
        while(tempNode!=null){
            System.out.println(tempNode.data);
            tempNode=tempNode.nextNode;
        }
}
}

