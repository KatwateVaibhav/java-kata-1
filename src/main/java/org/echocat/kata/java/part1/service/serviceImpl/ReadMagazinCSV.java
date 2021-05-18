package org.echocat.kata.java.part1.service.serviceImpl;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.echocat.kata.java.part1.model.MagazinModel;
import org.echocat.kata.java.part1.service.FilterData;
import org.springframework.stereotype.Service;

@Service
public class ReadMagazinCSV extends ReadFromCSV<ReadMagazinCSV> implements FilterData<MagazinModel>{

    public Set<MagazinModel> returnMagizinItem(String csvName){
    	Pattern pattern = Pattern.compile(";");
        return readFromCSV(csvName).stream().map(line -> {
    		String[] str = pattern.split(line);
    		return new MagazinModel(str[0], str[1],str[2],str[3]);
    	}).collect(Collectors.toSet());
    }
    
    public Set<MagazinModel> sortMagazineTitle(){
    	return returnMagizinItem("magazines").stream()
		.collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(MagazinModel::getTitle))));
    }
    @Override
    public Set<MagazinModel> returnFilterIsbn(String value) {
        Set<MagazinModel> magazines=this.returnMagizinItem("magazines");
        return magazines.stream().filter(x->x.getIsbn().equals(value)).collect(Collectors.toSet());
    }

    @Override
    public Set<MagazinModel> returnFilterAuthors(String value) {
        Set<MagazinModel> magazines=this.returnMagizinItem("magazines");
        return magazines.stream().filter(x->x.getAuthors().equals(value)).collect(Collectors.toSet());
    }
}
