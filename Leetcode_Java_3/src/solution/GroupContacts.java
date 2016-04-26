package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Given an array of contacts with name/emails you should detect and union identical contacts. 

 For example, given the following contacts array: 

 {
 { "John", {"john@gmail.com"} },
 { "Mary", {"mary@gmail.com"} },
 { "John", {"john@yahoo.com"} },
 { "John", {"john@gmail.com", "john@yahoo.com", "john@hotmail.com"} },
 { "Bob",  {"bob@gmail.com"} }
 }

 We can see that john1985, John and john123 are the same person by their contact information. 

 We should output 

 [[ 0, 2, 3], [1]] (0,2,3 are the same person and 1 is another one)
 */
public class GroupContacts {
	public List<List<Contact>> groupContact(List<Contact> contacts) {
		List<List<Contact>> res = new ArrayList<List<Contact>>();

		int size = contacts.size();

		UnionFind uf = new UnionFind(size);

		Map<String, List<Integer>> emails = new HashMap<String, List<Integer>>();
		for (int i = 0; i < size; i++) {
			Contact tmp = contacts.get(i);
			for (String email : tmp.emails) {
				if (!emails.containsKey(email)) {
					List<Integer> idxList = new ArrayList<Integer>();
					idxList.add(i);
					emails.put(email, idxList);
				} else {
					emails.get(email).add(i);
				}
			}
		}

		for (Entry<String, List<Integer>> entry : emails.entrySet()) {
			List<Integer> idxList = entry.getValue();

			for (int i = 0; i < idxList.size() - 1; i++) {
				uf.union(idxList.get(i), idxList.get(i + 1));
			}
		}

		Map<Integer, List<Integer>> groups = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < size; i++) {
			int parent = uf.find(i);
			if (!groups.containsKey(parent)) {
				List<Integer> idxs = new ArrayList<Integer>();
				idxs.add(i);
				groups.put(parent, idxs);
			} else {
				groups.get(parent).add(i);
			}
		}

		for (Entry<Integer, List<Integer>> entry : groups.entrySet()) {
			List<Integer> idxList = entry.getValue();
			List<Contact> group = new ArrayList<Contact>();

			for (int i = 0; i < idxList.size(); i++) {
				group.add(contacts.get(idxList.get(i)));
			}
			res.add(group);
		}

		return res;
	}

	public static void main(String[] args) {
		GroupContacts test = new GroupContacts();
		List<Contact> contacts = new ArrayList<Contact>();
		List<String> emailList = new ArrayList<String>();
		emailList.add("john@gmail.com");
		contacts.add(new Contact("John", emailList));
		emailList.add("john@yahoo.com");
		emailList.add("john@hotmail.com");
		contacts.add(new Contact("John", emailList));

		emailList = new ArrayList<String>();
		emailList.add("mary@yahoo.com");
		contacts.add(new Contact("Mary", emailList));

		emailList = new ArrayList<String>();
		emailList.add("bob@yahoo.com");
		contacts.add(new Contact("Bob", emailList));
		emailList.add("bob@gmail.com");
		contacts.add(new Contact("Bob", emailList));

		List<List<Contact>> groups = test.groupContact(contacts);

		for (List<Contact> group : groups) {
			System.out.println("Group:");
			for (Contact c : group) {
				System.out.println(c.toString());
			}
		}
	}

	class UnionFind {
		List<Integer> parents;
		List<Integer> ranks;

		public UnionFind(int size) {
			this.parents = new ArrayList<Integer>();
			this.ranks = new ArrayList<Integer>();

			for (int i = 0; i < size; i++) {
				parents.add(i);
				ranks.add(0);
			}
		}

		public int find(int x) {
			if (parents.get(x) != x) {
				return find(parents.get(x));
			}
			return x;
		}

		public void union(int x, int y) {
			int i = find(x);
			int j = find(y);

			if (i == j) {
				return;
			}

			if (ranks.get(i) < ranks.get(j)) {
				parents.set(i, j);
			} else {
				parents.set(j, i);
				if (ranks.get(i) == ranks.get(j)) {
					ranks.set(x, ranks.get(x) + 1);
				}
			}
		}
	}
}

class Contact {
	String name;
	List<String> emails;

	public Contact(String name) {
		this.name = name;
		this.emails = new ArrayList<String>();
	}

	public Contact(String name, List<String> emails) {
		this.name = name;
		this.emails = new ArrayList<String>(emails);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.name + ": ");
		for (String email : emails) {
			sb.append(email + ",");
		}

		return sb.toString().substring(0, sb.length() - 1);
	}
}
