import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * StopWordRemover removes stop words from an arraylist of strings, given the arraylist of stopwords.
 * Date: Sept. 9, 2016
 * @author yzhan265
 *
 */

public class StopWordRemover {
	public static void main(String[] args){
		
		System.out.println("This program removes stop words from ArrayLists.");
		
		// test string
		String firstString = "Two roads diverged in a yellow wood, And sorry I could not travel both "
				+"And be one traveler, long I stood And looked down one as far as I could "
				+"I I I "
				+"To where it bent in the undergrowth;";
		
		// convert the test string into an arraylist --> too much of a hassle to individually
		// hardcode and add() each string to the arraylist
		ArrayList<String> firstList = new ArrayList<String>(splitString(firstString));
		System.out.println("The first list of words are:"+Arrays.toString(firstList.toArray()));
		
		// test string of stop words
		String stopWordsString = "I, in, the";
		
		// convert the test string of stop words into an arraylist
		ArrayList<String> stopWords = new ArrayList<String>(splitString(stopWordsString));
		System.out.println("The list of stop words are:"+Arrays.toString(stopWords.toArray()));
		
		// remove the stop words from the first list.
		removeStopWords(firstList, stopWords);
		
		// print out the remaining words
		System.out.println("Once the stop words are removed, the remaining words are:"
				+"\n"
				+Arrays.toString(firstList.toArray()));
		
	}
	
	public static void removeStopWords(ArrayList<String> firstList, ArrayList<String> stopWords){
		int firstListIndex = 0; // keeps track of current index for the firstList
		
		// for each element in the firstList, check if it matches a element in stopWords.
		// if they match, remove the element from the firstList,
		// if not, continue onto the next element.
		while (firstListIndex < firstList.size()){
			for (int stopIndex = 0; stopIndex < stopWords.size(); stopIndex++){
				if (firstList.get(firstListIndex).equals(stopWords.get(stopIndex))){
					firstList.remove(firstListIndex);
					firstListIndex --; // subtracting one from the index counter makes up for the removed word.
				}// if
			}// for			
			firstListIndex ++;
		}// while
	}
	
	public static List splitString(String inputString){
		List firstList = Arrays.asList(inputString.split("\\W+")); // removes and nonword and splits the string.
		return firstList;
	}
}

/*
 * OUTPUT
 * 
 * This program removes stop words from ArrayLists.
The first list of words are:[Two, roads, diverged, in, a, yellow, wood, And, sorry, I, could, not, travel, both, And, be, one, traveler, long, I, stood, And, looked, down, one, as, far, as, I, could, I, I, I, To, where, it, bent, in, the, undergrowth]
The list of stop words are:[I, in, the]
Once the stop words are removed, the remaining words are:
[Two, roads, diverged, a, yellow, wood, And, sorry, could, not, travel, both, And, be, one, traveler, long, stood, And, looked, down, one, as, far, as, could, To, where, it, bent, undergrowth]
*/
