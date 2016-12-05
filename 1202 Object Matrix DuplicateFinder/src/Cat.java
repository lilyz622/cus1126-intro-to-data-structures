
public class Cat {
	public String name;
	public String color;
	public String eyecolor;
	public int weight;
	
	
	
	public Cat(String name, String color, String eyecolor, int weight) {
		super();
		this.name = name;
		this.color = color;
		this.eyecolor = eyecolor;
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((eyecolor == null) ? 0 : eyecolor.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + weight;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat other = (Cat) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (eyecolor == null) {
			if (other.eyecolor != null)
				return false;
		} else if (!eyecolor.equals(other.eyecolor))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}
	
	
}
