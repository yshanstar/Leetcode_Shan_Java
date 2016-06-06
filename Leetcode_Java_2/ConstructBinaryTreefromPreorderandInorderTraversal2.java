/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0){
        	return null;
        }

        HashMap<Integer, Integer> nodeMap = new HashMap<Integer, Integer>();

        for(int i=0; i<inorder.length; i++){
        	nodeMap.put(inorder[i], i);
        }

        return helper(	preorder,
        				0,
        				preorder.length-1,
        				inorder,
        				0,
        				inorder.length-1,
        				nodeMap);
    }

    private TreeNode helper(int[] preorder, 
    						int preOrderStart, 
    						int preOrderEnd,
    						int [] inorder,
    						int inOrderStart,
    						int inOrderEnd,
    						HashMap<Integer,Integer> nodeMap){
    	TreeNode root = new TreeNode(preorder[preOrderStart]);
    	root.left = null;
    	root.right = null;

    	int idx = nodeMap.get(root.val);

    	if(preOrderStart == preOrderEnd && preorder[preOrderStart] == inorder[inOrderStart]){
    		return root;
    	}

    	if(idx > inOrderStart){
    		root.left = helper( preorder,
    							preOrderStart + 1,
    							preOrderStart + idx - inOrderStart,
    							inorder,
    							inOrderStart,
    							idx-1,
    							nodeMap);
    	}
    	if(idx < inOrderEnd){
    		root.right = helper(preorder,
    							preOrderStart + idx - inOrderStart + 1,
    							preOrderEnd,
    							inorder,
    							idx+1,
    							inOrderEnd,
    							nodeMap);
    	}
    	return root;
    }
}