package application;

//Alphavantage.co APIKey: I39UJCSEE96GJQ9C
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.Certificate;
import java.io.*;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

import org.json.*;


public class GetData{
	
	/*public static void main(String[] args)
		{
	        new GetData().testIt();
		}
	*/
	public String testIt(){

		String https_url = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=MSFT&interval=15min&apikey=I39UJCSEE96GJQ9C";
		URL url;
		try {

			url = new URL(https_url);
			HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
			
			
			return reader(con);
		} 
		catch (MalformedURLException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}


	
	private String reader(HttpsURLConnection con){
		if(con!=null){

			try {

				BufferedReader br =new BufferedReader(
				
				new InputStreamReader(con.getInputStream()));

				String input;
				StringBuffer PreJson = new StringBuffer();

				while ((input = br.readLine()) != null){
					PreJson.append(input+"\n");
				}
	   
				br.close();
				
				return PreJson.toString();
				//parseJson(PreJson);
			} 
		
			catch (IOException e) {
				e.printStackTrace();
			}

		}
		return null;

	}

}
