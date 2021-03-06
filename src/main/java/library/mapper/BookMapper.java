package library.mapper;

import java.util.List;

import library.dto.BookDto;
import library.dto.LibraryDto;
import library.dto.MypageRentalDto;
import library.dto.RentalDto;
import library.dto.StatusDto;

public interface BookMapper {
	void insert(BookDto dto);
	void rental(RentalDto dto);
	List<LibraryDto> library();
	void returnBook(BookDto dto);
	List<BookDto> bookCheck(BookDto dto);
	List<MypageRentalDto> rentalConfirm(RentalDto dto);
	List<MypageRentalDto> delinquentBook(RentalDto dto);
	BookDto lendConfirm(RentalDto dto);
	void updateStatus(BookDto dto);
	void changeStatus(BookDto dto);
	List<StatusDto> status();
	List<BookDto> bookManagement();
	List<MypageRentalDto> rentalManagement();
	void changeDate(RentalDto dto);
}
