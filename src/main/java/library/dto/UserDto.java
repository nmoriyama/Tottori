package library.dto;

import java.util.Date;

public class UserDto {
	
	private static final long serialVersionUID = 1L;

	private static UserDto userDto;

	public static UserDto getUserDto() {
		if (userDto == null) {
			userDto = new UserDto();
		}
		return userDto;
	}

	public static void setUserDto(UserDto Dto) {
		userDto = Dto;
	}
	
	private String userId;
	private String userName;
	private String address;
	private String mail;
	private String phoneNumber;
	private int libraryId;
	private Date insertTime;
	private Date updateTime;
	private String date;
	private String referer;
	
	public String getReferer() {
		return referer;
	}
	public void setReferer(String referer) {
		this.referer = referer;
	}
	
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
	public Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}

