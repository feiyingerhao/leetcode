import java.util.*;

/**
 * Created by haolidong on 2017/3/4.
 */
public class Solution {
    /**
     * NO.1 Two Sum
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
     * NO.2 Add Two Numbers
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
 * NO.3 Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 Subscribe to see which companies asked this question.
 * */
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
 * NO.5 Longest Palindromic Substring
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
 * NO.6 ZigZag Conversion
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:
>>>>>>> 2736f461d16d3e7839f8ecfa7e0e0579221b831e

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
/**
 * NO.7 Reverse Integer
 * Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321

 click to show spoilers.

 Note:
 The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.

 Subscribe to see which companies asked this question.
 * */
    public int reverse(int x) {
        int result;
        long resultlong=0L;
        while (x!=0){
            int lastnum = x%10;
            resultlong = resultlong*10 + lastnum;
            x = x / 10;
        }
        if(resultlong>Integer.MAX_VALUE||resultlong<Integer.MIN_VALUE){
            result = 0;
        }else{
            result = (int)resultlong;
        }
        return result;
    }

/**
 * NO.8 String to Integer (atoi)
 * Implement atoi to convert a string to an integer.

 Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

 Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

 Update (2015-02-10):
 The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
 * */
    public int myAtoi(String str) {
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        int result=0;
        int flag=1;
        int count = 0;
        str = str.trim();
        long resultlong = 0L;
        map.put('0',0);
        map.put('1',1);
        map.put('2',2);
        map.put('3',3);
        map.put('4',4);
        map.put('5',5);
        map.put('6',6);
        map.put('7',7);
        map.put('8',8);
        map.put('9',9);
        if(str.equals(""))
            return 0;
        if(str.charAt(0)=='+'||str.charAt(0)=='-'){
            if(str.charAt(0)=='-'){
                flag = -1;
            }
            str = str.substring(1);
        }
        if(str.equals(""))
            return 0;
        for (int i = 0;i < str.length();i++){
            if(!map.containsKey(str.charAt(i)))
                break;
            resultlong = resultlong*10 + map.get(str.charAt(i));
            if(resultlong*flag>Integer.MAX_VALUE){
                result = Integer.MAX_VALUE;
                return result;
            }else if(resultlong*flag<Integer.MIN_VALUE){
                result = Integer.MIN_VALUE;
                return result;
            }

        }
        resultlong = resultlong * flag;
        if(resultlong>Integer.MAX_VALUE){
            result = Integer.MAX_VALUE;
        }else if(resultlong<Integer.MIN_VALUE){
            result = Integer.MIN_VALUE;
        } else {
            result = (int)resultlong;
        }
        return result;
    }
/**
 * NO.9 Palindrome Number
 * Determine whether an integer is a palindrome. Do this without extra space.
 * */
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        int length = (x+"").length();
        for (int i = 0;i < length;i++){
            int high =((int) (x/Math.pow(10,length-i-1)))%10;
            int low = ((int) (x/Math.pow(10,i)))%10;
            if(high!=low){
                return false;
            }
        }
        return true;
    }
/**
 * NO.10.Failure Regular Expression Matching
 *'.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "a*") → true
 isMatch("aa", ".*") → true
 isMatch("ab", ".*") → true
 isMatch("aab", "c*a*b") → true
 * */
public boolean isMatch_Failure(String s, String p) {
    List<String> pattern = new ArrayList<String>();
    putIntoArray(p,pattern);
    int patternIndex = 0;
    if(s.length()==0&&pattern.size()==0){
        return true;
    } else if(s.length()==0&&pattern.size()!=0){
        return true;
    } else if(s.length()!=0&&pattern.size()==0){
        return false;
    } else{
        for (int i = 0;i < s.length();){
            if(patternIndex < pattern.size()){
                int status = strcompare(""+s.charAt(i),pattern.get(patternIndex));
                if(status == 1){
                    i++;
                } else if(status == 2){
                    patternIndex++;
                } else if(status == 3){
                    i++;
                    patternIndex++;
                } else if(status == 4){
                    return false;
                }
            }else{
                return false;
            }
        }
        while (patternIndex<pattern.size()){
            String lastpattern = pattern.get(patternIndex);
            if(lastpattern.contains("*")){
                patternIndex++;
                continue;
            }else{
                if((pattern.get(patternIndex).charAt(0)==pattern.get(patternIndex-1).charAt(0)||pattern.get(patternIndex-1).charAt(0)=='.')&&pattern.get(patternIndex-1).contains("*")){
                    patternIndex++;
                    continue;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}

    public void putIntoArray(String p,List<String> pattern){
        for (int i=0;i<p.length();){
            if(i+1<p.length()){
                if(p.charAt(i+1)=='*'){
                    pattern.add(""+p.charAt(i)+p.charAt(i+1));
                    i=i+2;
                }else{
                    pattern.add(""+p.charAt(i));
                    i=i+1;
                }
            } else {
                pattern.add(""+p.charAt(i));
                i=i+1;
            }
        }
    }
//1 表示匹配成功，pattern不需要向后移动，字符向后移动
//2 表示*匹配失败，pattern向后移动,字符不需要向后移动
//3 表示匹配成功,pattern需要向后移动，字符需要向后移动
//4 表示匹配失败，最终结果为false
    public int strcompare(String pi,String pat){
        if(pat.contains("*")){
            if(pat.equals(".*")){
                return 1;
            } else {
                if(pi.equals(pat.charAt(0)+"")){
                    return 1;
                }else {
                    return 2;
                }
            }
        }else{
            if(pi.equals(pat)){
                return 3;
            } else {
               if(pat.equals(".")){
                   return 3;
               } else {
                   return 4;
               }
            }
        }
    }

    public boolean singleStrCmp(String s1,String p1){
        for (int i=0;i<s1.length();i++){
            if(s1.charAt(i)==p1.charAt(i)||p1.charAt(i)=='.'){
                continue;
            }else {
                return false;
            }
        }
        return true;
    }
    /**
     * NO.10  From Internet
     *'.' Matches any single character.
     '*' Matches zero or more of the preceding element.

     The matching should cover the entire input string (not partial).

     The function prototype should be:
     bool isMatch(const char *s, const char *p)

     Some examples:
     isMatch("aa","a") → false
     isMatch("aa","aa") → true
     isMatch("aaa","aa") → false
     isMatch("aa", "a*") → true
     isMatch("aa", ".*") → true
     isMatch("ab", ".*") → true
     isMatch("aab", "c*a*b") → true
     * */
    public boolean isMatch(String s, String p) {
        if (p.length() == 0)
            return s.length() == 0;

        // length == 1 is the case that is easy to forget.
        // as p is subtracted 2 each time, so if original
        // p is odd, then finally it will face the length 1
        if (p.length() == 1)
            return (s.length() == 1) && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');

        // next char is not '*': must match current character
        if (p.charAt(1) != '*') {
            if (s.length() == 0)
                return false;
            else
                return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
                        && isMatch(s.substring(1), p.substring(1));
        }else{
            // next char is *
            while (s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
                if (isMatch(s, p.substring(2)))
                    return true;
                s = s.substring(1);
            }
            return isMatch(s, p.substring(2));
        }
    }
    /**
     * NO.10.MySelf
     *'.' Matches any single character.
     '*' Matches zero or more of the preceding element.

     The matching should cover the entire input string (not partial).

     The function prototype should be:
     bool isMatch(const char *s, const char *p)

     Some examples:
     isMatch("aa","a") → false
     isMatch("aa","aa") → true
     isMatch("aaa","aa") → false
     isMatch("aa", "a*") → true
     isMatch("aa", ".*") → true
     isMatch("ab", ".*") → true
     isMatch("aab", "c*a*b") → true
     * */

    public boolean isMatchNew(String s, String p) {
        if(s.length()==0){
            if(p.length()==0)
                return true;
            else if(p.length()==1)
                return false;
            else {
                if(p.charAt(1)=='*')
                    return isMatchNew(s,p.substring(2));
                else
                    return false;
            }
        }
        else if(s.length() == 1){
            if(p.length()==0)
                return false;
            else if(p.length()==1)
                return p.charAt(0)==s.charAt(0)||p.charAt(0)=='.';
            else{
                if(p.charAt(1)=='*'){
                    if(p.charAt(0)==s.charAt(0)||p.charAt(0)=='.'){
                        if(isMatchNew(s,p.substring(2)))
                            return true;
                        else
                            return isMatchNew(s.substring(1),p);
                    }else{
                        return isMatchNew(s,p.substring(2));
                    }
                }else {
                    if(p.charAt(0)==s.charAt(0)||p.charAt(0)=='.')
                        return isMatchNew(s.substring(1),p.substring(1));
                    else
                        return false;
                }
            }
        }
        else {
            if(p.length()==0||p.length()==1){
                return false;
            } else{
                if(p.charAt(1)=='*'){
                    if(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.')
                        if(isMatchNew(s,p.substring(2)))
                            return true;
                        else {
                            return isMatchNew(s.substring(1),p);
                        }
                    else
                        return isMatchNew(s,p.substring(2));
                } else {
                    if(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.')
                        return isMatchNew(s.substring(1),p.substring(1));
                    else
                        return false;
                }
            }
        }
    }
/**
 * NO.11.Failure
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

 Note: You may not slant the container and n is at least 2.

 Subscribe to see which companies asked this question.
 * */
    public int maxArea_f(int[] height) {
        int area = 0;
        for (int i = 0;i < height.length-1;i++){
            for (int j = i+1;j < height.length;j++){
                area=Math.max(Math.min(height[i],height[j])*(j-i),area);
            }
        }
        return area;
    }
/**
 * NO.11 Container With Most Water
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

 Note: You may not slant the container and n is at least 2.

 Subscribe to see which companies asked this question.
 * */
    public int maxArea(int[] height){
        int area = 0;
        int left = 0;
        int right = height.length-1;
        boolean flag = true;//flag right或者是right更新的标志
        while (left < right && flag){
            area = Math.max(area,Math.min(height[left],height[right])*(right-left));
            flag = false;
            if(height[left]<height[right]){
                for (int i = left+1;i<right;i++){
                    if(height[i]>height[left]){
                        left = i;
                        flag = true;
                        break;
                    }
                }
            } else {
                for (int i = right-1;i>left;i--){
                    if(height[i]>height[right]){
                        right = i;
                        flag = true;
                        break;
                    }
                }
            }
        }
        return area;
    }
/**
 * NO.12 Integer to Roman
 * Given an integer, convert it to a roman numeral.

 Input is guaranteed to be within the range from 1 to 3999.

 Subscribe to see which companies asked this question.[1 4 5 9 10....]
 M 1000
 CM 900
 D 500
 CD 400
 C 100
 XC 90
 L 50
 XL 40
 X 10
 IX 9
 V 5
 IV 4
 I 1
 * */
    public String intToRoman(int num) {
        String[] charters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] nums ={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String result = "";
        for (int i = 0;i < nums.length;i++){
            while (num>=nums[i]){
                num -= nums[i];
                result += charters[i];
            }
        }
        return result;
    }
/**
 * NO.13 Roman to Integer
 * Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.

 Subscribe to see which companies asked this question.

 Show Tags
 Show Similar Problems
 * */
    public int romanToInt(String s) {
        String[] charters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] nums ={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        int result = 0;
        boolean flag = true;
        for (int i = 0;i < charters.length;i++){
            flag = true;
            while (flag){
                if(charters[i].length()==2){
                    if(s.length()>=2){
                        String tmps = s.substring(0,2);
                        if(tmps.equals(charters[i])){
                            s=s.substring(2);
                            result+=nums[i];
                        }

                        else
                            flag = false;
                    } else {
                            flag=false;
                    }
                } else {
                    if(s.length()>=1){
                        String tmps = s.substring(0,1);
                        if(tmps.equals(charters[i])){
                            s = s.substring(1);
                            result+=nums[i];
                        }

                        else
                            flag = false;
                    }else{
                        flag = false;
                    }
                }
            }
        }
        return result;
    }

/**
 * NO.14 Longest Common Prefix
 Write a function to find the longest common prefix string amongst an array of strings.

 Subscribe to see which companies asked this question.
 * */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
            return "";
        String prefix = strs[0];
        for (int i = 1;i < strs.length;i++){
            int j = 0;
            while (j<prefix.length()&&j<strs[i].length()&&(strs[i].charAt(j) == prefix.charAt(j))){
                j++;
            }
            prefix = prefix.substring(0,j);
        }
        return prefix;
    }
/**
 * NO.15 3SUM
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note: The solution set must not contain duplicate triplets.

 For example, given array S = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 * */
    public List<List<Integer>> twoSum(int[] nums){
        if(nums.length<2)
            return null;
        List<Integer> li = new ArrayList<Integer>();
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        for (int i = 0;i<nums.length;i++){
            li.add(nums[i]);
        }
        Collections.sort(li);
        int left = 0;
        int right = li.size()-1;
        while (left<right){
            if(li.get(left)+li.get(right)>0){
                right--;
            } else if(li.get(left)+li.get(right)<0) {
                left++;
            }else{
                List<Integer> list = new ArrayList<Integer>();
                list.add(li.get(left));
                list.add(li.get(right));
                results.add(list);
                left++;
                right--;
            }
        }
        return results;
    }
    public List<List<Integer>> threeSum_TimeOut(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        if(nums.length<3)
            return results;
        for (int i = 0;i < nums.length;i++){
            int target = nums[i];
            List<Integer> li = new ArrayList<Integer>();
            for (int j = 0;j<nums.length;j++){
                if(j==i)
                    continue;
                li.add(nums[j]);
            }
            Collections.sort(li);
            int left = 0;
            int right = li.size()-1;
            while (left<right){
                if(li.get(left)+li.get(right)+target>0){
                    right--;
                } else if(li.get(left)+li.get(right)+target<0) {
                    left++;
                }else{
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(li.get(left));
                    list.add(li.get(right));
                    list.add(target);
                    Collections.sort(list);
                    if(!set.contains(list)){
                        results.add(list);
                        set.add(list);
                    }
                    left++;
                    right--;
                }
            }
        }
        return results;
    }
    public boolean threeSumExist(List<List<Integer>> results,List<Integer> elements){
        for (int i = 0;i < results.size();i++){
            if(
                    results.get(i).get(0)==elements.get(0)&&
                            results.get(i).get(1)==elements.get(1)&&
                            results.get(i).get(2)==elements.get(2)){
                return true;
            }else {
                continue;
            }
        }
        return false;
    }
//-1 0 2 3 4
    public List<List<Integer>> threeSum_fail(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> li = new ArrayList<Integer>();
        for (int j = 0;j<nums.length;j++){
            li.add(nums[j]);
        }
        Collections.sort(li);
        for (int i = 0;i < li.size();i++){
            while(i > 0 && i < li.size() && li.get(i) == li.get(i-1))
                i ++;
            int target = li.get(i);
            int left = i+1;
            int right = li.size()-1;
            while (left<right){
                if(li.get(left)+li.get(right)+target>0){
                    right--;
                    while(left < right &&li.get(right)==li.get(right+1))
                        right --;
                } else if(li.get(left)+li.get(right)+target<0) {
                    left++;
                    while(left < right && li.get(left)==li.get(left-1))
                        left ++;
                }else{
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(li.get(left));
                    list.add(li.get(right));
                    list.add(target);
                    Collections.sort(list);
                    results.add(list);
                    left++;
                    right--;
                    while(left < right && li.get(left)==li.get(left-1))
                        left ++;
                    while(left < right &&li.get(right)==li.get(right+1))
                        right --;
                }
            }
        }
        return results;
    }
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> results = new ArrayList<List<Integer>>();
//        List<Integer> li = new ArrayList<Integer>();
//        for (int j = 0;j<nums.length;j++){
//            li.add(nums[j]);
//        }
//        Collections.sort(li);
//        for(int i = 0; i < li.size(); i ++)
//        {
//            //srightip same i
//            while(i > 0 && i < li.size() && li.get(i) == li.get(i-1))
//                i ++;
//            int left = i + 1;
//            int right = li.size() - 1;
//            while(left < right)
//            {
//                int sum =li.get(i) + li.get(left) + li.get(right);
//                if(sum == 0)
//                {
//                    List<Integer> list = new ArrayList<Integer>();
//                    list.add(li.get(i));
//                    list.add(li.get(left));
//                    list.add(li.get(right));
//                    results.add(li);
//                    left ++;
//                    right --;
//                    //srightip same left
//                    while(left < right && li.get(left) == li.get(left)-1)
//                        left ++;
//                    //srightip same right
//                    while(right > left && li.get(right) ==li.get(right+1))
//                        right --;
//                }
//                else if(sum < 0)
//                {
//                    left ++;
//                    //srightip same left
//                    while(left < right && li.get(left) == li.get(left)-1)
//                        left ++;
//                }
//                else
//                {
//                    right --;
//                    while(right > left && li.get(right) ==li.get(right+1))
//                        right --;
//                }
//            }
//        }
//        return results;
//    }

//  li.get(i)==li.get(i-1) 因为是integer的类型，所以要显示转化为int，才能进行比较，否则会报错
    /**
    public static Integer valueOf(int i) {
               assert IntegerCache.high >= 127;
              if (i >= IntegerCache.low && i <= IntegerCache.high)
                     return IntegerCache.cache[i + (-IntegerCache.low)];
               return new Integer(i);
    }
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if(nums.length<3)
            return results;
        List<Integer> li = new ArrayList<Integer>();
        for (int j = 0;j<nums.length;j++){
            li.add(nums[j]);
        }
        Collections.sort(li);
        for (int i = 0;i < li.size()-1;i++){
            while(i > 0 && i < li.size()-1 && li.get(i).intValue() == li.get(i-1).intValue())
                i ++;
            int target = li.get(i).intValue();
            int left = i+1;
            int right = li.size()-1;
            while (left<right){
                if(li.get(left).intValue()+li.get(right).intValue()+target>0){
                    right--;
                    while(left < right &&li.get(right).intValue()==li.get(right+1).intValue())
                        right --;
                } else if(li.get(left).intValue()+li.get(right).intValue()+target<0) {
                    left++;
                    while(left < right && li.get(left).intValue()==li.get(left-1).intValue())
                        left ++;
                }else{
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(li.get(left).intValue());
                    list.add(li.get(right).intValue());
                    list.add(target);
                    results.add(list);
                    left++;
                    right--;
                    while(left < right && li.get(left).intValue()==li.get(left-1).intValue())
                        left ++;
                    while(left < right &&li.get(right).intValue()==li.get(right+1).intValue())
                        right --;
                }
            }
        }
        return results;
    }
/**
 * NO.16 3Sum Closest
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * */
    public int threeSumClosest(int[] nums, int target) {
        int size = nums.length;
        Arrays.sort(nums);
        int diff=Integer.MAX_VALUE;
        int closenum = 0;
        for (int i = 0;i < size ; i++){
            while (i>0 && i < size && nums[i]==nums[i-1])
                i++;
            int left = i + 1;
            int right = size - 1;
            while (left<right){
                int result = nums[left]+nums[right]+nums[i]-target;
                if(result>0){
                    if(result<diff){
                        diff = result;
                        closenum = nums[left]+nums[right]+nums[i];
                    }
                    right--;
                    while (left<right&&nums[right]==nums[right+1])
                        right--;
                }else if(result<0){
                    if(Math.abs(result)<diff){
                        diff = Math.abs(result);
                        closenum = nums[left]+nums[right]+nums[i];
                    }
                    left++;
                    while (left<right&&nums[left]==nums[left-1])
                        left++;

                }else {
                    return target;
                }
            }


        }
        return closenum;
    }

/**
 * NO.18 4Sum
 *For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

 A solution set is:
 [
 [-1,  0, 0, 1],
 [-2, -1, 1, 2],
 [-2,  0, 0, 2]
 ]
 * */
    public List<List<Integer>> fourSum_timeout(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if(nums.length<4||nums==null)
            return results;
        List<Integer> li = new ArrayList<Integer>();
        for (int j = 0;j<nums.length;j++){
            li.add(nums[j]);
        }
        Collections.sort(li);
        for (int i = 0;i < li.size()-3;i++){
            while(i > 0 && i < li.size()-3 && li.get(i).intValue() == li.get(i-1).intValue())
                i ++;
            for (int j = i+1;j<li.size()-2;j++){
                while(j!=i+1 && j < li.size()-2 && li.get(j).intValue() == li.get(j-1).intValue())
                    j ++;
                int current_i = li.get(i).intValue();
                int current_j = li.get(j).intValue();
                int left = j+1;
                int right = li.size()-1;
                while (left<right){
                    if(li.get(left).intValue()+li.get(right).intValue()+current_i+current_j-target>0){
                        right--;
//                        while(left < right &&li.get(right).intValue()==li.get(right+1).intValue())
//                            right --;
                    } else if(li.get(left).intValue()+li.get(right).intValue()+current_i+current_j-target<0) {
                        left++;
//                        while(left < right && li.get(left).intValue()==li.get(left-1).intValue())
//                            left ++;
                    }else{
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(li.get(left).intValue());
                        list.add(li.get(right).intValue());
                        list.add(current_i);
                        list.add(current_j);
                        results.add(list);
                        left++;
                        right--;
                        while(left < right && li.get(left).intValue()==li.get(left-1).intValue())
                            left ++;
                        while(left < right &&li.get(right).intValue()==li.get(right+1).intValue())
                            right --;
                    }
                }
            }
        }
        return results;
    }
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            if(nums==null||nums.length<4)
                return result;
            for (int i=0;i<nums.length-3;i++){
                while(i!=0&&i<nums.length-3&&nums[i]==nums[i-1])
                    i++;
                for (int j=i+1;j<nums.length-2;j++){
                    while(j!=i+1&&j<nums.length-2&&nums[j]==nums[j-1])
                        j++;
                    int left=j+1;
                    int right=nums.length-1;
                    while (left<right){
                        if(nums[i]+nums[j]+nums[left]+nums[right]>target){
                            right--;

                        }else if(nums[i]+nums[j]+nums[left]+nums[right]<target){
                            left++;
                        //不理解为什么这边加上while以后会有timeout的错误
                        }else {
                            List<Integer> li= new ArrayList<Integer>();
                            li.add(nums[i]);
                            li.add(nums[j]);
                            li.add(nums[left]);
                            li.add(nums[right]);
                            result.add(li);
                            left++;
                            right--;
                            while (left<right&&nums[left]==nums[left-1])
                                left++;
                            while (left<right&&nums[right]==nums[right+1])
                                right--;
                        }
                    }

                }
            }
            return result;
        }
/**
 * NO.17 Letter Combinations of a Phone Number
 * Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 Note:
 Although the above answer is in lexicographical order, your answer could be in any order you want.

 Subscribe to see which companies asked this question.
 * */
    public List<String> letterCombinations(String digits) {
        Map<Character,String> map = new HashMap<Character, String>();
        map.put('0',"");
        map.put('1',"");
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> list = new ArrayList<String>();;
        for (int i = 0;i<digits.length();i++){
            list = digitCom(list,map.get(digits.charAt(i)));
        }
        return list;
    }

    public List<String> digitCom(List<String> current,String character){
        List<String> newcom = new ArrayList<String>();
        if(current==null||current.size()==0){
            for (int i = 0;i< character.length();i++){
                newcom.add(""+character.charAt(i));
            }
        }else {
            for (int i = 0;i< character.length();i++){
                for (int j=0;j<current.size();j++){
                    newcom.add(current.get(j)+""+character.charAt(i));
                }
            }
        }
        return newcom;
    }

/**
 * NO.19 Remove Nth Node From End of List
 * Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:
 Given n will always be valid.
 Try to do this in one pass.

 Subscribe to see which companies asked this question
 * */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp=head;
        int length = getListNodeLength(head);
        if(length==0||length==1){
            return null;
        }
//        else if(length==1){
//            return null;
//        }
        else{
            int pos = length-n;
            if(pos==0){
                head= head.next;
            }else{
                for (int i = 0;i<pos-1;i++){
                    if(tmp.next!=null){
                        tmp=tmp.next;
                    }else {
                        return null;
                    }
                }
                tmp.next=tmp.next.next;
            }
        }
        return head;
    }
    public int getListNodeLength(ListNode li){
        ListNode tmp = li;
        int length=1;
        if(tmp==null)
            return 0;
        while (tmp.next!=null){
            length++;
            tmp=tmp.next;
        }
        return length;
    }
/**
 * NO.20 Valid Parentheses
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

 Subscribe to see which companies asked this question.
 * */
    public boolean isValid(String s) {
        Stack<Character> sc = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                sc.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (sc.size()==0||sc.peek() != '(')
                    return false;
                else
                    sc.pop();
            } else if (s.charAt(i) == '}') {
                if (sc.size()==0||sc.peek() != '{')
                    return false;
                else
                    sc.pop();
            } else if (s.charAt(i) == ']') {
                if (sc.size()==0||sc.peek() != '[')
                    return false;
                else
                    sc.pop();
            }
        }
        if(sc.size()==0){
            return true;
        }else {
            return false;
        }
    }
    /**
     * NO.21 Merge Two Sorted Lists
     * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

     Subscribe to see which companies asked this question.
     * */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        List<Integer> li = new ArrayList<Integer>();
        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
                li.add(l1.val);
                l1=l1.next;
            }else {
                li.add(l2.val);
                l2=l2.next;
            }
        }
        while (l1!=null){
            li.add(l1.val);
            l1=l1.next;
        }
        while (l2!=null){
            li.add(l2.val);
            l2=l2.next;
        }
        Collections.reverse(li);
        ListNode ln = null;
        for (int num:li){
            ln = addtoList(ln,num);
        }
        return ln;
    }
    /**
     * NO.22 Generate Parentheses
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

     For example, given n = 3, a solution set is:

     [
     "((()))",
     "(()())",
     "(())()",
     "()(())",
     "()()()"
     ]
     * */
    public List<String> generateParenthesis(int n) {
        List<String> ls = new ArrayList<String>();
        String s="";
        generateParenthesisUtil(ls,s,n);
        return ls;
    }

    public void generateParenthesisUtil(List<String> ls,String s,int n){
        int leftspace =  leftSpaceCount(s);
        if(leftspace==n){
            for (int i=s.length();i<2*n;i++){
                s=s+")";
            }
            ls.add(s);
        }else {
            int rightSpace = s.length()-leftspace;
            if(rightSpace==leftspace){
                generateParenthesisUtil(ls,s+"(",n);
            }else {
                generateParenthesisUtil(ls,s+"(",n);
                generateParenthesisUtil(ls,s+")",n);
            }
        }
    }

    public int leftSpaceCount(String s){
        int count=0;
        for(int i = 0;i< s.length();i++){
            if(s.charAt(i)=='(')
                count++;
        }
        return count;
    }
/**
 * NO.23 Merge k Sorted Lists
 Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 Subscribe to see which companies asked this question.
 * */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        else
            return mergeCur(lists,0,lists.length-1);
    }

    public ListNode mergeCur(ListNode[] listNodes,int start,int end){
        if(start==end)
            return listNodes[start];
        else if(end-start==1){
            return mergeTwoLists(listNodes[start],listNodes[end]);
        }else {
            int median = (end+start)/2;
            ListNode l1=mergeCur(listNodes,start,median);
            ListNode l2=mergeCur(listNodes,median+1,end);
            return mergeTwoLists(l1,l2);
        }
    }
 /**
  * NO.24 Swap Nodes in Pairs
  * Given a linked list, swap every two adjacent nodes and return its head.

  For example,
  Given 1->2->3->4, you should return the list as 2->1->4->3.

  Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

  Subscribe to see which companies asked this question.
  * */
     public ListNode swapPairs(ListNode head) {
         if(head==null)
             return null;
         ListNode pointHead = new ListNode(0);
         ListNode p = pointHead;
         pointHead.next = head;
         int count=0;
         while (p.next.next!=null){
             ListNode tmp = p.next.next;
             p.next.next = tmp.next;
             tmp.next = p.next;
             p.next = tmp;
             if(count++==0){
                 pointHead.next=p.next;
             }
             p = p.next.next;
             if(p.next==null){
                 break;
             }
         }
            return pointHead.next;
     }
     /**
      *
      * */

}
