package org.echocat.kata.java.part1.model;

public class BookModel implements Comparable<BookModel> {
    String title;
    String isbn;
    String authors;
    String description;
	public BookModel(String title, String isbn, String authors, String description) {
		this.title = title;
		this.isbn = isbn;
		this.authors = authors;
		this.description = description;
	}
	public BookModel() {
		// TODO Auto-generated constructor stub
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "BookModel [title=" + title + ", isbn=" + isbn + ", authors=" + authors + ", description=" + description
				+ "]";
	}
	@Override
	public int compareTo(BookModel o) {
		// TODO Auto-generated method stub
		return this.getTitle().compareTo(o.getTitle());
	}
    
    
}
