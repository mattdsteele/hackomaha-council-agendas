package hackomaha;

import java.util.ArrayList;
import java.util.Collection;

import org.json.JSONArray;
import org.json.JSONObject;

public class Agenda {
	public static final String DB = "citycouncil";
	public static final String TABLE = "agendas";
	
	private JSONObject json;
	
	public Agenda(JSONObject json) {
		this.json = json;
	}
	
	public static Collection<Agenda> getAll() {
		return null;
	}
	
	public static Agenda get(String id) {
		String content = ElasticSearchAdapter.get("/" + DB + "/" + TABLE + "/" + id);
		JSONObject json = null;
		
		try {
			json = new JSONObject(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new Agenda(json);
	}

	public Collection<Item> getItems() {
		Collection<Item> items = new ArrayList<Item>();
		
		try {
			JSONArray itemsJson = json.getJSONObject("_source").getJSONArray("items");
			
			for (int i = 0; i < itemsJson.length(); i ++) {
				items.add(new Item(itemsJson.getJSONObject(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return items;
	}
	
	public void process() {
		for (Item item : getItems()) {
			item.process();
		}
	}
	
	public boolean save() {
		return false;
	}
}
