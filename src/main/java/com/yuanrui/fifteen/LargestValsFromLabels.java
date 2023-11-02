package com.yuanrui.fifteen;

import java.util.*;

public class LargestValsFromLabels {

    private static class Node{
        int value;
        int label;
        Node(int value, int label) { this.value = value; this.label = label; }
    }

    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int res = 0;
        int[] labelMark = new int[20001];
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < values.length; i++)
            nodes.add(new Node(values[i], labels[i]));
        nodes.sort((a,b) -> b.value-a.value);
        int actualCount = 0;
        for (Node node : nodes) {
            if (labelMark[node.label] >= useLimit)
                continue;
            res += node.value;
            actualCount++;
            labelMark[node.label]++;
            if (actualCount == numWanted)
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] values = {9,8,8,7,6};
        int[] labels = {0,0,0,1,1};
        int numWanted = 3;
        int useLimit = 1;
        LargestValsFromLabels largestValsFromLabels = new LargestValsFromLabels();

        int i = largestValsFromLabels.largestValsFromLabels(values, labels, numWanted, useLimit);
        System.out.println(i);
    }
}
