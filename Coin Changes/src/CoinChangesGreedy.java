import java.util.Vector;

public class CoinChangesGreedy {
	
	static void findMin(int totalcents, int[] coins) 
	{ 
		Vector<Integer> sol = new Vector<>(); 
		int i;
		
	    for (i = 4 - 1; i >= 0; i--) 
	    { 
	    	while (totalcents >= coins[i]) 
		{ 
	    		totalcents -= coins[i]; 
	            sol.add(coins[i]);
	        } 
	    } 
	    
	    System.out.println("The minimum number of coins are : " + sol.size());
	    System.out.println("The coins are :");
	    
	    for (i = 0; i < sol.size(); i++) 
	    { 
	        System.out.println(""+sol.elementAt(i)); 
	    } 
	} 

	public static void main(String[] args) 
	{
		int coins[] = { 1,5,10,25 }; 
		int n = 102; 
		  
        findMin(n,coins); 
	}
}
