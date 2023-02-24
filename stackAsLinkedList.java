package stack_main;
class testStack {
    public static void main(String[] args) {
     
       //object of stack class
        stackAsLinkedList s1=new stackAsLinkedList();

        System.out.println(s1.pop());

        // int[] array1={11,12,13,14,15};
        // for(int i : array1){
        //     s1.push(i);
        // }
        // System.out.println("Element at peek is : "+s1.peek());
        // System.out.println("Element deleted is : "+s1.pop());
        // System.out.println("Element of stacks are : ");
        // s1.display();
        // System.out.print("Does 12 exits in stack ? ");
        // System.out.print(s1.search(12));


    }
}
public class stackAsLinkedList{
    //node class 
    static class stackNdoe{
        //properties of node class
        int data;
        stackNdoe nextNode;
        //constructor of node class 
        stackNdoe(int data){
            this.data=data;
            nextNode=null;
        }
    }
    //properties of stack 
    int size;
    stackNdoe peek; //head
    //constructor of stack class
    stackAsLinkedList(){
        peek=null;
        size=0;
    }
    //isEmpty method
    boolean isEmpty(){
        return (peek==null);
    }
    //push method -> it is like insert at first method 
    void push(int data){
        //create new node
        stackNdoe newNode=new stackNdoe(data);
        if(isEmpty()){
           peek=newNode; 
        }
        else{
            newNode.nextNode=peek;
            peek=newNode;
        }
        size++;
    }
    //pop method -> it is like delete at first method
    int pop(){
        if(isEmpty()){
            System.out.println("Underflow: stack is empty");
            return -1;
        }
        else{
            stackNdoe tempNode=peek;
            peek=tempNode.nextNode;
            tempNode.nextNode=null;
            stackNdoe deletedNode=tempNode;
            size--;
            return deletedNode.data;
            // System.out.println(head.data+" is deleted.");       
        }
    }
    //peek method
    int peek(){
        return peek.data;
    }
    //search method
    boolean search(int data){
        stackNdoe tempNode=peek;
        //search node if it exists return it 
        if(isEmpty()){
            System.out.println("Underflow: stack is empty");
            return false;
        }
        else{
            while(tempNode!=null){
                if(tempNode.data==data)
                    return true;
                else
                    tempNode=tempNode.nextNode;
            }
            return false;
        }
    }
    //display method
   public void display(){
    stackNdoe tempNode=peek;
    //for(i=1; to size)
    //while(tempNode!=null)
    while(tempNode!=null){
        System.out.println(tempNode.data);
        tempNode=tempNode.nextNode;
    }
}


    
}
