package com.yuanrui.leetcode;


/**
 * 1533. 找到最大整数的索引
 */
public class GetIndex {

//    public int getIndex(ArrayReader reader) {
//        int left = 0;
//        int right = reader.length() - 1;
//        while (left < right) {
//            int middle = (left + right) >>> 1;
//            boolean bi = (left+right)%2==1;
//            if(bi){
//                if (reader.compareSub(left, middle, middle+1, right) > 0)
//                    right = middle-1;
//                else if(reader.compareSub(left,middle,middle+1,right)<0)
//                    left = middle+1;
//                else
//                    return left;
//            }else{
//                if(reader.compareSub(left,left,middle,middle)<0)
//                    return middle;
//                if (reader.compareSub(left, middle-1, middle+1, right) > 0)
//                    right = middle-1;
//                else if(reader.compareSub(left,middle-1,middle+1,right)<0)
//                    left = middle+1;
//                else
//                    return left;
//            }
//        }
//        return left;
//    }
}
