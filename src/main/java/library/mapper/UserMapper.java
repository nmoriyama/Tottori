package library.mapper;

import java.util.List;

import library.dto.BlackListDto;
import library.dto.UserDto;

public interface UserMapper {
	void insert(UserDto dto);
	UserDto search(UserDto dto);
	void update(UserDto dto);
	List<BlackListDto> blackList();
}
