import java.util.*;

public class DeleteNodeBST {

    public static void main(String[] args) {

        Node root = new Node(12);
        // MAKE A TREE OF NODES...    
        
        delete(root, 14);
    }    

    public static Node delete(Node root, int data) {

        // base case, tree is empty
        if (root == null) {
            return root;
        }
        // 1.A node is in left subtree
        //  set root's leftchild to result of delete(root.left...)
        else if (data < root.data) {
            root.left = delete(root.left, data);
        }
        // 1.B node is in right subtree
        //  set root's righth child to result of delete(root.right...)
        else if (data > root.data) {
            root.right = delete(root.right, data);
        }
        // 2 found data!
        else {
            // Case 1: no child
            //  just set node to null (remove it) and return it
            if (root.left == null && root.right == null) {
                root = null;
            }
            // Case 2: one child
            // 2.A: no left child
            else if (root.left == null) {
                Node temp = root;
                root = root.right;
                temp = null;
            }
            // 2.B: no right child
            else if (root.right == null) {
                Node temp = root;
                root = root.left;
                temp = null;
            }
            // Case 3: 2 children
            else {
                // get minimum element in right subtree
                //  set it to `root` and remove it from its
                //   original spot
                Node temp = findMin(root.right);
                root.data = temp.data;
                root.right = delete(root.right, temp.data);
            }
        }

        return root;

    }

    public static Node findMin(Node root) {
        while (root.left != null)
            root = root.left;
        return root;
    }
}
