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
    public boolean isBST() {
            return isBSTRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        private boolean isBSTRec(tNode node, int min, int max) {
            if (node == null) {
                return true;
            }
            if (node.key < min || node.key > max) {
                return false;
            }
            return isBSTRec(node.left, min, node.key - 1) &&
                    isBSTRec(node.right, node.key + 1, max);
        }
    public void deleteAllEven() {
            ArrayList<Integer> evenKeys = new ArrayList<>();
            collectEvenKeys(root, evenKeys);
            for (int key : evenKeys) {
                delete(key);
            }
        }
        private void collectEvenKeys(tNode node, ArrayList<Integer> list) {
            if (node == null) {
                return;
            }
            collectEvenKeys(node.left, list);
            if (node.key % 2 == 0) {
                list.add(node.key);
            }
            collectEvenKeys(node.right, list);
        }
        public int getSize() {
            return size;
        }
        public void clear() {
            root = null;
            size = 0;
        }
        public tNode getRoot() {
            return root;
        }
        public void inorderPrint() {
            inorderPrintRec(root);
            System.out.println();
        }
        private void inorderPrintRec(tNode node) {
            if (node != null) {
                inorderPrintRec(node.left);
                System.out.print(node.key + " ");
                inorderPrintRec(node.right);
            }
        }
    
    
    
    
    
    
          
        
      
        
    
      
