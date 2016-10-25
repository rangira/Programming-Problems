public class BinaryTreeMinDepth {
2	
3	    private TreeNode root;
4	
5	    public int getMinDepth() {
6	        return getMinDepth(root);
7	    }
8	
9	    private int getMinDepth(TreeNode root) {
10	
11	        if (root == null) {
12	            return 0;
13	        }
14	
15	        if (root.left == null && root.right == null) {
16	            return 1;
17	        }
18	
19	        int leftDepth = root.left != null ? getMinDepth(root.left) : Integer.MAX_VALUE;
20	        int rightDepth = root.right != null ? getMinDepth(root.right) : Integer.MAX_VALUE;
21	
22	        return 1 + Math.min(leftDepth, rightDepth);
23	    }
24	
25	    public void createSampleTree() {
26	        root = new TreeNode(1);
27	        TreeNode n2 = new TreeNode(2);
28	        TreeNode n3 = new TreeNode(3);
29	        TreeNode n4 = new TreeNode(4);
30	        TreeNode n5 = new TreeNode(5);
31	        TreeNode n6 = new TreeNode(6);
32	        TreeNode n7 = new TreeNode(7);
33	        TreeNode n8 = new TreeNode(8);
34	        TreeNode n9 = new TreeNode(9);
35	        TreeNode n10 = new TreeNode(10);
36	        TreeNode n11 = new TreeNode(11);
37	
38	        root.left = n2;
39	        root.right = n3;
40	
41	        n2.left = n4;
42	        n2.right = n5;
43	
44	        n3.left = n6;
45	        n3.right = n7;
46	
47	        n4.right = n8;
48	
49	        n5.right = n9;
50	
51	        n7.right = n10;
52	
53	        n8.left = n11;
54	    }
55	
56	    public static void main(String[] args) {
57	        BinaryTreeMinDepth tree = new BinaryTreeMinDepth();
58	        tree.createSampleTree();
59	        System.out.println("Min Depth "  + tree.getMinDepth());
60	    }
61	
62	}
63	
64	class TreeNode {
65	    int data;
66	    TreeNode left;
67	    TreeNode right;
68	
69	    public TreeNode(int data, TreeNode left, TreeNode right) {
70	        super();
71	        this.data = data;
72	        this.left = left;
73	        this.right = right;
74	    }
75	
76	    public TreeNode() {
77	        super();
78	    }
79	
80	    public TreeNode(int data) {
81	        super();
82	        this.data = data;
83	    }
84	}
