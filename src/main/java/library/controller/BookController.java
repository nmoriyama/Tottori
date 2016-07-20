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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import library.dto.BlackListDto;
import library.dto.BookDto;
import library.dto.LibraryDto;
import library.dto.MypageRentalDto;
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
    public String lendBook(@ModelAttribute RentalForm form, Model model, RedirectAttributes attrs) {
    	RentalDto dto = new RentalDto();
    	BeanUtils.copyProperties(form, dto);
    	List<String> messages = new ArrayList<String>();
    	//更新していない
//		if (userService.updateConfirm(dto)) {
//	        attrs.addFlashAttribute("form", dto);
//			return "redirect:/userUpdate";
//		} 
//		//延滞
    	List<MypageRentalDto> rentalBook = bookService.rentalConfirm(dto);
//		if () {
//			model.addAttribute("RentalBook", rentalBook);
//			return "delinquentUser";	
//		} 
		//８冊以上借りている
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
    
    //ブラックリスト
    @RequestMapping(value = "/blackList", method = RequestMethod.GET)
    public String blackList(Model model) {
    	List<BlackListDto> blackList = userService.blackList();
        model.addAttribute("BlackList", blackList);
        return "blackList";
    }
}
