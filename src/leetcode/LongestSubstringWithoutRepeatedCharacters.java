package leetcode;

import java.util.HashMap;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatedCharacters {

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatedCharacters o = new LongestSubstringWithoutRepeatedCharacters();
		System.out.println(o.lengthOfLongestSubstring("")); // 0
		System.out.println(o.lengthOfLongestSubstring("a")); // 1
		System.out.println(o.lengthOfLongestSubstring("abcabcbb")); // 3
		System.out.println(o.lengthOfLongestSubstring("bbbbb")); // 1
		System.out.println(o.lengthOfLongestSubstring("pwwkew")); // 3
		System.out.println(o.lengthOfLongestSubstring("abba")); // 2
	}

	public int lengthOfLongestSubstring(String s) {

		if (s.isEmpty())
		{
			return 0;
		}

		HashMap<Character, Integer> lastSeenAt = new HashMap<Character, Integer>();
		char[] arr = s.toCharArray();
		int [] substringLength = new int[arr.length];
		substringLength[0] = 1;
		lastSeenAt.put(arr[0], 0);
		int ans = 1;

		for(int i = 1; i<arr.length; i++)
		{
			char cur = arr[i];
			if (lastSeenAt.containsKey(cur))
			{
				int lastSeenIndex = lastSeenAt.get(cur);
				substringLength[i] = Math.min(i - lastSeenIndex, substringLength[i-1] + 1);
			}
			else
			{
				substringLength[i] = substringLength[i-1] + 1;
			}

			lastSeenAt.put(cur, i);
			ans = Math.max(ans, substringLength[i]);
		}

		return ans;
	}
}
