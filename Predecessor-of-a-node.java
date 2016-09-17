package zappos;

import java.util.Stack;

class Node2 {
	  int node;
	  Node2 left;
	  Node2 right;

	  Node2(int node, Node2 left, Node2 right) {
	    this.node = node;
	    this.left = left;
	    this.right = right;
	  }
	  @Override
	  public String toString (){
	     return "("+node+")";
	  }
	}

public class dNode {

	
	static Node2 root;
	int target;
	boolean found;
	static Stack<Node2> parentStack = new Stack<Node2>();
	static Node2 parent;
	
	dNode(){
		  init();
		  for (int i=0; i<=35; i++){
		    Node2 parent = findParent(i);
		    if (parent != null)
		      System.out.println("("+parent.node+", "+i+")");
		  }

		}
	
	public Node2 findParent(int target){
		  found = false;
		  this.target = target;
		  return internalFindParent(root, null);
		}
	
	private Node2 internalFindParent(Node2 node, Node2 parent){
		  if (found) 
			  return parent;
		  if (node.node == target) {
		    found = true;
		    return parent;
		  }
		  
		  if (node.left == null) return null;
		  Node2 temp = internalFindParent(node.left, node);
		  if(temp != null)
		    return temp;
		  if (node.right == null) return null;
		  temp = internalFindParent(node.right, node);
		  if(temp != null)
		    return temp;
		  return null;
		}
	
	public Node2 parent(int p){
	    return parentHelper(root,p);
	}
	private Node2 parentHelper(Node2 currentRoot, int p) {        
	    if (root.node == p || currentRoot==null){
	            return null;
	    }
	    else{
	        if(currentRoot.left.node==p || currentRoot.right.node==p)
	            return currentRoot;
	        else {
	            if (currentRoot.node<p) {
	                return parentHelper(currentRoot.right,p);
	            }
	            else {
	                return parentHelper(currentRoot.left,p);
	            }
	        }
	    }
	} 
	
	
	
	public void init() {
		  root = new Node2 (0,
		    new Node2(1,
		      new Node2 (2,
		        new Node2 (3,
		          new Node2 (4, null, null),
		          new Node2 (5, null, null)
		        ),
		        new Node2 (6,
		          new Node2 (7, null, null),
		          new Node2 (8, null, null)
		        )
		      ),
		      new Node2 (9,
		        new Node2 (10,
		          new Node2 (11, null, null),
		          new Node2 (12, null, null)
		        ),
		        new Node2 (13,
		          new Node2 (14, null, null),
		          new Node2 (15, null, null)
		        )
		      )
		     ),
		    new Node2(21,
		      new Node2 (22,
		        new Node2 (23,
		          new Node2 (24, null, null),
		          new Node2 (25, null, null)
		        ),
		        new Node2 (26,
		          new Node2 (27, null, null),
		          new Node2 (28, null, null)
		        )
		      ),
		      new Node2 (29,
		        new Node2 (30,
		          new Node2 (31, null, null),
		          new Node2 (32, null, null)
		        ),
		        new Node2 (33,
		          new Node2 (34, null, null),
		          new Node2 (35, null, null)
		        )
		      )
		    )
		  );
		}
	
	public static void inOrderTraversal(Node2 root){
        if(root != null){
            if(parentStack.size()==0){
                parentStack.push(root);
            }
            if(root.left!=null){
                parentStack.push(root); 
                inOrderTraversal(root.left);  
            }
            if(root.node == 35)
            {
	            parent = parentStack.pop();
	            System.out.println(root.node+"'s parent is "+parent.node);
            }
            if(root.right!=null){
                parentStack.push(root);
                inOrderTraversal(root.right);
            }
        }
        else{
            if(root==null){System.err.println("Can't process a empty root tree");}
        }
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      /*Node2 r = new Node2(1);
      r.left = new Node2(2);
      r.right = new Node2(3);
      r.left.left = new Node2(4);
      r.left.right = new Node2(5);
      r.left.left.left = new Node2(9);
      r.left.right.left = new Node2(8);
      r.right.left = new Node2(6);
      r.right.left.right = new Node2(7);
      Node2 n = pred(r,5);
      System.out.println(n.val);*/
		//new dNode().parent(13);
		new dNode().inOrderTraversal(root);
		
		  System.exit(0);
	}

}



