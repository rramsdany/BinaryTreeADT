public class BinaryTree {
    private BinaryTreeNode root;

    public BinaryTree(){}
    public BinaryTree(BinaryTreeNode root){
        this.root = root;
    }
    public BinaryTree(BinaryTree bt){
        root = bt.getRoot();
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public BinaryTreeNode findMin(BinaryTreeNode current){
        if(current == null)
            return null;
        else if(current.getLeft() == null)
            return current;
        else
            return findMin(current.getLeft());
    }

    public BinaryTreeNode findMax(BinaryTreeNode current){
        if(current == null)
            return null;
        else if(current.getRight() == null)
            return current;
        else
            return findMin(current.getRight());
    }

    public void insert(GenericItemType key){
        if(root == null)
            root = new BinaryTreeNode(key);
        else
            root = recursiveInsert(key, root);
    }

    private BinaryTreeNode recursiveInsert(GenericItemType key, BinaryTreeNode current){
        if(current == null){
            current = new BinaryTreeNode(key);
            return current;
        }

        if(key.isEqual(current.getKey())){
            current.setCount(current.getCount() + 1);
            return current;
        }

        if(key.isLess(current.getKey()))
            current.setLeft(recursiveInsert(key, current.getLeft()));
        else if (key.isGreater(current.getKey()))
            current.setRight(recursiveInsert(key, current.getRight()));

        return current;
    }

    public BinaryTreeNode search(GenericItemType key){
        return recursiveSearch(key, root);
    }

    private BinaryTreeNode recursiveSearch(GenericItemType key, BinaryTreeNode current){
        if(current == null)
            return null;
        if(current.getKey().isEqual(key))
            return current;
        if(current.getKey().isLess(key))
            return recursiveSearch(key, current.getLeft());
        if(current.getKey().isGreater(key))
            return recursiveSearch(key, current.getRight());

        return null;
    }

    public boolean contains(GenericItemType key){
        if(root == null)
            return false;
        else
            return recursiveContains(key, root);
    }

    private boolean recursiveContains(GenericItemType key, BinaryTreeNode current){
        if(current == null)
            return false;
        if(current.getKey().isEqual(key))
            return true;
        if(current.getKey().isLess(key))
            return recursiveContains(key, current.getLeft());
        if(current.getKey().isGreater(key))
            return recursiveContains(key, current.getRight());

        return false;
    }

    public void inOrderTraversal(BinaryTreeNode root){
        if(root == null)
            return;
        else
            recursiveInOrder(root);
    }

    private void recursiveInOrder(BinaryTreeNode current){
        if(current == null)
            return;
        recursiveInOrder(current.getLeft());
        for(int i = 0; i < current.getCount() + 1; i++)
            System.out.print(current.getKey() + " ");
        recursiveInOrder(current.getRight());


    }

}
