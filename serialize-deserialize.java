package pingpong;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

class TreeNode {
	     int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }

public class test {
	static int pos =-1;
	static TreeNode tree = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		TreeNode  root        = new TreeNode(20);       
	    root.left               = new TreeNode(8);
	    root.right              = new TreeNode(22);
	    root.left.left         = new TreeNode(4);
	    root.left.right        = new TreeNode(12);
	    root.left.right.left  = new TreeNode(10);
	    root.left.right.right = new TreeNode(14);
	    System.out.println("original="+serialize(root));
	    System.out.println(deserialize(serialize(root)).left.right.right.val);
	    //System.out.println(serialize1(root));
	    //System.out.println(deserialize1(serialize(root)).left.left.val);
	    /*System.out.println(serialize3(root));
	    System.out.println(deserialize2(serialize2(root)).left.right.right.val);
	    
	    System.out.println(serialize4(root));
	    System.out.println(deserialize4(serialize4(root)).left.right.right.val);*/
	}

	public static  String serialize(TreeNode root) {
	    if(root==null){
	        return "";
	    }
	 
	    StringBuilder sb = new StringBuilder();
	 
	    LinkedList<TreeNode> queue = new LinkedList<TreeNode>()	;
	 
	    queue.add(root);
	    while(!queue.isEmpty()){
	        TreeNode t = queue.poll();
	        if(t!=null){
	            sb.append(String.valueOf(t.val) + ",");
	            queue.add(t.left);
	            queue.add(t.right);
	        }else{
	            sb.append("#,");
	        }
	    }
	 
	    sb.deleteCharAt(sb.length()-1);
	    System.out.println(sb.toString());
	    return sb.toString();
	}
	 
	// Decodes your encoded data to tree.
	public static TreeNode deserialize(String data) {
	    if(data==null || data.length()==0)
	        return null;
	 
	    String[] arr = data.split(",");
	    TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
	 
	 
	    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	    queue.add(root);
	 
	    int i=1;
	    while(!queue.isEmpty()){
	        TreeNode t = queue.poll();
	 
	        if(t==null)
	            continue;
	 
	        if(!arr[i].equals("#")){
	            t.left = new TreeNode(Integer.parseInt(arr[i]));    
	            queue.offer(t.left);
	      
	        }else{
	            t.left = null;
	            queue.offer(null);
	        }
	        i++;
	 
	        if(!arr[i].equals("#")){
	            t.right = new TreeNode(Integer.parseInt(arr[i]));    
	            queue.offer(t.right);
	 
	        }else{
	            t.right = null;
	            queue.offer(null);
	        }
	        i++;
	    }
	 
	    return root;
	}
	
	
	 static String data = "";
     
	    public static String serialize1(TreeNode root) {
	        // write your code here
	        if (root == null) {
	            data += "# ";
	        }
	        else {
	            data += root.val + " ";
	            serialize1(root.left);
	            serialize1(root.right);
	        }
	        return data;
	    }
	    
	    public static TreeNode deserialize1(String data) {
	        if(data == null)
	            return null;
	     
	        int[] t = {0};
	        String[] arr = data.split(",");
	     
	        return helper(arr, t);
	    }
	     
	    public static TreeNode helper(String[] arr, int[] t){
	        if(arr[t[0]].equals("#")){
	            return null;
	        }
	     
	        TreeNode root = new TreeNode(Integer.parseInt(arr[t[0]]));
	     
	        t[0]=t[0]+1;
	        root.left = helper(arr, t);
	        t[0]=t[0]+1;
	        root.right = helper(arr, t);
	     
	        return root;
	    }
	    
	    
	    public static String serialize2(TreeNode root) {
	        StringBuilder sb = new StringBuilder();    
	        helperS(root, sb);
	        return sb.toString();
	    }
	    private static void helperS(TreeNode node, StringBuilder sb){
	        if(node == null){
	            sb.append("null").append(",");
	            return;
	        }
	        sb.append(node.val).append(",");
	        helperS(node.left, sb);
	        helperS(node.right, sb);
	    }

	    // Decodes your encoded data to tree.
	    public static TreeNode deserialize2(String data) {
	        String[] vals  = data.split(",");
	        Deque<TreeNode> nodeStk = new LinkedList<>();
	        Deque<Boolean> leftOrRightStk = new LinkedList<>();
	        TreeNode tmp = null;
	        for (int idx = 0; idx < vals.length; idx++) {
	            String nextVal = vals[idx];
	            if (nextVal.equals("null")) {
	                if (!leftOrRightStk.isEmpty() && leftOrRightStk.peek() == false) {
	                    leftOrRightStk.pop();
	                    leftOrRightStk.push(true);
	                } else {
	                    tmp = null;
	                    while (!leftOrRightStk.isEmpty() && leftOrRightStk.peek() == true) {
	                        nodeStk.peek().right = tmp;
	                        tmp = nodeStk.pop();
	                        leftOrRightStk.pop();
	                    }
	                    if (!leftOrRightStk.isEmpty()) {
	                        nodeStk.peek().left = tmp;
	                        leftOrRightStk.pop();
	                        leftOrRightStk.push(true);
	                    }
	                }
	            } else {
	                nodeStk.push(new TreeNode(Integer.parseInt(nextVal)));
	                leftOrRightStk.push(false);
	            }
	        }
	        return tmp;
	    }
	    
	    public static String serialize3(TreeNode root) {
	        if(root==null)
	            return null;
	     
	        Stack<TreeNode> stack = new Stack<TreeNode>();
	        stack.push(root);
	        StringBuilder sb = new StringBuilder();
	     
	        while(!stack.isEmpty()){
	            TreeNode h = stack.pop();   
	            if(h!=null){
	                sb.append(h.val+",");
	                stack.push(h.right);
	                stack.push(h.left);  
	            }else{
	                sb.append("#,");
	            }
	        }
	     
	        return sb.toString().substring(0, sb.length()-1);
	    }
	    
	    
	    
	    public static String serialize4(TreeNode root) {
	        StringBuilder sb=new StringBuilder();
	        serializeHelper4(root,sb);
	        return sb.toString().substring(1);
	    }
	    private static void serializeHelper4(TreeNode root, StringBuilder sb){
	        sb.append(",");
	        if(root==null) sb.append("#");
	        else sb.append(root.val);
	        if(root!=null){
	            serializeHelper4(root.left,sb);
	            serializeHelper4(root.right,sb);            
	        }
	    }

	    // Decodes your encoded data to tree.
	    public static TreeNode deserialize4(String data) {
	        if(data.equals("#")) return null;
	        String[] s=data.split(",");
	        int[] index={-1};
	        return deserializeHelper4(s,index);

	    }
	    public static TreeNode deserializeHelper4(String[] s,int[] index){
	        index[0]++;
	        if(s[index[0]].equals("#")) return null;
	        
	        TreeNode root=new TreeNode(Integer.parseInt(s[index[0]]));
	        root.left=deserializeHelper4(s,index);
	        root.right=deserializeHelper4(s,index);
	        return root;
	    }

}
