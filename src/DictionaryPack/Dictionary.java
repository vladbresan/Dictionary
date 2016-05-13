package DictionaryPack;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import FileOperations.Serialization;
import FileOperations.SerializationJSON;
import FileOperations.SerializationSer;

public class Dictionary implements DictionaryProc {
	public Map<String, Set<String>> dictJSON;
	public Map<String, Set<String>> dictSer;
	private Serialization sJSON;
	private Serialization sSer;

	public Dictionary() {
		sJSON = new SerializationJSON();
		sSer = new SerializationSer();
		dictJSON = sJSON.readFromDictionary();
		dictSer = sSer.readFromDictionary();
	}

	@Override
	public void addWord(String word, String synonyms,Map<String,Set<String>> dict) {
		assert word != null : "Word is null";
		assert synonyms!=null : "Synonym is empty";
		int valPrecDict = dict.size();
		if (dict.containsKey(word)) {
			addSynonyms(word, synonyms,dict);
		} else {
			Set<String> setSyn = new HashSet<String>();
			setSyn.add(synonyms);
			dict.put(word, setSyn);
			if (!dict.containsKey(synonyms))
				addWord(synonyms, word,dict);
			assert dict.size() > valPrecDict: "Something went wrong";
		}
		assert isConsistent(dictJSON):".json dictionary is incosistent";
	//	assert isConsistent(dictSer):".ser dictionary is incosistent";
	}

	@Override
	public void addSynonyms(String word, String synonym,Map<String,Set<String>> dict) {
		assert word != null : "Word is null";
		assert synonym != null : "Synonym is null";
		int valPrec = 0;
		valPrec = dict.get(word).size();
		dict.get(word).add(synonym);
		dict.put(word, dictJSON.get(word));
		if (!dictJSON.containsKey(synonym))
			addWord(synonym, word,dict);
		assert dictJSON.get(word).size() >= valPrec : "Error adding the synonym";
		assert isConsistent(dictJSON):".json dictionary is incosistent";
		assert isConsistent(dictSer):".ser dictionary is incosistent";
	}

	@Override
	public void deleteWord(String word) {
		assert word != null : "Word is null";
		dictJSON.remove(word);
		for (String s : dictJSON.keySet()) {
			for (String s1 : dictJSON.get(s))
				if (s1.equals(word)) {
					dictJSON.get(s).remove(s1);
					break;
				}
		}
	
		try {
			for (String s : dictJSON.keySet())
				if (dictJSON.get(s).size() == 0)
					deleteWord(s);
		} catch (Exception e) {
		}

		assert isConsistent(dictJSON):".json dictionary is incosistent";
		assert isConsistent(dictSer):".ser dictionary is incosistent";
	}

	@Override
	public boolean isConsistent(Map<String,Set<String>> dict) {
		boolean exists = true;
		if (dict.size() != 0)
			for (String s : dict.keySet()){
				if(dict.get(s).size()==0){
					exists = false;
					}
				for (String s1 : dict.get(s))
					exists = exists & dict.containsKey(s1);
				}
		else
			exists = false;
		return exists;
	}

}
