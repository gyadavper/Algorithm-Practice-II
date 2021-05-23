package com.gyadav.practice2.tree;

import com.gyadav.practice2.helper.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal429 {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                temp.add(current.val);
                if (current.children != null) {
                    for (Node node : current.children)
                        queue.offer(node);
                }
            }
            output.add(temp);
        }
        return output;
    }
}

