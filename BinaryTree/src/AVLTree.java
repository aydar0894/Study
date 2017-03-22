import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;

/**
 * Created by ASUS on 27.09.2016.
 */
public class AVLTree<T extends Comparable> {

    int count = 0;
    int count1 = 0;

    TreeNode<T> root = null;

    public AVLTree() {

    }


    public String traverse() {
        String result = "";
        TreeNode<T> temp = root;
        while (temp.lChild != null) temp = temp.lChild;
        result += temp.inf + ":" + temp.getCount();
        while (successor(temp) != null) {
            temp = successor(temp);
            result += " " + temp.inf + ":" + temp.getCount();
        }
        return result;
    }

    private TreeNode median(TreeNode x, TreeNode y, TreeNode z) {
        TreeNode result = x;
        if (x.inf.compareTo(y.inf) < 0 && x.inf.compareTo(z.inf) > 0) result = x;
        else if (y.inf.compareTo(x.inf) <= 0 && y.inf.compareTo(z.inf) >= 0) result = y;
        else if (z.inf.compareTo(y.inf) <= 0 && z.inf.compareTo(x.inf) >= 0) result = z;
        else if (x.inf.compareTo(z.inf) <= 0 && x.inf.compareTo(y.inf) >= 0) result = x;
        else if (y.inf.compareTo(z.inf) <= 0 && y.inf.compareTo(x.inf) >= 0) result = y;
        else if (z.inf.compareTo(x.inf) <= 0 && z.inf.compareTo(y.inf) >= 0) result = z;
        return result;
    }

    private void restructure(TreeNode node) {
        TreeNode median = null, noMedian = null;
        TreeNode x = null, y, z;
        TreeNode temp;
        int lH = 0, rH = 0;
        while (node != root && node != null) {
            if (node.parent.lChild != null && node.parent.rChid != null) {
                lH = node.parent.lChild.heigh;
                rH = node.parent.rChid.heigh;
            } else if (node.parent.lChild != null) {
                lH = node.parent.lChild.heigh;
                rH = -1;
            } else if (node.parent.rChid != null) {
                rH = node.parent.rChid.heigh;
                lH = -1;
            }

            if (lH - 1 > rH) {

                z = node.parent;
                y = node;
                if (node.rChid == null && node.lChild == null) {
                    node = node.parent;
                    continue;
                }
                if (node.rChid == null) x = node.lChild;
                else if (node.lChild == null) x = node.rChid;
                else if (lH > rH) x = node.lChild;
                else if (lH < rH) x = node.rChid;
                median = median(x, y, z);

                if (median == x) {
                    z.lChild = x.rChid;
                    if (z.lChild != null) z.lChild.parent = z;
                    y.rChid = x.lChild;
                    if (y.rChid != null) y.rChid.parent = y;
                    x.rChid = z;
                    x.lChild = y;
                    x.parent = z.parent;

                    int xH, yH, zH;

                    xH = x.heigh;
                    yH = y.heigh;
                    zH = z.heigh;

                    x.heigh = zH - 1;

                    if (z.parent == null) {
                        root = x;
                    } else if (z.parent.lChild == z) z.parent.lChild = x;
                    else if (z.parent.rChid == z) z.parent.rChid = x;

                    z.parent = x;
                    y.parent = x;

                    z.heigh = maxHeight(z.lChild, z.rChid);
                    y.heigh = maxHeight(y.lChild, y.rChid);
                    x.heigh = maxHeight(y, z);

                }

                if (median == y) {
                    z.lChild = y.rChid;
                    y.rChid = z;
                    y.parent = z.parent;

                    if (z.lChild != null) z.lChild.parent = z;


                    int xH, yH, zH;

                    xH = x.heigh;
                    yH = y.heigh;
                    zH = z.heigh;

                    y.heigh = zH - 1;


                    if (z.parent == null) {
                        root = y;
                    } else if (z.parent.lChild == z) z.parent.lChild = y;
                    else if (z.parent.rChid == z) z.parent.rChid = y;

                    z.parent = y;


                    z.heigh = maxHeight(z.lChild, z.rChid);
                    x.heigh = maxHeight(x.lChild, x.rChid);
                    y.heigh = maxHeight(x, z);
                }


            } else if (rH - 1 > lH) {

                z = node.parent;
                y = node;

                if (node.rChid == null && node.lChild == null) {
                    node = node.parent;
                    continue;
                } else if (node.rChid == null) x = node.lChild;
                else if (node.lChild == null) x = node.rChid;
                else if (y.lChild.heigh > y.rChid.heigh) x = node.lChild;
                else if (y.lChild.heigh <= y.rChid.heigh) x = node.rChid;
                median = median(x, y, z);
                if (median == x) {
                    z.rChid = x.lChild;
                    y.lChild = x.rChid;

                    if (z.rChid != null) z.rChid.parent = z;
                    if (y.lChild != null) y.lChild.parent = y;

                    x.rChid = y;
                    x.lChild = z;
                    x.parent = z.parent;


                    int xH, yH, zH;

                    xH = x.heigh;
                    yH = y.heigh;
                    zH = z.heigh;

                    x.heigh = zH - 1;

                    if (z.parent == null) {
                        root = x;
                    } else if (z.parent.lChild == z) z.parent.lChild = x;
                    else if (z.parent.rChid == z) z.parent.rChid = x;

                    z.parent = x;
                    y.parent = x;

                    z.heigh = maxHeight(z.lChild, z.rChid);
                    y.heigh = maxHeight(y.lChild, y.rChid);
                    x.heigh = maxHeight(z, y);


                }

                if (median == y) {
                    z.rChid = y.lChild;
                    y.lChild = z;
                    y.parent = z.parent;

                    if (z.rChid != null) z.rChid.parent = z;


                    int xH, yH, zH;

                    xH = x.heigh;
                    yH = y.heigh;
                    zH = z.heigh;

                    y.heigh = zH - 1;


                    if (z.parent == null) {
                        root = y;
                    } else if (z.parent.lChild == z) z.parent.lChild = y;
                    else if (z.parent.rChid == z) z.parent.rChid = y;

                    z.parent = y;

                    z.heigh = maxHeight(z.lChild, z.rChid);
                    x.heigh = maxHeight(x.lChild, x.rChid);
                    y.heigh = maxHeight(y.lChild, y.rChid);
                }

            }
            node = node.parent;
        }
    }

    public TreeNode search(T val) {
        TreeNode temp = root;
        TreeNode result = null;
        while (temp != null && temp.inf.compareTo(val) != 0) {
            if (temp.inf.compareTo(val) < 0) {
                temp = temp.rChid;
            } else temp = temp.lChild;
        }

        result = temp;
        return result;
    }


    public void add(T k) {
        TreeNode<T> current = root, parent = null;
        if ((parent = search(k)) != null) {
            parent.incCount();
            return;
        }
        while (current != null) {
            int cmp = k.compareTo(current.inf);
            parent = current;
            if (cmp < 0) {
                current = current.lChild;
            } else {
                current = current.rChid;
            }
        }
        TreeNode<T> newNode = new TreeNode<T>(k);

        if (parent == null) {
            root = newNode;
        } else {
            if (k.compareTo(parent.inf) < 0) {
                parent.lChild = newNode;
                parent.lChild.parent = parent;


            } else {
                parent.rChid = newNode;
                parent.rChid.parent = parent;
            }

            TreeNode restr = parent;
            do {
                if (restr.rChid == null && restr.lChild == null) ;
                else if (restr.rChid == null) restr.heigh = restr.lChild.heigh + 1;
                else if (restr.lChild == null) restr.heigh = restr.rChid.heigh + 1;
                else restr.heigh = Math.max(restr.lChild.heigh, restr.rChid.heigh) + 1;
                if (restr != root) restr = restr.parent;
            }
            while (restr != root);

            if (root.lChild == null && root.rChid == null) root.heigh = 0;
            else if (root.lChild == null) root.heigh = root.rChid.heigh + 1;
            else if (root.rChid == null) root.heigh = root.lChild.heigh + 1;
            else root.heigh = Math.max(root.lChild.heigh, root.rChid.heigh) + 1;
        }
        restructure(parent);

        int a = 0;

    }

    public TreeNode successor(TreeNode node) {
        TreeNode result = node;
        if (node.rChid != null) {
            result = node.rChid;
            while (result.lChild != null) {
                result = result.lChild;
            }
        } else {
            if (result.equals(result.parent.lChild)) {
                result = result.parent;
                return result;
            } else {
                while (result.parent != null && !result.equals(result.parent.lChild)) {
                    if (result == null || result.parent == null) return null;
                    result = result.parent;
                }
                result = result.parent;
            }


        }

        return result;
    }

    public TreeNode predecessor(TreeNode node) {
        if (node.lChild == null) return node;
        TreeNode result = node.lChild;
        while (result.lChild != null) {
            result = result.rChid;
        }
        return result;
    }

    public void delete(T val) {
        TreeNode delNode = search(val);
        if (delNode == null) return;
        TreeNode replaceNode = null;
        TreeNode restrNode = delNode.parent;
        TreeNode heighNode = successor(delNode);

        if (delNode.lChild == null && delNode.rChid == null) {
            if (delNode == delNode.parent.lChild) {
                if (delNode.parent.rChid != null) delNode.parent.heigh = delNode.parent.rChid.heigh + 1;
                else delNode.parent.heigh = 0;
                delNode.parent.lChild = null;
            } else if (delNode == delNode.parent.rChid) {
                if (delNode.parent.lChild != null) delNode.parent.heigh = delNode.parent.lChild.heigh + 1;
                else delNode.parent.heigh = 0;
                delNode.parent.rChid = null;
            }
            delNode = null;
        }
        else {
            if(delNode.rChid == null)replaceNode = predecessor(delNode);
            else replaceNode = successor(delNode);
            delNode.inf = replaceNode.inf;
            delNode.count = replaceNode.count;
            if (replaceNode.parent.lChild.inf == replaceNode.inf) replaceNode.parent.lChild = null;
            else if (replaceNode.parent.rChid.inf == replaceNode.inf) replaceNode.parent.rChid = null;
            replaceNode = null;
        }


        do {
            heighNode.heigh = maxHeight(heighNode.lChild, heighNode.rChid);
            if (heighNode != root) heighNode = heighNode.parent;
        }
        while (heighNode != root);


        restructure(restrNode);
        root.heigh = Math.max(root.lChild.heigh, root.rChid.heigh) + 1;
    }


    private int maxHeight(TreeNode ln, TreeNode rn) {
        int result = 0;
        if (ln == null && rn == null) result = 0;
        else if (ln == null) result = rn.heigh + 1;
        else if (rn == null) result = ln.heigh + 1;
        else result = Math.max(ln.heigh,rn.heigh)+1;
        return result;

    }


}
