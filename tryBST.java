import java.util.*;
public class tryBST{
  static class tNode {
    int key;
    tNode left;
    tNode right;
    tNode(int key) {
      this.key = key;
      this.left = null;
      this.right =null;
    }
  }
  static class BinarySearchTree{
    private tNode root;
    private int size ;
    public BinarySearchTree() {
      root = null;
      size = 0;
    }
    
      
