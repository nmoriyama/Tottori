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

import library.dto.BookDto;
import library.dto.LibraryDto;
import library.dto.RentalDto;
import library.form.BookForm;
import library.form.RentalForm;
import library.service.BookService;
import library.service.UserService;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    
    @Autowired
    private UserService userService;
    //図書登録 重複確認　既に登録されています
    @RequestMapping(value = "/bookRegister", method = RequestMethod.GET)
    public String bookInsert(Model model) {
        BookForm form = new BookForm();
        //各図書館の名前を持ってくる
        List<LibraryDto> library = bookService.library();
        model.addAttribute("bookForm", form);
        model.addAttribute("Library", library);
        return "bookRegister";
    }
    
    @RequestMapping(value = "/bookRegister", method = RequestMethod.POST)
    public String bookInsert(@Valid @ModelAttribute BookForm form, BindingResult result, Model model) {
        List<LibraryDto> library = bookService.library();
        BookForm bookForm = new BookForm();
        model.addAttribute("Library", library);
        model.addAttribute("bookForm", form);
    	if (result.hasErrors()) {
    		
            return "bookRegister";
    	} else {
    		BookDto dto = new BookDto();
    		BeanUtils.copyProperties(form, dto);
    		List<String> messages = bookService.bookCheck(dto);
    		if (messages.size() == 0) {
    			bookService.insert(dto);
    			model.addAttribute("bookForm", bookForm);
    		}
    		
    		model.addAttribute("messages", messages);
    		return "bookRegister";
    	}
    }
    
    
    
    //返却
    @RequestMapping(value = "/returnBook", method = RequestMethod.GET)
    public String returnBook(Model model) {
    	RentalForm form = new RentalForm();//rentalテーブル以外
        List<LibraryDto> library = bookService.library();
        model.addAttribute("rentalForm", form);
        model.addAttribute("Library", library);
        return "returnBook";
    }
    
    @RequestMapping(value = "/returnBook", method = RequestMethod.POST)
    public String returnBook(@ModelAttribute RentalForm form, Model model) {
    	RentalDto dto = new RentalDto();
    	BeanUtils.copyProperties(form, dto);
    	List<String> messages = bookService.returnBook(dto);
        model.addAttribute("messages", messages);
        return "redirect:/returnBook";
    }
}
