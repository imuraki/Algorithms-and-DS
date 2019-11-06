/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alg.testset.util;

import alg.search.LinearSearch;
import alg.search.BinarySearch;
import java.util.ArrayList;

/**
 *
 * @author Qiong
 */
public class TestSearch {
    public static void testframe(int [] array, int key){
        long startTime, duration;
        //System.out.println(Arrays.toString(array) + "\t" + key);
        
        startTime = System.nanoTime();
        LinearSearch.search(array, key);
        duration = System.nanoTime() - startTime;
        System.out.print(array.length + "\t" + duration + "\t");
      
        startTime = System.nanoTime();
        BinarySearch.search(array, key);
        duration = System.nanoTime() - startTime;
        System.out.println(duration);
    }
    
    public static void main(String[] argv){
        System.out.println("Input instance size\tLinear Search\tBinary Search");
        int [] ids = {5, 7, 15, 17, 25, 27};
        int key = Common.randomIndex(0, ids.length-1);
        TestSearch.testframe(ids, ids[key]);
        
        int start = 100, end = 1000000, update = 500;
        ArrayList<Integer> list;
        for (int i = start; i <= end; i += update){
            list = CollectionGenerator.generateRandomArrayList(i, 0);
            int [] array = Common.copy2Array(list);
            
            key = Common.randomIndex(0, ids.length-1);
            TestSearch.testframe(array, ids[key]);
        }
    }
}
