public class BinaryTreeNode {
    private GenericItemType key;
    private int count;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(){}
    public BinaryTreeNode(GenericItemType key){
        this.key = key;
    }
    public BinaryTreeNode(BinaryTreeNode btn){
        key = btn.key;
        count = btn.count;
        left = btn.left;
        right = btn.right;
    }

    public void setKey(GenericItemType key){
        this.key = key;
    }

    public void setLeft(BinaryTreeNode left){
        this.left = left;
    }

    public void setRight(BinaryTreeNode right){
        this.right = right;
    }

    public void setCount(int count){
        this.count = count;
    }

    public BinaryTreeNode getRight(){
        return right;
    }

    public BinaryTreeNode getLeft(){
        return left;
    }

    public int getCount(){
        return count;
    }

    public GenericItemType getKey(){
        return key;
    }
}

