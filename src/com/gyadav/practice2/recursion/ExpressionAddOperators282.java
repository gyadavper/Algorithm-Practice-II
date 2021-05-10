package com.gyadav.practice2.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ExpressionAddOperators282 {
    static List<String> outputList = new ArrayList<>();
    static String[] generate_palindromic_decompositions(String s) {
        generatePdHelper(s, 0, new LinkedList<String>());
        String[] output = new String[outputList.size()];
        for (int i = 0; i < outputList.size(); i++)
            output[i] = outputList.get(i);
        return output;
    }
    static void generatePdHelper(String s, int index, LinkedList<String> slate) {
        // Recursive case
        if (index > 0 && !isPalindrome(slate.getLast()))
            return;
        // Base case: Leaf Node
        if (s.length() == index) {
            outputList.add(getFormat(slate));
            return;
        }
        // Recursive case: Internal Node
        for (int i = index; i < s.length(); i++) {
            slate.addLast(s.substring(index, i + 1));
            generatePdHelper(s, i + 1, slate);
            slate.removeLast();
        }

    }
    static boolean isPalindrome(String slate) {
        int start = 0, end = slate.length() - 1;
        while(start < end) {
            if (slate.charAt(start) != slate.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
    static String getFormat(LinkedList<String> slate) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < slate.size(); i++) {
            out.append(slate.get(i));
            if (i != slate.size() - 1)
                out.append('|');
        }
        return out.toString();
    }
public static void main(String[] a) {
        generate_palindromic_decompositions("xxy");
}
}
