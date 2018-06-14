import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NMostFrequent{
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws FileNotFoundException{
		
		File Bible = new File("src\\bible.dat");
		Scanner file = new Scanner(Bible);
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Find n most frequent words. What is n? Integers only.");
		int n = scan.nextInt();
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		while(file.hasNext()){
			String str = file.next().toLowerCase().trim();
			
			if(map.containsKey(str))
				map.put(str, map.get(str) + 1);
			else
				map.put(str, 1);
		}
		
		//Sorts map
		Object[] arr = map.entrySet().toArray();
		Arrays.sort(arr, new Comparator() {
		    public int compare(Object o1, Object o2) {
		        return ((Map.Entry<String, Integer>) o2).getValue().compareTo(((Map.Entry<String, Integer>) o1).getValue());
		    }
		});
		
		//Prints
		for (int i = 0; i < n; i++) 
			System.out.println(((Map.Entry<String, Integer>) arr[i]).getKey() + " : " + ((Map.Entry<String, Integer>) arr[i]).getValue());
	}
}