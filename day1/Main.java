import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
class Main{
	public static void main(String[] args) throws FileNotFoundException{
		// Part 1
		// Find the Elf carrying the most Calories. How many total Calories is that Elf carrying?
		Scanner f = new Scanner(new File("input"));
		int numberOfElfs = 0;
		Map<Integer,Integer> elfCalories = new TreeMap<Integer,Integer>();
		while(f.hasNextLine()){
			Boolean cont = false;
			int sum=0;
			while(f.hasNextLine()&&!cont){
				String numString = f.nextLine();
				int num=0;
				if(numString==""){
					cont=true;
				}else{
					num=Integer.parseInt(numString);
					sum+=num;
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
		// Print
		System.out.println("Part 1"+"\nElf :: " + bigest +"\nCalories :: " +elfTotalCalories.get(bigest));
		// Part 2
		// Find the top three Elves carrying the most Calories. How many Calories are those Elves carrying in total?
		int top=0,top1=0,top2=0;
		for(int j=0;j<elfTotalCalories.size();j++){
			if(elfTotalCalories.get(top2)<elfTotalCalories.get(j))
				if(elfTotalCalories.get(top1)<elfTotalCalories.get(j))
					if(elfTotalCalories.get(top)<elfTotalCalories.get(j))
						top=j;
					else
						top1=j;
				else
					top2=j;
		}
		// Print
		System.out.println("Part 2"+"\nTop :: " + top + " :: Calories :: " + elfTotalCalories.get(top) + "\nTop1 :: " + top1 + " :: Calories :: " + elfTotalCalories.get(top1) + "\nTop2 :: " +top2+ " :: Calories :: " + elfTotalCalories.get(top2) + "\nTotal :: " +(elfTotalCalories.get(top)+elfTotalCalories.get(top1)+elfTotalCalories.get(top2)));
	}
}
