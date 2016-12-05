
public class BucketLinkedList {
	public Pet pet;
	public Pet next;
	
	public boolean addPet(Pet pet){
		if (this.pet == null) {
			this.pet = pet;
			return true;
		} else if (this.pet.equals(pet)){
			System.out.println("Dog is already here.");
			return false;
		} else if (this.pet.size == Size.LARGE){
			System.out.println("Error adding dog: Already contains a large dog.");
			return false;
		} else if (next != null){
			System.out.println("Error adding dog: Already contains two dogs.");
			return false;
		} else {
			next = pet;
			return true;
		}
	}
	
	public String toString(){
		String print = "";
		if (pet != null) {
			print+= pet+"";
		} else {
			print+= "null";
		}
		
		print+="\n\t";
		if (next != null) {
			print+= next+"";
		} else {
			print+= "null";
		}
		return print;
	}
	
	public void popPet(){
		
	}
	

}
