package library.dto;

import java.util.Date;

public class RentalDto {
	private int rentalId;
	private String userId;
	private int[] isbn = new int[8];
	private int libraryId;
	private Date rentalTime;
	public int[] getIsbn() {
		return isbn;
	}
	public void setIsbn(int[] isbn) {
		this.isbn = isbn;
	}
	public int getRentalId() {
		return rentalId;
	}
	public void setRentalId(int rentalId) {
		this.rentalId = rentalId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public int getLibraryId() {
		return libraryId;
	}
	public void setLibraryId(int libraryId) {
		this.libraryId = libraryId;
	}
	public Date getRentalTime() {
		return rentalTime;
	}
	public void setRentalTime(Date rentalTime) {
		this.rentalTime = rentalTime;
	}
}
