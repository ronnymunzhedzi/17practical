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
    public void insert (int key) {
      root =insertRec(root,key);
      size++;
    }
    private tNode insertrec(tNode ,int key) {
      if (node==null){
        return new tNode (key);
      }
      if (key < node.key){
        node.left = insertRec(node.left,key);
      } else if (key> node.key){
        node.right = insertRec( node.right,key);
        return node;
      }
      public boolean delete(int key) {
        if (search(key)){
        root = deleteRec(root,key):
          size--;
        return true;
      }
      return false;
    }
    private tNode
        
    
      
