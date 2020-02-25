package application;
import java.util.Arrays;
import java.util.HashMap;

// https://github.com/stleary/JSON-java
import org.json.*;

public class JSONInterpreter {
	
	public void Converter(String str) {
		HttpsClient client = new HttpsClient();
		JSONObject JSON = new JSONObject(str);
		
		System.out.println(JSON);

		String[] TimeSeries = JSONObject.getNames(JSON);
		System.out.println(Arrays.toString(TimeSeries));
		
		JSONObject JO = getJSON(JSON, TimeSeries[0]);
		System.out.println(JO);
		
		
		
		String DataSeries[] = {"1. open", "2. high", "3. low", "4. close", "5. volume"};
		

		}
		//JSONArray arr1 = KeyArr(JO);
		//System.out.println(arr1);
	
	private static JSONObject getJSON(JSONObject JSON, String key) {
		JSONObject KeyJSON = JSON.getJSONObject(key);
		return KeyJSON;
	}
	
	
}
