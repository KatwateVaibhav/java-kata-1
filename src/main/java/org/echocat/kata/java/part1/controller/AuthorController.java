package org.echocat.kata.java.part1.controller;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.echocat.kata.java.part1.model.AuthorsModel;
import org.echocat.kata.java.part1.model.BookModel;
import org.echocat.kata.java.part1.model.MagazinModel;
import org.echocat.kata.java.part1.service.serviceImpl.ReadAuthorCSV;
import org.echocat.kata.java.part1.service.serviceImpl.ReadBookCSV;
import org.echocat.kata.java.part1.service.serviceImpl.ReadMagazinCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
	
@Autowired
private ReadAuthorCSV readAuthorCSV;

@Autowired
private ReadBookCSV readBookCSV;

@Autowired
private ReadMagazinCSV readMagazinCSV;

@RequestMapping(value = "/authorItem", method = RequestMethod.GET)
public Set<AuthorsModel> getAuthorsItem() {
	return readAuthorCSV.returnAuthorsItem("authors");
}

@RequestMapping(value = "/bookItem", method = RequestMethod.GET)
public Set<BookModel> getBookItem() {
	return readBookCSV.returnBookItem("books");
}

@RequestMapping(value = "/magazineItem", method = RequestMethod.GET)
public Set<MagazinModel> getMagazineItem() {
	return readMagazinCSV.returnMagizinItem("magazines");
}	

@RequestMapping(value = "/SortMagazineByTitle", method = RequestMethod.GET)
public Set<MagazinModel> sortedMagazineByTitle() {
	return readMagazinCSV.sortMagazineTitle();
}

@RequestMapping(value = "/SortBookByTitle", method = RequestMethod.GET)
public Set<BookModel> sortedBookByTitle() {
	return readBookCSV.sortBookTitle();
}

@RequestMapping(value = "/findBookByIsbn/{isbn}", method = RequestMethod.GET)
public Set<BookModel> getBookByIsbn(@PathVariable("isbn") String isbnId) {
	return readBookCSV.returnFilterIsbn(isbnId);
}

@RequestMapping(value = "/findAllBookByAuthorName/{authName}", method = RequestMethod.GET)
public Set<BookModel> findBookByAuthName(@PathVariable("authName") String authName) {
	return readBookCSV.returnFilterAuthors(authName);
}

}
