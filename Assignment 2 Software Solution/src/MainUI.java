import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MainUI{
	protected static final String NullPointExecept = null;
	static membersList membersList;
	private JFrame home;
	protected static JTextField textField1, textField2, textField3, textField4, textField5, textField6, textField7;
	protected static JTable table;
	protected static JTextField[] textFields = {textField1, textField2, textField3, textField4, textField5, textField6, textField7};
	TableRowSorter<TableModel> sorter ;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
		@Override
		public void run() {
			try 
			{
				MainUI window = new MainUI();
				window.home.setVisible(true);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		});
	}

	/**
	 * Create the application.
	 */
	public MainUI() {
		initialize();
	}

	void filter()
	{
		ArrayList<RowFilter<TableModel,Object>> rowFinder = new ArrayList<RowFilter<TableModel,Object>>();
		RowFilter<TableModel,Object> rf=null;
		 try {
		rowFinder.add(RowFilter.regexFilter("(?i)"+textField2.getText(), 1));
		rowFinder.add(RowFilter.regexFilter(textField1.getText(), 0));
    	 rf = RowFilter.andFilter(rowFinder);		
	    } catch (java.util.regex.PatternSyntaxException ee) {
	        return;
	    }
	    sorter.setRowFilter(rf);
	}
	/*********************Refreshes JTable***************************/
	public static void refreshTable(){
		membersList = new membersList();
		membersList.readCSVFile("MembersList.csv");
		MemberTableModel tablemodel1 = new MemberTableModel(membersList);
		table.setModel(tablemodel1);
	}
	
	 // Initialize the contents of the frame.
	 private void initialize(){
		 
		 /*********************JFrame declaration****************************/
		home = new JFrame();
		home.getContentPane().setFont(new Font("Constantia", Font.PLAIN, 16));
		home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		home.setTitle("Member Manager");
		home.setSize(743, 348);
		home.setLocation(50, 50);
		home.getContentPane().setLayout(null);
		home.setResizable(false);
		
		/****************JComponents Declaration/Customisation*****************/
		JLabel lblMemberId = new JLabel("ID:");
		lblMemberId.setBounds(12, 14, 34, 19);
		home.getContentPane().add(lblMemberId);
		lblMemberId.setFont(new Font("Constantia", Font.PLAIN, 16));
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(140, 13, 97, 19);
		home.getContentPane().add(lblFirstName);
		lblFirstName.setFont(new Font("Constantia", Font.PLAIN, 16));
		
		textField1 = new JTextField(10);
		textField1.setBounds(45, 12, 86, 20);
		home.getContentPane().add(textField1);
		
		textField2 = new JTextField(10);
		textField2.setBounds(231, 12, 117, 21);
		home.getContentPane().add(textField2);
		
		textField3 = new JTextField(10);
		textField3.setBounds(429, 12, 86, 20);
		home.getContentPane().add(textField3);
		textField3.setVisible(false);

		JLabel lblDateOfBirth = new JLabel("Date Of Birth:");
		lblDateOfBirth.setFont(new Font("Constantia", Font.PLAIN, 16));
		lblDateOfBirth.setBounds(525, 14, 109, 19);
		home.getContentPane().add(lblDateOfBirth);
		lblDateOfBirth.setVisible(false);
		
		textField4 = new JTextField();
		textField4.setBounds(630, 12, 76, 20);
		home.getContentPane().add(textField4);
		textField4.setColumns(10);
		textField4.setVisible(false);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Constantia", Font.PLAIN, 16));
		lblEmail.setBounds(12, 45, 71, 19);
		home.getContentPane().add(lblEmail);
		lblEmail.setVisible(false);

		textField5 = new JTextField();
		textField5.setBounds(69, 43, 86, 20);
		home.getContentPane().add(textField5);
		textField5.setColumns(10);
		textField5.setVisible(false);
		
		JLabel lblTelephone = new JLabel("Telephone:");
		lblTelephone.setFont(new Font("Constantia", Font.PLAIN, 16));
		lblTelephone.setBounds(177, 42, 97, 25);
		home.getContentPane().add(lblTelephone);
		lblTelephone.setVisible(false);
		
		textField6 = new JTextField();
		textField6.setBounds(262, 43, 117, 20);
		home.getContentPane().add(textField6);
		textField6.setColumns(10);
		textField6.setVisible(false);
		
		JLabel lblMobile = new JLabel("Mobile:");
		lblMobile.setFont(new Font("Constantia", Font.PLAIN, 16));
		lblMobile.setBounds(391, 45, 71, 19);
		home.getContentPane().add(lblMobile);
		lblMobile.setVisible(false);
		
		textField7 = new JTextField();
		textField7.setBounds(455, 43, 86, 20);
		home.getContentPane().add(textField7);
		textField7.setColumns(10);
		textField7.setVisible(false);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setFont(new Font("Constantia", Font.PLAIN, 16));
		lblSurname.setBounds(358, 15, 78, 16);
		lblSurname.setVisible(false);
		home.getContentPane().add(lblSurname);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(17, 232, 89, 25);
		home.getContentPane().add(btnSave);
		btnSave.setVisible(false);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Constantia", Font.PLAIN, 16));
		home.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setFont(new Font("Constantia", Font.PLAIN, 16));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmAddNewMember = new JMenuItem("Add New Member");
		mntmAddNewMember.setFont(new Font("Constantia", Font.PLAIN, 16));
		mnNewMenu.add(mntmAddNewMember);
		
		JMenuItem mntmDeleteMember = new JMenuItem("Delete Member");
		mntmDeleteMember.setFont(new Font("Constantia", Font.PLAIN, 16));
		mnNewMenu.add(mntmDeleteMember);
		
		JMenu mnEdit = new JMenu("Edit");
		mnEdit.setFont(new Font("Constantia", Font.PLAIN, 16));
		menuBar.add(mnEdit);
		
		JMenu mnSave = new JMenu("Save");
		mnSave.setFont(new Font("Constantia", Font.PLAIN, 16));
		menuBar.add(mnSave);
		
		JMenu mnAbout = new JMenu("About");
		mnAbout.setFont(new Font("Constantia", Font.PLAIN, 16));
		menuBar.add(mnAbout);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(120, 232, 97, 25);
		home.getContentPane().add(btnCancel);
		btnCancel.setVisible(false);
		
		JButton btnDisplay = new JButton("Refresh");
		btnDisplay.setBounds(17, 232, 138, 25);
		home.getContentPane().add(btnDisplay);
		
		/****************Array that holds the JTextField variables**************************/
		JTextField[] textFields = {textField1, textField2,textField3,textField4,textField5,textField6,textField7};
		
		membersList = new membersList();
		membersList.readCSVFile("MembersList.csv");
		//Creates a TableModel which will populate the table
		MemberTableModel tablemodel1 = new MemberTableModel(membersList);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 46, 694, 175);
		home.getContentPane().add(scrollPane);
		
		table = new JTable(tablemodel1);
		scrollPane.setViewportView(table);
		sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);
		
		/***************************************Action Events**************************************************************/
		
		table.getSelectionModel().addListSelectionListener(
	        new ListSelectionListener() {
	            public void valueChanged(ListSelectionEvent event) {
	            /**	if (table.getSelectedRow() == -1) {
	            		return;
	            	}*/
	             	if (event.getValueIsAdjusting())
	            		return;
	                int row = table.getSelectedRow();
	                if (row >= 0 ) {
	                	for (int x = 0; x < textFields.length;x++) {
	                		textFields[x].setText(table.getValueAt(row, x).toString());
	                	}
	                }
	            }
	        }
		);	
		
		/*******************MENU SAVE********************/
		mnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "You need to select a row!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				Members member = new Members(Integer.parseInt(textField1.getText()),
						textField2.getText(),textField3.getText(),
						textField4.getText(),textField5.getText(),
						textField6.getText(),textField7.getText());
				membersList.edit(member);
				membersList.deleteWriter();
				((MemberTableModel) table.getModel()).fireTableDataChanged();
				refreshTable();
				
				//hides the UI
				lblSurname.setVisible(false);
				lblDateOfBirth.setVisible(false);
				lblEmail.setVisible(false);
				lblTelephone.setVisible(false);
				lblMobile.setVisible(false);
				
				//Sets text-fields 3 - 7 as invisible
				for (int x = 2; x < textFields.length; x++){
					textFields[x].setVisible(false);
					textFields[x].setText(null);
				}
				textField1.setText(null);
				textField2.setText(null);
				
				//resets the UI from before.
				scrollPane.setBounds(22, 46, 694, 175);
				table.setBounds(22, 46, 694, 175);
				btnSave.setVisible(false);
				btnCancel.setVisible(false);
				btnDisplay.setVisible(true);
				textField1.setEditable(true);
			}
		});
		
		/********************About Message*******************/
		mnAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//On click. Displays a message dialog with a short message.
				JOptionPane.showMessageDialog(null, "This program was"
						+ " made by Tony Huang. "
						+ "\n Eclipse Neon 2.0 \n Copyright (C) All Rights Reserved.");
			}
		});
		
		/***********************Delete Button***********************/
		mntmDeleteMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() == -1){
					JOptionPane.showMessageDialog(null, "You need to select a row!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					membersList.delete(Integer.parseInt(textField1.getText()));
					membersList.deleteWriter();
					((MemberTableModel) table.getModel()).fireTableDataChanged();
					for (int x = 0; x < textFields.length; x++){
						textFields[x].setText(null);
						refreshTable();
					}
				} catch (NumberFormatException | IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		/****************Search filter for ID***************************/
		textField1.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				filter();
			}
		});
		
		/***************Search filter for first name*******************/
		textField2.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				filter();
			}
		});
		
		/****************File Reader button****************************/
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				//READS A FILE AND DISPLAYS IN THE TEXT AREA
				refreshTable();
			}
		});
		
		/******************CSV Writer*********************/
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (int x = 0; x < textFields.length;x++) {
					/** Validation
					if (textFields[x].getText() == ""){	
						JOptionPane.showMessageDialog(null, "You haven't filled in a field.", "Error", JOptionPane.ERROR_MESSAGE );
						System.out.println(textFields[x].getText().equals(null));
						return;
					} else {
						System.out.println(textFields[x].getText().equals(null));
						System.out.println(textFields[x].getText());
						JOptionPane.showMessageDialog(null, "Occupied", "Error", JOptionPane.ERROR_MESSAGE );
					}*/
				}

				//File Writer
				try {
					FileWriter writer = new FileWriter("MembersList.csv", true);
					BufferedWriter bw = new BufferedWriter(writer);
					//Iterates through the textField[] object.
					for (int x = 0; x < textFields.length; x++){
						//Last item doesn't require a comma ending.
						if (x == textFields.length - 1){
							bw.write(textFields[x].getText());
						}
						else {//Writes a comma after each item in the list.
							bw.write(textFields[x].getText());
							bw.write(",");
						}
					}
					bw.newLine();
					bw.close();
				}
				catch (IOException e) {
					System.exit(1);
				}
				refreshTable();
				
				//Hides add member UI
				btnSave.setVisible(false);
				btnCancel.setVisible(false);
				btnDisplay.setVisible(true);
				lblSurname.setVisible(false);
				lblDateOfBirth.setVisible(false);
				lblEmail.setVisible(false);
				lblTelephone.setVisible(false);
				lblMobile.setVisible(false);
				
				/** Hides the UI */
				for (int x = 2; x < textFields.length; x++){
					textFields[x].setVisible(false);
					textFields[x].setText(null);
				}
				textField1.setText(null);
				textField2.setText(null);
				textField1.setEditable(true);
				scrollPane.setBounds(22, 46, 694, 175);
				table.setBounds(22, 46, 694, 175);
				refreshTable();
				
				}
		 });
	
		/********** CANCEL BUTTON******/
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//hides the UI
				lblSurname.setVisible(false);
				lblDateOfBirth.setVisible(false);
				lblEmail.setVisible(false);
				lblTelephone.setVisible(false);
				lblMobile.setVisible(false);
				
				//Sets text-fields 3 - 7 as invisible
				for (int x = 2; x < textFields.length; x++){
					textFields[x].setVisible(false);
					textFields[x].setText(null);
				}
				textField1.setText(null);
				textField2.setText(null);
				
				//resets the UI from before.
				scrollPane.setBounds(22, 46, 694, 175);
				table.setBounds(22, 46, 694, 175);
				btnSave.setVisible(false);
				btnCancel.setVisible(false);
				btnDisplay.setVisible(true);
				textField1.setEditable(true);
				btnCancel.setBounds(120, 232, 97, 25);
			}
		});
		
		/***********Add Member Button***************/
		mntmAddNewMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//generates id and sets in textField1
				textField1.setText(Integer.toString(membersList.idGenerator()));
				textField1.setEditable(false);
				lblSurname.setVisible(true);
				lblDateOfBirth.setVisible(true);
				lblEmail.setVisible(true);
				lblTelephone.setVisible(true);
				lblMobile.setVisible(true);
				
				//Sets text-fields 3 - 7 as invisible
				for (int x = 2; x < textFields.length; x++){
					textFields[x].setVisible(true);
				}
				//Empties the fields
				for (int x = 1; x < textFields.length;x++) {
					textFields[x].setText("");
				}
				scrollPane.setBounds(22, 75, 694, 144);
				table.setBounds(22, 75, 694, 144);
				btnDisplay.setVisible(false);
				btnSave.setVisible(true);
				btnCancel.setVisible(true);
			}
		});
		/***********************Menu Edit UI**************************/
		mnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (table.getSelectedRow() == -1){
					JOptionPane.showMessageDialog(null, "You need to select a row!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				refreshTable();
				/**********Changes UI***************/
				textField1.setEditable(false);
				lblSurname.setVisible(true);
				lblDateOfBirth.setVisible(true);
				lblEmail.setVisible(true);
				lblTelephone.setVisible(true);
				lblMobile.setVisible(true);
				btnSave.setVisible(false);
				
				//Sets text-fields 3 - 7 as visible
				for (int x = 2; x < textFields.length; x++){
					textFields[x].setVisible(true);
				}
				scrollPane.setBounds(22, 75, 694, 144);
				table.setBounds(22, 75, 694, 144);
				btnDisplay.setVisible(false);
				btnCancel.setBounds(17, 232, 138, 25);
				btnCancel.setVisible(true);
				btnSave.setVisible(false);

			}
			
		});
	}
}
