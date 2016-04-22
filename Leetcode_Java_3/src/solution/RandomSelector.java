package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * So with each item store a number that marks its relative probability, 
 * for example if you have 3 items one should be twice as likely to be selected as either of the other two then your list will have:

 [{A,1},{B,1},{C,2}]
 Then sum the numbers of the list (i.e. 4 in our case). Now generate a random number and choose that index. int index = rand.nextInt(4); return the number such that the index is in the correct range.
 */
public class RandomSelector {
	List<ItemEle> elements;
	Random rand = new Random();
	int totalSum = 0;

	public RandomSelector(List<ItemEle> elements) {
		this.elements = elements;
		for (ItemEle e : elements) {
			totalSum += e.prob;
		}
	}

	public ItemEle select() {
		int random = rand.nextInt(this.totalSum);
		int sum = 0;
		int i = 0;

		while (sum < random) {
			sum = sum + elements.get(i++).prob;
		}

		return elements.get(Math.max(0, i - 1));
	}

	public static void main(String[] args) {
		List<ItemEle> nums = new ArrayList<ItemEle>();
		nums.add(new ItemEle(1, 1));
		nums.add(new ItemEle(2, 5));
		nums.add(new ItemEle(3, 2));
		nums.add(new ItemEle(4, 1));

		RandomSelector test = new RandomSelector(nums);

		for (int i = 0; i < 100; i++) {
			System.out.println(test.select().toString());
		}
	}
}

class ItemEle {
	int value;
	int prob;

	public ItemEle(int value, int prob) {
		this.prob = prob;
		this.value = value;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.value + ": " + this.prob);
		return sb.toString();
	}
}