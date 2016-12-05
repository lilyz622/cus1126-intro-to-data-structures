/**
 * Project: Object Matrix Duplicate Finder
 * 
 * c) The time complexity of finding all the duplicates is usually O(n) because 
 * duplicateFinder hashes all the objects to hashtable, with the object as
 * key and the position of the object in the matrix as value. Therefore same
 * objects hash to the same position, however, if there is already a value
 * in that bucket, it will return the positions in the matrix of both the 
 * duplicate and that of the original. 
 * 
 * For each object, the containsKey(Cat Key) method is on average O(1), however, 
 * if the hashcode is really bad or the ratio is really large, in the worst 
 * case all values hash to one bucket, so that the containsKey method has O(n).
 * This is also impossible because the java library implementation does not
 * allow this to occur. 
 * 
 * Like the containsKey, the get(Cat Key) method is on average O(1), but also
 * worst case O(n).
 * 
 * The hashtable.put(key, value) method has O(1), as it hashes directly to the
 * value and even if another value is there, it just adds it to the end O(1).
 * 
 * Therefore, the time complexity of finding the duplicates is usually just the
 * time it needs to traverse through the array, so O(n). However, the absolute
 * worst time, which is nearly impossible, is O(n*n), if there were only one 
 * bucket in the hashtable and the bucket acted as a linked list.
 * 
 */

import java.util.Hashtable;

public class Object_Matrix_DuplicateFinder {
	public static void main(String[] args){
		Cat[][] array = {
				{new Cat("A","Yellow", "Green", 30), 
					new Cat("B", "Black", "Brown", 60), //
					new Cat("C", "Tabby", "Blue", 20)}, //
				{new Cat("D","Yellow", "Green", 30), 
						new Cat("B", "Black", "Brown", 60), //Duplicate
						new Cat("F", "Tabby", "Blue", 20)},
				{new Cat("G","Yellow", "Green", 30), 
							new Cat("H", "Black", "Brown", 60), 
							new Cat("C", "Tabby", "Blue", 20)} //Duplicate
		};
		
		duplicateFinder(array);
	}
	
	public static void duplicateFinder(Cat[][] array){
		
		Hashtable<Cat, Integer> table = new Hashtable();
		
		for (int row = 0; row < array.length; row++){
			for (int column = 0; column < array[0].length; column ++){
				Cat tempcat = array[row][column];
				if (table.containsKey(tempcat)){
					int prevcat = (int) table.get(tempcat);
					System.out.println(tempcat.name+" at ["+row+","+column+"] is a duplicate of "
							+ "object at ["+prevcat/array.length+","+prevcat%array.length+"]");
				}else {
					table.put(tempcat, row*array.length+column);
				}
			}
		}
			
	}

}
