import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JLabel;

public class MainFrame extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField_search;

	TableRowSorter<TableModel> sorter ;
	private JTextField textField_id;
	private JTextField textField_title;
	private JTextField textField_author;
	BookList bookList;
	JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("Book Management");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 486);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		/************** Labels**************************/
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(40, 15, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Title");
		lblNewLabel_1.setBounds(40, 45, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Author");
		lblNewLabel_2.setBounds(40, 79, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		/************** Text Fields**************************/
		textField_id = new JTextField();
		textField_id.setBounds(96, 12, 86, 20);
		contentPane.add(textField_id);
		textField_id.setColumns(10);
		
		textField_title = new JTextField();
		textField_title.setBounds(96, 42, 86, 20);
		contentPane.add(textField_title);
		textField_title.setColumns(10);
		
		textField_author = new JTextField();
		textField_author.setBounds(96, 76, 86, 20);
		contentPane.add(textField_author);
		textField_author.setColumns(10);
		
		
		/**************Add Button**************************/
		JButton Btn_AddNewBook = new JButton("Add New Book");
		Btn_AddNewBook.setBounds(220, 11, 101, 23);
		Btn_AddNewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Book book = new Book(Integer.parseInt(textField_id.getText()), textField_title.getText(), textField_author.getText());
				bookList.add(book);
				((BookTableModel) table.getModel()).fireTableDataChanged();
				bookList.writeToCSV("books.csv");
				
				
				//refreshTable();
			}
		});
		contentPane.add(Btn_AddNewBook);
		
		
		/**************Update Button**************************/
		JButton btn_update = new JButton("Update");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Book book = new Book(Integer.parseInt(textField_id.getText()), textField_title.getText(), textField_author.getText());
				bookList.update(book);
				bookList.writeToCSV("books.csv");
				((BookTableModel) table.getModel()).fireTableDataChanged();
			}
		});
		btn_update.setBounds(220, 41, 99, 23);
		contentPane.add(btn_update);
		
		/**************Delete Button**************************/
		JButton btn_remove = new JButton("Remove");
		btn_remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bookList.remove(Integer.parseInt(textField_id.getText()));
				bookList.writeToCSV("books.csv");
				((BookTableModel) table.getModel()).fireTableDataChanged();
				textField_id.setText("");
				textField_title.setText("");
				textField_author.setText("");
			}
		});
		btn_remove.setBounds(220, 75, 101, 23);
		contentPane.add(btn_remove);
		
		/**************Search**************************/

		JLabel lblSearch = new JLabel("Search");
		lblSearch.setBounds(61, 145, 55, 14);
		contentPane.add(lblSearch);
		
		textField_search = new JTextField();
		textField_search.setColumns(10);
		textField_search.setBounds(118, 142, 86, 20);
			
		textField_search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				ArrayList<RowFilter<TableModel,Object>> rfs = new ArrayList<RowFilter<TableModel,Object>>();
				RowFilter<TableModel,Object> rf=null;
				 try {
				rfs.add(RowFilter.regexFilter(textField_search.getText(), 0));
				rfs.add(RowFilter.regexFilter("(?i)"+textField_search.getText(), 1));
				rfs.add(RowFilter.regexFilter("(?i)"+textField_search.getText(), 2));
		    	 rf = RowFilter.orFilter(rfs);		
			    } catch (java.util.regex.PatternSyntaxException ee) {
			        return;
			    }
			    sorter.setRowFilter(rf);
			}
		});
		contentPane.add(textField_search);		
		
		
		/**************Refresh Button**************************/
		JButton refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(317, 141, 86, 23);
		
		refreshBtn.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				bookList.readFromCSV("books.csv");
				((BookTableModel) table.getModel()).fireTableDataChanged();
			}
		});
		
		contentPane.add(refreshBtn);
		
		
		/**************Filling the table from CSV file**************************/
		bookList = new BookList();
		bookList.readFromCSV("books.csv");
		BookTableModel bookTableModel = new BookTableModel(bookList);
		table = new JTable(bookTableModel);
	
		//JScrollpane
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 173, 402, 264);
		contentPane.add(scrollPane);
	
		//Sorter
		sorter  = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);
		
		table.getSelectionModel().addListSelectionListener(
		        new ListSelectionListener() {
		            public void valueChanged(ListSelectionEvent event) {
		             	if (event.getValueIsAdjusting())
		            		return;
		                int viewRow = table.getSelectedRow();
		                if (viewRow >= 0 ) {
		                   textField_id.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
		                   textField_title.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
		                   textField_author.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
		                }
		            }
		        }
		);		
	}
}
