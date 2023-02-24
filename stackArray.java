class testStack{
    public static void main(String[] args) {
        //class object
        stackArray s1=new stackArray(5);
        s1.push(11);
        s1.push(12); //11 , 12
        System.out.println(s1.peek());
        System.out.println("Stack elements are : ");
        s1.display();
        System.out.println(s1.pop());
        System.out.println("Stack elements are : ");
        s1.display();
        System.out.println(s1.search(110));
        
    }
}
public class stackArray {
    //create an array 
    int[] arrayStack;
    int size; //stack size
    int peek; //it store -> index number of last element(recent)
    //constrcutor
    stackArray(int size){
        this.size=size;
        arrayStack=new int[size];
        peek=-1;
    }
    //isEmpty
    boolean isEmpty(){
        return (peek<0);
    }
    //isFull
    boolean isFull(){
        return (size-1==peek);
    }
    //push method
    public void push(int data){
        if(isFull()){
            System.out.println("Overfull: stack is full");
        }
        else{
            arrayStack[++peek]=data;
        }
    }
    //peek method 
    public int peek(){
        return arrayStack[peek];
    }
    //display
    public void display(){
        if(isEmpty()){
            System.out.println("Stack is empty");
        }
        else{
            for(int i=0; i<=peek; i++){
                System.out.println(arrayStack[i]);
            }
        }
    }
    //pop method
    public int pop(){
        int result = arrayStack[peek];
        peek--;
        return result;
    }    
    //search method -> linear search
    public boolean search(int key){
        if(isEmpty()){
            System.out.println("stack is empty");
            return false;
        }
        else{
            for(int i = 0 ; i <= peek ; i++){
                if(arrayStack[i] == key){
                    return true;
                }
            }
            return false;
        }
    }


}
