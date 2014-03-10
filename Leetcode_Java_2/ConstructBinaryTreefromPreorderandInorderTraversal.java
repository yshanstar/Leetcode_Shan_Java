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
			nodeMap.put(inorder[i],i);
        }

        return treeBuilder(preorder, inorder, nodeMap, 0, preorder.length-1, 0, inorder.length-1);
    }

    private TreeNode treeBuilder(int[] preorder, 
    							int[] inorder, 
    							HashMap<Integer, Integer> nodeMap, 
    							int preStart, 
    							int preEnd,
    							int inStart,
    							int inEnd){
    	TreeNode root = new TreeNode(preorder[preStart]);
    	root.left = null;
    	root.right = null;

    	int idx = nodeMap.get(root.val);

    	if(preStart == preEnd && preorder[preStart] == inorder[inStart]){
    		return root;
    	}
    	if(idx > inStart){
    		root.left = treeBuilder(preorder, inorder, nodeMap, preStart+1, preStart+idx-inStart, inStart, idx-1);
    	}
    	if(inEnd > idx){
    		root.right = treeBuilder(preorder, inorder, nodeMap, preStart+idx-inStart+1, preEnd, idx+1, inEnd);
    	}
    	return root;
    }
}