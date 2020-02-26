package swd20.hh.Bookstore.domain;

public class Book {
	private String title;
	private String author;
	private Integer year;
	private Integer isbn;
	private Integer price;
	
	public Book() {
		super();
		this.title="";
		this.author="";
		this.year=0;
		this.isbn=0;
		this.price=0;
		
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

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	

}
