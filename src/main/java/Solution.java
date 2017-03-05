import java.util.*;

/**
 * Created by haolidong on 2017/3/4.
 */
public class Solution {
    /**
     * NO.1
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

     You may assume that each input would have exactly one solution, and you may not use the same element twice.

     Example:
     Given nums = [2, 7, 11, 15], target = 9,

     Because nums[0] + nums[1] = 2 + 7 = 9,
     return [0, 1].
     * */
    public int[] twoSum(int[] nums, int target) {
        int[] result={0,0};
        for (int i = 0;i < nums.length-1;i++){
            for (int j = i+1;j < nums.length;j++){
                if(nums[i]+nums[j] == target){
                    result[0]=i;
                    result[1]=j;
                }
            }
        }
        return result;
    }

    /**
     * NO.2
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

     You may assume the two numbers do not contain any leading zero, except the number 0 itself.

     Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     Output: 7 -> 0 -> 8
     * */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        List<Integer> li1 = new ArrayList<Integer>();
        List<Integer> li2 = new ArrayList<Integer>();
        List<Integer> resultlist = new ArrayList<Integer>();
        while (l1.next!=null){
            li1.add(l1.val);
            l1=l1.next;
        }
        li1.add(l1.val);

        while (l2.next!=null){
            li2.add(l2.val);
            l2=l2.next;
        }
        li2.add(l2.val);
        int jinwei = 0;
        int index = li1.size()<li2.size()?li1.size():li2.size();
        for(int i = 0;i<index;i++){
            resultlist.add( (li1.get(i)+li2.get(i)+jinwei)%10);
            jinwei = (li1.get(i)+li2.get(i)+jinwei)/10;
        }
        if(li1.size()<li2.size()){
            for (int j = index;j< li2.size();j++){
                resultlist.add( (li2.get(j)+jinwei)%10);
                jinwei = (li2.get(j)+jinwei)/10;
            }
        }else {
            for (int j = index;j< li1.size();j++){
                resultlist.add( (li1.get(j)+jinwei)%10);
                jinwei = (li1.get(j)+jinwei)/10;
            }
        }
        if(jinwei == 1){
            resultlist.add(1);
        }
        Collections.reverse(resultlist);
        for (int k=0;k<resultlist.size();k++){
            result = addtoList(result,resultlist.get(k));
        }
        return result;
    }

    public ListNode addtoList(ListNode nextNode,int num){
        ListNode ln = new ListNode(num);
        ln.next = nextNode;
        return  ln;
    }

/**
 * NO.3
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 Subscribe to see which companies asked this question.
 * */
    public int lengthOfLongestSubstring(String s) {
        String str="";
        int maxlength=0;
        for (int i = 0;i < s.length(); i++){
            String charater = s.charAt(i)+"";
            int index = str.indexOf(charater);
            if(index!=-1){
                if(str.length()>maxlength){
                    maxlength=str.length();
                }
                str = str.substring(index+1);
                str+=charater;
            }else{
                str+=charater;
                if(i==s.length()-1){
                    if(str.length()>maxlength){
                        maxlength=str.length();
                    }
                }
            }
        }
        return maxlength;
    }

/**
 * NO.4
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 Example 1:
 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0
 Example 2:
 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5
 * */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> li = new ArrayList<Integer>();
        double result = 0.0;
        int i=0;
        int j=0;
        while (i<nums1.length && j <nums2.length){
            if(nums1[i]<nums2[j]){
                li.add(nums1[i]);
                i++;
            }else if(nums1[i]>nums2[j]){
                li.add(nums2[j]);
                j++;
            }else {
                li.add(nums1[i]);
                li.add(nums2[j]);
                i++;
                j++;
            }
        }
        for (int k = i;k<nums1.length;k++){
            li.add(nums1[k]);
        }
        for (int k = j;k<nums2.length;k++){
            li.add(nums2[k]);
        }

        if(li.size()%2==0){
            int index1 = li.size()/2;
            int num1 = li.get(index1);
            int num2 = li.get(index1-1);
            result = 1.0*(num1+num2)/2;
        }else{
            int index1 = li.size()/2;
            int num1 = li.get(index1);
            result = 1.0*num1;
        }

        return result;
    }
/**
 * NO.5
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example:

 Input: "babad"

 Output: "bab"

 Note: "aba" is also a valid answer.
 Example:

 Input: "cbbd"

 Output: "bb"
 * */
    public String longestPalindrome(String s) {
        int start = 0;
        int maxlength = 0;
        for (int i = 0;i<s.length();i++){
            int j = i;
            int k = i;
            while(j>=0&&k<s.length()&& s.charAt(j)==s.charAt(k)){
                int length = k-j+1;
                if(length>maxlength){
                    start = j;
                    maxlength=length;
                }
                j--;
                k++;
            }
        }
        for (int i = 0;i<s.length()-1;i++){
            int j = i;
            int k = i+1;
            while(j>=0&&k<s.length()&& s.charAt(j)==s.charAt(k)){
                int length = k-j+1;
                if(length>maxlength){
                    start = j;
                    maxlength=length;
                }
                j--;
                k++;
            }
        }
        return s.substring(start,start+maxlength);
    }
/**
 * NO.6
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * */
    public String convert(String s, int numRows) {
        int length = s.length();
        String result="";
        char[][] chars = new char[length][numRows];
        int x = 0;
        int y = -1;
        if(numRows==1)
            return s;
        for (int i = 0;i<s.length();){
            while (y<numRows-1&&i<s.length())chars[x][++y]=s.charAt(i++);
            while (y>0&&i<s.length())chars[++x][--y]=s.charAt(i++);
        }
        for (int p=0;p<numRows;p++){
            for (int q=0;q<length;q++){
                if(chars[q][p]!='\0'){
                    result=result+chars[q][p];
                }
            }
        }
        return result;
    }
/**
 * NO.7
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
 * NO.9
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
 * NO.10.Failure
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
     * NO.10
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

}
