package library.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import library.dto.LibraryDto;
import library.dto.UserDto;
import library.form.UserForm;
import library.service.BookService;
import library.service.UserService;

@Controller
@SessionAttributes("UpdateUser")
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private BookService bookService;  
    
    //ホーム
    @RequestMapping(value = "/manageHome", method = RequestMethod.GET)
    public String home(Model model) {
        return "manageHome";
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
    	if (result.hasErrors()) {
    		List<LibraryDto> library = bookService.library();
    		model.addAttribute("Library", library);
    		model.addAttribute("userForm", form);
    		 return "userRegister";
    	} else {
	    	UserDto dto = new UserDto();
	    	BeanUtils.copyProperties(form, dto);
	    	List<String> messages = userService.insert(dto);
	    	model.addAttribute("userForm", form);
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
    
    
    @RequestMapping(value = "/userSearch/{id}", method = RequestMethod.GET)
    public String userSearch(@PathVariable("id") int id, Model model) {
    	UserDto dto = new UserDto();
    	dto.setUserId(id);
    	//BeanUtils.copyProperties(form, dto);
    	UserDto UpdateUser = userService.search(dto);
    	model.addAttribute("UpdateUser", UpdateUser);
    	UserForm form = new UserForm();
        model.addAttribute("userForm", form);
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
            model.addAttribute("UpdateUser", form);
            return "userUpdate";
    	} else {
    		UserDto dto = new UserDto();
    		BeanUtils.copyProperties(form, dto);
    		userService.update(dto);
    		//model.addAttribute("message", "ユーザー更新");
    		return "home";
    	}
    }
}
