/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alg.testset.util;

import alg.sort.InsertionSort;
import alg.sort.MergeSort;
import alg.sort.SelectionSort;
import alg.sort.BubbleSort;
import java.util.ArrayList;

public class testsortwithbubble {
    public final static int NUMBER_OF_SORTS = 4;
    public final static int INSERTION_SORT = 1;
    public final static int SELECTION_SORT = 2;
    public final static int MERGE_SORT = 3;
    public final static int BUBBLE_SORT = 4;
    public final static int INPUT_INSTANCE_SIZE = 0;
    
    public final static int REPEATS = 100;
    
    /**
     * Test framework for one examination of sort algorithms by giving an input instance
     * @param isPrint  Print the execution running time for each algorithm
     */
    public static long [] testframework(int []numbers, boolean isPrint)
    {
        long startTime; int size = numbers.length;
        
        if (numbers == null) return null;
        
        long duration[] = new long[NUMBER_OF_SORTS + 1];
        duration[INPUT_INSTANCE_SIZE] = size;
        int tmp [] = new int[size]; 
        for (int i = 0; i < size; i++) 
            tmp[i] = numbers[i];
        
        /* initial call to insertion sort with index */
        startTime = System.nanoTime();
        InsertionSort.sort(tmp, size);
        duration[INSERTION_SORT] = System.nanoTime() - startTime;
        if (isPrint) System.out.print(duration[INPUT_INSTANCE_SIZE] + "\t" + duration[INSERTION_SORT] + "\t");

        for (int i = 0; i < size; i++)  
            tmp[i] = numbers[i];
        startTime = System.nanoTime();
        SelectionSort.sort(tmp, size);
        duration[SELECTION_SORT] = System.nanoTime() - startTime;
        if (isPrint) System.out.print(duration[SELECTION_SORT] + "\t");

        for (int i = 0; i < size; i++)  
            tmp[i] = numbers[i];
        startTime = System.nanoTime();
        MergeSort.sort(tmp, 0, size-1);
        duration[MERGE_SORT] = System.nanoTime() - startTime;
        if (isPrint) System.out.print(duration[MERGE_SORT] + "\t"); 
        
        for (int i = 0; i < size; i++)   
            tmp[i] = numbers[i];
        startTime = System.nanoTime();
        BubbleSort.sort(tmp, size);
        duration[BUBBLE_SORT] = System.nanoTime() - startTime;
        if (isPrint) System.out.println(duration[BUBBLE_SORT] ); 
        
        return duration;
    }
    
    /**
     * Examine sort algorithms in best or worst case
     * @param size_start
     * @param size_end
     * @param size_updates
     * @param title
     * @param isBestCase 
     */
    public static void testExtremeCase(int size_start, int size_end, int size_updates, String title, boolean isBestCase){
        System.out.println("-----------------" + title + "-----------------");
        System.out.println("Input instance size\tInsertion Sort\tSelection Sort\tMergeSort\tBubbleSort");
        ArrayList<Integer> list;

        for (int i = size_start; i<= size_end; i+=size_updates)
            {
                list = CollectionGenerator.generateRandomArrayList(i, isBestCase?1:-1);
                int [] array = Common.copy2Array(list);
                testframework(array, true);
            }
    }
    
    /**
     * Examine sort algorithms in average case
     * @param size_start
     * @param size_end
     * @param size_updates
     * @param title 
     */
    public static void testAverageCase(int size_start, int size_end, int size_updates, String title){
        System.out.println("-----------------" + title + "-----------------");
        System.out.println("Input instance size\tInsertion Sort\tSelection Sort\tMergeSort\tBubbleSort");
        ArrayList<Integer> list;
        
        int times = (size_end - size_start + 1) % size_updates == 0
                ? (size_end - size_start + 1) / size_updates
                : (size_end - size_start + 1) / size_updates + 1;
        int count = 0;
        long duration[][] = new long[times][NUMBER_OF_SORTS + 1];
        long tmp_duration[];
        long total_duration[] = new long[NUMBER_OF_SORTS + 1];
        
        for (int i = size_start; i<= size_end; i+=size_updates){
            for (int j = 0; j < REPEATS; j++)
                for (int k = 0; k < NUMBER_OF_SORTS + 1; k++ )
                    total_duration[k] = 0;
            
            for (int j = 0; j < REPEATS; j++){
                list = CollectionGenerator.generateRandomArrayList(i, -1); 
                int [] array = Common.copy2Array(list);
                tmp_duration = testframework(array, false);
                
                for (int k = 0; k < NUMBER_OF_SORTS + 1; k++)
                    total_duration[k] += tmp_duration[k];
            }
            
            for (int k = 0; k < NUMBER_OF_SORTS + 1; k++)
                duration[count][k] = total_duration[k] / REPEATS;
            
            count++;
        }
        
        for (int i = 0; i < count; i++)
            System.out.println(duration[i][INPUT_INSTANCE_SIZE]
                    + "\t" + duration[i][INSERTION_SORT]
                    + "\t" + duration[i][SELECTION_SORT]
                    + "\t" + duration[i][MERGE_SORT]
                    + "\t" + duration[i][BUBBLE_SORT]);
    }
    
    public static void main(String[] argv)
    {
        //int numbers [] = {10, 2, 78, 4, 45, 32, 7, 11};
        //final int NUMBERS_SIZE = 8;

        //TestSorts.test(numbers, NUMBERS_SIZE, "Short list test");
      
       //testExtremeCase(0, 30000, 1000, "Comparison [best case]", true);
        testExtremeCase(0, 100000, 10000, "Comparison [worse case]", false);
        
        //testAverageCase(100, 5000, 200, "Comparison [average case]");
    }
}
