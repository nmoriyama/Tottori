package library.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.dto.BlackListDto;
import library.dto.RentalDto;
import library.dto.UserDto;
import library.mapper.UserMapper;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
	//ユーザー登録
    public void insert(UserDto dto) {
    	Date date = new Date();
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(date);
    	cal.add(Calendar.YEAR,1);
    	Date afterTime = new java.sql.Date(cal.getTimeInMillis());
    	dto.setUpdateTime(afterTime);
    	userMapper.insert(dto);
    }
    
    //ユーザー検索
    public UserDto search(UserDto dto) {
    	
    	UserDto user = userMapper.search(dto);

    	return user;
    }
    //ユーザー更新
    public void update(UserDto dto) {
    	Date date = new Date();
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(date);
    	cal.add(Calendar.YEAR,1);
    	Date afterTime = new java.sql.Date(cal.getTimeInMillis());
    	dto.setUpdateTime(afterTime);
        userMapper.update(dto);
    }
    
    public List<BlackListDto> blackList() {
    	List<BlackListDto> blackList = userMapper.blackList();
    	return blackList;
    }
    
    //重複チェック
    public List<String> userCheck(UserDto dto) {
    	List<String> messages = new ArrayList<String>();
    	List<UserDto> userIdCheck = userMapper.userIdCheck(dto);
    	List<UserDto> mailCheck = userMapper.mailCheck(dto);
    	List<UserDto> phoneNumberCheck = userMapper.phoneNumberCheck(dto);
    	if (userIdCheck.size() > 0) {
    		messages.add("そのユーザーIDは既に登録されています");
    	}
    	if (mailCheck.size() > 0) {
    		messages.add("そのメールアドレスは既に登録されています");
    	}
    	if (phoneNumberCheck.size() > 0) {
    		messages.add("その電話番号は既に登録されています");
    	}
    	return messages;
    }
    
    //ユーザーが更新しているか
    public boolean updateConfirm(RentalDto dto) {
    	List<UserDto> user = userMapper.updateConfirm(dto);
    	if (user.size() == 0){
    		return false;
    	}
    	return true;
    }

    public List<UserDto> userManagement() {
    	List<UserDto> users = userMapper.userManagement();
    	return users;
    }
    
    public void changeDate(UserDto dto) {
    	userMapper.changeDate(dto);
    }
}
