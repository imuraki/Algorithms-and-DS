/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alg.testset.util;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Qiong
 */
public class Common {
    
    /**
     * Convert an array list to a static array
     * @param list
     * @return 
     */
    public static int[] copy2Array(ArrayList<Integer> list){
        if (list == null) return null;
        int[] arr = new int[list.size()];
        for(int j = 0; j < list.size(); j++) {
            if (list.get(j) != null) {
                arr[j] = list.get(j);
            }
        }
        return arr;
    }
    
    /**
     * Generate a random number in the range of startIndex through endIndex
     * @param startIndex
     * @param endIndex
     * @return 
     */
    public static int randomIndex(int startIndex, int endIndex){
        Random rand = new Random(); 
        return rand.nextInt(endIndex - startIndex + 1) + startIndex;
    }
}
