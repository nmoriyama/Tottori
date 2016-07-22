package library.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.dto.BookDto;
import library.dto.LibraryDto;
import library.dto.MypageRentalDto;
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
	
	//貸出
	public List<String> rental(RentalDto dto) {
		List<String> messages = new ArrayList<String>();
		for (int i=0; i < 8; i++) {
			BookDto insert = new BookDto();
			insert.setIsbn(dto.getIsbn()[i]);
			insert.setLibraryId(dto.getLibraryId());
			Date date = new Date();
			insert.setRentalTime(date);
			bookMapper.rental(dto);
		}

        return messages;
    }
	
	//返却
	public List<String> returnBook(RentalDto dto) {
		List<String> messages = new ArrayList<String>();
		for (int i=0; i < 8; i++) {
			BookDto delete = new BookDto();
			delete.setIsbn(dto.getIsbn()[i]);
			delete.setLibraryId(dto.getLibraryId());
			bookMapper.returnBook(delete);
		}
        return messages;
    }
	
	//図書館名
	public List<LibraryDto> library() {
		List<LibraryDto> library = bookMapper.library();
		return library;
	}
	
	//図書が登録されているか
	public List<String> bookCheck(BookDto dto) {
		List<String> messages = new ArrayList<String>();
		List<BookDto> bookCheck = bookMapper.bookCheck(dto);
		if (bookCheck.size() > 0) {
    		messages.add("その図書は既に登録されています");
    	}
        return messages;
	}
	
	//
	public List<MypageRentalDto> rentalConfirm(RentalDto dto) {
		List<MypageRentalDto> rentalBook = bookMapper.rentalConfirm(dto);
		return rentalBook;
	}

	
	//貸し出し期限
	public List<BookDto> delinquentBook(RentalDto dto) {
    	Date date = new Date();
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(date);
    	cal.add(Calendar.DATE,-14);
    	Date afterTime = new java.sql.Date(cal.getTimeInMillis());
    	dto.setRentalTime(afterTime);
		List<BookDto> delinquentBook = bookMapper.delinquentBook(dto);
		return delinquentBook;
	}

	public BookDto lendConfirm(RentalDto dto) {
		BookDto lend = bookMapper.lendConfirm(dto);
		
		return lend;
	}

	public void updateStatus(int status, RentalDto dto) {
		
		for (int i = 0; i < 8; i++) {
			BookDto update = new BookDto();
			update.setIsbn(dto.getIsbn()[i]);
			update.setStatusId(status);
			bookMapper.updateStatus(update);
		}
	}
} 
