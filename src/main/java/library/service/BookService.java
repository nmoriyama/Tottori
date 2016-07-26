package library.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.dto.BookDto;
import library.dto.LibraryDto;
import library.dto.MypageRentalDto;
import library.dto.RentalDto;
import library.dto.StatusDto;
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
	public List<String> rental(RentalDto dto, int totalIsbn) {
		List<String> messages = new ArrayList<String>();
		for (int i=0; i < totalIsbn; i++) {
			RentalDto insert = new RentalDto();
			insert.setUserId(dto.getUserId());
			insert.setUseIsbn(dto.getIsbn()[i]);
			insert.setLibraryId(dto.getLibraryId());
			Date date = new Date();
			insert.setRentalTime(date);
			bookMapper.rental(insert);
		}

        return messages;
    }
	
	//返却
	public List<String> returnBook(RentalDto dto, int totalIsbn) {
		List<String> messages = new ArrayList<String>();
		for (int i=0; i < totalIsbn; i++) {
			BookDto delete = new BookDto();
			delete.setIsbn(dto.getIsbn()[i]);
			delete.setLibraryId(dto.getLibraryId());
			bookMapper.returnBook(delete);
		}
        return messages;
    }
	
	//図書館名
	public List<LibraryDto> library() {
		List<LibraryDto>  library = bookMapper.library();
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

	
	//延滞チェック
	public BookDto delinquentBook(RentalDto dto) throws ParseException {
		//１４日前の日付を取得(取得した日以前の場合延滞)
    	Date date = new Date();
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(date);
    	cal.add(Calendar.DATE,-14);
    	String strPreviousDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss",Locale.US).format(cal.getTime());
    	// Date型変換
    	Date formatDate =DateFormat.getDateInstance().parse(strPreviousDate);
    	//延滞チェック
    	RentalDto Search = new RentalDto();
    	Search.setRentalTime(formatDate);
    	Search.setUserId(dto.getUserId());
    	BookDto result = bookMapper.delinquentBook(Search);

		return result;
	}

	//貸出中かチェック
	public BookDto lendConfirm(RentalDto dto, int isbn) {
		BookDto lend = new BookDto();
		dto.setUseIsbn(isbn);
		lend = bookMapper.lendConfirm(dto);
		return lend;
	}

	public void updateStatus(int status, RentalDto dto, int totalIsbn) {
		
		for (int i = 0; i < totalIsbn; i++) {
			BookDto update = new BookDto();
			update.setIsbn(dto.getIsbn()[i]);
			update.setStatusId(status);
			bookMapper.updateStatus(update);
		}
	}
	
	//ステータス変更
	public void changeStatus(BookDto dto) {
		
		bookMapper.changeStatus(dto);
		
	}
	
	//ステータス名
	public List<StatusDto> status(){
		List<StatusDto> status = bookMapper.status();
		return status;
	}
} 
