package Practaice1;

public class Book {
	private String title;
	private int pages;
	
	// constructor that takes the title and number of pages as a parameter
	public Book(String title, int pages) {
		this.title = title;
		this.pages = pages;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getPages() {
		return pages;
	}
	
	public String toString() {
		return "Book: " + getTitle() + ", # Pages: " + getPages();
	}
	
}
