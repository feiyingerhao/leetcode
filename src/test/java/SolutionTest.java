import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

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
    public void convert(){
//        System.out.println(new Solution().convert("PAYPALISHIRING",3));
        System.out.println(new Solution().convert("AB",1));
    }

    @Test
    public void test(){
        String str="12323";
        int index = str.indexOf("1");
//        str = str.substring(1,3);
        System.out.println(str);
        System.out.println(str.charAt(1)==str.charAt(3));
        char[][] a = new char[2][2];
        a[1][1]='a';
        System.out.println(a[1][1]);


    }

}
