package library.controller;

import java.util.ArrayList;
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

import library.dto.BookDto;
import library.dto.LibraryDto;
import library.dto.MypageRentalDto;
import library.dto.RentalDto;
import library.dto.UserDto;
import library.form.RentalForm;
import library.form.UserForm;
import library.service.BookService;
import library.service.UserService;

@Controller
@SessionAttributes("updateUser")
public class UserInformController {
	
    @Autowired
    private UserService userService;
    
    @Autowired
    private BookService bookService;  
    
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
        List<LibraryDto> library = bookService.library();
        List<String> messages = new ArrayList<String>();
        model.addAttribute("Library", library);
    	if (dto.getUserId() == null) {
    		return "userUpdate";
    	}
    	model.addAttribute("userForm", userForm);
    	//ユーザーが見つからなかったとき
    	if(updateUser == null) {
    		messages.add("ユーザーが見つかりませんでした");
    		model.addAttribute("messages", messages);
    		return "userSearch";
    	}
    	
    	model.addAttribute("updateUser", updateUser);

        return "userUpdate";
    }
	 
    @RequestMapping(value = "/userUpdate", method = RequestMethod.POST)
    public String userUpdate(@Valid @ModelAttribute UserForm form, BindingResult result, Model model) {
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
//	    	if (messages.size() != 0) {
	    		userService.update(dto);
//	    	}
    		model.addAttribute("message", messages);
    		return "home";
    	}
    }
	//貸出
    @RequestMapping(value = "/lendBook", method = RequestMethod.GET)
    public String lendBook(Model model) {
    	RentalForm form = new RentalForm();
    	//各図書館の名前を持ってくる
        List<LibraryDto> library = bookService.library();
        model.addAttribute("rentalForm", form);
        model.addAttribute("Library", library);
        return "lendBook";
    }
    
    @RequestMapping(value = "/lendBook", method = RequestMethod.POST)
    public String lendBook(@ModelAttribute RentalForm form, Model model) {
    	RentalDto dto = new RentalDto();
    	BeanUtils.copyProperties(form, dto);
    	List<String> messages = new ArrayList<String>();
    	//更新していない
		if (userService.updateConfirm(dto)) {
	    	UserDto userDto = new UserDto();
	    	userDto.setUserId(dto.getUserId());
	    	UserDto updateUser = userService.search(userDto);
	    	model.addAttribute("updateUser", updateUser);
			return "redirect:/userUpdate";
		} 
		//延滞
		List<BookDto> delinquentBook = bookService.delinquentBook(dto);
		if (delinquentBook.size() != 0) {
			model.addAttribute("RentalBook", delinquentBook);
			return "delinquentUser";	
		} 
		//８冊以上借りている
		List<MypageRentalDto> rentalBook = bookService.rentalConfirm(dto);
		if (rentalBook.size() >= 8) {
	        List<LibraryDto> library = bookService.library();
	        messages.add("既に8冊借りています");
	        model.addAttribute("rentalForm", form);
	        model.addAttribute("Library", library);
	        model.addAttribute("messages", messages);
	        return "lendBook";
		}
		
    	messages = bookService.rental(dto);
    	model.addAttribute("bookForm", form);
        model.addAttribute("messages", messages);
        return "redirect:/lendBook";
	}
//    @RequestMapping(value = "/delinquentUser", method = RequestMethod.GET)
//    public String delinquentUser(Model model) {
//    	return "delinquentUser";
//    }
}
