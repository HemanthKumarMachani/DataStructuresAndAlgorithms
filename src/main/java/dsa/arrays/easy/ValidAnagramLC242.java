package dsa.arrays.easy;

import java.util.HashMap;
import java.util.Map;

/*
242. Valid Anagram
Solved
Easy
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

 */
public class ValidAnagramLC242 {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println("OnlyLowersResult: "+ onlyLowerCase(s, t));
        System.out.println("Result: " + isAnagram(s, t));
    }
    public static boolean onlyLowerCase(String s, String t) {
        if(s.length() != t.length()) return false;
        int [] counter = new int[26];
        for(int i=0; i<s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for(int i=0; i<26; i++) {
            if(counter[i] != 0) return false;
        }
        return true;
    }
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> sMap = new HashMap<>();
        for (int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
        }
        for (int index = 0; index < t.length(); index++) {
            char ch = t.charAt(index);
            if(!(sMap.containsKey(ch)) || sMap.get(ch) <=0) return false;
            sMap.put(ch, sMap.getOrDefault(ch, 0) - 1);
        }
        return true;
    }

}
