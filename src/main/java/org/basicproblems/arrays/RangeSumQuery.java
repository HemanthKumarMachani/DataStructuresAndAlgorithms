package org.basicproblems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RangeSumQuery {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4);
        List<Integer> resultList = prefixSumOfList(list);
        System.out.println("prefix sum of input list:"+resultList);
        List<List<Integer>> sampleQueries = new ArrayList<>();
        for(int i=0; i<2; i++){
            sampleQueries.add(new ArrayList<>());
        }
        sampleQueries.get(0).add(0);
        sampleQueries.get(0).add(2);
        sampleQueries.get(1).add(1);
        sampleQueries.get(1).add(3);
        List<Integer> rangeSumQueryOutput = rangeSumQuery(list,sampleQueries);
        System.out.println("range sum query output:"+rangeSumQueryOutput);
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
    public static List<Integer> rangeSumQuery(List<Integer> inputList, List<List<Integer>> queries){
        List<Integer> resultList = new ArrayList<>();
        if(inputList == null || inputList.isEmpty()){ return resultList;}
        List<Integer> prefList = prefixSumOfList(inputList);
        System.out.println("prefix sum output inside rangeSum: "+prefList);
        int m = queries.size();
        for (int i=0; i<m; i++) {
            int left = queries.get(i).get(0);
            int right = queries.get(i).get(1);
            if (left == 0) resultList.add(prefList.get(right));
            else resultList.add(prefList.get(right) - prefList.get(left - 1));
        }
        return resultList;
    }
}
