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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null){
			return head;
        }

        if(m>=n){
        	return head;
        }

        ListNode preM = null;
        ListNode M = head;
        ListNode N = head;
        ListNode afterN = N.next;

        int count = 1;
        while(count < n ){
        	N = afterN;
        	afterN = (afterN.next != null)? afterN.next : null;
        	if(count < m){
        		preM = M;
        		M = M.next;
        	}else{
        		N.next = M;
        		M = N;
        	}
        	count++;
        	if(count == m){
        		M.next = null;
        	}
        }

        if(preM == null && afterN == null){
        	head.next = null;
        	return N;
        }else if (afterN == null){
        	preM.next = N;
        	return head;
        }

        if(preM == null){
        	head.next = afterN;
        	return N;
        }

        preM.next.next = afterN;
		preM.next = N;

		return head;

    }
}