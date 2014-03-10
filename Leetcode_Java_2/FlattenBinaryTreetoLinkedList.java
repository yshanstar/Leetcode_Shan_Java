public class Solution {
    public void flatten(TreeNode root) {
        if(root == null){
        	return;
        }

        ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();

        preOrder(root, nodeList);

        TreeNode tmp = nodeList.get(0);
        tmp.left = null;
        for(int i=1; i<nodeList.size(); i++){
        	tmp.right = nodeList.get(i);
        	tmp = tmp.right;
        	tmp.left = null;
        }

    }

    private void preOrder(TreeNode node, ArrayList<TreeNode> nodeList){
    	if(node == null){
    		return;
    	}

    	nodeList.add(node);
    	if(node.left != null){
    		preOrder(node.left, nodeList);
    	}

    	if(node.right != null){
    		preOrder(node.right, nodeList);
    	}
    }

    /*
    *
    *	Flatten 2
    */
    public void flatten2(TreeNode root){
    	if(root == null){
    		return;
    	}

		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		nodeStack.push(root);
		TreeNode pre = null;

		while(!nodeStack.isEmpty()){
    		TreeNode cur = nodeStack.pop();

    		if(cur.right != null){
				nodeStack.push(cur.right);
    		}

    		if(cur.left != null){
    			nodeStack.push(cur.left);
    		}

    		if(pre != null){
    			pre.left = null;
    			pre.right = cur;
    		}

    		pre = cur;
    	}
    }
}
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { 
    	val = x; 
    }
}