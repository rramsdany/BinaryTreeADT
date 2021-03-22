public class AppDriver {
    public static void main(String[] args) {
        BinaryTree newTree = new BinaryTree();
        newTree.insert(new IntegerDataType(3));
        newTree.insert(new IntegerDataType(4));
        newTree.insert(new IntegerDataType(50));
        newTree.insert(new IntegerDataType(60));
        newTree.insert(new IntegerDataType(23));
        newTree.insert(new IntegerDataType(43));
        newTree.insert(new IntegerDataType(15));
        newTree.insert(new IntegerDataType(50));
        newTree.insert(new IntegerDataType(15));
        newTree.insert(new IntegerDataType(50));

        System.out.print("In Order: ");
        newTree.inOrderTraversal(newTree.getRoot());
        System.out.print("\nPost Order: ");
        newTree.postOrderTraversal(newTree.getRoot());
        System.out.print("\nPre Order: ");
        newTree.preOrderTraversal(newTree.getRoot());
        System.out.println();

        // Delete some items.
        newTree.delete(new IntegerDataType(23));
        newTree.delete(new IntegerDataType(50));

        System.out.print("\n\nIn Order: ");
        newTree.inOrderTraversal(newTree.getRoot());






    }
}
