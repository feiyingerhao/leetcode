import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by haolidong on 2017/3/4.
 */
public class SolutionTest {
    @Test
    public void twoSumTest(){
        int[] num={3,2,4};
        int[] result=new Solution().twoSum(num,6);
        System.out.println(result[0]+","+result[1]);
    }

    @Test
    public void addTwoNumbersTest(){
        ListNode ln = null;
        ln = addtoList(ln,3);
        ln = addtoList(ln,4);
        ln = addtoList(ln,2);

        ListNode ln2 = null;
        ln2 = addtoList(ln2,6);
        ln2 = addtoList(ln2,5);
        ln2 = addtoList(ln2,8);
        ListNode result = new Solution().addTwoNumbers(ln,ln2);
    }

    public ListNode addtoList(ListNode nextNode,int num){
        ListNode ln = new ListNode(num);
        ln.next = nextNode;
        return  ln;
    }

    @Test
    public void lengthOfLongestSubstringTest(){
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Solution().lengthOfLongestSubstring("c"));
        System.out.println(new Solution().lengthOfLongestSubstring(""));
        System.out.println(new Solution().lengthOfLongestSubstring("dvdf"));
        System.out.println(new Solution().lengthOfLongestSubstring("bpfbhmipx"));
    }

    @Test
    public void findMedianSortedArraysTest(){
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(new Solution().findMedianSortedArrays(nums1,nums2));
    }

    @Test
    public void longestPalindromeTest(){
//        System.out.println(new Solution().longestPalindrome("cbbd"));
//        System.out.println(new Solution().longestPalindrome("aba"));
        System.out.println(new Solution().longestPalindrome("ccc"));
        System.out.println(new Solution().longestPalindrome("c"));
        System.out.println(new Solution().longestPalindrome(""));
    }

    @Test
    public void convertTest(){
//        System.out.println(new Solution().convert("PAYPALISHIRING",3));
        System.out.println(new Solution().convert("AB",1));
    }

    @Test
    public void reverseTest(){
        System.out.println(new Solution().reverse(123));
        System.out.println(new Solution().reverse(-123));
        System.out.println(new Solution().reverse(2147483645));
        System.out.println(new Solution().reverse(0));
    }

    @Test
    public void myAtoiTest(){
//        System.out.println(new Solution().myAtoi("  +002a43"));
//        System.out.println(new Solution().myAtoi(""));
//        System.out.println(new Solution().myAtoi("+"));
//        System.out.println(new Solution().myAtoi("   +0 123"));
//        System.out.println(new Solution().myAtoi("   -2 123"));
//        System.out.println(new Solution().myAtoi("   -2123"));
//        System.out.println(new Solution().myAtoi("   +-2123"));
        System.out.println(new Solution().myAtoi("2147483647"));
        System.out.println(new Solution().myAtoi("9223372036854775809"));
    }

    @Test
    public void isPalindromeTest(){
        System.out.println(new Solution().isPalindrome(-12321));
    }

    @Test
    public void isMatch(){
        System.out.println(new Solution().isMatch("aa","a"));
        System.out.println(new Solution().isMatch("aa","aa"));
        System.out.println(new Solution().isMatch("aaa","aa"));
        System.out.println(new Solution().isMatch("aa","a*"));
        System.out.println(new Solution().isMatch("aa",".*"));
        System.out.println(new Solution().isMatch("ab",".*"));
        System.out.println(new Solution().isMatch("aab","c*a*b*"));
        System.out.println(new Solution().isMatch("aaa","aaaa"));
        System.out.println(new Solution().isMatch("aaa","a.a"));
        System.out.println(new Solution().isMatch("aabc",".*ab*c"));
        System.out.println(new Solution().isMatch("ab",".*..c*"));
        System.out.println(new Solution().isMatch("a",".*..a*"));
        System.out.println(new Solution().isMatch("aaaaaaaaaaaaab","a*a*c"));


        System.out.println("------------------compare----------------");
        System.out.println(new Solution().isMatchNew("aa","a"));
        System.out.println(new Solution().isMatchNew("aa","aa"));
        System.out.println(new Solution().isMatchNew("aaa","aa"));
        System.out.println(new Solution().isMatchNew("aa","a*"));
        System.out.println(new Solution().isMatchNew("aa",".*"));
        System.out.println(new Solution().isMatchNew("ab",".*"));
        System.out.println(new Solution().isMatchNew("aab","c*a*b*"));
        System.out.println(new Solution().isMatchNew("aaa","aaaa"));
        System.out.println(new Solution().isMatchNew("aaa","a.a"));
        System.out.println(new Solution().isMatchNew("aabc",".*ab*c"));
        System.out.println(new Solution().isMatchNew("ab",".*..c*"));
        System.out.println(new Solution().isMatchNew("a",".*..a*"));
        System.out.println(new Solution().isMatchNew("aaaaaaaaaaaaab","a*a*a*a*a*a*a*a*a*a*a*a*c"));

    }

    @Test
    public void maxAreaTest(){
        int[] height = {1,2,3,2,1};
        System.out.println(new Solution().maxArea(height));
    }

    @Test
    public void intToRomanTest(){
        System.out.println(new Solution().intToRoman(2334));
    }

    @Test
    public void romanToIntTest(){
        System.out.println(new Solution().romanToInt("CCXXXII"));
    }
    @Test
    public void test(){
//        Pattern pattern = Pattern.compile("aaaa");
//        Matcher matcher = pattern.matcher("aaa");
//        // 字符串是否与正则表达式相匹配
//        boolean rs = matcher.matches();
//        System.out.println(rs);
        String a="123";
        String b = "a123";
        System.out.println(b.substring(b.length()-a.length()));

    }



}
