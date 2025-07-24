//
import  java.util.*;
public class main {
    // Main method to run the program
    public static void main(String[] args) {
        
    System.out.println("Hello, in this program we will let you  bulit  Binary Search Tree. We will give you options to pick so please enter numbers that associate with the option and not type in the words. ");
        System.out.println("Here is an example: Who walked across the road?  1.Dog 2.Cat 3.Chicken.");
        System.out.println("You would enter 3 and not the word chicken, then press enter.");
        System.out.println("Let's get started!");
        menu(); // Call the menu function to start the program
  }
  
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




}

