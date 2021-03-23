import java.util.ArrayList;

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
            System.out.println(((StringDataType)current.getKey()).get()); // Casted specifically for Strings
        recursiveInOrder(current.getRight());
    }

    public void preOrderTraversal(BinaryTreeNode root){
        if(root == null)
            return;
        else
            recursivePreOrder(root);
    }

    private void recursivePreOrder(BinaryTreeNode current){
        if(current == null)
            return;
        for(int i = 0; i < current.getCount() + 1; i++)
            System.out.print(current.getKey() + " ");
        recursivePreOrder(current.getLeft());
        recursivePreOrder(current.getRight());
    }

    public void postOrderTraversal(BinaryTreeNode root){
        if(root == null)
            return;
        else
            recursivePostOrder(root);
    }

    private void recursivePostOrder(BinaryTreeNode current){
        if(current == null)
            return;
        recursivePostOrder(current.getLeft());
        recursivePostOrder(current.getRight());
        for(int i = 0; i < current.getCount() + 1; i++)
            System.out.print(current.getKey() + " ");
    }

    public void delete(GenericItemType key){
        if(root == null)
            return;
        else
            root = recursiveDelete(key, root);
    }

    public BinaryTreeNode recursiveDelete(GenericItemType key, BinaryTreeNode current){
        if(current == null)
            return null;
        else if(key.isLess(current.getKey()))
            current.setLeft(recursiveDelete(key, current.getLeft()));
        else if(key.isGreater(current.getKey()))
            current.setRight(recursiveDelete(key, current.getRight()));
        else{
            if(current.getLeft() == null && current.getRight() == null)
                current = null;
            else if(current.getLeft() == null)
                current = current.getRight();
            else if(current.getRight() == null)
                current = current.getLeft();
            else{
                current.setKey(findMin(current.getRight()).getKey());
                current.setRight(recursiveDelete(findMin(current.getRight()).getKey(), current.getRight()));
            }
        }
        return current;
    }

}
