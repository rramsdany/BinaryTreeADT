import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AppDriver {
    public static void main(String[] args) {
        BinaryTree newTree = new BinaryTree();
        insert(newTree);

        // Insert the dictionary into the BST
            // Read through each line in the txt file
            // Insert each line into the BST


        // Print the BST in ascending and descending order

        newTree.inOrderTraversal(newTree.getRoot());
        // Delete the following words from the BST

        // Reprint the BST in ascending and descending order


    }

    public static void insert(BinaryTree tree){
        try{
            File myObj = new File("dictionary.txt");
            Scanner myReader = new Scanner(myObj);
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                tree.insert(new StringDataType(data));
            }myReader.close();


        } catch(FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }
}
