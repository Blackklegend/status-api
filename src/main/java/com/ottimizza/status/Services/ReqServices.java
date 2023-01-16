package com.ottimizza.status.Services;

import com.ottimizza.status.Model.Body;
import com.ottimizza.status.StatusApplication;

import java.util.List;
import java.time.ZoneId;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.time.LocalDateTime;

import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.stereotype.Service;

@Service
public class ReqServices {

	private void removeFromMap(String key) {
		if (StatusApplication.rotaInfoLog.get(key) != null) {
			StatusApplication.rotaInfoLog.remove(key);
		}
	}

	public String addToList(Body rota) {
	
		if (rota.getId() == null) {
			Body body = new Body(rota);
			String key = body.getId();

			removeFromMap(key);
			StatusApplication.rotaInfoLog.put(key, body);

		} else {
				rota.setData(LocalDateTime.now(ZoneId.of("Brazil/East")));

				String key = rota.getId();

				removeFromMap(key);
				StatusApplication.rotaInfoLog.put(key, rota);
		}

		return "Status registered successfully";
	}

	public HashMap<String, JSONArray> serverParser(LinkedHashMap<String, Body> map) {
		
		HashMap<String, JSONArray> retorno = new HashMap<String, JSONArray>();
		List<JSONObject> s1 = new ArrayList<JSONObject>(), s3 = new ArrayList<JSONObject>(), s5 = new ArrayList<JSONObject>(), s6 = new ArrayList<JSONObject>();

		for (Entry<String, Body> object : map.entrySet()) {
			JSONObject jo = new JSONObject(object.getValue());

			switch (jo.optString("servidor").toLowerCase()) {
			case "s1":
				s1.add(jo);
				break;

			case "s3":
				s3.add(jo);
				break;

			case "s5":
				s5.add(jo);
				break;

			case "s6":
				s6.add(jo);
				break;

			default:
				break;
			}
		}


		retorno.remove("S1");
		retorno.remove("S3");
		retorno.remove("S5");
		retorno.remove("S6");
		
		retorno.put("S1", new JSONArray(s1));
		retorno.put("S3", new JSONArray(s3));
		retorno.put("S5", new JSONArray(s5));
		retorno.put("S6", new JSONArray(s6));
		
		return retorno;
	}
}
