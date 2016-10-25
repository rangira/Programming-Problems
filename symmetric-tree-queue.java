/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return true;
            
        Queue<TreeNode> lq = new LinkedList<TreeNode>();
        Queue<TreeNode> rq = new LinkedList<TreeNode>();
        
        lq.add(root.left);
        rq.add(root.right);
        TreeNode leftTemp = null;
        TreeNode rightTemp = null;
        
        while(lq.isEmpty() == false && rq.isEmpty() == false){
            leftTemp = lq.poll();
            rightTemp = rq.poll();
            
            if(leftTemp == null && rightTemp == null)
                continue;
            
            if((leftTemp == null && rightTemp != null) || (leftTemp != null && rightTemp == null))
                return false;
            
            if(leftTemp.val != rightTemp.val)
                return false;
            
            //take care of the order when adding left and right child to left and right queue
            lq.add(leftTemp.left);
            lq.add(leftTemp.right);
            
            rq.add(rightTemp.right);
            rq.add(rightTemp.left);
        }
        
        //since the left and right always have same size, at here both of them are empty
        
        return true;
        
    }
    
}
