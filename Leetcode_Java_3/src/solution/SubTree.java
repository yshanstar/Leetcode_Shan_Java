package solution;

import util.TreeNode;

/*
 * Given two binary trees, check if the first tree is subtree of the second one. A subtree of a tree T is a tree S consisting of a TreeNode in T and all of its descendants in T. The subtree corresponding to the root TreeNode is the entire tree; the subtree corresponding to any other TreeNode is called a proper subtree.

For example, in the following case, tree S is a subtree of tree T.

        Tree 2
          10  
        /    \ 
      4       6
       \
        30


        Tree 1
              26
            /   \
          10     3
        /    \     \
      4       6      3
       \
        30
 */
public class SubTree {
	/* This function returns true if S is a subtree of T, otherwise false */
	public boolean isSubtree(TreeNode T, TreeNode S) {
		if (S == null) {
			return true;
		}

		if (T == null) {
			return false;
		}

		if (sameTree(T, S)) {
			return true;
		}

		return isSubtree(T.left, S) || isSubtree(T.right, S);
	}

	private boolean sameTree(TreeNode n1, TreeNode n2) {
		if (n1 == null && n2 == null) {
			return true;
		}

		if (n1 == null || n2 == null) {
			return false;
		}

		return (n1.val == n2.val) && sameTree(n1.left, n2.left) && sameTree(n1.right, n2.right);
	}

	public static void main(String[] args) {
		// TREE 1
        /* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      3
           \
            30  */

		TreeNode root = new TreeNode(26);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(3);
		root.left = new TreeNode(10);
		root.left.left = new TreeNode(4);
		root.left.left.right = new TreeNode(30);
		root.left.right = new TreeNode(6);

		// TREE 2
        /* Construct the following tree
           10
         /    \
         4      6
          \
          30  */

		TreeNode root2 = new TreeNode(10);
		root2.right = new TreeNode(6);
		root2.left = new TreeNode(4);
		root2.left.right = new TreeNode(30);

		SubTree test = new SubTree();
		if (test.isSubtree(root, root2)) {
			System.out.println("Tree 2 is subtree of Tree 1 ");
		} else {
			System.out.println("Tree 2 is not a subtree of Tree 1");
		}
	}
}
