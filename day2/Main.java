import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main{
	private int abcScore=0, xyzScore=0;
	int play (char abc, char xyz){
		//a,x==rock
		//b,y==paper
		//c,z==scissors
		//The winner of the whole tournament is the player with the highest score. Your total score is the sum of your scores for each round.
		//The score for a single round is the score for the shape you selected (1 for Rock, 2 for Paper, and 3 for Scissors) plus the score for the outcome of the round (0 if you lost, 3 if the round was a draw, and 6 if you won).
		int score = 0;
		switch(abc){
			case 'A':
				switch(xyz){
					case 'X':
						//Tie
						score=1+3;
						System.out.println("Tie a-x");
						break;
					case 'Y':
						//Win
						score=2+6;
						System.out.println("Win a-y");
						break;
					case 'Z':
						//Lose
						score=3+0;
						System.out.println("Lose a-z");
						break;
				}
				break;
			case 'B':
				switch(xyz){
					case 'X':
						//Lose
						score=1+0;
						System.out.println("Lose b-x");
						break;
					case 'Y':
						//Tie
						score=2+3;
						System.out.println("Tie b-y");
						break;
					case 'Z':
						//Win
						score=3+6;
						System.out.println("Win b-z");
						break;
				}
				break;
			case 'C':
				switch(xyz){
					case 'X':
						//Win
						score=1+6;
						System.out.println("Win c-x");
						break;
					case 'Y':
						//Lose
						score=2+0;
						System.out.println("Lose c-y");
						break;
					case 'Z':
						//Tie
						score=3+3;
						System.out.println("Tie c-z");
						break;
				}
				break;
		}
		return score;
	}
	public static void main(String[] args) throws FileNotFoundException{
		Scanner f = new Scanner(new File("input"));
		Main m = new Main();
		char elf =  ' ',me=' ';
		int count = 0, score=0;
		boolean first = true;
		while(f.hasNext()){
			String str=f.next();
			// System.out.println(str+"\n"+count+"%2="+(count%2));
			switch(count%2){
				case 0:
					if(!first){
						// System.out.println(m.play(elf, me));
						score+=m.play(elf,me);
					}
					elf=str.charAt(0);
					first=false;
					break;
				case 1:
					me=str.charAt(0);
					break;
			}
			count++;
		}
		score+=m.play(elf, me);
		System.out.println(score);
	}
}
