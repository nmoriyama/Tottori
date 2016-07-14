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

import library.dto.UserDto;
import library.form.UserForm;
import library.service.UserService;


@Controller
public class UserController {

    @Autowired
    private UserService userService;
    
    
    //ユーザー登録
    @RequestMapping(value = "/userRegister", method = RequestMethod.GET)
    public String userInsert(Model model) {

			UserForm form = new UserForm();
			model.addAttribute("userForm", form);
    	//model.addAttribute("message", "ユーザー登録");

        return "userRegister";
    }
    
    @RequestMapping(value = "/userRegister", method = RequestMethod.POST)
    public String userInsert(@Valid @ModelAttribute UserForm form,  BindingResult result, Model model) {
    	if (result.hasErrors()) {
    		model.addAttribute("userForm", form);
    		 return "userRegister";
    	} else {
    	UserDto dto = new UserDto();
    	BeanUtils.copyProperties(form, dto);
    	List<String> messages = userService.insert(dto);
    	model.addAttribute("userForm", form);
        //model.addAttribute("message", "ユーザー登録");
    	return "userRegister";
    	}
    }
    //ユーザー更新(検索)
    @RequestMapping(value = "/userSearch", method = RequestMethod.GET)
    public String userSearch(Model model) {

        UserForm form = new UserForm();
        model.addAttribute("userForm", form);
        //model.addAttribute("message", "ユーザー更新");
        return "userSearch";
    }
    
    
    @RequestMapping(value = "/userSearch", method = RequestMethod.POST)
    public String userSearch(@ModelAttribute UserForm form, Model model) {
    	UserDto dto = new UserDto();
    	BeanUtils.copyProperties(form, dto);
    	UserDto UpdateUser = userService.search(dto);

        model.addAttribute("userForm", UpdateUser);
        //model.addAttribute("message", "ユーザー更新");
        return "userUpdate";
    }
    
 //ユーザー更新(更新)
    @RequestMapping(value = "/userUpdate", method = RequestMethod.POST)
    public String userUpdate(@ModelAttribute UserForm form, Model model) {
    	UserDto dto = new UserDto();
    	BeanUtils.copyProperties(form, dto);
    	userService.update(dto);
        //model.addAttribute("message", "ユーザー更新");
        return "home";
    }
}
