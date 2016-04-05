package hack.leetcode.dev;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

import javax.management.RuntimeErrorException;

/*
 * Write a deep iterator to iterate through a list of objects or integer which could be another list or integer. This is frequently asked by LinkedIn, Twitter and Hulu. 


 For example, this collection contains Integer or another collection. L means it is a collection that contains either integer or another L. 

						   ----> 5
						   |
		   ---- 3 -> 4  -> L  -> 6
		   |
 1 -> 2 -> L -> 7-> 8

 We would expect an iterator to loop through it will print out 1, 2, 3, 4, 5, 6, 7, 8 

 */
public class DeepIterator implements Iterator<Integer> {
	private Stack<Iterator> iteratorStack;
	private Integer top;
	
	public DeepIterator(Iterable iterable){
		iteratorStack = new Stack<Iterator>();
		iteratorStack.push(iterable.iterator());
	}
	

	@Override
	public boolean hasNext() {
		if(this.top != null){
			return true;
		}
		
		while(!iteratorStack.isEmpty()){
			Iterator tmp = iteratorStack.peek();
			
			if(tmp.hasNext()){
				Object tmpObj = tmp.next();
				if(tmpObj instanceof Integer){
					this.top = (Integer) tmpObj;
					return true;
				}else if (tmpObj instanceof Iterable){
					this.iteratorStack.push(((Iterable) tmpObj).iterator());
				}else{
					throw new RuntimeErrorException(null, "Unsupported data type");
				}
			}else{
				this.iteratorStack.pop();
			}
		}
		
		return false;
	}

	@Override
	public Integer next()throws NoSuchElementException {
		if(hasNext()){
			Integer tmp = this.top;
			this.top = null;
			return tmp;
		}

		throw new NoSuchElementException();
	}
	
	@Override
	public void remove() {
		throw new UnsupportedOperationException("This is not supported right now.");
	}
	
	
	public static void main(String[] args) {
		List sub2 = new LinkedList();
		sub2.add(5);
		
		List sub1 = new LinkedList();
		sub1.add(3);
		sub1.add(4);
		sub1.add(sub2);
		sub1.add(6);
		
		List list = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(sub1);
		list.add(7);
		list.add(8);

		List<Integer> newList = new LinkedList<Integer>();
		DeepIterator di = new DeepIterator(list);

		while (di.hasNext()) {
			System.out.println(di.next());
		}
	}
}
