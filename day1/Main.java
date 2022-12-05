import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
class Main{
	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("input"));
		int numberOfElfs = 0;
		// Map<Integer,ArrayList<Integer>> elfCalories = new HashMap<Integer,ArrayList<Integer>>();
		Map<Integer,Integer> elfCalories = new TreeMap<Integer,Integer>();
		while(f.hasNextLine()){
			// ArrayList<Integer> items = new ArrayList<Integer>();
			Boolean cont = false;
			int sum=0;
			while(f.hasNextLine()&&!cont){
				String numString = f.nextLine();
				// System.out.println(numString);
				int num=0;
				if(numString==""){
					cont=true;
					// System.out.println("New Elf");
				}else{
					num=Integer.parseInt(numString);
					sum+=num;
					// items.add(num);
					// System.out.println(num);
				}
			}
			elfCalories.put(numberOfElfs, sum);
			numberOfElfs++;
		}
		ArrayList<Integer> elfTotalCalories = new ArrayList<Integer>();
		Iterator<Integer> i=elfCalories.values().iterator();
		int bigest=0;
		while(i.hasNext())
			elfTotalCalories.add(i.next());
		for(int j=0;j<elfTotalCalories.size();j++){
			if(elfTotalCalories.get(bigest)<elfTotalCalories.get(j))
				bigest=j;
		}

		// while(i.hasNext()){
		// 	ArrayList<Integer> arr=i.next();
		// 	int total = 0;
		// 	for(Integer item:arr)
		// 		total+=item;
		// 	elfTotalCalories.add(total);
		// }
		// int large=0;
		// for(int j=1;j>elfTotalCalories.size();j++){
		// 	if(elfTotalCalories.get(large)<elfTotalCalories.get(j))
		// 		large=j;
		// }
		System.out.println("Elf :: " + bigest +"\nCalories :: " +elfTotalCalories.get(bigest));
	}
}
