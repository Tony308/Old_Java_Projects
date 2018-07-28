import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BookList {
	private ArrayList<Book> books;
	public BookList()
	{
		books = new ArrayList<>();
	}
	public void add(Book book) {
		books.add(book);
	}

	public void update(Book updatedBook)
	{
		for (Book book:books)
		{
			if (book.getId() == updatedBook.getId())
			{
				book.setTitle(updatedBook.getTitle());
				book.setAuthor(updatedBook.getAuthor());
			}
		}
	}

	public void remove(int memberId)
	{
		for(int index=0;index<books.size();index++)
		{
			if ( books.get(index).getId() == memberId)
				books.remove(index);
		}
	}

	public void readFromCSV(String filename) {
		try {
			books.clear();
			// Create a new BufferedReader instance for reading the text file.
			BufferedReader bufferReader = new BufferedReader(new FileReader(filename));

			// Read the lines from the text file row by row.
			String line = null;
			while ((line = bufferReader.readLine()) != null) {

				String[] tokens = line.trim().split(",");
				int  id = Integer.parseInt(tokens[0].trim());
				String title = tokens[1].trim();
				String author = tokens[2].trim();
				Book book = new Book(id,title,author);
				books.add(book);
			}
			bufferReader.close();
		}
		catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void writeToCSV(String filename) {
		try {

			// Create a new bufferWriter instance for writing the text file.
			BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(filename));

			for (int i=0; i<books.size(); i++) {

				// Write the row of text to the text file.
				Book book = books.get(i);
				bufferWriter.write(Integer.toString(book.getId()));
				bufferWriter.write(",");
				bufferWriter.write(book.getTitle());
				bufferWriter.write(",");
				bufferWriter.write(book.getAuthor());

				// Write the new line character(s) to the text file for each new line of data.
				bufferWriter.newLine();
			}

			// Close the bufferWriter file stream when done.
			bufferWriter.close();

		}  catch (Exception e) {

			// An unexpected error occurred so we print out the error message to the Console. 
			e.printStackTrace();
		}
	}
	
	public ArrayList<Book> getBooks() {
		return books;
	}

}
