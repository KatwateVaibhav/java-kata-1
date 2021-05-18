package org.echocat.kata.java.part1.service.serviceImpl;

import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.echocat.kata.java.part1.model.AuthorsModel;
import org.springframework.stereotype.Service;

@Service
public class ReadAuthorCSV extends ReadFromCSV<AuthorsModel> {

    public Set<AuthorsModel> returnAuthorsItem(String csvName){
    	Pattern pattern = Pattern.compile(";");
        return readFromCSV(csvName).stream().map(line -> {
    		String[] str = pattern.split(line);
    		return new AuthorsModel(str[0], str[1],str[2]);
    	}).collect(Collectors.toSet());
    }

}
