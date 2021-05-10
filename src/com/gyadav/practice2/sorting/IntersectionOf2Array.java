package com.gyadav.practice2.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOf2Array {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> output = new ArrayList<>();
        int n1 = 0, n2 = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (n1 < nums1.length && n2 < nums2.length) {
            while (n1 > 0 && nums1[n1] == nums1[n1 - 1])
                n1++;
            while (n2 > 0 && nums2[n2] == nums2[n2 - 1])
                n2++;
            if (nums1[n1] == nums2[n2]) {
                output.add(nums1[n1]);
                n1++;
                n2++;
            } else if (nums1[n1] < nums2[n2]) {
                n1++;
            } else {
                n2++;
            }
        }
        return listToArray(output);
    }

    public int[] listToArray(List<Integer> list) {
        int[] output = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            output[i] = list.get(i);
        }
        return output;
    }
}
