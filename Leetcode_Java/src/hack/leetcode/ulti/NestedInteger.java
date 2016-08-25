package hack.leetcode.ulti;

import java.util.List;

public abstract class NestedInteger {

	// Constructor initializes an empty nested list.
	public NestedInteger() {
	}

	// Constructor initializes a single integer.
	public NestedInteger(int value) {
	}

	// @return true if this NestedInteger holds a single integer, rather than a
	// nested list.
	public abstract boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a
	// single integer
	// Return null if this NestedInteger holds a nested list
	public abstract Integer getInteger();

	// Set this NestedInteger to hold a single integer.
	public abstract void setInteger(int value);

	// Set this NestedInteger to hold a nested list and adds a nested integer to
	// it.
	public abstract void add(NestedInteger ni);

	// @return the nested list that this NestedInteger holds, if it holds a
	// nested list
	// Return null if this NestedInteger holds a single integer
	public abstract List<NestedInteger> getList();
}
