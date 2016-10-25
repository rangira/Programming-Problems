public void connect(TreeLinkNode root) {
    if(root==null)
        return;
 
    LinkedList<TreeLinkNode> nodeQueue = new LinkedList<TreeLinkNode>();
    LinkedList<Integer> depthQueue = new LinkedList<Integer>();
 
    if(root!=null){
        nodeQueue.offer(root);
        depthQueue.offer(1);
    }
 
    while(!nodeQueue.isEmpty()){
        TreeLinkNode topNode = nodeQueue.poll();
        int depth = depthQueue.poll();
 
        if(depthQueue.isEmpty()){
            topNode.next = null;
        }else if(depthQueue.peek()>depth){
            topNode.next = null;
        }else{
            topNode.next = nodeQueue.peek();
        }
 
        if(topNode.left!=null){
            nodeQueue.offer(topNode.left);
            depthQueue.offer(depth+1);
        }
 
        if(topNode.right!=null){
            nodeQueue.offer(topNode.right);
            depthQueue.offer(depth+1);
        }        
    }
}
