package hack.leetcode.dev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Design a data structure that supports all following operations in average O(1) time.

 Note: Duplicate elements are allowed.
 insert(val): Inserts an item val to the collection.
 remove(val): Removes an item val from the collection if present.
 getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
 Example:

 // Init an empty collection.
 RandomizedCollection collection = new RandomizedCollection();

 // Inserts 1 to the collection. Returns true as the collection did not contain 1.
 collection.insert(1);

 // Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
 collection.insert(1);

 // Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
 collection.insert(2);

 // getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
 collection.getRandom();

 // Removes 1 from the collection, returns true. Collection now contains [1,2].
 collection.remove(1);

 // getRandom should return 1 and 2 both equally likely.
 collection.getRandom();


 https://discuss.leetcode.com/topic/53717/clean-o-1-java-solution-with-hashmap-and-set

 */
public class RandomizedCollection {
	List<Integer> nums;
	Map<Integer, LinkedHashSet<Integer>> map;

	/** Initialize your data structure here. */
	public RandomizedCollection() {
		this.nums = new ArrayList<Integer>();
		this.map = new HashMap<Integer, LinkedHashSet<Integer>>();
	}

	/**
	 * Inserts a value to the collection. Returns true if the collection did not
	 * already contain the specified element.
	 */
	public boolean insert(int val) {
		boolean exist = contains(val);
		if (!exist) {
			this.map.put(val, new LinkedHashSet<Integer>());
		}
		this.map.get(val).add(this.nums.size());
		this.nums.add(val);

		return !exist;
	}

	/**
	 * Removes a value from the collection. Returns true if the collection
	 * contained the specified element.
	 */
	public boolean remove(int val) {
		if (!contains(val)) {
			return false;
		}

		LinkedHashSet<Integer> valSet = this.map.get(val);
		int idxToReplace = valSet.iterator().next();

		int tmpVal = this.nums.get(this.nums.size() - 1);
		LinkedHashSet<Integer> replaceWith = this.map.get(tmpVal);

		this.nums.set(idxToReplace, tmpVal);
		valSet.remove(idxToReplace);

		if (idxToReplace != this.nums.size() - 1) {
			replaceWith.remove(this.nums.size() - 1);
			replaceWith.add(idxToReplace);
		}

		this.nums.remove(this.nums.size() - 1);

		if (valSet.isEmpty()) {
			this.map.remove(val);
		}

		return true;
	}

	/** Get a random element from the collection. */
	public int getRandom() {
		if (this.nums.isEmpty()) {
			return Integer.MIN_VALUE;
		}

		return this.nums.get((int) (Math.random() * this.nums.size()));
	}

	private boolean contains(int val) {
		return this.map.containsKey(val);
	}
}
