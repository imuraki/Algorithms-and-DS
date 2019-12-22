import java.util.HashMap;
import java.util.Scanner;

public class CoinChanges {
	
	int minCoins(int[] coins, int sum){
		
		return minCoins(coins, new HashMap<Integer, Integer>(), sum);
	}
	
	int minCoins(int[] coins, HashMap<Integer, Integer>minmap, int sum){
		
		if(sum == 0)
			return 0;
		
		if(sum < 0)
			return -1;
		
		
		if(minmap.containsKey(sum))
			return minmap.get(sum);
		
		
		int minval = Integer.MAX_VALUE;
		
		for(int coin : coins){
			int changeResult = minCoins(coins, minmap, sum-coin);
			if(changeResult >= 0 && changeResult < minval)
				minval = changeResult;
		}
		
		minval = (minval == Integer.MAX_VALUE) ? -1 : 1+minval;
		minmap.put(sum, minval);
		return minval;
		
	}
	
	public static void main(String [] argv){
		
		CoinChanges coinchanges = new CoinChanges();
		int coins[] = {1, 5, 10, 25};
		
		System.out.println("Minimum number of coins required are : " +coinchanges.minCoins(coins, 83));
	}
}
