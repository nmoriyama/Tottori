package library.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.dto.BlackListDto;
import library.dto.UserDto;
import library.mapper.UserMapper;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<String> insert(UserDto dto) {
    	List<String> messages = new ArrayList<String>();
    	Date date = new Date();
    	dto.setInsertTime(date);
    	dto.setUpdateTime(date);
    	userMapper.insert(dto);
   
        return messages;
    }
    
    public List<String> userCheck(UserDto dto) {
    	List<String> messages = new ArrayList<String>();
    	//if () 
        return messages;
    }
    
    public UserDto search(UserDto dto) {

    	UserDto user = userMapper.search(dto);
    	return user;
    }
    
    public void update(UserDto dto) {
        userMapper.update(dto);
    }
    
    public List<BlackListDto> blackList() {
    	List<BlackListDto> blackList = userMapper.blackList();
    	return blackList;
    }
}
