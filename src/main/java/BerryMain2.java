import org.json.JSONException;
import org.json.JSONObject;

public class BerryMain2 {

	public static void main(String[] args) {
		int count = 0;
		try { count = (int) BerryUtil.getBerryData("").get("count");
		} catch (JSONException e1) {
			e1.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		int biggestSize = 0;
		int shortestTime = Integer.MAX_VALUE;
		String highestName = null;
		
		for (int id = 1; id < count; id++) {
			try {
				JSONObject berryData = BerryUtil.getBerryData(String.valueOf(id));
				
				int size = berryData.getInt("size");
				int growthTime = berryData.getInt("growth_time");
				String name = berryData.getString("name");
				
				if (growthTime < shortestTime) {
					shortestTime = growthTime;
					biggestSize = size;
					highestName = name;
				} else if (growthTime == shortestTime) {
					if (size > biggestSize) {
						biggestSize = size;
						highestName = name;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Largest Berry You Can Grow With The Shortest Amount of Time:");		
		System.out.println("berry name: " + highestName + "\nsize: " + String.valueOf(biggestSize) + "\ngrowth time: " + String.valueOf(shortestTime));
	}

}
