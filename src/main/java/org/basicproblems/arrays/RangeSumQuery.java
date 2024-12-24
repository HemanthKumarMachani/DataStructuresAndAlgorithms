package org.basicproblems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RangeSumQuery {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4);
        List<Integer> resultList = prefixSumOfList(list);
        System.out.println("prefix sum of input list:"+resultList);
    }
    //Generating prefix sum array of the input array.
    //A prefix sum is noting but a cumulative sum of sequence of elements of the input list.
    //Generated using pf[i] = p[i-1] + input[i] which means current element of prefix array
    //is obtained by the sum of previous element in prefix array and current element in input array.
    public static List<Integer> prefixSumOfList(List<Integer> list){
        List<Integer> prefList = new ArrayList<>();
        if(list == null || list.isEmpty()){ return prefList;}
        prefList.add(list.getFirst());
        for(int i = 1; i < list.size(); i++){
            prefList.add(prefList.get(i-1) + list.get(i));
        }
        return prefList;
    }
}
