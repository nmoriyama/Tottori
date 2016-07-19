package library.mapper;

import java.util.List;

import library.dto.BookDto;
import library.dto.LibraryDto;
import library.dto.RentalDto;

public interface BookMapper {
	void insert(BookDto dto);
	void rental(RentalDto dto);
	List<LibraryDto> library();
	void returnBook(RentalDto dto);
	List<BookDto> bookCheck(BookDto dto);
}
