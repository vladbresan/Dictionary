package FileOperations;
import java.util.Map;
import java.util.Set;

public abstract class Serialization {
	protected String filename = "Dictionary";
	
	public abstract void writeInDictionary(Map<String,Set<String>> dictionary);
	public abstract Map<String,Set<String>> readFromDictionary();
}
