import java.util.*;

/**
 * Created by haolidong on 2017/3/4.
 */
public class Solution {
    /**
     * NO.1
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * <p>
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * <p>
     * Example:
     * Given nums = [2, 7, 11, 15], target = 9,
     * <p>
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = {0, 0};
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    /**
     * NO.2
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     * <p>
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     * <p>
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        List<Integer> li1 = new ArrayList<Integer>();
        List<Integer> li2 = new ArrayList<Integer>();
        List<Integer> resultlist = new ArrayList<Integer>();
        while (l1.next != null) {
            li1.add(l1.val);
            l1 = l1.next;
        }
        li1.add(l1.val);

        while (l2.next != null) {
            li2.add(l2.val);
            l2 = l2.next;
        }
        li2.add(l2.val);
        int jinwei = 0;
        int index = li1.size() < li2.size() ? li1.size() : li2.size();
        for (int i = 0; i < index; i++) {
            resultlist.add((li1.get(i) + li2.get(i) + jinwei) % 10);
            jinwei = (li1.get(i) + li2.get(i) + jinwei) / 10;
        }
        if (li1.size() < li2.size()) {
            for (int j = index; j < li2.size(); j++) {
                resultlist.add((li2.get(j) + jinwei) % 10);
                jinwei = (li2.get(j) + jinwei) / 10;
            }
        } else {
            for (int j = index; j < li1.size(); j++) {
                resultlist.add((li1.get(j) + jinwei) % 10);
                jinwei = (li1.get(j) + jinwei) / 10;
            }
        }
        if (jinwei == 1) {
            resultlist.add(1);
        }
        Collections.reverse(resultlist);
        for (int k = 0; k < resultlist.size(); k++) {
            result = addtoList(result, resultlist.get(k));
        }
        return result;
    }

    public ListNode addtoList(ListNode nextNode, int num) {
        ListNode ln = new ListNode(num);
        ln.next = nextNode;
        return ln;
    }

    /**
     * NO.3
     * Given a string, find the length of the longest substring without repeating characters.
     * <p>
     * Examples:
     * <p>
     * Given "abcabcbb", the answer is "abc", which the length is 3.
     * <p>
     * Given "bbbbb", the answer is "b", with the length of 1.
     * <p>
     * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     * <p>
     * Subscribe to see which companies asked this question.
     */
    public int lengthOfLongestSubstring(String s) {
        String str = "";
        int maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            String charater = s.charAt(i) + "";
            int index = str.indexOf(charater);
            if (index != -1) {
                if (str.length() > maxlength) {
                    maxlength = str.length();
                }
                str = str.substring(index + 1);
                str += charater;
            } else {
                str += charater;
                if (i == s.length() - 1) {
                    if (str.length() > maxlength) {
                        maxlength = str.length();
                    }
                }
            }
        }
        return maxlength;
    }

    /**
     * NO.4
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.
     * <p>
     * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
     * <p>
     * Example 1:
     * nums1 = [1, 3]
     * nums2 = [2]
     * <p>
     * The median is 2.0
     * Example 2:
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * <p>
     * The median is (2 + 3)/2 = 2.5
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> li = new ArrayList<Integer>();
        double result = 0.0;
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                li.add(nums1[i]);
                i++;
            } else if (nums1[i] > nums2[j]) {
                li.add(nums2[j]);
                j++;
            } else {
                li.add(nums1[i]);
                li.add(nums2[j]);
                i++;
                j++;
            }
        }
        for (int k = i; k < nums1.length; k++) {
            li.add(nums1[k]);
        }
        for (int k = j; k < nums2.length; k++) {
            li.add(nums2[k]);
        }

        if (li.size() % 2 == 0) {
            int index1 = li.size() / 2;
            int num1 = li.get(index1);
            int num2 = li.get(index1 - 1);
            result = 1.0 * (num1 + num2) / 2;
        } else {
            int index1 = li.size() / 2;
            int num1 = li.get(index1);
            result = 1.0 * num1;
        }

        return result;
    }

    /**
     * NO.5
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
     * <p>
     * Example:
     * <p>
     * Input: "babad"
     * <p>
     * Output: "bab"
     * <p>
     * Note: "aba" is also a valid answer.
     * Example:
     * <p>
     * Input: "cbbd"
     * <p>
     * Output: "bb"
     */
    public String longestPalindrome(String s) {
        int start = 0;
        int maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            int k = i;
            while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
                int length = k - j + 1;
                if (length > maxlength) {
                    start = j;
                    maxlength = length;
                }
                j--;
                k++;
            }
        }
        for (int i = 0; i < s.length() - 1; i++) {
            int j = i;
            int k = i + 1;
            while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
                int length = k - j + 1;
                if (length > maxlength) {
                    start = j;
                    maxlength = length;
                }
                j--;
                k++;
            }
        }
        return s.substring(start, start + maxlength);
    }

    /**
     * NO.6
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
     * <p>
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     * Write the code that will take a string and make this conversion given a number of rows:
     * <p>
     * string convert(string text, int nRows);
     * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
     */
    public String convert(String s, int numRows) {
        int length = s.length();
        String result = "";
        char[][] chars = new char[length][numRows];
        int x = 0;
        int y = -1;
        if (numRows == 1)
            return s;
        for (int i = 0; i < s.length(); ) {
            while (y < numRows - 1 && i < s.length()) chars[x][++y] = s.charAt(i++);
            while (y > 0 && i < s.length()) chars[++x][--y] = s.charAt(i++);
        }
        for (int p = 0; p < numRows; p++) {
            for (int q = 0; q < length; q++) {
                if (chars[q][p] != '\0') {
                    result = result + chars[q][p];
                }
            }
        }
        return result;
    }
}
