package hackomaha;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ElasticSearchAdapter {
	static String HOST = "simomaha.com";
	static int PORT = 9200;
	
	public static String get(String path) {
		String content = "";
		
		try {
			URL url = new URL("http://" + HOST + ":" + PORT + path);
			URLConnection connection = url.openConnection();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null)
				content += inputLine + "\n";
			
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content;
	}
	public static void main(String[] args) {
//		for (Agenda agenda : Agenda.getAll()) {
//			agenda.process();
//			agenda.save();
//		}

		Agenda.get("2012-10-16");
	}
}
