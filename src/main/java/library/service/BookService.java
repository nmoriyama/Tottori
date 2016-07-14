package library.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.dto.BookDto;
import library.dto.RentalDto;
import library.mapper.BookMapper;

@Service
public class BookService {
    @Autowired
    private BookMapper bookMapper;
	public List<String> insert(BookDto dto) {
		List<String> messages = new ArrayList<String>();
        bookMapper.insert(dto);
        return messages;
    }
	
	public List<String> rental(RentalDto dto) {
		List<String> messages = new ArrayList<String>();
        bookMapper.rental(dto);
        return messages;
    }
}
