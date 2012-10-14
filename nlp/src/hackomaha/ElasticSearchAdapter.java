package hackomaha;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ElasticSearchAdapter {
	static String HOST = "simomaha.com";
	static int PORT = 9200;

	public static String get(String path) {
        WebResource resource = Client.create().resource("http://" + HOST + ":" + PORT + path);
        return resource.get(String.class);
	}
	
	public static void put(String path, String content) {
        WebResource resource = Client.create().resource("http://" + HOST + ":" + PORT + path);
        resource.put(content);
	}
	
	public static void main(String[] args) {
//		for (Agenda agenda : Agenda.getAll()) {
//			agenda.process();
//			agenda.save();
//		}
        Agenda.get("2012-10-16");
	}
}
