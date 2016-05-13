package DictionaryPack;

import java.util.Map;
import java.util.Set;

/**
 * @author Vlad
 *
 */
public interface DictionaryProc {
	
	/**
	 * @pre word != null && !synonyms.isEmpty()
	 * @post dictionary.size() = previous dicitonary.size() +1 
	 * @param word
	 * @param synonyms
	 */
	public void addWord(String word,String synonyms,Map<String,Set<String>> dict);
	/** @pre word!=NULL and synonym!=NULL
	 *  @post new dictionary.get(word).size() == previous dictionary.get(word).size() + val;
	 *  @param 2 Strings : the word and the synonym to be added
	 * 	@return
	 */
	public void addSynonyms(String word, String synonym,Map<String,Set<String>> dict);
	/** @pre word!=NULL and synonym!=NULL
	 *  @post new dictionary.size() = oldDictionary.size() -1;
	 *  @param 2 Strings : the word and the synonym to be added
	 * 	@return
	 */
	public void deleteWord(String word);
	
	/**
	 * @pre !dictionary.isEmpty()
	 * @post
	 * @param
	 * @return
	 */
	public boolean isConsistent(Map<String,Set<String>> dict);
}
