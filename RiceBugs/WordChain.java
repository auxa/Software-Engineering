
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class WordChain{
	public static void main(String[] args){
		System.out.println("Number of Words");
		Scanner scanner = new Scanner(System.in); 
		int numberOfWords = scanner.nextInt();
		String[] wordsIn = new String[numberOfWords];
		boolean badInput = false;
		System.out.println("Enter the words");

		for(int i = 0; i < numberOfWords; i ++){
			wordsIn[i] = scanner.next();

			if(wordsIn[i].length() < 3)
				badInput = true;
		}
		scanner.close();
		if(!badInput){
			ArrayList<Integer> checkedIndex = new ArrayList<Integer>();
			checkedIndex.add(0);
			String wordChain = wordsIn[0] + " " + findPath(checkedIndex, wordsIn);

			if(wordChain.split(" ").length != numberOfWords)
				System.out.println("IMPOSSIBLE");
			else
				System.out.println(wordChain.replace(" ", "\n"));
		}else{
			System.out.println("IMPOSSIBLE");
		}
	}
	public static boolean checkIndexes(ArrayList<Integer> checked, int j){
		for(int i = 0; i < checked.size(); i ++){
			if(checked.get(i) == j)
				return true;
		}
		return false;
	}
	public static String findPath(ArrayList<Integer> checkedThese, String[] wordsIn){

		if(checkedThese.size() == wordsIn.length)
			return "";		
		
		String lastWordCheck = wordsIn[checkedThese.get(checkedThese.size() - 1)];

		for(int j = 0; j < wordsIn.length; j ++){
			boolean isUsed = checkIndexes(checkedThese,j);

			if(!isUsed){
				int smallestWord = lastWordCheck.length();
				
				if(wordsIn[j].length() < smallestWord)
					smallestWord = wordsIn[j].length();
				
				for(int k = 3; k <= smallestWord; k ++){
					
					if(checkThis(lastWordCheck, k, wordsIn[j])){
						ArrayList<Integer> newArray = copyOver(checkedThese, j);
						String total = wordsIn[j] + " " + findPath(newArray, wordsIn);
						
						if(isEnd(total, wordsIn.length, newArray.size())){
							return total;
						}

					}
				}
			}
		}return "";
	}
	public static boolean checkThis(String lastWord, int k, String word){

		String temp = lastWord.substring(lastWord.length() - k);
		String temp2 = word.substring(0, k);

		if(temp.equals(temp2)){
			return true;
		}
		return false;
	}
	public static boolean isEnd(String total, int var, int otherVar){

		int spaceCount = total.split(" ").length;
		int otherCount = var - otherVar + 1;
		if(spaceCount == otherCount){
			return true;
		}
		else{
			return false;
		}
	}
	public static ArrayList<Integer> copyOver(ArrayList<Integer> checked, int j){
		ArrayList<Integer> checkedIndex = new ArrayList<Integer>();
		for(int i=0; i<checked.size();i++){
			checkedIndex.add(checked.get(i));
		}
		checkedIndex.add(j);
		return checkedIndex;
	}
}
