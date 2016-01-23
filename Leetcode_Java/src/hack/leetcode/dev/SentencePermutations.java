package hack.leetcode.dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SentencePermutations {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		scanner.close();
		
		String s = removeGroups(input);
		List<List<String>> groups = extractGroups(input);

		permutations(new ArrayList<>(), 0, groups, s);
	}

	public static void permutations(List<String> permutation, int groupIndex, List<List<String>> groups, String s) {
		if (groupIndex == groups.size()) {
			String pattern = "#";
			String result = s;
			for(String str : permutation){
				result = result.replaceFirst(pattern, str);
			}
			System.out.println(result);
			return;
		}

		for (String element : groups.get(groupIndex)) {
			List<String> newPermute = new ArrayList<>(permutation);
			newPermute.add(element);

			permutations(newPermute, groupIndex + 1, groups, s);
		}
	}

	public static List<List<String>> extractGroups(String value) {

		List<List<String>> groups = new ArrayList<>();

		String regex = "\\{([^\\}]+)}";
		Matcher matcher = Pattern.compile(regex).matcher(value);

		while (matcher.find()) {
			groups.add(Arrays.stream(matcher.group(1).split(",")).map(s -> s.trim()).collect(Collectors.toList()));
		}

		return groups;
	}
	
	public static String removeGroups(String value) {
		String regex = "\\{([^\\}]+)}";
		value = value.replaceAll(regex, "#");

		return value;
	}
}
