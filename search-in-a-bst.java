public Node search(Node root, int key)
{
    // Base Cases: root is null or key is present at root
    if (root==null || root.key==key)
        return root;
 
    // val is greater than root's key
    if (root.key > key)
        return search(root.left, key);
 
    // val is less than root's key
    return search(root.right, key);
}
