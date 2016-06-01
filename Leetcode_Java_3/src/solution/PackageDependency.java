package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * We annotate the top of our JavaScript files with directives like "require('otherfile.js'); require('otherfile2.js');" to indicate dependencies between JS files. Write code that print out script file name in the order that if A require on B, print A before B.

 Please focus on finding the proper order, not on parsing the require statements or loading files. Assume you are given input:
 - dependencies: a map from file name to an array of the names of files



 	A
   /  \
  B <- C
 Map : A -> B,C
 C->B
 You should print in the order A, C, B
 */
public class PackageDependency {
	public static List<String> resolveDependency(Map<String, List<String>> dependencies) {
		List<String> path = new ArrayList<String>();

		Set<String> allPackages = new HashSet<String>();

		// first, retrieve all packages from the dependencies
		for (String key : dependencies.keySet()) {
			if (!allPackages.contains(key)) {
				allPackages.add(key);
			}

			for (String str : dependencies.get(key)) {
				if (!allPackages.contains(str)) {
					allPackages.add(str);
				}
			}
		}

		Map<String, Integer> inDegree = new HashMap<String, Integer>();

		// construct the in degree map.
		// key is the package, value is the number of the package that relies on
		// the package.
		for (String key : dependencies.keySet()) {
			for (String dep : dependencies.get(key)) {
				if (!inDegree.containsKey(dep)) {
					inDegree.put(dep, 0);
				}

				inDegree.put(dep, inDegree.get(dep) + 1);
			}
		}

		Queue<String> queue = new LinkedList<String>();
		for (String pkg : allPackages) {
			if (!inDegree.containsKey(pkg)) {
				queue.add(pkg);
			}
		}

		// all the dependencies has circle. No solution
		if (queue.isEmpty()) {
			return path;
		}

		while (!queue.isEmpty()) {
			String pkg = queue.poll();
			path.add(pkg);

			if (!dependencies.containsKey(pkg)) {
				continue;
			}

			for (String dep : dependencies.get(pkg)) {
				int in = inDegree.get(dep) - 1;
				if (in == 0) {
					inDegree.remove(dep);
					queue.offer(dep);
				} else {
					inDegree.put(dep, in);
				}
			}
		}

		if (path.size() != allPackages.size()) {
			return new ArrayList<String>();
		}

		return path;
	}

	public static void main(String[] args) {

		Map<String, List<String>> dependencies = new HashMap<String, List<String>>();
		// situation 1
		// A->B,C
		// C->B
		String[] aDependencies = new String[] { "B", "C" };
		String[] cDependencies = new String[] { "B" };
		dependencies.put("A", Arrays.asList(aDependencies));
		dependencies.put("C", Arrays.asList(cDependencies));

		List<String> path = resolveDependency(dependencies);
		System.out.println(Arrays.toString(path.toArray())); // [A, C, B]

		// situation 2
		// A->B,C
		// C->A
		dependencies.clear();
		aDependencies = new String[] { "B", "C" };
		cDependencies = new String[] { "A" };
		dependencies.put("A", Arrays.asList(aDependencies));
		dependencies.put("C", Arrays.asList(cDependencies));
		path = resolveDependency(dependencies);
		System.out.println(Arrays.toString(path.toArray())); // []

		// situation 3
		// A->[]
		// C->[]
		dependencies.clear();
		aDependencies = new String[] {};
		cDependencies = new String[] {};
		dependencies.put("A", Arrays.asList(aDependencies));
		dependencies.put("C", Arrays.asList(cDependencies));
		path = resolveDependency(dependencies);
		System.out.println(Arrays.toString(path.toArray())); // [A, C]

		// situation 3
		// A->[]
		// B->[A]
		// C->[A]
		dependencies.clear();
		aDependencies = new String[] {};
		cDependencies = new String[] { "A" };
		dependencies.put("A", Arrays.asList(aDependencies));
		dependencies.put("B", Arrays.asList(cDependencies));
		dependencies.put("C", Arrays.asList(cDependencies));
		path = resolveDependency(dependencies);
		System.out.println(Arrays.toString(path.toArray())); // [B, C, A]

	}
}
