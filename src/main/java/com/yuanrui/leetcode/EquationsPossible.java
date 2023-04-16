package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/4/16-12:25
 */
public class EquationsPossible {

    public static void main(String[] args) {
        String[] equations = {"a==b","b!=a"};
        equationsPossible(equations);
    }

    public static boolean equationsPossible(String[] equations) {
        List<String> equalLst = new ArrayList<>();
        List<String> unequalLst = new ArrayList<>();
        int[] parent = new int[26];

        for (int i = 0; i < parent.length; ++i){
            parent[i] = i;
        }

        for(int i = 0; i < equations.length; ++i){
            if (equations[i].charAt(1) == '='){
                equalLst.add(equations[i]);
            }else{
                unequalLst.add(equations[i]);
            }
        }

        for(int i = 0; i < equalLst.size(); ++i){
            union(parent, (equalLst.get(i).charAt(0) - 'a'), (equalLst.get(i).charAt(3) - 'a'));
        }

        for(int j = 0; j < unequalLst.size(); ++j){
            if(find(parent, (unequalLst.get(j).charAt(0) - 'a')) != find(parent, (unequalLst.get(j).charAt(3) - 'a')))
                return false;
        }

        return true;
    }

    private static int find(int[] parent, int index){
        if(parent[index] != index){
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

    private static void union(int[] parent, int index1, int index2){
        parent[find(parent,index1)] = find(parent, index2);
    }
}
