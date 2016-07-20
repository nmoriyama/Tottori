package library.mapper;

import java.util.List;

import library.dto.BlackListDto;
import library.dto.RentalDto;
import library.dto.UserDto;

public interface UserMapper {
	void insert(UserDto dto);
	UserDto search(UserDto dto);
	void update(UserDto dto);
	List<BlackListDto> blackList();
	List<UserDto> userIdCheck(UserDto dto);
	List<UserDto> mailCheck(UserDto dto);
	List<UserDto> phoneNumberCheck(UserDto dto);
	UserDto updateConfirm(RentalDto dto);
}
