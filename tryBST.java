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
    private tNode deleteRec(tNode,int key) {
      if ( node== null){
        return null;
      }
      if (key < node.key) {
                node.left = deleteRec(node.left, key);
            } else if (key > node.key) {
                node.right = deleteRec(node.right, key);
            } else {
        if ( node.left == null && node .right ==null){
          return null;
        }
        else if ( node.left == null){
          return node.right;
        }
        else if ( node.right == null) {
          return node.right;
        } else if ( node .right == null){
          return node.left;
        }
        else{
          tNode succesor = findMin( node.right);
          node.key= succesor.key;
          node.right = deleteRec(node.right ,succesor.key);
        }
      }
      return node;
    }
    private tNode findMin(tnode node) {
      while ( node.left!=null) {
        node = node.left;
      }
      return node;
    }
    private boolean searchRec(tNode node, int key) {
            if (node == null) {
                return false;
            }

            if (key == node.key) {
                return true;
            }

            if (key < node.key) {
                return searchRec(node.left, key);
            } else {
                return searchRec(node.right, key);
            }
        }
    
    
    
    
          
        
      
        
    
      
