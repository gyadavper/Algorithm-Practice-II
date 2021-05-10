package com.gyadav.practice2.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning131 {
    List<List<String>> output = new ArrayList<>();
    public List<List<String>> partition(String s) {
        partitionHelper(s, 0, new LinkedList<>());
        return output;
    }
    private void partitionHelper (String s, int index, LinkedList<String> slate) {
        // Backtracking case
        if (index > 0 && isPalindrome(slate.getLast(), 0, slate.getLast().length() - 1))
        // Base Case : Leaf node
        if (s.length() == index) {
            output.add(new ArrayList<>(slate));
        }
        // Recursive case: Internal node worker
        for (int i = index; i < s.length(); i++) {
            slate.addLast(s.substring(index, i + 1));
            partitionHelper(s, index + 1, slate);
            slate.removeLast();
        }
    }
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
 public static void main(String[] a) {
        PalindromePartitioning131 palindromePartitioning131 = new PalindromePartitioning131();
        palindromePartitioning131.partition("abc");
 }
}
