package org.echocat.kata.java.part1.service.serviceImpl;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.echocat.kata.java.part1.controller.ErrorController;
import org.echocat.kata.java.part1.model.BookModel;
import org.echocat.kata.java.part1.service.FilterData;
import org.springframework.stereotype.Service;
@Service
public class ReadBookCSV extends ReadFromCSV<BookModel> implements FilterData<BookModel>{

    public Set<BookModel> returnBookItem(String csvName){
    	Pattern pattern = Pattern.compile(";");
        return readFromCSV(csvName).stream().map(line -> {
    		String[] str = pattern.split(line);
    		return new BookModel(str[0], str[1],str[2],str[3]);
    	}).collect(Collectors.toSet());
    }
    
    public Set<BookModel> sortBookTitle(){
    	return returnBookItem("books").stream()
		.collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(BookModel::getTitle))));
    }
   
    @Override
    public Set<BookModel> returnFilterIsbn(String value) {
        Set<BookModel> books = this.returnBookItem("books").stream().filter(x->x.getIsbn().equals(value)).collect(Collectors.toSet());
        
        if(books.isEmpty()) {
        	throw new ErrorController("Not Found");
        }else {
        	return books;
        }
    }

    @Override
    public Set<BookModel> returnFilterAuthors(String value) {
        Set<BookModel> books=this.returnBookItem("books").stream().filter(x->x.getAuthors().equals(value)).collect(Collectors.toSet());
        if(books.isEmpty()) {
        	throw new ErrorController("Not Found");
        }else {
        	return books;
        }
    }
}
