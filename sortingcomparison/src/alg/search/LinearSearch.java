/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alg.search;

import java.util.Arrays;

/**
 *
 * @author Qiong
 */
public class LinearSearch {
    public static int search(int[] array, int targetValue) {
        //System.out.println(Arrays.toString(array));
        for (int i = 0; i< array.length; i++)
            if (array[i] == targetValue)
                return i;

        return -1;
    }
}
