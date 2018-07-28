import javax.swing.table.AbstractTableModel;

public class MemberTableModel extends AbstractTableModel {

	private String[] columnNames = {"ID", "First Name", "Surname", "DoB", "Email", "Telephone", "Mobile"};
	private membersList myMembersList;
	public MemberTableModel(membersList MembersList){
		myMembersList = MembersList;
	}
	
	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		int size;
		if (myMembersList == null) {
			size = 0;
		}
		else {
		size = myMembersList.getMembers().size();	
		}
		return size;
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object temp = null;
		
		if (columnIndex == 0){
			temp = myMembersList.getMembers().get(rowIndex).getMemberID();
		}
		else if (columnIndex == 1 ){
			temp = myMembersList.getMembers().get(rowIndex).getFirstName();
		}
		else if (columnIndex == 2 ){
			temp = myMembersList.getMembers().get(rowIndex).getSurname();
		}
		else if (columnIndex == 3 ){
			temp = myMembersList.getMembers().get(rowIndex).getDateOfBirth();
		}
		else if (columnIndex == 4 ){
			temp = myMembersList.getMembers().get(rowIndex).getEmail();
		}
		else if (columnIndex == 5 ){
			temp = myMembersList.getMembers().get(rowIndex).getTelephone();
		}
		else if (columnIndex == 6){
			temp = myMembersList.getMembers().get(rowIndex).getMobile();
		}
		return temp;
	}//End getValueAt;
	
	@Override
	public void fireTableDataChanged() {
		// TODO Auto-generated method stub
		super.fireTableDataChanged();
	}
	@Override
	public void fireTableCellUpdated(int arg0, int arg1) {
		// TODO Auto-generated method stub
		super.fireTableCellUpdated(arg0, arg1);
	}

	@Override
	public void fireTableRowsUpdated(int firstRow, int lastRow) {
		// TODO Auto-generated method stub
		super.fireTableRowsUpdated(firstRow, lastRow);
	}
	@Override
	public void fireTableRowsDeleted(int firstRow, int lastRow) {
		// TODO Auto-generated method stub
		super.fireTableRowsDeleted(firstRow, lastRow);
	}
	@Override
	public void fireTableRowsInserted(int firstRow, int lastRow) {
		// TODO Auto-generated method stub
		super.fireTableRowsInserted(firstRow, lastRow);
	}
		// needed to show column names in JTable 
		public String getColumnName(int columnIndex) { 
			return columnNames[columnIndex]; 
		}
		public void Refresh(String filename)
		{
			myMembersList.readCSVFile(filename);
		}
		public Class getColumnClass(int columnIndex) {
			if (columnIndex == 0){
				return Integer.class;
			}
			else if (columnIndex == 1){
				return String.class;
			}
			else if (columnIndex == 2){
				return String.class;
			}
			else if (columnIndex == 3){
				return String.class;
			}
			else if (columnIndex == 4){
				return String.class;
			}
			else if (columnIndex == 5){
				return String.class;
			}
			else if (columnIndex == 6){
				return String.class;
			}
			return null;
		} 
}
