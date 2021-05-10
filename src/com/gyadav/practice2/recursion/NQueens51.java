package com.gyadav.practice2.recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueens51 {
    List<List<String>> output = new ArrayList<>();

/*    public static void main(String[] a) {
        NQueens51 nQueens51 = new NQueens51();
        nQueens51.solveNQueens(4);
    }*/

    public List<List<String>> solveNQueens(int n) {
        int[] row = new int[n];
        for (int i = 0; i < n; i++)
            row[i] = i;
        int[] slate = new int[n];
        for (int i = 0; i < n; i++)
            slate[i] = -1;
        solveNQueensHelper(n, row, 0, slate);
        return output;
    }

    private void solveNQueensHelper(int n, int[] row, int index, int[] slate) {
        // Backtracking case
        for (int i = 0; i < index - 1; i++) {
            int rowDiff = Math.abs((index - 1) - i);
            int colDiff = Math.abs(slate[index - 1] - slate[i]);
            if (rowDiff == colDiff)
                return;
        }

        // Base case: Leaf node
        if (n == index) {
            output.add(getLcOutput(slate));
        }
        // Recursive case : Internal node worker
        for (int i = index; i < row.length; i++) {
            slate[index] = row[i];
            swap(row, i, index);
            solveNQueensHelper(n, row, index + 1, slate);
            slate[index] = -1;
            swap(row, i, index);
        }

    }

    private List<String> getLcOutput(int[] slate) {
        List<String> out = new ArrayList<>();
        for (int i = 0; i < slate.length; i++) {
            StringBuilder sb = new StringBuilder(slate.length);
            for (int j = 0; j < slate.length; j++) {
                if (slate[i] == j)
                    sb.append('Q');
                else
                    sb.append('.');
            }
            out.add(sb.toString());
        }
        return out;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
