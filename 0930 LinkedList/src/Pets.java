/**
 * definition of the Pets class
 * @author yzhan265
 *
 */

public class Pets {
	protected String species;
	protected String name;
	public int ID;

	/**
	 * constructor assigning species, name, id
	 * @param s species
	 * @param n name
	 * @param i ID
	 */
	public Pets (String s, String n, int i){
		species=s;
		name = n; 
		ID = i;
	}

	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getId() {
		return ID;
	}
	public void setId(int id) {
		this.ID = id;
	}
	
	public String toString() {
		return "ID: "+ID+"\tName: "+name+"\tSpecies: "+species;
	}
}
