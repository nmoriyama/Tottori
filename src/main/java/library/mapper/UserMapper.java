package library.mapper;

import library.dto.UserDto;

public interface UserMapper {
	void insert(UserDto dto);
	UserDto search(UserDto dto);
	void update(UserDto dto);
}
