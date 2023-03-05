public class testBSTree{
    public static void main(String[] args) {
        BST obj=new BST();
        //array
        int[] listOfNum={12,3,6,8,10,13,15};
        for(int i : listOfNum){
            obj.insert(i);
        }
        System.out.println("\nInorder traversing");
        obj.inOrderTraverse(obj.root);
        System.out.println("\nPreorder traversing");
        obj.preOrderTraverse(obj.root);
        System.out.println("\nPostorder traversing");
        obj.postOrderTraverse(obj.root);
    }
}



class BST {
     //node class
    static class Node{
    //properties of node class 
    int data;
    Node leftNode, rightNode;
    //constructor
    Node(int data){
        this.data=data;
        leftNode=rightNode=null;
    }
}
    //binary search tree properties
    int size;
    Node root;
    //constructor
    BST(){
        size=0;
        root=null;
    }
    //operations of BST
    //1- getSize
    public int getSize(){
        return size;
    }
    //2- isEmpty
    public boolean isEmpty(){
        return (size==0 || root==null);
    }
    //insert
    public void insert(int data){
        addNode(root,data);
    }
    //3- insert -> another way to implement insertion 
    public void addNode(Node node, int data){
        Node newNode=new Node(data);
        if(isEmpty()){
            root=newNode;
        }
        else{
            if((int)data<(int)node.data){
                if(node.leftNode!=null){
                    addNode(node.leftNode, data);
                }
                else{
                    node.leftNode=new Node(data);
                }
            }
            else{
                if(node.rightNode!=null){
                    addNode(node.rightNode, data);
                }
                else{
                    node.rightNode=newNode;
                }
            }
        }
        size++;
    }
    //inorder traverse 
    public void inOrderTraverse(Node node){
        if(node==null)
            return;
        else{
            inOrderTraverse(node.leftNode);
            System.out.print(" "+node.data);
            inOrderTraverse(node.rightNode);
        }
    }
    //preorder traverse 
    public void preOrderTraverse(Node node){
        if(node==null)
            return;
        else{
            System.out.print(" "+node.data);
            preOrderTraverse(node.leftNode);
            preOrderTraverse(node.rightNode);
        }
    }
    //postorder traverse 
    public void postOrderTraverse(Node node){
        if(node==null)
            return;
        else{
            postOrderTraverse(node.leftNode);
            postOrderTraverse(node.rightNode);
            System.out.print(" "+node.data);
        }
    }
}
