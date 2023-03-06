// AVL tree implementation in Java
  
  // Tree class
class AVL{
  
// Create node
static class Node {
  int data, height;
  Node leftNode, rightNode;

  Node(int d) {
    data = d;
    height = 1;
  }
}
    Node root;
    int height(Node N) {
      if (N == null)
        return 0;
      return N.height;
    }
  //case#01 Left heavy situation or Left left situation
    Node rightRotate(Node parent) {
      Node L = parent.leftNode;
      Node LR = L.rightNode;
      L.rightNode = parent;
      parent.leftNode = LR;
      parent.height = Math.max(height(parent.leftNode), height(parent.rightNode)) + 1;
      L.height = Math.max(height(L.leftNode), height(L.rightNode)) + 1;
      return L;
    }
  //case#02 Right heavy situation or right right situation
    Node leftRotate(Node parent) {
      Node R = parent.rightNode;
      Node RL = R.leftNode;
      R.leftNode = parent;
      parent.rightNode = RL;
      parent.height = Math.max(height(parent.leftNode), height(parent.rightNode)) + 1;
      R.height = Math.max(height(R.leftNode), height(R.rightNode)) + 1;
      return R;
    }
  
    // Get balance factor of a node
    int getBalanceFactor(Node N) {
      if (N == null)
        return 0;
      return height(N.leftNode) - height(N.rightNode);
    }
  
    // Insert a node
    Node insertNode(Node node, int data) {
      // Find the position and insert the node
      if (node == null)
        return (new Node(data));
      if (data < node.data)
        node.leftNode = insertNode(node.leftNode, data);
      else if (data > node.data)
        node.rightNode = insertNode(node.rightNode, data);
      else
        return node;
  
      // Update the balance factor of each node
      // And, balance the tree
      node.height = 1 + Math.max(height(node.leftNode), height(node.rightNode));
      int balanceFactor = getBalanceFactor(node);
      if (balanceFactor > 1) {
       //Left heavy situation
        if (data < node.leftNode.data) {
          return rightRotate(node);
        } 
        //LR situation
        else if (data > node.leftNode.data) {
          node.leftNode = leftRotate(node.leftNode);
          return rightRotate(node);
        }
      }
      if (balanceFactor < -1) {
        //right heavy situation
        if (data > node.rightNode.data) {
          return leftRotate(node);
        }
        //RL rotation
        else if (data < node.rightNode.data) {
          node.rightNode = rightRotate(node.rightNode);
          return leftRotate(node);
        }
      }
      return node;
    }
  
    // Node nodeWithMimumValue(Node node) {
    //   Node current = node;
    //   while (current.leftNode != null)
    //     current = current.leftNode;
    //   return current;
    // }
  
    // // Delete a node
    // Node deleteNode(Node root, int data) {
  
    //   // Find the node to be deleted and remove it
    //   if (root == null)
    //     return root;
    //   if (data < root.data)
    //     root.leftNode = deleteNode(root.leftNode, data);
    //   else if (data > root.data)
    //     root.rightNode = deleteNode(root.rightNode, data);
    //   else {
    //     if ((root.leftNode == null) || (root.rightNode == null)) {
    //       Node temp = null;
    //       if (temp == root.leftNode)
    //         temp = root.rightNode;
    //       else
    //         temp = root.leftNode;
    //       if (temp == null) {
    //         temp = root;
    //         root = null;
    //       } else
    //         root = temp;
    //     } else {
    //       Node temp = nodeWithMimumValue(root.rightNode);
    //       root.data = temp.data;
    //       root.rightNode = deleteNode(root.rightNode, temp.data);
    //     }
    //   }
    //   if (root == null)
    //     return root;
  
    //   // Update the balance factor of each node and balance the tree
    //   root.height = Math.max(height(root.leftNode), height(root.rightNode)) + 1;
    //   int balanceFactor = getBalanceFactor(root);
    //   if (balanceFactor > 1) {
    //     if (getBalanceFactor(root.leftNode) >= 0) {
    //       return rightRotate(root);
    //     } else {
    //       root.leftNode = leftRotate(root.leftNode);
    //       return rightRotate(root);
    //     }
    //   }
    //   if (balanceFactor < -1) {
    //     if (getBalanceFactor(root.rightNode) <= 0) {
    //       return leftRotate(root);
    //     } else {
    //       root.rightNode = rightRotate(root.rightNode);
    //       return leftRotate(root);
    //     }
    //   }
    //   return root;
    // }
  //traversing
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
  public void display(){
    System.out.println("\nInorder");
    inOrderTraverse(root);
    System.out.println("\nPreoder");
    preOrderTraverse(root);
    System.out.println("\nPostorder");
    postOrderTraverse(root);
  }
  // Print the tree
  // public void printTree(Node currPtr, String indent, boolean last) {
  //   if (currPtr != null) {
  //     System.out.print(indent);
  //     if (last) {
  //       System.out.print("R----");
  //       indent += "   ";
  //     } else {
  //       System.out.print("L----");
  //       indent += "|  ";
  //     }
  //     System.out.println(currPtr.data);
  //     printTree(currPtr.leftNode, indent, false);
  //     printTree(currPtr.rightNode, indent, true);
  //   }
  // }
  
  }
  public class testAVLTree{
    // Driver code
    public static void main(String[] args) {
      AVL tree = new AVL();
      int[] listNum={33,13,53,9,21,61,8,11};
      for(int i : listNum){
        tree.root = tree.insertNode(tree.root,i);
      }
      // tree.printTree(tree.root, "", true);
      tree.display();
    }
  }