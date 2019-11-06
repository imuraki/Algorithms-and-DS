package alg.testset.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Qiong
 */
public class CollectionGenerator {
    /**
     * Generate a random array list
     * @param size
     * @param order
     * @return 
     */
    public static ArrayList<Integer> generateRandomArrayList(int size, int order){
        ArrayList<Integer> randList = new ArrayList<Integer>();
        Random rand = new Random(); 
        
        for (int i = 0; i < size; i++){
            randList.add(rand.nextInt(size));
        }
        
        if (order == 0) return randList;
        else{
            if (order == 1)
                Collections.sort(randList); 
            else if (order == -1)
                Collections.sort(randList, Collections.reverseOrder());
            
            return randList;
        }
    }
}
