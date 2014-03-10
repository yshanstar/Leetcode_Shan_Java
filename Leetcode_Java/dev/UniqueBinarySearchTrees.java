package hack.leetcode.dev;
/*
 *  Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *	For example,
 *	Given n = 3, there are a total of 5 unique BST's.
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
 *	比如，以1为根的树有几个，完全取决于有二个元素的子树有几种。同理，2为根的子树取决于一个元素的子树有几个。以3为根的情况，则与1相同。
 *	定义Count[i] 为以[0,i]能产生的Unique Binary Tree的数目，
 *	如果数组为空，毫无疑问，只有一种BST，即空树，
 *	Count[0] =1
 *	如果数组仅有一个元素{1}，只有一种BST，单个节点
 *	Count[1] = 1
 *	如果数组有两个元素{1,2}， 那么有如下两种可能
	1                       2
	  \                    /
	    2                1
 *	Count[2] = Count[0] * Count[1]   (1为根的情况)
 *           + Count[1] * Count[0]  (2为根的情况。  
 */
public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
		if (n <= 1) {
			return 1;
		}
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= i - 1; j++) {
				dp[i] += dp[j] * dp[i - j - 1];
			}
		}
		
		return dp[n];
	}
}
