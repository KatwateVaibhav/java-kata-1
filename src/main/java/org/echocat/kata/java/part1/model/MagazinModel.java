package org.echocat.kata.java.part1.model;

public class MagazinModel extends BookModel {
    String publishedAt;

	public MagazinModel(String title, String isbn, String authors, String publishedAt) {
		super.title=title;
		super.isbn = isbn;
		super.authors = authors;
		this.publishedAt = publishedAt;
	}

	
	public MagazinModel() {
		super();
	}



	public String getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(String publishedAt) {
		this.publishedAt = publishedAt;
	}


	

	
	@Override
	public String toString() {
		return "MagazinModel [title=" + title + ", isbn=" + isbn + ", authors="
				+ authors + ", publishedAt =" + publishedAt +"]";
	}


	@Override
	public int compareTo(BookModel o) {
		return this.getTitle().compareTo(o.getTitle());
	}


    
    
}
