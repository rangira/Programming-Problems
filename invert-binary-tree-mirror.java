Java Solution 1 - Recursive

public TreeNode invertTree(TreeNode root) {
    if(root!=null){
        helper(root);
    }
 
    return root;    
}
 
public void helper(TreeNode p){
 
    TreeNode temp = p.left;
    p.left = p.right;
    p.right = temp;
 
    if(p.left!=null)
        helper(p.left);
 
    if(p.right!=null)
        helper(p.right);
}
Java Solution 2 - Iterative

public TreeNode invertTree(TreeNode root) {
    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
 
    if(root!=null){
        queue.add(root);
    }
 
    while(!queue.isEmpty()){
        TreeNode p = queue.poll();
        if(p.left!=null)
            queue.add(p.left);
        if(p.right!=null)
            queue.add(p.right);
 
        TreeNode temp = p.left;
        p.left = p.right;
        p.right = temp;
    }
 
    return root;    
}
