
import java.util.LinkedList;
import java.util.Queue;



class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){};
    TreeNode(int val){
        this.val=val;
    }
    TreeNode (int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class InvertBinaryTrees{
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(7);
        TreeNode left1left = new TreeNode(1);
        TreeNode left1right = new TreeNode(3);
        TreeNode right1left= new TreeNode(6);
        TreeNode right1right = new TreeNode(9);

        left1.left = left1left;
        left1.right = left1right;
        right1.left = right1left;
        right1.right = right1right;
        root.left = left1;
        root.right=right1;
        System.out.println("---Tree---");
        levelOrderTraversal(root);

        TreeNode invertedTree = invertTree(root);
        System.out.println("---invertedTree---");
        levelOrderTraversal(invertedTree);


    }

    public static void printTree(TreeNode root){
        if(root!=null){
            System.out.print(root.val + " ");
            //print left node
            printTree(root.left);
            printTree(root.right);
        }

    }

    public static void inOrderTraversal(TreeNode root){
       
        if(root != null){
            printTree(root.left);
            System.out.print(root.val + " ");
            printTree(root.right);
        }
    }

    public static void levelOrderTraversal(TreeNode root){
        if(root==null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.val+ " ");
            if(node.left != null){
                queue.offer(node.left);
            } 
            if(node.right != null){
                queue.offer(node.right);
            }
        }
    }

    public static TreeNode invertTree(TreeNode root){
        if(root == null || (root.left == null && root.right == null)){
            return root;
        }

        //swap
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right=left;

        return root;
    }

}