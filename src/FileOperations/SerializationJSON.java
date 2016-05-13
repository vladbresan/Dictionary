package FileOperations;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class SerializationJSON extends Serialization{

	@SuppressWarnings("unchecked")
	@Override
	public void writeInDictionary(Map<String, Set<String>> dictionary) {
		JSONObject dictionaryObj = new JSONObject();
		for (java.util.Map.Entry<String, Set<String>> entry : dictionary.entrySet()) {
			JSONArray jsonObj = new JSONArray();
			for (String synonym : entry.getValue()) {
				jsonObj.add(synonym);
			}
			dictionaryObj.put(entry.getKey(), jsonObj);
		}
		try {

			FileWriter file = new FileWriter(super.filename+".json");
			file.write(dictionaryObj.toJSONString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Set<String>> readFromDictionary() {
		Map<String,Set<String>> output = new TreeMap<String,Set<String>>();
		JSONParser parser = new JSONParser();

		try {

			Object obj = parser.parse(new FileReader(super.filename+".json"));

			JSONObject jsonObject = (JSONObject) obj;

			Set<String> keys = (Set<String>) jsonObject.keySet();

			for(String key : keys){
				Set<String> values = new TreeSet<String>();
				JSONArray arr = (JSONArray) jsonObject.get(key);
				Iterator<String> iterator = arr.iterator();
				while (iterator.hasNext()) {
					values.add(iterator.next());
				}
				output.put(key, values);
			}			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
		return output;
	}

}
