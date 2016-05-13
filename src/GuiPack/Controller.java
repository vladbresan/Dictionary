package GuiPack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import DictionaryPack.Dictionary;
import FileOperations.Serialization;
import FileOperations.SerializationJSON;
import FileOperations.SerializationSer;

public class Controller {
	GUI guiObj = GUI.getInstance();
	Serialization json = new SerializationJSON();
	Serialization ser = new SerializationSer();
	Dictionary dict = new Dictionary();

	public Controller() {
		actions();
	}

	private void write() {
		if (guiObj.checkBoxJson.isSelected()) {
			json.writeInDictionary(dict.dictJSON);
		}
		if (guiObj.checkBoxSer.isSelected()) {
			ser.writeInDictionary(dict.dictSer);
		}
	}

	private void actions() {
		guiObj.btnAddWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (guiObj.checkBoxJson.isSelected()) {
					dict.addWord(guiObj.addOrDeleteWordField.getText(), guiObj.addSynField.getText(), dict.dictJSON);
				}
				if (guiObj.checkBoxSer.isSelected()) {
					dict.addWord(guiObj.addOrDeleteWordField.getText(), guiObj.addSynField.getText(), dict.dictSer);
				}
				write();
			}
		});
		guiObj.btnDeleteWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dict.deleteWord(guiObj.addOrDeleteWordField.getText());
				write();
			}
		});
		guiObj.btnSeeWords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View obj = new View();
				if (guiObj.checkBoxJson.isSelected()) {
					obj.seeSynonyms(guiObj.addOrDeleteWordField.getText(), dict.dictJSON);
				}
				if (guiObj.checkBoxSer.isSelected()) {
					obj.seeSynonyms(guiObj.addOrDeleteWordField.getText(), dict.dictSer);
				}
			}
		});
		guiObj.btnAddSynonym.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (guiObj.checkBoxJson.isSelected()) {
					dict.addSynonyms(guiObj.addOrDeleteWordField.getText(), guiObj.addSynField.getText(),
							dict.dictJSON);
				}
				if (guiObj.checkBoxSer.isSelected()) {
					dict.addSynonyms(guiObj.addOrDeleteWordField.getText(), guiObj.addSynField.getText(), dict.dictSer);
				}
				write();
			}
		});
		guiObj.btnSeeDictionary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View obj = new View();
				if (guiObj.checkBoxJson.isSelected()) {
					obj.seeDictionary(dict.dictJSON);
				}
				if (guiObj.checkBoxSer.isSelected()) {
					obj.seeDictionary(dict.dictSer);
				}
			}
		});
		guiObj.btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View obj = new View();
				if (guiObj.checkBoxJson.isSelected()) {
					String word = guiObj.searchField.getText();
					word = word.replaceAll("\\*", "(.*)");
					word = word.replaceAll("\\?", "[^ ]");
					Pattern p = Pattern.compile(word);
					Matcher m;
					for (String s : dict.dictJSON.keySet()) {
						m = p.matcher(s);
						if (m.lookingAt()) {
							Object ob[] = { s, dict.dictJSON.get(s) };
							obj.model.addRow(ob);
						}

					}
				}
				if (guiObj.checkBoxSer.isSelected()) {
					String word = guiObj.searchField.getText();
					word = word.replaceAll("\\*", "(.*)");
					word = word.replaceAll("\\?", "[^ ]");
					Pattern p = Pattern.compile(word);
					Matcher m;
					for (String s : dict.dictSer.keySet()) {
						m = p.matcher(s);
						if (m.lookingAt()) {
							Object ob[] = { s, dict.dictSer.get(s) };
							obj.model.addRow(ob);
						}

					}
				}
			}
		});
		guiObj.isConsistentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (guiObj.checkBoxJson.isSelected())
					JOptionPane.showMessageDialog(null, dict.isConsistent(dict.dictJSON));
			}
		});

	}
}