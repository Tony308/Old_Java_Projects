
public class Book {
  private int id;
  private String title;
  private String author;
  Book(int id,  String title,String author)
  {
	  this.setId(id);
	  this.setTitle(title);
	  this.setAuthor(author);
  }
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String toString()
{
	return this.getId()+","+this.getTitle()+","+this.getAuthor();
}
}
