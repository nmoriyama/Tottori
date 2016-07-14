package library.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class UserForm {
	@NotNull(message = "ログインIDを入力してください")
	@Min(3)
	@Max(9)
	private int userId;
	@NotEmpty(message = "名前を入力してください")
	private String userName;
	@NotEmpty(message = "住所を入力してください")
	private String address;
	@NotEmpty(message = "メールを入力してください")
	private String mail;
	@NotEmpty(message = "電話番号を入力してください")
	@Min(value = 11, message = "電話番号は{value}桁の値で設定してください")
	private String phoneNumber;
	@NotNull
	private int libraryId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
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
