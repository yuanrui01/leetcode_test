package com.yuanrui.leetcode;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/4/16-12:40
 */
public class FindRedundantConnection {


    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[1001];
        int[] ans = new int[0];

        for (int i = 0; i < parent.length; ++i) {
            parent[i] = i;
        }

        for(int i = 0; i < edges.length; ++i) {
            if (find(parent, edges[i][0]) != find(parent, edges[i][1])){
                union(parent, edges[i][0], edges[i][1]);
            }else{
                ans = edges[i];
                break;
            }
        }

        return ans;
    }


    private int find(int[] parent, int index){
        if(parent[index] != index){
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

    private void union(int[] parent, int index1, int index2){
        parent[find(parent,index1)] = find(parent, index2);
    }
}
