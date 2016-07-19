package library.form;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class BookForm {
	private int bookId;
	@NotEmpty(message = "書名のふりがなを入力してください")
	private String bookKana;
	private String bookKanaByte;
	//@Min(value=100, message = "書名が100文字を超えています")
	private String bookName;
	
	private String authorKana;
	private String authorKanaByte;
	//@Max(value=255, message = "著者名が255文字を超えています")
	private String authorName;
	@NotEmpty(message = "出版社名を入力してください")
	private String publisher;
	private Date rentalTime;
	@NotNull(message = "ISBNを入力してください")
	private int isbn;
	@NotNull(message = "棚番号を入力してください")
	private int shelfId;
	private int documentId;
	private int libraryId;
	private int status;
	
	public String getBookKana() {
		return bookKana;
	}
	public void setBookKana(String bookKana) {
		this.bookKana = bookKana;
	}
	public String getAuthorKana() {
		return authorKana;
	}
	public void setAuthorKana(String authorKana) {
		this.authorKana = authorKana;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookKanaByte() {
		return bookKanaByte;
	}
	public void setBookKanaByte(String bookKanaByte) {
		this.bookKanaByte = bookKanaByte;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorKanaByte() {
		return authorKanaByte;
	}
	public void setAuthorKanaByte(String authorKanaByte) {
		this.authorKanaByte = authorKanaByte;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Date getRentalTime() {
		return rentalTime;
	}
	public void setRentalTime(Date rentalTime) {
		this.rentalTime = rentalTime;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public int getShelfId() {
		return shelfId;
	}
	public void setShelfId(int shelfId) {
		this.shelfId = shelfId;
	}
	public int getDocumentId() {
		return documentId;
	}
	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}
	public int getLibraryId() {
		return libraryId;
	}
	public void setLibraryId(int libraryId) {
		this.libraryId = libraryId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}