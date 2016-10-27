Java Solution 1 - Recursive

All values on the left sub tree must be less than root, and all values on the right sub tree must be greater than root. So we just check the boundaries for each node.

public boolean isValidBST(TreeNode root) {
    return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);    
}
 
public boolean isValidBST(TreeNode p, double min, double max){
    if(p==null) 
        return true;
 
    if(p.val <= min || p.val >= max)
        return false;
 
    return isValidBST(p.left, min, p.val) && isValidBST(p.right, p.val, max);
}
This solution also goes to the left subtree first. If the violation occurs close to the root but on the right subtree, the method still cost O(n). The second solution below can handle violations close to root node faster.

This solution can also be written as the following:

public boolean isValidBST(TreeNode root) {
    if(root==null)
        return true;
 
    return helper(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
}
 
public boolean helper(TreeNode root, double low, double high){
 
    if(root.val<=low || root.val>=high)
        return false;
 
    if(root.left!=null && !helper(root.left, low, root.val)){
        return false;
    }
 
    if(root.right!=null && !helper(root.right, root.val, high)){
        return false;
    }
 
    return true;    
}
Java Solution 2 - Iterative

public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
 
        LinkedList<BNode> queue = new LinkedList<BNode>();
        queue.add(new BNode(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY));
        while(!queue.isEmpty()){
            BNode b = queue.poll();
            if(b.n.val <= b.left || b.n.val >=b.right){
                return false;
            }
            if(b.n.left!=null){
                queue.offer(new BNode(b.n.left, b.left, b.n.val));
            }
            if(b.n.right!=null){
                queue.offer(new BNode(b.n.right, b.n.val, b.right));
            }
        }
        return true;
    }
}
//define a BNode class with TreeNode and it's boundaries
class BNode{
    TreeNode n;
    double left;
    double right;
    public BNode(TreeNode n, double left, double right){
        this.n = n;
        this.left = left;
        this.right = right;
    }
}
