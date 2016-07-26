package library.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class UserForm {
	//@Range(min=4, max=8, message = "ログインIDは4～8桁で入力してください")
	private String userId;
	@NotEmpty(message = "名前は4～8桁で入力してください")
	private String userName;
	@NotEmpty(message = "住所を入力してください")
	private String address;
	@NotEmpty(message = "メールを入力してください")
	private String mail;
	@Min(value = 11, message = "電話番号は{value}桁の値で設定してください")
	private String phoneNumber;
	@NotNull
	private int libraryId;
	private String date;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getLibraryId() {
		return libraryId;
	}
	public void setLibraryId(int libraryId) {
		this.libraryId = libraryId;
	}
}
