
import javax.swing.table.AbstractTableModel;

public class BookTableModel extends AbstractTableModel { 
	private String[] columnNames = {"Id","Title","Author"}; 
	private BookList myBookList; 
	public BookTableModel(BookList bookList) { 
		myBookList = bookList; 
	} 

	public int getColumnCount() { 
		return columnNames.length; 
	}

	public int getRowCount() { 
		int size; 
		if (myBookList == null) { 
			
			size = 0; 
		} 
		else { 
			size = myBookList.getBooks().size(); 
		} 
		return size; 
	} 

	public Object getValueAt(int row, int col) { 
		Object temp = null; 
		if (col == 0) { 
			temp = myBookList.getBooks().get(row).getId(); 
		} 
		else if (col == 1) { 
			temp = myBookList.getBooks().get(row).getTitle(); 
		} 
		else if (col == 2) { 
			temp = myBookList.getBooks().get(row).getAuthor(); 
		}  
		return temp; 
	} 

	// needed to show column names in JTable 
	public String getColumnName(int col) { 
		return columnNames[col]; 
	}
	
	public Class getColumnClass(int col) {
		if (col == 0) { 
			return  Integer.class; 
		} 
		else if (col == 1) { 
			return  String.class; 
		} 
		else if (col == 2) { 
			return String.class; 
		}
		return null;
	} 
}