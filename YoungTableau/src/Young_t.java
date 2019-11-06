import java.util.Arrays;

public class Young_t {
	
	public static void insert_key(int [][]young_t, int i, int j, int key){
				int x, y, max, temp;

		       if (young_t[i][j] < key){
		           System.out.println("No more insertions possible, The tableau is full");
		           return;
		       }
		       young_t[i][j] = key;
		       x = i;
		       y = j;
		       max = Integer.MAX_VALUE;

		       while( (i > 0 || j > 0) && (max > young_t[i][j]) ){

		           temp = young_t[x][y];
		           young_t[x][y] = young_t[i][j];
		           young_t[i][j] = temp;
		           i = x;
		           j = y;

		           if (i - 1 >= 0 && young_t[i][j] < young_t[i-1][j]){
		               x = i -1;
		               y = j;
		           }
		           if(j -1 >= 0 && young_t[x][y] < young_t[i][j-1]){
		               x = i;
		               y = j - 1;
		           }
		           max = young_t[x][y];
		       }
		   }
	
	public static void print2D(int mat[][]) 
    { 
        // Loop through all rows 
        for (int i = 0; i < mat.length; i++) {
            // Loop through all elements of current row 
            for (int j = 0; j < mat[i].length; j++) 
                System.out.print(mat[i][j] + " "); 
        
        System.out.print("\n");
      }
        
        System.out.print("\n");
    }
	
	public static int extract_min(int [][]youngT){
		    int x = youngT[0][0];
		    youngT[0][0] = Integer.MAX_VALUE;
		    youngify(youngT, 0, 0);
		    return x;
	}
	
	public static void youngify(int [][] young_t, int i, int j){
		        int x, y;
		        x = i;
		        y = j;
		        int temp;

		        if (i + 1 < 4){
		            if (young_t[i][j] > young_t[i+1][j]){
		                x = i + 1;
		                y = j;
		            }
		        }
		        if (j+1 < 4){
		            if (young_t[x][y] > young_t[i][j+1]){
		                x = i;
		                y = j+1;
		            }
		        }
		        if(x != i || y != j){
		            temp = young_t[x][y];
		            young_t[x][y] = young_t[i][j];
		            young_t[i][j] = temp;
		            youngify(young_t, x, y);
		        }
	}

	
	public static Boolean searchtableau(int tableau[][], int key){
		int i= 3, j=0; 
		
		while(i >= 0 && j <= 3){
			if(tableau[i][j] > key)
				i--;
			else if(tableau[i][j] < key)
				j++;
			else
				return true;
		}
		
		return false;
	}

	public static void sortusingtableau(int tableau[][], int keys[]){
		for(int key : keys){
			insert_key(tableau,3,3,key);
		}
		
		for(int i=0;i < keys.length;i++){
			keys[i] = extract_min(tableau);
		}
		
	}
  
	public static void main(String [] args) {
		
		int tableauarr[][]= new int[4][4];
		int keys[] = {9,16,3,2,4,8,5,14,12};
		
		int keysforsorting[] = {9,16,3,2,4,8,5,14,12,16,15,25,24,23,40,100};
		
		for (int[] row : tableauarr) {
            Arrays.fill(row, Integer.MAX_VALUE); 	
	   }
	
		for(int key : keys){
			insert_key(tableauarr,3,3,key);
		}
		
		print2D(tableauarr);
		
		System.out.println("Minimum value present in the tableau matrix: " + extract_min(tableauarr));
	
		
		System.out.println("Search key 40 :" + (searchtableau(tableauarr, 40) ? "Key present" : "key not present"));
		
		System.out.println("Search key 12 :" + (searchtableau(tableauarr, 12) ? "Key present" : "key not present"));
		
		System.out.println("Search key 5 :" + (searchtableau(tableauarr, 5) ? "Key present" : "key not present"));
		
		for (int[] row : tableauarr) {
            Arrays.fill(row, Integer.MAX_VALUE); 	
	   }
		
		System.out.println("Keys Before Sorting: ");
		
		for(int key : keysforsorting){
			System.out.print(key + " ");
		}
		System.out.println("");
		System.out.println("Keys After Sorting: ");
		
		sortusingtableau(tableauarr,keysforsorting);
		
		for(int key: keysforsorting){
			System.out.print(key+" ");
		}
			
		}
}
