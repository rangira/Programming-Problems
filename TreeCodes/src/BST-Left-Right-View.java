/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
 
 
 class BinaryTreeViews {
  
 private static Node root = null;
  
 public static void main(String[] args) {
  int [] A = {10,8,9,14,12,13};
  root = buildBST(root, A);
  System.out.println("printing inorder: ");
  printBST(root);
  System.out.println();
  printLeftNRightViewOfBT(root);
 }
  
 public static void printLeftNRightViewOfBT(Node node) {
  if (null == node) { return ; }
  Queue<Node> queue = new LinkedList<Node>();
  Node marker = new Node(null);
  queue.add(node);
  queue.add(marker);
   
  //boolean wasMarker = false;
  ArrayList<Node> leftViewList = new ArrayList<Node>();
  ArrayList<Node> rightViewList = new ArrayList<Node>();
  leftViewList.add(node);
  //rightViewList.add(node);
  while (!queue.isEmpty()) {
   Node currentNode = queue.remove();
   if (currentNode.equals(marker)) {
    if (!queue.isEmpty()) {
     leftViewList.add(queue.peek());
     queue.add(marker);
    }
   } 
   if (!queue.isEmpty() && queue.peek().equals(marker)) {
    rightViewList.add(currentNode);      
   }
   if (currentNode.left != null) {
    queue.add(currentNode.left);
   }
   if (currentNode.right != null) {
    queue.add(currentNode.right);
   }
  }
  Iterator<Node> itLeft = leftViewList.iterator();
  System.out.println("Printing left View: ");
  while (itLeft.hasNext()) {
   System.out.print(itLeft.next().data + " ");
  }
  System.out.println();
   
  System.out.println("Printing right view: ");
  Iterator<Node> itRight = rightViewList.iterator();
  while (itRight.hasNext()) {
   System.out.print(itRight.next().data + " ");
  }
  System.out.println();
 }
  
 public static void printBST(Node node) {
  if (node == null) { return ; }
  if (node.left != null) {
   printBST(node.left);
  }
  System.out.print(node.data + " ");
  if (node.right != null) {
   printBST(node.right);
  }
 }
  
 public static Node buildBST(Node node, int [] A) {
  int len = A.length;
   
  for (int i=0; i<len; i++) {
   node = insertIntoBST(node, A[i]);
  }
   
  return node;
 }
  
 private static Node insertIntoBST(Node node, int value) {
  if (node == null) {
   return new Node(value);
  }
  if (value <= node.data) {
   node.left = insertIntoBST(node.left, value);
  } else {
   node.right = insertIntoBST(node.right, value);
  }
  return node;
 }
}
 
class Node {
 Integer data;
 Node left;
 Node right;
  
 Node(Integer data) {
  this.data = data;
  this.left = null;
  this.right = null;
 }
}

/* OUTPUT 

Success	time: 0.1 memory: 320576 signal:0
printing inorder: 
8 9 10 12 13 14 
Printing left View: 
10 8 9 13 
Printing right view: 
10 14 12 13 

*/
