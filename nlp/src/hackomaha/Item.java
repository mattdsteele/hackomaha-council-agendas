package hackomaha;

import org.json.JSONException;
import org.json.JSONObject;

public class Item {
	private JSONObject json;
	
	public Item(JSONObject json) {
		this.json = json;
	}
	
	public void process() {
		try {
//			for (int i = 0; i < json.getJSONArray("text").length(); i++) {
//				String currItemStr = (String)json.getJSONArray("text").get(i);
//				AgendaItem agendaItem = new AgendaItem(currItemStr);
//				
//			}
			String allItems = "";
			for (int i = 0; i < json.getJSONArray("text").length(); i++) {
				allItems += json.getJSONArray("text").get(i) + "\n";
			}
			AgendaItem agendaItem = new AgendaItem(allItems);
			for(String currKey : agendaItem.map.keySet()) {
				this.json.put(currKey, agendaItem.map.get(currKey));
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
