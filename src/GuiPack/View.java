package GuiPack;

import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private Object[] column = {"Word","Synonyms"};
	private Object[][] rows = new Object[0][0];
	public DefaultTableModel model;
	
	public View() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		model = new DefaultTableModel(rows, column);
		table = new JTable(model);
		table.setBounds(10, 11, 414, 239);
		contentPane.add(table);
		
		contentPane.setVisible(true);
		table.setVisible(true);
		setVisible(true);
	}
	public void seeSynonyms(String word,Map<String,Set<String>> dict){
		
		for(String s:dict.get(word)){
			if(dict.get(s).size()!=0){
			Object ob[]={word,s};
			model.addRow(ob);
			}
		}
	}
	public void seeDictionary(Map<String,Set<String>> dict){
		for(String s:dict.keySet()){
			if(dict.get(s).size()!=0){
			Object ob[]={s,dict.get(s)};
			model.addRow(ob);
			}
		}
	}
}
