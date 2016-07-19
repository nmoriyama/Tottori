package library.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.dto.BookDto;
import library.dto.LibraryDto;
import library.dto.RentalDto;
import library.mapper.BookMapper;

@Service
public class BookService {
    @Autowired
    private BookMapper bookMapper;
    
	public void insert(BookDto dto) {
		dto.setAuthorKanaByte(dto.getAuthorKana());
		dto.setBookKanaByte(dto.getBookKana().substring(0,1));
		dto.setAuthorKanaByte(dto.getAuthorKana().substring(0,1));
        bookMapper.insert(dto);
    }
	
	public List<String> rental(RentalDto dto) {
		List<String> messages = new ArrayList<String>();
		Date date = new Date();
		dto.setRentalTime(date);
		
        bookMapper.rental(dto);
        return messages;
    }
	public List<String> returnBook(RentalDto dto) {
		List<String> messages = new ArrayList<String>();
		
        bookMapper.returnBook(dto);
        return messages;
    }
	public List<LibraryDto> library() {
		List<LibraryDto> library = bookMapper.library();
		return library;
	}
	
	public List<String> bookCheck(BookDto dto) {
		List<String> messages = new ArrayList<String>();
		if (bookMapper.bookCheck(dto) != null) {
    		messages.add("その図書は既に登録されています");
    	}
        return messages;
	}
} 
