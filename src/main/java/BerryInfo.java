
public class BerryInfo {

	public final String name;
	public final int size;
	public final int growthTime;

	public BerryInfo(final String name, final int size, final int growthTime) {
		this.name = name;;
		this.size = size;
		this.growthTime = growthTime;
	}

	public String toString() {
		return name + " " + size + " " + growthTime;
	}

	public String getName() {
		return name;
	}
	
	public int getSize() {
		return size;
	}
	
	public int getGrowthTime() {
		return growthTime;
	}
	
}
