//
import  java.util.*;
public class Main {
    //  defining a Node for a binary tree
  static class Node{
    int data;
    Node left;
    Node right;
     Node(int data){
      this.data = data;
    }     

   }
  static class BinarySearchTree {
    Node root;

    // Constructor to initialize the root of the tree
    // Recurstion Functionns is use to make recursion easier 
    
    // adding node to the tree
    private Node addRecursion(Node root, Node node) {
        int data = node.data;
        if ( root == null) {
            // If the tree is empty, return a new node
            return node;
        }
        else if (data < root.data) {
            root.left = addRecursion(root.left, node);
        } else  {
            root.right = addRecursion(root.right, node);
        }
        return root;
    }
    // method to  call to run
    public void addNode(Node node){
        root = addRecursion(root, node);
    }
    
    // searching for a node in the tree
    private boolean searchRecursion(Node root, int data) {
        if (root == null) {
            return false; // Node not found or tree is empty
        }
         else if (root.data == data) {
            return true; // Node found
        }
        // if the data is less than the root data
        else if(root.data > data) {
            return searchRecursion(root.left, data); // Search in the left subtree
        } 
        // if the data is greater than the root data
        else {
            return searchRecursion(root.right, data); // Search in the right subtree
        }


    }
    // method to call to  run
    public boolean searchNode(int data) {
        return searchRecursion(root, data);
    }

  //  balence rule with delection
   private int smallestRight(Node root) {
        // Find the smallest value in the right subtree
        root = root.right;
        
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }
   private int largestLeft(Node root) {
        // Find the largest value in the left subtree
        root = root.left;
        
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }

 // deleting a node from the tree
    private Node deleteRecursion(Node root, int data) {
         if(root == null) {
      return root;
    }
      // if the data is less than the root data
    else if(data < root.data) {
      root.left = deleteRecursion(root.left, data);
    }
      // if the data is greater than the root data
    else if(data > root.data) {
      root.right = deleteRecursion(root.right, data);
    }
      // node found
    else { 
      //Case 1: no children
      if(root.left == null && root.right == null) {
        root = null;
      }
        //Case 2: only right child
      else if(root.right != null) { 
        //find a successor(Smallest in Right) to replace this node
        root.data = smallestRight(root);
        root.right = deleteRecursion(root.right, root.data);
      }
        //Case 2: only left child
      else { 
        //find a predecessor(Largest in Left) to replace this node
        root.data = largestLeft(root);
        root.left = deleteRecursion(root.left, root.data);
      }
    }
    return root;
    }
    public void deleteNode(int data) {
        //if  we find the data we want to remove
    if(searchNode(data)) {
      deleteRecursion(root, data);
    }
      // if we do not find the data we want to remove
    else {
      System.out.println(data + " could not be found");
    }
    }
   // Traversal methods for printing nodes in different orders
// InOrder: Left, Root, Right

 private void inOrderRecursion(Node root) {
        if (root != null) {
            // need to go left first
            inOrderRecursion(root.left);
            // then print the root
            System.out.print(root.data + " ");
            // then go right
            inOrderRecursion(root.right);
        }
    }
 public void printInOrder() {
        System.out.print("InOrder: ");
        inOrderRecursion(root);
        System.out.println();
    }
// PreOrder: Root, Left, Right (not  correct)
 private void preOrderRecursion(Node root) {
        if (root != null) {
            // print the root first
            System.out.print(root.data + " ");
            // then go left
            preOrderRecursion(root.left);
            // then go right
            preOrderRecursion(root.right);
        }
    }
 public void printPreOrder() {
        System.out.print("PreOrder: ");
        preOrderRecursion(root);
        System.out.println();
    }
// PostOrder: Left, Right, Root (not correct)
 private void postOrderRecursion(Node root) {
            if (root != null) {
                // go left first
                postOrderRecursion(root.left);
                // then go right
                postOrderRecursion(root.right);
                // then print the root
                System.out.print(root.data + " ");
            }
        }
 public void printPostOrder() {
        System.out.print("PostOrder: ");
        postOrderRecursion(root);
        System.out.println();
    }

}
   // Holder for the BinarySearchTree

    static BinarySearchTree tree = null; // Declare as static for global access
    static boolean madeTree = false;     // Declare as static for global access
    // Scanner for user input
    static Scanner scanner = new Scanner(System.in); // Declare Scanner as static for global access
  
  //menu  function 
  public static void menu() {

     int choice;
    String[] options = {"Create a binary search tree", "Add a node", "Delete a node", "Print nodes by InOrder", "Print nodes by PreOrder", "Print nodes by PostOrder", "Exit program"};
    // Display the menu options
       System.out.println("Binary Search Tree Menu:");  
    for (int i = 0; i < options.length; i++) {
        System.out.println((i + 1) + ". " + options[i]);
    }
    System.out.print("Please enter your choice (1-" + options.length + "): ");
    choice = scanner.nextInt();
    switch (choice) {
        case 1:
            createBinarySearchTree();
            break;
        case 2:
            System.out.print("Enter the value to add: ");
            int addValue = scanner.nextInt();
            addNode(addValue);
            break;
        case 3:
            System.out.print("Enter the value to delete: ");
            int deleteValue = scanner.nextInt();
            deleteNode(deleteValue);
            break;
        case 4:
            printInOrder();
            break;
        case 5:
            printPreOrder();
            break;
        case 6:
            printPostOrder();
            break;
        case 7:
            System.out.println("Exiting program.");
            scanner.close(); // Close the scanner to prevent resource leaks
            System.exit(0);
        default:
            System.out.println("Invalid choice. Please try again.");
    }
  
}  
    
    //Create a binary search tree function 
    public static void createBinarySearchTree() {
        // Implementation for creating a binary search tree
        
        
        for (int i = 1; i < 11; i++) {
            // Adding some nodes to the tree with given data
            tree.addNode(new Node(i));
        }
        madeTree = true; // Set the flag to true indicating the tree is created
        System.out.println("Binary Search Tree created successfully.");
        menu(); // Call the menu function to continue operations
    }

    //Add a node function
    public static void addNode(int data) {
        // Implementation for adding a node to the binary search tree
        if(!madeTree) {
          System.out.println("Please create a binary search tree first.");
           
        }
        else {
            tree.addNode(new Node(data)); // Add the node with the given data
            System.out.println("Node with value " + data + " added successfully.");
        }

         menu(); // Call the menu function to continue operations
    }
    
    //Delete a node function
    public static void deleteNode(int data) {
        // Implementation for deleting a node from the binary search tree
        if(!madeTree) {
            System.out.println("Please create a binary search tree first.");
            
        }
        else {
            tree.deleteNode(data); // Delete the node with the given data
            System.out.println("Node with value " + data + " deleted successfully.");
             
        }
      menu(); // Call the menu function to continue operations
       
    }

    //Print nodes by InOrder function
    public static void printInOrder() {
        // Implementation for printing nodes in InOrder traversal
        if(!madeTree) {
            System.out.println("Please create a binary search tree first.");
        }
            
        else if (tree.root == null) {
            System.out.println("The tree is empty.");
        }
        else{
        tree.printInOrder(); // Call the method to print nodes in InOrder
        }
         menu(); // Call the menu function to continue operations
    }
    
    //Print nodes by PreOrder function
    public static void printPreOrder() {
        // Implementation for printing nodes in PreOrder traversal
        if(!madeTree) {
            System.out.println("Please create a binary search tree first. ");
            
        }
        else if (tree.root == null) {
            System.out.println("The tree is empty.");}
        else{
            tree.printPreOrder(); // Call the method to print nodes in PreOrder
        }

         menu(); // Call the menu function to continue operations
    }

    //Print nodes by PostOrder function
    public static void printPostOrder() {
        // Implementation for printing nodes in PostOrder traversal
        if(!madeTree) {
            System.out.println("Please create a binary search tree first.");
            
        }
        else if (tree.root == null) {
            System.out.println("The tree is empty.");} 
        else{
            tree.printPostOrder(); // Call the method to print nodes in PostOrder
        }

         menu(); // Call the menu function to continue operations
    }
 // Main method to run the program
public static void main(String[] args) {
    //introduction to the program
    System.out.println("Welcome to the Binary Search Tree Program!");   
    System.out.println("In this program we will let you  bulit  Binary Search Tree and be able to edit them . We will give you options to pick so please enter numbers that associate with the option and not type in the words. ");
    System.out.println("Here is an example: Who walked across the road?  1.Dog 2.Cat 3.Chicken.");
    System.out.println("You would enter 3 and not the word chicken, then press enter.");
    System.out.println(" press enter to continue");
    String enter = scanner.nextLine(); // Wait for user to press enter

    tree = new BinarySearchTree(); // Initialize the tree before use
    menu(); // Call the menu function to start the program
}

}


