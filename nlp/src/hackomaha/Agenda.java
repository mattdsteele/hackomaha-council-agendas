package hackomaha;

import java.util.Collection;

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

	public boolean process() {
		return false;
	}
	
	public boolean save() {
		return false;
	}
}
