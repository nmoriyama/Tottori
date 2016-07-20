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
import org.springframework.web.bind.annotation.SessionAttributes;

import library.dto.LibraryDto;
import library.dto.UserDto;
import library.form.UserForm;
import library.service.BookService;
import library.service.UserService;

@Controller
@SessionAttributes("updateUser")
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
    //ユーザー更新(検索)
    @RequestMapping(value = "/userSearch", method = RequestMethod.GET)
    public String userSearch(Model model) {
    	
        UserForm form = new UserForm();
        model.addAttribute("userForm", form);
        return "userSearch";
    }
    
    @RequestMapping(value = "/userUpdate", method = RequestMethod.GET)
    public String userSearch(@ModelAttribute UserForm form, Model model) {
    	UserDto dto = new UserDto();
    	UserForm userForm = new UserForm();
    	BeanUtils.copyProperties(form, dto);
    	UserDto updateUser = userService.search(dto);
    	model.addAttribute("userForm", userForm);
    	if(updateUser == null) {
    		return "redirect:/userSearch";
    	}
    	model.addAttribute("updateUser", updateUser);
        
        List<LibraryDto> library = bookService.library();
        model.addAttribute("Library", library);
        return "userUpdate";
    }
    
    
 //ユーザー更新(更新)
  /*  @RequestMapping(value = "/userUpdate", method = RequestMethod.GET)
    public String userUpdate(Model model) {
    	UserForm form = new UserForm();
        model.addAttribute("userForm", form);
        List<LibraryDto> library = bookService.library();
        model.addAttribute("Library", library);
        return "userUpdate";
    }*/
    
    @RequestMapping(value = "/userUpdate", method = RequestMethod.POST)
    public String userUpdate(@Valid @ModelAttribute UserForm form,  BindingResult result, Model model) {
    	if (result.hasErrors()) {
            List<LibraryDto> library = bookService.library();
            model.addAttribute("Library", library);
            model.addAttribute("updateUser", form);
            return "userUpdate";
    	} else {
    		UserDto dto = new UserDto();
    		BeanUtils.copyProperties(form, dto);
	    	List<String> messages = userService.userCheck(dto);
	    	//重複チェック
	    	if (messages.size() != 0) {
	    		userService.update(dto);
	    	}
    		
    		model.addAttribute("message", messages);
    		return "home";
    	}
    }
}
