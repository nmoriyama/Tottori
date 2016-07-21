package library.dto;

import java.util.Date;

public class MypageRentalDto {
	private String userId;
	private String authorName;
	private String bookName;
	private Date rentalTime;
	private int isbn;

	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
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
