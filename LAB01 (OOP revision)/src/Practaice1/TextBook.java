package Practaice1;

public class TextBook extends Book {
	private String course;
	
	//constructor that inherits the book class but adds a course parameter
	public TextBook(String title, int pages, String course) {
		super(title, pages);
		this.course = course;
	}

	public String getCourse() {
		return course;
	}
	
	public String toString(){
		 return "Book: " + getTitle() + ", # Pages: " + getPages() + ", Course: " + course;
	}
	
	
}
