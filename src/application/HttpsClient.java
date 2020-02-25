package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class HttpsClient {
	
	public String Connect(String TimeSeries,
			String Symbol,
			String TimeInterval) {

		String ApiKey = "II39UJCSEE96GJQ9C";
		
		String httpsURL = "https://www.alphavantage.co/query?function=" + TimeSeries + "&symbol=" + Symbol + "&interval=" + TimeInterval + "&apikey=" + ApiKey;
		
		URL url;
		
		try {
			
			url = new URL(httpsURL);
			HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
			
			return reader(connection);
		}
		
		catch (MalformedURLException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	private String reader(HttpsURLConnection connection){
		
		if(connection!=null){

			try {

				BufferedReader BR =new BufferedReader(
				
				new InputStreamReader(connection.getInputStream()));

				String input;
				StringBuffer Data = new StringBuffer();

				while ((input = BR.readLine()) != null){
					Data.append(input+"\n");
				}
	   
				BR.close();
				
				return Data.toString();
				
			} 
		
			catch (IOException e) {
				e.printStackTrace();
			}

		}
		
		return null;
		
	}
}
