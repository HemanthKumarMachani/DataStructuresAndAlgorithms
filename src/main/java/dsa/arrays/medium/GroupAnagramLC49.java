package dsa.arrays.medium;

import java.util.*;

/*
49. Group Anagrams
Solved
Medium
Topics

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]

Constraints:

1 <= strs.length <= 10^4
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.


 */
public class GroupAnagramLC49 {
    public static void main(String[] args) {
        String [] input1 = {"eat","tea","tan","ate","nat","bat"};
        String [] input2 = {"eat","tea","tan","ate","bat"};
        String [] input3 = {""};
        String [] input4 = {"H"};
        List<List<String>> result = groupAnagrams(input1);
        System.out.println("Result of input1: "+result);
        result = groupAnagrams(input2);
        System.out.println("Result of input2: "+result);
        result = groupAnagrams(input3);
        System.out.println("Result of input3: "+result);
        result = groupAnagrams(input4);
        System.out.println("Result of input4: "+result);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> anagramsMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(!anagramsMap.containsKey(key)) {
                anagramsMap.put(key, new ArrayList<>());
            }
            anagramsMap.get(key).add(str);
        }
        return new ArrayList<>(anagramsMap.values());
    }
}
