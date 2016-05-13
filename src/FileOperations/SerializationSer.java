package FileOperations;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SerializationSer extends Serialization {
	public SerializationSer() {

	}

	@Override
	public void writeInDictionary(Map<String, Set<String>> dictionary) {
		try {
			FileOutputStream fileOut = new FileOutputStream(super.filename + ".ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(dictionary);
			out.close();
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Set<String>> readFromDictionary() {
		FileInputStream fileIn;
		Map<String, Set<String>> obj = new HashMap<String, Set<String>>();
		try {
			fileIn = new FileInputStream(super.filename + ".ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			obj = (Map<String, Set<String>>) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
