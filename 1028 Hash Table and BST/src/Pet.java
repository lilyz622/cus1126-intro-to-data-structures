
public class Pet {
	public String pName;
	public String owner;
	public String breed;
	public Size size;
	
	
	public Pet(String pName, String owner, String breed, Size size) {
		this.pName = pName;
		this.owner = owner;
		this.breed = breed;
		this.size = size;
	}
	
	public String toString(){
		return "Pet Name:"+pName+"\tOwner:"+owner+"\tBreed:"+breed+"\tSize:"+size;
	}
}
