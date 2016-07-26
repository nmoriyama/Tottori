package library.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import library.dto.LibraryDto;
import library.dto.UserDto;
import library.form.UserForm;
import library.service.BookService;
import library.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private BookService bookService;  

    //ホーム
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) {
        return "home";
    }
    
    //ユーザー登録
    @RequestMapping(value = "/userRegister", method = RequestMethod.GET)
    public String userInsert(Model model) {
		UserForm form = new UserForm();
		//各図書館の名前を持ってくる
		List<LibraryDto> library = bookService.library();
		model.addAttribute("userForm", form);
		model.addAttribute("Library", library);
        return "userRegister";
    }
    
    @RequestMapping(value = "/userRegister", method = RequestMethod.POST)
    public String userInsert(@Valid @ModelAttribute UserForm form, BindingResult result, Model model) {
		List<LibraryDto> library = bookService.library();
		model.addAttribute("Library", library);
    	if (result.hasErrors()) {
    		form.getUserId();

    		model.addAttribute("insertUser", form);
    		 return "userRegister";
    	} else {
	    	UserDto dto = new UserDto();
	    	UserForm userForm = new UserForm();
	    	BeanUtils.copyProperties(form, dto);
	    	List<String> messages = userService.userCheck(dto);
	    	//重複チェック
	    	if (messages.size() == 0) {
	    		userService.insert(dto);
	    	}
	    	model.addAttribute("userForm", userForm);
	        model.addAttribute("messages", messages);
	    	return "userRegister";
    	}
    }

    //ユーザー管理
    @RequestMapping(value = "/userManagement", method = RequestMethod.GET)
    public String userManagement(Model model) {
    	UserForm userForm = new UserForm();
        List<UserDto> users = userService.userManagement();
        model.addAttribute("userForm", userForm);
        model.addAttribute("Users", users);
        return "userManagement";
    }
    
    @RequestMapping(value = "/userManagement", method = RequestMethod.POST)
    public String userManagement(@ModelAttribute UserForm form, Model model) {
    	UserDto dto = new UserDto();
    	BeanUtils.copyProperties(form, dto);
    	userService.changeDate(dto);
    	
    	return "redirect:/userManagement";
    }
  
}
