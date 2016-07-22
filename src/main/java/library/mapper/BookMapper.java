package library.mapper;

import java.util.List;

import library.dto.BookDto;
import library.dto.LibraryDto;
import library.dto.MypageRentalDto;
import library.dto.RentalDto;

public interface BookMapper {
	void insert(BookDto dto);
	void rental(RentalDto dto);
	List<LibraryDto> library();
	void returnBook(BookDto dto);
	List<BookDto> bookCheck(BookDto dto);
	List<MypageRentalDto> rentalConfirm(RentalDto dto);
	List<BookDto> delinquentBook(RentalDto dto);
	BookDto lendConfirm(RentalDto dto);
	void updateStatus(BookDto dto);
}
