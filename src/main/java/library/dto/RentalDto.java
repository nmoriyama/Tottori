package library.dto;

import java.util.Date;

public class RentalDto {
	private int rentalId;
	private String userId;
	private int[] isbn;
	private int useIsbn;
	private int libraryId;
	private Date rentalTime;
	private String date;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getUseIsbn() {
		return useIsbn;
	}
	public void setUseIsbn(int useIsbn) {
		this.useIsbn = useIsbn;
	}
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
