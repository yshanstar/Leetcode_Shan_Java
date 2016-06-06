/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
    	if(lists == null || lists.size() == 0){
			return null;
    	}else if (lists.size() ==1){
    		return lists.get(0);
    	}

    	Comparator<ListNode> nodeComparator = new Comparator<ListNode>(){
    		public int compare(ListNode node1, ListNode node2){
    			return node1.val - node2.val;
    		}
    	};

    	PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(lists.size(), nodeComparator);

    	for(ListNode n : lists){
    		if(n != null){
    			minHeap.add(n);
    		}
    	}

    	ListNode newHead = null;
    	ListNode cur = null;

    	while(!minHeap.isEmpty()){
    		if(newHead == null){
    			newHead = minHeap.poll();
    			cur = newHead;
    		}else{
    			ListNode tmp = minHeap.poll();
    			cur.next = tmp;
    			cur = tmp;
    		}
    		if(cur.next != null){
    			minHeap.add(cur.next);
    		}
    	}


    	return newHead;
    }
}