package com.decoverri.treasureGenerator.converter;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONStringer;

import com.decoverri.treasureGenerator.interfaces.Treasure;

public class JsonConverter {

	public String treasureToJson(List<Treasure> treasures) throws JSONException {
		JSONStringer jsonStringer = new JSONStringer();
		jsonStringer.object().key("treasures").array();
		for (Treasure treasure : treasures) {
			jsonStringer.object()
						.key("name").value(treasure.getName())
						.key("value").value(treasure.getTreasureValue())
						.endObject();
		}
		jsonStringer.endArray().endObject();
		return jsonStringer.toString();
	}

}
