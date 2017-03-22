import sun.reflect.generics.tree.Tree;

/**
 * Created by ASUS on 27.09.2016.
 */
public class TreeNode<T extends Comparable> {
    public TreeNode parent,lChild,rChid;
    public T inf;
    public int count;
    int heigh;
    public void incCount()
    {
        count++;
    }

    public int getCount(){return count;}
    public TreeNode(T inf)
    {
        heigh = 0;
        this.inf = inf;
        this.lChild = null;
        this.rChid = null;
        count = 1;

    }
    public TreeNode()
    {
    }


}
