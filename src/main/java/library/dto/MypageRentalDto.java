package library.dto;

import java.util.Date;

public class MypageRentalDto {
	private String authorName;
	private String bookName;
	private Date rentalTime;
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Date getRentalTime() {
		return rentalTime;
	}
	public void setRentalTime(Date rentalTime) {
		this.rentalTime = rentalTime;
	}
	
}
