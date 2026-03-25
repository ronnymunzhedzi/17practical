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
    public void printTree() {
            printTreeRec(root, 0);
        }
        private void printTreeRec(tNode node, int level) {
            if (node == null) {
                return;
            }
            printTreeRec(node.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(node.key);
            printTreeRec(node.left, level + 1);
        }
    }
   public static void main(String[] args) {
        System.out.println("\n=== BINARY SEARCH TREE PERFORMANCE ANALYSIS ===");
        System.out.println(" Balanced BST Operations\n");
        int n = 20; 
        System.out.println("Finding optimal tree size for timing >1000ms...\n");
        int[] testN = {16, 17, 18, 19, 20, 21};
        for (int test : testN) {
            int size = (1 << test) - 1;
            System.out.println("Testing n=" + test + " (size=" + size + " keys)...");
            double testTime = estimateOperationTime(test);
            if (testTime > 500) { 
                n = test;
                System.out.println("  Suitable size found! Time ~" +
                        String.format("%.0f", testTime) + "ms\n");
                break;
            }
        }
        int totalKeys = (1 << n) - 1; 
        System.out.println("Using n = " + n + " with " + totalKeys + " keys\n");
        int repetitions = 30;
        double[] populateTimes = new double[repetitions];
        double[] deleteEvenTimes = new double[repetitions];
        System.out.println("Running " + repetitions + " repetitions...\n");
        for (int rep = 0; rep < repetitions; rep++) {
            BinarySearchTree bst = new BinarySearchTree();
            long start = System.nanoTime();
            buildBalancedBST(bst, 1, totalKeys);
            long end = System.nanoTime();
            populateTimes[rep] = (end - start) / 1_000_000.0;
            if (!bst.isBST()) {
                System.out.println("Tree is not a valid BST at repetition " + (rep+1));
            }
            start = System.nanoTime();
            bst.deleteAllEven();
            end = System.nanoTime();
            deleteEvenTimes[rep] = (end - start) / 1_000_000.0; 
            if ((rep + 1) % 5 == 0) {
                System.out.println("  Completed " + (rep + 1) + " repetitions...");
            }
        }
        double populateAvg = calculateAverage(populateTimes);
        double populateStdDev = calculateStdDev(populateTimes, populateAvg);
        double deleteEvenAvg = calculateAverage(deleteEvenTimes);
        double deleteEvenStdDev = calculateStdDev(deleteEvenTimes, deleteEvenAvg);
        System.out.println("\n\n=== FINAL RESULTS ===");
        System.out.println("Number of keys: " + totalKeys);
        System.out.println("Repetitions: " + repetitions);
        System.out.println();
        System.out.println("+--------------------------+---------------------+-------------------+");
        System.out.println("| Method                   | Average Time (ms)   | Std Deviation (ms) |");
        System.out.println("+--------------------------+---------------------+-------------------+");
        System.out.printf("| Populate tree            | %19.2f | %17.2f |\n",
                populateAvg, populateStdDev);
        System.out.printf("| Remove evens from tree   | %19.2f | %17.2f |\n",
                deleteEvenAvg, deleteEvenStdDev);
        System.out.println("+--------------------------+---------------------+-------------------+");
        if (populateAvg < 1000 || deleteEvenAvg < 1000) {
            System.out.println("\n: Average times are less than 1000ms.");
            System.out.println("   Consider increasing n for the next run.");
            System.out.println("   Current n=" + n + " (size=" + totalKeys + ")");
            System.out.println("   Try n=21 (2,097,151 keys) or n=22 (4,194,303 keys)");
        } else {
            System.out.println("\n Times are >1000ms as required.");
        }
        System.out.println("\n---Statistics");
        System.out.println("Tree is perfectly balanced: " +
                (populateTimes.length > 0 ? "Yes (by construction)" : "N/A"));
        System.out.println("\nPractical completed successfully!");
    }
  
  
    
    
    
    
    
    
    
          
        
      
        
    
      
