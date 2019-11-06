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
public class BinarySearch {
    public static int search(int[] array, int targetValue) {
        int min = 0;
        //System.out.println(Arrays.toString(array));
        int max = array.length - 1;
        int guess;

        while (min <= max){
          guess = (min + max) /2;
          if (array[guess] == targetValue)
            return guess;
          else if (array[guess] < targetValue)
            min = guess + 1;
          else
            max = guess -1;
        }
	return -1;
    }
}
