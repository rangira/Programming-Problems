
import java.util.Scanner;
 
/** Class ExpressionTree **/
class ExpressionTree
{
    /** class TreeNode **/
    class TreeNode
    {    
        char data;
        TreeNode left, right;
 
        /** constructor **/
        public TreeNode(char data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    } 
 
    /** class StackNode **/
    class StackNode
    {
        TreeNode treeNode;
        StackNode next;
 
        /** constructor **/
        public StackNode(TreeNode treeNode)
        {
            this.treeNode = treeNode;
            next = null;
        }
    }
 
    private static StackNode top;
 
    /** constructor **/
    public ExpressionTree()
    {
        top = null;
    }
 
    /** function to clear tree **/
    public void clear()
    {
        top = null;
    }
 
    /** function to push a node **/
    private void push(TreeNode ptr)
    {
        if (top == null)
            top = new StackNode(ptr);
        else
        {
            StackNode nptr = new StackNode(ptr);
            nptr.next = top;
            top = nptr;
        }
    }
 
    /** function to pop a node **/
    private TreeNode pop()
    {
        if (top == null)
            throw new RuntimeException("Underflow");
        else
        {
            TreeNode ptr = top.treeNode;
            top = top.next;
            return ptr;
        }
    }
 
    /** function to get top node **/
    private TreeNode peek()
    {
        return top.treeNode;
    }
 
    /** function to insert character **/
    private void insert(char val)
    {
        try
        {
            if (isDigit(val))
            {
                TreeNode nptr = new TreeNode(val);
                push(nptr);
            }
            else if (isOperator(val))
            {
                TreeNode nptr = new TreeNode(val);
                nptr.left = pop();
                nptr.right = pop();
                push(nptr);
            }
        }
        catch (Exception e)
        {
            System.out.println("Invalid Expression");
        }
    }
 
    /** function to check if digit **/
    private boolean isDigit(char ch)
    {
        return ch >= '0' && ch <= '9';
    }
 
    /** function to check if operator **/
    private boolean isOperator(char ch)
    {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
 
    /** function to convert character to digit **/
    private int toDigit(char ch)
    {
        return ch - '0';
    }
 
    /** function to build tree from input */
    public void buildTree(String eqn)
    {
        for (int i = eqn.length() - 1; i >= 0; i--)
            insert(eqn.charAt(i));
    }
 
    /** function to evaluate tree */
    public double evaluate()
    {
        return evaluate(peek());
    }
 
    /** function to evaluate tree */
    public double evaluate(TreeNode ptr)
    {
        if (ptr.left == null && ptr.right == null)
            return toDigit(ptr.data);
        else
        {
            double result = 0.0;
            double left = evaluate(ptr.left);
            double right = evaluate(ptr.right);
            char operator = ptr.data;
 
            switch (operator)
            {
            case '+' : result = left + right; break;
            case '-' : result = left - right; break;
            case '*' : result = left * right; break;
            case '/' : result = left / right; break;
            default  : result = left + right; break;
            }
            return result;
        }
    }
 
    /** function to get postfix expression */
    public void postfix()
    {
        postOrder(peek());
    }
 
    /** post order traversal */
    private void postOrder(TreeNode ptr)
    {
        if (ptr != null)
        {
            postOrder(ptr.left);            
            postOrder(ptr.right);
            System.out.print(ptr.data);            
        }    
    }
 
    /** function to get infix expression */
    public void infix()
    {
        inOrder(peek());
    }
 
    /** in order traversal */
    private void inOrder(TreeNode ptr)
    {
        if (ptr != null)
        {
            inOrder(ptr.left);
            System.out.print(ptr.data);
            inOrder(ptr.right);            
        }    
    }
 
    /** function to get prefix expression */
    public void prefix()
    {
        preOrder(peek());
    }
 
    /** pre order traversal */
    private void preOrder(TreeNode ptr)
    {
        if (ptr != null)
        {
            System.out.print(ptr.data);
            preOrder(ptr.left);
            preOrder(ptr.right);            
        }    
    }
}
 
/** class ExpressionTreeTest **/
public class ExpressionTreeTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Expression Tree Test");
 
        /** make object of ExpressionTree **/
        ExpressionTree et = new ExpressionTree();
 
        System.out.println("\nEnter equation in prefix form");
        et.buildTree(scan.next());
 
        System.out.print("\nPrefix  : ");
        et.prefix();
        System.out.print("\n\nInfix   : ");
        et.infix();
        System.out.print("\n\nPostfix : ");
        et.postfix();
        System.out.println("\n\nEvaluated Result : "+ et.evaluate());
    }
}
