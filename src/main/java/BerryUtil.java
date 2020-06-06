import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpResponse;
import java.util.function.Predicate;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class BerryUtil {

	public static JSONObject getBerryData(String id) throws Exception {
		String rootURL = "https://pokeapi.co/api/v2/berry/";
		rootURL += URLEncoder.encode(id,   "UTF-8");

		JSONObject berryDetails = new JSONObject();
    	try {

            URL url = new URL(rootURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }

            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
	        StringBuilder sb = new StringBuilder();
            String line; 
            
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            berryDetails = new JSONObject(sb.toString());
            conn.disconnect();
            
        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
    	
        return berryDetails;
    }
}
