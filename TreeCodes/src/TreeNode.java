import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
public class TreeNode {
	 int key;
	 TreeNode right,left;
	 
	 public TreeNode(int key) {
		// TODO Auto-generated constructor stub
		 this.key = key;
		 left = right =null;
	}
}

class QItem
{
	TreeNode node;
	int hd;
	public QItem(TreeNode n, int h) {
		// TODO Auto-generated constructor stub
		node = n;
		hd = h;
	}
}

class Tree
{
	TreeNode root;
	public Tree() {
		// TODO Auto-generated constructor stub
		root = null;
	}
	
	public Tree(TreeNode n)
	{
		root = n;
	}
	
	public void printTopView()
	{
		
		if(root == null) return;
		
		HashSet<Integer> set= new HashSet<>();
		Queue<QItem> Q = new LinkedList<QItem>();
		Q.add(new QItem(root, 0));
		
		while(!Q.isEmpty()){
			//System.out.println("Queue elements now"+Q.toString());
			//remove an item from the queue
			QItem qi = Q.remove();
			//get its horizontal distance
			int hd = qi.hd;
			
			//get the node as well
			TreeNode node = qi.node;
			
			if(!set.contains(hd)){
				set.add(hd);
				System.out.print(node.key);
			}
			if(node.left!=null)
				Q.add(new QItem(node.left,hd-1));
			if(node.right!=null)
				Q.add(new QItem(node.right, hd+1));
			}
			
		}
	
	public static void main(String args[])
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);
        Tree t = new Tree(root);
        System.out.print("top view is");
        t.printTopView();
	}
	}
	
