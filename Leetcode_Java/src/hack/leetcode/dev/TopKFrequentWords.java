package hack.leetcode.dev;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 *
 Given a list of words and an integer k, return the top k frequent words in the list.
 Example
 Given
 [
 "yes", "lint", "code",
 "yes", "code", "baby",
 "you", "baby", "chrome",
 "safari", "lint", "code",
 "body", "lint", "code"
 ]
 for k = 3, return ["code", "lint", "baby"].
 for k = 4, return ["code", "lint", "baby", "yes"],
 Note
 You should order the words by the frequency of them in the return list, the most frequent one comes first. If two words has the same frequency, the one with lower alphabetical order come first.
 Challenge
 Do it in O(nlogk) time and O(n) extra space.
 Extra points if you can do it in O(n) time with O(k) extra space.
 
 
 http://www.geeksforgeeks.org/find-the-k-most-frequent-words-from-a-file/
 
 */
public class TopKFrequentWords {
	class Node {
		String word;
		int feq;

		TrieNode trieNode;

		public Node(String str, int feq) {
			this.word = str;
			this.feq = feq;
		}
	}

	public String[] topKFrequentWords(String[] words, int k) {
		String[] res = new String[k];
		if (words == null || words.length == 0) {
			return res;
		}

		HashMap<String, Node> wordMap = new HashMap<String, Node>();

		for (String word : words) {
			if (!wordMap.containsKey(word)) {
				Node tmp = new Node(word, 1);
				wordMap.put(word, tmp);
			} else {
				Node tmp = wordMap.get(word);
				tmp.feq = tmp.feq + 1;
			}
		}

		// queue
		PriorityQueue<Node> queue = new PriorityQueue<Node>(k,
				new Comparator<Node>() {
					public int compare(Node a, Node b) {
						if (a.feq == b.feq) {
							return a.word.compareTo(b.word);
						} else {
							return b.feq - a.feq;
						}
					}
				});

		for (Map.Entry<String, Node> entry : wordMap.entrySet()) {
			queue.offer(entry.getValue());
		}

		for (int i = 0; i < k; i++) {
			res[i] = queue.poll().word;
		}

		return res;
	}

	public String[] topKFrequentWordsII(String[] words, int k) {
		String[] res = new String[k];
		if (words == null || words.length == 0) {
			return res;
		}

		HashMap<String, Node> wordMap = new HashMap<String, Node>();

		return res;
	}

	class TrieNode {
		char data;
		boolean isEndOfWord;
		int freq;
		int idxMinHeap;
		Map<Character, TrieNode> children;

		public TrieNode(char data) {
			this.children = new HashMap<Character, TrieNode>();
			this.freq = 0;
			this.idxMinHeap = -1;
			this.isEndOfWord = false;
			this.data = data;
		}

		public TrieNode children(char c) {
			return children.get(c);
		}

		public boolean isChildExist(char c) {
			return children.containsKey(c);
		}
	}

	class MinHeap {
		int size;
		int capacity;
		Node[] nodes;

		public MinHeap(int size) {
			this.nodes = new Node[size];
			this.capacity = size;
		}
	}

	class Trie {
		TrieNode root;
		MinHeap minHeap;

		public Trie(int freq) {
			root = new TrieNode(' ');
			this.minHeap = new MinHeap(freq);
		}

		public void insert(String word) {
			if (word == null || word.length() == 0) {
				return;
			}

			TrieNode current = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (!current.isChildExist(c)) {
					TrieNode node = new TrieNode(c);
					current.children.put(c, node);
				}
				current = current.children(c);
			}

			if (current.isEndOfWord) {
				current.freq++;
			} else {
				current.freq = 1;
				current.isEndOfWord = true;
			}

			insertInMinHeap(word, current);
		}

		private void insertInMinHeap(String word, TrieNode node) {
			if (node.idxMinHeap != -1) {
				this.minHeap.nodes[node.idxMinHeap].feq++;
				minHeapify(node.idxMinHeap);
			} else if (this.minHeap.size < this.minHeap.capacity) {
				++this.minHeap.size;
				Node tmp = new Node(word, node.freq);
				tmp.trieNode = node;
				tmp.trieNode.idxMinHeap = this.minHeap.size - 1;
				this.minHeap.nodes[this.minHeap.size - 1] = tmp;
				buildHeap();
			} else if (node.freq > this.minHeap.nodes[0].feq) {
				this.minHeap.nodes[0].trieNode.idxMinHeap = -1;
				this.minHeap.nodes[0].trieNode = node;
				this.minHeap.nodes[0].feq = node.freq;
				this.minHeap.nodes[0].word = word;
				node.idxMinHeap = 0;
				minHeapify(0);
			}
		}

		private void buildHeap() {
			for (int i = (this.minHeap.size - 1) / 2; i >= 0; i--) {
				minHeapify(i);
			}
		}

		/*
		 * This method is to heapify the given and make sure it satisfies the
		 * property of the node
		 */
		public void minHeapify(int node) {
			int left = (node << 1) + 1;
			int right = (node << 1) + 2;
			int smallest = node;
			if (left < this.minHeap.size
					&& this.minHeap.nodes[smallest].feq > this.minHeap.nodes[left].feq) {
				smallest = left;
			}
			if (right < this.minHeap.size
					&& this.minHeap.nodes[smallest].feq > this.minHeap.nodes[right].feq) {
				smallest = right;
			}
			if (smallest != node) {
				int index = this.minHeap.nodes[smallest].trieNode.idxMinHeap;
				this.minHeap.nodes[smallest].trieNode.idxMinHeap = this.minHeap.nodes[node].trieNode.idxMinHeap;
				this.minHeap.nodes[node].trieNode.idxMinHeap = index;
				Node temp = this.minHeap.nodes[smallest];
				this.minHeap.nodes[smallest] = this.minHeap.nodes[node];
				this.minHeap.nodes[node] = temp;
				minHeapify(smallest);
			}
		}
	}
}
