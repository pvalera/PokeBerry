import org.json.JSONException;
import org.json.JSONObject;

public class BerryMain {

	public static void main(String[] args) {
		int count = 0;
		try { count = (int) BerryUtil.getBerryData("").get("count");
		} catch (JSONException e1) {
			e1.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		double highestRatio = 0.0;
		String highestName = null;
		
		for (int id = 1; id < count; id++) {
			try {
				JSONObject berryData = BerryUtil.getBerryData(String.valueOf(id));
				
				int size = berryData.getInt("size");
				int growthTime = berryData.getInt("growth_time");
				double ratio = size / growthTime;
				
				if (ratio > highestRatio) {
					highestRatio = ratio;
					highestName = berryData.getString("name");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Largest Berry You Can Grow With The Shortest Amount of Time (Ratio):");		
		System.out.println("berry name: " + highestName + "\nratio: " + String.valueOf(highestRatio));
	}

}
