package GuiPack;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUI {

	private JFrame frmDictionary;
	public JTextField searchField;
	public JTextField addOrDeleteWordField;
	public JTextField addSynField;
	public static GUI instance = new GUI();
	public JButton btnAddWord;
	public JButton btnDeleteWord;
	public JButton btnAddSynonym;
	public JButton btnSearch;
	public JButton btnSeeWords;
	public JButton btnSeeDictionary;
	public JCheckBox checkBoxJson;
	public JCheckBox checkBoxSer;
	public JButton isConsistentBtn;

	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDictionary = new JFrame();
		frmDictionary.setTitle("Dictionary");
		frmDictionary.setBounds(100, 100, 612, 146);
		frmDictionary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDictionary.getContentPane().setLayout(null);
		
		btnAddWord = new JButton("Add word");
		btnAddWord.setBounds(230, 10, 112, 23);
		frmDictionary.getContentPane().add(btnAddWord);
		
		btnDeleteWord = new JButton("Delete word");
		btnDeleteWord.setBounds(352, 10, 112, 23);
		frmDictionary.getContentPane().add(btnDeleteWord);
		
		btnAddSynonym = new JButton("Add synonym");
		btnAddSynonym.setBounds(230, 44, 112, 23);
		frmDictionary.getContentPane().add(btnAddSynonym);
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(15, 76, 89, 23);
		frmDictionary.getContentPane().add(btnSearch);
		
		btnSeeWords = new JButton("See synonyms");
		btnSeeWords.setBounds(352, 44, 112, 23);
		frmDictionary.getContentPane().add(btnSeeWords);
		
		checkBoxJson = new JCheckBox(".json file");
		checkBoxJson.setBounds(513, 76, 78, 23);
		frmDictionary.getContentPane().add(checkBoxJson);
		
		checkBoxSer = new JCheckBox(".ser file");
		checkBoxSer.setBounds(442, 76, 69, 23);
		frmDictionary.getContentPane().add(checkBoxSer);
		
		searchField = new JTextField();
		searchField.setBounds(114, 78, 322, 20);
		frmDictionary.getContentPane().add(searchField);
		searchField.setColumns(10);
		
		addOrDeleteWordField = new JTextField();
		addOrDeleteWordField.setBounds(71, 11, 139, 20);
		frmDictionary.getContentPane().add(addOrDeleteWordField);
		addOrDeleteWordField.setColumns(10);
		
		addSynField = new JTextField();
		addSynField.setColumns(10);
		addSynField.setBounds(71, 45, 139, 20);
		frmDictionary.getContentPane().add(addSynField);
		
		JLabel lblWord = new JLabel("Word");
		lblWord.setHorizontalAlignment(SwingConstants.CENTER);
		lblWord.setBounds(15, 14, 46, 14);
		frmDictionary.getContentPane().add(lblWord);
		
		JLabel lblSynonym = new JLabel("Synonym");
		lblSynonym.setHorizontalAlignment(SwingConstants.CENTER);
		lblSynonym.setBounds(15, 48, 46, 14);
		frmDictionary.getContentPane().add(lblSynonym);
		
		btnSeeDictionary = new JButton("See dictionary");
		btnSeeDictionary.setBounds(474, 10, 112, 23);
		frmDictionary.getContentPane().add(btnSeeDictionary);
		
		isConsistentBtn = new JButton("Is Consistent");
		isConsistentBtn.setBounds(474, 44, 112, 23);
		frmDictionary.getContentPane().add(isConsistentBtn);
		
		frmDictionary.setVisible(true);
	}

	public static GUI getInstance() {
		return instance;
	}	
}
