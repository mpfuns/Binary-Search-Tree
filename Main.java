//
import  java.util.*;
public class Main {
    //  defining a Node for a binary tree
    class Node{
    int data;
    Node left;
    Node right;
     Node(int data){
      this.data = data;
    }     
}
  
 class BinarySearchTree {
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
}

// Traversal methods for printing nodes in different orders

private void inOrderRecursion(Node root) {
        if (root != null) {
            inOrderRecursion(root.left);
            System.out.print(root.data + " ");
            inOrderRecursion(root.right);
        }
    }
    





    
    
    // Main method to run the program
    
  //menu  function 
  public static void menu() {
     Scanner scanner = new Scanner(System.in);
     int choice;
    String[] options = {"Create a binary search tree", "Add a node", "Delete a node", "Print nodes by InOrder", "Print nodes by PreOrder", "Print nodes by PostOrder", "Exit program"};
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
            System.exit(0);
        default:
            System.out.println("Invalid choice. Please try again.");
    }
  
}  
    
    //Create a binary search tree function 
    public static void createBinarySearchTree() {
        // Implementation for creating a binary search tree
        System.out.println("Binary Search Tree created successfully.");
        menu(); // Call the menu function to continue operations
    }

    //Add a node function
    public static void addNode(int data) {
        // Implementation for adding a node to the binary search tree

         menu(); // Call the menu function to continue operations
    }
    
    //Delete a node function
    public static void deleteNode(int data) {
        // Implementation for deleting a node from the binary search tree

         menu(); // Call the menu function to continue operations
    }

    //Print nodes by InOrder function
    public static void printInOrder() {
        // Implementation for printing nodes in InOrder traversal

         menu(); // Call the menu function to continue operations
    }
    
    //Print nodes by PreOrder function
    public static void printPreOrder() {
        // Implementation for printing nodes in PreOrder traversal

         menu(); // Call the menu function to continue operations
    }

    //Print nodes by PostOrder function
    public static void printPostOrder() {
        // Implementation for printing nodes in PostOrder traversal

         menu(); // Call the menu function to continue operations
    }

public static void main(String[] args) {
    //introduction to the program
        System.out.println("Welcome to the Binary Search Tree Program!");   
    System.out.println("Hello, in this program we will let you  bulit  Binary Search Tree and be able to edit them . We will give you options to pick so please enter numbers that associate with the option and not type in the words. ");
        System.out.println("Here is an example: Who walked across the road?  1.Dog 2.Cat 3.Chicken.");
        System.out.println("You would enter 3 and not the word chicken, then press enter.");
        System.out.println("Let's get started!");
        menu(); // Call the menu function to start the program
  }
  


}


