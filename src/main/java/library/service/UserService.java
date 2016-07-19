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
	//ユーザー登録
    public void insert(UserDto dto) {
    	Date date = new Date();
    	dto.setInsertTime(date);
    	dto.setUpdateTime(date);
    	userMapper.insert(dto);
    }
    
    //ユーザー検索
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
    
    //重複チェック
    public List<String> userCheck(UserDto dto) {
    	List<String> messages = new ArrayList<String>();
    	if (userMapper.userIdCheck(dto) != null) {
    		messages.add("そのユーザーIDは既に登録されています");
    	}
    	if (userMapper.mailCheck(dto) != null) {
    		messages.add("そのメールアドレスは既に登録されています");
    	}
    	if (userMapper.phoneNumberCheck(dto) != null) {
    		messages.add("その電話番号は既に登録されています");
    	}
    	return messages;
    }
}
