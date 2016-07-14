package library.mapper;

import library.dto.BookDto;
import library.dto.RentalDto;

public interface BookMapper {
	void insert(BookDto dto);
	void rental(RentalDto dto);
}
